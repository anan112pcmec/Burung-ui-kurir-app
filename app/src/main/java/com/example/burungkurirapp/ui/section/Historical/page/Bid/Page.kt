package com.example.burungkurirapp.ui.section.History

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.FilterList
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
import androidx.compose.foundation.lazy.items
import com.example.burungkurirapp.ui.section.LocalUiFlowState
import com.example.burungkurirapp.ui.section.rememberUiFlowState

data class HistoricalBidItem(
    val id: Long,
    val jenisPengiriman: String = "REGULER",
    val mode: String = "AUTO",
    val provinsi: String = "DKI Jakarta",
    val kota: String = "Jakarta Selatan",
    val totalKm: Double = 14.2,
    val dimulai: String = "08:00",
    val selesai: String = "16:30",
    val status: String = "Selesai"
)

@Preview(showBackground = true)
@Composable
fun HistoricalBidPage(
    onSearchQueryChange: (String) -> Unit = {},
    onSortChange: (String) -> Unit = {},
    onDeepFilterClick: () -> Unit = {}
) {
    CompositionLocalProvider(LocalUiFlowState provides rememberUiFlowState()) {
        val state = LocalUiFlowState.current
        val dummyBidList = remember {
            listOf(
                HistoricalBidItem(
                    id = 1,
                    provinsi = "DKI Jakarta",
                    kota = "Jakarta Selatan",
                    totalKm = 12.5,
                    dimulai = "08:00",
                    selesai = "15:30",
                    status = "Selesai"
                ),
                HistoricalBidItem(
                    id = 2,
                    provinsi = "Jawa Barat",
                    kota = "Kota Depok",
                    totalKm = 24.0,
                    dimulai = "09:15",
                    selesai = "17:00",
                    status = "Selesai"
                ),
                HistoricalBidItem(
                    id = 3,
                    provinsi = "DKI Jakarta",
                    kota = "Jakarta Timur",
                    totalKm = 8.7,
                    dimulai = "13:00",
                    selesai = "18:20",
                    status = "Batal"
                )
            )
        }

        var searchQuery by remember { mutableStateOf("") }
        var selectedSort by remember { mutableStateOf("Terbaru") }
        var isDropdownExpanded by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.Start
        ) {
            Row(
                modifier = Modifier
                    .weight(0.2f)
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // ─── BOX 1: FILTER CEPAT (0.2f) ───
                Box(
                    modifier = Modifier
                        .weight(0.2f)
                        .padding(end = 4.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(38.dp)
                            .clip(RoundedCornerShape(6.dp))
                            .background(Zinc100)
                            .border(BorderStroke(1.dp, Zinc200), RoundedCornerShape(6.dp))
                            .clickable { isDropdownExpanded = true }
                            .padding(horizontal = 6.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = selectedSort,
                            fontFamily = FontFamily.SansSerif,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Medium,
                            color = Slate950,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "Sort Dropdown",
                            tint = Slate950,
                            modifier = Modifier.size(14.dp)
                        )
                    }

                    DropdownMenu(
                        expanded = isDropdownExpanded,
                        onDismissRequest = { isDropdownExpanded = false }
                    ) {
                        DropdownMenuItem(
                            text = {
                                Text(
                                    "Terbaru",
                                    fontSize = 11.sp,
                                    fontFamily = FontFamily.SansSerif
                                )
                            },
                            onClick = {
                                selectedSort = "Terbaru"
                                onSortChange("Terbaru")
                                isDropdownExpanded = false
                            }
                        )
                        DropdownMenuItem(
                            text = {
                                Text(
                                    "Terlama",
                                    fontSize = 11.sp,
                                    fontFamily = FontFamily.SansSerif
                                )
                            },
                            onClick = {
                                selectedSort = "Terlama"
                                onSortChange("Terlama")
                                isDropdownExpanded = false
                            }
                        )
                    }
                }

                // ─── BOX 2: SEARCH BAR (0.5f) ───
                Box(
                    modifier = Modifier
                        .weight(0.8f)
                        .padding(horizontal = 4.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(38.dp)
                            .clip(RoundedCornerShape(6.dp))
                            .background(Color.White)
                            .border(BorderStroke(1.dp, Zinc300), RoundedCornerShape(6.dp))
                            .padding(horizontal = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search",
                            tint = Zinc400,
                            modifier = Modifier.size(14.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        BasicTextField(
                            value = searchQuery,
                            onValueChange = {
                                searchQuery = it
                                onSearchQueryChange(it)
                            },
                            singleLine = true,
                            textStyle = TextStyle(
                                fontFamily = FontFamily.SansSerif,
                                fontSize = 10.sp,
                                color = Slate950
                            ),
                            modifier = Modifier.fillMaxWidth(),
                            decorationBox = { innerTextField ->
                                if (searchQuery.isEmpty()) {
                                    Text(
                                        text = "Cari ID Order...",
                                        fontFamily = FontFamily.SansSerif,
                                        fontSize = 10.sp,
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

                // ─── BOX 3: FILTER LEBIH DALAM (0.3f) ───
                Box(
                    modifier = Modifier
                        .weight(0.3f)
                        .padding(start = 4.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(38.dp)
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
                            modifier = Modifier.size(14.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "Filter Status",
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
            Column(
                modifier = Modifier
                    .weight(0.8f)
                    .fillMaxWidth()
            ) {
                // Contoh daftar data dummy (Ganti dengan list dari ViewModel/State)

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
                            onCardClick = { bidId ->
                                // Navigasi ke halaman detail
                                state.navController.navigate("/details/bid/$bidId")
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun HistoricalBidCardItem(
    data: HistoricalBidItem,
    onCardClick: (Long) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(Color.White)
            .border(BorderStroke(1.dp, Zinc200), RoundedCornerShape(8.dp))
            .clickable { onCardClick(data.id) }
            .padding(14.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // ─── TOP ROW: JENIS LAYANAN & RENTANG WAKTU ───
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Badge Status & Layanan
                Row(
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .background(
                                if (data.status == "Selesai") Zinc100 else Color(0xFFFEE2E2),
                                RoundedCornerShape(4.dp)
                            )
                            .padding(horizontal = 6.dp, vertical = 2.dp)
                    ) {
                        Text(
                            text = data.status.uppercase(),
                            fontFamily = FontFamily.Monospace,
                            fontWeight = FontWeight.Bold,
                            fontSize = 9.sp,
                            color = if (data.status == "Selesai") Slate950 else Color(0xFFDC2626)
                        )
                    }

                    Text(
                        text = "${data.jenisPengiriman} • ${data.mode}",
                        fontFamily = FontFamily.Monospace,
                        fontSize = 10.sp,
                        color = Zinc400
                    )
                }

                // Rentang Waktu (Dimulai - Selesai)
                Text(
                    text = "${data.dimulai} - ${data.selesai}",
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.Bold,
                    fontSize = 11.sp,
                    color = Slate950
                )
            }

            HorizontalDivider(color = Zinc100, thickness = 1.dp)

            // ─── BOTTOM ROW: LOKASI & JARAK TEMPUH ───
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Info Lokasi (Kota & Provinsi)
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = data.kota,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        color = Slate950,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = data.provinsi,
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 10.sp,
                        color = Zinc600,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                // Info Jarak Tempuh (KM)
                Column(horizontalAlignment = Alignment.End) {
                    Text(
                        text = "${data.totalKm} KM",
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp,
                        color = Slate950
                    )
                    Text(
                        text = "Total Jarak",
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 9.sp,
                        color = Zinc400
                    )
                }
            }
        }
    }
}