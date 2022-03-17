package com.example.mvvmcompose.ui.theme.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mvvmcompose.ui.theme.MVVMComposeTheme
import com.example.mvvmcompose.ui.theme.app.details.MovieDetails
import com.example.mvvmcompose.ui.theme.app.list.MainList
import com.example.mvvmcompose.viewmodel.MainViewModel


class MainActivity : ComponentActivity() {

    val mainViewModel by viewModels<MainViewModel>()

    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            MVVMComposeTheme {
                NavHost(navController = navController, startDestination = "trendingMovieList") {
                    composable("trendingMovieList") {
                        Surface(color = MaterialTheme.colors.background) {
                            MainList(navController = navController, mainViewModel = mainViewModel)
                        }
                    }
                    composable("movieDetails") {
                        MovieDetails(mainViewModel.clickedItem)

                    }
                }
                // A surface container using the 'background' color from the theme

            }
        }
    }
}


