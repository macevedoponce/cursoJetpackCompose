package com.acevedo.navigationcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.acevedo.navigationcompose.ui.screens.detail.DetailScreen
import com.acevedo.navigationcompose.ui.screens.main.MainScreen
import com.acevedo.navigationcompose.ui.theme.NavigationcomposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationcomposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "main") {
                        composable("main") {
                            MainScreen(navController)
                        }
                        composable( //enviando datos por argumento entre composables
                            route = "detail/{mediaId}",
                            arguments = listOf(
                                navArgument("mediaId") {})
                        ) {backStackentry ->
                            val id = backStackentry.arguments?.getString("mediaId")
                            requireNotNull(id) { "No puede ser nulo por que el detalle siempre necesia un id" }
                            DetailScreen(id,navController)
                        }

                    }
                }
            }
        }
    }
}

//nos quedamos en el vid #11 https://youtu.be/iZiXpWRIl3U?list=PLrn69hTK5FBwu7VmWBg76v23atiMqz_pY