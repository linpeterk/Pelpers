package com.pelp
import com.google.android.gms.maps.GoogleMap



import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState

/*
        Image(
            painter = painterResource(id = R.drawAable.fakemap), contentDescription = "Fake_Map",
                    modifier = Modifier
                    .fillMaxSize()
        )
        TopAppBar(title= { }, Modifier.height(20.dp))
*/
@Composable
fun MainScreen(){

    Box(modifier = Modifier
        .fillMaxSize()
        .fillMaxHeight()
        .fillMaxWidth()
    ){
        Column() {
            Box(modifier = Modifier
                .weight(1f)

            ) {
                val hit = LatLng(34.05, -118.24)
                val cali = LatLng(34.05, -118.24)
                val cameraPositionState = rememberCameraPositionState {
                    position = CameraPosition.fromLatLngZoom(cali, 15f)
                }
                GoogleMap(
                    modifier = Modifier.fillMaxSize(),
                    cameraPositionState = cameraPositionState
                ) {
                    val markerClick: (Marker) -> Boolean = {

                        false
                    }

                    Marker(
                        position = hit,
                        title = "California",
                        snippet = "Marker in California",
                        onClick = markerClick
                    )

                }

            }
            Box(modifier = Modifier
                .weight(0.8f)

            ){
                testingScrolls()
            }
        }

    }

}

@Composable
fun makeMarkers(){
    val hit = LatLng(34.25, 118.24)
    Marker(
        position = hit,
        title = "California",
        snippet = "Marker in California",


    )
}



@Composable
fun testingScrolls(){
    var scrollState:ScrollState =  rememberScrollState()
    //val gradient = Brush.verticalGradient(0f to Color.Gray, 1000f to Color.White)
    Box(

        modifier = Modifier
            //  .background(Color.Black)
            .padding(5.dp)
            .fillMaxHeight(1f)
            // .offset(y=300.dp)
            .verticalScroll(scrollState),
        // .offset(y = 500.dp)

    ) {

        Column (
            modifier = Modifier
                //.verticalScroll(rememberScrollState())

                ) {

            repeat(10) {
                Card(
                    modifier = Modifier
                        .height(40.dp),
                    shape = RoundedCornerShape(3.dp),

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