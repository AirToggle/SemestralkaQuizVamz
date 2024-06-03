package com.example.semestralka_quiz_geo

import androidx.compose.ui.Modifier
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val novControllerr = rememberNavController()
            NavHost(navController = novControllerr, startDestination = "obrazovka") {
                composable("obrazovka") { obrazovka(novControllerr) }
                composable("Hl_menu") { Hl_menu(novControllerr) }
                composable("Quiz_Screen") { Quiz_Screen(novControllerr) }
                composable("Encyklopedia") { Encyklopedia(novControllerr) }
                composable("Nastavenia") { Nastavenia(novControllerr) }
            }
        }
    }
}

@Composable
fun obrazovka(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.pozadie1),
            contentDescription = "pozadie",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )
    }
    LazyColumn(
        modifier = Modifier.fillMaxSize()
        .padding(top = 64.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Text(text = "Vitaj ' uživateľ '", fontSize = 32.sp,)
        }
            item {
            Button(
                onClick = {
                    navController.navigate("Hl_menu")
                },
                modifier = Modifier.padding(bottom = 48.dp),
            ) {
                Text(text = "Klikni sem pre pokračovanie", fontSize = 16.sp)
            }
        }
    }
}




    @Preview(showBackground = true)
    @Composable
    fun obrazovkaPreview() {
        obrazovka(navController = rememberNavController())
    }
