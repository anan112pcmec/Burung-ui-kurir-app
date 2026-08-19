package com.example.burungkurirapp.ui.section.Home.page.Home.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.burungkurirapp.ui.constant.color.Slate950
import com.example.burungkurirapp.ui.constant.color.Teal600
import com.example.burungkurirapp.ui.constant.color.Zinc100
import com.example.burungkurirapp.ui.constant.color.Zinc200
import com.example.burungkurirapp.ui.constant.color.Zinc400
import com.example.burungkurirapp.ui.constant.color.Zinc500
import com.example.burungkurirapp.ui.constant.color.Zinc600
import com.example.burungkurirapp.ui.constant.color.Zinc700

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

private fun getHeatmapColors(level: Int): Pair<Color, Color> {
    return when (level) {
        3 -> Slate950 to Color.White
        2 -> Zinc400 to Color.White
        1 -> Zinc200 to Zinc700
        else -> Zinc100 to Color.Transparent
    }
}

@Preview(showBackground = true)
@Composable
fun PanelTugasOperasionalSection(
    modifier: Modifier = Modifier,
    stats: OperationalStats = OperationalStats()
) {
    val days: List<String> = listOf("Sen", "Sel", "Rab", "Kam", "Jum", "Sab", "Ming")
    val timeSlots: List<String> = listOf(
        "00:00 - 04:00",
        "04:00 - 08:00",
        "08:00 - 12:00",
        "12:00 - 16:00",
        "16:00 - 20:00",
        "20:00 - 24:00"
    )

    val heatmapData: List<List<Int>> = listOf(
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
            .background(Color.White)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // ─── 1. HEADER HALAMAN ───
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "PERFORMA OPERASIONAL",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp,
                    color = Slate950
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "Ringkasan histori & aktivitas harian kurir",
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 11.sp,
                    color = Zinc500
                )
            }

            Surface(
                shape = RoundedCornerShape(4.dp),
                color = Color(0xFFECFDF5),
                border = BorderStroke(1.dp, Teal600)
            ) {
                Text(
                    text = "SANGAT BAIK",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 10.sp,
                    color = Teal600,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                )
            }
        }

        HorizontalDivider(color = Zinc200)

        // ─── 2. METRIK UTAMA (2x2 GRID) ───
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            val successRate: String = String.format("%.1f", (stats.berhasil.toDouble() / stats.totalPengiriman) * 100)
            val failRate: String = String.format("%.1f", (stats.gagal.toDouble() / stats.totalPengiriman) * 100)

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                MetricCard(
                    modifier = Modifier.weight(1f),
                    title = "TOTAL ORDER",
                    value = stats.totalPengiriman.toString(),
                    badgeText = "Selesai",
                    valueColor = Slate950
                )
                MetricCard(
                    modifier = Modifier.weight(1f),
                    title = "BERHASIL",
                    value = stats.berhasil.toString(),
                    badgeText = "$successRate%",
                    valueColor = Teal600,
                    badgeBgColor = Color(0xFFECFDF5),
                    badgeTextColor = Teal600
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                MetricCard(
                    modifier = Modifier.weight(1f),
                    title = "GAGAL / RETUR",
                    value = stats.gagal.toString(),
                    badgeText = "$failRate%",
                    valueColor = Color(0xFFE11D48),
                    badgeBgColor = Color(0xFFFFF1F2),
                    badgeTextColor = Color(0xFFE11D48)
                )
                MetricCard(
                    modifier = Modifier.weight(1f),
                    title = "TROUBLE RATE",
                    value = "${stats.troubleRate}%",
                    badgeText = "< 5% Aman",
                    valueColor = Slate950,
                    badgeBgColor = Zinc100,
                    badgeTextColor = Zinc600
                )
            }
        }

        // ─── 3. REPUTASI & REVIEWS ───
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .border(BorderStroke(1.dp, Zinc200), RoundedCornerShape(6.dp))
                .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "REPUTASI & ULASAN",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 11.sp,
                    color = Slate950
                )

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Rating",
                        tint = Teal600,
                        modifier = Modifier.size(14.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "${stats.ratingAvg} / 5.0",
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold,
                        fontSize = 11.sp,
                        color = Slate950
                    )
                }
            }

            val goodPercent: Float = (stats.goodReview.toFloat() / stats.totalReview.toFloat())
            ProgressBarRow(
                label = "Positif (★ 4-5)",
                countText = "${stats.goodReview} (${(goodPercent * 100).toInt()}%)",
                progressFraction = goodPercent,
                progressColor = Teal600
            )

            val badPercent: Float = (stats.badReview.toFloat() / stats.totalReview.toFloat())
            ProgressBarRow(
                label = "Negatif (★ 1-3)",
                countText = "${stats.badReview} (${(badPercent * 100).toInt()}%)",
                progressFraction = badPercent,
                progressColor = Color(0xFFE11D48)
            )
        }

        // ─── 4. HEATMAP JAM AKTIF (SCROLLABLE) ───
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .border(BorderStroke(1.dp, Zinc200), RoundedCornerShape(6.dp))
                .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "HEATMAP WAKTU AKTIF",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 11.sp,
                    color = Slate950
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Box(modifier = Modifier.size(8.dp).background(Zinc200))
                    Box(modifier = Modifier.size(8.dp).background(Zinc400))
                    Box(modifier = Modifier.size(8.dp).background(Slate950))
                    Text("Tinggi", fontFamily = FontFamily.SansSerif, fontSize = 9.sp, color = Zinc500)
                }
            }

            // Scrollable Matrix Heatmap
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState())
            ) {
                Column {
                    // Header Hari
                    Row(modifier = Modifier.padding(bottom = 6.dp)) {
                        Box(modifier = Modifier.width(90.dp)) {
                            Text("JAM", fontFamily = FontFamily.SansSerif, fontSize = 10.sp, color = Zinc400)
                        }
                        days.forEach { day: String ->
                            Box(modifier = Modifier.width(36.dp), contentAlignment = Alignment.Center) {
                                Text(
                                    text = day.uppercase(),
                                    fontFamily = FontFamily.SansSerif,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 10.sp,
                                    color = Zinc600
                                )
                            }
                        }
                    }

                    // Baris Jam
                    timeSlots.forEachIndexed { rowIndex: Int, timeLabel: String ->
                        Row(
                            modifier = Modifier.padding(vertical = 2.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(modifier = Modifier.width(90.dp)) {
                                Text(
                                    text = timeLabel,
                                    fontFamily = FontFamily.SansSerif,
                                    fontSize = 9.sp,
                                    color = Zinc600
                                )
                            }

                            days.forEachIndexed { colIndex: Int, _: String ->
                                val level: Int = heatmapData[rowIndex][colIndex]
                                val (bgColor: Color, textColor: Color) = getHeatmapColors(level)

                                Box(
                                    modifier = Modifier
                                        .padding(horizontal = 2.dp)
                                        .width(32.dp)
                                        .height(24.dp)
                                        .background(bgColor, RoundedCornerShape(2.dp)),
                                    contentAlignment = Alignment.Center
                                ) {
                                    if (level == 3) {
                                        Text(
                                            text = "PEAK",
                                            fontFamily = FontFamily.SansSerif,
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 7.sp,
                                            color = textColor
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

// ─── REUSABLE COMPONENTS ───
@Composable
private fun MetricCard(
    modifier: Modifier = Modifier,
    title: String,
    value: String,
    badgeText: String,
    valueColor: Color,
    badgeBgColor: Color = Zinc100,
    badgeTextColor: Color = Zinc600
) {
    Column(
        modifier = modifier
            .background(Color.White, RoundedCornerShape(6.dp))
            .border(BorderStroke(1.dp, Zinc200), RoundedCornerShape(6.dp))
            .padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                fontSize = 9.sp,
                color = Zinc500
            )

            Surface(
                shape = RoundedCornerShape(3.dp),
                color = badgeBgColor
            ) {
                Text(
                    text = badgeText,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 9.sp,
                    color = badgeTextColor,
                    modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp)
                )
            }
        }

        Text(
            text = value,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = valueColor
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
    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(label, fontFamily = FontFamily.SansSerif, fontSize = 11.sp, color = Zinc600)
            Text(countText, fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.Bold, fontSize = 11.sp, color = progressColor)
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(6.dp)
                .background(Zinc100, RoundedCornerShape(3.dp))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(fraction = progressFraction.coerceIn(0f, 1f))
                    .background(progressColor, RoundedCornerShape(3.dp))
            )
        }
    }
}