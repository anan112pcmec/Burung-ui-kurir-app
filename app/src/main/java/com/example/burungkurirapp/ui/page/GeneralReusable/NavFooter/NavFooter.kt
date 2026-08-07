package com.example.burungkurirapp.ui.page.GeneralReusable.NavFooter

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.burungkurirapp.statis.icons.FluentuiSystemIconsHistory
import com.example.burungkurirapp.statis.icons.FluentuiSystemIconsReceipt
import com.example.burungkurirapp.statis.icons.FontAwesomeShippingFast
import com.example.burungkurirapp.statis.icons.VscodeCodiconsHome
import com.example.burungkurirapp.ui.constant.color.Slate950

class NavFooter

@Preview(showBackground = true)
@Composable
fun NavFooterPage(
    selectedIndex: Int = 0,
    onTabSelected: (Int) -> Unit = {}
) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(Color.White)
                .border(width = 0.5.dp, color = Color(0xFFE4E4E7))
                .padding(horizontal = 8.dp)
                .navigationBarsPadding(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            val items = listOf(
                Triple(VscodeCodiconsHome, "BERANDA", 0),
                Triple(FluentuiSystemIconsReceipt, "TRANSAKSI", 1),
                Triple(FontAwesomeShippingFast, "TUGAS", 2),
                Triple(FluentuiSystemIconsHistory, "RIWAYAT", 3)
            )

            for ((icon, label, index) in items) {
                val isSelected = selectedIndex == index
                val color = if (isSelected) Slate950 else Color.Gray

                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .clickable { onTabSelected(index) }
                        .padding(horizontal = 12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = label,
                        tint = color,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = label,
                        color = color,
                        fontSize = 10.sp
                    )
                }
            }
        }
    }
}