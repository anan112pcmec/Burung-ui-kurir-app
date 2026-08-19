package com.example.burungkurirapp.ui.section.Home.page.Home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.burungkurirapp.ui.constant.color.Slate950
import com.example.burungkurirapp.ui.constant.color.Teal600
import com.example.burungkurirapp.ui.constant.color.Zinc100
import com.example.burungkurirapp.ui.constant.color.Zinc200
import com.example.burungkurirapp.ui.constant.color.Zinc500
import com.example.burungkurirapp.ui.constant.color.Zinc600
import com.example.burungkurirapp.ui.constant.color.Zinc700
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
    val nama: String = "Faiz Hannan Hakim"
    val username: String = "@faizhannan"
    val email: String = "faiz.hannan@mail.com"
    val jenisLayanan: String = "Reguler"
    val deskripsi: String = "Driver motor berpengalaman, siap antar paket cepat, aman, dan tepat waktu."
    val statusKurir: String = "Online"
    val statusBid: String = "On"
    val isVerified: Boolean = true
    val ratingKurir: Float = 4.8f
    val tipeKendaraan: String = "Motor"

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // ─── CARD PROFIL KURIR ───
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .border(BorderStroke(1.dp, Zinc200), RoundedCornerShape(8.dp))
                .padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            // Header: Nama, Verified Badge & Rating Chip
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = nama.uppercase(),
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        color = Slate950,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    if (isVerified) {
                        Spacer(modifier = Modifier.width(6.dp))
                        Icon(
                            imageVector = Icons.Default.CheckCircle,
                            contentDescription = "Verified",
                            tint = Teal600,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }

                // Rating Chip
                Surface(
                    shape = RoundedCornerShape(4.dp),
                    color = Slate950
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "Rating",
                            tint = Teal600,
                            modifier = Modifier.size(14.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "$ratingKurir (${getRatingLabel(ratingKurir)})",
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Bold,
                            fontSize = 11.sp,
                            color = Color.White
                        )
                    }
                }
            }

            // Metadata: Username, Email & Layanan
            Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                Text(
                    text = "$username • $email",
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 11.sp,
                    color = Zinc500
                )
                Text(
                    text = "$tipeKendaraan • LAYANAN ${jenisLayanan.uppercase()}",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 11.sp,
                    color = Zinc700
                )
            }

            // Deskripsi Kurir
            Text(
                text = "\"$deskripsi\"",
                fontFamily = FontFamily.SansSerif,
                fontStyle = FontStyle.Italic,
                fontSize = 12.sp,
                color = Zinc600,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            // Status Badges
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Surface(
                    shape = RoundedCornerShape(4.dp),
                    color = if (statusKurir == "Online") Color(0xFFECFDF5) else Zinc100,
                    border = BorderStroke(1.dp, if (statusKurir == "Online") Teal600 else Zinc200)
                ) {
                    Text(
                        text = "STATUS: ${statusKurir.uppercase()}",
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold,
                        fontSize = 10.sp,
                        color = if (statusKurir == "Online") Teal600 else Zinc600,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                    )
                }

                Surface(
                    shape = RoundedCornerShape(4.dp),
                    color = Slate950
                ) {
                    Text(
                        text = "BID: ${statusBid.uppercase()}",
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold,
                        fontSize = 10.sp,
                        color = Color.White,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                    )
                }
            }
        }

        // ─── BOTTOM SECTION ───
        PanelTugasOperasionalSection()
    }
}