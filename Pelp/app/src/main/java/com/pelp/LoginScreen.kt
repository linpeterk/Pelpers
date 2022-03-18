package com.pelp

import android.util.Log
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.keyframes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.pelp.model.data.loginAnimation
import com.pelp.ui.theme.lightBlue


@Composable
fun LoginScreen(
    navController: NavController ,
) {
    var userName by rememberSaveable { mutableStateOf("")}
    Log.d(Examples.TAG,"Hello from Login")
    var alert by rememberSaveable { mutableStateOf(false)}
    var sizeState by remember { mutableStateOf(0.dp) }
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(5.dp)) {

        Surface(
            modifier = Modifier.size(60.dp),
            shape = CircleShape
        ) {

            Image(
                painter = painterResource(id = R.drawable.sea),
                contentDescription = "Sea World",
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
            )


        }
        Spacer(modifier = Modifier.padding(10.dp))
        Text(text="Disclaimers and privacy policy. There are words below, and here are some more words. There are words above too",
            fontSize = 11.sp,
            modifier = Modifier
                .height(50.dp)
                .width(300.dp),
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Light
            )

        var result by rememberSaveable {mutableStateOf("admin/admin")}

        var password by rememberSaveable {mutableStateOf("")}
        Surface(
            shape = RoundedCornerShape(3.dp)
        ) {
            OutlinedTextField(
                value = userName,
                onValueChange = { userName = it },
                shape = RoundedCornerShape(3.dp),
                label = { Text(text = "User Name") },
                modifier = Modifier.width(350.dp)

                )

        }
        Surface(
            shape = RoundedCornerShape(3.dp)
        ) {
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                shape = RoundedCornerShape(3.dp),
                label = { Text(text = "Password") },
                modifier = Modifier.width(350.dp)
                )
        }
        Surface(
            shape = RoundedCornerShape(3.dp), modifier = Modifier.padding(10.dp)

        ) {


            Button(onClick = {
                if(Database.data.loginVerify(userName, password)){
                  //  alert = true
                    sizeState += 450.dp
             //   navController.navigate(route=Screen.Main.route)
                }
              else{
                    result= "These credential does not match our record"
                }
            {
            //    popUpTo(Screen.Main.route){
            //        inclusive=true

         //       }
            }
                             }, modifier = Modifier
                .width(350.dp)
                .height(50.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = lightBlue)

            ){
                Text(text = "Log in with Email", modifier = Modifier.padding(2.dp),color=Color.White)
            }

        }
        Text(text=result)
       Spacer(modifier = Modifier.padding(100.dp))
        Row() {
            Text(
                text = "Already have a Pelp Account?",
                fontSize = 15.sp,
                modifier = Modifier
                    .height(50.dp)
                    .width(220.dp),
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Normal
            )
            Button(onClick = {
                             navController.navigate(Screen.Signup.route)
            }, modifier = Modifier
                .height(40.dp)
                .width(100.dp)
                ,
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red)

            ){
                Text(text = "Sign Up", modifier = Modifier.padding(2.dp),color=Color.White)
            }

        }
    }
/*
    if(alert) {
        alert = false
        loginAnimation(sizeState)
    }
    else {
        loginAnimation()
    }

 */

    val size by animateDpAsState(targetValue = sizeState,
        keyframes {
            durationMillis = 4000
            sizeState at 0 with FastOutLinearInEasing
            sizeState * 1.5f at 1000 with FastOutLinearInEasing
            sizeState * 2f at 4000

        }
    )

Log.d(Examples.TAG, "Size is $size")
    if(size>800.dp) {
        navController.navigate(Screen.Main.route) {
            popUpTo(Screen.Main.route) {
                //           inclusive=true
            }
        }
    }

        Box(
            modifier = Modifier
                .size(size)
                .background(Color.Red)
                .wrapContentSize(),

            contentAlignment = Alignment.Center

        ) {
            Text(
                text = "Welcome $userName!", modifier = Modifier
                    .fillMaxWidth(),
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                fontStyle= FontStyle.Normal,
                color = Color.White,
                textAlign = TextAlign.Center
               )

        }


}