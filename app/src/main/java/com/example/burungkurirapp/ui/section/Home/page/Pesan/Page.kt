package com.example.burungkurirapp.ui.section.Home.page.Pesan

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MarkEmailUnread
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.burungkurirapp.ui.constant.color.Slate50
import com.example.burungkurirapp.ui.constant.color.Slate800
import com.example.burungkurirapp.ui.constant.color.Teal600
import com.example.burungkurirapp.ui.constant.color.Zinc500
import com.example.burungkurirapp.ui.constant.color.Zinc600
import com.example.burungkurirapp.ui.constant.color.Zinc950
import com.example.burungkurirapp.ui.constant.prefix.DetailsSectionPrefix
import com.example.burungkurirapp.ui.constant.types.NotificationKurir
import com.example.burungkurirapp.ui.section.LocalUiFlowState

// Menggunakan data class NotificationKurir yang sudah ada di proyek Anda
@Composable
fun HomePesanPage(data: List<NotificationKurir>) {
    val state = LocalUiFlowState.current
    val filteredData = data.filter { it.Inbox }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Slate50)
            .padding(16.dp)
    ) {
        // Header Section dengan nuansa lebih personal
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                Text(
                    text = "Pesan Masuk",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    color = Zinc950
                )
                Text(
                    text = "Informasi dan pemberitahuan terbaru untuk Anda",
                    fontSize = 12.sp,
                    color = Zinc500
                )
            }

            // Badge Indikator Total Inbox
            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .background(Teal600.copy(alpha = 0.12f))
                    .padding(horizontal = 12.dp, vertical = 6.dp),
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.MarkEmailUnread,
                    contentDescription = null,
                    modifier = Modifier.size(15.dp),
                    tint = Teal600
                )
                Text(
                    text = "${filteredData.size} Pesan",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 12.sp,
                    color = Teal600
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Daftar Pesan (Inbox)
        if (filteredData.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Belum ada pesan masuk saat ini.",
                    fontSize = 14.sp,
                    color = Zinc500,
                    textAlign = TextAlign.Center
                )
            }
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(
                    count = filteredData.size,
                    key = { index -> filteredData[index].IdKurir }
                ) { index ->
                    val item = filteredData[index]

                    Card(
                        modifier = Modifier.fillMaxWidth()
                            .clickable(
                                onClick = {state.navController.navigate("$DetailsSectionPrefix/Notifikasi")}
                            ),
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        ),
                        elevation = CardDefaults.cardElevation(defaultElevation = 0.5.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(14.dp),
                            horizontalArrangement = Arrangement.spacedBy(12.dp),
                            verticalAlignment = Alignment.Top
                        ) {
                            // Aksen Lingkaran / Avatar Inisial Pengirim
                            Box(
                                modifier = Modifier
                                    .size(36.dp)
                                    .clip(CircleShape)
                                    .background(Teal600.copy(alpha = 0.1f)),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = item.Pengirim.take(1).uppercase(),
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 14.sp,
                                    color = Teal600
                                )
                            }

                            // Konten Utama Pesan
                            Column(
                                modifier = Modifier.weight(1f),
                                verticalArrangement = Arrangement.spacedBy(4.dp)
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = item.Pengirim,
                                        fontSize = 13.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Zinc950
                                    )
                                    Text(
                                        text = item.CreatedAt,
                                        fontSize = 11.sp,
                                        color = Zinc500
                                    )
                                }

                                Text(
                                    text = item.Judul,
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = Slate800
                                )

                                Text(
                                    text = item.Pesan,
                                    fontSize = 12.sp,
                                    color = Zinc600,
                                    maxLines = 2,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true, backgroundColor = 0xFFF8FAFC)
@Composable
private fun PrevHomePesanPage() {
    val dummyData = listOf(
        NotificationKurir(
            IdKurir = 1,
            Pengirim = "Admin Operasional",
            Judul = "Jadwal Shift Baru",
            Pesan = "Mohon periksa kembali jadwal shift pengiriman Anda untuk minggu depan di menu profil.",
            Pop = 1.0f,
            Archive = false,
            Inbox = true,
            Activity = false,
            CreatedAt = "09:30",
            ExpiredAt = "2026-12-31",
            Data = NotificationKurir.DataInfo(mapOf(), "")
        ),
        NotificationKurir(
            IdKurir = 2,
            Pengirim = "Pusat Bantuan",
            Judul = "Verifikasi Data Berhasil",
            Pesan = "Akun kurir Anda telah terverifikasi penuh oleh sistem pusat.",
            Pop = 0.5f,
            Archive = false,
            Inbox = true,
            Activity = true,
            CreatedAt = "Kemarin",
            ExpiredAt = "2026-12-31",
            Data = NotificationKurir.DataInfo(mapOf(), "")
        )
    )

    HomePesanPage(data = dummyData)
}