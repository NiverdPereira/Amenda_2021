package com.example.amenda

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Colors
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.example.amenda.ui.theme.AmendaTheme


@OptIn(ExperimentalUnitApi::class)
@Composable
@Preview
fun Design() {
    var visible by rememberSaveable { mutableStateOf(0) }
    var chooser by rememberSaveable { mutableStateOf(0) }

    AmendaTheme {
        Column(
            Modifier
                .fillMaxSize()
                .wrapContentWidth(), verticalArrangement = Arrangement.Top
        ) {
            if (visible >= 4) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth()
                        .padding(5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    ChooserButton(onClick = {
                        visible = -1
                        chooser = 1
                    }, text = "Yes")
                    ChooserButton(onClick = {
                        visible = -1
                        chooser = 1
                    }, text = "Also yes")
                }
            }
            Button(
                onClick = {
                    chooser = 0
                    if (visible == 4) {
                        visible -= 4
                    } else {
                        visible++
                    }
                },
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .align(Alignment.CenterHorizontally)
                    .padding(30.dp)
            ) {
                Text(text = if(chooser == 1) "Go Again" else "Next")
            }

            if (chooser == 1) {
                Text(
                    text = "Happy Birthday pudding and I love you so much!",
                    fontWeight = FontWeight.Bold,
                    fontSize = TextUnit(21.0F, TextUnitType.Sp),
                    color = Color.Magenta,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(start = 55.dp, end = 55.dp)
                )
            }
            Column(
                Modifier
                    .fillMaxSize()
                    .wrapContentWidth(),
                verticalArrangement = Arrangement.Center,
            ) {
                //CenterImage()
                if (visible >= 1) Greeting("AMENDA", pId = R.drawable.p_one, "From Pagar")
                if (visible >= 2) Marry()
                if (visible >= 3) Greeting("SHOVON", pId = R.drawable.p_two, "From Bhadarty")
            }
            //if(visible >= 4) {

            //}
        }
    }

}

@OptIn(ExperimentalUnitApi::class)
@Composable
private fun Greeting(name: String = "name", pId: Int, sub: String) {
    //Text(text = "Hello $name!")
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(),
        verticalAlignment = Alignment.CenterVertically,

        ) {
        //Greeting("Android")
        Image(
            alignment = Alignment.Center,
            painter = painterResource(id = pId),
            contentScale = ContentScale.Crop,
            contentDescription = null,
            modifier = Modifier
                .padding(start = 10.dp)
                .clip(CircleShape)
                .size(150.dp)
        )
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(10.dp)

        ) {
            Text(
                text = name, fontWeight = FontWeight.Bold,
                fontSize = TextUnit(21.0F, TextUnitType.Sp)
            )
            Text(
                text = sub,
                fontWeight = FontWeight.Light,
                fontSize = TextUnit(25.0F, TextUnitType.Sp)
            )
        }
    }
}

@Composable
private fun CenterImage() {
    Image(
        painter = painterResource(id = R.drawable.the_one),
        contentScale = ContentScale.Crop,
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth()
            .padding(start = 20.dp, end = 20.dp)
            .size(200.dp)
            .clip(RoundedCornerShape(10.dp))
    )
}

@OptIn(ExperimentalUnitApi::class)
@Composable
private fun Marry() {
    Text(
        text = "Will you marry?",
        fontWeight = FontWeight.Bold,
        fontSize = TextUnit(21.0F, TextUnitType.Sp),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth()
            .padding(20.dp)
    )
}

@Composable
private fun ChooserButton(onClick: () -> Unit, text: String) {
    Button(
        onClick = onClick, modifier = Modifier
            .padding(3.dp)
    ) {
        Text(text = text)
    }
}