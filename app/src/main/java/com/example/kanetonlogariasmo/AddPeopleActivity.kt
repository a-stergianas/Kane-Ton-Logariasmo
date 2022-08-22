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
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.kanetonlogariasmo.ui.theme.*

//var names = mutableListOf<String>()
val names = mutableStateListOf<String>()
var name: String = ""

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
    val context = LocalContext.current
    val (showDialog, setShowDialog) =  remember { mutableStateOf(true) }

    Scaffold(
        topBar = {
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
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {

            Spacer(modifier = Modifier.height(16.dp))
            for(n in names){
                Row (
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.Top,
                    modifier = Modifier.fillMaxWidth()
                ){
                    Text(
                        text = n,
                        Modifier.width(300.dp),
                        fontFamily = font,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Start,
                        color = Color.White,
                        fontSize = 24.sp
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    IconButton(
                        onClick = {
                            names.remove(n)
                        },
                        modifier = Modifier
                            .size(40.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = null,
                            tint = Brown_Lighter
                        )
                    }
                }
            }

            TextButton(
                onClick = {
                    setShowDialog(true)
                }
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

        AddPersonDialog(
            showDialog,
            setShowDialog,
            onPositiveClick = {
                if(names.contains(name)){
                    Toast.makeText(
                        context,
                        "Ο/Η $name υπάρχει ήδη.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                else{
                    setShowDialog(false)
                    names.add(name)
                }
            }
        )
    }
}

@Composable
fun AddPersonDialog(
    showDialog: Boolean, setShowDialog: (Boolean) -> Unit,
    onPositiveClick: () -> Unit,
) {
    if (showDialog) {
        Dialog(
            onDismissRequest = {
                setShowDialog(false)
            },
            properties = DialogProperties(
                dismissOnClickOutside = true,
                dismissOnBackPress = true,
            )
            ) {
            Card(
                elevation = 8.dp,
                shape = Shapes.medium,
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Όνομα:",
                        fontFamily = font,
                        fontWeight = FontWeight.Bold,
                        color = Brown_Dark,
                        fontSize = 20.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 24.dp, top = 8.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    var text by remember { mutableStateOf(TextFieldValue("")) }

                    OutlinedTextField(
                        value = text,
                        placeholder = { Text("Δώσε όνομα") },
                        textStyle = TextStyle.Default.copy(fontSize = 16.sp),
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Brown_Lighter,
                            cursorColor = Brown_Dark,
                            textColor = Brown_Dark,
                            focusedIndicatorColor = Brown,
                            unfocusedIndicatorColor = Brown,
                        ),
                        onValueChange = { newText ->
                            text = newText
                        }
                    )

                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        TextButton(
                            onClick = {
                                setShowDialog(false)
                            },
                            modifier = Modifier
                                .fillMaxWidth(.5f)
                        ) {
                            Text(
                                text = "ΑΚΥΡΟ",
                                fontFamily = font,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                color = Brown_Dark
                            )
                        }
                        Spacer(modifier = Modifier.width(4.dp))
                        TextButton(
                            onClick = {
                                name = text.text
                                onPositiveClick.invoke()
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Text(
                                text = "ΟΚ",
                                fontFamily = font,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                color = Brown_Dark
                            )
                        }
                    }
                }
            }
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