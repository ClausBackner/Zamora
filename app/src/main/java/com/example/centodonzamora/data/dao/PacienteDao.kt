package com.example.centodonzamora.data.dao

import com.example.centodonzamora.data.model.PacienteModel
import java.sql.Date

object PacienteDao {
    fun listar(dato: String):List<PacienteModel>{
        var lista = mutableListOf<PacienteModel>()


        val ps = MySqlConexion.getConexion()?.prepareStatement(
            "SELECT nombre, apellido, dni, edad, telefono, direccion, servicio, fecha, descripcion FROM paciente WHERE nombre Like concat('%','?','%');"
        )
        ps?.setString(1, dato)

        val rs = ps?.executeQuery()

        while (rs?.next() == true){
            lista.add(
                PacienteModel(
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("dni"),
                    rs.getInt("edad"),
                    rs.getInt("telefono"),
                    rs.getString("direccion"),
                    rs.getString("servicio"),
                    rs.getDate("fecha"),
                    rs.getString("descripcion")
                )
            )
        }
        rs?.close()
        rs?.close()

        return lista
    }

    private fun registrar(paciente: PacienteModel){
        val ps = MySqlConexion.getConexion()?.prepareStatement(
            "INSET INTO paciente(nombre, apellido, dni, edad, telefono, direccion, servicio, fecha, descripcion) VALUES (? ,?, ?, ?, ?, ?, ?, ?, ?);"
        )

        ps?.setString(1, paciente.nombre)
        ps?.setString(2, paciente.apellido)
        ps?.setString(3, paciente.dni)
        ps?.setInt(4, paciente.edad)
        ps?.setInt(5, paciente.telefono)
        ps?.setString(6, paciente.direccion)
        ps?.setDate(7, paciente.fecha as Date?)
        ps?.setString(8, paciente.descripcion)

        ps?.executeUpdate()

        ps?.close()
    }
    private fun actualizar(paciente: PacienteModel){
        val ps = MySqlConexion.getConexion()?.prepareStatement(
            "UPDATE paciente SET nombre=?, apellido=?, dni=?, edad=?, telefono=?, direccion=?, servicio=?, fecha=?, descripcion=?; WHERE nombre="
        )

        ps?.setString(1, paciente.nombre)
        ps?.setString(2, paciente.apellido)
        ps?.setString(3, paciente.dni)
        ps?.setInt(4, paciente.edad)
        ps?.setInt(5, paciente.telefono)
        ps?.setString(6, paciente.direccion)
        ps?.setDate(7, paciente.fecha as Date?)
        ps?.setString(8, paciente.descripcion)

        ps?.executeUpdate()

        ps?.close()
    }
    fun eliminar(paciente: PacienteModel){
        val ps = MySqlConexion.getConexion()?.prepareStatement(
            " DELETE FROM paciente WHERE nombre=?;"
        )

        ps?.setString(1, paciente.nombre)


        ps?.executeUpdate()

        ps?.close()
    }
    fun grabar(paciente: PacienteModel){
        if (paciente.nombre==""){
            registrar(paciente)
        }else{
            actualizar(paciente)
        }
    }
}