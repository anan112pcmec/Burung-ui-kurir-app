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
import androidx.compose.material.icons.filled.AddAPhoto
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Navigation
import androidx.compose.material.icons.filled.Send
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
private val TealPrimary = Color(0xFF0D9488)
private val SlateDark = Color(0xFF0F172A)
private val SlateMedium = Color(0xFF64748B)
private val SlateBorder = Color(0xFFE2E8F0)
private val ZincBackground = Color(0xFFF4F4F5)
private val ZincCard = Color(0xFFF8FAFC)

// Model Data Lokal untuk Historis Jejak Pengiriman (Sederhana)
data class JejakPengirimanItem(
    val id: Long,
    val waktu: String,
    val keterangan: String,
    val photoUrl: String? = null
)

@Composable
fun DiperjalananUi(
    data: TugasPengirimanProps,
    historisJejak: List<JejakPengirimanItem>,
    onNavigateToRecipient: (lat: Double, long: Double) -> Unit,
    onSendUpdateJejak: (keterangan: String, photoUrl: String?) -> Unit,
    onTakePhotoDelivered: () -> Unit,
    onConfirmDelivered: () -> Unit,
    modifier: Modifier = Modifier
) {
    // State lokal form update jejak (opsional)
    var inputKeteranganJejak by remember { mutableStateOf("") }
    var optionalJejakPhotoUrl by remember { mutableStateOf<String?>(null) }

    // State lokal foto bukti penyerahan akhir (wajib untuk konfirmasi sampai)
    var finalDeliveredPhotoUrl by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = modifier
            .wrapContentSize()
            .background(Color.White),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // 1. Lokasi Tujuan Pengantaran (Penerima)
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
                        text = "Tujuan Pengantaran",
                        style = MaterialTheme.typography.labelLarge,
                        color = TealPrimary,
                        fontWeight = FontWeight.SemiBold
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
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

            }
        }

        // 2. Context Informasi Barang Bawaan
        Card(
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, SlateBorder, RoundedCornerShape(12.dp))
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Barang yang Dibawa",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = SlateDark
                )
                Spacer(modifier = Modifier.height(8.dp))

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
                                    .size(70.dp)
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(ZincBackground),
                                contentScale = ContentScale.Crop
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                }

                Text(
                    text = data.NamaBarangInduk,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 15.sp,
                    color = SlateDark
                )
                Text(
                    text = "Kategori: ${data.NamaKategoriBarang} | Berat: ${data.BeratBarang} kg",
                    style = MaterialTheme.typography.bodySmall,
                    color = SlateMedium
                )
            }
        }

        // 3. Form Kirim Update Jejak Perjalanan (Keterangan & Foto Opsional)
        Card(
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, SlateBorder, RoundedCornerShape(12.dp))
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Update Jejak Perjalanan",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = SlateDark
                )
                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = inputKeteranganJejak,
                    onValueChange = { inputKeteranganJejak = it },
                    placeholder = { Text("Contoh: Terjebak macet, Sedang berteduh, dll.") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = TealPrimary,
                        unfocusedBorderColor = SlateBorder
                    )
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedButton(
                        onClick = { /* Trigger kamera opsional */ },
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = SlateDark),
                        border = ButtonDefaults.outlinedButtonBorder.copy(brush = androidx.compose.ui.graphics.SolidColor(SlateBorder))
                    ) {
                        Icon(Icons.Default.AddAPhoto, contentDescription = null, modifier = Modifier.size(18.dp))
                        Spacer(modifier = Modifier.width(6.dp))
                        Text("Foto (Opsional)", fontSize = 12.sp)
                    }

                    Button(
                        onClick = {
                            if (inputKeteranganJejak.isNotBlank()) {
                                onSendUpdateJejak(inputKeteranganJejak, optionalJejakPhotoUrl)
                                inputKeteranganJejak = ""
                                optionalJejakPhotoUrl = null
                            }
                        },
                        enabled = inputKeteranganJejak.isNotBlank(),
                        colors = ButtonDefaults.buttonColors(containerColor = TealPrimary),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Icon(Icons.Default.Send, contentDescription = null, modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(6.dp))
                        Text("Kirim Jejak", fontSize = 13.sp)
                    }
                }
            }
        }

        // 4. Carousel / List Horizontal Historis Jejak Perjalanan (Terbaru Paling Depan)
        if (historisJejak.isNotEmpty()) {
            Column {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.History, contentDescription = null, tint = SlateMedium, modifier = Modifier.size(20.dp))
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "Riwayat Update Jejak (${historisJejak.size})",
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp,
                        color = SlateDark
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))

                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(historisJejak) { item ->
                        Card(
                            colors = CardDefaults.cardColors(containerColor = ZincCard),
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier
                                .width(220.dp)
                                .border(1.dp, SlateBorder, RoundedCornerShape(8.dp))
                        ) {
                            Column(modifier = Modifier.padding(12.dp)) {
                                Text(
                                    text = item.waktu,
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = TealPrimary
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = item.keterangan,
                                    fontSize = 13.sp,
                                    color = SlateDark,
                                    maxLines = 2
                                )
                                if (item.photoUrl != null) {
                                    Spacer(modifier = Modifier.height(8.dp))
                                    AsyncImage(
                                        model = item.photoUrl,
                                        contentDescription = "Foto Jejak",
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(80.dp)
                                            .clip(RoundedCornerShape(6.dp)),
                                        contentScale = ContentScale.Crop
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }

        // 5. Section Konfirmasi Barang Sampai (Foto Wajib)
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
                    text = "Bukti Serah Terima Barang",
                    fontWeight = FontWeight.Bold,
                    color = SlateDark,
                    modifier = Modifier.align(Alignment.Start)
                )
                Spacer(modifier = Modifier.height(12.dp))

                if (finalDeliveredPhotoUrl != null) {
                    AsyncImage(
                        model = finalDeliveredPhotoUrl,
                        contentDescription = "Bukti Sampai",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(180.dp)
                            .clip(RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedButton(
                        onClick = onTakePhotoDelivered,
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = TealPrimary),
                        border = ButtonDefaults.outlinedButtonBorder.copy(brush = androidx.compose.ui.graphics.SolidColor(TealPrimary))
                    ) {
                        Text("Foto Ulang Bukti")
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
                            onClick = onTakePhotoDelivered,
                            colors = ButtonDefaults.outlinedButtonColors(contentColor = TealPrimary),
                            border = ButtonDefaults.outlinedButtonBorder.copy(brush = androidx.compose.ui.graphics.SolidColor(TealPrimary))
                        ) {
                            Icon(Icons.Default.CameraAlt, contentDescription = null)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Foto Penerima / Barang Sampai")
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        // 6. Tombol Eksekusi Status Sampai
        Button(
            onClick = {
//                finalDeliveredPhotoUrl?.let { photo ->
//                    onConfirmDelivered(photo)
//                }
                onConfirmDelivered()
            },
//            enabled = finalDeliveredPhotoUrl != null,
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
            Text("Konfirmasi Barang Sampai", fontSize = 16.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DiperjalananUiPreview() {
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
        UrlFotoKategoriBarang = listOf("https://via.placeholder.com/150"),
        IdKurir = 801L,
        KodeOrderSistem = "ORD-2026-0820-001",
        Catatan = "",
        BeratBarang = 12,
        KendaraanRequired = "Motor Box",
        JenisPengiriman = "Non-Ekspres",
        JarakTempuh = "8.5 km",
        KurirPaid = 35000L,
        Status = STatusPengiriman.DI_PERJALANAN
    )

    val mockHistoris = listOf(
        JejakPengirimanItem(1, "14:20", "Sedang berteduh karena hujan deras di daerah Tebet"),
        JejakPengirimanItem(2, "13:45", "Terjebak macet di persimpangan Kuningan")
    )

    MaterialTheme {
        DiperjalananUi(
            data = mockData,
            historisJejak = mockHistoris,
            onNavigateToRecipient = { _, _ -> },
            onSendUpdateJejak = { _, _ -> },
            onTakePhotoDelivered = { },
            onConfirmDelivered = { }
        )
    }
}