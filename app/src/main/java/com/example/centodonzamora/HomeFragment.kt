package com.example.centodonzamora
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.zamora.databinding.FragmentHomeBinding
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("HomeFragment", "HomeFragment cargado")

        // Crear datos mínimos para el gráfico
        val entries = listOf(
            Entry(0f, 1f),
            Entry(1f, 2f),
            Entry(2f, 3f)
        )

        val dataSet = LineDataSet(entries, "Datos de Prueba").apply {
            color = Color.BLUE
            valueTextColor = Color.RED
            lineWidth = 2f
            circleRadius = 4f
            setCircleColor(Color.GREEN)
        }

        val lineData = LineData(dataSet)

        // Configurar el gráfico
        binding.lineChart.apply {
            data = lineData
            description = Description().apply {
                text = "Gráfico de Prueba"
                textColor = Color.BLACK
                textSize = 12f
            }
            setTouchEnabled(true)
            isDragEnabled = true
            setScaleEnabled(true)
            animateX(1000)
            invalidate()
        }

        Log.d("HomeFragment", "LineChart configurado con ${entries.size} entradas")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

