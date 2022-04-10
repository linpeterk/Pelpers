package com.PelpCrews

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.maps.android.compose.GoogleMap

@Composable
fun emergency(navController : NavController) {

    Column() {
        Box(/*modifier= Modifier.fillMaxSize()*/){
            GoogleMap(modifier=Modifier.size(400.dp)){

            }
        }
        Box(modifier= Modifier.height(50.dp)) {
            MenuTab(navController)
        }

        Box(modifier = Modifier
            .weight(0.8f)
            .background(MaterialTheme.colors.primaryVariant)
        ){
            MakeScrollComponents(navController)
        }
    }





   
}

