package com.pelp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.pelp.ui.theme.PelpTheme
import Examples.*

class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Database.data.init() // Don't Comment this out! it's in database
        setContent {
             // Don't Comment this out!
            // A surface container using the 'background' color from the theme



            PelpTheme {
                navController = rememberNavController()
                SetupNavGraph(navController = navController)

            }


            //SquareImage (navController, 2)
        //   SetupNavGraph(navController = navController)


           // MainScreen(navController = navController)
            // A surface container using the 'background' color from the theme
//            navController = rememberNavController()
//            SetupNavGraph(navController = navController)
//            ExpertReview()
           // LandingPageScreen(navController = navController)
            // testingScrolls()
//            searchAddress()
     //   SquareImage(navController = navController, addressLoc =2 )
     //       emergency(navController = navController)


            //MainScreen()

//            SortScreen()

   //         SquareImage (navController, 2)


            //LoginScreen(navController)
          //  ProfileScreen(navController = navController)



        }
    }
}

