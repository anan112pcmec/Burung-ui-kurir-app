package com.example.burungkurirapp.ui.section.Home.page.Privasi.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.burungkurirapp.ui.constant.color.Slate950
import com.example.burungkurirapp.ui.constant.color.Zinc100
import com.example.burungkurirapp.ui.constant.color.Zinc200


// ─── FORM PRE-UBAH PASSWORD (KOMPONEN 2) ───
@Composable
fun FormUbahPasswordSection(
    passwordLama: String,
    passwordBaru: String,
    onPasswordLamaChange: (String) -> Unit,
    onPasswordBaruChange: (String) -> Unit,
    onSubmitPreUbah: () -> Unit
) {
    var isPasswordLamaVisible by remember { mutableStateOf(false) }
    var isPasswordBaruVisible by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(2.dp))
            .border(BorderStroke(1.dp, Zinc200), RoundedCornerShape(2.dp))
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Default.Lock,
                contentDescription = null,
                tint = Slate950,
                modifier = Modifier.size(14.dp)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = "PERUBAHAN PASSWORD",
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                fontSize = 10.sp,
                color = Slate950,
                letterSpacing = 1.sp
            )
        }

        Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(Zinc100))

        // Input Password Lama
        PasswordFieldInput(
            label = "PASSWORD LAMA",
            value = passwordLama,
            onValueChange = onPasswordLamaChange,
            isVisible = isPasswordLamaVisible,
            onToggleVisibility = { isPasswordLamaVisible = !isPasswordLamaVisible },
            placeholder = "Masukkan password saat ini"
        )

        // Input Password Baru
        PasswordFieldInput(
            label = "PASSWORD BARU",
            value = passwordBaru,
            onValueChange = onPasswordBaruChange,
            isVisible = isPasswordBaruVisible,
            onToggleVisibility = { isPasswordBaruVisible = !isPasswordBaruVisible },
            placeholder = "Minimal 8 karakter"
        )

        Spacer(modifier = Modifier.height(2.dp))

        // Tombol Trigger Pre-Ubah Password
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(38.dp)
                .background(Slate950, RoundedCornerShape(2.dp))
                .clickable { onSubmitPreUbah() },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "MINTA KODE VERIFIKASI (OTP)",
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                fontSize = 9.sp,
                color = Color.White,
                letterSpacing = 1.sp
            )
        }
    }
}
