package com.example.burungkurirapp.ui.page.GeneralReusable.NavHeader

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.burungkurirapp.statis.icons.HeroiconsBell

// ─── COLOR PALETTE (Zinc, Slate, Monochromatic Accent) ───
private val Zinc100 = Color(0xFFF4F4F5)
private val Zinc200 = Color(0xFFE4E4E7)
private val Zinc400 = Color(0xFFA1A1AA)
private val Zinc600 = Color(0xFF52525B)
private val Zinc950 = Color(0xFF09090B)
private val Slate950 = Color(0xFF020617)
private val Emerald500 = Color(0xFF10B981)

class NavHeader

@Composable
fun NavHeader.Element(
    namaKurir: String = "Budi Pratama",
    idKurir: String = "KR-082",
    tipeKendaraan: String = "MOTOR",
    isOnline: Boolean = true,
    onStatusToggle: () -> Unit = {},
    onNotificationClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .border(BorderStroke(1.dp, Zinc100))
    ) {
        // Safe Inset Handling untuk Status Bar (Bebas tabrakan notch/hole)
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .windowInsetsTopHeight(WindowInsets.statusBars)
        )

        // Header Content Area
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp)
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // ─── LEFT: AVATAR BULAT + IDENTITAS KURIR ───
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f)
            ) {
                // Avatar Bulat + Indicator Dot Status
                Box(contentAlignment = Alignment.BottomEnd) {
                    Box(
                        modifier = Modifier
                            .size(36.dp)
                            .clip(CircleShape)
                            .background(Zinc950)
                            .border(BorderStroke(1.dp, Zinc200), CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = namaKurir.take(2).uppercase(),
                            fontFamily = FontFamily.Monospace,
                            fontWeight = FontWeight.Bold,
                            fontSize = 11.sp,
                            color = Color.White
                        )
                    }

                    // Dot Indicator Status Operasional
                    Box(
                        modifier = Modifier
                            .size(10.dp)
                            .clip(CircleShape)
                            .background(if (isOnline) Emerald500 else Zinc400)
                            .border(BorderStroke(1.5.dp, Color.White), CircleShape)
                    )
                }

                Spacer(modifier = Modifier.width(10.dp))

                // Name & Metadata
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxHeight()
                ) {
                    Text(
                        text = namaKurir,
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        color = Slate950,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )

                    Spacer(modifier = Modifier.height(1.dp))

                    Text(
                        text = "$tipeKendaraan • #$idKurir",
                        fontFamily = FontFamily.Monospace,
                        fontSize = 9.sp,
                        color = Zinc400,
                        maxLines = 1
                    )
                }
            }

            Spacer(modifier = Modifier.width(12.dp))

            // ─── RIGHT: SHIFT MODE TOGGLE & NOTIFIKASI ORDER ───
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                // Badge Status Shift / Mode Bid
                Box(
                    modifier = Modifier
                        .background(
                            color = if (isOnline) Zinc950 else Zinc100,
                            shape = RoundedCornerShape(2.dp)
                        )
                        .border(
                            BorderStroke(1.dp, if (isOnline) Zinc950 else Zinc200),
                            shape = RoundedCornerShape(2.dp)
                        )
                        .clickable { onStatusToggle() }
                        .padding(horizontal = 8.dp, vertical = 5.dp)
                ) {
                    Text(
                        text = if (isOnline) "SIAP BID" else "OFFLINE",
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Bold,
                        fontSize = 9.sp,
                        color = if (isOnline) Color.White else Zinc600,
                        letterSpacing = 0.5.sp
                    )
                }

                // Bell Alert Order Masuk
                Box(
                    modifier = Modifier
                        .size(32.dp)
                        .border(BorderStroke(1.dp, Zinc200), RoundedCornerShape(2.dp))
                        .clickable { onNotificationClick() },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = HeroiconsBell,
                        contentDescription = "Alert Order",
                        tint = Zinc950,
                        modifier = Modifier.size(15.dp)
                    )
                }
            }
        }
    }
}