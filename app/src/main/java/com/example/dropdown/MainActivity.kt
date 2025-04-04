package com.example.dropdown

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.dropdown.items.PantallaOpciones
import com.example.dropdown.ui.theme.DropDownTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DropDownTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { rellenoInterno ->
                    PantallaOpciones(
                        modificador = Modifier.padding(rellenoInterno)
                    )
                }
            }
        }
    }
}