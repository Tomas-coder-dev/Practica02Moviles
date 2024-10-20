package com.aylas.moreno.usolayoutsv4

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aylas.moreno.usolayoutsv4.databinding.ActivityDetallesPedidoBinding

class DetallesPedidoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetallesPedidoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetallesPedidoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtener los datos del intent
        val nombreCliente = intent.getStringExtra("nombreCliente")
        val numeroCliente = intent.getStringExtra("numeroCliente")
        val productos = intent.getStringExtra("productos")
        val ciudad = intent.getStringExtra("ciudad")
        val direccion = intent.getStringExtra("direccion")

        // Mostrar la información en los TextViews
        binding.tvNombreCliente.text = nombreCliente
        binding.tvNumeroCliente.text = numeroCliente
        binding.tvProductos.text = productos
        binding.tvDireccion.text = direccion

        // Botón de llamada
        binding.btnLlamar.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:$numeroCliente")
            }
            startActivity(intent)
        }

        // Botón de WhatsApp
        binding.btnWhatsapp.setOnClickListener {
            val mensaje = "Hola $nombreCliente, tus productos: $productos están en camino a la dirección: $direccion."
            val uri = Uri.parse("smsto:$numeroCliente")
            val intent = Intent(Intent.ACTION_SENDTO, uri).apply {
                setPackage("com.whatsapp")
                putExtra(Intent.EXTRA_TEXT, mensaje)
            }
            startActivity(intent)
        }

        // Botón de Google Maps
        binding.btnMaps.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("geo:0,0?q=$direccion, $ciudad")
            }
            startActivity(intent)
        }
    }
}
