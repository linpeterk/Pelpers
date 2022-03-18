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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.pelp.model.data.Location_Restroom
import com.pelp.model.data.*
import java.io.IOException
import java.util.*

var cameraPositionState:CameraPositionState?=null
var addressGlobal: Location_Restroom = Location_Restroom(loc=LatLng(100.0, 100.0))
private const val TAG = "MapSampleActivity"

//val destList = listOf(caliMuseum, toyDistrict, brew,dodgerS,church)  //List of locations name
//val destObject = mutableListOf<Location_Restroom>() //List of location object
//val strName = listOf("Japanese American National Museum " , "Toy District", "Brewery", "Dodger Stadium","Our Lady Queen of Angels" )


//var cardCount:MutableState<Int> = mutableStateOf(dataBase.count())





@Composable
fun MainScreen(navController: NavController){

   // cardCount =  remember {  mutableStateOf(dataBase.count()) }

    Log.d(Examples.TAG,"Hello from Main")

    Box(modifier = Modifier
        .fillMaxSize()
        .fillMaxHeight()
        .fillMaxWidth()
    ){
        Column() {
            Box(modifier = Modifier
                .weight(1f)

            ) {

              MakeGoogleMap(true, modifier = Modifier.fillMaxSize())

            }

            Box(modifier = Modifier
                .weight(0.15f)

            ){
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
    makeAddressButton()
}


@Composable
fun makeAddressButton(){
    Column(modifier = Modifier
        .offset(x = 132.dp)
        .padding(5.dp)
        .wrapContentSize())
    {

        Box(
            modifier = Modifier
                .wrapContentSize()
                .padding(2.dp),
        ) {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .size(100.dp, 35.dp),
                backgroundColor = Color.Transparent
            ) {
                Text(text="Address", color=Color.DarkGray ,modifier = Modifier, fontStyle = FontStyle.Normal, fontWeight = FontWeight.Bold)
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

    }
}

@Composable
fun MenuTab(navController: NavController){

    Box(modifier = Modifier

    ) {
        Log.d(TAG, "Hello From ")

        Row(
            modifier = Modifier
                .horizontalScroll(rememberScrollState())

        ) {
            Spacer(modifier = Modifier.width(20.dp))
            //Home button
            Column(modifier = Modifier
                .padding(horizontal = 15.dp)


            ) {
                FloatingActionButton(
                    onClick = {navController.navigate(route=Screen.Main.route){
                        popUpTo(Screen.Main.route){
                            inclusive=true
                        }}
                    },
                    modifier = Modifier.scale(.7F),
                    backgroundColor = MaterialTheme.colors.surface
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_sea_icon_round),
                        contentDescription = "Home!",
                        modifier = Modifier
                            .background(Color.Transparent)
                            .scale(.8F)
                    )

                }
                //Text(text = "Hello")  WTF IS THIS?
            }

            // SORT BUTTON HERE
            Column(modifier = Modifier
                .padding(horizontal = 15.dp)


            ) {
                FloatingActionButton(
                    onClick = {navController.navigate(route=Screen.Sort.route){
                        popUpTo(Screen.Sort.route){
                            inclusive=true
                        }}
                    },
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

            // EMERGENCY BUTTON HERE
            Column(modifier = Modifier
                .padding(horizontal = 15.dp)


            ) {

                var test by rememberSaveable { mutableStateOf(0)}

                FloatingActionButton(
                    onClick = {navController.navigate(route=Screen.Emergency.route){
                        popUpTo(Screen.Sort.route){
                            inclusive=true
                        }}
                    },
                    modifier = Modifier.scale(.7F),
                    backgroundColor = MaterialTheme.colors.surface
                ) {
                    Image(
                        painter = painterResource(R.drawable.runer_silhouette_running_fast),
                        contentDescription = "Emergency!",
                        modifier = Modifier
                            .background(Color.Transparent)
                            .scale(.8F)

                    )
                }
                //Text(text = "Hello")
            }



            Column(modifier = Modifier
                .padding(horizontal = 15.dp )

            ) {
                FloatingActionButton(
                    onClick = {navController.navigate(route=Screen.ExpertReview.route){
                        popUpTo(Screen.Sort.route){
                            inclusive=true
                        }}
                    },
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
                        contentDescription = "Share!",
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
                    onClick = { navController.navigate(route=Screen.Profile.route){
                        popUpTo(Screen.Profile.route){
                            inclusive=true
                        }
                    } },
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
fun MakeGoogleMap(
    makeMarker: Boolean = false,
    obj: HashMap<LatLng, Location_Restroom> = Database.dataBase,
    modifier: Modifier
){
    cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(caliMuseum, 15f)
    }
    val contex=LocalContext.current
    var array=Array<Int>(5, init={i->i } )
    var a= arrayOf<Int>()

//
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
            var a: Location_Restroom = Location_Restroom( str, LatLng(it.latitude, it.longitude))
          //  destObject.add(a)

           // dataAdd(a.loc, a)

          //  cardCount.value++ //force refresh

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

          //  addressString = sb.toString()

        }
    } catch (e: IOException) {
        Toast.makeText(context,"Unable connect to Geocoder ${e.message}",Toast.LENGTH_LONG).show()
    }

    // Finally, the address string is posted in the textView with LatLng.
    return addressString

}
//marketCount not in used, make marker base on size of init destObject
@Composable
fun makeMarkers(obj:HashMap<LatLng, Location_Restroom> = Database.dataBase){
    val context = LocalContext.current

    val markerClick: (Marker) -> Boolean = {
    //address.loc=it.position
        false
    }
   // cardCount.value
    Database.dataBase.forEach(){
        Marker(
            position = it.value.loc,
            title = it.value.name,
            snippet = "Marker in ${it.value.name}",
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
fun updateComposable(context:Context)
{

}

fun anotherFunction(){

}

@Composable
fun MakeScrollComponents(navController: NavController){

   // var scrollState:ScrollState =  rememberScrollState()
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
            .verticalScroll(rememberScrollState()),
        // .offset(y = 500.dp)

    ) {

        Column (
            modifier = Modifier
                //.verticalScroll(rememberScrollState())

                ) {
            var  dataBaseIter:Int

            if(Database.dataBase.count()>0){
                dataBaseIter=Database.dataBase.count()-1}else dataBaseIter = 0
            var entry = Database.dataBase.iterator().next()

            var lastLoc = Database.dataBase[Database.data.getKeyFromList(dataBaseIter)]
           // cardCount.value // force update components

            repeat(
               times= Database.dataBase.count()
            ) {
                Spacer(modifier = Modifier.padding(5.dp))
                Card(
                    modifier = Modifier
                        .height(40.dp)
                        .clickable(onClick = {
//                            Log.d(TAG, "Name is ${lastLoc?.name}")
                            cameraPositionState!!.position =
                                CameraPosition.fromLatLngZoom(
                                    Database.data.getKeyFromList(Database.dataBase.count() - 1 - (it % 5)),
                                    15f
                                )
                            //destObject[destObjSize - it].loc
                        }),
                    RoundedCornerShape(15.dp)
                    // .fillMaxWidth()

                ) {
                    Text(
                        text=lastLoc?.name!!,
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
                            Log.d(TAG, "B4address = ${Database.dataBase.count() - 1 - (it % 5)}")

                            //     addressGlobal = dataBase[Database.data.getKeyFromList(dataBase.count()-1-(it%5))]!!
                            //      navController.navigate(Screen.Review.route)
                            navController.navigate(Screen.Review.route + "/${Database.dataBase.count() - 1 - (it % 5)}")
                            //          navController.navigate(Screen.Review.route + "/${"abcdef"}")

                            //Screen.profile_screen.route+"/Peter/1234/5678")

                        }),

                    RoundedCornerShape(15.dp)

                ) {

////////////////////////////////////////////////////////////////

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .border(5.dp, Color.Magenta),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Surface(
                                modifier = Modifier
                                    /*.size(50.dp, 50.dp)*/
                                    .padding(4.dp)
                                    .weight(1f)
                                    .fillMaxHeight()
                                    .border(2.dp, Color.Red)
                                ,
                                /*.border(2.dp, Color.Blue),*/
                                shape = RoundedCornerShape(10.dp)
                            ) {
                                Image(
                                    modifier = Modifier.size(50.dp, 50.dp),
                                    contentScale = ContentScale.Fit,
                                    painter = painterResource(id = R.drawable.ic_sea_icon_round),
                                  //  painter = painterResource(id = restRoomObj?.userIMG_URL?.get(it)!!),
                                    contentDescription = "Urban Bathroom"
                                    /*contentScale = ContentScale.Fit*/
                                )
                            }
                            //  restRoomObj is the current component's location_restroom

                            Box(
                                modifier = Modifier
                                    .weight(0.8f)
                                    .fillMaxHeight()
                                    .border(2.dp, Color.Green)
                                //.border(2.dp, Color.Red),


                            ) {

                             //   Text(text = restRoomObj!!.reviewArray[it].customerName,
                                Text(text = "Things",
                                    color = Color.Black,modifier = Modifier.offset(x=4.dp,y=13.dp))
                                //Spacer(modifier = Modifier.height(30.dp))
                                //  var str: String = dataBase[addressGlobal.loc]?.reviewArray!!.get(it)

                            }
                        }




////////////////////////////////////////////////////////////////////////////
                }

                if((--dataBaseIter)>=0) {
                    lastLoc= Database.dataBase[Database.data.getKeyFromList(dataBaseIter)]
                }
            }
        }
    }
}

@Preview
@Composable
fun prev(){


}