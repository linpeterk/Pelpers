package com.pelp

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp



@Composable
fun MainScreen(){
    Box(modifier = Modifier.fillMaxSize()){

        Image(
            painter = painterResource(id = R.drawable.fakemap), contentDescription = "Fake_Map",
                    modifier = Modifier
                    .fillMaxSize()
        )
        TopAppBar(title= { }, Modifier.height(20.dp))

    }
    testingScrolls()


}




@Composable
fun testingScrolls(){

    //val gradient = Brush.verticalGradient(0f to Color.Gray, 1000f to Color.White)
    Box(
        modifier = Modifier
            .background(Color.Transparent)
            .verticalScroll(rememberScrollState())
            .padding(5.dp)
            .offset(y = 500.dp)

    ) {

        Column {

            repeat(10) {
                Card(
                    modifier = Modifier
                        .height(40.dp),
                    shape = RoundedCornerShape(3.dp)
                    // .fillMaxWidth()

                ) {
                    Text(
                        "Title Bar",
                        modifier = Modifier
                            .border(4.dp, Color.LightGray)
                            .background(Color.White)
                            .padding(5.dp)
                            .height(20.dp)
                            .fillMaxWidth()
                    )
                }
                Card(
                    modifier = Modifier
                        .height(128.dp),
                    shape = RoundedCornerShape(3.dp)
                    // .fillMaxWidth()

                ) {
                    Text(
                        "Generate Stuff Here",
                        modifier = Modifier
                            .border(4.dp, Color.LightGray)
                            .background(Color.White)
                            .padding(24.dp)
                            .height(150.dp)
                            .fillMaxWidth()
                    )
                }
            }
        }
    }
}