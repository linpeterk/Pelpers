package com.pelp

import android.util.Log
import com.google.android.gms.maps.model.LatLng
import java.util.*
import java.util.Collections.reverse
import kotlin.collections.LinkedHashMap

val dataBase:LinkedHashMap<LatLng, Location_Restroom> = LinkedHashMap()
 var arrayKeys: MutableList<LatLng> = mutableListOf()

val caliMuseum = LatLng(34.05, -118.24)
val toyDistrict = LatLng(34.047, -118.243)
val brew = LatLng(34.051, -118.234)
val dodgerS = LatLng(34.073, -118.241)
val church = LatLng(34.05693923331048, -118.23957346932366)
////val strName = listOf("Japanese American National Museum " , "Toy District", "Brewery", "Dodger Stadium","Our Lady Queen of Angels" )
private const val TAG = "DatabaseFile"
fun init(){

    add(caliMuseum, Location_Restroom(name="Japanese American National Museum", LatLng(34.05,-118.24)))
    add(toyDistrict, Location_Restroom(name= "Toy District", LatLng(34.047,-118.243)))
    add(brew, Location_Restroom(name="Brewery", LatLng(34.051,-118.234)))
    add(dodgerS, Location_Restroom("Dodger Stadium", LatLng(34.073,-118.241)))
    add(church, Location_Restroom("Our Lady Queen of Angels", LatLng(34.05693923331048,-118.23957346932366)))

  //  arrayKeys= dataBase.keys.toMutableList()
 //   reverseHashMap()
}

fun add(loc:LatLng, restR:Location_Restroom){
    dataBase[loc] = restR
    arrayKeys.add(loc)
}

fun reverseHashMap(){  //get database key of next iteration, in reverse order
    reverse(arrayKeys)
}

fun getKeyFromList(index:Int):LatLng{  //get database key of next iteration, in reverse order
    Log.d(TAG, "ArrayKey size is ${arrayKeys.count()}")
    Log.d(TAG, "index 0 is ${arrayKeys[0]}")
    return arrayKeys[index]
}