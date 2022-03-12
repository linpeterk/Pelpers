package com.pelp
import com.google.android.gms.maps.GoogleMap



import android.util.Log
import android.widget.Toast
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
import com.google.maps.android.compose.CameraPositionState
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
var cameraPositionState:CameraPositionState?=null
val caliMuseum = LatLng(34.05, -118.24)
val toyDistrict = LatLng(34.047, -118.243)
val brew = LatLng(34.051, -118.234)
val dodgerS = LatLng(34.073, -118.241)
val church = LatLng(34.05693923331048, -118.23957346932366
)

val destList = listOf(caliMuseum, toyDistrict, brew,dodgerS,church)

@Composable
fun MainScreen(){
    cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(caliMuseum, 15f)
    }
    Box(modifier = Modifier
        .fillMaxSize()
        .fillMaxHeight()
        .fillMaxWidth()
    ){
        Column() {
            Box(modifier = Modifier
                .weight(1f)

            ) {


                GoogleMap(
                    modifier = Modifier.fillMaxSize(),
                    cameraPositionState = cameraPositionState!!,
                    onMapLoaded = {}
                ) {
                    makeMarkers()

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

    val markerClick: (Marker) -> Boolean = {
        false
    }
    Marker(
        position = caliMuseum,
        title = "Japanese American National Museum",
        snippet = "Marker in California",
        onClick = markerClick
    )
    Marker(
        position = toyDistrict,
        title = "California",
        snippet = "Marker in California",
        onClick = markerClick
    )

    Marker(
        position = brew,
        title = "California",
        snippet = "Marker in California",
        onClick = markerClick
    )
    Marker(
        position = dodgerS,
        title = "California",
        snippet = "Marker in California",
        onClick = markerClick
    )
    Marker(
        position = church,
        title = "California",
        snippet = "Marker in California",
        onClick = markerClick
    )
}

@Composable
fun repeatCard()
{

}

@Composable
fun testingScrolls(){

    var scrollState:ScrollState =  rememberScrollState()
    val context = LocalContext.current
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
          var  count:Int=0;
            repeat(
               times= destList.size,
             //   action = { i:Int-> return count=i }
            ) {
                Card(
                    modifier = Modifier
                        .height(40.dp)
                        .clickable(onClick = { cameraPositionState!!.position=CameraPosition.fromLatLngZoom(caliMuseum, 15f) } ),


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
                            .clickable { cameraPositionState!!.position=CameraPosition.fromLatLngZoom(caliMuseum, 15f) }
                    )
                }
                Card(
                    modifier = Modifier
                        .height(128.dp)
                                //Toast.makeText(context, "TestA", Toast.LENGTH_LONG) toast syntax
                    .clickable(onClick = { cameraPositionState!!.position=CameraPosition.fromLatLngZoom(caliMuseum, 15f) } ),
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
                            .clickable(onClick = { cameraPositionState!!.position=CameraPosition.fromLatLngZoom(caliMuseum, 15f) })
                    )
                }
            }
        }
    }
}