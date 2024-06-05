package com.example.semestralka_quiz_geo.Obrazovky

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.semestralka_quiz_geo.R
import com.example.semestralka_quiz_geo.Uzivatel.UzivatelData

@Composable
fun Quiz_Screen(navController: NavController , uzivatel : UzivatelData = UzivatelData()) {
    val configuration = LocalConfiguration.current
    val isPortrait =
        configuration.orientation == android.content.res.Configuration.ORIENTATION_PORTRAIT

    Box(modifier = Modifier.fillMaxSize()) {

        Image(
            painter = painterResource(id = R.drawable.pozadie2),
            contentDescription = "pozadie",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )


        Image(
            painter = painterResource(id = R.drawable.question_mark),
            contentDescription = "otazka_fotka",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxWidth()
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .size(50.dp)
                    .background(color = Color.Red),
            ) {
                Button(
                    onClick = { navController.navigate("Hl_menu") },
                    modifier = Modifier.fillMaxSize(),
                    colors = ButtonDefaults.buttonColors(Color.Transparent)
                ) {
                    Text(
                        text = "X",
                        color = Color.Black,
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }


        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = if (isPortrait) 144.dp else 0.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(
                        onClick = {

                                  },
                        modifier = Modifier
                            .weight(1f)
                            .wrapContentWidth()
                            .padding(8.dp),
                        colors = ButtonDefaults.buttonColors(Color.Green)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.albansko),
                            contentDescription = "Albánsko",
                            modifier = Modifier.size(128.dp)
                        )
                    }
                    Button(
                        onClick = {

                        },
                        modifier = Modifier
                            .weight(1f)
                            .wrapContentWidth()
                            .padding(8.dp),
                        colors = ButtonDefaults.buttonColors(Color.Green)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.bielorusko),
                            contentDescription = "Bielorusko",
                            modifier = Modifier.size(128.dp)
                        )
                    }
                }
            }

            item {
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(
                        onClick = {

                        },
                        modifier = Modifier
                            .weight(1f)
                            .wrapContentWidth()
                            .padding(8.dp),
                        colors = ButtonDefaults.buttonColors(Color.Green)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.chorvatsko),
                            contentDescription = "Chorvátsko",
                            modifier = Modifier.size(128.dp)
                        )
                    }
                    Button(
                        onClick = {

                                  },
                        modifier = Modifier
                            .weight(1f)
                            .wrapContentWidth()
                            .padding(8.dp),
                        colors = ButtonDefaults.buttonColors(Color.Green)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.dansko),
                            contentDescription = "Dánsko",
                            modifier = Modifier.size(128.dp)
                        )
                    }
                }
            }
        }
    }
}
