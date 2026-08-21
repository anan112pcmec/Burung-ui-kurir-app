package com.example.burungkurirapp.ui.section.Tugas.page.Pengiriman

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.example.burungkurirapp.ui.constant.color.Slate950
import com.example.burungkurirapp.ui.constant.color.Teal100
import com.example.burungkurirapp.ui.constant.color.Teal700
import com.example.burungkurirapp.ui.constant.color.Zinc100
import com.example.burungkurirapp.ui.constant.color.Zinc200
import com.example.burungkurirapp.ui.constant.color.Zinc300
import com.example.burungkurirapp.ui.constant.color.Zinc400
import com.example.burungkurirapp.ui.constant.color.Zinc500
import com.example.burungkurirapp.ui.constant.color.Zinc600
import com.example.burungkurirapp.ui.constant.enum.STatusPengiriman
import com.example.burungkurirapp.ui.section.Tugas.page.Pengiriman.component.DiperjalananUi
import com.example.burungkurirapp.ui.section.Tugas.page.Pengiriman.component.JejakPengirimanItem
import com.example.burungkurirapp.ui.section.Tugas.page.Pengiriman.component.PickedUpUi
import com.example.burungkurirapp.ui.section.Tugas.page.Pengiriman.component.SampaiUi
import com.example.burungkurirapp.ui.section.Tugas.page.Pengiriman.component.WaitingUi
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun TugasPengirimanPage(data: TugasPengirimanProps) {
    val statusPengiriman: MutableState<STatusPengiriman> = remember { mutableStateOf(data.Status) }

    // Defaulting to user's address if waiting/delivering, otherwise warehouse.
    val latObjective: MutableState<Double> = remember { mutableDoubleStateOf(data.LatAlamatPengguna) }
    val longitudeObjective: MutableState<Double> = remember { mutableDoubleStateOf(data.LongAlamatPengguna) }

    val lokasiAlamat = LatLng(latObjective.value, longitudeObjective.value)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(lokasiAlamat, 15f)
    }
    val isPreview = LocalInspectionMode.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 14.dp, vertical = 16.dp)
            ,

        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        // ─── HEADER SECTION ───
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
            ) {
                Text(
                    text = "DETAIL PENGIRIMAN",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = FontFamily.SansSerif,
                    letterSpacing = 0.8.sp,
                    color = Zinc400
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = data.KodeOrderSistem,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Monospace,
                    letterSpacing = (-0.5).sp,
                    color = Slate950
                )
            }

            // Status Badge
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(6.dp))
                    .background(Teal100)
                    .border(1.dp, Teal100, RoundedCornerShape(6.dp))
                    .padding(horizontal = 10.dp, vertical = 4.dp),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = statusPengiriman.value.name.uppercase(),
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif,
                    color = Teal700
                )
            }
        }

        // ─── SUB HEADER (Quick Info) ───
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "Seller",
                    fontSize = 9.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = FontFamily.SansSerif,
                    color = Zinc400
                )
                Text(
                    text = data.NamaSeller,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Medium,
                    fontFamily = FontFamily.SansSerif,
                    color = Slate950
                )
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Penerima",
                    fontSize = 9.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = FontFamily.SansSerif,
                    color = Zinc400
                )
                Text(
                    text = data.NamaPengguna,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Medium,
                    fontFamily = FontFamily.SansSerif,
                    color = Slate950
                )
            }
            Column(horizontalAlignment = Alignment.End) {
                Text(
                    text = "Upah Kurir",
                    fontSize = 9.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = FontFamily.SansSerif,
                    color = Zinc400
                )
                Text(
                    text = "Rp.${data.KurirPaid}",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = FontFamily.SansSerif,
                    color = Slate950
                )
            }
        }

        // Divider
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Zinc200)
        )

        // ─── MAP SECTION ───
        if (statusPengiriman.value != STatusPengiriman.PICKED_UP && statusPengiriman.value != STatusPengiriman.SAMPAI){
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp) // Disesuaikan sedikit agar ada ruang sisa untuk komponen bawah & mudah di-scroll
            ) {
                if (isPreview) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(12.dp))
                            .background(Zinc100)
                            .border(1.dp, Zinc300, RoundedCornerShape(12.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = "Google Maps Placeholder",
                                textAlign = TextAlign.Center,
                                color = Zinc500,
                                fontFamily = FontFamily.SansSerif,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 14.sp
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "Lat: ${latObjective.value}, Lng: ${longitudeObjective.value}",
                                textAlign = TextAlign.Center,
                                color = Zinc400,
                                fontFamily = FontFamily.Monospace,
                                fontWeight = FontWeight.Medium,
                                fontSize = 11.sp
                            )
                        }
                    }
                } else {
//                    GoogleMap(
//                        modifier = Modifier
//                            .fillMaxSize()
//                            .clip(RoundedCornerShape(12.dp))
//                            .border(1.dp, Zinc200, RoundedCornerShape(12.dp)),
//                        cameraPositionState = cameraPositionState
//                    )
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(12.dp))
                            .background(Zinc100)
                            .border(1.dp, Zinc300, RoundedCornerShape(12.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = "Google Maps Placeholder",
                                textAlign = TextAlign.Center,
                                color = Zinc500,
                                fontFamily = FontFamily.SansSerif,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 14.sp
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "Lat: ${latObjective.value}, Lng: ${longitudeObjective.value}",
                                textAlign = TextAlign.Center,
                                color = Zinc400,
                                fontFamily = FontFamily.Monospace,
                                fontWeight = FontWeight.Medium,
                                fontSize = 11.sp
                            )
                        }
                    }
                }
            }
        }

        // Catatan: Spacer weight(1f) dihapus agar tidak error di dalam verticalScroll

        // Catatan: Spacer weight(1f) dihapus agar tidak error di dalam verticalScroll

        when(statusPengiriman.value){
            STatusPengiriman.WAITING -> WaitingUi(data, onNavigateToWarehouse = { _, _ -> }, onTakePhotoClick = { }, onConfirmPickedUp = {
                statusPengiriman.value = STatusPengiriman.PICKED_UP
            })
            STatusPengiriman.PICKED_UP -> PickedUpUi(data, {
                statusPengiriman.value = STatusPengiriman.DI_PERJALANAN
            });
            STatusPengiriman.DI_PERJALANAN -> DiperjalananUi(data,   historisJejak = listOf(
                JejakPengirimanItem(1, "14:20", "Sedang berteduh karena hujan deras di daerah Tebet"),
                JejakPengirimanItem(2, "13:45", "Terjebak macet di persimpangan Kuningan")
            ),
                onNavigateToRecipient = { _, _ -> },
                onSendUpdateJejak = { _, _ -> },
                onTakePhotoDelivered = { },
                onConfirmDelivered = {
                    statusPengiriman.value = STatusPengiriman.SAMPAI
                }
            )

            STatusPengiriman.SAMPAI -> SampaiUi(data, buktiFotoUrl = "https://via.placeholder.com/300",
                onFinishClick = { })

            else -> {}
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun PrevTugasPengirimanPage() {
    val dummyTugasPengiriman = TugasPengirimanProps(
        Id = 1001L,
        IdTransaksi = 50021L,
        IdSeller = 301L,
        NamaSeller = "Toko Berkah Jaya",
        IdPengguna = 102,
        NamaPengguna = "Budiansyah",
        IdAlamatGudang = 101L,
        NamaAlamatGudang = "Gudang Utama Karawang",
        LongAlamatGudang = 107.3023,
        LatAlamatGudang = -6.3155,
        IdAlamatPengguna = 205L,
        NamaAlamatPengguna = "Perumahan Teluk Jambe Blok A No. 12",
        LongAlamatPengguna = 107.3112,
        LatAlamatPengguna = -6.3201,
        IdBarangInduk = 9988L,
        NamaBarangInduk = "Paket Elektronik - Speaker Bluetooth",
        IdKategoriBarang = 12L,
        NamaKategoriBarang = "Elektronik",
        UrlFotoKategoriBarang = listOf(
            "https://example.com/images/speaker1.jpg",
            "https://example.com/images/speaker2.jpg"
        ),
        IdKurir = 88L,
        KodeOrderSistem = "ORD-2026-0820-001",
        Catatan = "Harap hubungi penerima sebelum sampai di lokasi.",
        BeratBarang = 1500,
        KendaraanRequired = "Motor",
        JenisPengiriman = "Instant",
        JarakTempuh = "4.5 km",
        KurirPaid = 15000L,
        Status = STatusPengiriman.WAITING
    )

    TugasPengirimanPage(dummyTugasPengiriman)
}