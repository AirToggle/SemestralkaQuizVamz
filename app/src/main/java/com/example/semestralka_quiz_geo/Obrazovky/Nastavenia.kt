package com.example.semestralka_quiz_geo.Obrazovky


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp

import androidx.navigation.NavController
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.VisualTransformation
import com.example.semestralka_quiz_geo.R
import com.example.semestralka_quiz_geo.Uzivatel.UzivatelData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Composable
fun Nastavenia(navController: NavController, uzivatel : UzivatelData = UzivatelData()) {
    val configuration = LocalConfiguration.current
    val currentFocus = LocalFocusManager.current
    val isPortrait =
        configuration.orientation == android.content.res.Configuration.ORIENTATION_PORTRAIT

    val contextt = LocalContext.current;
    var text by rememberSaveable { mutableStateOf("")}
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
                text = " Nastavenia ",
                fontSize = 24.sp,
                color = Color.White,
                modifier = Modifier
                    //.align(Alignment.Center)
                    .background(Color.Blue)
            )
        }
        item {
            TextField(
                value = text,
                onValueChange = { newText ->
                    val filteredText = newText.filter { it.isLetter() }
                    text = filteredText
                },
                label = { Text("Zmena mena") },
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(onDone = {
                    uzivatel.name = text
                    CoroutineScope(Dispatchers.IO).launch {
                        uzivatel.ulozitUdaje(contextt)
                    }
                    currentFocus.clearFocus()
                }),
                visualTransformation = VisualTransformation.None // Zobrazíme text v neupravenej podobe
            )
            Box(modifier = Modifier.fillMaxWidth()) {
                Button(modifier = Modifier.align(Alignment.Center),
                    colors = ButtonDefaults.buttonColors(Color.Green),
                    onClick = {
                        uzivatel.name = text
                        CoroutineScope(Dispatchers.IO).launch {
                            uzivatel.ulozitUdaje(contextt)
                        }
                        currentFocus.clearFocus()
                    }
                ) {
                    Text(text = "Uložiť meno", fontSize = 16.sp, color = Color.Black)
                }
            }
        }
        item {
            Button(onClick = {
                navController.navigate("Hl_menu")
            }) {
                Text(text = "Späť", fontSize = 16.sp)
            }
        }

    }
}