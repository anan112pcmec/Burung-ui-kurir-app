package com.example.burungkurirapp.ui.section.Historical.page.Aktivitas

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
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
fun HistoricalAktivitasPage(data: List<NotificationKurir>) {
    val filteredData = data.filter { it.Activity }
   Column(
       modifier = Modifier
           .fillMaxSize()
           .padding(11.dp)
   ) {
       Row(
           modifier = Modifier.fillMaxWidth(),
           horizontalArrangement = Arrangement.SpaceBetween,
           verticalAlignment = Alignment.CenterVertically
       ) {
           Text(
               text = "AKTIVITAS KURIR",
               fontFamily = FontFamily.SansSerif,
               fontWeight = FontWeight.Bold,
               fontSize = 21.sp,
               color = Zinc950,
               textAlign = TextAlign.Center,
               modifier = Modifier.padding(horizontal = 2.dp)
           )
           Row(
               modifier = Modifier
                   .background(Slate700, RoundedCornerShape(12.dp))
                   .padding(horizontal = 12.dp, vertical = 4.dp),
               horizontalArrangement = Arrangement.spacedBy(6.dp), // Beri jarak antara ikon dan teks
               verticalAlignment = Alignment.CenterVertically // Perbaikan dari contentAlignment ke verticalAlignment
           ) {
               Icon(
                   imageVector = Icons.Default.History,
                   contentDescription = null, // Praktik terbaik untuk aksesibilitas
                   modifier = Modifier.size(14.dp), // Ukuran ikon disesuaikan agar pas dengan teks ukuran 12.sp
                   tint = Color.White // Menyamakan warna ikon dengan teks
               )
               Text(
                   text = "${data.filter { it.Activity }.size} Aktivitas", // Perbaikan typo 'Aktifitas' ke 'Aktivitas'
                   fontFamily = FontFamily.SansSerif,
                   fontWeight = FontWeight.Bold,
                   fontSize = 12.sp,
                   color = Color.White
               )
           }
       }
       Spacer(modifier = Modifier.height(21.dp))
       LazyColumn(
           modifier = Modifier
               .fillMaxSize()
               .background(Slate50),
           verticalArrangement = Arrangement.spacedBy(10.dp),
           horizontalAlignment = Alignment.CenterHorizontally
       ) {
           items(
               count = filteredData.size,
               key = { index ->
                   // Karena key menerima lambda (Int) -> Any, kita ambil IdKurir berdasarkan index
                   filteredData[index].IdKurir
               }
           ) { index ->
               // Di sini parameter 'index' adalah posisi integer, jadi kita ambil datanya dengan cara ini:
               val item = filteredData[index]

               Card(
                   modifier = Modifier.fillMaxWidth(),
                   shape = RoundedCornerShape(8.dp),
                   colors = CardDefaults.cardColors(
                       containerColor = Color.White
                   ),
                   elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
               ) {
                   Row(
                       modifier = Modifier
                           .fillMaxWidth()
                           .padding(12.dp),
                       horizontalArrangement = Arrangement.spacedBy(12.dp),
                       verticalAlignment = Alignment.Top
                   ) {
                       // Indikator Titik Teal
                       Box(
                           modifier = Modifier
                               .padding(top = 4.dp)
                               .size(8.dp)
                               .background(Teal600, shape = CircleShape)
                       )

                       // Konten Pesan Email
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
                                   fontWeight = FontWeight.SemiBold,
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
                               fontSize = 14.sp,
                               fontWeight = FontWeight.Bold,
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

@Preview(showBackground = true, backgroundColor = 0xFFF8FAFC)
@Composable
private fun PrevHistoricalAktivitasKurir() {
    val dummyData = listOf(
        NotificationKurir(
            IdKurir = 1,
            Pengirim = "Logistik Hub Jakarta",
            Judul = "Paket Telah Diserahterimakan",
            Pesan = "Kurir telah berhasil menyerahkan paket kepada penerima di alamat tujuan utama.",
            Pop = 1.0f,
            Archive = false,
            Inbox = true,
            Activity = true,
            CreatedAt = "10:45",
            ExpiredAt = "2026-12-31",
            Data = NotificationKurir.DataInfo(
                Metadata = mapOf("resi" to "JP123456789"),
                Special = "express"
            )
        ),
        NotificationKurir(
            IdKurir = 2,
            Pengirim = "Sistem Otomasi",
            Judul = "Pembaruan Rute Perjalanan",
            Pesan = "Terdapat pengalihan rute karena adanya perbaikan jalan di sekitar wilayah Jakarta Selatan.",
            Pop = 0.5f,
            Archive = false,
            Inbox = true,
            Activity = true,
            CreatedAt = "Kemarin",
            ExpiredAt = "2026-12-31",
            Data = NotificationKurir.DataInfo(
                Metadata = mapOf("zone" to "B"),
                Special = false
            )
        )
    )

    HistoricalAktivitasPage(data = dummyData)
}