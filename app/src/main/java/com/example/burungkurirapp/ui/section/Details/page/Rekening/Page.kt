package com.example.burungkurirapp.ui.section.Details.page.Rekening

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.burungkurirapp.ui.constant.color.Slate950
import com.example.burungkurirapp.ui.constant.color.Zinc100
import com.example.burungkurirapp.ui.constant.color.Zinc300
import com.example.burungkurirapp.ui.constant.color.Zinc600
import com.example.burungkurirapp.ui.constant.types.Pengiriman
import com.example.burungkurirapp.ui.constant.types.RekeningKurir
import java.text.NumberFormat
import java.util.Locale

@Composable
fun DetailsRekeningPage(
    data: RekeningKurir,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Header & Bank Account Card
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            colors = CardDefaults.cardColors(containerColor = Slate950)
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = data.NamaBank.uppercase(),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = Color.White.copy(alpha = 0.15f)
                    ) {
                        Text(
                            text = "Rekening Utama",
                            color = Color.White,
                            fontSize = 11.sp,
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = data.NomorRekening,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Monospace,
                    color = Color.White
                )

                Text(
                    text = "a.n ${data.PemilikRekening}",
                    fontSize = 13.sp,
                    color = Zinc300
                )
            }
        }

        // Section: Visual Chart Pemasukan (Pie Chart Canvas)
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            colors = CardDefaults.cardColors(containerColor = Zinc100)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "Ringkasan Alokasi Keuangan",
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    color = Slate950
                )
                HorizontalDivider(color = Zinc300)

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    // Pie Chart Component
                    PemasukanPieChart(
                        pemasukan = data.PemasukanTotal,
                        pending = data.PendingDisbursmentAmount,
                        gagal = (data.DisbursmentGagalCount * 50000).toLong() // Nilai estimasi nominal gagal
                    )

                    // Pie Chart Legend
                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        ChartLegendItem(
                            color = Color(0xFF16A34A),
                            label = "Pemasukan",
                            value = formatRupiah(data.PemasukanTotal)
                        )
                        ChartLegendItem(
                            color = Color(0xFFEAB308),
                            label = "Pending",
                            value = formatRupiah(data.PendingDisbursmentAmount)
                        )
                        ChartLegendItem(
                            color = Color(0xFFDC2626),
                            label = "Gagal Disburs",
                            value = "${data.DisbursmentGagalCount} Transaksi"
                        )
                    }
                }
            }
        }

        // Section: Statistik Berdasarkan Periode
        Column(
            modifier = Modifier.padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "Statistik Pendapatan Periode",
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                color = Slate950
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                StatCard(
                    title = "Hari Ini",
                    nominal = formatRupiah(data.PemasukanTotalHariIni),
                    count = "${data.PengirimanDisbursmentCountHariIni} Selesai",
                    modifier = Modifier.weight(1f)
                )
                StatCard(
                    title = "Minggu Ini",
                    nominal = formatRupiah(data.PemasukanTotalMingguIni),
                    count = "${data.PengirimanDisbursmentCountMingguIni} Selesai",
                    modifier = Modifier.weight(1f)
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                StatCard(
                    title = "Bulan Ini",
                    nominal = formatRupiah(data.PemasukanTotalBulanIni),
                    count = "${data.PengirimanDisbursmentCountBulanIni} Selesai",
                    modifier = Modifier.weight(1f)
                )
                StatCard(
                    title = "Tahun Ini",
                    nominal = formatRupiah(data.PemasukanTotalTahunIni),
                    count = "${data.PengirimanDisbursmentCountTahunIni} Selesai",
                    modifier = Modifier.weight(1f)
                )
            }
        }

        // Section: Carousel Slider List Pengiriman Terkait Rekening
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Pengiriman Terkait Rekening",
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    color = Slate950
                )
                Text(
                    text = "${data.listPengirimanTerkaitRek.size} Total",
                    fontSize = 12.sp,
                    color = Zinc600
                )
            }

            if (data.listPengirimanTerkaitRek.isNotEmpty()) {
                val pagerState = rememberPagerState(pageCount = { data.listPengirimanTerkaitRek.size })

                HorizontalPager(
                    state = pagerState,
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    pageSpacing = 12.dp,
                    modifier = Modifier.fillMaxWidth()
                ) { page ->
                    val pengirimanItem = data.listPengirimanTerkaitRek[page]
                    PengirimanCarouselCard(item = pengirimanItem)
                }
            } else {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .height(100.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(Zinc100),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Belum ada riwayat pengiriman terkait",
                        fontSize = 13.sp,
                        color = Zinc600
                    )
                }
            }
        }
    }
}

@Composable
private fun PemasukanPieChart(
    pemasukan: Long,
    pending: Long,
    gagal: Long
) {
    val total = (pemasukan + pending + gagal).coerceAtLeast(1L).toFloat()
    val sweepPemasukan = (pemasukan.toFloat() / total) * 360f
    val sweepPending = (pending.toFloat() / total) * 360f
    val sweepGagal = (gagal.toFloat() / total) * 360f

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.size(130.dp)
    ) {
        Canvas(modifier = Modifier.size(120.dp)) {
            var startAngle = -90f

            // Arc Pemasukan (Green)
            drawArc(
                color = Color(0xFF16A34A),
                startAngle = startAngle,
                sweepAngle = if (sweepPemasukan == 0f) 0.1f else sweepPemasukan,
                useCenter = false,
                style = Stroke(width = 24.dp.toPx(), cap = StrokeCap.Butt)
            )
            startAngle += sweepPemasukan

            // Arc Pending (Yellow)
            drawArc(
                color = Color(0xFFEAB308),
                startAngle = startAngle,
                sweepAngle = if (sweepPending == 0f) 0.1f else sweepPending,
                useCenter = false,
                style = Stroke(width = 24.dp.toPx(), cap = StrokeCap.Butt)
            )
            startAngle += sweepPending

            // Arc Gagal (Red)
            drawArc(
                color = Color(0xFFDC2626),
                startAngle = startAngle,
                sweepAngle = if (sweepGagal == 0f) 0.1f else sweepGagal,
                useCenter = false,
                style = Stroke(width = 24.dp.toPx(), cap = StrokeCap.Butt)
            )
        }
    }
}

@Composable
private fun ChartLegendItem(color: Color, label: String, value: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Box(
            modifier = Modifier
                .size(10.dp)
                .clip(CircleShape)
                .background(color)
        )
        Column {
            Text(text = label, fontSize = 11.sp, color = Zinc600)
            Text(text = value, fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Slate950)
        }
    }
}

@Composable
private fun StatCard(
    title: String,
    nominal: String,
    count: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = Zinc100)
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(text = title, fontSize = 12.sp, color = Zinc600)
            Text(text = nominal, fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Slate950)
            Text(text = count, fontSize = 11.sp, fontWeight = FontWeight.Medium, color = Color(0xFF16A34A))
        }
    }
}

@Composable
private fun PengirimanCarouselCard(item: Pengiriman) {
    Card(
        modifier = Modifier
            .width(280.dp)
            .height(130.dp),
        colors = CardDefaults.cardColors(containerColor = Zinc100)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(14.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "ID: #${item.Id}",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Slate950
                )
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = Slate950
                ) {
                    Text(
                        text = item.Status,
                        color = Color.White,
                        fontSize = 10.sp,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                    )
                }
            }

            Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                Text(
                    text = "Asal: ${item.AlamatGudang?.NamaAlamat ?: "-"}",
                    fontSize = 11.sp,
                    color = Zinc600,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "Tujuan: ${item.AlamatPengguna?.NamaAlamat ?: "-"}",
                    fontSize = 11.sp,
                    color = Zinc600,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            HorizontalDivider(color = Zinc300)

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Ongkir/Ongkos", fontSize = 11.sp, color = Zinc600)
                Text(
                    text = formatRupiah(item.KurirPaid.toLongOrNull() ?: 0L),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF16A34A)
                )
            }
        }
    }
}
private fun formatRupiah(amount: Long): String {
    val formatter = NumberFormat.getCurrencyInstance(Locale("id", "ID"))
    return formatter.format(amount).replace(",00", "")
}

@Preview(showBackground = true)
@Composable
private fun PrevDetailsRekeningPage() {
    val sampleData = RekeningKurir(
        Id = 1L,
        IdKurir = 10L,
        Kurir = null,
        NamaBank = "Bank Central Asia (BCA)",
        NomorRekening = "8830192831",
        PemilikRekening = "Budi Santoso",
        CreatedAt = "2025-01-01",
        UpdatedAt = "2025-10-01",
        PengirimanDisbursmentCount = 120,
        PemasukanTotal = 4500000L,
        DisbursmentGagalCount = 2,
        PendingDisbursmentAmount = 350000L,
        PengirimanDisbursmentCountHariIni = 5,
        PemasukanTotalHariIni = 175000L,
        DisbursmentGagalCountHariIni = 0,
        PendingDisbursmentAmountHariIni = 50000L,
        PengirimanDisbursmentCountMingguIni = 28,
        PemasukanTotalMingguIni = 980000L,
        DisbursmentGagalCountMingguIni = 1,
        PendingDisbursmentAmountMingguIni = 100000L,
        PengirimanDisbursmentCountBulanIni = 85,
        PemasukanTotalBulanIni = 2950000L,
        DisbursmentGagalCountBulanIni = 1,
        PendingDisbursmentAmountBulanIni = 200000L,
        PengirimanDisbursmentCountTahunIni = 120,
        PemasukanTotalTahunIni = 4500000L,
        DisbursmentGagalCountTahunIni = 2,
        PendingDisbursmentAmountTahunIni = 350000L,
        listPengirimanTerkaitRek = listOf(
            Pengiriman(
                Id = 1,
                IdTransaksi = 1001,
                IdSeller = 501,
                IdAlamatGudang = 101,
                IdAlamatPengguna = 201,
                IdKurir = 10,
                BeratBarang = 1500,
                KendaraanRequired = "Motor",
                JenisPengiriman = "Instant",
                JarakTempuh = "4.5 km",
                KurirPaid = "15000",
                Status = "Selesai",
                CreatedAt = "2026-08-18 08:30:00",
                Transaksi = null,
                AlamatGudang = null,
                AlamatPengguna = null
            ),
            Pengiriman(
                Id = 2,
                IdTransaksi = 1002,
                IdSeller = 502,
                IdAlamatGudang = 102,
                IdAlamatPengguna = 202,
                IdKurir = 12,
                BeratBarang = 3200,
                KendaraanRequired = "Motor",
                JenisPengiriman = "SameDay",
                JarakTempuh = "8.2 km",
                KurirPaid = "25000",
                Status = "Proses",
                CreatedAt = "2026-08-18 09:15:00",
                Transaksi = null,
                AlamatGudang = null,
                AlamatPengguna = null
            ),
            Pengiriman(
                Id = 3,
                IdTransaksi = 1003,
                IdSeller = 501,
                IdAlamatGudang = 101,
                IdAlamatPengguna = 203,
                IdKurir = 15,
                BeratBarang = 8500,
                KendaraanRequired = "Mobil",
                JenisPengiriman = "Cargo",
                JarakTempuh = "14.1 km",
                KurirPaid = "65000",
                Status = "Pending",
                CreatedAt = "2026-08-18 10:00:00",
                Transaksi = null,
                AlamatGudang = null,
                AlamatPengguna = null
            ),
            Pengiriman(
                Id = 4,
                IdTransaksi = 1004,
                IdSeller = 503,
                IdAlamatGudang = 103,
                IdAlamatPengguna = 204,
                IdKurir = 10,
                BeratBarang = 500,
                KendaraanRequired = "Motor",
                JenisPengiriman = "Instant",
                JarakTempuh = "2.1 km",
                KurirPaid = "12000",
                Status = "Selesai",
                CreatedAt = "2026-08-18 10:45:00",
                Transaksi = null,
                AlamatGudang = null,
                AlamatPengguna = null
            ),
            Pengiriman(
                Id = 5,
                IdTransaksi = 1005,
                IdSeller = 504,
                IdAlamatGudang = 104,
                IdAlamatPengguna = 205,
                IdKurir = 18,
                BeratBarang = 12000,
                KendaraanRequired = "Mobil",
                JenisPengiriman = "Regular",
                JarakTempuh = "22.5 km",
                KurirPaid = "90000",
                Status = "Proses",
                CreatedAt = "2026-08-18 11:20:00",
                Transaksi = null,
                AlamatGudang = null,
                AlamatPengguna = null
            ),
            Pengiriman(
                Id = 6,
                IdTransaksi = 1006,
                IdSeller = 502,
                IdAlamatGudang = 102,
                IdAlamatPengguna = 206,
                IdKurir = 12,
                BeratBarang = 2100,
                KendaraanRequired = "Motor",
                JenisPengiriman = "SameDay",
                JarakTempuh = "6.0 km",
                KurirPaid = "20000",
                Status = "Selesai",
                CreatedAt = "2026-08-18 12:05:00",
                Transaksi = null,
                AlamatGudang = null,
                AlamatPengguna = null
            ),
            Pengiriman(
                Id = 7,
                IdTransaksi = 1007,
                IdSeller = 505,
                IdAlamatGudang = 105,
                IdAlamatPengguna = 207,
                IdKurir = 20,
                BeratBarang = 900,
                KendaraanRequired = "Motor",
                JenisPengiriman = "Instant",
                JarakTempuh = "3.3 km",
                KurirPaid = "14000",
                Status = "Pending",
                CreatedAt = "2026-08-18 13:00:00",
                Transaksi = null,
                AlamatGudang = null,
                AlamatPengguna = null
            ),
            Pengiriman(
                Id = 8,
                IdTransaksi = 1008,
                IdSeller = 501,
                IdAlamatGudang = 101,
                IdAlamatPengguna = 208,
                IdKurir = 15,
                BeratBarang = 4500,
                KendaraanRequired = "Motor",
                JenisPengiriman = "SameDay",
                JarakTempuh = "9.8 km",
                KurirPaid = "30000",
                Status = "Proses",
                CreatedAt = "2026-08-18 13:40:00",
                Transaksi = null,
                AlamatGudang = null,
                AlamatPengguna = null
            ),
            Pengiriman(
                Id = 9,
                IdTransaksi = 1009,
                IdSeller = 503,
                IdAlamatGudang = 103,
                IdAlamatPengguna = 209,
                IdKurir = 22,
                BeratBarang = 25000,
                KendaraanRequired = "Mobil",
                JenisPengiriman = "Cargo",
                JarakTempuh = "35.0 km",
                KurirPaid = "150000",
                Status = "Selesai",
                CreatedAt = "2026-08-18 14:15:00",
                Transaksi = null,
                AlamatGudang = null,
                AlamatPengguna = null
            ),
            Pengiriman(
                Id = 10,
                IdTransaksi = 1010,
                IdSeller = 504,
                IdAlamatGudang = 104,
                IdAlamatPengguna = 210,
                IdKurir = 10,
                BeratBarang = 1100,
                KendaraanRequired = "Motor",
                JenisPengiriman = "Instant",
                JarakTempuh = "5.2 km",
                KurirPaid = "17000",
                Status = "Pending",
                CreatedAt = "2026-08-18 15:00:00",
                Transaksi = null,
                AlamatGudang = null,
                AlamatPengguna = null
            )
        )
    )

    DetailsRekeningPage(data = sampleData)
}