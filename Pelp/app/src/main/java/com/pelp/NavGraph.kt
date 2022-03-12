package com.pelp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun SetupNavGraph(
    navController:NavHostController
){

    NavHost(
        navController = navController,
        startDestination = Screen.Start.route
         ){
        composable(
            route = Screen.Start.route
        ){
            LandingPageScreen( navController = navController)
        }

        composable(
            route = Screen.Login.route
        ){
            LoginScreen(navController = navController)
        }

        composable(
            route = Screen.Main.route
        ){
            MainScreen()
        }
    }
}