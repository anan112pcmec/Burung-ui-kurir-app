package com.example.burungkurirapp.ui.section.Home.page.Home.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.burungkurirapp.ui.constant.color.*

// ─── DATA MODELS ───
data class OperationalStats(
    val totalPengiriman: Int = 1420,
    val berhasil: Int = 1385,
    val gagal: Int = 35,
    val troubleRate: Double = 2.46,
    val totalReview: Int = 480,
    val goodReview: Int = 462,
    val badReview: Int = 18,
    val ratingAvg: Double = 4.92
)

data class TimeSlot(val label: String)

// ─── HELPER COLOR FOR HEATMAP ───
private fun getHeatmapColors(level: Int): Pair<Color, Color> {
    return when (level) {
        3 -> Slate950 to Color.White         // Peak (Tinggi)
        2 -> Zinc400 to Color.White         // Medium (Sedang)
        1 -> Zinc200 to Zinc700             // Low (Rendah)
        else -> Zinc50 to Color.Transparent // Inactive
    }
}

@Preview(showBackground=true)
@Composable
fun PanelTugasOperasionalSection(
    modifier: Modifier = Modifier,
    stats: OperationalStats = OperationalStats()
) {
    val days = listOf("Sen", "Sel", "Rab", "Kam", "Jum", "Sab", "Ming")
    val timeSlots = listOf(
        TimeSlot("00:00 - 04:00"),
        TimeSlot("04:00 - 08:00"),
        TimeSlot("08:00 - 12:00"),
        TimeSlot("12:00 - 16:00"),
        TimeSlot("16:00 - 20:00"),
        TimeSlot("20:00 - 24:00")
    )

    val heatmapData = listOf(
        listOf(0, 0, 0, 0, 0, 0, 0),
        listOf(1, 1, 1, 1, 1, 0, 0),
        listOf(3, 3, 3, 3, 3, 2, 1),
        listOf(3, 2, 3, 3, 3, 3, 1),
        listOf(2, 3, 2, 2, 3, 2, 0),
        listOf(1, 1, 1, 1, 2, 1, 0)
    )

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(2.dp))
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        // ─── 1. HEADER HALAMAN: TITLE & QUICK INFO ───
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column (modifier = Modifier.weight(0.6f)){
                Text(
                    text = "IKHTISAR PERFORMA KURIR",
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.Bold,
                    fontSize = 11.sp,
                    color = Slate950,
                    letterSpacing = 1.sp
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "Analisis histori operasional, keandalan, dan aktivitas harian.",
                    fontFamily = FontFamily.Monospace,
                    fontSize = 8.sp,
                    color = Zinc400
                )
            }
            Spacer(modifier = Modifier.weight(0.1f))
            Box(
                modifier = Modifier
                    .background(Zinc100, RoundedCornerShape(2.dp))
                    .border(BorderStroke(1.dp, Zinc200), RoundedCornerShape(2.dp))
                    .padding(horizontal = 6.dp, vertical = 3.dp)
                    .weight(0.3f),
                contentAlignment = Alignment.Center
            ) {
               Row() {
                   Text(
                       text = "PERFORMA:",
                       fontFamily = FontFamily.Monospace,
                       fontWeight = FontWeight.Bold,
                       fontSize = 5.sp,
                       color = Teal600
                   )
                   Text(
                       text = "SANGAT BAIK",
                       fontFamily = FontFamily.Monospace,
                       fontWeight = FontWeight.Bold,
                       fontSize = 5.sp,
                       color = Teal600
                   )
               }
            }
        }

        Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(Zinc100))

        // ─── 2. BARIS 1: METRIK STATISTIK PENGIRIMAN (GRID 2x2) ───
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            // Row 1: Total & Selesai
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                MetricCard(
                    modifier = Modifier.weight(1f),
                    title = "TOTAL PENGIRIMAN",
                    value = stats.totalPengiriman.toString(),
                    badgeText = "Order",
                    subtitle = "Akumulasi rute",
                    valueColor = Slate950
                )
                MetricCard(
                    modifier = Modifier.weight(1f),
                    title = "SELESAI (BERHASIL)",
                    value = stats.berhasil.toString(),
                    badgeText = "${String.format("%.1f", (stats.berhasil.toDouble() / stats.totalPengiriman) * 100)}%",
                    subtitle = "Paket diterima",
                    valueColor = Teal600,
                    badgeBgColor = Color(0xFFECFDF5),
                    badgeTextColor = Zinc500
                )
            }

            // Row 2: Gagal & Trouble Rate
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                MetricCard(
                    modifier = Modifier.weight(1f),
                    title = "GAGAL / RETUR",
                    value = stats.gagal.toString(),
                    badgeText = "${String.format("%.1f", (stats.gagal.toDouble() / stats.totalPengiriman) * 100)}%",
                    subtitle = "Alamat salah/retur",
                    valueColor = Color(0xFFE11D48),
                    badgeBgColor = Color(0xFFFFF1F2),
                    badgeTextColor = Color(0xFFE11D48)
                )
                MetricCard(
                    modifier = Modifier.weight(1f),
                    title = "TROUBLE RATE",
                    value = "${stats.troubleRate}%",
                    badgeText = "< 5% TOLERANSI",
                    subtitle = "Kendala vs rute",
                    valueColor = Slate950,
                    badgeBgColor = Color(0xFFFEF3C7),
                    badgeTextColor = Teal600
                )
            }
        }

        Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(Zinc100))

        // ─── 3. BARIS 2: RATIO REVIEWS & HEATMAP ───
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            // A. REPUTASI & ULASAN BREAKDOWN
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, RoundedCornerShape(2.dp))
                    .border(BorderStroke(1.dp, Zinc200), RoundedCornerShape(2.dp))
                    .padding(10.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "REPUTASI & ULASAN",
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Bold,
                        fontSize = 9.sp,
                        color = Slate950
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = null,
                            tint = Teal600,
                            modifier = Modifier.size(11.dp)
                        )
                        Spacer(modifier = Modifier.width(3.dp))
                        Text(
                            text = "${stats.ratingAvg} / 5.0",
                            fontFamily = FontFamily.Monospace,
                            fontWeight = FontWeight.Bold,
                            fontSize = 9.sp,
                            color = Slate950
                        )
                    }
                }

                // Good Review Bar
                val goodPercent = (stats.goodReview.toFloat() / stats.totalReview.toFloat())
                ProgressBarRow(
                    label = "Ulasan Positif (★ 4-5)",
                    countText = "${stats.goodReview} (${(goodPercent * 100).toInt()}%)",
                    progressFraction = goodPercent,
                    progressColor = Teal600
                )

                // Bad Review Bar
                val badPercent = (stats.badReview.toFloat() / stats.totalReview.toFloat())
                ProgressBarRow(
                    label = "Ulasan Negatif (★ 1-3)",
                    countText = "${stats.badReview} (${(badPercent * 100).toInt()}%)",
                    progressFraction = badPercent,
                    progressColor = Color(0xFFE11D48)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Total Responden:",
                        fontFamily = FontFamily.Monospace,
                        fontSize = 8.sp,
                        color = Zinc400
                    )
                    Text(
                        text = "${stats.totalReview} Pengguna",
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Bold,
                        fontSize = 8.sp,
                        color = Slate950
                    )
                }
            }

            // B. HEATMAP JAM AKTIF OPERASIONAL
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, RoundedCornerShape(2.dp))
                    .border(BorderStroke(1.dp, Zinc200), RoundedCornerShape(2.dp))
                    .padding(10.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "HEATMAP JAM AKTIF",
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Bold,
                        fontSize = 9.sp,
                        color = Slate950
                    )

                    // Legend
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(3.dp)
                    ) {
                        Text("Rendah", fontFamily = FontFamily.Monospace, fontSize = 7.sp, color = Zinc400)
                        Box(modifier = Modifier.size(6.dp).background(Zinc200))
                        Box(modifier = Modifier.size(6.dp).background(Zinc400))
                        Box(modifier = Modifier.size(6.dp).background(Slate950))
                        Text("Tinggi", fontFamily = FontFamily.Monospace, fontSize = 7.sp, color = Zinc400)
                    }
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()

                ) {
                    // Header Row (Days)
                    Row(modifier = Modifier.padding(bottom = 4.dp)) {
                        Box(modifier = Modifier.width(72.dp)) {
                            Text("JAM", fontFamily = FontFamily.Monospace, fontSize = 7.sp, color = Zinc400)
                        }
                        days.forEach { day ->
                            Box(modifier = Modifier.width(32.dp), contentAlignment = Alignment.Center) {
                                Text(day.uppercase(), fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold, fontSize = 8.sp, color = Zinc600)
                            }
                        }
                    }

                    // Matrix Slots Rows
                    timeSlots.forEachIndexed { rowIndex, slot ->
                        Row(
                            modifier = Modifier.padding(vertical = 2.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(modifier = Modifier.width(72.dp)) {
                                Text(slot.label, fontFamily = FontFamily.Monospace, fontSize = 7.sp, color = Zinc500)
                            }

                            days.forEachIndexed { colIndex, _ ->
                                val level = heatmapData[rowIndex][colIndex]
                                val (bgColor, textColor) = getHeatmapColors(level)

                                Box(
                                    modifier = Modifier
                                        .padding(horizontal = 1.dp)
                                        .width(30.dp)
                                        .height(20.dp)
                                        .background(bgColor, RoundedCornerShape(1.dp))
                                        .border(BorderStroke(0.5.dp, Zinc200), RoundedCornerShape(1.dp)),
                                    contentAlignment = Alignment.Center
                                ) {
                                    if (level == 3) {
                                        Text(
                                            text = "PEAK",
                                            fontFamily = FontFamily.Monospace,
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 6.sp,
                                            color = textColor
                                        )
                                    }
                                }
                            }
                        }
                    }
                }

                Text(
                    text = "* Intensitas order berdasarkan akumulasi log GPS harian.",
                    fontFamily = FontFamily.Monospace,
                    fontSize = 7.sp,
                    color = Zinc400
                )
            }
        }
    }
}

// ─── REUSABLE SUB-COMPONENTS ───
@Composable
private fun MetricCard(
    modifier: Modifier = Modifier,
    title: String,
    value: String,
    badgeText: String,
    subtitle: String,
    valueColor: Color,
    badgeBgColor: Color = Zinc100,
    badgeTextColor: Color = Zinc600
) {
    Column(
        modifier = modifier
            .background(Zinc50, RoundedCornerShape(2.dp))
            .border(BorderStroke(1.dp, Zinc200), RoundedCornerShape(2.dp))
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = title,
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.Bold,
            fontSize = 8.sp,
            color = Zinc400,
            letterSpacing = 0.5.sp
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = value,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                color = valueColor
            )

            Box(
                modifier = Modifier
                    .background(badgeBgColor, RoundedCornerShape(2.dp))
                    .padding(horizontal = 4.dp, vertical = 1.dp)
            ) {
                Text(
                    text = badgeText,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.Bold,
                    fontSize = 7.sp,
                    color = badgeTextColor
                )
            }
        }

        Text(
            text = subtitle,
            fontFamily = FontFamily.Monospace,
            fontSize = 7.sp,
            color = Zinc400
        )
    }
}

@Composable
private fun ProgressBarRow(
    label: String,
    countText: String,
    progressFraction: Float,
    progressColor: Color
) {
    Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(label, fontFamily = FontFamily.Monospace, fontSize = 8.sp, color = Zinc600)
            Text(countText, fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold, fontSize = 8.sp, color = progressColor)
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(4.dp)
                .background(Zinc100, RoundedCornerShape(1.dp))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(fraction = progressFraction.coerceIn(0f, 1f))
                    .background(progressColor, RoundedCornerShape(1.dp))
            )
        }
    }
}