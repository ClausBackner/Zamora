package com.example.centodonzamora.data.model

import java.util.Date

data class PacienteModel(
    var nombre: String,
    var apellido: String,
    var dni: String,
    var edad: Int,
    var telefono: Int,
    var direccion: String,
    var servicio: String,
    var fecha: Date,
    var descripcion: String,
)
