package com.pelp

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.GoogleMap
import com.pelp.ui.theme.lightBlue





@Preview
@Composable
fun PreviewMap(){
    SortScreen()

}

@Composable
fun SortScreen(){

    Box(/*modifier= Modifier.fillMaxSize()*/){
        GoogleMap(modifier=Modifier.fillMaxSize()){

        }

//        Image(painter = painterResource(R.drawable.fakemap), contentDescription ="Fake Map",
//            modifier=Modifier.fillMaxSize())
        TopAppBar(title = {},Modifier.height(60.dp))
    }

    IconBox()
}

@Composable
fun IconBox(){
    Column(){
        Card(modifier = Modifier
            .height(60.dp)
            .offset(y = 444.dp)
            //.border(1.dp, Color.Black)
            .padding(3.dp)
            .fillMaxWidth(),
            shape = RoundedCornerShape(4.dp),
            Color.LightGray){
            Row() {
                Column() {
                    FloatingActionButton(onClick = { /*TODO*/ },modifier=Modifier.scale(.7F),backgroundColor = MaterialTheme.colors.surface) {
                        Image(painter = painterResource(R.drawable.sort_down),
                            contentDescription ="Sort!",
                            modifier = Modifier
                                .background(Color.Transparent)
                                .scale(.5F))
                    }
                    //Text(text = "Hello")
                }

                Spacer(modifier = Modifier.width(25.dp))

                Column() {
                    FloatingActionButton(onClick = { /*TODO*/ },modifier=Modifier.scale(.7F),backgroundColor = MaterialTheme.colors.surface) {
                        Image(painter = painterResource(R.drawable.check),
                            contentDescription ="Expert Verified!",
                            modifier = Modifier
                                .background(Color.Transparent)
                                .scale(.5F))
                    }
                    //Text(text = "Hello")
                }

                Spacer(modifier = Modifier.width(25.dp))

                Column() {
                    FloatingActionButton(onClick = { /*TODO*/ },modifier=Modifier.scale(.7F),backgroundColor = MaterialTheme.colors.surface) {
                        Image(painter = painterResource(R.drawable.runer_silhouette_running_fast),
                            contentDescription ="Emergency!",
                            modifier = Modifier
                                .background(Color.Transparent)
                                .scale(.8F))
                    }
                    //Text(text = "Hello")
                }

                Spacer(modifier = Modifier.width(25.dp))

                Column() {
                    FloatingActionButton(onClick = { /*TODO*/ },modifier = Modifier.scale(.7F),backgroundColor = MaterialTheme.colors.surface) {
                        Image(painter = painterResource(R.drawable.share),
                            contentDescription ="Expert Verified!",
                            modifier = Modifier
                                .background(Color.Transparent)
                                .scale(.5F))
                    }
                    //Text(text = "Hello")
                }

                Spacer(modifier = Modifier.width(25.dp))

                Column() {
                    FloatingActionButton(onClick = { /*TODO*/ },modifier=Modifier.scale(.7F),backgroundColor = MaterialTheme.colors.surface) {
                        Image(painter = painterResource(R.drawable.profile_user),
                            contentDescription ="Profile!",
                            modifier = Modifier
                                .background(Color.Transparent)
                                .scale(.5F))
                    }
                    //Text(text = "Hello")
                }
            }

        }
        Card(modifier = Modifier
            .height(211.dp)
            .offset(y = 445.dp)
            //.border(1.dp, Color.Black)
            .padding(3.dp)
            .fillMaxWidth(),
            shape = RoundedCornerShape(4.dp),
            Color.White){
            val checkedState= remember { mutableStateOf(true) }
            Column() {
                Button(
                    onClick = {
                        //dialogState.value = true
                    },
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = lightBlue)
                ) {
                    Text(
                        text = "Single Click Selection 1",
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )
                }
                Divider(color = Color.Black)
//                Text(
//                    //text = selectedCountry.value,
//                    textAlign = TextAlign.Center,
//                    color = Color.Black
//                )
                Button(
                    onClick = {
                        //dialogState.value = true
                    },
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = lightBlue)
                ) {
                    Text(
                        text = "Single Click Selection 2",
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )
                }
                Divider(color = Color.Black)
//                Text(
//                    //text = selectedCountry.value,
//                    textAlign = TextAlign.Center,
//                    color = Color.Black
//                )
                Button(
                    onClick = {
                        //dialogState.value = true
                    },
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = lightBlue)
                ) {
                    Text(
                        text = "Single Click Selection 3",
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )
                }
                Divider(color = Color.Black)
//                Text(
//                    //text = selectedCountry.value,
//                    textAlign = TextAlign.Center,
//                    color = Color.Black
//                )
            }



        }
    }
}



//@ExperimentalMaterialApi
//@Composable
//fun ExpandableCard(){
//    var expandedState by remember{ mutableStateOf(false)}
//    val rotationState by animateFloatAsState(targetValue = if(expandedState)180f else 0f)
//
//    Card(modifier= Modifier
//        .offset(0.dp,700.dp)
//        .fillMaxWidth()
//        .animateContentSize(
//            animationSpec = tween(
//                durationMillis = 300,
//                easing = LinearOutSlowInEasing
//            )
//        ),
//        shape = Shapes.large,
//        onClick = {
//            expandedState=!expandedState
//        }
//    ) {
//      Column(modifier= Modifier
//          .fillMaxWidth()
//          .padding(12.dp)
//      ) {
//          Row(verticalAlignment = Alignment.CenterVertically) {
//              Text(
//                  modifier=Modifier
//                      .weight(6f),
//                  text="My Title",
//                  fontSize=MaterialTheme.typography.h6.fontSize,
//                  fontWeight= FontWeight.Bold,
//                  maxLines = 1,
//                  overflow = TextOverflow.Ellipsis
//              )
//              IconButton(
//                  modifier= Modifier
//                      .alpha(ContentAlpha.medium)
//                      .weight(1f)
//                      .rotate(rotationState),
//                      onClick = {
//                          expandedState=!expandedState
//                      }) {
//                      Icon(
//                          imageVector = Icons.Default.ArrowDropDown,
//                          contentDescription = "DropDownArrow"
//                      )
//
//              }
//
//          }
//          if(expandedState){
//              Column() {
//                  Text(text = "Choice1")
//                  Text(text = "Choice2")
//                  Text(text = "Choice3")
//                  Text(text = "Choice4")
//              }
//
//          }
//
//      }
//    }
//    Box(modifier=Modifier.fillMaxSize()){
//        Image(painter = painterResource(R.drawable.fakemap), contentDescription ="Fake Map",
//            modifier=Modifier.fillMaxSize()
//        )
//        TopAppBar(title = {},Modifier.height(20.dp))
//    }
//}

//@ExperimentalMaterialApi
//@Preview
//@Composable
//fun ExpandandableCardPreview(){
//    ExpandableCard()
//}