package com.example.burungkurirapp.ui.section.Tugas.page.Pengiriman.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
import com.example.burungkurirapp.ui.constant.enum.STatusPengiriman
import com.example.burungkurirapp.ui.section.Tugas.page.Pengiriman.TugasPengirimanProps

// Skema Warna: Teal, Slate, Zinc, White
private val TealPrimary = Color(0xFF0D9488)       // Teal 600
private val TealDark = Color(0xFF0F766E)          // Teal 700
private val TealContainer = Color(0xFFCCFBF1)     // Teal 100
private val SlateDark = Color(0xFF0F172A)         // Slate 900
private val SlateMedium = Color(0xFF64748B)       // Slate 500
private val SlateBorder = Color(0xFFE2E8F0)       // Slate 200
private val ZincBackground = Color(0xFFF4F4F5)    // Zinc 100
private val ZincCard = Color(0xFFF8FAFC)          // Slate/Zinc 50

@Composable
fun WaitingUi(
    data: TugasPengirimanProps,
    onNavigateToWarehouse: (lat: Double, long: Double) -> Unit,
    onTakePhotoClick: () -> Unit,
    onConfirmPickedUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    var capturedPhotoUrl by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = modifier
            .wrapContentSize()
            .background(Color.White),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // 1. Lokasi Penjemputan (Gudang/Seller)
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
                        text = "Lokasi Penjemputan",
                        style = MaterialTheme.typography.labelLarge,
                        color = TealPrimary,
                        fontWeight = FontWeight.SemiBold
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = data.NamaSeller,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = SlateDark
                )
                Text(
                    text = data.NamaAlamatGudang,
                    style = MaterialTheme.typography.bodyMedium,
                    color = SlateMedium
                )
                Spacer(modifier = Modifier.height(12.dp))
            }
        }

        // 2. Detail Barang & Visual
        Card(
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, SlateBorder, RoundedCornerShape(12.dp))
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Detail Barang",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = SlateDark
                )
                Spacer(modifier = Modifier.height(8.dp))

                // Galeri Foto Referensi Barang
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

                Spacer(modifier = Modifier.height(8.dp))
                HorizontalDivider(color = SlateBorder)
                Spacer(modifier = Modifier.height(8.dp))

                // Informasi Fisik Barang
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Berat: ${data.BeratBarang} kg",
                        style = MaterialTheme.typography.bodyMedium,
                        color = SlateDark
                    )
                    Text(
                        text = "Kendaraan: ${data.KendaraanRequired}",
                        style = MaterialTheme.typography.bodyMedium,
                        color = SlateDark
                    )
                }
            }
        }

        // 3. Catatan Khusus Seller (Jika ada)
        if (data.Catatan.isNotBlank()) {
            Card(
                colors = CardDefaults.cardColors(containerColor = TealContainer.copy(alpha = 0.5f)),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, TealPrimary.copy(alpha = 0.3f), RoundedCornerShape(12.dp))
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.Top
                ) {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = null,
                        tint = TealDark
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Text(
                            text = "Catatan Penjemputan",
                            fontWeight = FontWeight.Bold,
                            color = TealDark
                        )
                        Text(
                            text = data.Catatan,
                            style = MaterialTheme.typography.bodyMedium,
                            color = SlateDark
                        )
                    }
                }
            }
        }

        // 4. Akses Kamera & Preview Foto Bukti Picked Up
        Card(
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, SlateBorder, RoundedCornerShape(12.dp))
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Bukti Penjemputan Barang",
                    fontWeight = FontWeight.Bold,
                    color = SlateDark,
                    modifier = Modifier.align(Alignment.Start)
                )
                Spacer(modifier = Modifier.height(12.dp))

                if (capturedPhotoUrl != null) {
                    AsyncImage(
                        model = capturedPhotoUrl,
                        contentDescription = "Hasil Foto Barang",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(180.dp)
                            .clip(RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedButton(
                        onClick = onTakePhotoClick,
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = TealPrimary),
                        border = ButtonDefaults.outlinedButtonBorder.copy(brush = androidx.compose.ui.graphics.SolidColor(TealPrimary))
                    ) {
                        Text("Foto Ulang")
                    }
                } else {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(120.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(ZincBackground)
                            .border(1.dp, SlateBorder, RoundedCornerShape(8.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        OutlinedButton(
                            onClick = onTakePhotoClick,
                            colors = ButtonDefaults.outlinedButtonColors(contentColor = TealPrimary),
                            border = ButtonDefaults.outlinedButtonBorder.copy(brush = androidx.compose.ui.graphics.SolidColor(TealPrimary))
                        ) {
                            Icon(Icons.Default.CameraAlt, contentDescription = null)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Ambil Foto Barang")
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        // 5. Tombol Eksekusi Aksi Picked Up
        Button(
            onClick = {
                onConfirmPickedUp()
//                capturedPhotoUrl?.let { photo ->
//                    onConfirmPickedUp(photo)
//                }
            },
//            enabled = capturedPhotoUrl != null,
            colors = ButtonDefaults.buttonColors(
                containerColor = TealPrimary,
                contentColor = Color.White,
                disabledContainerColor = ZincBackground,
                disabledContentColor = SlateMedium
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text("Konfirmasi Picked Up", fontSize = 16.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun WaitingUiPreview() {
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
        Catatan = "Barang lumayan berat dan pecah belah. Ambil dari pintu samping gudang dan konfirmasi ke Mas Yanto.",
        BeratBarang = 12,
        KendaraanRequired = "Motor Box",
        JenisPengiriman = "Non-Ekspres",
        JarakTempuh = "8.5 km",
        KurirPaid = 35000L,
        Status = STatusPengiriman.WAITING
    )

    MaterialTheme {
        WaitingUi(
            data = mockData,
            onNavigateToWarehouse = { _, _ -> },
            onTakePhotoClick = { },
            onConfirmPickedUp = { }
        )
    }
}