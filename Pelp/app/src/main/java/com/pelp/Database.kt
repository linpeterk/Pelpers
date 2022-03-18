package com.pelp

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import com.google.android.gms.maps.model.LatLng
import com.pelp.model.data.Location_Restroom
import com.pelp.model.data.*
import java.util.Collections.reverse
import kotlin.collections.LinkedHashMap
//store restroom location data
//var dataBase: LinkedHashMap<LatLng, Location_Restroom> = LinkedHashMap()

//store customers user
//var  userBase:LinkedHashMap<String, Person> = LinkedHashMap()
 //var arrayKeys: MutableList<LatLng> = mutableListOf()

////val strName = listOf("Japanese American National Museum " , "Toy District", "Brewery", "Dodger Stadium","Our Lady Queen of Angels" )
private const val TAG = "DatabaseFile"

class Database(){

    companion object{

        val data = Database()
        var dataBase: LinkedHashMap<LatLng, Location_Restroom> = LinkedHashMap()
        var userBase:LinkedHashMap<String, Person> = LinkedHashMap()

        var arrayKeys: MutableList<LatLng> = mutableListOf() // Not used

    }

    fun init(){
        /*
        Initalize some plebs
         */
        customerAdd("peter", "12345", "KC", 90001)
        customerAdd("carlos", "12345", "carlos", 90002)
        customerAdd("lyle", "12345", "lyle", 90003)
        customerAdd("aidan", "12345", "aidan", 90004)
        customerAdd("admin", "admin", "admin", 90005)

        /*
        initalize some poopers
         */
        addRestroom(caliMuseum, "Japanese American National Museum")
        addRestroom(toyDistrict, "Toy District K9")
        addRestroom(brew, "Cool Brewery")
        addRestroom(dodgerS, "Dodger Stadium")
        addRestroom(church, "Our Lady Queen of Angels")

        /*

         Paid Reviews

         */

        addReviewPersonRest("peter", caliMuseum, "The Best Restroom in Town", personImage = R.drawable.man,restRoomImage = R.drawable.cleanbathroom1 )
        addReviewPersonRest("carlos", caliMuseum, "It's Craptacular", personImage = R.drawable.weird_hair,restRoomImage = R.drawable.urbanbathroom )
        addReviewPersonRest("lyle", caliMuseum, "Would poop here again", personImage = R.drawable.old_lady,restRoomImage = R.drawable.handicap )
        addReviewPersonRest("aidan", caliMuseum, "Bewarn: Risky Business", personImage = R.drawable.girl,restRoomImage = R.drawable.ic_sea_icon_round )

        addReviewPersonRest("peter", toyDistrict, "The Best Restroom in Town", personImage = R.drawable.man,restRoomImage = R.drawable.urbanbathroom )
        addReviewPersonRest("carlos", toyDistrict, "It's Craptacular", personImage = R.drawable.weird_hair,restRoomImage = R.drawable.cleanbathroom1 )
        addReviewPersonRest("lyle", toyDistrict, "Would poop here again", personImage = R.drawable.old_lady,restRoomImage = R.drawable.handicap )
        addReviewPersonRest("aidan", toyDistrict, "Bewarn: Risky Business", personImage = R.drawable.girl,restRoomImage = R.drawable.ic_sea_icon_round )

        addReviewPersonRest("peter", brew, "The Best Restroom in Town", personImage = R.drawable.man,restRoomImage = R.drawable.handicap )
        addReviewPersonRest("carlos", brew, "It's Craptacular", personImage = R.drawable.weird_hair,restRoomImage = R.drawable.urbanbathroom )
        addReviewPersonRest("lyle", brew, "Would poop here again", personImage = R.drawable.old_lady,restRoomImage = R.drawable.cleanbathroom1 )
        addReviewPersonRest("aidan", brew, "Bewarn: Risky Business", personImage = R.drawable.girl,restRoomImage = R.drawable.ic_sea_icon_round )

        addReviewPersonRest("peter", dodgerS, "The Best Restroom in Town", personImage = R.drawable.man,restRoomImage = R.drawable.cleanbathroom1 )
        addReviewPersonRest("carlos", dodgerS, "It's Craptacular", personImage = R.drawable.weird_hair,restRoomImage = R.drawable.urbanbathroom )
        addReviewPersonRest("lyle", dodgerS, "Would poop here again", personImage = R.drawable.old_lady,restRoomImage = R.drawable.handicap )
        addReviewPersonRest("aidan", dodgerS, "Bewarn: Risky Business", personImage = R.drawable.girl,restRoomImage = R.drawable.ic_sea_icon_round )

        addReviewPersonRest("peter", church, "The Best Restroom in Town", personImage = R.drawable.man,restRoomImage = R.drawable.ic_sea_icon_round )
        addReviewPersonRest("carlos", church, "It's Craptacular", personImage = R.drawable.weird_hair,restRoomImage = R.drawable.urbanbathroom )
        addReviewPersonRest("lyle", church, "Would poop here again", personImage = R.drawable.old_lady,restRoomImage = R.drawable.handicap )
        addReviewPersonRest("aidan", church, "Bewarn: Risky Business", personImage = R.drawable.girl,restRoomImage = R.drawable.cleanbathroom1 )

        checkCustomerExist("peter")
        checkCustomerExist("carlos")
        checkCustomerExist("lyle")
        checkCustomerExist("aidan")

        checkRestRoomExist(caliMuseum)
        checkRestRoomExist(toyDistrict)
        checkRestRoomExist(brew)
        checkRestRoomExist(church)
        checkRestRoomExist(caliMuseum)
/*
        dataAdd(caliMuseum, Location_Restroom(name="Japanese American National Museum", caliMuseum))
        dataAdd(toyDistrict, Location_Restroom(name= "Toy District", toyDistrict))
        dataAdd(brew, Location_Restroom(name="Brewery", brew))
        dataAdd(dodgerS, Location_Restroom("Dodger Stadium", dodgerS))
        dataAdd(church, Location_Restroom("Our Lady Queen of Angels", church))

         reviewArray.add(Review("Carlos", loc, "It's craptacular",R.drawable.old_lady))
        reviewArray.add(Review("Lyle", loc, "Would poop here again", R.drawable.girl))
        reviewArray.add(Review("Aidan", loc, "Risky Business", R.drawable.weird_hair))
        reviewArray.add(Review("Peter", restroomLoc=loc, "The best bathroom in town", R.drawable.man))

   addImage(R.drawable.cleanbathroom1)
        addImage(R.drawable.urbanbathroom)
        addImage(R.drawable.handicap)

        customerAdd("peter", "12345", "KC")

        customerAdd("carlo", "12345", "carlo")

        customerAdd("lyle", "12345", "lyle")

        customerAdd("aidan", "12345", "aidan")

        customerAdd("admin", "admin", "admin")

        initReview()
        */

 /*
   reviewArray.add(Review("Carlos", loc, "It's craptacular",R.drawable.old_lady))
        reviewArray.add(Review("Lyle", loc, "Would poop here again", R.drawable.girl))
        reviewArray.add(Review("Aidan", loc, "Risky Business", R.drawable.weird_hair))
        reviewArray.add(Review("Peter", restroomLoc=loc, "The best bathroom in town", R.drawable.man))

  */
    }

   fun addRestroom(locRestRoom: LatLng, restRoomName: String){
       dataAdd(locRestRoom, Location_Restroom(restRoomName, locRestRoom))
   }

    fun customerAdd(name:String, password:String, realName:String, zip:Int = 90001){
        var p = Person(name, realName, password, zip)
        userBase[name] = p

    }

    fun addReviewPersonRest(userName: String, locRestRoom: LatLng, reviewComment: String, personImage: Int, restRoomImage:Int = R.drawable.ic_sea_icon_round){

        var review = Review(customerName = userName, restroomLoc = locRestRoom, comments = reviewComment, imageID = personImage, restRoomID = restRoomImage)

        //add to Location_restroom review list
        dataBase[locRestRoom]?.reviewArray?.add(review)

        //add to restroom images
        dataBase[locRestRoom]?.image_URL?.add(restRoomImage)

        // add to person history list
        customerAddHistory(userName, review)



    }

    fun adminAdd(userName:String, restRoomName:String, password:String, reviewComment:String, locRestRoom:LatLng, realName:String = "johnTEST", restroomImage:Int, personImage:Int = R.drawable.man)
    {
        //add Restroom
        dataAdd(locRestRoom, Location_Restroom(restRoomName, locRestRoom))

        //add Customer
        customerAdd(userName, password, realName)

        var review = Review(userName, locRestRoom, reviewComment, personImage)

        //add to Location_restroom review list

     dataBase[caliMuseum]?.reviewArray?.add(review)
        // add to person history list

     customerAddHistory(userName, review)
    }

    fun addReview(userName:String, loc:LatLng, comments:String){
        val review = Review(userName, loc, comments)
        customerAddHistory(userName, review)
        dataBase[loc]?.reviewArray?.add(review)
    }
    fun loginVerify(userName:String, password:String):Boolean{

        return (userBase[userName]!=null && userBase[userName]?.password ==password)
    }

    fun checkCustomerExist(name:String)
    {
        Log.d("Tag", "Person exist? Name:${userBase[name]?.userName} pass ${userBase[name]?.password} history ${userBase[name]?.history?.get(0)?.comments} image ${userBase[name]?.imageId}")
    }

    fun checkRestRoomExist(locRestRoom: LatLng)
    {
        Log.d("Tag", "Restroom exist? Name:${dataBase[locRestRoom]?.name} comments: ${dataBase[locRestRoom]?.reviewArray?.get(0)?.comments} Image ${dataBase[locRestRoom]?.image_URL?.get(0)}")
    }


    fun dataAdd(loc:LatLng, restR: Location_Restroom){
        dataBase[loc] = restR
        arrayKeys.add(loc)
    }



    private fun customerAddHistory(name:String, review: Review){
        if(userBase[name]!= null )
           userBase[name]?.history?.add(review)

    }

    private fun reverseHashMap(){  //get database key of next iteration, in reverse order
        reverse(arrayKeys)
    }

    fun getKeyFromList(index:Int):LatLng{  //get database key of next iteration, in reverse order
        Log.d(TAG, "ArrayKey size is ${arrayKeys.count()}")
        Log.d(TAG, "index 0 is ${arrayKeys[0]}")
        return arrayKeys[index]
    }
}
