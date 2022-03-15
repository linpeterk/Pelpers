package com.pelp

import com.google.android.gms.maps.model.LatLng

data class Person(

    var name:String,
    var password:String,
    var history:MutableList<Location_Restroom> = mutableListOf()


)
