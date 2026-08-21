package com.example.burungkurirapp.ui.section.Home.page.Home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
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
import com.example.burungkurirapp.ui.constant.color.Zinc800
import com.example.burungkurirapp.ui.constant.color.Zinc900
import com.example.burungkurirapp.ui.constant.color.Zinc950
import com.example.burungkurirapp.ui.constant.prefix.TugasSectionPrefix
import com.example.burungkurirapp.ui.section.LocalUiFlowState
import com.example.burungkurirapp.ui.section.Tugas.page.DaftarBid.component.ActiveDeliveryCard
import com.example.burungkurirapp.ui.section.Tugas.page.DaftarBid.component.AvailableOrderCard
import com.example.burungkurirapp.ui.section.rememberUiFlowState

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
            fontFamily = FontFamily.SansSerif,
            fontSize = 11.sp,
            color = Zinc500,
            fontWeight = FontWeight.Medium
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = value,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            fontSize = 13.sp,
            color = Slate950
        )
    }
}




@Composable
fun TugasDaftarBidPage() {
    CompositionLocalProvider(LocalUiFlowState provides rememberUiFlowState()) {
        val state = LocalUiFlowState.current
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
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(vertical = 16.dp)
        ) {
            // 1. GREETING & RINGKASAN PENDAPATAN HARIAN
            item {
                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(
                                text = "SELAMAT DATANG,",
                                fontFamily = FontFamily.SansSerif,
                                fontSize = 11.sp,
                                color = Zinc400,
                                letterSpacing = 1.sp
                            )
                            Text(
                                text = "Faiz",
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                color = Slate950,
                                fontFamily = FontFamily.SansSerif
                            )
                        }

                        // Badge Shift Status
                        Box(
                            modifier = Modifier
                                .background(Zinc950, RoundedCornerShape(4.dp))
                                .padding(horizontal = 10.dp, vertical = 6.dp)
                        ) {
                            Text(
                                text = "BID: AKTIF",
                                fontFamily = FontFamily.SansSerif,
                                fontWeight = FontWeight.Bold,
                                fontSize = 11.sp,
                                color = Color.White
                            )
                        }
                    }

                    // Card Ringkasan Pendapatan
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Zinc50, RoundedCornerShape(8.dp))
                            .border(BorderStroke(1.dp, Zinc200), RoundedCornerShape(8.dp))
                            .padding(16.dp)
                    ) {
                        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "PENDAPATAN HARI INI",
                                    fontFamily = FontFamily.SansSerif,
                                    fontSize = 11.sp,
                                    color = Zinc500,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = "21 AGU 2026",
                                    fontFamily = FontFamily.SansSerif,
                                    fontSize = 11.sp,
                                    color = Zinc400
                                )
                            }

                            Text(
                                text = "Rp 185.000",
                                fontFamily = FontFamily.SansSerif,
                                fontWeight = FontWeight.Bold,
                                fontSize = 24.sp,
                                color = Slate950
                            )

                            // Metric Trio Grid
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .border(BorderStroke(1.dp, Zinc200), RoundedCornerShape(6.dp))
                                    .background(Color.White)
                                    .padding(vertical = 10.dp, horizontal = 6.dp),
                                horizontalArrangement = Arrangement.SpaceEvenly,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                MetricItem(label = "TERKIRIM", value = "8 Order")
                                Box(
                                    modifier = Modifier
                                        .width(1.dp)
                                        .height(24.dp)
                                        .background(Zinc200)
                                )
                                MetricItem(label = "RATING", value = "4.9 ★")
                                Box(
                                    modifier = Modifier
                                        .width(1.dp)
                                        .height(24.dp)
                                        .background(Zinc200)
                                )
                                MetricItem(label = "ACCEPTANCE", value = "98%")
                            }
                        }
                    }
                }
            }

            // 2. TUGAS AKTIF / SEDANG DIKIRIM
            item {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(
                        text = "TUGAS BERJALAN (1)",
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        color = Zinc900,
                        letterSpacing = 1.sp
                    )

                    ActiveDeliveryCard(fun() {
                        state.navController.navigate("$TugasSectionPrefix/Pengiriman")
                    })
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
                        text = "DAFTAR PENGIRIMAN (${incomingOrders.size})",
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        color = Zinc900,
                        letterSpacing = 1.sp
                    )
                    Text(
                        text = "AUTO-REFRESH",
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 11.sp,
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
}

@Preview
@Composable
private fun PrevTugasDaftarBidPage() {
    TugasDaftarBidPage()
}