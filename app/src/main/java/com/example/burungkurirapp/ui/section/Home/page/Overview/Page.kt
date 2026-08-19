package com.example.burungkurirapp.ui.section.Home.page.Overview

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.burungkurirapp.ui.constant.color.*

// ─── DATA MODELS ───
data class TopMetric(
    val label: String,
    val value: String,
    val stat: String
)

data class RegionalDist(
    val region: String,
    val percentage: String,
    val fraction: Float,
    val color: Color
)

data class IssueBreakdown(
    val type: String,
    val count: Int,
    val share: String
)

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun OverviewPage() {
    val timeRanges = listOf("Hari Ini", "Minggu Ini", "Bulan Ini", "Tahun Ini", "Custom")
    var selectedTimeRange by remember { mutableStateOf("Minggu Ini") }

    val topMetrics = listOf(
        TopMetric("RATA-RATA PICKUP", "14.2 Min", "Sesuai SLA (<20m)"),
        TopMetric("KETEPATAN WAKTU", "97.4%", "+1.2% vs minggu lalu"),
        TopMetric("DURASI SHIFT", "9.2 Jam", "Aktif 08:00 - 18:00"),
        TopMetric("BEBAN RATA-RATA", "14.8 Kg", "74% Kapasitas Terpakai"),
        TopMetric("RESPON INSIDEN", "3.5 Min", "Respon Darurat Cepat")
    )

    val regionalDist = listOf(
        RegionalDist("Jakarta Selatan (Kebayoran)", "52%", 0.52f, Slate950),
        RegionalDist("Jakarta Barat (Kebon Jeruk)", "28%", 0.28f, Zinc600),
        RegionalDist("Jakarta Pusat (Tanah Abang)", "12%", 0.12f, Zinc400),
        RegionalDist("Lainnya / Out-of-Bound", "8%", 0.08f, Zinc200)
    )

    val issueBreakdown = listOf(
        IssueBreakdown("Penerima Tidak Ada / Alamat Salah", 18, "51%"),
        IssueBreakdown("Cuaca Hujan Deras / Banjir", 10, "29%"),
        IssueBreakdown("Kendala Armada (Ban Bocor/Mesin)", 5, "14%"),
        IssueBreakdown("Paket Ditolak Penerima", 2, "6%")
    )

    val incidentHistory = listOf(1, 0, 3, 1, 0, 2, 0)
    val daysList = listOf("Sen", "Sel", "Rab", "Kam", "Jum", "Sab", "Min")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        // ─── SECTION 1: HEADER & TIME-RANGE SELECTOR ───
        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Text(
                text = "FLEET OPERATIONAL ANALYTICS",
                fontFamily = FontFamily.SansSerif,
                fontSize = 11.sp,
                color = Zinc400,
                letterSpacing = 0.5.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "STATISTIK OPERASIONAL KURIR",
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Slate950,
                letterSpacing = 0.5.sp
            )

            Spacer(modifier = Modifier.height(6.dp))

            // Selector Horizontal Time Ranges
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState())
                    .clip(RoundedCornerShape(2.dp))
                    .background(Zinc50)
                    .border(BorderStroke(1.dp, Zinc200), RoundedCornerShape(2.dp))
                    .padding(6.dp),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                timeRanges.forEach { range ->
                    val isSelected = range == selectedTimeRange
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(2.dp))
                            .background(if (isSelected) Slate950 else Color.White)
                            .border(
                                BorderStroke(1.dp, if (isSelected) Slate950 else Zinc200),
                                RoundedCornerShape(2.dp)
                            )
                            .clickable { selectedTimeRange = range }
                            .padding(horizontal = 12.dp, vertical = 6.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = range.uppercase(),
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Bold,
                            fontSize = 11.sp,
                            color = if (isSelected) Color.White else Zinc600,
                            letterSpacing = 0.5.sp
                        )
                    }
                }
            }
        }

        Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(Zinc100))

        // ─── SECTION 2: TOP METRIC CARDS ───
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            topMetrics.forEach { metric ->
                Column(
                    modifier = Modifier
                        .width(170.dp)
                        .clip(RoundedCornerShape(2.dp))
                        .background(Zinc50)
                        .border(BorderStroke(1.dp, Zinc200), RoundedCornerShape(2.dp))
                        .padding(14.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = metric.label,
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 10.sp,
                        color = Zinc400,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 14.sp,
                        letterSpacing = 0.5.sp
                    )
                    Text(
                        text = metric.value,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = Slate950
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(6.dp)
                                .clip(RoundedCornerShape(1.dp))
                                .background(Slate950)
                        )
                        Text(
                            text = metric.stat,
                            fontFamily = FontFamily.SansSerif,
                            fontSize = 10.sp,
                            color = Zinc600
                        )
                    }
                }
            }
        }

        // ─── SECTION 3: WIDGET 1 - SHIFT & KEHADIRAN ───
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            SectionTitleHeader("01. SHIFT & KEHADIRAN OPERASIONAL")

            // Heatmap Keaktifan Dispatch Matrix
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(2.dp))
                    .background(Color.White)
                    .border(BorderStroke(1.dp, Zinc200), RoundedCornerShape(2.dp))
                    .padding(14.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                        Text(
                            text = "MATRIKS KEAKTIFAN DISPATCH",
                            fontFamily = FontFamily.SansSerif,
                            fontSize = 11.sp,
                            color = Zinc400,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 0.5.sp
                        )
                        Text(
                            text = "Fokus Jam Aktif & Ambil Order",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = Slate950
                        )
                    }
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(2.dp))
                            .background(Zinc50)
                            .border(BorderStroke(1.dp, Zinc200), RoundedCornerShape(2.dp))
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                    ) {
                        Text(
                            text = "HOURLY LOG",
                            fontFamily = FontFamily.SansSerif,
                            fontSize = 9.sp,
                            color = Zinc600,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                // Grid Matrix Rows (Sen-Min x 12 Blocks)
                Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    daysList.forEachIndexed { dIdx, day ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Text(
                                text = day,
                                fontFamily = FontFamily.SansSerif,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = Zinc500,
                                modifier = Modifier.width(28.dp)
                            )

                            Row(
                                modifier = Modifier.weight(1f),
                                horizontalArrangement = Arrangement.spacedBy(3.dp)
                            ) {
                                for (i in 0 until 12) {
                                    val cellColor = when {
                                        dIdx < 5 && i in 4..9 -> Slate950
                                        dIdx < 5 && (i == 3 || i == 10) -> Zinc400
                                        else -> Zinc100
                                    }
                                    Box(
                                        modifier = Modifier
                                            .weight(1f)
                                            .height(20.dp)
                                            .clip(RoundedCornerShape(2.dp))
                                            .background(cellColor)
                                            .border(BorderStroke(0.5.dp, Zinc200), RoundedCornerShape(2.dp))
                                    )
                                }
                            }
                        }
                    }
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("00:00 WIB", fontFamily = FontFamily.SansSerif, fontSize = 10.sp, color = Zinc400)
                    Text("12:00 WIB", fontFamily = FontFamily.SansSerif, fontSize = 10.sp, color = Zinc400)
                    Text("23:59 WIB", fontFamily = FontFamily.SansSerif, fontSize = 10.sp, color = Zinc400)
                }
            }

            // Shift Compliance Rate Card
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(2.dp))
                    .background(Zinc50)
                    .border(BorderStroke(1.dp, Zinc200), RoundedCornerShape(2.dp))
                    .padding(14.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "SHIFT COMPLIANCE RATE",
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 11.sp,
                        color = Zinc400,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 0.5.sp
                    )
                    Text(
                        text = "94.2%",
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = Slate950
                    )
                }

                Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(Zinc200))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    DetailTextRow("Total Slot On-Duty:", "28 Slot", Slate950)
                    DetailTextRow("Tepat Waktu:", "26 Slot", Teal600)
                    DetailTextRow("Terlambat:", "2 Slot", Color(0xFFE11D48))
                }
            }
        }

        // ─── SECTION 4: WIDGET 2 - RUTE & EFISIENSI LOKASI ───
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            SectionTitleHeader("02. RUTE, JARAK & EFISIENSI LOKASI")

            // Jarak Tempuh Progress Bars
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(2.dp))
                    .background(Color.White)
                    .border(BorderStroke(1.dp, Zinc200), RoundedCornerShape(2.dp))
                    .padding(14.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "DISTRIBUSI JARAK TEMPUH (KM)",
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 11.sp,
                    color = Zinc400,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 0.5.sp
                )

                DistanceBarRow("Jarak Pendek (< 5 KM)", "55%", 0.55f, Slate950)
                DistanceBarRow("Jarak Menengah (5 - 15 KM)", "35%", 0.35f, Zinc600)
                DistanceBarRow("Jarak Jauh (> 15 KM)", "10%", 0.10f, Zinc400)
            }

            // Coverage Area Bar
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(2.dp))
                    .background(Color.White)
                    .border(BorderStroke(1.dp, Zinc200), RoundedCornerShape(2.dp))
                    .padding(14.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "KONSENTRASI RUTE OPERASIONAL",
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 11.sp,
                    color = Zinc400,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 0.5.sp
                )

                // Segmented Bar
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(12.dp)
                        .clip(RoundedCornerShape(2.dp))
                        .background(Zinc100)
                ) {
                    regionalDist.forEach { dist ->
                        Box(
                            modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth(fraction = dist.fraction)
                                .background(dist.color)
                        )
                    }
                }

                Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    regionalDist.forEach { dist ->
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(8.dp)
                                        .clip(RoundedCornerShape(2.dp))
                                        .background(dist.color)
                                )
                                Text(
                                    text = dist.region,
                                    fontSize = 12.sp,
                                    color = Zinc600,
                                    fontWeight = FontWeight.Medium
                                )
                            }
                            Text(
                                text = dist.percentage,
                                fontFamily = FontFamily.SansSerif,
                                fontWeight = FontWeight.Bold,
                                fontSize = 12.sp,
                                color = Slate950
                            )
                        }
                    }
                }
            }
        }

        // ─── SECTION 5: WIDGET 3 - LAPORAN KENDALA & RISIKO ───
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            SectionTitleHeader("03. LAPORAN KENDALA & MANAJEMEN RISIKO")

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                // Bar Chart Insiden (7 Hari)
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(2.dp))
                        .background(Color.White)
                        .border(BorderStroke(1.dp, Zinc200), RoundedCornerShape(2.dp))
                        .padding(14.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Text(
                        text = "INSIDEN (7 HARI)",
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 11.sp,
                        color = Zinc400,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 0.5.sp
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(80.dp),
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                        verticalAlignment = Alignment.Bottom
                    ) {
                        incidentHistory.forEachIndexed { idx, count ->
                            Column(
                                modifier = Modifier.weight(1f),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Bottom
                            ) {
                                Text(
                                    text = count.toString(),
                                    fontFamily = FontFamily.SansSerif,
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Zinc500
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(if (count == 0) 4.dp else (count * 20).dp)
                                        .clip(RoundedCornerShape(2.dp))
                                        .background(if (count > 2) Color(0xFFE11D48) else Slate950)
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = daysList[idx],
                                    fontFamily = FontFamily.SansSerif,
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Zinc600
                                )
                            }
                        }
                    }
                }

                // Breakdown Kategori Kendala List
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(2.dp))
                        .background(Color.White)
                        .border(BorderStroke(1.dp, Zinc200), RoundedCornerShape(2.dp))
                        .padding(14.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "PENYEBAB RETUR",
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 11.sp,
                        color = Zinc400,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 0.5.sp
                    )

                    issueBreakdown.forEach { issue ->
                        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = issue.type,
                                    fontSize = 11.sp,
                                    color = Zinc600,
                                    modifier = Modifier.weight(1f),
                                    maxLines = 1,
                                    fontWeight = FontWeight.Medium
                                )
                                Text(
                                    text = "${issue.count} (${issue.share})",
                                    fontFamily = FontFamily.SansSerif,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 11.sp,
                                    color = Slate950
                                )
                            }
                            Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(Zinc100))
                        }
                    }
                }
            }
        }
    }
}

// ─── REUSABLE HELPERS ───
@Composable
private fun SectionTitleHeader(title: String) {
    Text(
        text = title,
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
        color = Zinc400,
        letterSpacing = 0.5.sp
    )
}

@Composable
private fun DetailTextRow(label: String, value: String, valueColor: Color) {
    Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
        Text(text = label, fontFamily = FontFamily.SansSerif, fontSize = 10.sp, color = Zinc400)
        Text(text = value, fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.Bold, fontSize = 12.sp, color = valueColor)
    }
}

@Composable
private fun DistanceBarRow(label: String, percentageText: String, fraction: Float, barColor: Color) {
    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(label, fontSize = 12.sp, color = Zinc600, fontWeight = FontWeight.Medium)
            Text(percentageText, fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.Bold, fontSize = 12.sp, color = Slate950)
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(6.dp)
                .clip(RoundedCornerShape(2.dp))
                .background(Zinc100)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(fraction = fraction)
                    .clip(RoundedCornerShape(2.dp))
                    .background(barColor)
            )
        }
    }
}