package com.revature.mvvmcomposev1.data.model

//this is the base data class which sets the data types to a variable but not yet declared
data class MovieItem (
    var backdrop_path:String,
    var id:String,
    var original_title:String,
    var overview:String,
    var poster_path:String,
    var release_date:String,
    var title:String?, //elvis operator is used when you are not sure if the data will come from the server
    var votes_average:String,
        )