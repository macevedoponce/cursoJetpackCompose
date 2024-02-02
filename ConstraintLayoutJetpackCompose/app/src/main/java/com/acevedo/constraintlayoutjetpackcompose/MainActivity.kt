package com.acevedo.constraintlayoutjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.PlayCircleOutline
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import coil.transform.RoundedCornersTransformation
import com.acevedo.constraintlayoutjetpackcompose.ui.theme.ConstraintLayoutJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConstraintLayoutJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BoxConstraint()
                    //Example()
                    //ExampleText()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExampleText() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Hola mundo supremo, lorem ipsum. lorem lorem lorem ipsum lorem.",
            color = Color.Red,
            fontSize = 50.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily.Monospace,
            letterSpacing = 5.sp,
            textDecoration = TextDecoration.LineThrough,
            textAlign = TextAlign.Left,
            lineHeight = 2.em,
            maxLines = 2,
            softWrap = true,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.labelMedium.copy(
                shadow = Shadow(
                    offset = Offset(10f, 10f),
                    blurRadius = 5f,
                    color = Color.Blue.copy(alpha = 0.5f)
                )
            )

        )
    }
}

@Preview(showBackground = true, widthDp = 200, heightDp = 100)
@Composable
fun Example() {
    Column {

        Box(
            modifier = Modifier
                .height(500.dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                //painter = painterResource(id = R.drawable.paisaje),//local
                painter = rememberImagePainter(
                    data = "https://plus.unsplash.com/premium_photo-1706625694769-4f9df2cb4c26?q=80&w=1974&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                    builder = {
                        //transformations(CircleCropTransformation()) -> redondear imagenes, ideal para perfiles
                        //crossfade(true)
                        //transformations(BlurTransformation(LocalContext.current)) -> blur en la imagen
                    }
                ),
                contentDescription = "Glencoe, Ballachulish, UK",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Icon(imageVector = Icons.Default.PlayCircleOutline,
                contentDescription = null,
                modifier = Modifier.size(92.dp),
                tint = Color.White
            )
        }

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.secondary)
                .padding(16.dp)
        ) {
            Text(
                text = "Glencoe, Ballachulish, UK",
                fontWeight = FontWeight.Bold,
                color = Color.Green,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun BoxConstraint() {
    LazyColumn(
        Modifier
            .fillMaxHeight()
            .background(color = Color.Cyan)
    ) {
        item {
            ConstraintLayout(Modifier.fillParentMaxSize()) {
                val (boxRed, boxBlue, boxGreen, boxMagenta, boxYellow) = createRefs()
                val topGuide = createGuidelineFromTop(0.2f)
                val startGuide = createGuidelineFromStart(0.2f)

                Box(
                    Modifier
                        .size(100.dp)
                        .background(Color.Red)
                        .constrainAs(boxRed) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                            end.linkTo(boxBlue.start)
                        })

                Box(
                    Modifier
                        .size(100.dp)
                        .background(Color.Blue)
                        .constrainAs(boxBlue) {
                            top.linkTo(parent.top)
                            start.linkTo(boxRed.end)
                            end.linkTo(parent.end)
                        })

                createHorizontalChain(boxRed, boxBlue, chainStyle = ChainStyle.SpreadInside)


                Box(
                    Modifier
                        .size(100.dp)
                        .background(Color.Green)
                        .constrainAs(boxGreen) {
                            //porcentajes en constraint
                            top.linkTo(topGuide)
                            start.linkTo(startGuide)
                        })

                Box(
                    Modifier
                        .size(100.dp)
                        .background(Color.Magenta)
                        .constrainAs(boxMagenta) {
                            top.linkTo(boxYellow.bottom)
                            bottom.linkTo(parent.bottom)
                            end.linkTo(parent.end, margin = 16.dp)
                        })

                Box(
                    Modifier
                        .size(100.dp)
                        .background(Color.Yellow)
                        .constrainAs(boxYellow) {
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        })
            }
        }
    }

}
