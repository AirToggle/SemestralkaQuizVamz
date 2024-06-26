package com.example.semestralka_quiz_geo.obrazovky

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.semestralka_quiz_geo.Otazka.NacitajOtazky
import com.example.semestralka_quiz_geo.R
import com.example.semestralka_quiz_geo.Uzivatel.UzivatelData



@Composable
fun Hl_menu(navController: NavController, uzivatel : UzivatelData = UzivatelData()) {
    val context = LocalContext.current

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
            
        }

        item {
            Button(onClick = {
                NacitajOtazky(context)
                navController.navigate("Quiz_Screen")
            }) {
                Text(text = "Spusti Quiz", fontSize = 16.sp)
            }
        }
        item {
            Button(onClick = {
                NacitajOtazky(context)
                navController.navigate("Statistiky")
            }) {
                Text(text = "Štatistiky", fontSize = 16.sp)
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
                //modifier = Modifier.padding(bottom = 48.dp),
                colors = ButtonDefaults.buttonColors(Color.Black)
            ) {
                Text(text = "Nastavenia", fontSize = 16.sp)
            }
        }
        item {
            Button(
                onClick = {
                    (context as? Activity)?.finishAffinity()
                },
                //modifier = Modifier.padding(bottom = 48.dp),
                colors = ButtonDefaults.buttonColors(Color.Red)
            ) {
                Text(text = "Ukonči", fontSize = 16.sp)
            }
        }
    }
}

