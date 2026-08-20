package com.example.burungkurirapp.ui.section.Historical.page.Alamat

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.burungkurirapp.ui.constant.color.*
import com.example.burungkurirapp.ui.constant.prefix.DetailsSectionPrefix
import com.example.burungkurirapp.ui.section.LocalUiFlowState
import com.example.burungkurirapp.ui.section.rememberUiFlowState

// ─── UNIFIED DATA MODEL (Representation of AlamatKurir Struct) ───
data class HistoricalAlamatItem(
    val id: Long,
    val panggilanAlamat: String = "Gudang Utama",
    val namaAlamat: String = "Jl. Merdeka No. 45",
    val nomorTelefon: String = "08123456789",
    val provinsi: String = "DKI Jakarta",
    val kota: String = "Jakarta Selatan",
    val kodePos: String = "12190",
    val deskripsi: String = "Pagar hitam, samping toko kelontong",
    val isAktif: Boolean = true, // true = MASIH ADA, false = DIHAPUS
    val latitude: Double = -6.2088,
    val longitude: Double = 106.8456,
    val tanggal: String = "15 Ags 2026, 08:30 WIB"
)

@Preview(showBackground = true)
@Composable
fun HistoricalAlamatPagePreview() {
    HistoricalAlamatPage()
}

@Composable
fun HistoricalAlamatPage(
    onSearchQueryChange: (String) -> Unit = {},
    onDateFilterClick: () -> Unit = {}
) {
        val state = LocalUiFlowState.current
        var searchQuery by remember { mutableStateOf("") }

        val dummyHistoryList = remember {
            listOf(
                HistoricalAlamatItem(
                    id = 1,
                    panggilanAlamat = "Rumah Utama",
                    namaAlamat = "Jl. Senopati No. 12",
                    nomorTelefon = "081299887766",
                    provinsi = "DKI Jakarta",
                    kota = "Jakarta Selatan",
                    kodePos = "12190",
                    deskripsi = "Rumah cat putih pagar hitam",
                    isAktif = true,
                    tanggal = "16 Ags 2026, 14:00 WIB"
                ),
                HistoricalAlamatItem(
                    id = 2,
                    panggilanAlamat = "Gudang Transit",
                    namaAlamat = "Jl. Raya Bogor KM 28",
                    nomorTelefon = "085611223344",
                    provinsi = "Jawa Barat",
                    kota = "Kota Depok",
                    kodePos = "16410",
                    deskripsi = "Patokannya dekat gapura hijau",
                    isAktif = false,
                    tanggal = "10 Jun 2026, 09:15 WIB"
                ),
                HistoricalAlamatItem(
                    id = 3,
                    panggilanAlamat = "Kantor Cabang",
                    namaAlamat = "Jl. Daan Mogot No. 88",
                    nomorTelefon = "081344556677",
                    provinsi = "DKI Jakarta",
                    kota = "Jakarta Barat",
                    kodePos = "11730",
                    deskripsi = "Gedung Komplek Ruko Blok C3",
                    isAktif = true,
                    tanggal = "01 Mei 2026, 11:45 WIB"
                )
            )
        }

        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // ─── TOP HEADER: PELENGKAP + SEARCHBAR + FILTER WAKTU ───
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 10.dp),
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Box 1: Info Pelengkap
                Box(
                    modifier = Modifier.weight(0.28f),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "Riwayat Alamat",
                            tint = Slate950,
                            modifier = Modifier.size(15.dp)
                        )
                        Text(
                            text = "${dummyHistoryList.size} Alamat",
                            fontFamily = FontFamily.SansSerif,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = Slate950,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }

                // Box 2: Search Bar Nama Alamat
                Box(
                    modifier = Modifier.weight(0.44f),
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(34.dp)
                            .clip(RoundedCornerShape(6.dp))
                            .background(Color.White)
                            .border(BorderStroke(1.dp, Zinc300), RoundedCornerShape(6.dp))
                            .padding(horizontal = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search Alamat",
                            tint = Zinc400,
                            modifier = Modifier.size(13.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        BasicTextField(
                            value = searchQuery,
                            onValueChange = {
                                searchQuery = it
                                onSearchQueryChange(it)
                            },
                            singleLine = true,
                            textStyle = TextStyle(
                                fontFamily = FontFamily.SansSerif,
                                fontSize = 9.5.sp,
                                color = Slate950
                            ),
                            modifier = Modifier.fillMaxWidth(),
                            decorationBox = { innerTextField ->
                                if (searchQuery.isEmpty()) {
                                    Text(
                                        text = "Cari alamat...",
                                        fontFamily = FontFamily.SansSerif,
                                        fontSize = 9.5.sp,
                                        color = Zinc400,
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                }
                                innerTextField()
                            }
                        )
                    }
                }

                // Box 3: Filter Waktu
                Box(
                    modifier = Modifier.weight(0.28f),
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(34.dp)
                            .clip(RoundedCornerShape(6.dp))
                            .background(Slate950)
                            .clickable { onDateFilterClick() }
                            .padding(horizontal = 6.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.DateRange,
                            contentDescription = "Filter Waktu",
                            tint = Color.White,
                            modifier = Modifier.size(13.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "Waktu",
                            fontFamily = FontFamily.SansSerif,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }

            HorizontalDivider(color = Zinc100, thickness = 1.dp)

            // ─── BOTTOM LIST: CARD RIWAYAT ALAMAT KURIR ───
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(
                        items = dummyHistoryList,
                        key = { it.id }
                    ) { alamatItem ->
                        HistoricalAlamatCardItem(
                            data = alamatItem,
                            onCardClick = {
                                state.navController.navigate("$DetailsSectionPrefix/Alamat")
                            }
                        )
                    }
                }
            }
        }
}

@Composable
fun HistoricalAlamatCardItem(
    data: HistoricalAlamatItem,
    onCardClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(Color.White)
            .border(BorderStroke(1.dp, Zinc200), RoundedCornerShape(8.dp))
            .clickable { onCardClick() }
            .padding(14.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // ─── HEADER: PANGGILAN ALAMAT & BADGE STATUS (MASIH ADA / DIHAPUS) ───
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = data.panggilanAlamat,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        color = Slate950,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )

                    Box(
                        modifier = Modifier
                            .background(
                                if (data.isAktif) Zinc100 else Color(0xFFFEE2E2),
                                RoundedCornerShape(4.dp)
                            )
                            .padding(horizontal = 6.dp, vertical = 2.dp)
                    ) {
                        Text(
                            text = if (data.isAktif) "MASIH ADA" else "DIHAPUS",
                            fontFamily = FontFamily.Monospace,
                            fontWeight = FontWeight.Bold,
                            fontSize = 8.5.sp,
                            color = if (data.isAktif) Slate950 else Color(0xFFDC2626)
                        )
                    }
                }

                Text(
                    text = data.tanggal,
                    fontFamily = FontFamily.Monospace,
                    fontSize = 9.5.sp,
                    color = Zinc400
                )
            }

            HorizontalDivider(color = Zinc100, thickness = 1.dp)

            // ─── MIDDLE: DETAIL ALAMAT & DESKRIPSI ───
            Column(
                verticalArrangement = Arrangement.spacedBy(3.dp)
            ) {
                Text(
                    text = data.namaAlamat,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Medium,
                    fontSize = 11.5.sp,
                    color = Slate950,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                if (data.deskripsi.isNotEmpty()) {
                    Text(
                        text = "Ket: ${data.deskripsi}",
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 10.sp,
                        color = Zinc600,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }

            // ─── FOOTER: KOTA, PROVINSI & PHONE ───
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "${data.kota}, ${data.provinsi} ${data.kodePos}",
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 10.sp,
                    color = Zinc600,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f)
                )

                Text(
                    text = data.nomorTelefon,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.Medium,
                    fontSize = 10.sp,
                    color = Slate950
                )
            }
        }
    }
}