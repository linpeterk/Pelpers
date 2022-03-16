package com.pelp

import android.location.Location
import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Preview
@Composable
fun Preview(){

   // SquareImage (navController)
}

@Composable
fun SquareImage (navController: NavController, addressLoc:Int) {
    var restRoomObj = Database.dataBase[Database.data.getKeyFromList(addressLoc)]
    Log.d(Examples.TAG,"AddressLoc is $addressLoc")
   // val locationRestroom = dataBase [addressLoc]
    //TopAppBar(title = {},Modifier.height(60.dp))
    //Spacer(modifier = Modifier.width(4.dp))
    Surface(color = MaterialTheme.colors.primary) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .offset(y = 3.dp)
        ) {
            Row(
                modifier = Modifier
                    .horizontalScroll(rememberScrollState())
            ) {

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp), shape = RoundedCornerShape(15.dp), elevation = 5.dp
                ) {
                    Box(modifier = Modifier.height(200.dp)) {
                        Image(
                            painter = painterResource(id = R.drawable.urbanbathroom),
                            contentDescription = "Urban Bathroom",
                            contentScale = ContentScale.Fit
                        )
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(10.dp),
                            contentAlignment = Alignment.BottomCenter
                        ) {
                            Text(
                                text = "URBAN BATHROOM: Clean Grunge!",
                                style = TextStyle(color = Color.White, fontSize = 16.sp)
                            )

                        }
                    }
                }

                Card(
                    modifier = Modifier
                        .offset(y = 0.dp)
                        .fillMaxWidth()
                        .padding(4.dp), shape = RoundedCornerShape(15.dp), elevation = 5.dp
                ) {
                    Box(modifier = Modifier.height(200.dp)) {
                        Image(
                            painter = painterResource(id = R.drawable.cleanbathroom1),
                            contentDescription = "Urban Bathroom",
                            contentScale = ContentScale.Fit
                        )
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(10.dp),
                            contentAlignment = Alignment.BottomCenter
                        ) {
                            Text(
                                text = "MODERN PUBLIC: Sterile!",
                                style = TextStyle(color = Color.White, fontSize = 16.sp)
                            )

                        }
                    }
                }

                Card(
                    modifier = Modifier
                        .offset(y = 0.dp)
                        .fillMaxWidth()
                        .padding(4.dp), shape = RoundedCornerShape(15.dp), elevation = 5.dp
                ) {
                    Box(modifier = Modifier.height(200.dp)) {
                        Image(
                            painter = painterResource(id = R.drawable.handicap),
                            contentDescription = "Urban Bathroom",
                            contentScale = ContentScale.Fit
                        )
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(10.dp),
                            contentAlignment = Alignment.BottomCenter
                        ) {
                            Text(
                                text = "FULL ACCESS: Good Space!",
                                style = TextStyle(color = Color.White, fontSize = 16.sp)
                            )

                        }
                    }
                }
            }
            Column( ) {
                Card(
                    modifier = Modifier
                        .height(60.dp)
                        .offset(y = 5.dp)
                        //.border(1.dp, Color.Black)
                        .height(10.dp)
                        .padding(3.dp)
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(4.dp),
                    Color.LightGray
                ) {
                    MenuTab(navController)

                    Spacer(modifier = Modifier.height(30.dp))
                }


                Column(modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .border(3.dp, Color.Red)
                ) {
                    repeat(restRoomObj!!.reviewArray.count())
                    {
                        Card(
                            elevation = 10.dp,
                            modifier = Modifier
                                .height(200.dp)
                                .offset(y = 5.dp)
                                //.border(1.dp, Color.LightGray)
                                .padding(10.dp)
                                .fillMaxWidth(),
                            shape = RoundedCornerShape(10.dp),
                            contentColor = Color.White
                        ) {

                            Column() {

                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()

                                ) {
                                    Surface(
                                        modifier = Modifier
                                            /*.size(50.dp, 50.dp)*/
                                            .padding(4.dp)
                                            .border(2.dp, Color.Blue),
                                        shape = RoundedCornerShape(10.dp)
                                    ) {
                                        Image(
                                            modifier = Modifier.size(50.dp, 50.dp),
                                            contentScale = ContentScale.Fit,
                                            painter = painterResource(id = R.drawable.handicap),
                                            contentDescription = "Urban Bathroom"
                                            /*contentScale = ContentScale.Fit*/
                                        )
                                    }
                                    //  restRoomObj is the current component's location_restroom

                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(60.dp)
                                            .border(2.dp, Color.Red),


                                        ) {

                                        Text(text = restRoomObj!!.reviewArray[it].customerName,
                                        color = Color.Black)
                                        //Spacer(modifier = Modifier.height(30.dp))
                                        //  var str: String = dataBase[addressGlobal.loc]?.reviewArray!!.get(it)

                                    }
                                }
                                Card(
                                    modifier = Modifier
                                        .border(3.dp, Color.Green)
                                        .fillMaxSize()
                                ) {
                                    var str: String = restRoomObj?.reviewArray!!.get(it).comments
                                    //  var a:Location_Restroom = dataBase[Brew]!!
                                    //Spacer(modifier = Modifier.height(30.dp))
                                    Text(text = "Location: ${restRoomObj!!.name}  \n \n Reviews:\n $str")
                                }

//                            Card(modifier=Modifier.padding(150.dp,60.dp,150.dp,60.dp).offset(-145.dp,-55.dp)) {
//                                Box() {
//                                    Image(
//                                        painter = painterResource(id = R.drawable.handicap),
//                                        contentScale = ContentScale.FillBounds,
//                                        contentDescription = "Urban Bathroom")
//                                }
//
//                            }

                            }
                        }
                    }

                }
            }
        }
    }
}




