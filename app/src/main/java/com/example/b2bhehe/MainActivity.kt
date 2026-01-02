package com.example.b2bhehe

import android.R
import android.R.attr.onClick
import android.R.attr.button
import android.R.attr.text
import android.os.Bundle
import android.service.autofill.OnClickAction
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.w3c.dom.Text

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
                    /*Box(modifier = Modifier
                        .fillMaxSize() //take all the space willing to give/get, only what parent allows
                    ) { //fills whole screen
                        //padding is just how much extra space between a certain function, avoid overlap
                        PressIt(modifier = Modifier
                            .align(Alignment.Center) //starts out centered
                            .offset(y = (-80).dp)
                        )
                        topRightCounter(modifier = Modifier
                            .align(Alignment.TopEnd)
                            .offset(y = 50.dp)
                        )
                        //for movement, start = right, top = down, end = left, bottom = up
                        //offset is visual shift, padding is layout space, offset works with x y
                        //negative up/left
                    } */
                    Box(modifier = Modifier
                        .fillMaxSize()){
                        centeredBox(modifier = Modifier
                            .align(Alignment.Center)
                        )
                    }

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "C is for Calc",
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
        counter++
    }, modifier = modifier) { //always make sure your function is actually using it
        Text("Press Me")
    }
}

@Composable
fun topRightCounter(modifier: Modifier = Modifier){
    Text(
        counter.toString(),
        modifier = modifier
    )
}

fun getCount() : Int{
    return counter
}
@Composable
fun centeredBox(modifier: Modifier = Modifier){
    Card(modifier = modifier //be sure to reference the actual modifer called, captilization
        .width(260.dp)
        .height(550.dp),
        border = BorderStroke(2.dp, Color.Black)
    ){
        Column(modifier = Modifier.fillMaxSize()){
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                //.background(Color.Black)
            ){
                Text(pressed)
            }
            //divider
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .border(2.dp, Color.Black)
            )

            Box(modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
            ){
                BottomHalfGrid(3,3, labels) //call in our other container for the other half
            }
        }

    }
}
var counter by mutableStateOf(0)
//there are two types to keep track of info. remember and mutableStateOf, mutatable state of just
//keeps track of info to know for the compostible to update
val labels = listOf<String>("9","8","7","6","5","4","3","2","1")
var pressed : String = ""
@Composable
fun BottomHalfGrid(rows: Int, cols: Int, labels: List<String>){
    Column(modifier = Modifier.fillMaxSize()){
        for (r in 0 until rows){
            Row(modifier = Modifier.weight(1f)){
                for (c in 0 until cols){
                    val index = r * cols + c
                    Box(modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .border(2.dp, Color.Black),
                        contentAlignment = Alignment.Center
                    ) {
                        Cell(text = labels[index], onClick = {
                            pressed = labels[index]
                        })
                    }
                }
            }
        }
    }
}
fun Preview(text: String): String { //this is how you change the return type
    return text
}
@Composable
fun Cell(text: String, onClick: () -> Unit, modifier: Modifier = Modifier){
    Box(modifier = Modifier
        .border(2.dp, Color.Black)
        .clickable{ onClick() }
        .padding(12.dp),
        contentAlignment = Alignment.Center
    ){
        Text(text)
    }
}
