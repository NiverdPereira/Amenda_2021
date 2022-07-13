package com.example.amenda

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.example.amenda.ui.theme.AmendaTheme

@Composable
@Preview
fun Design() {
    AmendaTheme {
        Column {
            CenterImage()
            Greeting()
            Greeting()
        }
    }

}

@OptIn(ExperimentalUnitApi::class)
@Composable
private fun Greeting(name: String = "name") {
    //Text(text = "Hello $name!")
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(top = 10.dp)
    ) {
        //Greeting("Android")
        Image(
            painter = painterResource(id = R.drawable.feb21_2021),
            contentScale = ContentScale.Crop,
            contentDescription = null,
            modifier = Modifier
                .padding(start = 10.dp)
                .clip(CircleShape)
                .size(100.dp)
        )
        Column(modifier = Modifier.padding(top = 10.dp, start = 10.dp, end = 10.dp)) {
            Text(
                text = "Amenda", fontWeight = FontWeight.Bold,
                fontSize = TextUnit(21.0F, TextUnitType.Sp)
            )
            Text(
                text = "Active 2 min ago",
                fontWeight = FontWeight.Light,
                fontSize = TextUnit(15.0F, TextUnitType.Sp)
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
        modifier = Modifier.padding(start = 20.dp, end = 20.dp)
            .size(200.dp).clip(RoundedCornerShape(10.dp))
    )
}