package com.revature.mvvmcomposev1.data.model

//this is how the server will send the data (in from the JSON)
//the server api will give you a key to be able to use the data
data class MovieResponse(
    var page:String,
    var result:List<MovieItem>
)