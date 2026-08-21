package com.example.burungkurirapp.ui.section.Details.page.Bid

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.burungkurirapp.ui.constant.color.*
import com.example.burungkurirapp.ui.constant.types.AlamatGudang
import com.example.burungkurirapp.ui.constant.types.AlamatPengguna
import com.example.burungkurirapp.ui.constant.types.BidKurirData
import com.example.burungkurirapp.ui.constant.types.Pengiriman
import com.example.burungkurirapp.ui.constant.types.PengirimanEks
import com.example.burungkurirapp.ui.constant.types.Transaksi
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun DetailsBidPage(data: BidKurirData) {
    val lokasiAlamat = LatLng(data.Latitude, data.Longitude)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(lokasiAlamat, 15f)
    }

    val ListPengirimanEks: List<PengirimanEks>? = null
    val ListPengiriman: List<Pengiriman> = listOf(
        Pengiriman(
            Id = 1,
            IdTransaksi = 101,
            IdSeller = 201,
            IdAlamatGudang = 301,
            IdAlamatPengguna = 401,
            IdKurir = 501,
            BeratBarang = 1200,
            KendaraanRequired = "Motor",
            JenisPengiriman = "Instant",
            JarakTempuh = "4.5 km",
            KurirPaid = "15000",
            Status = "WAITING",
            CreatedAt = "2026-08-21 08:30:00",
            AlamatGudang = AlamatGudang(
                Id = 301,
                IdSeller = 201,
                PanggilanAlamat = "Gudang Utama",
                NomorTelephone = "081234567890",
                NamaAlamat = "Jl. Sudirman No. 10",
                Provinsi = "DKI Jakarta",
                Kota = "Jakarta Selatan",
                KodePos = "12190",
                KodeNegara = "ID",
                Deskripsi = "Dekat gedung oranye",
                Longitude = 106.816666,
                Latitude = -6.200000,
                CreatedAt = "2026-01-01 00:00:00",
                UpdatedAt = "2026-01-01 00:00:00"
            ),
            AlamatPengguna = AlamatPengguna(
                Id = 401,
                IdPengguna = 901,
                PanggilanAlamat = "Rumah",
                NomorTelephone = "089876543210",
                NamaAlamat = "Jl. Gatot Subroto No. 45",
                Provinsi = "DKI Jakarta",
                Kota = "Jakarta Selatan",
                KodeNegara = "ID",
                KodePos = "12930",
                Deskripsi = "Pagar hitam",
                Longitude = 106.820000,
                Latitude = -6.210000,
                CreatedAt = "2026-01-01 00:00:00",
                UpdatedAt = "2026-01-01 00:00:00"
            ),
            Transaksi = Transaksi(
                id = 101L,
                idPengguna = 901L,
                idSeller = 201,
                idBarangInduk = 5001L,
                idKategoriBarang = 10L,
                idAlamatPengguna = 401L,
                gambarUrlKategoriBarang = listOf("https://example.com/img1.jpg"),
                alamatPengguna = AlamatPengguna(
                    Id = 401, IdPengguna = 901, PanggilanAlamat = "Rumah", NomorTelephone = "089876543210",
                    NamaAlamat = "Jl. Gatot Subroto No. 45", Provinsi = "DKI Jakarta", Kota = "Jakarta Selatan",
                    KodeNegara = "ID", KodePos = "12930", Deskripsi = "Pagar hitam", Longitude = 106.820000,
                    Latitude = -6.210000, CreatedAt = "2026-01-01 00:00:00", UpdatedAt = "2026-01-01 00:00:00"
                ),
                idAlamatGudang = 301L,
                alamatGudang = AlamatGudang(
                    Id = 301, IdSeller = 201, PanggilanAlamat = "Gudang Utama", NomorTelephone = "081234567890",
                    NamaAlamat = "Jl. Sudirman No. 10", Provinsi = "DKI Jakarta", Kota = "Jakarta Selatan",
                    KodePos = "12190", KodeNegara = "ID", Deskripsi = "Dekat gedung oranye", Longitude = 106.816666,
                    Latitude = -6.200000, CreatedAt = "2026-01-01 00:00:00", UpdatedAt = "2026-01-01 00:00:00"
                ),
                idAlamatEkspedisi = 1L,
                idPembayaran = 10L,
                idDiskon = null,
                kendaraanPengiriman = "Motor",
                jenisPengiriman = "Instant",
                jarakTempuh = "4.5 km",
                beratTotalKg = 1,
                kodeOrderSistem = "ORD-2026-0821-001",
                kodeResiEkspedisi = "RESI12345",
                status = "WAITING",
                dibatalkanOleh = "",
                catatan = "Hati-hati barang pecah belah",
                kuantitasBarang = 1,
                isEkspedisi = false,
                sellerPaid = 50000L,
                kurirPaid = 15000L,
                sistemPaid = 5000L,
                ekspedisiPaid = 0L,
                total = 70000L,
                reviewed = false,
                createdAt = "2026-08-21 08:00:00",
                updatedAt = "2026-08-21 08:00:00"
            )
        ),
        Pengiriman(
            Id = 2,
            IdTransaksi = 102,
            IdSeller = 202,
            IdAlamatGudang = 302,
            IdAlamatPengguna = 402,
            IdKurir = 502,
            BeratBarang = 500,
            KendaraanRequired = "Motor",
            JenisPengiriman = "Sameday",
            JarakTempuh = "8.2 km",
            KurirPaid = "22000",
            Status = "PICKED_UP",
            CreatedAt = "2026-08-21 09:00:00",
            AlamatGudang = AlamatGudang(
                Id = 302,
                IdSeller = 202,
                PanggilanAlamat = "Hub Bandung",
                NomorTelephone = "081298765432",
                NamaAlamat = "Jl. Asia Afrika No. 50",
                Provinsi = "Jawa Barat",
                Kota = "Bandung",
                KodePos = "40111",
                KodeNegara = "ID",
                Deskripsi = "Seberang hotel",
                Longitude = 107.609810,
                Latitude = -6.914744,
                CreatedAt = "2026-01-01 00:00:00",
                UpdatedAt = "2026-01-01 00:00:00"
            ),
            AlamatPengguna = AlamatPengguna(
                Id = 402,
                IdPengguna = 902,
                PanggilanAlamat = "Kantor",
                NomorTelephone = "085612345678",
                NamaAlamat = "Jl. Dago No. 100",
                Provinsi = "Jawa Barat",
                Kota = "Bandung",
                KodeNegara = "ID",
                KodePos = "40135",
                Deskripsi = "Lantai 3",
                Longitude = 107.610000,
                Latitude = -6.920000,
                CreatedAt = "2026-01-01 00:00:00",
                UpdatedAt = "2026-01-01 00:00:00"
            ),
            Transaksi = Transaksi(
                id = 102L,
                idPengguna = 902L,
                idSeller = 202,
                idBarangInduk = 5002L,
                idKategoriBarang = 11L,
                idAlamatPengguna = 402L,
                gambarUrlKategoriBarang = listOf("https://example.com/img2.jpg"),
                alamatPengguna = AlamatPengguna(
                    Id = 402, IdPengguna = 902, PanggilanAlamat = "Kantor", NomorTelephone = "085612345678",
                    NamaAlamat = "Jl. Dago No. 100", Provinsi = "Jawa Barat", Kota = "Bandung",
                    KodeNegara = "ID", KodePos = "40135", Deskripsi = "Lantai 3", Longitude = 107.610000,
                    Latitude = -6.920000, CreatedAt = "2026-01-01 00:00:00", UpdatedAt = "2026-01-01 00:00:00"
                ),
                idAlamatGudang = 302L,
                alamatGudang = AlamatGudang(
                    Id = 302, IdSeller = 202, PanggilanAlamat = "Hub Bandung", NomorTelephone = "081298765432",
                    NamaAlamat = "Jl. Asia Afrika No. 50", Provinsi = "Jawa Barat", Kota = "Bandung",
                    KodePos = "40111", KodeNegara = "ID", Deskripsi = "Seberang hotel", Longitude = 107.609810,
                    Latitude = -6.914744, CreatedAt = "2026-01-01 00:00:00", UpdatedAt = "2026-01-01 00:00:00"
                ),
                idAlamatEkspedisi = 1L,
                idPembayaran = 11L,
                idDiskon = 2L,
                kendaraanPengiriman = "Motor",
                jenisPengiriman = "Sameday",
                jarakTempuh = "8.2 km",
                beratTotalKg = 1,
                kodeOrderSistem = "ORD-2026-0821-002",
                kodeResiEkspedisi = "RESI67890",
                status = "PICKED_UP",
                dibatalkanOleh = "",
                catatan = "Langsung kirim",
                kuantitasBarang = 2,
                isEkspedisi = false,
                sellerPaid = 40000L,
                kurirPaid = 22000L,
                sistemPaid = 4000L,
                ekspedisiPaid = 0L,
                total = 66000L,
                reviewed = false,
                createdAt = "2026-08-21 08:30:00",
                updatedAt = "2026-08-21 08:30:00"
            )
        )
    )

    val isPreview = LocalInspectionMode.current

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp, vertical = 15.dp),
        verticalArrangement = Arrangement.spacedBy(13.dp)
    ) {
        // ─── 1. HEADER SECTION ───
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "DETAIL BID KURIR",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = FontFamily.SansSerif,
                        letterSpacing = 0.8.sp,
                        color = Zinc400
                    )
                    Text(
                        text = data.JenisPengiriman,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.SansSerif,
                        letterSpacing = (-0.4).sp,
                        color = Slate950
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Mode: ${data.Mode}",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        fontFamily = FontFamily.SansSerif,
                        color = Zinc600
                    )
                }

                // Badge Tipe & Slot
                Column(horizontalAlignment = Alignment.End) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(6.dp))
                            .background(if (data.IsEkspedisi) Color(0xFFEFF6FF) else Zinc100)
                            .border(
                                1.dp,
                                if (data.IsEkspedisi) Color(0xFFBFDBFE) else Zinc300,
                                RoundedCornerShape(6.dp)
                            )
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                    ) {
                        Text(
                            text = if (data.IsEkspedisi) "EKSPEDISI" else "REGULER",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Monospace,
                            color = if (data.IsEkspedisi) Color(0xFF1D4ED8) else Slate950
                        )
                    }
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "Sisa Slot: ${data.SlotTersisa}",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = FontFamily.SansSerif,
                        color = Zinc600
                    )
                }
            }
        }

        item { HorizontalDivider(color = Zinc200, thickness = 1.dp) }

        // ─── 2. MAP SECTION ───
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                if (isPreview) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(8.dp))
                            .background(Zinc100)
                            .border(1.dp, Zinc300, RoundedCornerShape(8.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Google Maps Placeholder\nLat: ${data.Latitude}, Lng: ${data.Longitude}",
                            textAlign = TextAlign.Center,
                            color = Zinc400,
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Medium,
                            fontSize = 12.sp
                        )
                    }
                } else {
//                    GoogleMap(
//                        modifier = Modifier
//                            .fillMaxSize()
//                            .clip(RoundedCornerShape(8.dp)),
//                        cameraPositionState = cameraPositionState
//                    )

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(8.dp))
                            .background(Zinc100)
                            .border(1.dp, Zinc300, RoundedCornerShape(8.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Maps Placeholder\nLat: ${data.Latitude}, Lng: ${data.Longitude}",
                            textAlign = TextAlign.Center,
                            color = Zinc400,
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Medium,
                            fontSize = 12.sp
                        )
                    }
                }
            }
        }

        // ─── 3. INFORMASI DETAIL BID ───
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .border(1.dp, Zinc200, RoundedCornerShape(10.dp))
                    .background(Color.White)
                    .padding(14.dp)
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    // Alamat & Lokasi
                    Column {
                        Text(
                            text = "ALAMAT PENJEMPUTAN",
                            fontSize = 9.5.sp,
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = FontFamily.SansSerif,
                            letterSpacing = 0.6.sp,
                            color = Zinc400
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = "${data.Alamat}, ${data.Kota}, ${data.Provinsi}",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = FontFamily.SansSerif,
                            letterSpacing = (-0.2).sp,
                            color = Slate950
                        )
                    }

                    // Kapasitas & Jadwal
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text(
                                text = "KAPASITAS MAKSIMAL",
                                fontSize = 9.5.sp,
                                fontWeight = FontWeight.SemiBold,
                                fontFamily = FontFamily.SansSerif,
                                letterSpacing = 0.6.sp,
                                color = Zinc400
                            )
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                text = "${data.MaxKg} KG",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily.Monospace,
                                color = Slate950
                            )
                        }

                        Column(horizontalAlignment = Alignment.End) {
                            Text(
                                text = "PERIODE JADWAL",
                                fontSize = 9.5.sp,
                                fontWeight = FontWeight.SemiBold,
                                fontFamily = FontFamily.SansSerif,
                                letterSpacing = 0.6.sp,
                                color = Zinc400
                            )
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                text = "${data.Dimulai} - ${data.Selesai}",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Medium,
                                fontFamily = FontFamily.Monospace,
                                color = Slate950
                            )
                        }
                    }

                    HorizontalDivider(color = Zinc100, thickness = 1.dp)

                    // Koordinat & Created At
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text(
                                text = "KOORDINAT",
                                fontSize = 9.sp,
                                fontWeight = FontWeight.SemiBold,
                                fontFamily = FontFamily.SansSerif,
                                letterSpacing = 0.5.sp,
                                color = Zinc400
                            )
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                text = "${data.Latitude}, ${data.Longitude}",
                                fontSize = 10.5.sp,
                                fontFamily = FontFamily.Monospace,
                                fontWeight = FontWeight.Medium,
                                color = Zinc600
                            )
                        }

                        Column(horizontalAlignment = Alignment.End) {
                            Text(
                                text = "DIBUAT PADA",
                                fontSize = 9.sp,
                                fontWeight = FontWeight.SemiBold,
                                fontFamily = FontFamily.SansSerif,
                                letterSpacing = 0.5.sp,
                                color = Zinc400
                            )
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                text = data.CreatedAt,
                                fontSize = 10.5.sp,
                                fontFamily = FontFamily.Monospace,
                                fontWeight = FontWeight.Medium,
                                color = Zinc600
                            )
                        }
                    }
                }
            }
        }

        // ─── 4. JUDUL SECTION LIST PENGIRIMAN ───
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 6.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = if (data.IsEkspedisi) "DAFTAR PENGIRIMAN EKSPEDISI" else "DAFTAR PENGIRIMAN",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif,
                    letterSpacing = 0.6.sp,
                    color = Zinc600
                )

                val count = if (data.IsEkspedisi) {
                    ListPengirimanEks?.size ?: 0
                } else {
                    ListPengiriman?.size ?: 0
                }

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .background(Zinc100)
                        .padding(horizontal = 8.dp, vertical = 2.dp)
                ) {
                    Text(
                        text = "$count Item",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = FontFamily.Monospace,
                        color = Slate950
                    )
                }
            }
        }

        // ─── 5. LIST ITEM PENGIRIMAN (KONDISIONAL) ───
        if (data.IsEkspedisi) {
            val listEks = ListPengirimanEks
            if (listEks.isNullOrEmpty()) {
                item { EmptyPengirimanCard() }
            } else {
                items(listEks) { itemEks ->
                    ItemPengirimanEksCard(itemEks)
                }
            }
        } else {
            val listReg = ListPengiriman
            if (listReg.isNullOrEmpty()) {
                item { EmptyPengirimanCard() }
            } else {
                items(listReg) { itemReg ->
                    ItemPengirimanCard(itemReg)
                }
            }
        }
    }
}

// ─── COMPOSABLE CARD LIST ITEM (REGULER) ───
@Composable
fun ItemPengirimanCard(item: Pengiriman) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .border(1.dp, Zinc200, RoundedCornerShape(10.dp))
            .background(Color.White)
            .padding(14.dp)
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            // ─── 1. HEADER: TRX ID & STATUS BADGE ───
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "TRANSAKSI #${item.IdTransaksi}",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Monospace,
                        color = Slate950
                    )
                    Text(
                        text = "ID Pengiriman: #${item.Id}",
                        fontSize = 10.sp,
                        fontFamily = FontFamily.SansSerif,
                        color = Zinc400
                    )
                }

                // Status Badge Dynamic Styling
                val (statusBg, statusTextColor) = when (item.Status.uppercase()) {
                    "SELESAI", "DELIVERED", "PAID" -> Color(0xFFDCFCE7) to Color(0xFF15803D)
                    "PROSES", "ON_DELIVERY", "PICKED_UP" -> Color(0xFFDBEAFE) to Color(0xFF1D4ED8)
                    else -> Zinc100 to Slate950
                }

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .background(statusBg)
                        .padding(horizontal = 8.dp, vertical = 3.dp)
                ) {
                    Text(
                        text = item.Status.uppercase(),
                        fontSize = 9.5.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Monospace,
                        color = statusTextColor
                    )
                }
            }

            HorizontalDivider(color = Zinc100, thickness = 1.dp)

            // ─── 2. SPECS: LAYANAN, KENDARAAN, BERAT & JARAK ───
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "LAYANAN & KENDARAAN",
                        fontSize = 8.5.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = FontFamily.SansSerif,
                        letterSpacing = 0.5.sp,
                        color = Zinc400
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = "${item.JenisPengiriman} • ${item.KendaraanRequired}",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = FontFamily.SansSerif,
                        color = Slate950
                    )
                }

                Column(horizontalAlignment = Alignment.End) {
                    Text(
                        text = "BERAT & JARAK",
                        fontSize = 8.5.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = FontFamily.SansSerif,
                        letterSpacing = 0.5.sp,
                        color = Zinc400
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = "${item.BeratBarang} Kg • ${item.JarakTempuh}",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        fontFamily = FontFamily.Monospace,
                        color = Slate950
                    )
                }
            }

            HorizontalDivider(color = Zinc100, thickness = 1.dp)

            // ─── 3. FOOTER: ONGKIR KURIR & TANGGAL ───
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "ONGKIR KURIR",
                        fontSize = 8.5.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = FontFamily.SansSerif,
                        letterSpacing = 0.5.sp,
                        color = Zinc400
                    )
                    Spacer(modifier = Modifier.height(1.dp))
                    Text(
                        text = item.KurirPaid,
                        fontSize = 13.5.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Monospace,
                        color = Color(0xFF16A34A)
                    )
                }

                Column(horizontalAlignment = Alignment.End) {
                    Text(
                        text = "TANGGAL",
                        fontSize = 8.5.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = FontFamily.SansSerif,
                        letterSpacing = 0.5.sp,
                        color = Zinc400
                    )
                    Spacer(modifier = Modifier.height(1.dp))
                    Text(
                        text = item.CreatedAt,
                        fontSize = 10.5.sp,
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Medium,
                        color = Zinc600
                    )
                }
            }
        }
    }
}
// ─── COMPOSABLE CARD LIST ITEM (EKSPEDISI) ───
@Composable
fun ItemPengirimanEksCard(item: PengirimanEks) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .border(1.dp, Color(0xFFBFDBFE), RoundedCornerShape(10.dp))
            .background(Color.White)
            .padding(14.dp)
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            // ─── 1. HEADER: TRX ID & STATUS BADGE ───
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "EKSPEDISI #${item.IdTransaksi}",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Monospace,
                        color = Color(0xFF1D4ED8)
                    )
                    Text(
                        text = "ID Pengiriman Eks: #${item.Id}",
                        fontSize = 10.sp,
                        fontFamily = FontFamily.SansSerif,
                        color = Zinc400
                    )
                }

                // Dynamic Status Badge
                val (statusBg, statusTextColor) = when (item.Status.uppercase()) {
                    "SELESAI", "DELIVERED", "PAID" -> Color(0xFFDCFCE7) to Color(0xFF15803D)
                    "PROSES", "ON_DELIVERY", "PICKED_UP" -> Color(0xFFDBEAFE) to Color(0xFF1D4ED8)
                    else -> Zinc100 to Slate950
                }

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .background(statusBg)
                        .padding(horizontal = 8.dp, vertical = 3.dp)
                ) {
                    Text(
                        text = item.Status.uppercase(),
                        fontSize = 9.5.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Monospace,
                        color = statusTextColor
                    )
                }
            }

            HorizontalDivider(color = Zinc100, thickness = 1.dp)

            // ─── 2. SPECS: LAYANAN, KENDARAAN, BERAT & JARAK ───
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "LAYANAN & KENDARAAN",
                        fontSize = 8.5.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = FontFamily.SansSerif,
                        letterSpacing = 0.5.sp,
                        color = Zinc400
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = "${item.JenisPengiriman} • ${item.KendaraanRequired}",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = FontFamily.SansSerif,
                        color = Slate950
                    )
                }

                Column(horizontalAlignment = Alignment.End) {
                    Text(
                        text = "MUATAN & JARAK",
                        fontSize = 8.5.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = FontFamily.SansSerif,
                        letterSpacing = 0.5.sp,
                        color = Zinc400
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = "${item.BeratBarang} Kg • ${item.JarakTempuh}",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        fontFamily = FontFamily.Monospace,
                        color = Slate950
                    )
                }
            }

            HorizontalDivider(color = Zinc100, thickness = 1.dp)

            // ─── 3. FOOTER: ONGKIR KURIR & TANGGAL ───
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "ONGKIR KURIR",
                        fontSize = 8.5.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = FontFamily.SansSerif,
                        letterSpacing = 0.5.sp,
                        color = Zinc400
                    )
                    Spacer(modifier = Modifier.height(1.dp))
                    Text(
                        text = item.KurirPaid,
                        fontSize = 13.5.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Monospace,
                        color = Color(0xFF16A34A)
                    )
                }

                Column(horizontalAlignment = Alignment.End) {
                    Text(
                        text = "TANGGAL",
                        fontSize = 8.5.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = FontFamily.SansSerif,
                        letterSpacing = 0.5.sp,
                        color = Zinc400
                    )
                    Spacer(modifier = Modifier.height(1.dp))
                    Text(
                        text = item.CreatedAt,
                        fontSize = 10.5.sp,
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Medium,
                        color = Zinc600
                    )
                }
            }
        }
    }
}

// ─── FALLBACK EMPTY STATE ───
@Composable
fun EmptyPengirimanCard() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(Zinc100)
            .border(1.dp, Zinc200, RoundedCornerShape(8.dp))
            .padding(20.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Tidak ada daftar pengiriman",
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = FontFamily.SansSerif,
            color = Zinc400
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PrevDetailsBidPage() {
    val dummyListPengiriman = listOf(
        Pengiriman(
            Id = 1,
            IdTransaksi = 101,
            IdSeller = 12,
            IdAlamatGudang = 1,
            IdAlamatPengguna = 2,
            IdKurir = 5,
            BeratBarang = 2500, // dalam gram
            KendaraanRequired = "Motor",
            JenisPengiriman = "Instant",
            JarakTempuh = "4.5 km",
            KurirPaid = "15000",
            Status = "Dalam Perjalanan",
            CreatedAt = "18-08-2026 08:30:00",
            AlamatGudang = null,
            AlamatPengguna = null,
            Transaksi = null,
        ),
        Pengiriman(
            Id = 2,
            IdTransaksi = 102,
            IdSeller = 15,
            IdAlamatGudang = 1,
            IdAlamatPengguna = 4,
            IdKurir = 8,
            BeratBarang = 7000,
            KendaraanRequired = "Mobil",
            JenisPengiriman = "Same Day",
            JarakTempuh = "12.0 km",
            KurirPaid = "45000",
            Status = "Menunggu Pickup",
            CreatedAt = "18-08-2026 09:15:00",
            AlamatGudang = null,
            AlamatPengguna = null,
            Transaksi = null
        ),
        Pengiriman(
            Id = 3,
            IdTransaksi = 103,
            IdSeller = 10,
            IdAlamatGudang = 2,
            IdAlamatPengguna = 7,
            IdKurir = 3,
            BeratBarang = 1200,
            KendaraanRequired = "Motor",
            JenisPengiriman = "Reguler",
            JarakTempuh = "2.1 km",
            KurirPaid = "10000",
            Status = "Selesai",
            CreatedAt = "17-08-2026 14:20:00",
            AlamatGudang = null,
            Transaksi = null,
            AlamatPengguna = null
        )
    )
    val dummyData = BidKurirData(
        Id = 101,
        IdKurir = 12,
        JenisPengiriman = "Instant Delivery",
        Mode = "Motorcycle",
        Provinsi = "DKI Jakarta",
        Kota = "Jakarta Selatan",
        IsEkspedisi = false,
        Alamat = "Jl. Jendral Sudirman No. 45",
        Longitude = 106.8229,
        Latitude = -6.2088,
        MaxKg = 25,
        SlotTersisa = 3,
        Dimulai = "08:00",
        Selesai = "17:00",
        CreatedAt = "18-08-2026",
        UpdatedAt = "18-08-2026",
    )
    DetailsBidPage(dummyData)
}