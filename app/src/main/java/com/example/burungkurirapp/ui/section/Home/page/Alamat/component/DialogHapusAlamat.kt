package com.example.burungkurirapp.ui.section.Home.page.Alamat.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.burungkurirapp.ui.constant.color.Slate950
import com.example.burungkurirapp.ui.constant.color.Zinc200
import com.example.burungkurirapp.ui.constant.color.Zinc600


// ─── KOMPONEN 4: DIALOG HAPUS ALAMAT ───
@Composable
fun DialogHapusAlamat(
    onDismiss: () -> Unit,
    onConfirmDelete: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.4f))
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, RoundedCornerShape(2.dp))
                .border(BorderStroke(1.dp, Zinc200), RoundedCornerShape(2.dp))
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "HAPUS ALAMAT OPERASIONAL",
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                fontSize = 11.sp,
                color = Slate950,
                letterSpacing = 1.sp
            )

            Text(
                text = "Apakah Anda yakin ingin menghapus alamat ini? Sistem membutuhkan minimal 1 alamat operasional terdaftar untuk menerima penugasan area.",
                fontSize = 11.sp,
                color = Zinc600,
                lineHeight = 16.sp
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(36.dp)
                        .background(Color.White, RoundedCornerShape(2.dp))
                        .border(BorderStroke(1.dp, Zinc200), RoundedCornerShape(2.dp))
                        .clickable { onDismiss() },
                    contentAlignment = Alignment.Center
                ) {
                    Text("BATAL", fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold, fontSize = 9.sp, color = Zinc600)
                }

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(36.dp)
                        .background(Color(0xFFE11D48), RoundedCornerShape(2.dp))
                        .clickable { onConfirmDelete() },
                    contentAlignment = Alignment.Center
                ) {
                    Text("YA, HAPUS ALAMAT", fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold, fontSize = 9.sp, color = Color.White)
                }
            }
        }
    }
}