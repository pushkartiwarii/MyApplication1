package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.SpaceBetween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlin.math.floor
import androidx.compose.foundation.Image as Image1

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android", modifier = Modifier.padding(innerPadding)
//                    )
                    homescreen()
                    mylist()


                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hi $name!", modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}

@Composable
fun CardOne(modifier: Modifier = Modifier) {
    Column(
        Modifier
            .background(Color.White)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Welcome Jetpack compose",
            style = MaterialTheme.typography.headlineLarge,
            textAlign = TextAlign.Center
        )
        Text(text = "14th July 2024")
        Text(text = "Pushkar Tiwari")

    }
}

@Preview
@Composable
private fun CardOnePreview() {
    CardOne()
}

@Composable
fun RatingCard(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
    ) {

        Row(
            verticalAlignment = CenterVertically, modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                imageVector = Icons.Default.Info,
                contentDescription = null,
                modifier = Modifier
                    .size(32.dp)
                    .padding(8.dp)
            )
            Text(
                text = "Is this recommendation good for you?", fontWeight = FontWeight.Bold
            )
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()
        )

        {
            Text(
                text = "🤬",
                modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp),
                fontSize = 32.sp
            )
            Text(
                text = "😊",
                modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp),
                fontSize = 32.sp
            )
            Text(
                text = "😘",
                modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp),
                fontSize = 32.sp
            )
            Text(
                text = "😒",
                modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp),
                fontSize = 32.sp
            )
            Text(
                text = "😂",
                modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp),
                fontSize = 32.sp
            )


        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)

        ) {
            Text(text = "Very Bad", fontWeight = FontWeight.ExtraBold)
            Text(text = "Very Good", fontWeight = FontWeight.ExtraBold)

        }

    }

}


@Preview(showBackground = true)
@Composable
private fun RatingCardPreview() {
    RatingCard()
}

@Composable
fun InfoCard(modifier: Modifier = Modifier) {
    Column {
        Row {
            Column(
                verticalArrangement = SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .weight(1f)
                    .height(300.dp)
            ) {
                Column {
                    Text(
                        text = "Man of Steel",
                        style = MaterialTheme.typography.displayMedium,
                        fontWeight = FontWeight.ExtraBold
                    )
                    Text(
                        text = "Clark Kent",
                        style = MaterialTheme.typography.headlineLarge,
                        color = MaterialTheme.colorScheme.secondary
                    )
                    Spacer(modifier = Modifier.height(100.dp))
                    Text(
                        text = "The Man of Steel is a fictional character",
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.ExtraBold
                    )
                }
            }
            Image1(
                painter = painterResource(id = R.drawable.spiderman),
                contentDescription = null,
                modifier= Modifier
                    .height(300.dp)
                    .weight(1f)
                    .drawBehind {
                        drawCircle(
                            color = Color.Blue.copy(alpha = 0.1f), radius = 400f
                        )
                    }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun InfoCardPreview() {
    InfoCard()
}
@Composable
fun Tasklist(modifier: Modifier = Modifier) {
    val mytasks = listOf("Buy laundry", "do laundry", "don't eat sweets", "buy clothes")
    LazyColumn {
        items(mytasks) {
            Row(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null
                )
                Text(
                    text = it,
                    style = MaterialTheme.typography.headlineLarge,
                )

            }
        }
    }

}
@Preview(showSystemUi = true)
@Composable
private fun TaskListPreview() {
    Tasklist()
}
@Composable
fun homescreen() {
    Image1(
        painter = painterResource(id = R.drawable.background),
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.fillMaxSize()
    )
    Text(text = "Made By Pushkar Tiwari")
}



@Composable
fun mylist(modifier: Modifier = Modifier) {
    val avengers = listOf("Spiderman", "Ironman", "Netflix", "Superman")
    val avengersimages=listOf(R.drawable.spiderman,R.drawable.ironman,R.drawable.strangerthings,R.drawable.manofsteel)
    LazyColumn(
          horizontalAlignment = Alignment.CenterHorizontally,
        modifier= modifier
            .fillMaxWidth()
            .padding(16.dp)
    ){
        itemsIndexed(avengers){index,name->
            val imgScale = 1f
            Card(
                colors = CardDefaults.cardColors
                    (containerColor = MaterialTheme.colorScheme.background),
                modifier = Modifier
                    .padding(20.dp)
                    .width(330.dp)
                    .fillMaxSize(),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 8.dp),


            ){
                Row(
                    verticalAlignment = CenterVertically,) {
                    Image1(

                        painter = painterResource(id = avengersimages[index]),
                        contentDescription = null,
                        modifier = Modifier
                            .size(300.dp)
                            .weight(1f)
                            .drawBehind {
                                drawCircle(
                                    color = Color.Blue.copy(alpha = 0.1f),
                                    radius = 400f,
                                )
                                drawContext.transform.scale(
                                    scaleX = imgScale,
                                    scaleY = imgScale
                                )
                                drawContext.transform.translate(
                                    left = 0f,
                                    top = 100f
                                )
                                drawCircle(
                                    color = Color.Red.copy(alpha = 0.2f),
                                    radius = 300f,
                                )


                            }


                    )
                    Text(
                        text = name,
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.ExtraBold,
                        color = MaterialTheme.colorScheme.scrim
                    )


                }
            }
        }
    }
    
    
}




@Preview(showBackground = true)
@Composable
private fun MylistPreview() {
    homescreen()
    mylist()

}



