package com.example.burungkurirapp.ui.section.Tugas.page.Pengiriman.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Storefront
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
import com.example.burungkurirapp.ui.constant.color.Red100
import com.example.burungkurirapp.ui.constant.color.Red50
import com.example.burungkurirapp.ui.constant.color.Red500
import com.example.burungkurirapp.ui.constant.color.Red700
import com.example.burungkurirapp.ui.constant.color.Teal600
import com.example.burungkurirapp.ui.constant.enum.STatusPengiriman
import com.example.burungkurirapp.ui.section.Tugas.page.Pengiriman.TugasPengirimanProps

// Palet Fondasi Slate & Zinc
private val SlateDark = Color(0xFF0F172A)         // Slate 900
private val SlateMedium = Color(0xFF64748B)       // Slate 500
private val SlateBorder = Color(0xFFE2E8F0)       // Slate 200
private val ZincBackground = Color(0xFFF4F4F5)    // Zinc 100
private val ZincCard = Color(0xFFF8FAFC)          // Slate/Zinc 50

@Composable
fun PickedUpUi(
    data: TugasPengirimanProps,
) {
    Column(
        modifier = Modifier
            .wrapContentSize()
            .background(Color.White),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // 1. Banner Status Picked Up (Nuansa Soft Red sebagai penanda status)
        Card(
            colors = CardDefaults.cardColors(containerColor = Red50.copy(alpha = 0.6f)),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, Red100, RoundedCornerShape(12.dp))
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.CheckCircle,
                    contentDescription = null,
                    tint = Teal600,
                    modifier = Modifier.size(28.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text(
                        text = "Barang Sudah Diambil",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = SlateMedium
                    )
                    Text(
                        text = "Silakan tutup halaman ini dan ambil pengiriman lain jika ada.",
                        style = MaterialTheme.typography.bodySmall,
                        color = SlateMedium
                    )
                }
            }
        }

        // 2. Info Order & Seller
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
                        imageVector = Icons.Default.Storefront,
                        contentDescription = null,
                        tint = SlateMedium
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = data.NamaSeller,
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp,
                        color = SlateDark
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Kode Order: ${data.KodeOrderSistem}",
                    style = MaterialTheme.typography.bodySmall,
                    color = SlateMedium
                )
            }
        }

        // 3. Detail Barang yang Sudah Diambil
        Card(
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, SlateBorder, RoundedCornerShape(12.dp))
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Rincian Barang",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = SlateDark
                )
                Spacer(modifier = Modifier.height(8.dp))

                // Foto Referensi Barang
                if (data.UrlFotoKategoriBarang.isNotEmpty()) {
                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        items(data.UrlFotoKategoriBarang) { url ->
                            AsyncImage(
                                model = url,
                                contentDescription = "Foto Barang",
                                modifier = Modifier
                                    .size(80.dp)
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(ZincBackground),
                                contentScale = ContentScale.Crop
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                }

                Text(
                    text = data.NamaBarangInduk,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 15.sp,
                    color = SlateDark
                )
                Text(
                    text = "Kategori: ${data.NamaKategoriBarang}",
                    style = MaterialTheme.typography.bodySmall,
                    color = SlateMedium
                )
            }
        }

        // 4. Info Petunjuk Alur Sistem
        Card(
            colors = CardDefaults.cardColors(containerColor = ZincCard),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, SlateBorder, RoundedCornerShape(12.dp))
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.Top
            ) {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = null,
                    tint = SlateMedium
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Status pengantaran akan aktif otomatis begitu seluruh paket dalam batch selesai diambil.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = SlateMedium
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PickedUpUiPreview() {
    val mockData = TugasPengirimanProps(
        Id = 101L,
        IdTransaksi = 5001L,
        IdSeller = 201L,
        NamaSeller = "Toko Elektronik Makmur Jaya",
        IdPengguna = 301L,
        NamaPengguna = "Budi Santoso",
        IdAlamatGudang = 401L,
        NamaAlamatGudang = "Gudang A1, Jl. Industri No. 45, Jakarta Barat",
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
        UrlFotoKategoriBarang = listOf(
            "https://via.placeholder.com/150",
            "https://via.placeholder.com/150"
        ),
        IdKurir = 801L,
        KodeOrderSistem = "ORD-2026-0820-001",
        Catatan = "Ambil di gudang belakang",
        BeratBarang = 12,
        KendaraanRequired = "Motor Box",
        JenisPengiriman = "Non-Ekspres",
        JarakTempuh = "8.5 km",
        KurirPaid = 35000L,
        Status = STatusPengiriman.PICKED_UP
    )

    MaterialTheme {
        PickedUpUi(data = mockData)
    }
}