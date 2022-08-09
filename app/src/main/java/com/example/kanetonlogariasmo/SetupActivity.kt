package com.example.kanetonlogariasmo

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kanetonlogariasmo.ui.theme.*

class SetupActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SetupScreen()
        }
    }
}

@Composable
fun SetupScreen() {
    Scaffold(
        topBar = {
            val context = LocalContext.current
            TopAppBar(
                title = {
                    Text(
                        text = "Άτομα",
                        fontFamily = font,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 68.dp),
                        textAlign = TextAlign.Center
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        Toast.makeText(context, "Back", Toast.LENGTH_SHORT).show()
                    }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "back button")
                    }
                },
                backgroundColor = Brown,
                contentColor = Color.White
            )
        }
    ) {
        Image(
            painter = painterResource(id = R.drawable.wood),
            contentDescription = "wood",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .blur(radius = 16.dp)
        )
        TextButton(
            onClick = { /*TODO*/ }
        ) {
            Text(
                text = "+ Προσθήκη ατόμου",
                fontFamily = font,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = Brown_Lighter,
                fontSize = 20.sp
            )

        }

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ){
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Brown_Lighter,
                    contentColor = Brown_Dark
                ),
                modifier = Modifier
                    .width(240.dp)
            ) {
                Text(
                    text = "ΕΠΟΜΕΝΟ",
                    fontFamily = font,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    KaneTonLogariasmoTheme {
        SetupScreen()
    }
}