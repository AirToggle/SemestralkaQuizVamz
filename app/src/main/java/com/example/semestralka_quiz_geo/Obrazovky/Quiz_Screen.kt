package com.example.semestralka_quiz_geo.Obrazovky

import androidx.compose.foundation.Image
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
import com.example.semestralka_quiz_geo.R

@Composable
fun Quiz_Screen(navController: NavController) {
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
            Box(modifier = Modifier.fillMaxWidth(0.7f),
                //verticalArrangement = Arrangement.Center,
            )
        }
        item {
            Button(
                onClick = {

                },
                modifier = Modifier.padding(bottom = 48.dp),
                colors = ButtonDefaults.buttonColors(Color.Green)
            ) {
                Text(text = "Sabubo", fontSize = 16.sp)
            }
        }
        item {
            Button(
                onClick = {

                },
                modifier = Modifier.padding(bottom = 48.dp),
                colors = ButtonDefaults.buttonColors(Color.Green)
            ) {
                Text(text = "Sabubo", fontSize = 16.sp)
            }
        }
        item {
            Button(
                onClick = {

                },
                modifier = Modifier.padding(bottom = 48.dp),
                colors = ButtonDefaults.buttonColors(Color.Green)
            ) {
                Text(text = "Sabubo", fontSize = 16.sp)
            }
        }
        item {
            Button(
                onClick = {

                },
                modifier = Modifier.padding(bottom = 48.dp),
                colors = ButtonDefaults.buttonColors(Color.Green)
            ) {
                Text(text = "Sabubo", fontSize = 16.sp)
            }
        }
    }
}