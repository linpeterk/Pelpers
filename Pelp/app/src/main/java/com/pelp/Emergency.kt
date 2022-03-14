package com.pelp

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.maps.android.compose.GoogleMap

@Composable
fun emergency() {

    Box(/*modifier= Modifier.fillMaxSize()*/){
        GoogleMap(modifier=Modifier.fillMaxSize()){

        }
        TopAppBar(title = {},Modifier.height(60.dp))
    }

}

