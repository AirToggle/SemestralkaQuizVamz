package com.example.semestralka_quiz_geo.obrazovky

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.semestralka_quiz_geo.Otazka.Otazka
import com.example.semestralka_quiz_geo.R
import com.example.semestralka_quiz_geo.Uzivatel.UzivatelData
import com.example.semestralka_quiz_geo.obrazovky.Encyklopedia.ExpandableCard
import com.example.semestralka_quiz_geo.obrazovky.quiz.Quiz_ScreenView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@SuppressLint("DiscouragedApi")
@Composable
fun Quiz_Screen(navController: NavController, uzivatel: UzivatelData = UzivatelData()) {
    val context = LocalContext.current
    val viewModel: Quiz_ScreenView = viewModel()
    val numbers: MutableList<Otazka> = mutableListOf()

    LaunchedEffect(Unit) {
        viewModel.loadQuestions(context)
    }

    val questions = viewModel.questions.value
    val currentQuestionIndex by viewModel.currentQuestionIndex
    val currentQuestion = questions.getOrNull(currentQuestionIndex)
    var help : Boolean = false
    val configuration = LocalConfiguration.current
    val isPortrait =
        configuration.orientation == android.content.res.Configuration.ORIENTATION_PORTRAIT
    if (currentQuestion == null) {
        LazyColumn (modifier = Modifier
            .fillMaxSize()
            .padding(top = if (isPortrait) 144.dp else 0.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally) {
            item {
             Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "No more questions!", fontSize = 24.sp)
            }
        }
            item {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center, ) {
                Button(onClick = { navController.navigate("ResultScreen") }) {
                    Text(text = "Vysledky", fontSize = 24.sp)
                }
            }

            }
            /*
            for (myObject in questions) {
                item {
                    ExpandableCard(
                        title = myObject.question,
                        description = myObject.answer,
                        foto = myObject.image_url,
                        contextt = context

                    )
                }
            }

             */
        }


        help = true
        return
    }

    if (help) {
        navController.navigate("ResultScreen")
    }




    Box(modifier = Modifier.fillMaxSize()) {

        Image(
            painter = painterResource(id = R.drawable.pozadie2),
            contentDescription = "pozadie",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )

        val questionImageA = remember(currentQuestion.A) {
            context.resources.getIdentifier(
                currentQuestion.A,
                "drawable",
                context.packageName
            )
        }

        val questionImageB = remember(currentQuestion.B) {
            context.resources.getIdentifier(
                currentQuestion.B,
                "drawable",
                context.packageName
            )
        }
        val questionImageC = remember(currentQuestion.C) {
            context.resources.getIdentifier(
                currentQuestion.C,
                "drawable",
                context.packageName
            )
        }
        val questionImageD = remember(currentQuestion.D) {
            context.resources.getIdentifier(
                currentQuestion.D,
                "drawable",
                context.packageName
            )
        }





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
                    onClick = {
                        CoroutineScope(Dispatchers.Main).launch {
                            uzivatel.aktualizovatUdaje(context)
                        }
                        navController.popBackStack()
                    },

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
                Text(text = currentQuestion.question, fontSize = 24.sp, textAlign = TextAlign.Center)
            }

            item {
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(
                        onClick = {
                            if(viewModel.checkAnswer("A")) {
                                CoroutineScope(Dispatchers.Main).launch {
                                    uzivatel.pridajPocetSpravnychOtazok(context)
                                }
                            } else {
                                CoroutineScope(Dispatchers.Main).launch {
                                    uzivatel.pridajPocetOtazok(context)
                                }
                                numbers.add(currentQuestion)
                            }
                            viewModel.nextQuestion()
                        },
                        modifier = Modifier
                            .weight(1f)
                            .wrapContentWidth()
                            .padding(8.dp),
                        colors = ButtonDefaults.buttonColors(Color.Green)
                    ) {
                        Image(

                            painter = painterResource(id =  questionImageA),
                            contentDescription = "Albánsko",
                            modifier = Modifier.size(128.dp)
                        )
                    }
                    Button(
                        onClick = {
                            if(viewModel.checkAnswer("B")) {
                                CoroutineScope(Dispatchers.Main).launch {
                                    uzivatel.pridajPocetSpravnychOtazok(context)
                                }
                            } else {
                                CoroutineScope(Dispatchers.Main).launch {
                                    uzivatel.pridajPocetOtazok(context)
                                }
                                numbers.add(currentQuestion)
                            }
                            viewModel.nextQuestion()
                        },
                        modifier = Modifier
                            .weight(1f)
                            .wrapContentWidth()
                            .padding(8.dp),
                        colors = ButtonDefaults.buttonColors(Color.Green)
                    ) {
                        Image(
                            painter = painterResource(id =  questionImageB),
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
                            if(viewModel.checkAnswer("C")) {
                                CoroutineScope(Dispatchers.Main).launch {
                                    uzivatel.pridajPocetSpravnychOtazok(context)
                                }
                            } else {
                                CoroutineScope(Dispatchers.Main).launch {
                                    uzivatel.pridajPocetOtazok(context)
                                }
                                numbers.add(currentQuestion)
                            }
                            viewModel.nextQuestion()
                        },
                        modifier = Modifier
                            .weight(1f)
                            .wrapContentWidth()
                            .padding(8.dp),
                        colors = ButtonDefaults.buttonColors(Color.Green)
                    ) {
                        Image(
                            painter = painterResource(id =  questionImageC),
                            contentDescription = "Chorvátsko",
                            modifier = Modifier.size(128.dp)
                        )
                    }
                    Button(
                        onClick = {
                            if(viewModel.checkAnswer("D")) {
                                CoroutineScope(Dispatchers.Main).launch {
                                    uzivatel.pridajPocetSpravnychOtazok(context)
                                }
                            } else {
                                CoroutineScope(Dispatchers.Main).launch {
                                    uzivatel.pridajPocetOtazok(context)
                                }
                                numbers.add(currentQuestion)
                            }
                            viewModel.nextQuestion()
                        },
                        modifier = Modifier
                            .weight(1f)
                            .wrapContentWidth()
                            .padding(8.dp),
                        colors = ButtonDefaults.buttonColors(Color.Green)
                    ) {
                        Image(
                            painter = painterResource(id =  questionImageD),
                            contentDescription = "Dánsko",
                            modifier = Modifier.size(128.dp)
                        )
                    }
                }
            }
        }
    }
}


