package com.pelp.model.data

data class Person(

    var userName:String,
    var realName:String,
    var password:String,
    var zip:Int,
    var history:MutableList<Location_Restroom> = mutableListOf()


)
