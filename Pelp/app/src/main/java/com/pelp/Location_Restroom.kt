package com.pelp

import com.google.android.gms.maps.model.LatLng

class Location_Restroom (val name:String = "", var loc:LatLng) {

    val reviewArray:ArrayList<String> = ArrayList<String>()
    val image_URL:ArrayList<String> = ArrayList<String>()
    init{
        reviewArray.add("Good Review")
        reviewArray.add("Bad Review")
        reviewArray.add("abcdef")
    }

    fun addReview(review:String){
        reviewArray.add(review)
    }

}