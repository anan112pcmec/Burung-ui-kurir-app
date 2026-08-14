package com.example.burungkurirapp.ui.section.Auth.page.SignUp


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.burungkurirapp.ui.constant.color.*

// State DTO yang dipetakan langsung ke Struct Kurir (Go)
data class RegisterKurirFormState(
    val nama: String = "",
    val username: String = "",
    val email: String = "",
    val passwordHash: String = "",
    val jenisLayanan: String = "Reguler", // 'Reguler', 'Express', dll
    val tipeKendaraan: String = "Motor",  // 'Motor', 'Mobil', 'Lainnya'
    val deskripsi: String = ""
)

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignUpPage(
    onSubmitClick: (RegisterKurirFormState) -> Unit = {},
    onLoginRedirectClick: () -> Unit = {}
) {
    // ─── FORM STATES ───
    var nama by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var jenisLayanan by remember { mutableStateOf("Reguler") }
    var tipeKendaraan by remember { mutableStateOf("Motor") }
    var deskripsi by remember { mutableStateOf("") }

    // Dropdown States
    var expandedJenis by remember { mutableStateOf(false) }
    var expandedKendaraan by remember { mutableStateOf(false) }

    val opsiJenisLayanan = listOf("Reguler", "Express", "Kargo", "SameDay")
    val opsiTipeKendaraan = listOf("Motor", "Mobil", "Sepeda", "Lainnya")

    // Form Validation (Basic check)
    val isFormValid = nama.isNotBlank() && username.isNotBlank() &&
            email.contains("@") && password.length >= 6

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 24.dp, vertical = 32.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        // ─── HEADER SECTION ───
        Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
            Text(
                text = "Lengkapi Profil Kurir",
                fontFamily = FontFamily.SansSerif,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Slate950
            )
            Text(
                text = "Isi data diri dan identitas operasional Anda untuk membuat akun pendaftaran mitra.",
                fontFamily = FontFamily.SansSerif,
                fontSize = 13.sp,
                color = Zinc600,
                lineHeight = 18.sp
            )
        }

        HorizontalDivider(color = Zinc200, thickness = 1.dp)

        // ─── SECTION 1: DATA AKUN UTAMA ───
        Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
            Text(
                text = "INFORMASI AKUN & KREDENSIAL",
                fontFamily = FontFamily.SansSerif,
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = Slate950,
                letterSpacing = 0.5.sp
            )

            // Field: Nama Lengkap
            InputField(
                label = "Nama Lengkap (sesuai KTP)",
                value = nama,
                onValueChange = { nama = it },
                placeholder = "Contoh: Budi Santoso"
            )

            // Field: Username
            InputField(
                label = "Username",
                value = username,
                onValueChange = { username = it },
                placeholder = "contoh: budi_kurir"
            )

            // Field: Email
            InputField(
                label = "Alamat Email",
                value = email,
                onValueChange = { email = it },
                placeholder = "budi@email.com",
                keyboardType = KeyboardType.Email
            )

            // Field: Password (PasswordHash)
            InputField(
                label = "Kata Sandi",
                value = password,
                onValueChange = { password = it },
                placeholder = "Minimal 6 karakter",
                isPassword = true
            )
        }

        HorizontalDivider(color = Zinc200, thickness = 1.dp)

        // ─── SECTION 2: OPERASIONAL & KENDARAAN ───
        Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
            Text(
                text = "DETAIL OPERASIONAL KURIR",
                fontFamily = FontFamily.SansSerif,
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = Slate950,
                letterSpacing = 0.5.sp
            )

            // Dropdown: Jenis Layanan Kurir (Struct Field: jenis)
            ExposedDropdownMenuBox(
                expanded = expandedJenis,
                onExpandedChange = { expandedJenis = !expandedJenis }
            ) {
                OutlinedTextField(
                    value = jenisLayanan,
                    onValueChange = {},
                    readOnly = true,
                    label = { Text("Jenis Layanan", fontFamily = FontFamily.SansSerif, fontSize = 11.sp) },
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedJenis) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .menuAnchor(),
                    colors = textFieldColors()
                )
                ExposedDropdownMenu(
                    expanded = expandedJenis,
                    onDismissRequest = { expandedJenis = false }
                ) {
                    opsiJenisLayanan.forEach { item ->
                        DropdownMenuItem(
                            text = { Text(item, fontFamily = FontFamily.SansSerif) },
                            onClick = {
                                jenisLayanan = item
                                expandedJenis = false
                            }
                        )
                    }
                }
            }

            // Dropdown: Tipe Kendaraan (Struct Field: jenis_kendaraan)
            ExposedDropdownMenuBox(
                expanded = expandedKendaraan,
                onExpandedChange = { expandedKendaraan = !expandedKendaraan }
            ) {
                OutlinedTextField(
                    value = tipeKendaraan,
                    onValueChange = {},
                    readOnly = true,
                    label = { Text("Tipe Kendaraan", fontFamily = FontFamily.SansSerif, fontSize = 11.sp) },
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedKendaraan) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .menuAnchor(),
                    colors = textFieldColors()
                )
                ExposedDropdownMenu(
                    expanded = expandedKendaraan,
                    onDismissRequest = { expandedKendaraan = false }
                ) {
                    opsiTipeKendaraan.forEach { item ->
                        DropdownMenuItem(
                            text = { Text(item, fontFamily = FontFamily.SansSerif) },
                            onClick = {
                                tipeKendaraan = item
                                expandedKendaraan = false
                            }
                        )
                    }
                }
            }

            // Field: Deskripsi Singkat (Struct Field: deskripsi)
            OutlinedTextField(
                value = deskripsi,
                onValueChange = { deskripsi = it },
                label = { Text("Deskripsi Singkat / Pengalaman", fontFamily = FontFamily.SansSerif, fontSize = 11.sp) },
                placeholder = { Text("Contoh: Pengalaman kurir 2 tahun di area Jabodetabek.", fontSize = 12.sp, color = Zinc400) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp),
                maxLines = 3,
                colors = textFieldColors()
            )
        }

        // ─── ACTION BUTTON ───
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.padding(top = 12.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .background(
                        if (isFormValid) Slate950 else Zinc200,
                        RoundedCornerShape(6.dp)
                    )
                    .clickable(enabled = isFormValid) {
                        onSubmitClick(
                            RegisterKurirFormState(
                                nama = nama,
                                username = username,
                                email = email,
                                passwordHash = password,
                                jenisLayanan = jenisLayanan,
                                tipeKendaraan = tipeKendaraan,
                                deskripsi = deskripsi
                            )
                        )
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "KIRIM DATA PENDAFTARAN",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    color = if (isFormValid) Color.White else Zinc400,
                    letterSpacing = 0.5.sp
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onLoginRedirectClick() }
                    .padding(vertical = 6.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Sudah memiliki akun kurir? ",
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 12.sp,
                    color = Zinc600
                )
                Text(
                    text = "Masuk",
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Slate950
                )
            }
        }
    }
}

// ─── REUSABLE INPUT COMPONENT ───
@Composable
private fun InputField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    isPassword: Boolean = false,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label, fontFamily = FontFamily.SansSerif, fontSize = 11.sp) },
        placeholder = { Text(placeholder, fontSize = 12.sp, color = Zinc400) },
        singleLine = true,
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
        keyboardOptions = KeyboardOptions(
            keyboardType = if (isPassword) KeyboardType.Password else keyboardType,
            imeAction = ImeAction.Next
        ),
        modifier = Modifier.fillMaxWidth(),
        colors = textFieldColors()
    )
}

@Composable
private fun textFieldColors() = OutlinedTextFieldDefaults.colors(
    focusedBorderColor = Slate950,
    unfocusedBorderColor = Zinc300,
    focusedLabelColor = Slate950,
    unfocusedLabelColor = Zinc600,
    cursorColor = Slate950
)