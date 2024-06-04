package com.example.learningstate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.learningstate.ui.theme.LearningStateTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearningStateTheme {
                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.5f)
                            .weight(1f)
                    ) {
                        Greeting(modifier = Modifier.weight(0.5f))
                        Greeting(modifier = Modifier.weight(0.5f))
                    }

                    Row(
                        modifier = Modifier.fillMaxSize()

                    ) {
                        val color = remember { mutableStateOf(Color.Yellow) }
                        GreetingForExternalState(modifier = Modifier.weight(0.5f), updateColor = {
                            color.value = it
                        })
                        Greeting(modifier = Modifier.weight(0.5f).background(color.value))



                    }
                }


            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    val color = remember { mutableStateOf(Color.LightGray) }
    Box(modifier = modifier
        .fillMaxSize()
        .background(color.value)
        .clickable {
            color.value = Color(
                Random.nextFloat(),
                Random.nextFloat(),
                Random.nextFloat(),

                )
        }
    )
}

@Composable
fun GreetingForExternalState(modifier: Modifier = Modifier
        ,updateColor: (Color) -> Unit
) {

    Box(modifier = modifier
        .fillMaxSize()
        .background(Color.Cyan)
        .clickable {
            updateColor(Color(
                Random.nextFloat(),
                Random.nextFloat(),
                Random.nextFloat(),)


                )
        }
    )
}

@Preview(showSystemUi = true)
@Composable
fun GreetingPreview() {
    LearningStateTheme {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f)

            ) {
                Greeting(modifier = Modifier.weight(0.5f))
                Greeting(modifier = Modifier.weight(0.5f))
            }

            Row(
                modifier = Modifier.fillMaxSize()

            ) {
                val color = remember { mutableStateOf(Color.Yellow) }

                Box(modifier = Modifier.background(color.value).weight(0.5f).fillMaxSize()) {  }



                GreetingForExternalState(modifier = Modifier.weight(0.5f), updateColor = {
                    color.value = it
                })




            }
        }


    }
}