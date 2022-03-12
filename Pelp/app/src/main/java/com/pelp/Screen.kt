package com.pelp

sealed class Screen(val route:String){

    object Login:Screen(route="login_screen")
    object Start:Screen(route="start_screen")
    object Main:Screen(route="main_screen")
}
