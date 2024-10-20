package com.aylas.moreno.usolayoutsv4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aylas.moreno.usolayoutsv4.ui.theme.LaboratorioCalificado02Theme

class Ejercicio01 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LaboratorioCalificado02Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Content(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Content(modifier: Modifier = Modifier) {
    var isVisible by remember { mutableStateOf(true) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Examen Calificado 02")

        if (isVisible) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .height(320.dp)
                    .background(Color(0xFF4CAF50), shape = RoundedCornerShape(20.dp))
            )
        }

        Spacer(modifier = Modifier.height(80.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp)
                .height(80.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(end = 8.dp)
                    .height(80.dp),
                onClick = { isVisible = true },
                shape = RoundedCornerShape(50)
            ) {
                Text(text = "Mostrar", color = Color.Black)
            }
            Button(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(start = 8.dp)
                    .height(80.dp),
                onClick = { isVisible = false },
                shape = RoundedCornerShape(50)
            ) {
                Text(text = "Ocultar", color = Color.Black)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContentPreview() {
    LaboratorioCalificado02Theme {
        Content()
    }
}
