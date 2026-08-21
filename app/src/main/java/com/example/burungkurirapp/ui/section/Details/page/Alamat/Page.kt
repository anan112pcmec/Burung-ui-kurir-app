package com.example.burungkurirapp.ui.section.Details.page.Alamat

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import com.example.burungkurirapp.ui.constant.types.AlamatKurir
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.rememberCameraPositionState
import com.utsman.osmandcompose.OpenStreetMap
import com.utsman.osmandcompose.rememberCameraState
import org.osmdroid.util.GeoPoint

@Composable
fun DetailsAlamatPage(data: AlamatKurir) {
//    val context = androidx.ui.platform.LocalContext.current // Atau androidx.compose.ui.platform.LocalContext.current

    val lokasiAlamat = LatLng(data.Latitude, data.Longitude)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(lokasiAlamat, 15f)
    }
    val isPreview = LocalInspectionMode.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 10.dp, end = 10.dp, top = 15.dp)
    ) {
        // ─── HEADER ROW ───
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column {
                Text(
                    text = "ALAMAT UTAMA",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = FontFamily.SansSerif,
                    letterSpacing = 0.8.sp,
                    color = Zinc400
                )
                Text(
                    text = data.PanggilanAlamat,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif,
                    letterSpacing = (-0.4).sp,
                    color = Slate950
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = data.NomorTelephone,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    fontFamily = FontFamily.SansSerif,
                    color = Zinc600
                )
            }

            // Country Code Badge (iOS Minimal Pill Style)
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(6.dp))
                    .background(Zinc100)
                    .border(1.dp, Zinc300, RoundedCornerShape(6.dp))
                    .padding(horizontal = 8.dp, vertical = 4.dp),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = data.KodeNegara.uppercase(),
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Monospace,
                    color = Slate950
                )
            }
        }

        Spacer(modifier = Modifier.height(13.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, Zinc200)
        )

        Spacer(modifier = Modifier.height(13.dp))

        // ─── MAP BOX ───
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.6f)
                .padding(bottom = 15.dp)
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
                        text = "Maps Placeholder\nLat: ${data.Latitude}, Lng: ${data.Longitude}",
                        textAlign = TextAlign.Center,
                        color = Zinc400,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Medium,
                        fontSize = 12.sp
                    )
                }
            } else {
//                GoogleMap(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .clip(RoundedCornerShape(8.dp)),
//                    cameraPositionState = cameraPositionState
//                )

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

        // ─── BOTTOM DETAILS BOX (0.4f) ───
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.4f)
                .padding(bottom = 15.dp)
                .clip(RoundedCornerShape(10.dp))
                .border(1.dp, Zinc200, RoundedCornerShape(10.dp))
                .background(Color.White)
                .padding(14.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                // Label & Val: Nama Alamat
                Column {
                    Text(
                        text = "ALAMAT LENGKAP",
                        fontSize = 9.5.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = FontFamily.SansSerif,
                        letterSpacing = 0.6.sp,
                        color = Zinc400
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = "${data.NamaAlamat}, ${data.Kota}",
                        fontSize = 13.5.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = FontFamily.SansSerif,
                        letterSpacing = (-0.2).sp,
                        color = Slate950
                    )
                }

                // Label & Val: Provinsi & Kode Pos
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "PROVINSI",
                            fontSize = 9.5.sp,
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = FontFamily.SansSerif,
                            letterSpacing = 0.6.sp,
                            color = Zinc400
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = data.Provinsi,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium,
                            fontFamily = FontFamily.SansSerif,
                            color = Slate950
                        )
                    }

                    Column(horizontalAlignment = Alignment.End) {
                        Text(
                            text = "KODE POS",
                            fontSize = 9.5.sp,
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = FontFamily.SansSerif,
                            letterSpacing = 0.6.sp,
                            color = Zinc400
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(4.dp))
                                .background(Zinc100)
                                .padding(horizontal = 6.dp, vertical = 2.dp)
                        ) {
                            Text(
                                text = data.KodePos,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.SemiBold,
                                fontFamily = FontFamily.Monospace,
                                color = Slate950
                            )
                        }
                    }
                }

                // Label & Val: Deskripsi
                Column {
                    Text(
                        text = "CATATAN ALAMAT",
                        fontSize = 9.5.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = FontFamily.SansSerif,
                        letterSpacing = 0.6.sp,
                        color = Zinc400
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(6.dp))
                            .background(Zinc100)
                            .padding(horizontal = 10.dp, vertical = 8.dp)
                    ) {
                        Text(
                            text = if (data.Deskripsi.isNotBlank()) data.Deskripsi else "Tidak ada catatan tambahan",
                            fontSize = 11.5.sp,
                            fontWeight = FontWeight.Normal,
                            fontFamily = FontFamily.SansSerif,
                            lineHeight = 16.sp,
                            color = Zinc600
                        )
                    }
                }

                HorizontalDivider(color = Zinc100, thickness = 1.dp)

                // Label & Val: Koordinat & Created At
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "KOORDINAT (LAT, LNG)",
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
}

@Preview(showBackground = true)
@Composable
fun PrevDetailsAlamatPage() {
    val dataAlamat1 = AlamatKurir(
        1,
        2,
        "Rumah Gue",
        "092733829372",
        "Jalan Sebakti no 1",
        "Jakarta",
        "Jakarta Timur",
        "IDN",
        "00341",
        "Ini alamat rumah gw ya coy",
        106.827153,
        -6.175392,
        "12-09-2025",
        "18-08-2026"
    )
    DetailsAlamatPage(dataAlamat1)
}