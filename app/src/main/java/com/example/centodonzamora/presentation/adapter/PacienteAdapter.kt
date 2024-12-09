package com.example.centodonzamora.presentation.adapter

import android.view.ViewGroup
import android.view.ViewParent
import androidx.recyclerview.widget.RecyclerView
import com.example.centodonzamora.data.model.PacienteModel
import com.example.zamora.databinding.FragmentShortsBinding

class PacienteAdapter(
    private val listener: IOnClickListener
) {
    private var lista= emptyList<PacienteModel>()

    interface IOnClickListener{
        fun clickEditar(paciente:PacienteModel)
        fun clickEliminar(paciente: PacienteModel)
    }
    inner class PacienteViewHolder(private val binding: FragmentShortsBinding) : RecyclerView.ViewHolder(binding.root){
        fun enlazar(paciente: PacienteModel){
            binding.textDetalleNombre.text = paciente.nombre
            binding.textDetalleApellido.text = paciente.apellido
            binding.textDetalleDNI.text = paciente.dni
            binding.textDetalleEdad.text = paciente.edad.toString()
            binding.textDetalleTelefono.text = paciente.telefono.toString()
            binding.textDetalleDireccion.text = paciente.direccion
            binding.textDetalleServicio.text = paciente.servicio
            binding.textDetalleFecha.text = paciente.fecha.toString()
            binding.textDetalleDescripcion.text = paciente.servicio

            binding.btnEditar.setOnClickListener{listener.clickEditar(paciente)}
            binding.btnEliminar.setOnClickListener{listener.clickEliminar(paciente)}
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PacienteViewHolder{
        TODO()
    }
    override fun getItemCount(): Int{
        TODO()
    }
    override fun onBindViewHolder(holder: PacienteViewHolder, position: Int){
        TODO()
        
    }
}