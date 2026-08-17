package com.example.burungkurirapp.ui.GeneralReusable.NavHeader

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
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
import androidx.navigation.NavHostController
import com.example.burungkurirapp.statis.icons.HeroiconsBell
import com.example.burungkurirapp.statis.icons.MaterialIconsChat
import com.example.burungkurirapp.ui.constant.color.Slate950
import com.example.burungkurirapp.ui.constant.color.Teal400
import com.example.burungkurirapp.ui.constant.color.Zinc100
import com.example.burungkurirapp.ui.constant.color.Zinc200
import com.example.burungkurirapp.ui.constant.color.Zinc400
import com.example.burungkurirapp.ui.constant.color.Zinc600
import com.example.burungkurirapp.ui.constant.color.Zinc950
import com.example.burungkurirapp.ui.constant.prefix.AuthSectionPrefix
import com.example.burungkurirapp.ui.constant.prefix.HomeSectionPrefix
import com.example.burungkurirapp.ui.constant.prefix.LandingSectionPrefix
import com.example.burungkurirapp.ui.constant.prefix.TugasSectionPrefix

// ─── COLOR PALETTE (Zinc, Slate, Monochromatic Accent) ───
//Page ini diberkan nama HomePage tidak seragam dengan yang lain karna HomePage ini memicu bentrok

data class NavHeader( val namaKurir: String = "Budi Pratama",
                      val idKurir: String = "KR-082",
                      val tipeKendaraan: String = "MOTOR",
                      val Rating: Short = 5,
                      val isOnline: Boolean = true,
                      val onStatusToggle: () -> Unit = {},
                      val onNotificationClick: () -> Unit = {} )

@Composable
fun NavHeader.HomePage(OpenSideBar: () -> Unit ={}) {
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
                       Icon(
                           imageVector =Icons.Default.Star,
                           contentDescription = "Star",
                       modifier  = Modifier.size(24.dp))
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

@Composable
fun NavHeader.LandingPage(
    onLoginClick: () -> Unit = {},
    onHelpClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .border(BorderStroke(1.dp, Zinc100))
    ) {
        // Safe Inset Handling untuk Status Bar
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .windowInsetsTopHeight(WindowInsets.statusBars)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp)
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // BRAND LOGO & TITLE
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(32.dp)
                        .clip(CircleShape)
                        .background(Slate950),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "BK",
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        color = Color.White
                    )
                }

                Text(
                    text = "BURUNG KURIR",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp,
                    color = Slate950,
                    letterSpacing = 0.5.sp
                )
            }

            // ACTIONS (Bantuan & Tombol Masuk)
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "Bantuan",
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = Zinc600,
                    modifier = Modifier.clickable { onHelpClick() }
                )

                Box(
                    modifier = Modifier
                        .height(32.dp)
                        .background(Slate950, RoundedCornerShape(4.dp))
                        .clickable { onLoginClick() }
                        .padding(horizontal = 14.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "MASUK",
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold,
                        fontSize = 11.sp,
                        color = Color.White,
                        letterSpacing = 0.5.sp
                    )
                }
            }
        }
    }
}

// ─── 2. HEADER AUTH PAGE (Login / Register) ───
// Header bersih & minimalis dengan tombol kembali & indikator halaman
@Composable
fun NavHeader.AuthPage(
    title: String = "Masuk Akun",
    showBackButton: Boolean = true,
    onBackClick: () -> Unit = {},
    onHelpClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .border(BorderStroke(1.dp, Zinc100))
    ) {
        // Safe Inset Handling untuk Status Bar
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .windowInsetsTopHeight(WindowInsets.statusBars)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp)
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // LEFT: TOMBOL KEMBALI & JUDUL HALAMAN
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                if (showBackButton) {
                    Box(
                        modifier = Modifier
                            .size(32.dp)
                            .clip(CircleShape)
                            .background(Zinc100)
                            .border(BorderStroke(1.dp, Zinc200), CircleShape)
                            .clickable { onBackClick() },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Kembali",
                            tint = Slate950,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }

                Text(
                    text = title,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = Slate950
                )
            }

            // RIGHT: BANTUAN
            Text(
                text = "Butuh Bantuan?",
                fontFamily = FontFamily.SansSerif,
                fontSize = 11.sp,
                fontWeight = FontWeight.Medium,
                color = Zinc400,
                modifier = Modifier.clickable { onHelpClick() }
            )
        }
    }
}

@Composable
fun NavHeader.TugasPage(

    isAutoBidActive: Boolean = false,
    sisaKuotaBid: Int = 15,
    onAutoBidToggle: (Boolean) -> Unit = {},
    onFilterClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .border(BorderStroke(1.dp, Zinc100))
    ) {
        // Safe Inset Handling untuk Status Bar
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .windowInsetsTopHeight(WindowInsets.statusBars)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(58.dp)
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // ─── LEFT: STATUS RADAR & INFO KUOTA BID ───
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.weight(1f)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    // Indicator Dot Radar Status
                    Box(
                        modifier = Modifier
                            .size(8.dp)
                            .clip(CircleShape)
                            .background(if (isAutoBidActive) Teal400 else Zinc400)
                    )
                    Text(
                        text = if (isAutoBidActive) "RADAR BIDDING AKTIF" else "RADAR STANDBY",
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Bold,
                        fontSize = 11.sp,
                        color = Slate950,
                        letterSpacing = 0.5.sp
                    )
                }

                Spacer(modifier = Modifier.height(2.dp))

                Text(
                    text = "Sisa Kuota: $sisaKuotaBid Order • Area Jakarta",
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 10.sp,
                    color = Zinc600,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            // ─── RIGHT: TOMBOL TOGGLE AKTIFKAN BID ───
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Box(
                    modifier = Modifier
                        .height(34.dp)
                        .clip(RoundedCornerShape(6.dp))
                        .background(if (isAutoBidActive) Slate950 else Zinc100)
                        .border(
                            BorderStroke(1.dp, if (isAutoBidActive) Slate950 else Zinc200),
                            RoundedCornerShape(6.dp)
                        )
                        .clickable { onAutoBidToggle(!isAutoBidActive) }
                        .padding(horizontal = 12.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = if (isAutoBidActive) "AUTO-BID ON" else "AKTIFKAN BID",
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Bold,
                        fontSize = 10.sp,
                        color = if (isAutoBidActive) Color.White else Slate950
                    )
                }
            }
        }
    }
}
@Composable
fun NavHeader.ReusableHeader(
    headerType: String,
    OpenSideBar: () -> Unit = {},
    navigation: NavHostController,
    isAutoBidActive: Boolean = false,
    onAutoBidToggle: (Boolean) -> Unit = {}
) {
    when (headerType) {
        LandingSectionPrefix -> {
            this.LandingPage(
                onLoginClick = { navigation.navigate("$HomeSectionPrefix/Home") },
                onHelpClick = {}
            )
        }
        AuthSectionPrefix -> {
            this.AuthPage(
                title = namaKurir,
                showBackButton = true,
                onBackClick = { navigation.popBackStack() },
                onHelpClick = {}
            )
        }
        HomeSectionPrefix -> {
            this.HomePage(OpenSideBar = OpenSideBar)
        }
        TugasSectionPrefix -> {
            this.TugasPage(
                isAutoBidActive = isAutoBidActive,
                onAutoBidToggle = onAutoBidToggle
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewElement(){
    val header: NavHeader = NavHeader()
    header.HomePage(OpenSideBar = fun(){})
}