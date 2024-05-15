package com.example.mobilebanking

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mobilebanking.ui.theme.DarkBlue1

@Composable
fun ScreenD(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Transfer Berhasil",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp),
            style = TextStyle(color = DarkBlue1)
        )

        Spacer(modifier = Modifier.height(100.dp))

        // Image
        Image(
            painter = painterResource(R.drawable.ic_check_circle),
            contentDescription = "Transfer Success Icon",
            modifier = Modifier.size(180.dp)
        )

        Spacer(modifier = Modifier.height(100.dp))

        Button(
            onClick = {
            navController.navigate(Routes.screenA)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = DarkBlue1,
                contentColor = Color.White
            ),
        ) {
            Text(
                text = "Selesai",
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .width(228.dp)
                    .padding(vertical = 4.dp)
            )
        }
    }
}