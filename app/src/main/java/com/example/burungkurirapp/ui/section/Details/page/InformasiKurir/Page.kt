package com.example.burungkurirapp.ui.section.Details.page.InformasiKurir

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.burungkurirapp.ui.constant.color.Slate950
import com.example.burungkurirapp.ui.constant.color.Zinc100
import com.example.burungkurirapp.ui.constant.color.Zinc300
import com.example.burungkurirapp.ui.constant.color.Zinc600
import com.example.burungkurirapp.ui.constant.types.InformasiKurir
import com.example.burungkurirapp.ui.constant.types.Kurir

@Composable
fun DetailsInformasiKurirPage(kurir: Kurir, data: InformasiKurir) {
    var fotoKtpUrl = ""
    if (data.urlFotoKtp != null){
        fotoKtpUrl = data.urlFotoKtp
    }

    var fotoSimUrl = ""
    if (data.urlFotoSim != null){
        fotoSimUrl = data.urlFotoSim
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Header Status Verifikasi
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Informasi Kurir",
                fontSize = 20.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold
            )

            Surface(
                shape = RoundedCornerShape(20.dp),
                color = if (kurir.VerifierKurir) Slate950 else Zinc600
            ) {
                Text(
                    text = if (kurir.VerifierKurir) "Verified" else "Wait For Verified",
                    color = Zinc100,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                )
            }
        }

        // Card Profil Utama
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Zinc100)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(70.dp)
                        .clip(CircleShape)
                        .background(Zinc300),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = kurir.Nama.firstOrNull()?.toString() ?: "K",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Slate950
                    )
                }

                Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Text(
                        text = kurir.Nama,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Slate950
                    )
                    Text(
                        text = "@${kurir.Username}",
                        fontSize = 13.sp,
                        color = Zinc600
                    )
                    Text(
                        text = kurir.Email,
                        fontSize = 13.sp,
                        color = Zinc600
                    )
                }
            }
        }

        // Detail Informasi Personal & Kendaraan
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Zinc100)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(
                    text = "Detail Personal & Operasional",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = Slate950
                )
                HorizontalDivider(color = Zinc300)

                InfoRow(label = "Tanggal Lahir", value = data.TanggalLahir)
                InfoRow(label = "Tipe Kendaraan", value = kurir.TipeKendaraan)
                InfoRow(label = "Status Kurir", value = kurir.StatusKurir)
                InfoRow(label = "Status Bid", value = kurir.StatusBid)

                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Alasan Bergabung:",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = Zinc600
                )
                Text(
                    text = data.Alasan,
                    fontSize = 13.sp,
                    color = Slate950
                )
            }
        }

        // Dokumen Lampiran (KTP & SIM)
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Zinc100)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "Dokumen Verifikasi",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = Slate950
                )
                HorizontalDivider(color = Zinc300)


                   DocumentImageItem(
                       title = "Foto KTP",
                       imageUrl = fotoKtpUrl,
                       isVerified = data.InformasiKtp
                   )


                DocumentImageItem(
                    title = "Foto SIM",
                    imageUrl = fotoSimUrl,
                    isVerified = data.InformasiSim
                )
            }
        }
    }
}

@Composable
private fun InfoRow(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = label, fontSize = 13.sp, color = Zinc600)
        Text(text = value, fontSize = 13.sp, fontWeight = FontWeight.SemiBold, color = Slate950)
    }
}

@Composable
private fun DocumentImageItem(title: String, imageUrl: String, isVerified: Boolean) {
    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = title, fontSize = 13.sp, fontWeight = FontWeight.Medium, color = Slate950)
            Text(
                text = if (isVerified) "Tervalidasi" else "Belum Divalidasi",
                fontSize = 12.sp,
                color = if (isVerified) Color(0xFF16A34A) else Color(0xFFDC2626)
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Zinc300),
            contentAlignment = Alignment.Center
        ) {
            AsyncImage(
                model = imageUrl,
                contentDescription = title,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
    }
}



@Preview(showBackground = true)
@Composable
private fun PrevDetailsInformasiKurirPage() {
    val dataInformasiKurir: InformasiKurir = InformasiKurir(
        Id = 12,
        IdKurir = 1002,
        TanggalLahir = "12-08-2007",
        Alasan = "Saya ingin membangun sistem burung",
        InformasiKtp = true,
        InformasiSim = true,
        Status = "Verified",
        CreatedAt = "09-07-2025",
        UpdatedAt = "07-02-2026",

        urlFotoKtp = "data:image/jpeg;base64,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",
        urlFotoSim = "https://png.pngtree.com/png-vector/20220513/ourmid/pngtree-vector-of-sim-c-indonesian-driving-license-png-image_4619865.png"
    )

    val dataKurir: Kurir = Kurir(
        Id = 1,
        Nama = "Faiz Hannan Hakim",
        Username = "ananhakim112",
        Email = "ananlol156@gmail.com",
        Jenis = "",
        PasswordHash = "",
        Deskripsi = "Saya ingin membangun sistem burung",
        StatusKurir = "Online",
        StatusBid = "Off",
        VerifierKurir = true,
        TipeKendaraan = "Motor",
        CreatedAt = "09-07-2025",
        UpdatedAt = "07-02-2026",
    )

    DetailsInformasiKurirPage(dataKurir, dataInformasiKurir)
}
