package com.acevedo.cursojetpackcompose


import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.acevedo.cursojetpackcompose.ui.theme.CursoJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViewContainer()
        }
    }
}

@Preview
@Composable
fun ViewContainer(){
    Scaffold(
        topBar = {Toolbar()},
        content = {Content()},
        floatingActionButton = {FAB()},
        floatingActionButtonPosition = FabPosition.End
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar(){
    TopAppBar(
        title = {
            Text(
                text = "MiguelAcevedo Profile",
                color = colorResource(id = R.color.background),
            )
        },
        //backgroundColor = colorResource(id = R.color.background)
    )
}

@Composable
fun FAB(){
    val context = LocalContext.current

    FloatingActionButton(onClick = {
        Toast.makeText(context,"Bienvenido", Toast.LENGTH_SHORT).show()
    }){
        Text("X")
    }
}


@Composable
fun Content() {

    var counter by rememberSaveable { //guardar datos, hasta cuando se cambia de vista
        mutableStateOf(1)
    }

    LazyColumn( // una columna con scroll, funciona con item
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
            .padding(10.dp)
    ) {
        item{
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp),
                painter = painterResource(id = R.drawable.macevedologo),
                contentDescription = "Logo Miguel Acevedo"
            )

            Row(modifier = Modifier.padding(top = 8.dp)){
                Image(
                    painter = painterResource(id = R.drawable.ic_favorite),
                    contentDescription = "Like",
                    modifier = Modifier.clickable { counter++ }
                )
                Text(text = counter.toString(), color = Color.White, modifier = Modifier.padding(start = 4.dp))
            }

            Text(
                text = "Miguel Acevedo Ponce",
                fontSize = 32.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Android Developer",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = Color.White
            )

            Text(
                text = "+2 Años de Experiencia",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = Color.White
            )

            LazyRow(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                item{
                    Text(text = "JAVA", color = Color.Magenta)
                    Text(text = "KOTLIN", color = Color.Blue)
                    Text(text = "PHP", color = Color.Red)

                }

            }
        }

    }

}