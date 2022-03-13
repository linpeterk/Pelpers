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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
val destObject = mutableListOf<LocationsExample>()
val strName = listOf("Japanese American National Museum " , "Toy District", "Brewery", "Dodger Stadium","Our Lady Queen of Angels" )
@Composable
fun init(){
    for (i in destList.indices){
        var a:LocationsExample = LocationsExample(strName[i], destList[i])
        destObject.add(a)
    }
}
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

                MakeGoogleMap(true)

            }
            Box(modifier = Modifier
                .weight(0.8f)

            ){
                MakeScrollComponents()
            }
        }

    }

}


@Composable
//pass in true if you want to make markers
fun MakeGoogleMap(makeMarker:Boolean){
    cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(caliMuseum, 15f)
    }
    init()
    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState!!,
        onMapLoaded = {}
    ) {
        if(makeMarker)
        makeMarkers(destObject.count())

    }
}

//marketCount not in used, make marker base on size of init destObject
@Composable
fun makeMarkers(markerCount:Int){

    val markerClick: (Marker) -> Boolean = {
        false
    }
    for (obj in destObject){
        Marker(
            position = obj.loc,
            title = obj.name,
            snippet = "Marker in ${obj.name}",
            onClick = markerClick
        )
    }
    /*
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
    */

}

@Composable
fun repeatCard()
{

}

fun anotherFunction(){

}
@Composable
fun MakeScrollComponents(){

    var scrollState:ScrollState =  rememberScrollState()
    val context = LocalContext.current
    //val gradient = Brush.verticalGradient(0f to Color.Gray, 1000f to Color.White)
    Box(

        modifier = Modifier
            //  .background(Color.Black)
            .fillMaxWidth()
            .fillMaxHeight(1f)
            .padding(5.dp)
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

            ) {
                Card(
                    modifier = Modifier
                        .height(40.dp)
                        .clickable(onClick = { cameraPositionState!!.position=CameraPosition.fromLatLngZoom(destObject[it].loc, 15f) } ),

                    // .fillMaxWidth()

                ) {
                    Text(
                        text=destObject[it].name,
                        modifier = Modifier
                            .border(4.dp, Color.LightGray)
                            .background(Color.White)
                            .padding(5.dp)
                            .height(20.dp)
                            .fillMaxWidth()
                            .clickable { cameraPositionState!!.position=CameraPosition.fromLatLngZoom(destObject[it].loc, 15f) },
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center


                    )
                }
                Card(
                    modifier = Modifier
                        .height(128.dp)
                                //Toast.makeText(context, "TestA", Toast.LENGTH_LONG) toast syntax
                    .clickable(onClick = { cameraPositionState!!.position=CameraPosition.fromLatLngZoom(destObject[it].loc, 15f) } ),
                    shape = RoundedCornerShape(3.dp)

                    // .fillMaxWidth()

                ) {
                    Text(
                        text="Stuff about ${destObject[it].name} ETC",
                        modifier = Modifier
                            .border(4.dp, Color.LightGray)
                            .background(Color.White)
                            .padding(14.dp)
                            .height(150.dp)
                            .fillMaxWidth()
                            .clickable(onClick = { cameraPositionState!!.position=CameraPosition.fromLatLngZoom(destObject[it].loc, 15f) })
                    )
                }
            }
        }
    }
}