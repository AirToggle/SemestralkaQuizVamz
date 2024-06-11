package com.example.semestralka_quiz_geo.obrazovky.Encyklopedia

import android.content.Context
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.semestralka_quiz_geo.R
import androidx.compose.ui.platform.LocalContext
import androidx.compose.runtime.remember


@Composable
fun Encyklopedia(navController: NavController) {
    val viewModel: NacitavanieObsahuView = viewModel()
    val context = LocalContext.current
    var obsahy by remember { mutableStateOf<List<ObsahEncyklopedie>?>(null) }
    LaunchedEffect(Unit) {
        obsahy = viewModel.NacitajObsahy(context)
    }





    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
        Image(
            painter = painterResource(id = R.drawable.pozadie2),
            contentDescription = "pozadie",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )

        Text(
            text = " Encyklopédia ",
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            color = Color.White,
            modifier = Modifier
                .background(Color.DarkGray)
                .padding(top = 16.dp)

        )
    }
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if (obsahy != null) {
            for (myObject in obsahy!!) {
                item {
                    ExpandableCard(
                        title = myObject.title,
                        description = myObject.susedia,
                        foto = myObject.image_url,
                        contextt = context

                    )
                }
            }
        }


        item {
            Button(onClick = {
                navController.popBackStack()
            }) {
                Text(text = "Späť", fontSize = 16.sp)
            }
        }
    }
}


/*
    https://medium.com/@anandgaur22/expandable-card-with-animation-in-jetpack-compose-70849c33a391
 */
@Composable
fun ExpandableCard(
    title: String,
    titleFontSize: TextUnit = MaterialTheme.typography.titleLarge.fontSize,
    titleFontWeight: FontWeight = FontWeight.Bold,
    description: String,
    foto: String,
    contextt: Context,
    descriptionFontSize: TextUnit = MaterialTheme.typography.titleSmall.fontSize,
    descriptionFontWeight: FontWeight = FontWeight.Normal,
    descriptionMaxLines: Int = 4,
    //shape: androidx.compose.foundation.shape.Shape = sharpShapes.medium,
    padding: Dp = 12.dp
) {
    var expandedState by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(
        targetValue = if (expandedState) 180f else 0f
    )

    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            ),
        //shape = shape,
        onClick = {
            expandedState = !expandedState
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(padding)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier
                        .weight(6f),
                    text = title,
                    fontSize = titleFontSize,
                    fontWeight = titleFontWeight,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                IconButton(
                    modifier = Modifier
                        .weight(1f)
                        .alpha(0.2f)
                        .rotate(rotationState),
                    onClick = {
                        expandedState = !expandedState
                    }) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Drop-Down Arrow"
                    )
                }
            }
            if (expandedState) {
                Text(
                    text = " Susedia: " + description,
                    fontSize = descriptionFontSize,
                    fontWeight = descriptionFontWeight,
                    maxLines = descriptionMaxLines,
                    overflow = TextOverflow.Ellipsis
                )
                var fotoid = remember {
                    contextt.resources.getIdentifier(
                        foto,
                        "drawable",
                        contextt.packageName
                    )
                }
                Image(
                    painter = painterResource(id = fotoid),
                    contentDescription = "pozadie",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}
