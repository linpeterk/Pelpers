package com.pelp.model.data

import android.util.Log
import com.google.android.gms.maps.model.LatLng
import com.pelp.R

val caliMuseum = LatLng(34.05, -118.24)
val toyDistrict = LatLng(34.047, -118.243)
val brew = LatLng(34.051, -118.234)
val dodgerS = LatLng(34.073, -118.241)
val church = LatLng(34.05693923331048, -118.23957346932366)

class Location_Restroom (val name:String = "", var loc:LatLng) {

    val reviewArray:ArrayList<Review> = ArrayList<Review>()
    val image_URL:ArrayList<Int> = ArrayList<Int>()
    val userIMG_URL:ArrayList<Int> = ArrayList<Int>()
    init{
        reviewArray.add(Review("Peter", restroomLoc=loc, "The best bathroom in town"))
        reviewArray.add(Review("Carlos", loc, "It's craptacular"))
        reviewArray.add(Review("Lyle", loc, "Would poop here again"))
        reviewArray.add(Review("Aidan", loc, "Risky Business"))


        addImage(R.drawable.urbanbathroom)
        addImage(R.drawable.handicap)
        addImage(R.drawable.cleanbathroom1)
        addPeopleImage(R.drawable.man)
        addPeopleImage(R.drawable.old_lady)
        addPeopleImage(R.drawable.girl)
        addPeopleImage(R.drawable.weird_hair)

    }

    fun addReview(userName:String, review:String){
        reviewArray.add(Review(userName, loc, review))
    }

    fun addImage(reviewImage:Int){
       image_URL.add(reviewImage)
    }
    fun addPeopleImage(reviewImage:Int){
        userIMG_URL.add(reviewImage)
    }


}
