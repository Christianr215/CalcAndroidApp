package com.example.b2bhehe

import android.R.attr.onClick
import android.R.attr.button
import android.R.attr.text
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.b2bhehe.ui.theme.B2bHEHETheme
import androidx.compose.material3.Button
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            B2bHEHETheme { //scaffolding is like a shell to hold
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding).fillMaxSize()) {
                        Greeting(
                            name = "World",
                            modifier = Modifier.padding(innerPadding)
                            //modifiers don't draw anything, just affect how things look
                        )
                        //You can’t call multiple composables there without a parent layout
                        // like Column, Row, or Box.
                        Header(
                            modifier = Modifier.padding(innerPadding)
                        )
                    }
                    //alignment is for children only
                    Box(modifier = Modifier
                        .fillMaxSize() //take all the space willing to give/get, only what parent allows
                    ) { //fills whole screen
                        //padding is just how much extra space between a certain function, avoid overlap
                        PressIt(modifier = Modifier
                            .align(Alignment.Center) //starts out centered
                            .offset(y = (-80).dp)
                        )
                        //for movement, start = right, top = down, end = left, bottom = up
                        //offset is visual shift, padding is layout space, offset works with x y
                        //negative up/left
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true) //preview only runs in the android studio
@Composable //composable makes a function draw something on screen
fun GreetingPreview() {
    B2bHEHETheme {
        Greeting("World")
    }
}

@Composable
fun Header(modifier: Modifier = Modifier){
    Text("Testing", modifier = modifier)
}
@Composable
fun PressIt(modifier: Modifier = Modifier){
    Button(onClick = {

    }, modifier = modifier) { //always make sure your function is actually using it
        Text("Press Me")
    }
}
