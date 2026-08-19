package com.example.burungkurirapp.ui.section.Home.page.Alamat.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.burungkurirapp.ui.constant.color.Slate950
import com.example.burungkurirapp.ui.constant.color.Zinc200
import com.example.burungkurirapp.ui.constant.color.Zinc600

private val Rose600 = Color(0xFFE11D48)

@Composable
fun DialogHapusAlamat(
    onDismiss: () -> Unit,
    onConfirmDelete: () -> Unit
) {
    Dialog(onDismissRequest = onDismiss) {
        Surface(
            shape = RoundedCornerShape(2.dp),
            color = Color.White,
            border = BorderStroke(1.dp, Zinc200),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "HAPUS ALAMAT OPERASIONAL",
                    fontFamily = FontFamily.SansSerif,
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
                    // Tombol Batal
                    Surface(
                        onClick = onDismiss,
                        modifier = Modifier
                            .weight(1f)
                            .height(36.dp),
                        shape = RoundedCornerShape(2.dp),
                        color = Color.White,
                        border = BorderStroke(1.dp, Zinc200)
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Text(
                                text = "BATAL",
                                fontFamily = FontFamily.SansSerif,
                                fontWeight = FontWeight.Bold,
                                fontSize = 9.sp,
                                color = Zinc600
                            )
                        }
                    }

                    // Tombol Hapus
                    Surface(
                        onClick = onConfirmDelete,
                        modifier = Modifier
                            .weight(1f)
                            .height(36.dp),
                        shape = RoundedCornerShape(2.dp),
                        color = Rose600
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Text(
                                text = "YA, HAPUS ALAMAT",
                                fontFamily = FontFamily.SansSerif,
                                fontWeight = FontWeight.Bold,
                                fontSize = 9.sp,
                                color = Color.White
                            )
                        }
                    }
                }
            }
        }
    }
}