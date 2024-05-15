package com.example.mobilebanking

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.material3.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import com.example.mobilebanking.ui.theme.DarkBlue1
import com.example.mobilebanking.ui.theme.DarkBlue2
import com.example.mobilebanking.ui.theme.LightBlueBackground

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenB(navController: NavController) {

    val accountNumber = remember { mutableStateOf("") }
    val bankName = remember { mutableStateOf("")}
    var expanded by remember {
        mutableStateOf(false)
    }
    val bankList = listOf(
        "Bank Mandiri",
        "Bank Rakyat Indonesia",
        "Bank Negara Indonesia",
        "Bank Tabungan Negara"
    )
    val amount = remember { mutableStateOf("")}

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
//        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.padding(28.dp))

        // Title "Transfer"
        Text(
            text = "Transfer",
            modifier = Modifier.padding(16.dp),
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            style = TextStyle(color = DarkBlue1)
        )

        // Dropdown for Nama Bank
        Text(
            text = "Nama Bank",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(16.dp),
        )
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            }
        ) {
            TextField(
                value = bankName.value,
                onValueChange = { bankName.value = it },
                label = { Text("Pilih nama bank") },
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                },
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = LightBlueBackground,
                    focusedContainerColor = LightBlueBackground,
                    focusedIndicatorColor = DarkBlue1,
                    unfocusedIndicatorColor = DarkBlue1,
                    focusedLabelColor = DarkBlue1,
                    cursorColor = DarkBlue1
                ),
                modifier = Modifier
                    .menuAnchor()
                    .padding(bottom = 16.dp)
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                bankList.forEach { bank ->
                    DropdownMenuItem(
                        text = { Text(text = bank) },
                        onClick = {
                            bankName.value = bank
                            expanded = false
                        },
                        modifier = Modifier.background(LightBlueBackground)
                    )
                }
            }
        }

        // Input field for Nomor Rekening
        Text(
            text = "Nomor Rekening",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(16.dp),
        )

        TextField(
            value = accountNumber.value,
            onValueChange = { accountNumber.value = it },
            label = { Text("Masukkan nomor rekening") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
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

        // Input field for Jumlah
        Text(
            text = "Jumlah (Rp)",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(16.dp)
        )

        TextField(
            value = amount.value,
            onValueChange = { amount.value = it },
            label = { Text("Masukkan jumlah uang") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
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

        Spacer(modifier = Modifier.padding(72.dp))

        Button(
            onClick = {
            navController.navigate(Routes.screenC)
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