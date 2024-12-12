package com.example.centodonzamora

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.zamora.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    // Declaración de variables
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var fab: FloatingActionButton
    private lateinit var bottomNavigationView: BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)//cambio (R.layout.activity_main)

        // Inicialización de vistas
        drawerLayout = findViewById(R.id.drawer_layout)
        fab = findViewById(R.id.fab)
        bottomNavigationView = findViewById(R.id.bottomNavigationView)

        // Configuración de la barra de herramientas
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Configuración del ActionBarDrawerToggle
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.open_nav, R.string.close_nav
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // Configuración del BottomNavigationView
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> replaceFragment(HomeFragment())
                R.id.nav_settings -> replaceFragment(ShortsFragment())
                R.id.nav_about -> replaceFragment(SubscriptionFragment())
                R.id.nav_share -> replaceFragment(LibraryFragment())
            }
            true
        }

        // Configuración del botón flotante
        fab.setOnClickListener {
            showBottomDialog()
        }
    }




    // Método para reemplazar fragmentos
    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.frame_layout, fragment)
        transaction.commit()
    }

    // Método para mostrar un diálogo personalizado
    private fun showBottomDialog() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.bottomsheetlayout)

        // Inicialización de vistas del diálogo
        val nuevaCitaLayout = dialog.findViewById<LinearLayout>(R.id.layoutNuevaCita)
        val graficaLayout = dialog.findViewById<LinearLayout>(R.id.lineGrafica)
        val liveLayout = dialog.findViewById<LinearLayout>(R.id.layoutLive)
        val cancelButton = dialog.findViewById<ImageView>(R.id.cancelButton)


        nuevaCitaLayout.setOnClickListener {
            dialog.dismiss() // Cierra el diálogo
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_layout, Registro_nuevo())
            transaction.addToBackStack(null) // Habilita la navegación atrás
            transaction.commit()
        }



        graficaLayout?.setOnClickListener {
            dialog.dismiss()
            Toast.makeText(this, "Abrir gráfico", Toast.LENGTH_SHORT).show()
        }

        liveLayout.setOnClickListener {
            dialog.dismiss()
            Toast.makeText(this, "Go live is clicked", Toast.LENGTH_SHORT).show()
        }

        cancelButton.setOnClickListener {
            dialog.dismiss()
        }

        // Configuración del diálogo
        dialog.show()
        dialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window?.setWindowAnimations(R.style.DialogAnimation)
        dialog.window?.setGravity(Gravity.BOTTOM)
    }



}
