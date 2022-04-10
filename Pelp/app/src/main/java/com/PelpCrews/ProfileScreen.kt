package com.PelpCrews


import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.PelpCrews.Database.Companion.data
import com.PelpCrews.Database.Companion.userBase
import com.PelpCrews.model.data.Review


@Composable
fun ProfileScreen( navController: NavController) {
    var userName:String = who
    val notification = rememberSaveable{ (mutableStateOf("")) }
    var reviewCount = userBase[userName]?.history!!.size
    //val reviewArray:ArrayList<Review> = ArrayList<Review>()
    if (notification.value.isNotEmpty()) {
        Toast.makeText(LocalContext.current, notification.value, Toast.LENGTH_LONG).show()
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
        ) {
        Surface(
            modifier = Modifier
                .size(120.dp)
                .padding(15.dp),
            shape = CircleShape,
        ) {


            val imageUri = rememberSaveable{ mutableStateOf("") }
            val painter = rememberAsyncImagePainter(
                if (imageUri.value.isEmpty())
                    R.drawable.ic_user
                else
                    imageUri.value
            )
            val launcher = rememberLauncherForActivityResult(
                contract = ActivityResultContracts.GetContent()
            ){
                uri: Uri? ->
                uri?.let { imageUri.value = it.toString()}
            }
            Card (
                shape = CircleShape,
                modifier = Modifier
                    .padding(8.dp)
                    .size(100.dp)
            ) {
                Image (
                    painter = painter,
                    contentDescription = null,
                    modifier = Modifier
                        .wrapContentSize()
                        .clickable { launcher.launch("image/*") },
                    contentScale = ContentScale.Crop
                )
            }
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Surface(
            modifier = Modifier,
            color = Color.White
        ) {
            Text(text = "User: ${Database.data.getName(userName)}",
                 color = Color.Black)
        }
        Surface(
            modifier = Modifier,
            color = Color.White
        ) {
            Text(text = "Password: ${Database.data.getPass(userName)}",
                color = Color.Black)
        }
        Surface(
            modifier = Modifier,
            color = Color.White
        ) {
            Text(text = "Home Zip Code: ${Database.data.getZip(userName)}",
                color = Color.Black)
        }
        Surface (
            modifier = Modifier,
            color = Color.White
        ) {
            Text(text = "Recent History",
                 color = Color.Black,
                 style = MaterialTheme.typography.h4)
        }/*
        Surface  {
            Text(text = userBase[userName]?.history?.get(1)?.comments.toString())
        }*/
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())

        ) {
            iterate(historyList = userBase[userName]?.history!!, userName = userName)


        }
    }
}

@Composable
fun iterate(historyList: MutableList<Review>, userName: String) {
    for (i in historyList.indices) {
        reviewCard(loc = data.getLocName(userBase[userName]?.history?.get(i)!!.restroomLoc),
                   comments = userBase[userName]?.history?.get(i)?.comments.toString())
    }
}

@Composable
fun reviewCard(loc:String, comments:String) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = MaterialTheme.shapes.medium,
        elevation = 5.dp,
        backgroundColor = MaterialTheme.colors.surface
    ) {
        Column(Modifier.padding(8.dp)) {
            Text (
                text = loc,
                style = MaterialTheme.typography.h6,
                color = MaterialTheme.colors.onSurface,
            )
            Text(
                //text = location,
                text = comments,
                style = MaterialTheme.typography.body2,
            )/*
            Text(
                text = comments,
                style = MaterialTheme.typography.body1,
            )*/
        }
    }
}
