package com.example.burungkurirapp.ui.section.Details.page.InformasiKendaraanKurir

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.burungkurirapp.ui.constant.color.Slate950
import com.example.burungkurirapp.ui.constant.color.Zinc100
import com.example.burungkurirapp.ui.constant.color.Zinc300
import com.example.burungkurirapp.ui.constant.color.Zinc600
import com.example.burungkurirapp.ui.constant.types.InformasiKendaraanKurir

@Composable
fun InformasiKendaraanKurirPage(
    data: InformasiKendaraanKurir,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Header Status & Nama Kendaraan
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "Informasi Kendaraan",
                    fontSize = 20.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    color = Slate950
                )
                Text(
                    text = data.NamaKendaraan,
                    fontSize = 14.sp,
                    color = Zinc600
                )
            }

            Surface(
                shape = RoundedCornerShape(20.dp),
                color = if (data.Status.lowercase() == "verified" || data.Status.lowercase() == "active") Color(0xFF16A34A) else Slate950
            ) {
                Text(
                    text = data.Status,
                    color = Zinc100,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                )
            }
        }

        // Card Detail Spesifikasi Kendaraan
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Zinc100)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(
                    text = "Spesifikasi & Identitas",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = Slate950
                )
                HorizontalDivider(color = Zinc300)

                InfoRow(label = "Jenis Kendaraan", value = data.JenisKendaraan)
                InfoRow(label = "Jumlah Roda", value = "${data.RodaKendaraan} Roda")
                InfoRow(label = "Nomor Rangka", value = data.NomorRangka ?: "-")
                InfoRow(label = "Nomor Mesin", value = data.NomorMesin ?: "-")
            }
        }

        // Card Foto Unit Kendaraan
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Zinc100)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(
                    text = "Foto Unit Kendaraan",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = Slate950
                )
                HorizontalDivider(color = Zinc300)

                DocumentImageItem(
                    title = "Fisik Kendaraan",
                    imageUrl = data.fotoKendaraan,
                    isVerified = true
                )
            }
        }

        // Card Dokumen Legalitas (STNK & BPKB)
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Zinc100)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "Dokumen Legalitas",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = Slate950
                )
                HorizontalDivider(color = Zinc300)

                DocumentImageItem(
                    title = "Foto STNK",
                    imageUrl = data.fotoSTNK,
                    isVerified = data.InformasiStnk
                )

                DocumentImageItem(
                    title = "Foto BPKB",
                    imageUrl = data.fotoBpkb,
                    isVerified = data.InformasiBpkb
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
private fun DocumentImageItem(title: String, imageUrl: String?, isVerified: Boolean) {
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
            if (!imageUrl.isNullOrEmpty()) {
                AsyncImage(
                    model = imageUrl,
                    contentDescription = title,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            } else {
                Text(
                    text = "Foto tidak tersedia",
                    fontSize = 12.sp,
                    color = Zinc600
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PrevInformasiKendaraanKurirPage() {
    val sampleData = InformasiKendaraanKurir(
        Id = 1L,
        IdKurir = 100L,
        JenisKendaraan = "Motor",
        NamaKendaraan = "Honda Vario 160",
        RodaKendaraan = "2",
        InformasiStnk = true,
        InformasiBpkb = false,
        NomorRangka = "MH1JM8112NK123456",
        NomorMesin = "JM81E1123456",
        Status = "Verified",
        CreatedAt = "2025-10-01",
        UpdatedAt = "2025-10-02",
        fotoKendaraan = null,
        fotoBpkb = null,
        fotoSTNK = null
    )
    InformasiKendaraanKurirPage(data = sampleData)
}