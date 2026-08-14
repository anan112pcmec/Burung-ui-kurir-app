package com.example.burungkurirapp.ui.section.Landing.page.Login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.burungkurirapp.ui.constant.color.*

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginPage(
    onLoginClick: (String, String) -> Unit = { _, _ -> },
    onGoogleSsoClick: () -> Unit = {},
    onRegisterRedirectClick: () -> Unit = {}
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        // ─── HEADER ───
        Text(
            text = "Masuk Sebagai Kurir",
            fontFamily = FontFamily.SansSerif,
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = Slate950
        )
        Text(
            text = "Selamat datang kembali. Lanjutkan pekerjaan pengiriman Anda hari ini.",
            fontFamily = FontFamily.SansSerif,
            fontSize = 13.sp,
            color = Zinc600,
            modifier = Modifier.padding(top = 8.dp, bottom = 32.dp)
        )

        // ─── SSO GOOGLE BUTTON ───
        OutlinedButton(
            onClick = { onGoogleSsoClick() },
            modifier = Modifier.fillMaxWidth().height(48.dp),
            shape = RoundedCornerShape(6.dp),
            border = BorderStroke(1.dp, Zinc300)
        ) {
            Text(
                text = "Masuk dengan Google",
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Medium,
                color = Slate950
            )
        }

        Row(
            modifier = Modifier.padding(vertical = 24.dp).fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            HorizontalDivider(modifier = Modifier.weight(1f), color = Zinc200)
            Text(
                text = "ATAU",
                modifier = Modifier.padding(horizontal = 12.dp),
                fontSize = 10.sp,
                color = Zinc400,
                fontFamily = FontFamily.SansSerif
            )
            HorizontalDivider(modifier = Modifier.weight(1f), color = Zinc200)
        }

        // ─── EMAIL & PASSWORD FIELDS ───
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email", fontFamily = FontFamily.SansSerif, fontSize = 11.sp) },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = androidx.compose.foundation.text.KeyboardOptions(keyboardType = KeyboardType.Email),
                colors = textFieldColors()
            )

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Kata Sandi", fontFamily = FontFamily.SansSerif, fontSize = 11.sp) },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                visualTransformation = PasswordVisualTransformation(),
                colors = textFieldColors()
            )

            // ─── ACTION BUTTON ───
            Button(
                onClick = { onLoginClick(email, password) },
                modifier = Modifier.fillMaxWidth().height(48.dp),
                shape = RoundedCornerShape(6.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Slate950)
            ) {
                Text(
                    text = "MASUK KE AKUN",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp
                )
            }
        }

        // ─── FOOTER REDIRECT ───
        Row(
            modifier = Modifier.fillMaxWidth().padding(top = 20.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Belum punya akun? ",
                fontSize = 12.sp,
                color = Zinc600,
                fontFamily = FontFamily.SansSerif
            )
            Text(
                text = "Daftar Sekarang",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Slate950,
                fontFamily = FontFamily.SansSerif,
                modifier = Modifier.clickable { onRegisterRedirectClick() }
            )
        }
    }
}

@Composable
private fun textFieldColors() = OutlinedTextFieldDefaults.colors(
    focusedBorderColor = Slate950,
    unfocusedBorderColor = Zinc300,
    focusedLabelColor = Slate950,
    unfocusedLabelColor = Zinc600
)