package com.example.burungkurirapp.ui.section.Historical.page.Rekening

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
import androidx.compose.material.icons.filled.CreditCard
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

data class HistoricalRekeningItem(
    val id: Long,
    val tanggalWaktu: String = "14 Okt 2025, 14:30 WIB",
    val namaBank: String = "BCA",
    val nomorRekening: String = "1234567890",
    val namaPemilik: String = "Budi Pratama",
    val status: String = "Diubah"
)

@Preview(showBackground = true)
@Composable
fun HistoricalRekeningPagePreview() {
    HistoricalRekeningPage()
}

@Composable
fun HistoricalRekeningPage(
    onBankFilterSelect: (String) -> Unit = {},
    onDateFilterClick: () -> Unit = {}
) {
    val state = LocalUiFlowState.current

    var selectedBank by remember { mutableStateOf("Semua Bank") }
    var isBankDropdownExpanded by remember { mutableStateOf(false) }

    val bankOptions = listOf("Semua Bank", "BCA", "Mandiri", "BRI", "CIMB Niaga")

    val dummyHistoryList = remember {
        listOf(
            HistoricalRekeningItem(id = 1, tanggalWaktu = "14 Okt 2025, 14:30 WIB", namaBank = "BCA", nomorRekening = "8830123456", namaPemilik = "Budi Pratama", status = "Aktif"),
            HistoricalRekeningItem(id = 2, tanggalWaktu = "02 Sep 2025, 09:15 WIB", namaBank = "Mandiri", nomorRekening = "1370009876543", namaPemilik = "Budi Pratama", status = "Diubah"),
            HistoricalRekeningItem(id = 3, tanggalWaktu = "10 Jun 2025, 16:45 WIB", namaBank = "BRI", nomorRekening = "001201998877665", namaPemilik = "Budi Pratama", status = "Nonaktif")
        )
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // ─── TOP HEADER: PELENGKAP + FILTER BANK + FILTER WAKTU ───
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Box 1: Info Pelengkap
            Box(
                modifier = Modifier.weight(0.35f),
                contentAlignment = Alignment.CenterStart
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.CreditCard,
                        contentDescription = "Riwayat Rekening",
                        tint = Slate950,
                        modifier = Modifier.size(15.dp)
                    )
                    Text(
                        text = "${dummyHistoryList.size} Riwayat",
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = Slate950,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }

            // Box 2: Filter Jenis Bank (Dropdown)
            Box(
                modifier = Modifier.weight(0.35f),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(34.dp)
                        .clip(RoundedCornerShape(6.dp))
                        .background(Zinc100)
                        .border(BorderStroke(1.dp, Zinc200), RoundedCornerShape(6.dp))
                        .clickable { isBankDropdownExpanded = true }
                        .padding(horizontal = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = selectedBank,
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Medium,
                        color = Slate950,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Dropdown Bank",
                        tint = Slate950,
                        modifier = Modifier.size(14.dp)
                    )
                }

                DropdownMenu(
                    expanded = isBankDropdownExpanded,
                    onDismissRequest = { isBankDropdownExpanded = false }
                ) {
                    bankOptions.forEach { bank ->
                        DropdownMenuItem(
                            text = { Text(bank, fontSize = 11.sp, fontFamily = FontFamily.SansSerif) },
                            onClick = {
                                selectedBank = bank
                                onBankFilterSelect(bank)
                                isBankDropdownExpanded = false
                            }
                        )
                    }
                }
            }

            // Box 3: Filter Waktu
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

        // ─── BOTTOM LIST: CARD RIWAYAT REKENING ───
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
                ) { rekeningItem ->
                    HistoricalRekeningCardItem(
                        data = rekeningItem,
                        onCardClick = { state?.navController?.navigate("$DetailsSectionPrefix/Rekening")
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun HistoricalRekeningCardItem(
    data: HistoricalRekeningItem,
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
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            // Header Info Perubahan
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Perubahan rekening pada ${data.tanggalWaktu}",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 11.sp,
                    color = Slate950,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f)
                )

                Spacer(modifier = Modifier.width(6.dp))

                Box(
                    modifier = Modifier
                        .background(Zinc100, RoundedCornerShape(4.dp))
                        .padding(horizontal = 6.dp, vertical = 2.dp)
                ) {
                    Text(
                        text = data.status.uppercase(),
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Bold,
                        fontSize = 9.sp,
                        color = Slate950
                    )
                }
            }

            HorizontalDivider(color = Zinc100, thickness = 1.dp)

            // Content Body: Image Placeholder + Detail Rekening
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                // ─── PLACEHOLDER GAMBAR KARTU BANK ───
                Box(
                    modifier = Modifier
                        .size(width = 52.dp, height = 34.dp)
                        .clip(RoundedCornerShape(4.dp))
                        .background(Zinc100)
                        .border(BorderStroke(1.dp, Zinc300), RoundedCornerShape(4.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    // Wadah kosong untuk Image/Resource Logo Kartu
                    Text(
                        text = data.namaBank,
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Bold,
                        fontSize = 9.sp,
                        color = Zinc600
                    )
                }

                // Info Detail Rekening
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    Text(
                        text = "${data.namaBank} • ${data.nomorRekening}",
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        color = Slate950,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = "a.n. ${data.namaPemilik}",
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 10.sp,
                        color = Zinc600,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}