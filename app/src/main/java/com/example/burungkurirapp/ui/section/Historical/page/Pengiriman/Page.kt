package com.example.burungkurirapp.ui.section.Historical.page.Pengiriman

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.LocalShipping
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.burungkurirapp.ui.constant.color.*
import com.example.burungkurirapp.ui.section.LocalUiFlowState
import com.example.burungkurirapp.ui.section.rememberUiFlowState
import java.text.NumberFormat
import java.util.Locale

// ─── UNIFIED DATA MODEL (Representation of Pengiriman & PengirimanEkspedisi Structs) ───
data class HistoricalPengirimanItem(
    val id: Long,
    val idTransaksi: Long,
    val isEkspedisi: Boolean = false,
    val jenisPengiriman: String = "REGULER", // EXPRESS, INSTANT, REGULER
    val kendaraanRequired: String = "Motor",
    val beratBarang: Int = 1500, // Gram
    val jarakTempuh: String = "4.5 km",
    val kurirPaid: Long = 25000,
    val status: String = "Picked Up",
    val tanggal: String = "17 Ags 2026, 10:15 WIB"
)

@Preview(showBackground = true)
@Composable
fun HistoricalPengirimanPagePreview() {
    HistoricalPengirimanPage()
}

@Composable
fun HistoricalPengirimanPage(
    onTipeFilterSelect: (String) -> Unit = {},
    onJenisFilterSelect: (String) -> Unit = {},
    onDateFilterClick: () -> Unit = {}
) {
    CompositionLocalProvider(LocalUiFlowState provides rememberUiFlowState()) {
        val state = LocalUiFlowState.current

        var selectedTipe by remember { mutableStateOf("Semua Tipe") }
        var selectedJenis by remember { mutableStateOf("Semua Jenis") }

        var isTipeDropdownExpanded by remember { mutableStateOf(false) }
        var isJenisDropdownExpanded by remember { mutableStateOf(false) }

        val tipeOptions = listOf("Semua Tipe", "Non-Ekspedisi", "Ekspedisi")
        val jenisOptions = listOf("Semua Jenis", "Instant", "Express", "Reguler")

        val dummyHistoryList = remember {
            listOf(
                HistoricalPengirimanItem(
                    id = 101,
                    idTransaksi = 5001,
                    isEkspedisi = false,
                    jenisPengiriman = "INSTANT",
                    kendaraanRequired = "Motor",
                    beratBarang = 2000,
                    jarakTempuh = "3.2 km",
                    kurirPaid = 18000,
                    status = "Delivered",
                    tanggal = "17 Ags 2026, 09:30 WIB"
                ),
                HistoricalPengirimanItem(
                    id = 102,
                    idTransaksi = 5002,
                    isEkspedisi = true,
                    jenisPengiriman = "EXPRESS",
                    kendaraanRequired = "Mobil",
                    beratBarang = 12000,
                    jarakTempuh = "18.5 km",
                    kurirPaid = 85000,
                    status = "Picked Up",
                    tanggal = "16 Ags 2026, 14:20 WIB"
                ),
                HistoricalPengirimanItem(
                    id = 103,
                    idTransaksi = 5003,
                    isEkspedisi = false,
                    jenisPengiriman = "REGULER",
                    kendaraanRequired = "Motor",
                    beratBarang = 800,
                    jarakTempuh = "5.0 km",
                    kurirPaid = 15000,
                    status = "Delivered",
                    tanggal = "15 Ags 2026, 11:00 WIB"
                )
            )
        }

        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // ─── TOP HEADER: FILTER TIPE + FILTER JENIS + FILTER WAKTU ───
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 10.dp),
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Box 1: Filter Tipe (Semua | Ekspedisi | Non-Ekspedisi)
                Box(
                    modifier = Modifier.weight(0.36f),
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(34.dp)
                            .clip(RoundedCornerShape(6.dp))
                            .background(Zinc100)
                            .border(BorderStroke(1.dp, Zinc200), RoundedCornerShape(6.dp))
                            .clickable { isTipeDropdownExpanded = true }
                            .padding(horizontal = 6.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = selectedTipe,
                            fontFamily = FontFamily.SansSerif,
                            fontSize = 9.5.sp,
                            fontWeight = FontWeight.Medium,
                            color = Slate950,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "Dropdown Tipe",
                            tint = Slate950,
                            modifier = Modifier.size(14.dp)
                        )
                    }

                    DropdownMenu(
                        expanded = isTipeDropdownExpanded,
                        onDismissRequest = { isTipeDropdownExpanded = false }
                    ) {
                        tipeOptions.forEach { tipe ->
                            DropdownMenuItem(
                                text = {
                                    Text(
                                        tipe,
                                        fontSize = 11.sp,
                                        fontFamily = FontFamily.SansSerif
                                    )
                                },
                                onClick = {
                                    selectedTipe = tipe
                                    onTipeFilterSelect(tipe)
                                    isTipeDropdownExpanded = false
                                }
                            )
                        }
                    }
                }

                // Box 2: Filter Jenis (Express | Instant | Reguler)
                Box(
                    modifier = Modifier.weight(0.36f),
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(34.dp)
                            .clip(RoundedCornerShape(6.dp))
                            .background(Zinc100)
                            .border(BorderStroke(1.dp, Zinc200), RoundedCornerShape(6.dp))
                            .clickable { isJenisDropdownExpanded = true }
                            .padding(horizontal = 6.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = selectedJenis,
                            fontFamily = FontFamily.SansSerif,
                            fontSize = 9.5.sp,
                            fontWeight = FontWeight.Medium,
                            color = Slate950,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "Dropdown Jenis",
                            tint = Slate950,
                            modifier = Modifier.size(14.dp)
                        )
                    }

                    DropdownMenu(
                        expanded = isJenisDropdownExpanded,
                        onDismissRequest = { isJenisDropdownExpanded = false }
                    ) {
                        jenisOptions.forEach { jenis ->
                            DropdownMenuItem(
                                text = {
                                    Text(
                                        jenis,
                                        fontSize = 11.sp,
                                        fontFamily = FontFamily.SansSerif
                                    )
                                },
                                onClick = {
                                    selectedJenis = jenis
                                    onJenisFilterSelect(jenis)
                                    isJenisDropdownExpanded = false
                                }
                            )
                        }
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

            // ─── BOTTOM LIST: CARD RIWAYAT PENGIRIMAN ───
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
                        key = { "${if (it.isEkspedisi) "eks" else "non"}_${it.id}" }
                    ) { pengirimanItem ->
                        HistoricalPengirimanCardItem(
                            data = pengirimanItem,
                            onCardClick = { item ->
                                val targetPath = if (item.isEkspedisi) "ekspedisi" else "direct"
                                state?.navController?.navigate("/details/historical-pengiriman/$targetPath/${item.id}")
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun HistoricalPengirimanCardItem(
    data: HistoricalPengirimanItem,
    onCardClick: (HistoricalPengirimanItem) -> Unit
) {
    val rupiahFormat = remember { NumberFormat.getCurrencyInstance(Locale("id", "ID")) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(Color.White)
            .border(BorderStroke(1.dp, Zinc200), RoundedCornerShape(8.dp))
            .clickable { onCardClick(data) }
            .padding(14.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // ─── HEADER: BADGE TIPE, ID TRX & STATUS ───
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Badge Ekspedisi vs Non-Ekspedisi
                    Box(
                        modifier = Modifier
                            .background(
                                if (data.isEkspedisi) Slate950 else Zinc100,
                                RoundedCornerShape(4.dp)
                            )
                            .padding(horizontal = 6.dp, vertical = 2.dp)
                    ) {
                        Text(
                            text = if (data.isEkspedisi) "EKSPEDISI" else "DIRECT",
                            fontFamily = FontFamily.Monospace,
                            fontWeight = FontWeight.Bold,
                            fontSize = 8.5.sp,
                            color = if (data.isEkspedisi) Color.White else Slate950
                        )
                    }

                    Text(
                        text = "#TRX-${data.idTransaksi}",
                        fontFamily = FontFamily.Monospace,
                        fontSize = 10.sp,
                        color = Zinc400,
                        fontWeight = FontWeight.Medium
                    )
                }

                // Status Badge
                Text(
                    text = data.status.uppercase(),
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.Bold,
                    fontSize = 10.sp,
                    color = if (data.status == "Delivered") Teal400 else Slate950
                )
            }

            HorizontalDivider(color = Zinc100, thickness = 1.dp)

            // ─── MIDDLE: SPESIFIKASI PENGIRIMAN ───
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.LocalShipping,
                            contentDescription = null,
                            tint = Slate950,
                            modifier = Modifier.size(14.dp)
                        )
                        Text(
                            text = "${data.jenisPengiriman} • ${data.kendaraanRequired}",
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Bold,
                            fontSize = 12.sp,
                            color = Slate950
                        )
                    }

                    Text(
                        text = "Jarak: ${data.jarakTempuh} | Berat: ${data.beratBarang / 1000.0} kg",
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 10.sp,
                        color = Zinc600
                    )
                }

                // ─── KURIR PAID (PENDAPATAN) ───
                Column(horizontalAlignment = Alignment.End) {
                    Text(
                        text = rupiahFormat.format(data.kurirPaid).replace(",00", ""),
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp,
                        color = Slate950
                    )
                    Text(
                        text = "Pendapatan",
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 9.sp,
                        color = Zinc400
                    )
                }
            }

            // ─── FOOTER: TANGGAL ───
            Text(
                text = data.tanggal,
                fontFamily = FontFamily.Monospace,
                fontSize = 9.5.sp,
                color = Zinc400
            )
        }
    }
}