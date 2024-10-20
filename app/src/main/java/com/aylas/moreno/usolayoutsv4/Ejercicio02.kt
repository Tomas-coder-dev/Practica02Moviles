package com.aylas.moreno.usolayoutsv4

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.aylas.moreno.usolayoutsv4.databinding.ActivityEjercicio02Binding

class Ejercicio02 : AppCompatActivity() {

    private lateinit var binding: ActivityEjercicio02Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Infla el layout
        binding = ActivityEjercicio02Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configuración del botón Registrar
        binding.btnRegistrar.setOnClickListener {
            val nombreCliente = binding.etNombreCliente.text.toString()
            val numeroCliente = binding.etNumeroCliente.text.toString()
            val productos = binding.etProductos.text.toString()
            val ciudad = binding.etCiudad.text.toString()
            val direccion = binding.etDireccion.text.toString()

            if (nombreCliente.isNotEmpty() && numeroCliente.isNotEmpty() && productos.isNotEmpty() && ciudad.isNotEmpty() && direccion.isNotEmpty()) {
                // Redirigir a la segunda pantalla con la información
                val intent = Intent(this, DetallesPedidoActivity::class.java).apply {
                    putExtra("nombreCliente", nombreCliente)
                    putExtra("numeroCliente", numeroCliente)
                    putExtra("productos", productos)
                    putExtra("ciudad", ciudad)
                    putExtra("direccion", direccion)
                }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
