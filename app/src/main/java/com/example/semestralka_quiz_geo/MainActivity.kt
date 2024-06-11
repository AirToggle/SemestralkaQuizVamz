package com.example.semestralka_quiz_geo

import android.content.Context
import android.content.pm.PackageManager
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
import androidx.compose.runtime.remember
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.semestralka_quiz_geo.obrazovky.Encyklopedia.Encyklopedia
import com.example.semestralka_quiz_geo.obrazovky.Hl_menu
import com.example.semestralka_quiz_geo.obrazovky.Nastavenia
import com.example.semestralka_quiz_geo.obrazovky.Quiz_Screen
import com.example.semestralka_quiz_geo.Uzivatel.UzivatelData
import com.example.semestralka_quiz_geo.obrazovky.ResultScreen
import com.example.semestralka_quiz_geo.obrazovky.Statistiky
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    object Global {
        var NevytvorenyUzivatel: Boolean = false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        var uzivatel = UzivatelData()
        val notifikacnyKanal = Notifikacia()
        val sharedPreferences = getSharedPreferences("app_preferences", Context.MODE_PRIVATE)
        setContent {
            val context = this@MainActivity
            val hasNotificationPermission = remember {
                mutableStateOf(
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                        ContextCompat.checkSelfPermission(
                            context,
                            android.Manifest.permission.POST_NOTIFICATIONS
                        ) == PackageManager.PERMISSION_GRANTED
                    } else {
                        true
                    }
                )
            }
        }
        val RC_NOTIFICATION = 99

        notifikacnyKanal.createNotificationChannel(this)
        CoroutineScope(Dispatchers.Main).launch {
            if (null != UzivatelData.nacitatUdajeMax(this@MainActivity)) {
                Global.NevytvorenyUzivatel = true
            }
        }
        CoroutineScope(Dispatchers.Main).launch {
            if (!Global.NevytvorenyUzivatel) {
                UzivatelData.nacitatUdaje(this@MainActivity)
            } else {
                uzivatel = UzivatelData.nacitatUdajeMax(this@MainActivity)!!
                uzivatel.name = UzivatelData.nacitatMeno(this@MainActivity)!!
                uzivatel.celkovyCas = UzivatelData.nacitatCas(this@MainActivity)!!
                uzivatel.pocetOtazok = UzivatelData.nacitatPocetOtazok(this@MainActivity)!!
                uzivatel.pocetSpravnychOtazok = UzivatelData.nacitatPocetSpravnychOtazok(this@MainActivity)!!
            }
            /*

            uzivatel.zmenitMeno("miro",this@MainActivity)
            uzivatel.ulozitUdaje(this@MainActivity)
            //uzivatel.id

            */
        }

        if (!Global.NevytvorenyUzivatel) {
            uzivatel = UzivatelData()
        }

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {

            requestPermissions(arrayOf(android.Manifest.permission.POST_NOTIFICATIONS), RC_NOTIFICATION)
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
                composable("ResultScreen") { ResultScreen(novControllerr) }
                composable("Statistiky") { Statistiky(novControllerr, uzivatel) }
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


