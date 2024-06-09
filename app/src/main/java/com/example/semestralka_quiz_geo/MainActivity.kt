package com.example.semestralka_quiz_geo

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.semestralka_quiz_geo.Obrazovky.Encyklopedia
import com.example.semestralka_quiz_geo.Obrazovky.Hl_menu
import com.example.semestralka_quiz_geo.Obrazovky.Nastavenia
import com.example.semestralka_quiz_geo.Obrazovky.Quiz_Screen
import com.example.semestralka_quiz_geo.Uzivatel.UzivatelData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var uzivatel = UzivatelData()
        val notifikacnyKanal = Notifikacia()
        notifikacnyKanal.createNotificationChannel(this)


        CoroutineScope(Dispatchers.Main).launch {
            UzivatelData.nacitatUdaje(this@MainActivity)
            uzivatel.zmenitMeno("miro",this@MainActivity)
            uzivatel.ulozitUdaje(this@MainActivity)
        }
        super.onCreate(savedInstanceState)
        setContent {
            val novControllerr = rememberNavController()
            NavHost(navController = novControllerr, startDestination = "obrazovka") {
                composable("Obrazovka") { Obrazovka(novControllerr,uzivatel) }
                composable("Hl_menu") { Hl_menu(novControllerr, uzivatel) }
                composable("Quiz_Screen") { Quiz_Screen(novControllerr, uzivatel) }
                composable("Encyklopedia") { Encyklopedia(novControllerr) }
                composable("Nastavenia") { Nastavenia(novControllerr, uzivatel) }
            }
        }
    }
}

@Composable
fun Obrazovka(navController: NavController, uzivatel : UzivatelData = UzivatelData()) {
    val configuration = LocalConfiguration.current
    val isPortrait = configuration.orientation == android.content.res.Configuration.ORIENTATION_PORTRAIT
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
            .padding(top = if (isPortrait) 64.dp else 16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Text(text = "Vitaj " + uzivatel.name, fontSize = 32.sp)
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
    fun ObrazovkaPreview() {
        Obrazovka(navController = rememberNavController())
    }

