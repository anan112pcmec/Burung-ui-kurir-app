package com.example.burungkurirapp.ui.section.Historical.page.Informasi

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Badge
import androidx.compose.material.icons.filled.TwoWheeler
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

// ─── TAB CATEGORY ENUM ───
enum class InformasiTabCategory {
    KURIR,
    KENDARAAN
}

// ─── UNIFIED DATA MODELS (Go Struct Mappers) ───
data class HistoricalInformasiKurirItem(
    val id: Long,
    val tanggalLahir: String = "12 Mei 1995",
    val alasan: String = "Pembaruan KTP & SIM karena expired",
    val isKtp: Boolean = true,
    val isSim: Boolean = true,
    val status: String = "Approved", // Pending, Approved, Rejected
    val tanggal: String = "17 Ags 2026, 11:00 WIB"
)

data class HistoricalInformasiKendaraanItem(
    val id: Long,
    val jenisKendaraan: String = "Motor",
    val namaKendaraan: String = "Honda Vario 160",
    val rodaKendaraan: String = "2",
    val isStnk: Boolean = true,
    val isBpkb: Boolean = false,
    val noRangka: String = "MH1JFA12345678",
    val noMesin: String = "JFA1E123456",
    val status: String = "Pending", // Pending, Approved, Rejected
    val tanggal: String = "15 Ags 2026, 14:30 WIB"
)

@Preview(showBackground = true)
@Composable
fun HistoricalInformasiPagePreview() {
    HistoricalInformasiPage()
}

@Composable
fun HistoricalInformasiPage() {
    CompositionLocalProvider(LocalUiFlowState provides rememberUiFlowState()) {
        val state = LocalUiFlowState.current
        var selectedTab by remember { mutableStateOf(InformasiTabCategory.KURIR) }

        val dummyKurirList = remember {
            listOf(
                HistoricalInformasiKurirItem(
                    id = 1,
                    tanggalLahir = "12 Mei 1995",
                    alasan = "Pembaruan alamat KTP terbaru",
                    isKtp = true,
                    isSim = true,
                    status = "Approved",
                    tanggal = "17 Ags 2026, 10:00 WIB"
                ),
                HistoricalInformasiKurirItem(
                    id = 2,
                    tanggalLahir = "12 Mei 1995",
                    alasan = "Pengajuan perpanjangan SIM C",
                    isKtp = false,
                    isSim = true,
                    status = "Pending",
                    tanggal = "10 Jul 2026, 09:15 WIB"
                ),
                HistoricalInformasiKurirItem(
                    id = 3,
                    tanggalLahir = "12 Mei 1995",
                    alasan = "Registrasi awal data kurir",
                    isKtp = true,
                    isSim = true,
                    status = "Approved",
                    tanggal = "01 Jan 2026, 08:00 WIB"
                )
            )
        }

        val dummyKendaraanList = remember {
            listOf(
                HistoricalInformasiKendaraanItem(
                    id = 101,
                    jenisKendaraan = "Motor",
                    namaKendaraan = "Honda Vario 160",
                    rodaKendaraan = "2",
                    isStnk = true,
                    isBpkb = true,
                    noRangka = "MH1JFA12345678",
                    noMesin = "JFA1E123456",
                    status = "Pending",
                    tanggal = "15 Ags 2026, 14:30 WIB"
                ),
                HistoricalInformasiKendaraanItem(
                    id = 102,
                    jenisKendaraan = "Mobil",
                    namaKendaraan = "Daihatsu Gran Max",
                    rodaKendaraan = "4",
                    isStnk = true,
                    isBpkb = false,
                    noRangka = "MHKE123456789",
                    noMesin = "K3VE987654",
                    status = "Approved",
                    tanggal = "02 Mei 2026, 11:20 WIB"
                )
            )
        }

        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // ─── TOP HEADER: TITLE + TOGGLE TAB SELECTOR (KURIR | KENDARAAN) ───
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Histori Informasi",
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Slate950
                )

                // Segmented Switcher Pill
                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(Zinc100)
                        .padding(3.dp),
                    horizontalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    InformasiTabChip(
                        title = "Kurir",
                        isSelected = selectedTab == InformasiTabCategory.KURIR,
                        onClick = { selectedTab = InformasiTabCategory.KURIR }
                    )
                    InformasiTabChip(
                        title = "Kendaraan",
                        isSelected = selectedTab == InformasiTabCategory.KENDARAAN,
                        onClick = { selectedTab = InformasiTabCategory.KENDARAAN }
                    )
                }
            }

            HorizontalDivider(color = Zinc100, thickness = 1.dp)

            // ─── LIST HISTORI DYNAMIC CONTENT ───
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
                    if (selectedTab == InformasiTabCategory.KURIR) {
                        items(
                            items = dummyKurirList,
                            key = { "kurir_${it.id}" }
                        ) { item ->
                            HistoricalInformasiKurirCard(
                                data = item,
                                onCardClick = { id ->
                                    state?.navController?.navigate("/details/historical-informasi/kurir/$id")
                                }
                            )
                        }
                    } else {
                        items(
                            items = dummyKendaraanList,
                            key = { "kendaraan_${it.id}" }
                        ) { item ->
                            HistoricalInformasiKendaraanCard(
                                data = item,
                                onCardClick = { id ->
                                    state?.navController?.navigate("/details/historical-informasi/kendaraan/$id")
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

// ─── TAB CHIP COMPONENT ───
@Composable
private fun InformasiTabChip(
    title: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(6.dp))
            .background(if (isSelected) Slate950 else Color.Transparent)
            .clickable { onClick() }
            .padding(horizontal = 12.dp, vertical = 6.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = title,
            fontFamily = FontFamily.SansSerif,
            fontSize = 11.sp,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
            color = if (isSelected) Color.White else Zinc600
        )
    }
}

// ─── CARD HISTORI INFORMASI KURIR ───
@Composable
fun HistoricalInformasiKurirCard(
    data: HistoricalInformasiKurirItem,
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
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            // Header: Icon + Alasan & Status Chip
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        imageVector = Icons.Default.Badge,
                        contentDescription = null,
                        tint = Slate950,
                        modifier = Modifier.size(16.dp)
                    )
                    Text(
                        text = data.alasan.ifEmpty { "Pembaruan Profil Kurir" },
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        color = Slate950,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                StatusBadgeChip(status = data.status)
            }

            HorizontalDivider(color = Zinc100, thickness = 1.dp)

            // Middle Info: Checklist KTP/SIM + Tgl Lahir
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                    DocumentBadge(label = "KTP", isAvailable = data.isKtp)
                    DocumentBadge(label = "SIM", isAvailable = data.isSim)
                }

                Text(
                    text = "Tgl Lahir: ${data.tanggalLahir}",
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 10.sp,
                    color = Zinc600
                )
            }

            // Footer: Timestamp
            Text(
                text = data.tanggal,
                fontFamily = FontFamily.Monospace,
                fontSize = 9.5.sp,
                color = Zinc400
            )
        }
    }
}

// ─── CARD HISTORI INFORMASI KENDARAAN ───
@Composable
fun HistoricalInformasiKendaraanCard(
    data: HistoricalInformasiKendaraanItem,
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
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            // Header: Nama Kendaraan & Status
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        imageVector = Icons.Default.TwoWheeler,
                        contentDescription = null,
                        tint = Slate950,
                        modifier = Modifier.size(16.dp)
                    )
                    Text(
                        text = "${data.namaKendaraan} (${data.jenisKendaraan})",
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        color = Slate950,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                StatusBadgeChip(status = data.status)
            }

            HorizontalDivider(color = Zinc100, thickness = 1.dp)

            // Middle Info: STNK & BPKB Badge + Detail Rangka
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                    DocumentBadge(label = "STNK", isAvailable = data.isStnk)
                    DocumentBadge(label = "BPKB", isAvailable = data.isBpkb)
                }

                Text(
                    text = "Roda ${data.rodaKendaraan}",
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.Medium,
                    fontSize = 10.sp,
                    color = Slate950
                )
            }

            // Sub Detail No Rangka / Mesin
            if (data.noRangka.isNotEmpty()) {
                Text(
                    text = "No. Rangka: ${data.noRangka} | No. Mesin: ${data.noMesin}",
                    fontFamily = FontFamily.Monospace,
                    fontSize = 9.5.sp,
                    color = Zinc600,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            // Footer: Timestamp
            Text(
                text = data.tanggal,
                fontFamily = FontFamily.Monospace,
                fontSize = 9.5.sp,
                color = Zinc400
            )
        }
    }
}

// ─── HELPER COMPONENTS ───
@Composable
private fun StatusBadgeChip(status: String) {
    val (bgColor, textColor) = when (status.lowercase()) {
        "approved" -> Teal400 to Color.White
        "rejected" -> Color(0xFFDC2626) to Color.White
        else -> Zinc100 to Slate950 // Pending
    }

    Box(
        modifier = Modifier
            .background(bgColor, RoundedCornerShape(4.dp))
            .padding(horizontal = 6.dp, vertical = 2.dp)
    ) {
        Text(
            text = status.uppercase(),
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.Bold,
            fontSize = 8.5.sp,
            color = textColor
        )
    }
}

@Composable
private fun DocumentBadge(label: String, isAvailable: Boolean) {
    Box(
        modifier = Modifier
            .background(if (isAvailable) Zinc100 else Color(0xFFFEE2E2), RoundedCornerShape(4.dp))
            .border(
                BorderStroke(1.dp, if (isAvailable) Zinc200 else Color(0xFFFCA5A5)),
                RoundedCornerShape(4.dp)
            )
            .padding(horizontal = 6.dp, vertical = 2.dp)
    ) {
        Text(
            text = "$label ${if (isAvailable) "✓" else "✕"}",
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.Bold,
            fontSize = 9.sp,
            color = if (isAvailable) Slate950 else Color(0xFFDC2626)
        )
    }
}