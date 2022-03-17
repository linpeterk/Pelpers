package com.revature.mvvmcomposev1.utils

//hard coded fixed values

class Constants {

    //this is similar to the static keyword in Java, can call the class name and itll grab all class members
    //call the companion object with out creating an instance of the class (Constants.BASE_IMAGE_URL)
    //since this is something that the user will not see it can be classified as a 'constant'
    //constants always stored in one single file
    //*this is calling the images from the online server*
    companion object{

        val BASE_IMAGE_URL ="https://image.tmdb.org/t/p/w500/"

    }
}