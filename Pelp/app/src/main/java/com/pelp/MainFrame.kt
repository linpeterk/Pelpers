package com.pelp


import android.content.Context
import android.location.Address
import android.location.Geocoder
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import java.io.IOException
import java.util.*


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
private const val TAG = "MapSampleActivity"

val destList = listOf(caliMuseum, toyDistrict, brew,dodgerS,church)
val destObject = mutableListOf<LocationsExample>()
val strName = listOf("Japanese American National Museum " , "Toy District", "Brewery", "Dodger Stadium","Our Lady Queen of Angels" )
var cardCount:MutableState<Int> = mutableStateOf(destObject.count())

fun init(){
    for (i in destList.indices){
        var a:LocationsExample = LocationsExample(strName[i], destList[i])
        destObject.add(a)
    }
}
@Composable
fun MainScreen(){
    cardCount =  remember {  mutableStateOf(destObject.count()) }

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
                .weight(0.15f)

            ){
                MenuTab()
            }


            Box(modifier = Modifier
                .weight(0.8f)

            ){
                MakeScrollComponents()
            }
        }

    }

}

@Preview
@Composable
fun PreviewMainFrame()
{
    Box(modifier = Modifier

        .fillMaxWidth(5f)
    ){
        MenuTab()
    }
}

@Composable
fun MenuTab(){
    Box(modifier = Modifier

    ) {
        Row(
            modifier = Modifier
                .horizontalScroll(rememberScrollState())

        ) {
            Spacer(modifier = Modifier.width(10.dp))
            Column(modifier = Modifier
                .padding(horizontal = 15.dp)


            ) {
                FloatingActionButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.scale(.7F),
                    backgroundColor = MaterialTheme.colors.surface
                ) {
                    Image(
                        painter = painterResource(R.drawable.sort_down),
                        contentDescription = "Sort!",
                        modifier = Modifier
                            .background(Color.Transparent)
                            .scale(.5F)
                    )

                }
                //Text(text = "Hello")
            }

          //  Spacer(modifier = Modifier.width(25.dp))

            Column(modifier = Modifier
                .padding(horizontal = 15.dp)


            ) {
                FloatingActionButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.scale(.7F),
                    backgroundColor = MaterialTheme.colors.surface
                ) {
                    Image(
                        painter = painterResource(R.drawable.runer_silhouette_running_fast),
                        contentDescription = "Emergency!",
                        modifier = Modifier
                            .background(Color.Transparent)
                            .scale(.5F)

                    )
                }
                //Text(text = "Hello")
            }



            Column(modifier = Modifier
                .padding(horizontal = 15.dp )

            ) {
                FloatingActionButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.scale(.7F),
                    backgroundColor = MaterialTheme.colors.surface
                ) {
                    Image(
                        painter = painterResource(R.drawable.check),
                        contentDescription = "Expert Verified!",
                        modifier = Modifier
                            .background(Color.Transparent)
                            .scale(.5F)
                    )
                }
                //Text(text = "Hello")
            }



            Column(modifier = Modifier
                .padding(horizontal = 15.dp )
                ) {
                FloatingActionButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.scale(.7F),
                    backgroundColor = MaterialTheme.colors.surface
                ) {
                    Image(
                        painter = painterResource(R.drawable.share),
                        contentDescription = "Expert Verified!",
                        modifier = Modifier
                            .background(Color.Transparent)
                            .scale(.5F)
                    )
                }
                //Text(text = "Hello")
            }



            Column(modifier = Modifier
                .padding(horizontal = 15.dp )
                ) {
                FloatingActionButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.scale(.7F),
                    backgroundColor = MaterialTheme.colors.surface
                ) {
                    Image(
                        painter = painterResource(R.drawable.profile_user),
                        contentDescription = "Profile!",
                        modifier = Modifier
                            .background(Color.Transparent)
                            .scale(.5F)
                    )
                }
                //Text(text = "Hello")
            }
            Column(modifier = Modifier
                .padding(horizontal = 15.dp )
               ) {
                FloatingActionButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.scale(.7F),
                    backgroundColor = MaterialTheme.colors.surface
                ) {
                    Image(
                        painter = painterResource(R.drawable.profile_user),
                        contentDescription = "Profile!",
                        modifier = Modifier
                            .background(Color.Transparent)
                            .scale(.5F)
                    )
                }
                //Text(text = "Hello")
            }
        }
    }
}



//val destObject = mutableListOf<LocationsExample>()
@Composable
//pass in true if you want to make markers
fun MakeGoogleMap( makeMarker: Boolean = false, obj:MutableList<LocationsExample> = destObject){
    cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(caliMuseum, 15f)
    }
    val contex=LocalContext.current

    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState!!,
        onMapLoaded = {},
        onPOIClick = {
            Log.d(TAG, "POI clicked: ${it.name}")
        },
        onMapLongClick = {
            Log.d(TAG, "lat is : ${it.latitude}")
            var str:String =  reverseGeocoder(contex, it.latitude, it.longitude)
            var a:LocationsExample = LocationsExample( str, LatLng(it.latitude, it.longitude))
            destObject.add(a)

            cardCount.value++

        }


    ) {
        if(makeMarker)
            makeMarkers(obj)


    }
}

fun reverseGeocoder(context:Context, lat:Double, lng:Double):String{

    val mGeocoder = Geocoder(context, Locale.getDefault())
    var addressString= ""

    // Reverse-Geocoding starts
    try {
        val addressList: List<Address> = mGeocoder.getFromLocation(lat, lng, 1)

        // use your lat, long value here
        if (addressList != null && addressList.isNotEmpty()) {
            val address = addressList[0]
            var sb:String =""


            return address.getAddressLine(0)

            // Various Parameters of an Address are appended
            // to generate a complete Address
//            if (address.premises != null)
//                sb.append(address.premises).append(", ")
//
//            sb.append(address.subAdminArea).append("\n")
//            sb.append(address.locality).append(", ")
//            sb.append(address.adminArea).append(", ")
//            sb.append(address.countryName).append(", ")
//            sb.append(address.postalCode)

            // StringBuilder sb is converted into a string
            // and this value is assigned to the
            // initially declared addressString string.
            addressString = sb.toString()

        }
    } catch (e: IOException) {
        Toast.makeText(context,"Unable connect to Geocoder",Toast.LENGTH_LONG).show()
    }

    // Finally, the address string is posted in the textView with LatLng.
    return addressString

}
//marketCount not in used, make marker base on size of init destObject
@Composable
fun makeMarkers(list:MutableList<LocationsExample> = destObject){

    val markerClick: (Marker) -> Boolean = {
        false
    }
    if(cardCount.value>0){}
    for (obj in list){
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
   // val context = LocalContext.current
   // var textFieldCount by remember { mutableStateOf (destObject.count()) }

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
            var  destObjSize:Int
            if(destObject.count()>0){
            destObjSize=destObject.count()-1}else destObjSize = 0
            repeat(
               times= cardCount.value,

            ) {
                Card(
                    modifier = Modifier
                        .height(40.dp)
                        .clickable(onClick = {
                            cameraPositionState!!.position =
                                CameraPosition.fromLatLngZoom(destObject[destObjSize - it].loc, 15f)

                        }),


                    // .fillMaxWidth()

                ) {
                    Text(
                        text=destObject[destObjSize-it].name,
                        modifier = Modifier
                            .border(4.dp, Color.LightGray)
                            .background(Color.White)
                            .padding(5.dp)
                            .fillMaxWidth()

                            ,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center


                    )
                }
                Card(
                    modifier = Modifier
                        .height(128.dp)
                        //Toast.makeText(context, "TestA", Toast.LENGTH_LONG) toast syntax
                        .clickable(onClick = {
                            cameraPositionState!!.position =
                                CameraPosition.fromLatLngZoom(destObject[destObjSize - it].loc, 15f)
                        }),

                    shape = RoundedCornerShape(3.dp)

                    // .fillMaxWidth()

                ) {
                    Text(
                        text="Stuff about ${destObject[destObjSize-it].name} ETC",
                        modifier = Modifier
                            .border(4.dp, Color.LightGray)
                            .background(Color.White)
                            .padding(14.dp)
                            .fillMaxWidth()

                    )
                }
            }
        }
    }
}