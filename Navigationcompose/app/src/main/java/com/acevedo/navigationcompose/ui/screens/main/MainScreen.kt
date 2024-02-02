package com.acevedo.navigationcompose.ui.screens.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun MainScreen(navController: NavHostController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Text(
                text = "Main Screen",
                color = Color.White,
                fontSize = 30.sp,
                style = MaterialTheme.typography.bodySmall
            )
            Button(onClick = { navController.navigate("detail/${"soy el detalle enviado desde el main button"}") }) {
                Text(text = "Cambiar pantalla")
            }
        }

    }
}