package com.example.burungkurirapp.ui.section.Overview

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
    val timeRanges = listOf("Hari Ini", "Minggu Ini", "Bulan Ini", "Tahun Ini", "Custom Date")
    var selectedTimeRange by remember { mutableStateOf("Minggu Ini") }

    val topMetrics = listOf(
        TopMetric("RATA-RATA PICKUP LEAD TIME", "14.2 Min", "Sesuai SLA (<20m)"),
        TopMetric("KETEPATAN WAKTU (ETA)", "97.4%", "+1.2% vs minggu lalu"),
        TopMetric("DURASI SHIFT ONLINE", "9.2 Jam/Hari", "Aktif jam 08:00 - 18:00"),
        TopMetric("KAPASITAS BEBAN RATA-RATA", "14.8 / 20 KG", "74% Kapasitas Terpakai"),
        TopMetric("INCIDENT REPORT TIME", "3.5 Min", "Respon Darurat Cepat")
    )

    val regionalDist = listOf(
        RegionalDist("Jakarta Selatan (Kebayoran & Cilandak)", "52%", 0.52f, Slate950),
        RegionalDist("Jakarta Barat (Kebon Jeruk & Palmerah)", "28%", 0.28f, Zinc600),
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
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // ─── SECTION 1: HEADER & TIME-RANGE SELECTOR ───
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(
                text = "FLEET OPERATIONAL ANALYTICS",
                fontFamily = FontFamily.Monospace,
                fontSize = 8.sp,
                color = Zinc400,
                letterSpacing = 1.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "STATISTIK OPERASIONAL KURIR",
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Slate950,
                letterSpacing = 1.sp
            )

            // Selector Horizontal Time Ranges
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState())
                    .background(Zinc50, RoundedCornerShape(2.dp))
                    .border(BorderStroke(1.dp, Zinc200), RoundedCornerShape(2.dp))
                    .padding(4.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                timeRanges.forEach { range ->
                    val isSelected = range == selectedTimeRange
                    Box(
                        modifier = Modifier
                            .background(
                                if (isSelected) Slate950 else Color.White,
                                RoundedCornerShape(2.dp)
                            )
                            .border(
                                BorderStroke(1.dp, if (isSelected) Slate950 else Zinc200),
                                RoundedCornerShape(2.dp)
                            )
                            .clickable { selectedTimeRange = range }
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                    ) {
                        Text(
                            text = range.uppercase(),
                            fontFamily = FontFamily.Monospace,
                            fontWeight = FontWeight.Bold,
                            fontSize = 8.sp,
                            color = if (isSelected) Color.White else Zinc600
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
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            topMetrics.forEach { metric ->
                Column(
                    modifier = Modifier
                        .width(160.dp)
                        .background(Zinc50, RoundedCornerShape(2.dp))
                        .border(BorderStroke(1.dp, Zinc200), RoundedCornerShape(2.dp))
                        .padding(10.dp),
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Text(
                        text = metric.label,
                        fontFamily = FontFamily.Monospace,
                        fontSize = 7.sp,
                        color = Zinc400,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 10.sp
                    )
                    Text(
                        text = metric.value,
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        color = Slate950
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(4.dp)
                                .background(Slate950, RoundedCornerShape(2.dp))
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = metric.stat,
                            fontFamily = FontFamily.Monospace,
                            fontSize = 7.sp,
                            color = Zinc600
                        )
                    }
                }
            }
        }

        // ─── SECTION 3: WIDGET 1 - SHIFT & KEHADIRAN ───
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            SectionTitleHeader("01. SHIFT & KEHADIRAN OPERASIONAL")

            // Heatmap Keaktifan Dispatch Matrix
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
                    Column {
                        Text(
                            text = "MATRIKS KEAKTIFAN DISPATCH",
                            fontFamily = FontFamily.Monospace,
                            fontSize = 8.sp,
                            color = Zinc400,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Fokus Jam Aktif & Ambil Order",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = Slate950
                        )
                    }
                    Box(
                        modifier = Modifier
                            .background(Zinc50, RoundedCornerShape(2.dp))
                            .border(BorderStroke(1.dp, Zinc200), RoundedCornerShape(2.dp))
                            .padding(horizontal = 6.dp, vertical = 2.dp)
                    ) {
                        Text(
                            text = "HOURLY LOG",
                            fontFamily = FontFamily.Monospace,
                            fontSize = 7.sp,
                            color = Zinc600
                        )
                    }
                }

                // Grid Matrix Rows (Sen-Min x 12 Blocks)
                Column(verticalArrangement = Arrangement.spacedBy(3.dp)) {
                    daysList.forEachIndexed { dIdx, day ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            Text(
                                text = day,
                                fontFamily = FontFamily.Monospace,
                                fontSize = 8.sp,
                                color = Zinc400,
                                modifier = Modifier.width(20.dp)
                            )

                            Row(
                                modifier = Modifier.weight(1f),
                                horizontalArrangement = Arrangement.spacedBy(2.dp)
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
                                            .height(16.dp)
                                            .background(cellColor, RoundedCornerShape(1.dp))
                                            .border(BorderStroke(0.5.dp, Zinc200), RoundedCornerShape(1.dp))
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
                    Text("00:00 WIB", fontFamily = FontFamily.Monospace, fontSize = 7.sp, color = Zinc400)
                    Text("12:00 WIB", fontFamily = FontFamily.Monospace, fontSize = 7.sp, color = Zinc400)
                    Text("23:59 WIB", fontFamily = FontFamily.Monospace, fontSize = 7.sp, color = Zinc400)
                }
            }

            // Shift Compliance Rate Card
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Zinc50, RoundedCornerShape(2.dp))
                    .border(BorderStroke(1.dp, Zinc200), RoundedCornerShape(2.dp))
                    .padding(10.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "SHIFT COMPLIANCE RATE",
                        fontFamily = FontFamily.Monospace,
                        fontSize = 8.sp,
                        color = Zinc400,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "94.2%",
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
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
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            SectionTitleHeader("02. RUTE, JARAK & EFISIENSI LOKASI")

            // Jarak Tempuh Progress Bars
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, RoundedCornerShape(2.dp))
                    .border(BorderStroke(1.dp, Zinc200), RoundedCornerShape(2.dp))
                    .padding(10.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "DISTRIBUSI JARAK TEMPUH (KM)",
                    fontFamily = FontFamily.Monospace,
                    fontSize = 8.sp,
                    color = Zinc400,
                    fontWeight = FontWeight.Bold
                )

                DistanceBarRow("Jarak Pendek (< 5 KM)", "55%", 0.55f, Slate950)
                DistanceBarRow("Jarak Menengah (5 - 15 KM)", "35%", 0.35f, Zinc600)
                DistanceBarRow("Jarak Jauh (> 15 KM)", "10%", 0.10f, Zinc400)
            }

            // Coverage Area Bar
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, RoundedCornerShape(2.dp))
                    .border(BorderStroke(1.dp, Zinc200), RoundedCornerShape(2.dp))
                    .padding(10.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "KONSENTRASI RUTE OPERASIONAL",
                    fontFamily = FontFamily.Monospace,
                    fontSize = 8.sp,
                    color = Zinc400,
                    fontWeight = FontWeight.Bold
                )

                // Segmented Bar
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(10.dp)
                        .background(Zinc100, RoundedCornerShape(1.dp))
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

                Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    regionalDist.forEach { dist ->
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Box(modifier = Modifier.size(6.dp).background(dist.color))
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = dist.region,
                                    fontSize = 10.sp,
                                    color = Zinc600
                                )
                            }
                            Text(
                                text = dist.percentage,
                                fontFamily = FontFamily.Monospace,
                                fontWeight = FontWeight.Bold,
                                fontSize = 9.sp,
                                color = Slate950
                            )
                        }
                    }
                }
            }
        }

        // ─── SECTION 5: WIDGET 3 - LAPORAN KENDALA & RISIKO ───
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            SectionTitleHeader("03. LAPORAN KENDALA & MANAJEMEN RISIKO")

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                // Bar Chart Insiden (7 Hari)
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .background(Color.White, RoundedCornerShape(2.dp))
                        .border(BorderStroke(1.dp, Zinc200), RoundedCornerShape(2.dp))
                        .padding(10.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "INSIDEN (7 HARI)",
                        fontFamily = FontFamily.Monospace,
                        fontSize = 8.sp,
                        color = Zinc400,
                        fontWeight = FontWeight.Bold
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp),
                        horizontalArrangement = Arrangement.spacedBy(4.dp),
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
                                    fontFamily = FontFamily.Monospace,
                                    fontSize = 7.sp,
                                    color = Zinc400
                                )
                                Spacer(modifier = Modifier.height(2.dp))
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(if (count == 0) 2.dp else (count * 15).dp)
                                        .background(if (count > 2) Color(0xFFE11D48) else Slate950)
                                )
                                Spacer(modifier = Modifier.height(2.dp))
                                Text(
                                    text = daysList[idx],
                                    fontFamily = FontFamily.Monospace,
                                    fontSize = 7.sp,
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
                        .background(Color.White, RoundedCornerShape(2.dp))
                        .border(BorderStroke(1.dp, Zinc200), RoundedCornerShape(2.dp))
                        .padding(10.dp),
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Text(
                        text = "PENYEBAB RETUR",
                        fontFamily = FontFamily.Monospace,
                        fontSize = 8.sp,
                        color = Zinc400,
                        fontWeight = FontWeight.Bold
                    )

                    issueBreakdown.forEach { issue ->
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = issue.type,
                                fontSize = 8.sp,
                                color = Zinc600,
                                modifier = Modifier.weight(1f),
                                maxLines = 1
                            )
                            Text(
                                text = "${issue.count} (${issue.share})",
                                fontFamily = FontFamily.Monospace,
                                fontWeight = FontWeight.Bold,
                                fontSize = 8.sp,
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

// ─── REUSABLE HELPERS ───
@Composable
private fun SectionTitleHeader(title: String) {
    Text(
        text = title,
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Bold,
        fontSize = 9.sp,
        color = Zinc400,
        letterSpacing = 1.sp
    )
}

@Composable
private fun DetailTextRow(label: String, value: String, valueColor: Color) {
    Column {
        Text(text = label, fontFamily = FontFamily.Monospace, fontSize = 7.sp, color = Zinc400)
        Text(text = value, fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold, fontSize = 9.sp, color = valueColor)
    }
}

@Composable
private fun DistanceBarRow(label: String, percentageText: String, fraction: Float, barColor: Color) {
    Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(label, fontSize = 9.sp, color = Zinc600)
            Text(percentageText, fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold, fontSize = 9.sp, color = Slate950)
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
                    .fillMaxWidth(fraction = fraction)
                    .background(barColor, RoundedCornerShape(1.dp))
            )
        }
    }
}