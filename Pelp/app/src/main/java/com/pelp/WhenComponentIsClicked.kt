package com.pelp

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun Preview(){
    SquareImage ()
}

@Composable
fun SquareImage () {
    TopAppBar(title = {},Modifier.height(60.dp))
    //Spacer(modifier = Modifier.width(4.dp))
    Column(modifier= Modifier
        .fillMaxSize()
        .offset(y = 64.dp)) {
        Row(modifier= Modifier
            .offset(y = 0.dp)
            .horizontalScroll(rememberScrollState())) {

            Card(modifier = Modifier
                .offset(y = 0.dp)
                .fillMaxWidth()
                .padding(4.dp),shape= RoundedCornerShape(15.dp),elevation=5.dp) {
                Box(modifier = Modifier.height(200.dp)){
                    Image(painter = painterResource(id = R.drawable.urbanbathroom),
                        contentDescription ="Urban Bathroom",
                        contentScale = ContentScale.Fit
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(10.dp),
                        contentAlignment = Alignment.BottomCenter){
                        Text(text = "URBAN BATHROOM: Clean Grunge!",style = TextStyle(color = Color.White,fontSize = 16.sp))

                    }
                }
            }

            Card(modifier = Modifier
                .offset(y = 0.dp)
                .fillMaxWidth()
                .padding(4.dp),shape= RoundedCornerShape(15.dp),elevation=5.dp) {
                Box(modifier = Modifier.height(200.dp)){
                    Image(painter = painterResource(id = R.drawable.cleanbathroom1),
                        contentDescription ="Urban Bathroom",
                        contentScale = ContentScale.Fit
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(10.dp),
                        contentAlignment = Alignment.BottomCenter){
                        Text(text = "MODERN PUBLIC: Sterile!",style = TextStyle(color = Color.White,fontSize = 16.sp))

                    }
                }
            }

            Card(modifier = Modifier
                .offset(y = 0.dp)
                .fillMaxWidth()
                .padding(4.dp),shape= RoundedCornerShape(15.dp),elevation=5.dp) {
                Box(modifier = Modifier.height(200.dp)){
                    Image(painter = painterResource(id = R.drawable.handicap),
                        contentDescription ="Urban Bathroom",
                        contentScale = ContentScale.Fit
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(10.dp),
                        contentAlignment = Alignment.BottomCenter){
                        Text(text = "FULL ACCESS: Good Space!",style = TextStyle(color = Color.White,fontSize = 16.sp))

                    }
                }
            }
        }
        Column() {
            Card(modifier = Modifier
                .height(60.dp)
                .offset(y = 10.dp)
                //.border(1.dp, Color.Black)
                .height(10.dp)
                .padding(3.dp)
                .fillMaxWidth(),
                shape = RoundedCornerShape(4.dp),
                Color.LightGray){
                Row() {
                    Column() {
                        FloatingActionButton(onClick = { /*TODO*/ },modifier=Modifier.scale(.8F),backgroundColor = MaterialTheme.colors.surface) {
                            Image(painter = painterResource(R.drawable.sort_down),
                                contentDescription ="Sort!",
                                modifier = Modifier.background(Color.Transparent).scale(.6F))
                        }
                        //Text(text = "Hello")
                    }

                    Spacer(modifier = Modifier.width(25.dp))

                    Column() {
                        FloatingActionButton(onClick = { /*TODO*/ },modifier=Modifier.scale(.8F),backgroundColor = MaterialTheme.colors.surface) {
                            Image(painter = painterResource(R.drawable.check),
                                contentDescription ="Expert Verified!",
                                modifier = Modifier.background(Color.Transparent).scale(.6F))
                        }
                        //Text(text = "Hello")
                    }

                    Spacer(modifier = Modifier.width(25.dp))

                    Column() {
                        FloatingActionButton(onClick = { /*TODO*/ },modifier=Modifier.scale(.8F),backgroundColor = MaterialTheme.colors.surface) {
                            Image(painter = painterResource(R.drawable.runer_silhouette_running_fast),
                                contentDescription ="Emergency!",
                                modifier = Modifier.background(Color.Transparent).scale(.8F))
                        }
                        //Text(text = "Hello")
                    }

                    Spacer(modifier = Modifier.width(25.dp))

                    Column() {
                        FloatingActionButton(onClick = { /*TODO*/ },modifier = Modifier.scale(.8F),backgroundColor = MaterialTheme.colors.surface) {
                            Image(painter = painterResource(R.drawable.share),
                                contentDescription ="Expert Verified!",
                                modifier = Modifier.background(Color.Transparent).scale(.6F))
                        }
                        //Text(text = "Hello")
                    }

                    Spacer(modifier = Modifier.width(20.dp))

                    Column() {
                        FloatingActionButton(onClick = { /*TODO*/ },modifier=Modifier.scale(.8F),backgroundColor = MaterialTheme.colors.surface) {
                            Image(painter = painterResource(R.drawable.profile_user),
                                contentDescription ="Profile!",
                                modifier = Modifier.background(Color.Transparent).scale(.7F))
                        }
                        //Text(text = "Hello")
                    }
                }
                Spacer(modifier = Modifier.height(30.dp))
            }
            Column(modifier=Modifier.verticalScroll(rememberScrollState())) {
                Card(modifier = Modifier
                    .height(300.dp)
                    .offset(y = 9.dp)
                    //.border(2.dp, Color.Black)
                    .padding(10.dp)
                    .fillMaxWidth(),
                    shape = RoundedCornerShape(10.dp),
                    Color.White){
                    Text(text = "Hello")
                }
                Card(modifier = Modifier
                    .height(300.dp)
                    .offset(y = 9.dp)
                    //.border(1.dp, Color.LightGray)
                    .padding(10.dp)
                    .fillMaxWidth(),
                    shape = RoundedCornerShape(10.dp),
                    Color.White){
                    Text(text = "Hello")
                }
                Card(modifier = Modifier
                    .height(300.dp)
                    .offset(y = 9.dp)
                    //.border(2.dp, Color.Black)
                    .padding(10.dp)
                    .fillMaxWidth(),
                    shape = RoundedCornerShape(10.dp),
                    Color.White){
                    Text(text = "Hello")
                }


            }
        }
    }
}