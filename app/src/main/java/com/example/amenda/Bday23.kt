package com.example.amenda

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
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
    AmendaTheme {
        // A surface container using the 'background' color from the theme
        Row(
            Modifier
                .fillMaxSize()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { /*TODO*/ }, modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .clip(
                        CircleShape
                    )
            ) {
                Text(text = "2021")
            }

            Button(
                onClick = {
                          /*TODO*/ }, modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .clip(
                        CircleShape
                    )
            ) {
                Text(text = "2022")
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