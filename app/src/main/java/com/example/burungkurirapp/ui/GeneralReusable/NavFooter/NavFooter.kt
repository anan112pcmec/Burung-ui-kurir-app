package com.example.burungkurirapp.ui.GeneralReusable.NavFooter

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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.burungkurirapp.statis.icons.FluentuiSystemIconsHistory
import com.example.burungkurirapp.statis.icons.FontAwesomeShippingFast
import com.example.burungkurirapp.statis.icons.VscodeCodiconsHome
import com.example.burungkurirapp.ui.constant.color.Slate950
import com.example.burungkurirapp.ui.constant.prefix.HomeSectionPrefix
import com.example.burungkurirapp.ui.constant.prefix.RiwayatSectionPrefix
import com.example.burungkurirapp.ui.constant.prefix.TugasSectionPrefix

data class NavItem(
    val icon: ImageVector,
    val label: String,
    val index: Int,
    val onClick: () -> Unit
)

@Preview(showBackground = true)
@Composable
fun NavFooterPage(
    selectedIndex: Int = 0,
    onTabSelected: (Int) -> Unit = {},
    RoutingElement: NavHostController = rememberNavController()
) {
    val items = listOf(
        NavItem(
            icon = VscodeCodiconsHome,
            label = "BERANDA",
            index = 0,
            onClick = { RoutingElement.navigate("$HomeSectionPrefix/Home") }
        ),
        NavItem(
            icon = FontAwesomeShippingFast,
            label = "TUGAS",
            index = 2,
            onClick = { RoutingElement.navigate("$TugasSectionPrefix/Daftar-Bid") }
        ),
        NavItem(
            icon = FluentuiSystemIconsHistory,
            label = "RIWAYAT",
            index = 3,
            onClick = { RoutingElement.navigate("$RiwayatSectionPrefix/") }
        )
    )

    // Perbaikan: Navigasi bar padding ditaruh di luar agar tidak mendistorsi tinggi Row 60.dp
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .border(width = 0.5.dp, color = Color(0xFFE4E4E7))
            .navigationBarsPadding(), // Aman untuk HP dengan gesture bar / tombol fisik bawah
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        for ((icon, label, index, onClickAction) in items) {
            val isSelected = selectedIndex == index
            val color = if (isSelected) Slate950 else Color.Gray

            Column(
                modifier = Modifier
                    .weight(1f) // Membagi lebar layar secara merata ke setiap menu
                    .height(60.dp)
                    .clickable {
                        onTabSelected(index)
                        onClickAction()
                    },
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