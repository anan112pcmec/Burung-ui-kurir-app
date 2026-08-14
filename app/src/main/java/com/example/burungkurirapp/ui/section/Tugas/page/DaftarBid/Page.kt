package com.example.burungkurirapp.ui.section.Home.page.Home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.burungkurirapp.statis.icons.FontAwesomeMotorcycle
import com.example.burungkurirapp.statis.icons.MaterialIconsApps
import com.example.burungkurirapp.statis.icons.MaterialIconsLocationPin
import com.example.burungkurirapp.statis.icons.VscodeCodiconsArrowRight
import com.example.burungkurirapp.ui.constant.color.Slate950
import com.example.burungkurirapp.ui.constant.color.Teal400
import com.example.burungkurirapp.ui.constant.color.Zinc100
import com.example.burungkurirapp.ui.constant.color.Zinc200
import com.example.burungkurirapp.ui.constant.color.Zinc400
import com.example.burungkurirapp.ui.constant.color.Zinc50
import com.example.burungkurirapp.ui.constant.color.Zinc500
import com.example.burungkurirapp.ui.constant.color.Zinc600
import com.example.burungkurirapp.ui.constant.color.Zinc900
import com.example.burungkurirapp.ui.constant.color.Zinc950


data class OrderDelivery(
    val idOrder: String,
    val toko: String,
    val alamatPickup: String,
    val penerima: String,
    val alamatDrop: String,
    val jarak: String,
    val ongkir: String,
    val tipeItem: String
)
@Composable
private fun MetricItem(label: String, value: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = label,
            fontFamily = FontFamily.Monospace,
            fontSize = 8.sp,
            color = Zinc400
        )
        Text(
            text = value,
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.Bold,
            fontSize = 10.sp,
            color = Slate950
        )
    }
}

@Composable
private fun ActiveDeliveryCard() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(2.dp))
            .border(BorderStroke(1.dp, Slate950), RoundedCornerShape(2.dp))
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .background(Teal400, RoundedCornerShape(2.dp))
                        .padding(horizontal = 6.dp, vertical = 2.dp)
                ) {
                    Text(
                        text = "SEDANG DIKIRIM",
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Bold,
                        fontSize = 8.sp,
                        color = Color.White
                    )
                }
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = "#TRX-89190",
                    fontFamily = FontFamily.Monospace,
                    fontSize = 10.sp,
                    color = Zinc500
                )
            }

            Text(
                text = "Rp 22.000",
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = Slate950
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Zinc100)
        )

        // Route Details
        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = FontAwesomeMotorcycle,
                    contentDescription = null,
                    tint = Zinc400,
                    modifier = Modifier.size(12.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = "AMBIL: Toko Garasi Bekas (Kopo)",
                    fontSize = 11.sp,
                    color = Zinc600,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = MaterialIconsLocationPin,
                    contentDescription = null,
                    tint = Slate950,
                    modifier = Modifier.size(12.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = "ANTAR: Rian Hidayat (Antapani)",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = Slate950,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }

        // Action Button
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Slate950, RoundedCornerShape(2.dp))
                .clickable { }
                .padding(vertical = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "UPDATE STATUS PENGIRIMAN",
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.Bold,
                    fontSize = 10.sp,
                    color = Color.White
                )
                Spacer(modifier = Modifier.width(6.dp))
                Icon(
                    imageVector = VscodeCodiconsArrowRight,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(12.dp)
                )
            }
        }
    }
}

@Composable
private fun AvailableOrderCard(order: OrderDelivery) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(2.dp))
            .border(BorderStroke(1.dp, Zinc200), RoundedCornerShape(2.dp))
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "#${order.idOrder}",
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.Bold,
                    fontSize = 10.sp,
                    color = Slate950
                )
                Spacer(modifier = Modifier.width(6.dp))
                Box(
                    modifier = Modifier
                        .background(Zinc100, RoundedCornerShape(2.dp))
                        .border(BorderStroke(1.dp, Zinc200), RoundedCornerShape(2.dp))
                        .padding(horizontal = 4.dp, vertical = 1.dp)
                ) {
                    Text(
                        text = order.tipeItem.uppercase(),
                        fontFamily = FontFamily.Monospace,
                        fontSize = 8.sp,
                        color = Zinc600
                    )
                }
            }

            Text(
                text = order.ongkir,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = Slate950
            )
        }

        // Address Section
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Zinc50, RoundedCornerShape(2.dp))
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = "PICKUP: ${order.toko} - ${order.alamatPickup}",
                fontSize = 10.sp,
                color = Zinc600,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "DROP: ${order.penerima} - ${order.alamatDrop}",
                fontSize = 10.sp,
                fontWeight = FontWeight.SemiBold,
                color = Slate950,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }

        // Footer Actions
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = MaterialIconsApps,
                    contentDescription = null,
                    tint = Zinc400,
                    modifier = Modifier.size(12.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "JARAK: ${order.jarak}",
                    fontFamily = FontFamily.Monospace,
                    fontSize = 9.sp,
                    color = Zinc500
                )
            }

            Box(
                modifier = Modifier
                    .border(BorderStroke(1.dp, Slate950), RoundedCornerShape(2.dp))
                    .background(Color.White)
                    .clickable { }
                    .padding(horizontal = 10.dp, vertical = 5.dp)
            ) {
                Text(
                    text = "AMBIL ORDER",
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.Bold,
                    fontSize = 9.sp,
                    color = Slate950
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DaftarBidPage(
    namaKurir: String = "Faiz",
    modifier: Modifier = Modifier
) {
    val incomingOrders = remember {
        listOf(
            OrderDelivery(
                idOrder = "TRX-89201",
                toko = "Mekar Jaya Tech",
                alamatPickup = "Jl. Mangga Dua No. 12, Jakbar",
                penerima = "Budi Santoso",
                alamatDrop = "Jl. Kebon Jeruk Raya No. 45",
                jarak = "3.2 KM",
                ongkir = "Rp 18.000",
                tipeItem = "Elektronik (Kecil)"
            ),
            OrderDelivery(
                idOrder = "TRX-89205",
                toko = "Avian Petstore",
                alamatPickup = "Ruko Green Lake Block C/8",
                penerima = "Deni Kurnia",
                alamatDrop = "Komplek Daan Mogot Baru",
                jarak = "5.8 KM",
                ongkir = "Rp 26.000",
                tipeItem = "Kandang & Pakan"
            ),
            OrderDelivery(
                idOrder = "TRX-89212",
                toko = "Dapur Kreatif",
                alamatPickup = "Jl. Tanjung Duren Barat No. 3",
                penerima = "Siska Amelia",
                alamatDrop = "Apartemen Mediterania Tower 2",
                jarak = "1.5 KM",
                ongkir = "Rp 12.000",
                tipeItem = "Peralatan Rumah"
            )
        )
    }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp),
        contentPadding = PaddingValues(vertical = 14.dp)
    ) {
        // 1. GREETING & RINGKASAN PENDAPATAN HARIAN
        item {
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "SELAMAT DATANG,",
                            fontFamily = FontFamily.Monospace,
                            fontSize = 9.sp,
                            color = Zinc400,
                            letterSpacing = 1.sp
                        )
                        Text(
                            text = namaKurir.uppercase(),
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            color = Slate950,
                            fontFamily = FontFamily.Monospace
                        )
                    }

                    // Badge Shift Status
                    Box(
                        modifier = Modifier
                            .background(Zinc950, RoundedCornerShape(2.dp))
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                    ) {
                        Text(
                            text = "BID: AKTIF",
                            fontFamily = FontFamily.Monospace,
                            fontWeight = FontWeight.Bold,
                            fontSize = 9.sp,
                            color = Color.White
                        )
                    }
                }

                // Card Ringkasan Pendapatan
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Zinc50, RoundedCornerShape(2.dp))
                        .border(BorderStroke(1.dp, Zinc200), RoundedCornerShape(2.dp))
                        .padding(12.dp)
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "PENDAPATAN HARI INI",
                                fontFamily = FontFamily.Monospace,
                                fontSize = 9.sp,
                                color = Zinc500,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "7 AGU 2026",
                                fontFamily = FontFamily.Monospace,
                                fontSize = 9.sp,
                                color = Zinc400
                            )
                        }

                        Text(
                            text = "Rp 185.000",
                            fontFamily = FontFamily.Monospace,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            color = Slate950
                        )

                        Spacer(modifier = Modifier.height(2.dp))

                        // Metric Trio Grid
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .border(BorderStroke(0.5.dp, Zinc200), RoundedCornerShape(2.dp))
                                .background(Color.White)
                                .padding(8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            MetricItem(label = "TERKIRIM", value = "8 Order")
                            Box(modifier = Modifier.width(1.dp).height(20.dp).background(Zinc200))
                            MetricItem(label = "RATING", value = "4.9 ★")
                            Box(modifier = Modifier.width(1.dp).height(20.dp).background(Zinc200))
                            MetricItem(label = "ACCEPTANCE", value = "98%")
                        }
                    }
                }
            }
        }

        // 2. TUGAS AKTIF / SEDANG DIKIRIM (IF ANY)
        item {
            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Text(
                    text = "TUGAS BERJALAN (1)",
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.Bold,
                    fontSize = 10.sp,
                    color = Zinc900,
                    letterSpacing = 1.sp
                )

                ActiveDeliveryCard()
            }
        }

        // 3. DAFTAR ORDERAN MASUK / SIAP BID
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Daftar Pengiriman (${incomingOrders.size})",
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.Bold,
                    fontSize = 10.sp,
                    color = Zinc900,
                    letterSpacing = 1.sp
                )
                Text(
                    text = "AUTO-REFRESH",
                    fontFamily = FontFamily.Monospace,
                    fontSize = 9.sp,
                    color = Teal400,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        // List Incoming Items
        items(incomingOrders, key = { it.idOrder }) { order ->
            AvailableOrderCard(order = order)
        }
    }
}
