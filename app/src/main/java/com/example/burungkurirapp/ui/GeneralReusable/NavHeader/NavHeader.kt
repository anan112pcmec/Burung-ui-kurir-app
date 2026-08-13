package com.example.burungkurirapp.ui.GeneralReusable.NavHeader

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.burungkurirapp.statis.icons.HeroiconsBell
import com.example.burungkurirapp.statis.icons.MaterialIconsChat
import com.example.burungkurirapp.ui.constant.color.Slate950
import com.example.burungkurirapp.ui.constant.color.Teal400
import com.example.burungkurirapp.ui.constant.color.Zinc100
import com.example.burungkurirapp.ui.constant.color.Zinc200
import com.example.burungkurirapp.ui.constant.color.Zinc400
import com.example.burungkurirapp.ui.constant.color.Zinc600
import com.example.burungkurirapp.ui.constant.color.Zinc950

// ─── COLOR PALETTE (Zinc, Slate, Monochromatic Accent) ───
//Page ini diberkan nama HomePage tidak seragam dengan yang lain karna HomePage ini memicu bentrok

@Preview(showBackground = true)
@Composable
fun NavHeaderPage(
    namaKurir: String = "Budi Pratama",
    idKurir: String = "KR-082",
    tipeKendaraan: String = "MOTOR",
    Rating: Short = 5,
    isOnline: Boolean = true,
    OpenSideBar: () -> Unit ={},
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
                modifier = Modifier
                    .weight(1f)
                    .clickable {
                        OpenSideBar();
                    }
                ,

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
                            .background(if (isOnline) Teal400 else Zinc400)
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

            Spacer(modifier = Modifier.width(6.dp))

            Column() {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(
                        onClick = {},
                        contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp),
                        modifier = Modifier.height(32.dp),
                        colors = ButtonDefaults.buttonColors(
                            Slate950,
                            Zinc100
                        )
                    )
                    {
                       Icon(Icons.Default.Star, "Star")
                    }

                    Icon(
                        imageVector = MaterialIconsChat,
                        contentDescription = "Chat",
                        tint = Slate950,
                        modifier = Modifier
                            .size(24.dp)
                            .clickable {}
                    )
                }
            }
        }
    }
}