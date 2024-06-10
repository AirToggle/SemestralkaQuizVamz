package com.example.semestralka_quiz_geo.obrazovky

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.semestralka_quiz_geo.R

@Composable
fun ResultScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.pozadie2),
            contentDescription = "pozadie",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
                Text(
                    text = " Výsledky ",
                    fontSize = 24.sp,
                    color = Color.Black,
                    modifier = Modifier
                        .background(Color.White)
                )

        }
        item {
            Text(
                text = " Výsledky ",
                fontSize = 24.sp,
                color = Color.Black,
                modifier = Modifier
                    .background(Color.White)
            )

        }
        item {
            Button(onClick = {
                navController.navigate("Hl_menu")
            }) {
                Text(text = "Späť do menu", fontSize = 16.sp)
            }
        }
    }
}

