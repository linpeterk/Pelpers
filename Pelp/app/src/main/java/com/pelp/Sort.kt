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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.GoogleMap
import com.pelp.ui.theme.lightBlue





@Preview
@Composable
fun PreviewMap(){

  //  SortScreen(navController)

}

@Composable
fun SortScreen(navController: NavController){

    Box(/*modifier= Modifier.fillMaxSize()*/){
        GoogleMap(modifier=Modifier.fillMaxSize()){

        }

//        Image(painter = painterResource(R.drawable.fakemap), contentDescription ="Fake Map",
//            modifier=Modifier.fillMaxSize())
        TopAppBar(title = {},Modifier.height(60.dp))
    }

    IconBox(navController)
}

@Composable
fun IconBox(navController: NavController){
    Column(){
        Card(modifier = Modifier
            .height(60.dp)
            .offset(y = 444.dp)
            //.border(1.dp, Color.Black)
            .padding(3.dp)
            .fillMaxWidth(),
            shape = RoundedCornerShape(4.dp),
            Color.LightGray){
            MenuTab(navController)


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



