package com.pelp

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.pelp.ui.theme.lightBlue

import org.intellij.lang.annotations.JdkConstants


/*
       .drawBehind {
       val path = Path()
       val x = size.width
       val y = size.height
       val center = size.center
       path.apply {
           moveTo(0f, 0f)
           lineTo(x, 0f)
           cubicTo(
                    x,
                center.y/2,
                    x,
                    center.y,
                0f,
                   center.y
                )
           }

           drawPath(path, orange)
       }
       */

@Composable
fun LandingPageScreen(
    navController: NavController
){


    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column(
            Modifier
                .background(Color.White)
        ) {
            Surface(
                modifier = Modifier.size(60.dp),
                shape = CircleShape
            ) {
                Image(
                    painter = painterResource(id = R.drawable.sea),
                    contentDescription = "piece",
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                )
            }

            Text(text = "Welcome to Pelp",
                modifier = Modifier
                    .padding(5.dp)
                    .clickable { },
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.body2
            )


            Text(text = "We know just the place", modifier = Modifier.padding(5.dp))


        }

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column(
                modifier = Modifier
            ) {
                Surface(modifier=Modifier.offset(y=35.dp)) {

                    Box(modifier=Modifier.offset(y=15.dp)){
                        Image(
                            painter = painterResource(id = R.drawable.pelplogo),
                            contentDescription = "Toilet House",
                            modifier = Modifier
                                //    .paddingFromBaseline(bottom = 150.dp)
                                .fillMaxWidth()
                                .clip(RectangleShape)
                                .scale(.7F)
                        )
                    }

                }
                Column(modifier = Modifier.offset(y = 70.dp)) {
                    Text(
                        text = "I agree to Pelp's term of services and confirmed that I have read Pelp's Privacy Policy",
                        modifier = Modifier
                            .padding(5.dp),
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Thin,
                        style = MaterialTheme.typography.subtitle1
                    )
                    //  Spacer(modifier = Modifier.height(150.dp))
                    Row(
                        modifier = Modifier.offset(x = 110.dp, y = 20.dp),
                       // horizontalArrangement = Arrangement.Center y no work
                    ) {
                        Button(
                            onClick = { navController.navigate(route=Screen.Login.route)},
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
                        ) {
                            Text(text = "Log in", modifier = Modifier.padding(5.dp), color = lightBlue)
                        }
                        Button(
                            onClick = { /*TODO*/ },
                            colors = ButtonDefaults.buttonColors(backgroundColor = lightBlue)
                        ) {
                            Text(text = "Sign up", modifier = Modifier.padding(5.dp), color = Color.White)
                        }
                    }
                }

            }


        }


    }
}



@Composable
fun Test(){

}

@Preview
@Composable
fun Previews()
{

    LandingPageScreen(
        navController = rememberNavController()
    )
}
