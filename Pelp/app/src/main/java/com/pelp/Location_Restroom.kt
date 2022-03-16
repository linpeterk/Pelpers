package com.pelp

import com.google.android.gms.maps.model.LatLng

class Location_Restroom (val name:String = "", var loc:LatLng) {

    val reviewArray:ArrayList<Review> = ArrayList<Review>()
    val image_URL:ArrayList<String> = ArrayList<String>()
    init{
        reviewArray.add(Review("Peter", restroomLoc=loc, "The best bathroom in town"))
        reviewArray.add(Review("Carlos", loc, "It's craptacular"))
        reviewArray.add(Review("Lyle", loc, "Would poop here again"))
        reviewArray.add(Review("Aidan", loc, "Risky Business"))
    }

    fun addReview(userName:String, review:String){
        reviewArray.add(Review(userName, loc, review))
    }

}