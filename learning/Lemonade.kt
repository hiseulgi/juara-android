package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonApp()
            }
        }
    }
}

@Composable
fun LemonApp(modifier: Modifier = Modifier) {
    var currentStep by remember { mutableStateOf(1) }
    var squeezeStep by remember { mutableStateOf(1) }
    var squeezeStepTotal by remember { mutableStateOf(2) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        when (currentStep) {
            1 -> {
                LemonTextAndImage(
                    imageSource = painterResource(id = R.drawable.lemon_tree),
                    stringSource = stringResource(id = R.string.lemon_step1),
                    onStartClicked = {
                        currentStep = 2
                        squeezeStepTotal = (2..4).random()
                        squeezeStep = 1
                    }
                )
            }
            2 -> {
                LemonTextAndImage(
                    imageSource = painterResource(id = R.drawable.lemon_squeeze),
                    stringSource = stringResource(id = R.string.lemon_step2),
                    onStartClicked = {
                        if (squeezeStep >= squeezeStepTotal) {
                            currentStep = 3
                        }
                        squeezeStep++
                    }
                )
            }
            3 -> {
                LemonTextAndImage(
                    imageSource = painterResource(id = R.drawable.lemon_drink),
                    stringSource = stringResource(id = R.string.lemon_step3),
                    onStartClicked = {
                        currentStep = 4
                    }
                )
            }
            4 -> {
                LemonTextAndImage(
                    imageSource = painterResource(id = R.drawable.lemon_restart),
                    stringSource = stringResource(id = R.string.lemon_step4),
                    onStartClicked = {
                        currentStep = 1
                    }
                )
            }
        }
    }
}

@Composable
fun LemonTextAndImage(
    imageSource: Painter,
    stringSource: String,
    onStartClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Button(
            onClick = onStartClicked,
            shape = RoundedCornerShape(16),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFC1D8C3))
        ) {
            Image(
                painter = imageSource,
                contentDescription = stringSource,
                modifier = Modifier
                    .wrapContentSize()
            )
        }
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = stringSource,
            fontSize = 18.sp
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LemonAppPreview() {
    LemonadeTheme {
        LemonApp()
    }
}