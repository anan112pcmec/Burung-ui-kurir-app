package com.example.burungkurirapp.ui.GeneralReusable.NavHeader

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.FilterList
import androidx.compose.material.icons.outlined.HelpOutline
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.burungkurirapp.statis.icons.HeroiconsBell
import com.example.burungkurirapp.statis.icons.MaterialIconsChat
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.burungkurirapp.ui.constant.color.Slate950
import com.example.burungkurirapp.ui.constant.color.Teal400
import com.example.burungkurirapp.ui.constant.color.Zinc100
import com.example.burungkurirapp.ui.constant.color.Zinc200
import com.example.burungkurirapp.ui.constant.color.Zinc400
import com.example.burungkurirapp.ui.constant.color.Zinc600
import com.example.burungkurirapp.ui.constant.color.Zinc950
import com.example.burungkurirapp.ui.constant.prefix.AuthSectionPrefix
import com.example.burungkurirapp.ui.constant.prefix.DetailsSectionPrefix
import com.example.burungkurirapp.ui.constant.prefix.HomeSectionPrefix
import com.example.burungkurirapp.ui.constant.prefix.LandingSectionPrefix
import com.example.burungkurirapp.ui.constant.prefix.RiwayatSectionPrefix
import com.example.burungkurirapp.ui.constant.prefix.TugasSectionPrefix
import com.example.burungkurirapp.ui.section.LocalUiFlowState

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
fun NavHeader.HomePage(
    OpenSideBar: () -> Unit = {},
    onNotificationClick: () -> Unit = {},
    onMailClick: () -> Unit = {},
    onRatingClick: () -> Unit = {}
) {
    val state = LocalUiFlowState.current
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

        // Header Content Area
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // ─── LEFT: AVATAR BULAT + IDENTITAS KURIR ───
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .weight(1f)
                    .clip(CircleShape)
                    .clickable { OpenSideBar() }
                    .padding(vertical = 4.dp)
            ) {
                // Avatar Bulat + Indicator Dot Status
                Box(contentAlignment = Alignment.BottomEnd) {
                    Box(
                        modifier = Modifier
                            .size(38.dp)
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
                        fontSize = 13.sp,
                        color = Slate950,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )

                    Spacer(modifier = Modifier.height(2.dp))

                    Text(
                        text = "$tipeKendaraan • #$idKurir",
                        fontFamily = FontFamily.Monospace,
                        fontSize = 10.sp,
                        color = Zinc400,
                        maxLines = 1
                    )
                }
            }

            Spacer(modifier = Modifier.width(8.dp))

            // ─── RIGHT: ACTION BUTTONS (Rating, Mail, Bell) ───
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                // Rating Pill Badge
                Surface (
                    onClick = onRatingClick,
                    shape = CircleShape,
                    color = Zinc100,
                    modifier = Modifier.height(32.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "Rating",
                            tint = Slate950,
                            modifier = Modifier.size(15.dp)
                        )
                        Text(
                            text = "4.9",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = Slate950
                        )
                    }
                }

                // Surat / Mail Icon
                IconButton (
                    onClick = {state.navController.navigate("$HomeSectionPrefix/Pesan")},
                    modifier = Modifier.size(36.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Mail,
                        contentDescription = "Pesan",
                        tint = Slate950,
                        modifier = Modifier.size(20.dp)
                    )
                }

                // Bell / Notification Icon dengan Red Dot Indicator
                Box(contentAlignment = Alignment.TopEnd) {
                    IconButton(
                        onClick = {state.navController.navigate("$HomeSectionPrefix/Aktivitas")},
                        modifier = Modifier.size(36.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Notifications,
                            contentDescription = "Notifikasi",
                            tint = Slate950,
                            modifier = Modifier.size(20.dp)
                        )
                    }

                    // Dot merah notifikasi belum dibaca
                    Box(
                        modifier = Modifier
                            .padding(top = 6.dp, end = 6.dp)
                            .size(8.dp)
                            .clip(CircleShape)
                            .background(Color(0xFFDC2626))
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
                .height(60.dp)
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
                        .size(36.dp)
                        .clip(CircleShape)
                        .background(Slate950)
                        .border(BorderStroke(1.dp, Zinc200), CircleShape),
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

                Column(verticalArrangement = Arrangement.Center) {
                    Text(
                        text = "BURUNG KURIR",
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp,
                        color = Slate950,
                        letterSpacing = 0.5.sp
                    )
                    Text(
                        text = "Logistics App",
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Medium,
                        fontSize = 9.sp,
                        color = Zinc600
                    )
                }
            }

            // ACTIONS (Bantuan & Tombol Masuk)
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                // Tombol Bantuan (Pill Style dengan Icon)
                Surface(
                    onClick = onHelpClick,
                    shape = RoundedCornerShape(20.dp),
                    color = Color.Transparent,
                    modifier = Modifier.height(34.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.HelpOutline,
                            contentDescription = "Bantuan",
                            tint = Zinc600,
                            modifier = Modifier.size(16.dp)
                        )
                        Text(
                            text = "Bantuan",
                            fontFamily = FontFamily.SansSerif,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium,
                            color = Zinc600
                        )
                    }
                }

                // Tombol Masuk (Primary CTA Button)
                Button(
                    onClick = onLoginClick,
                    modifier = Modifier.height(34.dp),
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Slate950,
                        contentColor = Color.White
                    ),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 0.dp)
                ) {
                    Text(
                        text = "MASUK",
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold,
                        fontSize = 11.sp,
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
                .height(60.dp)
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // LEFT: TOMBOL KEMBALI & JUDUL HALAMAN
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                if (showBackButton) {
                    Surface(
                        onClick = onBackClick,
                        shape = CircleShape,
                        color = Zinc100,
                        border = BorderStroke(1.dp, Zinc200),
                        modifier = Modifier.size(36.dp)
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Kembali",
                            tint = Slate950,
                            modifier = Modifier
                                .padding(8.dp)
                                .size(18.dp)
                        )
                    }
                }

                Text(
                    text = title,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    color = Slate950
                )
            }

            // RIGHT: BANTUAN
            Surface(
                onClick = onHelpClick,
                shape = RoundedCornerShape(20.dp),
                color = Color.Transparent,
                modifier = Modifier.height(34.dp)
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.HelpOutline,
                        contentDescription = "Bantuan",
                        tint = Zinc600,
                        modifier = Modifier.size(16.dp)
                    )
                    Text(
                        text = "Bantuan",
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        color = Zinc600
                    )
                }
            }
        }
    }
}
@Composable
fun NavHeader.TugasPage(
    isAutoBidActive: Boolean = false,
    sisaKuotaBid: Int = 15,
    areaAktif: String = "Jakarta",
    onAutoBidToggle: (Boolean) -> Unit = {},
    onFilterClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .border(BorderStroke(1.dp, Zinc100))
    ) {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .windowInsetsTopHeight(WindowInsets.statusBars)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.weight(1f)
            ) {
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .clip(CircleShape)
                        .background(if (isAutoBidActive) Teal400 else Zinc400)
                )

                Column(verticalArrangement = Arrangement.Center) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Text(
                            text = if (isAutoBidActive) "AUTO-BID ACTIVE" else "MANUAL BID",
                            fontFamily = FontFamily.Monospace,
                            fontWeight = FontWeight.Bold,
                            fontSize = 12.sp,
                            color = Slate950,
                            letterSpacing = 0.5.sp
                        )

                        Surface(
                            shape = RoundedCornerShape(4.dp),
                            color = Zinc100,
                            border = BorderStroke(1.dp, Zinc200)
                        ) {
                            Text(
                                text = "$sisaKuotaBid Kuota",
                                fontFamily = FontFamily.Monospace,
                                fontSize = 9.sp,
                                fontWeight = FontWeight.Bold,
                                color = Slate950,
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(2.dp))

                    Text(
                        text = "Area: $areaAktif",
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 10.sp,
                        color = Zinc600,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }

            Spacer(modifier = Modifier.width(8.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Switch(
                    checked = isAutoBidActive,
                    onCheckedChange = onAutoBidToggle,
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Color.White,
                        checkedTrackColor = Slate950,
                        uncheckedThumbColor = Zinc400,
                        uncheckedTrackColor = Zinc100,
                        uncheckedBorderColor = Zinc200
                    )
                )

                IconButton(
                    onClick = onFilterClick,
                    modifier = Modifier.size(36.dp)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.FilterList,
                        contentDescription = "Filter Order",
                        tint = Slate950,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }
    }
}

// ─── POPUP FILTER SIMPLE ───
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterBidBottomSheet(
    onDismiss: () -> Unit,
    onApply: (jenisPengiriman: String, isEkspedisi: Boolean, maxKg: Int) -> Unit = { _: String, _: Boolean, _: Int -> }
) {
    // State lokal eksplisit dengan deklarasi tipe data
    var jenisPengiriman: String by remember { mutableStateOf("reguler") }
    var isEkspedisi: Boolean by remember { mutableStateOf(false) }
    var maxKgText: String by remember { mutableStateOf("20") }

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        containerColor = Color.White
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Filter Bid",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Slate950
            )

            // 1. Jenis Pengiriman
            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Text("Jenis Pengiriman", fontSize = 12.sp, color = Zinc600)
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    listOf("reguler", "express", "instant").forEach { item: String ->
                        FilterChip(
                            selected = (jenisPengiriman == item),
                            onClick = { jenisPengiriman = item },
                            label = { Text(item.uppercase(), fontSize = 11.sp, fontWeight = FontWeight.Bold) },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = Slate950,
                                selectedLabelColor = Color.White
                            )
                        )
                    }
                }
            }

            // 2. Mode Ekspedisi
            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Text("Mode Layanan", fontSize = 12.sp, color = Zinc600)
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    FilterChip(
                        selected = (isEkspedisi == false),
                        onClick = { isEkspedisi = false },
                        label = { Text("NON-EKSPEDISI", fontSize = 11.sp, fontWeight = FontWeight.Bold) },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = Slate950,
                            selectedLabelColor = Color.White
                        )
                    )
                    FilterChip(
                        selected = (isEkspedisi == true),
                        onClick = { isEkspedisi = true },
                        label = { Text("EKSPEDISI", fontSize = 11.sp, fontWeight = FontWeight.Bold) },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = Slate950,
                            selectedLabelColor = Color.White
                        )
                    )
                }
            }

            // 3. Max Kg
            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Text("Kapasitas Maksimal (Kg)", fontSize = 12.sp, color = Zinc600)
                OutlinedTextField(
                    value = maxKgText,
                    onValueChange = { teksBaru: String -> maxKgText = teksBaru },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.fillMaxWidth()
                )
            }

            // Tombol Terapkan
            Button(
                onClick = {
                    val parsedKg: Int = maxKgText.toIntOrNull() ?: 0
                    onApply(jenisPengiriman, isEkspedisi, parsedKg)
                    onDismiss()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(44.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Slate950)
            ) {
                Text("TERAPKAN FILTER", fontWeight = FontWeight.Bold, fontSize = 12.sp)
            }
        }
    }
}

@Composable
fun NavHeader.RiwayatPage(
    selectedTabName: String = "Pengiriman",
    totalRiwayatCount: Int = 10,
    onFilterClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .border(BorderStroke(1.dp, Zinc100))
    ) {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .windowInsetsTopHeight(WindowInsets.statusBars)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // LEFT: JUDUL SECTION & COUNTER DATA
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.weight(1f)
            ) {
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .clip(CircleShape)
                        .background(Slate950)
                )

                Column(verticalArrangement = Arrangement.Center) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Text(
                            text = "RIWAYAT ${selectedTabName.uppercase()}",
                            fontFamily = FontFamily.Monospace,
                            fontWeight = FontWeight.Bold,
                            fontSize = 12.sp,
                            color = Slate950,
                            letterSpacing = 0.5.sp
                        )

                        Surface(
                            shape = RoundedCornerShape(4.dp),
                            color = Zinc100,
                            border = BorderStroke(1.dp, Zinc200)
                        ) {
                            Text(
                                text = "$totalRiwayatCount Data",
                                fontFamily = FontFamily.Monospace,
                                fontSize = 9.sp,
                                fontWeight = FontWeight.Bold,
                                color = Slate950,
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(2.dp))

                    Text(
                        text = "Arsip & Log Aktivitas Kurir",
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 10.sp,
                        color = Zinc600,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }

            Spacer(modifier = Modifier.width(8.dp))

            // RIGHT: FILTER ACTION BUTTON
            IconButton(
                onClick = onFilterClick,
                modifier = Modifier.size(36.dp)
            ) {
                Icon(
                    imageVector = Icons.Outlined.FilterList,
                    contentDescription = "Filter Riwayat",
                    tint = Slate950,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}

@Composable
fun NavHeader.DetailsPage(
    pageName: String = "Detail",
    onBackClick: () -> Unit = {}
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
                .height(60.dp)
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // LEFT: TOMBOL KEMBALI & JUDUL DETAILS
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Surface(
                    onClick = onBackClick,
                    shape = CircleShape,
                    color = Zinc100,
                    border = BorderStroke(1.dp, Zinc200),
                    modifier = Modifier.size(36.dp)
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Kembali",
                        tint = Slate950,
                        modifier = Modifier
                            .padding(8.dp)
                            .size(18.dp)
                    )
                }

                Column(verticalArrangement = Arrangement.Center) {
                    Text(
                        text = pageName.uppercase(),
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        color = Slate950,
                        letterSpacing = 0.5.sp
                    )
                    Text(
                        text = "Informasi & Detail Data",
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 10.sp,
                        color = Zinc600,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}
@Composable
fun NavHeader.ReusableHeader(
    headerType: String,
    pageName: String?,
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
        RiwayatSectionPrefix -> {
            this.RiwayatPage(
                selectedTabName = "Pengiriman", // Bisa disesuaikan dengan tab aktif
                totalRiwayatCount = 10,
                onFilterClick = { /* Aksi ketika tombol filter riwayat ditekan */ }
            )
        }

        DetailsSectionPrefix -> {
            this.DetailsPage(
                pageName = pageName ?: "Detail",
                onBackClick = { navigation.popBackStack() }
            )
        }


    }
}

@Preview(showBackground = true)
@Composable
fun PreviewElement(){
    val header: NavHeader = NavHeader()
    header.DetailsPage()
}