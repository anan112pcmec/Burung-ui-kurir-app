package com.example.burungkurirapp.ui.page.Privasi

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Shield
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.burungkurirapp.ui.constant.color.*
import com.example.burungkurirapp.ui.page.Privasi.component.DialogValidateOtp
import com.example.burungkurirapp.ui.page.Privasi.component.FormUbahPasswordSection

// ─── MAIN CONTAINER (KOMPONEN 1) ───
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PrivasiPage() {
    var passwordLama by remember { mutableStateOf("") }
    var passwordBaru by remember { mutableStateOf("") }
    var otpKeyInput by remember { mutableStateOf("") }

    // State Alur 2-Tahap Ubah Password
    var showOtpDialog by remember { mutableStateOf(false) }
    var isSuccessNotification by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize().background(Color.White)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Header Privasi
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "KEAMANAN & PRIVASI",
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        color = Slate950,
                        letterSpacing = 1.sp
                    )
                    Text(
                        text = "KONTROL KREDENSIAL & AKSES AKUN",
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 8.sp,
                        color = Zinc400
                    )
                }

                Box(
                    modifier = Modifier
                        .size(28.dp)
                        .background(Zinc50, RoundedCornerShape(2.dp))
                        .border(BorderStroke(1.dp, Zinc200), RoundedCornerShape(2.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Shield,
                        contentDescription = null,
                        tint = Slate950,
                        modifier = Modifier.size(14.dp)
                    )
                }
            }

            Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(Zinc100))

            // Banner Notifikasi Sukses
            if (isSuccessNotification) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Teal600, RoundedCornerShape(2.dp))
                        .padding(10.dp)
                ) {
                    Text(
                        text = "BERHASIL: PASSWORD AKUN KURIR TELAH DIPERBARUI.",
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold,
                        fontSize = 9.sp,
                        color = Color.White
                    )
                }
            }

            // Komponen Form Pre-Ubah Password (Tahap 1)
            FormUbahPasswordSection (
                passwordLama = passwordLama,
                passwordBaru = passwordBaru,
                onPasswordLamaChange = { passwordLama = it },
                onPasswordBaruChange = { passwordBaru = it },
                onSubmitPreUbah = {
                    if (passwordLama.isNotBlank() && passwordBaru.isNotBlank()) {
                        // Trigger PayloadPreUbahPassword ke backend -> Minta OTP
                        showOtpDialog = true
                    }
                }
            )
        }

        // Komponen Modal Dialog Validate OTP (Tahap 2)
        if (showOtpDialog) {
            DialogValidateOtp (
                otpKey = otpKeyInput,
                onOtpKeyChange = { otpKeyInput = it },
                onDismiss = { showOtpDialog = false },
                onValidateSubmit = {
                    if (otpKeyInput.isNotBlank()) {
                        // Trigger PayloadValidateUbahPassword ke backend
                        showOtpDialog = false
                        passwordLama = ""
                        passwordBaru = ""
                        otpKeyInput = ""
                        isSuccessNotification = true
                    }
                }
            )
        }
    }
}

