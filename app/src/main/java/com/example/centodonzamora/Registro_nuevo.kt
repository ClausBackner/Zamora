package com.example.centodonzamora

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.zamora.databinding.FragmentRegistroNuevoBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Registro_nuevo.newInstance] factory method to
 * create an instance of this fragment.
 */
class Registro_nuevo : Fragment() {

    private var _binding: FragmentRegistroNuevoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegistroNuevoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Servicios disponibles
        val servicios = listOf(
            "Restauraciones", "Profilaxis", "Rayos X", "Blanqueamiento",
            "Ortodoncia", "Extracciones", "Cirugías", "Endodoncia", "Prótesis"
        )

        // Horarios disponibles
        val horas = listOf("2:00 PM", "3:00 PM", "4:00 PM", "5:00 PM")

        // Configurar Spinner para servicios
        val adapterServicios = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            servicios
        )
        adapterServicios.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerServicio.adapter = adapterServicios

        // Configurar Spinner para horas
        val adapterHoras = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            horas
        )
        adapterHoras.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerHora.adapter = adapterHoras

        // Acción del botón Registrar
        binding.btnRegistrar.setOnClickListener {
            val nombre = binding.etNombre.text.toString()
            val apellidos = binding.etApellidos.text.toString()
            val dni = binding.etDNI.text.toString()
            val edad = binding.etEdad.text.toString()
            val telefono = binding.etTelefono.text.toString()
            val direccion = binding.etDireccion.text.toString()
            val servicio = binding.spinnerServicio.selectedItem.toString()
            val hora = binding.spinnerHora.selectedItem.toString()
            val fecha = "${binding.datePicker.dayOfMonth}/${binding.datePicker.month + 1}/${binding.datePicker.year}"
            val descripcion = binding.etDescripcion.text.toString()

            // Validar datos
            if (dni.length != 8) {
                Toast.makeText(requireContext(), "El DNI debe tener 8 dígitos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Procesar los datos (puedes almacenarlos o enviarlos a un servidor)
            Toast.makeText(
                requireContext(),
                "Registro exitoso:\nNombre: $nombre\nServicio: $servicio\nFecha: $fecha\nHora: $hora",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
