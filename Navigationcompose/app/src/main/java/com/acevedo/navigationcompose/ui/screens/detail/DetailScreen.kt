package com.acevedo.navigationcompose.ui.screens.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun DetailScreen(mediaId: String, navController: NavHostController) {
    Box(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Text(
                text = "Detail Screen",
                fontSize = 16.sp,
                color = Color.White,
                style = MaterialTheme.typography.labelMedium
            )
            Text(
                text = mediaId,
                fontSize = 15.sp,
                color = Color.Green,
                fontWeight = FontWeight.ExtraBold,
                textDecoration = TextDecoration.Underline,
                letterSpacing = 5.sp,
                overflow = TextOverflow.Ellipsis,
                softWrap = false,
                textAlign = TextAlign.Justify,
                style = MaterialTheme.typography.labelMedium
            )
            Button(onClick = { navController.navigate("main") }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                    tint = Color.White
                )
                Text(text = "Regresar", color = Color.White)

            }
        }


    }
}