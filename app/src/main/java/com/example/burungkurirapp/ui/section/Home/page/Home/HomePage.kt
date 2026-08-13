package com.example.burungkurirapp.ui.section.Home.page.Home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.burungkurirapp.ui.constant.color.*
import com.example.burungkurirapp.ui.section.Home.page.Home.component.PanelTugasOperasionalSection

// ─── HELPER MAPPING ARTI RATING ───
private fun getRatingLabel(rating: Float): String {
    return when (rating.toInt()) {
        1 -> "Kurang"
        2 -> "Perlu Peningkatan"
        3 -> "Standar"
        4 -> "Baik"
        5 -> "Excellent"
        else -> "Standar"
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomePage() {
    // Mock Data dari Kurir Struct GORM
    val nama = "Faiz Hannan Hakim"
    val username = "@faizhannan"
    val email = "faiz.hannan@mail.com"
    val jenisLayanan = "Reguler"
    val deskripsi = "Driver motor berpengalaman, siap antar paket cepat, aman, dan tepat waktu."
    val statusKurir = "Online"
    val statusBid = "On"
    val isVerified = true
    val ratingKurir = 4.8f
    val tipeKendaraan = "Motor"

    // 1. Buat state scroll
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(12.dp)
            // 2. Tambahkan verticalScroll dengan state-nya di sini
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // ─── TOP SECTION (WEIGHT 0.4F) ───
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {
            // 1. COLUMN PROFIL KURIR
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = nama.uppercase(),
                            fontFamily = FontFamily.Monospace,
                            fontWeight = FontWeight.Bold,
                            fontSize = 12.sp,
                            color = Slate950,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.weight(1f, fill = false)
                        )
                        if (isVerified) {
                            Spacer(modifier = Modifier.width(4.dp))
                            Icon(
                                imageVector = Icons.Default.CheckCircle,
                                contentDescription = "Verified",
                                tint = Teal600,
                                modifier = Modifier.size(12.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "$username • $email",
                        fontFamily = FontFamily.Monospace,
                        fontSize = 8.sp,
                        color = Zinc400,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "$tipeKendaraan • LAYANAN $jenisLayanan",
                        fontFamily = FontFamily.Monospace,
                        fontSize = 8.sp,
                        fontWeight = FontWeight.Bold,
                        color = Zinc600,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                // Deskripsi Kurir
                Text(
                    text = "\"$deskripsi\"",
                    fontFamily = FontFamily.Monospace,
                    fontSize = 8.sp,
                    color = Zinc500,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    lineHeight = 7.sp
                )

                // Badges Status Kurir & Bid
                Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                    Box(
                        modifier = Modifier
                            .background(if (statusKurir == "Online") Teal600 else Zinc400, RoundedCornerShape(2.dp))
                            .padding(horizontal = 4.dp, vertical = 2.dp)
                    ) {
                        Text(
                            text = "STATUS: ${statusKurir.uppercase()}",
                            fontFamily = FontFamily.Monospace,
                            fontWeight = FontWeight.Bold,
                            fontSize = 7.sp,
                            color = Color.White
                        )
                    }

                    Box(
                        modifier = Modifier
                            .background(Slate950, RoundedCornerShape(2.dp))
                            .padding(horizontal = 4.dp, vertical = 2.dp)
                    ) {
                        Text(
                            text = "BID: ${statusBid.uppercase()}",
                            fontFamily = FontFamily.Monospace,
                            fontWeight = FontWeight.Bold,
                            fontSize = 7.sp,
                            color = Color.White
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.width(8.dp))

            // 2. ROW RATING KURIR
            Row(
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalAlignment = Alignment.Top
            ) {
                Box(
                    modifier = Modifier
                        .background(Color.White, RoundedCornerShape(2.dp))
                        .border(BorderStroke(1.dp, Slate950), RoundedCornerShape(2.dp))
                        .padding(horizontal = 6.dp, vertical = 4.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "Rating",
                            tint = Teal600,
                            modifier = Modifier.size(12.dp)
                        )
                        Spacer(modifier = Modifier.width(3.dp))
                        Text(
                            text = ratingKurir.toString(),
                            fontFamily = FontFamily.Monospace,
                            fontWeight = FontWeight.Bold,
                            fontSize = 10.sp,
                            color = Slate950
                        )
                    }
                }

                Box(
                    modifier = Modifier
                        .background(Slate950, RoundedCornerShape(2.dp))
                        .padding(horizontal = 6.dp, vertical = 4.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = getRatingLabel(ratingKurir).uppercase(),
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Bold,
                        fontSize = 8.sp,
                        color = Color.White
                    )
                }
            }
        }

        // ─── BOTTOM SECTION ───
        PanelTugasOperasionalSection()
    }
}