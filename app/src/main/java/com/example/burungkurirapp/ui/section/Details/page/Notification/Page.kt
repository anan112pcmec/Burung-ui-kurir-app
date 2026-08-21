package com.example.burungkurirapp.ui.section.Details.page.Notification

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.burungkurirapp.ui.constant.color.Slate100
import com.example.burungkurirapp.ui.constant.color.Slate50
import com.example.burungkurirapp.ui.constant.color.Slate700
import com.example.burungkurirapp.ui.constant.color.Slate800
import com.example.burungkurirapp.ui.constant.color.Teal600
import com.example.burungkurirapp.ui.constant.color.Zinc500
import com.example.burungkurirapp.ui.constant.color.Zinc600
import com.example.burungkurirapp.ui.constant.color.Zinc950
import com.example.burungkurirapp.ui.constant.types.NotificationKurir

@Composable
fun DetailsNotificationPage(
    modifier: Modifier = Modifier,
    notification: NotificationKurir,
    onBackClick: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Slate50)
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Top Bar Navigasi Sederhana
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            IconButton(
                onClick = onBackClick,
                modifier = Modifier
                    .size(36.dp)
                    .background(Color.White, CircleShape)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Kembali",
                    tint = Zinc950,
                    modifier = Modifier.size(18.dp)
                )
            }
            Text(
                text = "Detail Pesan",
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Zinc950
            )
        }

        // Kartu Utama Konten Pesan
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 0.5.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                // Info Pengirim & Waktu
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .clip(CircleShape)
                                .background(Teal600.copy(alpha = 0.1f)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = notification.Pengirim.take(1).uppercase(),
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                color = Teal600
                            )
                        }
                        Column {
                            Text(
                                text = notification.Pengirim,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                color = Zinc950
                            )
                            Text(
                                text = "ID Kurir: #${notification.IdKurir}",
                                fontSize = 11.sp,
                                color = Zinc500
                            )
                        }
                    }
                    Text(
                        text = notification.CreatedAt,
                        fontSize = 11.sp,
                        color = Zinc500,
                        fontWeight = FontWeight.Medium
                    )
                }

                Divider(color = Slate100, thickness = 1.dp)

                // Judul Pesan
                Text(
                    text = notification.Judul,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Slate800
                )

                // Isi Pesan Lengkap
                Text(
                    text = notification.Pesan,
                    fontSize = 13.sp,
                    color = Zinc600,
                    lineHeight = 20.sp
                )
            }
        }

        // Kartu Informasi Tambahan / Metadata (Jika Ada)
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 0.5.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp),
                        tint = Teal600
                    )
                    Text(
                        text = "Informasi Sistem",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = Zinc950
                    )
                }

                Divider(color = Slate100, thickness = 1.dp)

                // Atribut Tambahan
                DetailRow(label = "Status Arsip", value = if (notification.Archive) "Diarsipkan" else "Tidak")
                DetailRow(label = "Status Inbox", value = if (notification.Inbox) "Masuk" else "Tidak")
                DetailRow(label = "Status Aktivitas", value = if (notification.Activity) "Aktif" else "Tidak")
                DetailRow(label = "Prioritas (Pop)", value = notification.Pop.toString())
                DetailRow(label = "Kadaluarsa", value = notification.ExpiredAt)

                // Menampilkan Metadata Map jika tidak kosong
                if (notification.Data.Metadata.isNotEmpty()) {
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Metadata:",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Zinc950
                    )
                    notification.Data.Metadata.forEach { (key, value) ->
                        DetailRow(label = "- $key", value = value.toString())
                    }
                }

                // Menampilkan Special jika ada
                if (notification.Data.Special.toString().isNotBlank()) {
                    DetailRow(label = "Special Info", value = notification.Data.Special.toString())
                }
            }
        }
    }
}

@Composable
private fun DetailRow(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            fontSize = 12.sp,
            color = Zinc500
        )
        Text(
            text = value,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            color = Zinc950
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF8FAFC)
@Composable
private fun PrevDetailsNotificationPage() {
    val sampleData = NotificationKurir(
        IdKurir = 1,
        Pengirim = "Logistik Hub Jakarta",
        Judul = "Paket Telah Diserahterimakan",
        Pesan = "Kurir telah berhasil menyerahkan paket kepada penerima di alamat tujuan utama tanpa kendala berarti. Tanda tangan penerima telah diverifikasi oleh sistem.",
        Pop = 1.0f,
        Archive = true,
        Inbox = true,
        Activity = true,
        CreatedAt = "10:45 WIB",
        ExpiredAt = "2026-12-31",
        Data = NotificationKurir.DataInfo(
            Metadata = mapOf("resi" to "JP123456789", "kurir_id" to "K-992"),
            Special = "express"
        )
    )

    DetailsNotificationPage(notification = sampleData)
}