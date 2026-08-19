package com.example.burungkurirapp.ui.section.Historical.page.Option

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.Gavel
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.LocalShipping
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Payments
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.burungkurirapp.ui.constant.color.Slate950
import com.example.burungkurirapp.ui.constant.color.Zinc100
import com.example.burungkurirapp.ui.constant.color.Zinc300
import com.example.burungkurirapp.ui.constant.color.Zinc600
import com.example.burungkurirapp.ui.section.LocalUiFlowState
import com.example.burungkurirapp.ui.section.rememberUiFlowState

@Composable
fun HistoricalOptionPage(
    option: List<OptionProps>
) {
    CompositionLocalProvider(LocalUiFlowState provides rememberUiFlowState()) {
        val uiFlowState = LocalUiFlowState.current

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            option.forEach { item ->
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .clickable {
                            uiFlowState.navController.navigate(item.path)
                        },
                    color = Zinc100,
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 14.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(Zinc300),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription = item.nama,
                                    tint = Slate950,
                                    modifier = Modifier.size(20.dp)
                                )
                            }

                            Text(
                                text = item.nama.uppercase(),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                color = Slate950
                            )
                        }

                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                            contentDescription = "Navigate",
                            tint = Zinc600
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PrevHistoricalOptionPage() {
    val sampleOptions = listOf(
        OptionProps(
            nama = "Riwayat Pengiriman",
            path = "history_pengiriman",
            icon = Icons.Default.LocalShipping
        ),
        OptionProps(
            nama = "Riwayat Pencairan Saldo",
            path = "history_pencairan",
            icon = Icons.Default.Payments
        ),
        OptionProps(
            nama = "Log Aktivitas Kurir",
            path = "history_aktivitas",
            icon = Icons.Default.History
        ),
        OptionProps(
            nama = "Riwayat Bid",
            path = "history_bid",
            icon = Icons.Default.Gavel
        ),
        OptionProps(
            nama = "Riwayat Informasi Kendaraan",
            path = "history_kendaraan",
            icon = Icons.Default.DirectionsCar
        ),
        OptionProps(
            nama = "Riwayat Informasi Kurir",
            path = "history_kurir",
            icon = Icons.Default.Person
        ),
        OptionProps(
            nama = "Riwayat Profile",
            path = "history_profile",
            icon = Icons.Default.AccountCircle
        ),
        OptionProps(
            nama = "Riwayat Rekening",
            path = "history_rekening",
            icon = Icons.Default.AccountBalance
        ),
        OptionProps(
            nama = "Riwayat Alamat",
            path = "history_alamat",
            icon = Icons.Default.LocationOn
        )
    )

    HistoricalOptionPage(option = sampleOptions)
}