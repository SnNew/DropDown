package com.example.dropdown.items

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PantallaOpciones(modificador: Modifier = Modifier) {
    // Menús desplegables
    var mostrarMenuColores by remember { mutableStateOf(false) }
    var mostrarMenuFuentes by remember { mutableStateOf(false) }

    // Selecciones actuales
    var colorSeleccionado by remember { mutableStateOf("Seleccionar color") }
    var fuenteSeleccionada by remember { mutableStateOf("Seleccionar fuente") }

    // Input del usuario y resultado aplicado
    var textoIngresado by remember { mutableStateOf("") }
    var textoAplicado by remember { mutableStateOf("") }
    var estiloAplicado by remember { mutableStateOf(TextStyle(fontSize = 16.sp)) }

    // Listas y mapeos
    val listaColores = listOf("Azul", "Morado", "Rojo", "Café", "Naranja")
    val colorMap = mapOf(
        "Azul" to Color.Blue,
        "Morado" to Color.Magenta,
        "Rojo" to Color.Red,
        "Café" to Color(0xFF795548),
        "Naranja" to Color(0xFFFF9800)
    )

    val listaFuentes = listOf("Sans Serif", "Serif", "Monospace", "Cursive", "Default")
    val fuenteMap = mapOf(
        "Sans Serif" to FontFamily.SansSerif,
        "Serif" to FontFamily.Serif,
        "Monospace" to FontFamily.Monospace,
        "Cursive" to FontFamily.Cursive,
        "Default" to FontFamily.Default
    )


    Column(
        modifier = modificador
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text(
            text = "Personalizar Texto",
            style = MaterialTheme.typography.headlineMedium
        )

        // Menús
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box {
                Button(onClick = { mostrarMenuColores = true }) {
                    Text(colorSeleccionado)
                }
                DropdownMenu(
                    expanded = mostrarMenuColores,
                    onDismissRequest = { mostrarMenuColores = false }
                ) {
                    listaColores.forEach { color ->
                        DropdownMenuItem(
                            text = { Text(color) },
                            onClick = {
                                colorSeleccionado = color
                                mostrarMenuColores = false
                            }
                        )
                    }
                }
            }

            Box {
                Button(onClick = { mostrarMenuFuentes = true }) {
                    Text(fuenteSeleccionada)
                }
                DropdownMenu(
                    expanded = mostrarMenuFuentes,
                    onDismissRequest = { mostrarMenuFuentes = false }
                ) {
                    listaFuentes.forEach { fuente ->
                        DropdownMenuItem(
                            text = { Text(fuente) },
                            onClick = {
                                fuenteSeleccionada = fuente
                                mostrarMenuFuentes = false
                            }
                        )
                    }
                }
            }
        }

        // Campo de texto
        TextField(
            value = textoIngresado,
            onValueChange = { textoIngresado = it },
            label = { Text("Ingrese su texto") },
            modifier = Modifier.fillMaxWidth()
        )

        // Botón para aplicar estilos
        Button(
            onClick = {
                textoAplicado = textoIngresado
                estiloAplicado = TextStyle(
                    color = colorMap[colorSeleccionado] ?: Color.Black,
                    fontFamily = fuenteMap[fuenteSeleccionada] ?: FontFamily.Default,
                    fontSize = 18.sp
                )
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Aplicar cambios")
        }

        // Texto con estilo aplicado
        if (textoAplicado.isNotEmpty()) {
            Text(
                text = textoAplicado,
                style = estiloAplicado,
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth()
            )
        }
    }
}
