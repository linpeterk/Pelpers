package com.pelp

import android.util.Log
import com.google.android.gms.maps.model.LatLng
import com.pelp.model.data.Location_Restroom
import com.pelp.model.data.Person
import com.pelp.model.data.*
import java.util.Collections.reverse
import kotlin.collections.LinkedHashMap
//store restroom location data
var dataBase: LinkedHashMap<LatLng, Location_Restroom> = LinkedHashMap()

//store customers user
var  userBase:LinkedHashMap<String, Person> = LinkedHashMap()
 var arrayKeys: MutableList<LatLng> = mutableListOf()

////val strName = listOf("Japanese American National Museum " , "Toy District", "Brewery", "Dodger Stadium","Our Lady Queen of Angels" )
private const val TAG = "DatabaseFile"
fun init(){

    dataAdd(caliMuseum, Location_Restroom(name="Japanese American National Museum", LatLng(34.05,-118.24)))
    dataAdd(toyDistrict, Location_Restroom(name= "Toy District", LatLng(34.047,-118.243)))
    dataAdd(brew, Location_Restroom(name="Brewery", LatLng(34.051,-118.234)))
    dataAdd(dodgerS, Location_Restroom("Dodger Stadium", LatLng(34.073,-118.241)))
    dataAdd(church, Location_Restroom("Our Lady Queen of Angels", LatLng(34.05693923331048,-118.23957346932366)))

    customerAdd("peter", "12345", "peter")
    customerAddHistory("peter", locationRestroom = dataBase[brew]!!)

    customerAdd("admin", "admin", "admin")
    customerAddHistory("admin", locationRestroom = dataBase[dodgerS]!!)

  // checkCustomerExist("peter")
  //  arrayKeys= dataBase.keys.toMutableList()
 //   reverseHashMap()
}
fun loginVerify(userName:String, password:String):Boolean{

    return (userBase[userName]!=null && userBase[userName]?.password ==password)
}

fun checkCustomerExist(name:String)
{
    Log.d("Tag", "Person exist? Name:${userBase["peter"]?.userName} pass ${userBase["peter"]?.password} history ${userBase["peter"]?.history?.get(0)?.name}")
}
fun dataAdd(loc:LatLng, restR: Location_Restroom){
    dataBase[loc] = restR
    arrayKeys.add(loc)
}

fun customerAdd(name:String, password:String, realName:String, zip:Int = 90001){
    var p = Person(name, realName, password, zip)
   userBase[name] = p

}

private fun customerAddHistory(name:String, locationRestroom: Location_Restroom){
if(userBase[name]!= null )
    userBase[name]?.history?.add(locationRestroom)

}

fun reverseHashMap(){  //get database key of next iteration, in reverse order
    reverse(arrayKeys)
}

fun getKeyFromList(index:Int):LatLng{  //get database key of next iteration, in reverse order
    Log.d(TAG, "ArrayKey size is ${arrayKeys.count()}")
    Log.d(TAG, "index 0 is ${arrayKeys[0]}")
    return arrayKeys[index]
}