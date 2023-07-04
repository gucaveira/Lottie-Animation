package com.gustavo.rocha.composelottie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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
import androidx.compose.ui.unit.dp
import com.gustavo.rocha.composelottie.ui.theme.ComposeLottieTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLottieTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeLottieScreen()
                }
            }
        }
    }
}

@Composable
fun ComposeLottieScreen() {
    var isSuccess by remember { mutableStateOf(false) }
    var isFailed by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        ComposeLottieAnimation(
            modifier = Modifier.align(alignment = Alignment.Center),
            isSuccess = isSuccess,
            isFailed = isFailed
        )

        Column(modifier = Modifier.align(Alignment.BottomCenter)) {

            Button(
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .padding(bottom = 15.dp),
                onClick = {
                    isSuccess = true
                    isFailed = false
                }) {
                Text(text = "Successful")
            }

            Button(
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .padding(bottom = 15.dp),
                onClick = {
                    isFailed = true
                    isSuccess = false
                }
            ) {
                Text(
                    text = "Failure"
                )
            }

            Button(
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .padding(bottom = 45.dp),
                onClick = {
                    isSuccess = false
                    isFailed = false
                }
            ) {
                Text(
                    text = "Restart"
                )
            }
        }
    }
}