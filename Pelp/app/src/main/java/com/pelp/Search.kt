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
import androidx.compose.ui.unit.dp

@Composable
fun searchAddress() {

    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(5.dp)) {

        val textState = remember { mutableStateOf(TextFieldValue()) }
        val textState1 = remember { mutableStateOf(TextFieldValue()) }
        Surface(
            shape = RoundedCornerShape(3.dp)
        ) {
            OutlinedTextField(
                value = textState.value,
                onValueChange = { textState.value = it },
                shape = RoundedCornerShape(3.dp),
                label = { Text(text = "Address") },
                modifier = Modifier.width(350.dp)

            )
        }
        Surface(
            shape = RoundedCornerShape(3.dp)
        ) {
            OutlinedTextField(
                value = textState1.value,
                onValueChange = { textState1.value = it },
                shape = RoundedCornerShape(3.dp),
                label = { Text(text = "Current location") },
                modifier = Modifier.width(350.dp)
            )
        }
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {

            Spacer(modifier = Modifier.size(16.dp))
            Row {
                val isChecked = remember { mutableStateOf(false) }
                Checkbox(
                    checked = isChecked.value,
                    onCheckedChange = {
                        isChecked.value = it
                    },
                )
                Spacer(modifier = Modifier.size(16.dp))
                Text("public only")

            }
        }

        Surface(
            shape = RoundedCornerShape(3.dp), modifier = Modifier.padding(10.dp)

        ) {
            Button(onClick = { /*TODO*/ }, modifier = Modifier
                .width(350.dp)
                .height(50.dp),
//                colors = ButtonDefaults.buttonColors

            ){
                Text(text = "Show All Nearby", modifier = Modifier.padding(2.dp),color= Color.White)
            }




        }

        Surface(
            shape = RoundedCornerShape(3.dp), modifier = Modifier.padding(10.dp)

        ) {
            Button(onClick = { /*TODO*/ }, modifier = Modifier
                .width(350.dp)
                .height(50.dp),
//                colors = ButtonDefaults.buttonColors

            ){
                Text(text = "Five Stars", modifier = Modifier.padding(2.dp),color= Color.White)
            }




        }



    }

}