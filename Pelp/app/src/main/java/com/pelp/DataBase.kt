package com.pelp

import android.util.Log
import com.google.android.gms.maps.model.LatLng

val dataBase:HashMap<LatLng, Location_Restroom> = HashMap()

val caliMuseum = LatLng(34.05, -118.24)
val toyDistrict = LatLng(34.047, -118.243)
val brew = LatLng(34.051, -118.234)
val dodgerS = LatLng(34.073, -118.241)
val church = LatLng(34.05693923331048, -118.23957346932366)
////val strName = listOf("Japanese American National Museum " , "Toy District", "Brewery", "Dodger Stadium","Our Lady Queen of Angels" )
private const val TAG = "DatabaseFile"
fun init(){
    /*

    for (i in destList.indices){
        var a:Location_Restroom = Location_Restroom(strName[i], destList[i])
        destObject.add(a)
    }
    */
    add(caliMuseum, Location_Restroom(name="Japanese American National Museum", LatLng(34.05,-118.24)))
    add(toyDistrict, Location_Restroom(name= "Toy District", LatLng(34.047,-118.243)))
    add(brew, Location_Restroom(name="Brewery", LatLng(34.051,-118.234)))
    add(dodgerS, Location_Restroom("Dodger Stadium", LatLng(34.073,-118.241)))
    add(church, Location_Restroom("Our Lady Queen of Angels", LatLng(34.05693923331048,-118.23957346932366)))


}

fun add(loc:LatLng, restR:Location_Restroom){
    dataBase[loc] = restR

}