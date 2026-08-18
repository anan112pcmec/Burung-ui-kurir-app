package com.example.burungkurirapp.ui.section.Details.page.Pengiriman

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
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.burungkurirapp.ui.constant.color.*
import com.example.burungkurirapp.ui.constant.types.AlamatGudang
import com.example.burungkurirapp.ui.constant.types.AlamatPengguna
import com.example.burungkurirapp.ui.constant.types.Pengiriman
import com.example.burungkurirapp.ui.constant.types.Transaksi
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun DetailsPengirimanPage(data: Pengiriman) {
    val asalPos = LatLng(data.AlamatGudang?.Latitude ?: 0.0, data.AlamatGudang?.Longitude ?: 0.0)
    val tujuanPos = LatLng(data.AlamatPengguna?.Latitude ?: 0.0, data.AlamatPengguna?.Longitude ?: 0.0)

    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(asalPos, 13f)
    }

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
                        text = "DETAIL PENGIRIMAN",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = FontFamily.SansSerif,
                        letterSpacing = 0.8.sp,
                        color = Zinc400
                    )
                    Text(
                        text = "TRX #${data.IdTransaksi}",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Monospace,
                        letterSpacing = (-0.4).sp,
                        color = Slate950
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "ID Pengiriman: #${data.Id}",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        fontFamily = FontFamily.SansSerif,
                        color = Zinc600
                    )
                }

                val (statusBg, statusTextColor) = when (data.Status.uppercase()) {
                    "SELESAI", "DELIVERED", "PAID" -> Color(0xFFDCFCE7) to Color(0xFF15803D)
                    "PROSES", "ON_DELIVERY", "PICKED_UP" -> Color(0xFFDBEAFE) to Color(0xFF1D4ED8)
                    else -> Zinc100 to Slate950
                }

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .background(statusBg)
                        .border(1.dp, Zinc300, RoundedCornerShape(6.dp))
                        .padding(horizontal = 10.dp, vertical = 5.dp)
                ) {
                    Text(
                        text = data.Status.uppercase(),
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Monospace,
                        color = statusTextColor
                    )
                }
            }
        }

        item { HorizontalDivider(color = Zinc200, thickness = 1.dp) }

        item {
            // Pastikan data.Transaksi tidak null sebelum merender komponen
            data.Transaksi?.let { transaksi ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(10.dp))
                        .border(
                            width = 1.dp,
                            color = if (transaksi.isEkspedisi) Color(0xFFBFDBFE) else Zinc200,
                            shape = RoundedCornerShape(10.dp)
                        )
                        .background(Color.White)
                        .padding(14.dp)
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        // ─── 1. HEADER: KODE ORDER & STATUS ───
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column {
                                Text(
                                    text = if (transaksi.isEkspedisi) "EKSPEDISI #${transaksi.kodeOrderSistem.orEmpty()}" else "ORDER #${transaksi.kodeOrderSistem.orEmpty()}",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = FontFamily.Monospace,
                                    color = if (transaksi.isEkspedisi) Color(0xFF1D4ED8) else Slate950
                                )
                                if (transaksi.isEkspedisi && !transaksi.kodeResiEkspedisi.isNullOrBlank()) {
                                    Text(
                                        text = "RESI: ${transaksi.kodeResiEkspedisi}",
                                        fontSize = 10.sp,
                                        fontFamily = FontFamily.Monospace,
                                        color = Zinc400
                                    )
                                }
                            }

                            // Dynamic Status Badge
                            val (statusBg, statusTextColor) = when (transaksi.status.orEmpty().uppercase()) {
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
                                    text = transaksi.status.orEmpty().uppercase(),
                                    fontSize = 9.5.sp,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = FontFamily.Monospace,
                                    color = statusTextColor
                                )
                            }
                        }

                        HorizontalDivider(color = Zinc100, thickness = 1.dp)

                        // ─── 1.5. GAMBAR BARANG (SLIDER HORIZONTAL) ───
                        val gambarList = transaksi.gambarUrlKategoriBarang.orEmpty()
                        if (gambarList.isNotEmpty()) {
                            val pagerState = rememberPagerState(pageCount = { gambarList.size })

                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(180.dp)
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(Zinc100)
                            ) {
                                HorizontalPager (
                                    state = pagerState,
                                    modifier = Modifier.fillMaxSize()
                                ) { page ->
                                    AsyncImage(
                                        model = gambarList[page],
                                        contentDescription = "Foto Barang $page",
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier.fillMaxSize()
                                    )
                                }

                                // Badge Indikator Halaman (misal: "1/3")
                                if (gambarList.size > 1) {
                                    Box(
                                        modifier = Modifier
                                            .align(Alignment.BottomEnd)
                                            .padding(8.dp)
                                            .clip(RoundedCornerShape(4.dp))
                                            .background(Color.Black.copy(alpha = 0.65f))
                                            .padding(horizontal = 7.dp, vertical = 3.dp)
                                    ) {
                                        Text(
                                            text = "${pagerState.currentPage + 1}/${gambarList.size}",
                                            fontSize = 10.sp,
                                            fontWeight = FontWeight.Bold,
                                            fontFamily = FontFamily.Monospace,
                                            color = Color.White
                                        )
                                    }
                                }
                            }

                            HorizontalDivider(color = Zinc100, thickness = 1.dp)
                        }

                        // ─── 2. SPECS: LAYANAN & MUATAN KURIR ───
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
                                    text = "${transaksi.jenisPengiriman.orEmpty()} • ${transaksi.kendaraanPengiriman.orEmpty()}",
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
                                    text = "${transaksi.beratTotalKg ?: 0} Kg (${transaksi.kuantitasBarang ?: 0} Item) • ${transaksi.jarakTempuh.orEmpty()}",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Medium,
                                    fontFamily = FontFamily.Monospace,
                                    color = Slate950
                                )
                            }
                        }

                        // ─── 3. CATATAN PENGIRIMAN (JIKA ADA) ───
                        if (!transaksi.catatan.isNullOrBlank()) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(6.dp))
                                    .background(Zinc100)
                                    .padding(8.dp)
                            ) {
                                Text(
                                    text = "Catatan: ${transaksi.catatan}",
                                    fontSize = 11.sp,
                                    fontFamily = FontFamily.SansSerif,
                                    color = Zinc600
                                )
                            }
                        }

                        HorizontalDivider(color = Zinc100, thickness = 1.dp)

                        // ─── 4. FOOTER: PENDAPATAN KURIR & TANGGAL ───
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column {
                                Text(
                                    text = "PENDAPATAN KURIR",
                                    fontSize = 8.5.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    fontFamily = FontFamily.SansSerif,
                                    letterSpacing = 0.5.sp,
                                    color = Zinc400
                                )
                                Spacer(modifier = Modifier.height(1.dp))
                                Text(
                                    text = "Rp ${transaksi.kurirPaid ?: 0}",
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
                                    text = transaksi.createdAt.orEmpty(),
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
        }

        // ─── 2. DUAL LOCATION MAP SECTION ───
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
                            text = "Google Maps Placeholder\nAsal: (${asalPos.latitude}, ${asalPos.longitude})\nTujuan: (${tujuanPos.latitude}, ${tujuanPos.longitude})",
                            textAlign = TextAlign.Center,
                            color = Zinc400,
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Medium,
                            fontSize = 12.sp
                        )
                    }
                } else {
                    GoogleMap(
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(8.dp)),
                        cameraPositionState = cameraPositionState
                    ) {
                        data.AlamatGudang?.let { gudang ->
                            Marker(
                                state = MarkerState(position = asalPos),
                                title = "Asal (Gudang)",
                                snippet = gudang.NamaAlamat
                            )
                        }
                        data.AlamatPengguna?.let { pengguna ->
                            Marker(
                                state = MarkerState(position = tujuanPos),
                                title = "Tujuan (Pengguna)",
                                snippet = pengguna.NamaAlamat
                            )
                        }
                    }
                }
            }
        }

        // ─── 3. ALAMAT ASAL & TUJUAN CARDS ───
        item {
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                AlamatAsalCard(data.AlamatGudang)
                AlamatTujuanCard(data.AlamatPengguna)
            }
        }

        // ─── 4. RINCIAN PENGIRIMAN ───
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
                    Text(
                        text = "RINCIAN PENGIRIMAN",
                        fontSize = 9.5.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = FontFamily.SansSerif,
                        letterSpacing = 0.6.sp,
                        color = Zinc400
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text(
                                text = "JENIS & KENDARAAN",
                                fontSize = 8.5.sp,
                                fontWeight = FontWeight.SemiBold,
                                fontFamily = FontFamily.SansSerif,
                                color = Zinc400
                            )
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                text = "${data.JenisPengiriman} • ${data.KendaraanRequired}",
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
                                color = Zinc400
                            )
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                text = "${data.BeratBarang} Kg • ${data.JarakTempuh}",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Medium,
                                fontFamily = FontFamily.Monospace,
                                color = Slate950
                            )
                        }
                    }

                    HorizontalDivider(color = Zinc100, thickness = 1.dp)

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
                                color = Zinc400
                            )
                            Spacer(modifier = Modifier.height(1.dp))
                            Text(
                                text = data.KurirPaid,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily.Monospace,
                                color = Color(0xFF16A34A)
                            )
                        }

                        Column(horizontalAlignment = Alignment.End) {
                            Text(
                                text = "DIBUAT PADA",
                                fontSize = 8.5.sp,
                                fontWeight = FontWeight.SemiBold,
                                fontFamily = FontFamily.SansSerif,
                                color = Zinc400
                            )
                            Spacer(modifier = Modifier.height(1.dp))
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
    }
}

// ─── CARD ALAMAT ASAL (GUDANG) ───
@Composable
fun AlamatAsalCard(gudang: AlamatGudang?) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .border(1.dp, Zinc200, RoundedCornerShape(10.dp))
            .background(Color.White)
            .padding(14.dp)
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "ALAMAT ASAL (GUDANG)",
                    fontSize = 9.5.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif,
                    letterSpacing = 0.6.sp,
                    color = Color(0xFF1D4ED8)
                )
                Text(
                    text = gudang?.KodeNegara?.uppercase() ?: "-",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Monospace,
                    color = Zinc400
                )
            }

            if (gudang != null) {
                Text(
                    text = gudang.PanggilanAlamat,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif,
                    color = Slate950
                )
                Text(
                    text = "Telp: ${gudang.NomorTelephone}",
                    fontSize = 11.sp,
                    fontFamily = FontFamily.SansSerif,
                    color = Zinc600
                )
                Text(
                    text = "${gudang.NamaAlamat}, ${gudang.Kota}, ${gudang.Provinsi} (${gudang.KodePos})",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    fontFamily = FontFamily.SansSerif,
                    color = Slate950
                )
                if (gudang.Deskripsi.isNotBlank()) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(6.dp))
                            .background(Zinc100)
                            .padding(8.dp)
                    ) {
                        Text(
                            text = gudang.Deskripsi,
                            fontSize = 11.sp,
                            fontFamily = FontFamily.SansSerif,
                            color = Zinc600
                        )
                    }
                }
            } else {
                Text(
                    text = "Data alamat gudang tidak tersedia",
                    fontSize = 11.sp,
                    color = Zinc400
                )
            }
        }
    }
}

// ─── CARD ALAMAT TUJUAN (PENGGUNA) ───
@Composable
fun AlamatTujuanCard(pengguna: AlamatPengguna?) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .border(1.dp, Zinc200, RoundedCornerShape(10.dp))
            .background(Color.White)
            .padding(14.dp)
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "ALAMAT TUJUAN (PENGGUNA)",
                    fontSize = 9.5.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif,
                    letterSpacing = 0.6.sp,
                    color = Color(0xFF16A34A)
                )
                Text(
                    text = pengguna?.KodeNegara?.uppercase() ?: "-",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Monospace,
                    color = Zinc400
                )
            }

            if (pengguna != null) {
                Text(
                    text = pengguna.PanggilanAlamat,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif,
                    color = Slate950
                )
                Text(
                    text = "Telp: ${pengguna.NomorTelephone}",
                    fontSize = 11.sp,
                    fontFamily = FontFamily.SansSerif,
                    color = Zinc600
                )
                Text(
                    text = "${pengguna.NamaAlamat}, ${pengguna.Kota}, ${pengguna.Provinsi} (${pengguna.KodePos})",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    fontFamily = FontFamily.SansSerif,
                    color = Slate950
                )
                if (pengguna.Deskripsi.isNotBlank()) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(6.dp))
                            .background(Zinc100)
                            .padding(8.dp)
                    ) {
                        Text(
                            text = pengguna.Deskripsi,
                            fontSize = 11.sp,
                            fontFamily = FontFamily.SansSerif,
                            color = Zinc600
                        )
                    }
                }
            } else {
                Text(
                    text = "Data alamat pengguna tidak tersedia",
                    fontSize = 11.sp,
                    color = Zinc400
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PrevDetailsPengirimanPage() {
    val dummyGudang = AlamatGudang(
        Id = 1,
        IdSeller = 10,
        PanggilanAlamat = "Gudang Pusat Cawang",
        NomorTelephone = "08123456789",
        NamaAlamat = "Jl. MT Haryono No. 12",
        Provinsi = "DKI Jakarta",
        Kota = "Jakarta Timur",
        KodePos = "13630",
        KodeNegara = "IDN",
        Deskripsi = "Pintu masuk dari gerbang samping warna biru",
        Longitude = 106.8621,
        Latitude = -6.2441,
        CreatedAt = "18-08-2026",
        UpdatedAt = "18-08-2026"
    )

    val dummyPengguna = AlamatPengguna(
        Id = 2,
        IdPengguna = 99,
        PanggilanAlamat = "Rumah Customer",
        NomorTelephone = "08987654321",
        NamaAlamat = "Jl. Radio Dalam No. 88",
        Provinsi = "DKI Jakarta",
        Kota = "Jakarta Selatan",
        KodePos = "12140",
        KodeNegara = "IDN",
        Deskripsi = "Pagar hitam depan pos satpam",
        Longitude = 106.7885,
        Latitude = -6.2553,
        CreatedAt = "18-08-2026",
        UpdatedAt = "18-08-2026"
    )

    val dummyTransaksi = Transaksi(
        id = 1001L,
        idPengguna = 501L,
        idSeller = 12,
        idBarangInduk = 9988L,
        idKategoriBarang = 3L,
        idAlamatPengguna = 202L,
        gambarUrlKategoriBarang = listOf(
            "https://images.unsplash.com/photo-1542291026-7eec264c27ff",
            "https://images.unsplash.com/photo-1505740420928-5e560c06d30e"
        ),
        alamatPengguna = dummyPengguna,
        idAlamatGudang = 10L,
        alamatGudang = dummyGudang,
        idAlamatEkspedisi = 5L,
        idPembayaran = 88L,
        idDiskon = 45L,
        kendaraanPengiriman = "Motor Box",
        jenisPengiriman = "Instan",
        jarakTempuh = "4.5 Km",
        beratTotalKg = 2,
        kodeOrderSistem = "ORD-2026-0618-001",
        kodeResiEkspedisi = "JPX-99887766",
        status = "PROSES",
        dibatalkanOleh = "",
        catatan = "Tolong ditaruh di depan pintu jika tidak ada orang.",
        kuantitasBarang = 3,
        isEkspedisi = false,
        sellerPaid = 150000L,
        kurirPaid = 25000L,
        sistemPaid = 5000L,
        ekspedisiPaid = 0L,
        total = 180000L,
        reviewed = false,
        createdAt = "2026-06-18 10:30:00",
        updatedAt = "2026-06-18 10:35:00"
    )

    val dummyPengiriman = Pengiriman(
        Id = 501,
        IdTransaksi = 20260818,
        IdSeller = 10,
        IdAlamatGudang = 1,
        IdAlamatPengguna = 2,
        IdKurir = 5,
        BeratBarang = 4,
        KendaraanRequired = "Motor",
        JenisPengiriman = "Express Instant",
        JarakTempuh = "12.4 km",
        KurirPaid = "Rp 35.000",
        Status = "PROSES",
        CreatedAt = "18-08-2026",
        AlamatGudang = dummyGudang,
        AlamatPengguna = dummyPengguna,
        Transaksi = dummyTransaksi,
    )


    DetailsPengirimanPage(dummyPengiriman)
}