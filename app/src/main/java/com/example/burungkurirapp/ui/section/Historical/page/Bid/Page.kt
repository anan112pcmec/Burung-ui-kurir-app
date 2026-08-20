package com.example.burungkurirapp.ui.section.History

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
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Gavel
import androidx.compose.material.icons.filled.Navigation
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
import com.example.burungkurirapp.ui.constant.prefix.DetailsSectionPrefix
import com.example.burungkurirapp.ui.section.LocalUiFlowState
import com.example.burungkurirapp.ui.section.rememberUiFlowState
import java.text.NumberFormat
import java.util.Locale

// ─── ENHANCED DATA MODEL FOR HISTORICAL BID ───
data class HistoricalBidItem(
    val id: Long,
    val idBid: String = "BID-8812",
    val jenisPengiriman: String = "REGULER",
    val mode: String = "AUTO", // AUTO | MANUAL
    val provinsi: String = "DKI Jakarta",
    val kota: String = "Jakarta Selatan",
    val totalKm: Double = 14.2,
    val totalOrder: Int = 4,
    val nominalBid: Long = 45000,
    val dimulai: String = "08:00",
    val selesai: String = "16:30",
    val tanggal: String = "17 Ags 2026",
    val status: String = "Selesai" // Selesai, Batal, Berlangsung
)

@Preview(showBackground = true)
@Composable
fun HistoricalBidPagePreview() {
    HistoricalBidPage()
}

@Composable
fun HistoricalBidPage(
    onSortChange: (String) -> Unit = {},
    onModeFilterChange: (String) -> Unit = {},
    onDeepFilterClick: () -> Unit = {}
) {
        val state = LocalUiFlowState.current

        var selectedSort by remember { mutableStateOf("Terbaru") }
        var selectedMode by remember { mutableStateOf("Semua Mode") }

        var isSortDropdownExpanded by remember { mutableStateOf(false) }
        var isModeDropdownExpanded by remember { mutableStateOf(false) }

        val sortOptions = listOf("Terbaru", "Terlama", "Bid Tertinggi")
        val modeOptions = listOf("Semua Mode", "Auto Bid", "Manual")

        val dummyBidList = remember {
            listOf(
                HistoricalBidItem(
                    id = 1,
                    idBid = "BID-9901",
                    jenisPengiriman = "EXPRESS",
                    mode = "AUTO",
                    provinsi = "DKI Jakarta",
                    kota = "Jakarta Selatan",
                    totalKm = 12.5,
                    totalOrder = 5,
                    nominalBid = 52000,
                    dimulai = "08:00",
                    selesai = "15:30",
                    tanggal = "17 Ags 2026",
                    status = "Selesai"
                ),
                HistoricalBidItem(
                    id = 2,
                    idBid = "BID-9844",
                    jenisPengiriman = "INSTANT",
                    mode = "MANUAL",
                    provinsi = "Jawa Barat",
                    kota = "Kota Depok",
                    totalKm = 24.0,
                    totalOrder = 2,
                    nominalBid = 85000,
                    dimulai = "09:15",
                    selesai = "17:00",
                    tanggal = "16 Ags 2026",
                    status = "Selesai"
                ),
                HistoricalBidItem(
                    id = 3,
                    idBid = "BID-9710",
                    jenisPengiriman = "REGULER",
                    mode = "AUTO",
                    provinsi = "DKI Jakarta",
                    kota = "Jakarta Timur",
                    totalKm = 8.7,
                    totalOrder = 3,
                    nominalBid = 30000,
                    dimulai = "13:00",
                    selesai = "18:20",
                    tanggal = "15 Ags 2026",
                    status = "Batal"
                )
            )
        }

        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // ─── TOP HEADER: INFO TOTAL + DROPDOWN MODE + FILTER STATUS ───
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 10.dp),
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Box 1: Info Pelengkap (Total Bid)
                Box(
                    modifier = Modifier.weight(0.32f),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Gavel,
                            contentDescription = "Total Bid",
                            tint = Slate950,
                            modifier = Modifier.size(15.dp)
                        )
                        Text(
                            text = "${dummyBidList.size} Riwayat",
                            fontFamily = FontFamily.SansSerif,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = Slate950,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }

                // Box 2: Filter Mode (Auto / Manual)
                Box(
                    modifier = Modifier.weight(0.38f),
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(34.dp)
                            .clip(RoundedCornerShape(6.dp))
                            .background(Zinc100)
                            .border(BorderStroke(1.dp, Zinc200), RoundedCornerShape(6.dp))
                            .clickable { isModeDropdownExpanded = true }
                            .padding(horizontal = 6.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = selectedMode,
                            fontFamily = FontFamily.SansSerif,
                            fontSize = 9.5.sp,
                            fontWeight = FontWeight.Medium,
                            color = Slate950,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "Mode Dropdown",
                            tint = Slate950,
                            modifier = Modifier.size(14.dp)
                        )
                    }

                    DropdownMenu(
                        expanded = isModeDropdownExpanded,
                        onDismissRequest = { isModeDropdownExpanded = false }
                    ) {
                        modeOptions.forEach { option ->
                            DropdownMenuItem(
                                text = { Text(option, fontSize = 11.sp, fontFamily = FontFamily.SansSerif) },
                                onClick = {
                                    selectedMode = option
                                    onModeFilterChange(option)
                                    isModeDropdownExpanded = false
                                }
                            )
                        }
                    }
                }

                // Box 3: Filter Status / Deep Filter
                Box(
                    modifier = Modifier.weight(0.3f),
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(34.dp)
                            .clip(RoundedCornerShape(6.dp))
                            .background(Slate950)
                            .clickable { onDeepFilterClick() }
                            .padding(horizontal = 6.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.FilterList,
                            contentDescription = "Filter",
                            tint = Color.White,
                            modifier = Modifier.size(13.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "Filter",
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

            // ─── BOTTOM LIST: CARD RIWAYAT BIDDING ───
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
                        items = dummyBidList,
                        key = { it.id }
                    ) { bidData ->
                        HistoricalBidCardItem(
                            data = bidData,
                            onCardClick = {
                                state.navController.navigate("$DetailsSectionPrefix/Bid")
                            }
                        )
                    }
                }
            }
        }

}

@Composable
fun HistoricalBidCardItem(
    data: HistoricalBidItem,
    onCardClick: () -> Unit
) {
    val rupiahFormat = remember { NumberFormat.getCurrencyInstance(Locale("id", "ID")) }

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
            // ─── HEADER: BADGE MODE, ID BID & STATUS BADGE ───
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Badge Auto/Manual Bid
                    Box(
                        modifier = Modifier
                            .background(
                                if (data.mode.equals("AUTO", ignoreCase = true)) Slate950 else Zinc100,
                                RoundedCornerShape(4.dp)
                            )
                            .padding(horizontal = 6.dp, vertical = 2.dp)
                    ) {
                        Text(
                            text = "${data.mode} BID",
                            fontFamily = FontFamily.Monospace,
                            fontWeight = FontWeight.Bold,
                            fontSize = 8.5.sp,
                            color = if (data.mode.equals("AUTO", ignoreCase = true)) Color.White else Slate950
                        )
                    }

                    Text(
                        text = "#${data.idBid}",
                        fontFamily = FontFamily.Monospace,
                        fontSize = 10.sp,
                        color = Zinc400,
                        fontWeight = FontWeight.Medium
                    )
                }

                // Status Badge
                Box(
                    modifier = Modifier
                        .background(
                            when (data.status.lowercase()) {
                                "selesai" -> Zinc100
                                "berlangsung" -> Teal400
                                else -> Color(0xFFFEE2E2)
                            },
                            RoundedCornerShape(4.dp)
                        )
                        .padding(horizontal = 6.dp, vertical = 2.dp)
                ) {
                    Text(
                        text = data.status.uppercase(),
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Bold,
                        fontSize = 9.sp,
                        color = when (data.status.lowercase()) {
                            "selesai" -> Slate950
                            "berlangsung" -> Color.White
                            else -> Color(0xFFDC2626)
                        }
                    )
                }
            }

            HorizontalDivider(color = Zinc100, thickness = 1.dp)

            // ─── MIDDLE: LOKASI, SPESIFIKASI & NOMINAL BID ───
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Navigation,
                            contentDescription = null,
                            tint = Slate950,
                            modifier = Modifier.size(13.dp)
                        )
                        Text(
                            text = "${data.kota}, ${data.provinsi}",
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Bold,
                            fontSize = 12.sp,
                            color = Slate950,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }

                    Text(
                        text = "${data.jenisPengiriman} • ${data.totalKm} KM • ${data.totalOrder} Order",
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 10.sp,
                        color = Zinc600,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                // Nominal Bid
                Column(horizontalAlignment = Alignment.End) {
                    Text(
                        text = rupiahFormat.format(data.nominalBid).replace(",00", ""),
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp,
                        color = Slate950
                    )
                    Text(
                        text = "Nilai Bid",
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 9.sp,
                        color = Zinc400
                    )
                }
            }

            // ─── FOOTER: RENTANG JAM OPERASIONAL & TANGGAL ───
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Jam: ${data.dimulai} - ${data.selesai}",
                    fontFamily = FontFamily.Monospace,
                    fontSize = 9.5.sp,
                    color = Zinc600
                )

                Text(
                    text = data.tanggal,
                    fontFamily = FontFamily.Monospace,
                    fontSize = 9.5.sp,
                    color = Zinc400
                )
            }
        }
    }
}