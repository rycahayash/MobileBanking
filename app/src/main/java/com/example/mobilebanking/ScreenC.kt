package com.example.mobilebanking

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mobilebanking.ui.theme.DarkBlue1
import com.example.mobilebanking.ui.theme.LightBlueBackground

@Composable
fun ScreenC(navController: NavController) {
    var pin by remember {
        mutableStateOf(TextFieldValue())
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.padding(120.dp))

        Text(
            text = "PIN ATM",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp),
            style = TextStyle(color = DarkBlue1)
        )

        Spacer(modifier = Modifier.padding(16.dp))

        // Input Field for PIN (6 digits)
        TextField(
            value = pin,
            onValueChange = {
                if (it.text.length <= 6) {
                    pin = it
                }
            },
            label = { Text("Masukkan PIN (6 digit)") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.padding(bottom = 16.dp),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = LightBlueBackground,
                focusedContainerColor = LightBlueBackground,
                focusedIndicatorColor = DarkBlue1,
                unfocusedIndicatorColor = DarkBlue1,
                focusedLabelColor = DarkBlue1,
                cursorColor = DarkBlue1
            )
        )

        Spacer(modifier = Modifier.height(120.dp))
        Button(
            onClick = {
                if(pin.text.length == 6){
                    navController.navigate(Routes.screenD)
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = DarkBlue1,
                contentColor = Color.White
            )
        ) {
            Text(
                text = "Lanjutkan",
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .width(228.dp)
                    .padding(vertical = 4.dp)
            )
        }
    }
}