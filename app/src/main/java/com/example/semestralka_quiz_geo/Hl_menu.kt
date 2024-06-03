package com.example.semestralka_quiz_geo

import android.view.Surface
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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



@Composable
fun Hl_menu(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.pozadie2),
            contentDescription = "pozadie",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )
    }

    Text(text = " ' Uživateľ ' ", fontSize = 24.sp, color = Color.Black,
        modifier = Modifier.padding(top = 48.dp)
            .padding(start = 16.dp)
            .background(Color.White)
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        item {
            Button(onClick = {
                navController.navigate("Quiz_Screen")
            }) {
                Text(text = "Spusti Quiz", fontSize = 16.sp)
            }
        }
        item {
            Button(
                onClick = {
                    navController.navigate("Encyklopedia")
                },
            ) {
                Text(text = "Encyklopédia", fontSize = 16.sp)
            }
        }
        item {
            Button(
                onClick = {
                    navController.navigate("Nastavenia")
                },
                modifier = Modifier.padding(bottom = 48.dp),
                colors = ButtonDefaults.buttonColors(Color.Black)
            ) {
                Text(text = "Nastavenia", fontSize = 16.sp)
            }
        }
    }
}

