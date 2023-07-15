package com.example.amenda

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.displayCutoutPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.sharp.ImageAspectRatio
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.amenda.ui.theme.AmendaTheme

class Bday23 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Greeting2(name = "ss")
        }
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    AmendaTheme {
        // A surface container using the 'background' color from the theme
        Row(
            Modifier
                .fillMaxSize()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { context.startActivity(Intent(context, MainActivity::class.java)) },
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .clip(CircleShape)
                    .size(120.dp)
                    .padding(end = 5.dp),
                contentPadding = PaddingValues(1.dp),
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(Color.Transparent)
            ) {
                Box() {
                    Image(
                        painter = painterResource(id = R.drawable.jan9_2021),
                        contentDescription = "test",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .clip(CircleShape)
                            .alpha(0.4f)
                    )
                    Text(
                        text = "2021", modifier = Modifier
                            .align(Alignment.Center)
                            .size(200.dp)
                            .wrapContentSize()
                    )
                }
            }

            Button(
                onClick = {
                    context.startActivity(Intent(context, Bday::class.java))
                },
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .clip(CircleShape)
                    .size(120.dp)
                    .padding(end = 5.dp),
                contentPadding = PaddingValues(1.dp),
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(Color.Transparent)
            ) {
                //Icon(Icons.Sharp.ImageAspectRatio, contentDescription = "2022", modifier = Modifier.size(30.dp))
                Box() {
                    Image(
                        painter = painterResource(id = R.drawable.feb14_2021),
                        contentDescription = "test",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .clip(CircleShape)
                            .alpha(0.4f)
                            .size(120.dp)
                    )
                    Text(text = "2022", modifier = Modifier
                        .align(Alignment.Center)
                        .size(200.dp)
                        .wrapContentSize(),
                    )
                }
            }

            Button(
                onClick = {
                    context.startActivity(Intent(context, Bday::class.java))
                },
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .clip(CircleShape)
                    .size(120.dp)
                    .padding(end = 5.dp),
                contentPadding = PaddingValues(1.dp),
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(Color.Transparent)
            ) {
                //Icon(Icons.Sharp.ImageAspectRatio, contentDescription = "2022", modifier = Modifier.size(30.dp))
                Box() {
                    Image(
                        painter = painterResource(id = R.drawable.feb27_2021),
                        contentDescription = "test",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .clip(CircleShape)
                            .alpha(0.4f)
                            .size(120.dp)
                    )
                    Text(text = "2023", modifier = Modifier
                        .align(Alignment.Center)
                        .size(200.dp)
                        .wrapContentSize(), color = Color.Magenta)
                }
            }


        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AmendaTheme {
        Greeting2("Android")
    }
}