package com.example.mobilebanking

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.example.mobilebanking.ui.theme.DarkBlue1
import com.example.mobilebanking.ui.theme.LightBlueBackground


@Composable
fun ScreenA(navController: NavController) {
    val password = remember { mutableStateOf("") }
    
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.padding(28.dp))

        // Logo Image
        Image(
            painter = painterResource(id = R.drawable.logo_livin),
            contentDescription = "Logo",
            modifier = Modifier
                .size(300.dp)
        )

        Text(
            text = "Kata Sandi",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(16.dp),
        )

        // Input field for password
        TextField(
            value = password.value,
            onValueChange = { password.value = it },
            label = { Text("Masukkan kata sandi") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.padding(bottom = 28.dp),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = LightBlueBackground,
                focusedContainerColor = LightBlueBackground,
                focusedIndicatorColor = DarkBlue1,
                unfocusedIndicatorColor = DarkBlue1,
                focusedLabelColor = DarkBlue1,
                cursorColor = DarkBlue1
            )
        )

        Button(
            onClick = {
            navController.navigate(Routes.screenB)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = DarkBlue1,
                contentColor = Color.White
            )
        ) {
            Text(
                text = "Login",
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .width(228.dp)
                    .padding(vertical = 4.dp)
            )
        }
    }
}