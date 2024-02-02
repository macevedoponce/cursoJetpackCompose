package com.acevedo.searchbarcompose

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.acevedo.searchbarcompose.ui.theme.SearchBarComposeTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SearchBarComposeTheme {
                val ctx = LocalContext.current
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = MaterialTheme.colorScheme.primaryContainer
                ) {
                    ExampleSearch(ctx)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExampleSearch(ctx: Context) {
    var query by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }



    SearchBar(
        query = query,
        onQueryChange = { query = it },
        onSearch = {
            Toast.makeText(ctx, query, Toast.LENGTH_SHORT).show()
            active = false
        },
        active = active,
        onActiveChange = { active = it },
        modifier = Modifier.wrapContentHeight()
    ) {
        if (query.isNotEmpty()) {
            val filteresCountryes = countries.filter { it.second.contains(query, true) }
            LazyColumn{
                items(filteresCountryes) {(name, flag) ->
                    Text(
                        text = "$flag $name",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Light,
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                            .clickable {
                                Toast
                                    .makeText(ctx, name, Toast.LENGTH_SHORT)
                                    .show()
                                active = false
                            })
                }
            }
        }
    }
    }

val countries = listOf(
    "Estados Unidos" to "US",
    "Canadá" to "CA",
    "Reino Unido" to "UK",
    "Australia" to "AU",
    "Alemania" to "DE",
    "Francia" to "FR",
    "Italia" to "IT",
    "Japón" to "JP",
    "Corea del Sur" to "KR",
    "India" to "IN",
    "China" to "CN",
    "Rusia" to "RU",
    "Brasil" to "BR",
    "México" to "MX",
    "Argentina" to "AR",
    "España" to "ES",
    "Sudáfrica" to "ZA",
    "Nigeria" to "NG",
    "Egipto" to "EG",
    "Kenia" to "KE",
    "Arabia Saudita" to "SA",
    "Emiratos Árabes Unidos" to "AE",
    "Turquía" to "TR",
    "Irán" to "IR",
    "Pakistán" to "PK",
    "Indonesia" to "ID",
    "Filipinas" to "PH",
    "Vietnam" to "VN",
    "Tailandia" to "TH",
    "Malasia" to "MY",
    "Singapur" to "SG",
    "Israel" to "IL",
    "Grecia" to "GR",
    "Portugal" to "PT",
    "Polonia" to "PL",
    "Ucrania" to "UA",
    "Suecia" to "SE",
    "Noruega" to "NO",
    "Finlandia" to "FI",
    "Dinamarca" to "DK",
    "Países Bajos" to "NL",
    "Bélgica" to "BE",
    "Suiza" to "CH",
    "Austria" to "AT",
    "Hungría" to "HU",
    "República Checa" to "CZ",
    "Rumania" to "RO",
    "Bulgaria" to "BG",
    "Estonia" to "EE",
    "Estados Unidos" to "US",
    "Canadá" to "CA",
    "Reino Unido" to "UK",
    "Australia" to "AU",
    "Alemania" to "DE",
    "Francia" to "FR",
    "Italia" to "IT",
    "Japón" to "JP",
    "Corea del Sur" to "KR",
    "India" to "IN",
    "China" to "CN",
    "Rusia" to "RU",
    "Brasil" to "BR",
    "México" to "MX",
    "Argentina" to "AR",
    "España" to "ES",
    "Sudáfrica" to "ZA",
    "Nigeria" to "NG",
    "Egipto" to "EG",
    "Kenia" to "KE",
    "Arabia Saudita" to "SA",
    "Emiratos Árabes Unidos" to "AE",
    "Turquía" to "TR",
    "Irán" to "IR",
    "Pakistán" to "PK",
    "Indonesia" to "ID",
    "Filipinas" to "PH",
    "Vietnam" to "VN",
    "Tailandia" to "TH",
    "Malasia" to "MY",
    "Singapur" to "SG",
    "Israel" to "IL",
    "Grecia" to "GR",
    "Portugal" to "PT",
    "Polonia" to "PL",
    "Ucrania" to "UA",
    "Suecia" to "SE",
    "Noruega" to "NO",
    "Finlandia" to "FI",
    "Dinamarca" to "DK",
    "Países Bajos" to "NL",
    "Bélgica" to "BE",
    "Suiza" to "CH",
    "Austria" to "AT",
    "Hungría" to "HU",
    "República Checa" to "CZ",
    "Rumania" to "RO",
    "Bulgaria" to "BG",
    "Estonia" to "EE"
)
