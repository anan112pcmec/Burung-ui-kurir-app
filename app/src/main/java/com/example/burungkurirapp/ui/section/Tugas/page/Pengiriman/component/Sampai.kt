package com.example.burungkurirapp.ui.section.Tugas.page.Pengiriman.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Payments
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.burungkurirapp.ui.constant.enum.StatusPengiriman
import com.example.burungkurirapp.ui.section.Tugas.page.Pengiriman.TugasPengirimanProps

// Skema Warna: Teal, Slate, Zinc, White
private val TealPrimary = Color(0xFF0D9488)
private val TealContainer = Color(0xFFCCFBF1)
private val SlateDark = Color(0xFF0F172A)
private val SlateMedium = Color(0xFF64748B)
private val SlateBorder = Color(0xFFE2E8F0)
private val ZincCard = Color(0xFFF8FAFC)

@Composable
fun SampaiUi(
    data: TugasPengirimanProps,
    buktiFotoUrl: String? = null,
    onFinishClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(8.dp))

        // 1. Header Ringkasan Sukses
        Box(
            modifier = Modifier
                .size(72.dp)
                .clip(RoundedCornerShape(36.dp))
                .background(TealContainer),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.CheckCircle,
                contentDescription = null,
                tint = TealPrimary,
                modifier = Modifier.size(44.dp)
            )
        }

        Text(
            text = "Pengiriman Selesai",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = SlateDark
        )
        Text(
            text = "Barang telah berhasil diserahkan kepada penerima.",
            style = MaterialTheme.typography.bodyMedium,
            color = SlateMedium
        )

        Spacer(modifier = Modifier.height(4.dp))

        // 2. Detail Penerima & Order
        Card(
            colors = CardDefaults.cardColors(containerColor = ZincCard),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, SlateBorder, RoundedCornerShape(12.dp))
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = null,
                        tint = TealPrimary
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Penerima",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        color = TealPrimary
                    )
                }
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = data.NamaPengguna,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = SlateDark
                )
                Text(
                    text = data.NamaAlamatPengguna,
                    style = MaterialTheme.typography.bodyMedium,
                    color = SlateMedium
                )

                Spacer(modifier = Modifier.height(12.dp))
                HorizontalDivider(color = SlateBorder)
                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text("Kode Order", style = MaterialTheme.typography.bodySmall, color = SlateMedium)
                        Text(data.KodeOrderSistem, fontWeight = FontWeight.SemiBold, fontSize = 13.sp, color = SlateDark)
                    }
                    Column(horizontalAlignment = Alignment.End) {
                        Text("Barang", style = MaterialTheme.typography.bodySmall, color = SlateMedium)
                        Text(data.NamaBarangInduk, fontWeight = FontWeight.SemiBold, fontSize = 13.sp, color = SlateDark)
                    }
                }
            }
        }

        // 3. Bukti Foto Penyerahan
        if (!buktiFotoUrl.isNullOrBlank()) {
            Card(
                colors = CardDefaults.cardColors(containerColor = Color.White),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, SlateBorder, RoundedCornerShape(12.dp))
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Bukti Serah Terima",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        color = SlateDark
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    AsyncImage(
                        model = buktiFotoUrl,
                        contentDescription = "Bukti Serah Terima",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(160.dp)
                            .clip(RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Crop
                    )
                }
            }
        }

        // 4. Ringkasan Pendapatan Kurir
        Card(
            colors = CardDefaults.cardColors(containerColor = TealContainer.copy(alpha = 0.4f)),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, TealPrimary.copy(alpha = 0.2f), RoundedCornerShape(12.dp))
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Payments, contentDescription = null, tint = TealPrimary)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Pendapatan Kurir",
                        fontWeight = FontWeight.SemiBold,
                        color = SlateDark
                    )
                }
                Text(
                    text = "Rp ${data.KurirPaid}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = TealPrimary
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        // 5. Tombol Selesai / Kembali
        Button(
            onClick = onFinishClick,
            colors = ButtonDefaults.buttonColors(containerColor = TealPrimary),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text("Selesai & Kembali", fontSize = 16.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SampaiUiPreview() {
    val mockData = TugasPengirimanProps(
        Id = 101L,
        IdTransaksi = 5001L,
        IdSeller = 201L,
        NamaSeller = "Toko Elektronik Makmur Jaya",
        IdPengguna = 301L,
        NamaPengguna = "Budi Santoso",
        IdAlamatGudang = 401L,
        NamaAlamatGudang = "Gudang A1, Jl. Industri No. 45",
        LongAlamatGudang = 106.78,
        LatAlamatGudang = -6.17,
        IdAlamatPengguna = 501L,
        NamaAlamatPengguna = "Jl. Melati No. 12, Jakarta Selatan",
        LongAlamatPengguna = 106.80,
        LatAlamatPengguna = -6.24,
        IdBarangInduk = 601L,
        NamaBarangInduk = "TV LED 43 Inch Smart TV",
        IdKategoriBarang = 701L,
        NamaKategoriBarang = "Elektronik Rumah Tangga",
        UrlFotoKategoriBarang = emptyList(),
        IdKurir = 801L,
        KodeOrderSistem = "ORD-2026-0820-001",
        Catatan = "",
        BeratBarang = 12,
        KendaraanRequired = "Motor Box",
        JenisPengiriman = "Non-Ekspres",
        JarakTempuh = "8.5 km",
        KurirPaid = 35000L,
        Status = StatusPengiriman.SAMPAI
    )

    MaterialTheme {
        SampaiUi(
            data = mockData,
            buktiFotoUrl = "https://via.placeholder.com/300",
            onFinishClick = { }
        )
    }
}