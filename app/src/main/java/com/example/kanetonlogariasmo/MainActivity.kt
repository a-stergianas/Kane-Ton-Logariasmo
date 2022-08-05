package com.example.kanetonlogariasmo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kanetonlogariasmo.ui.theme.KaneTonLogariasmoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KaneTonLogariasmoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    HomeScreen()
                }
            }
        }
    }
}

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Κάνε τον λογαριασμό!", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(40.dp))
        Button(onClick = { /*TODO*/ }, modifier = Modifier.width(200.dp)) {
            Text(text = "Νέος λογαριασμός")
        }
        Button(onClick = { /*TODO*/ }, modifier = Modifier.width(200.dp)) {
            Text(text = "Ιστορικό")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    KaneTonLogariasmoTheme {
        HomeScreen()
    }
}