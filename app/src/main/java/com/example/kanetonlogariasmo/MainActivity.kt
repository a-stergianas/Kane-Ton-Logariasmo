package com.example.kanetonlogariasmo

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kanetonlogariasmo.ui.theme.Brown_Dark
import com.example.kanetonlogariasmo.ui.theme.Brown_Lighter
import com.example.kanetonlogariasmo.ui.theme.KaneTonLogariasmoTheme
import com.example.kanetonlogariasmo.ui.theme.font

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen()
        }
    }
}

@Composable
fun HomeScreen() {
    Image(
        painter = painterResource(id = R.drawable.background),
        contentDescription = "background",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxSize()
            .blur(radius = 16.dp)
    )
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            painter = painterResource(id = R.drawable.cropped_icon),
            contentDescription = "logo",
            Modifier
                .width(180.dp)
                .padding(vertical = 40.dp)
        )
        Text(
            text = "Κάνε τον λογαριασμό!",
            fontFamily = font,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White)
        Spacer(modifier = Modifier.height(40.dp))

        val mContext = LocalContext.current
        Button(
            onClick = {
                mContext.startActivity(
                    Intent(mContext, SetupActivity::class.java)
                )
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Brown_Lighter,
                contentColor = Brown_Dark
            ),
            modifier = Modifier
                .width(200.dp)
        ) {
            Text(
                text = "Νέος λογαριασμός",
                fontFamily = font,
                fontWeight = FontWeight.Bold
            )
        }
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Brown_Lighter,
                contentColor = Brown_Dark
            ),
            modifier = Modifier
                .width(200.dp)
        ) {
            Text(
                text = "Ιστορικό",
                fontFamily = font,
                fontWeight = FontWeight.Bold
            )
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