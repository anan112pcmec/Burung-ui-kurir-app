package com.example.burungkurirapp.ui.section.Historical.page.Profile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.History
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

data class HistoricalProfileItem(
    val id: Long,
    val tanggal: String = "14 Oktober 2025",
    val nama: String = "Budi Pratama",
    val email: String = "budi.pratama@example.com",
    val noHp: String = "081234567890",
    val tipePerubahan: String = "Update Kontak"
)

@Preview(showBackground = true)
@Composable
fun HistoricalProfilePagePreview() {
    HistoricalProfilePage()
}

@Composable
fun HistoricalProfilePage(
    onDateFilterClick: () -> Unit = {}
) {
    CompositionLocalProvider(LocalUiFlowState provides rememberUiFlowState()) {
    val state = LocalUiFlowState.current

    val dummyHistoryList = remember {
        listOf(
            HistoricalProfileItem(id = 1, tanggal = "14 Oktober 2025", nama = "Budi Pratama", email = "budi.pratama@example.com", noHp = "081234567890", tipePerubahan = "Update No. HP"),
            HistoricalProfileItem(id = 2, tanggal = "02 September 2025", nama = "Budi Pratama", email = "budi.new@example.com", noHp = "081234567890", tipePerubahan = "Update Email Utama"),
            HistoricalProfileItem(id = 3, tanggal = "15 Juli 2025", nama = "Budi P.", email = "budi.old@example.com", noHp = "081111111111", tipePerubahan = "Update Nama Lengkap")
        )
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // ─── TOP HEADER: PELENGKAP & FILTER WAKTU ───
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Box 1: Info Pelengkap
            Box(
                modifier = Modifier.weight(1f)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.History,
                        contentDescription = "Riwayat Profil",
                        tint = Slate950,
                        modifier = Modifier.size(16.dp)
                    )
                    Text(
                        text = "Total ${dummyHistoryList.size} kali perubahan",
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Medium,
                        color = Slate950,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }

            Spacer(modifier = Modifier.width(8.dp))

            // Box 2: Filter Waktu
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(6.dp))
                    .background(Zinc100)
                    .border(BorderStroke(1.dp, Zinc200), RoundedCornerShape(6.dp))
                    .clickable { onDateFilterClick() }
                    .padding(horizontal = 10.dp, vertical = 6.dp),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = "Filter Waktu",
                        tint = Slate950,
                        modifier = Modifier.size(14.dp)
                    )
                    Text(
                        text = "Filter Waktu",
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = Slate950
                    )
                }
            }
        }

        HorizontalDivider(color = Zinc100, thickness = 1.dp)

        // ─── BOTTOM LIST: CARD RIWAYAT PROFIL ───
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
                ) { historyItem ->
                    HistoricalProfileCardItem(
                        data = historyItem,
                        onCardClick = { profileId ->
                            state?.navController?.navigate("/details/historical-profile/$profileId")
                        }
                    )
                }
            }
        }
    }
        }
}

@Composable
fun HistoricalProfileCardItem(
    data: HistoricalProfileItem,
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
            // Header Tanggal Perubahan
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Perubahan profil pada ${data.tanggal}",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    color = Slate950,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Box(
                    modifier = Modifier
                        .background(Zinc100, RoundedCornerShape(4.dp))
                        .padding(horizontal = 6.dp, vertical = 2.dp)
                ) {
                    Text(
                        text = data.tipePerubahan,
                        fontFamily = FontFamily.Monospace,
                        fontSize = 9.sp,
                        color = Zinc600
                    )
                }
            }

            HorizontalDivider(color = Zinc100, thickness = 1.dp)

            // Info Ringkas Profil (Nama, Email, No HP)
            Column(
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                Text(
                    text = "Nama: ${data.nama}",
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 11.sp,
                    color = Slate950,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "Email: ${data.email}",
                    fontFamily = FontFamily.Monospace,
                    fontSize = 10.sp,
                    color = Zinc600,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "No. HP: ${data.noHp}",
                    fontFamily = FontFamily.Monospace,
                    fontSize = 10.sp,
                    color = Zinc400,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}