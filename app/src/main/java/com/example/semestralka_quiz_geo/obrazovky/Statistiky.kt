package com.example.semestralka_quiz_geo.obrazovky

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.semestralka_quiz_geo.R
import com.example.semestralka_quiz_geo.Uzivatel.UzivatelData

@Composable
fun Statistiky(navController: NavController, uzivatel: UzivatelData = UzivatelData()) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
        Image(
            painter = painterResource(id = R.drawable.pozadie2),
            contentDescription = "pozadie",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )

    Text(
        text = " Štatistiky ",
        fontSize = 32.sp,
        color = Color.White,
        modifier = Modifier
            //.align(Alignment.Center)
            .background(Color.DarkGray)
            .padding(top = 16.dp)


    )
}

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Text(text = " Meno hráča: " + uzivatel.name + " ",fontSize = 20.sp, color = Color.Black,
            modifier = Modifier
                .padding(32.dp)
                .background(Color.White,shape = MaterialTheme.shapes.medium)
            )
        }
        item {
            Text(text = " Počet zodpovedaných otázok: " + uzivatel.pocetOtazok + " ",fontSize = 20.sp, color = Color.Black,
                modifier = Modifier
                    .padding(32.dp)
                    .background(Color.White,shape = MaterialTheme.shapes.medium)
            )
        }
        item {
            Text(text = " Počet správne zodpovedaných otázok: " + uzivatel.pocetSpravnychOtazok + " ",fontSize = 20.sp, color = Color.Black,
                modifier = Modifier
                    .padding(32.dp)
                    .background(Color.White,shape = MaterialTheme.shapes.medium)
            )
        }
        item {
            Text(text = " Celkový čas strávený v quize: " + uzivatel.celkovyCas + " ",fontSize = 20.sp, color = Color.Black,
                modifier = Modifier
                    .padding(32.dp)
                    .background(Color.White,shape = MaterialTheme.shapes.medium)
            )
        }
        item {
            Button(onClick = {
                navController.popBackStack()
            }) {
                Text(text = "Späť", fontSize = 16.sp)
            }
        }
    }


}