package com.example.burungkurirapp.ui.section.Tugas.page.DaftarBid.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import com.example.burungkurirapp.statis.icons.MaterialIconsApps
import com.example.burungkurirapp.ui.constant.color.Slate950
import com.example.burungkurirapp.ui.constant.color.Teal400
import com.example.burungkurirapp.ui.constant.color.Zinc100
import com.example.burungkurirapp.ui.constant.color.Zinc200
import com.example.burungkurirapp.ui.constant.color.Zinc400
import com.example.burungkurirapp.ui.constant.color.Zinc50
import com.example.burungkurirapp.ui.constant.color.Zinc500
import com.example.burungkurirapp.ui.constant.color.Zinc600
import com.example.burungkurirapp.ui.constant.color.Zinc800
import com.example.burungkurirapp.ui.section.Home.page.Home.OrderDelivery

@Composable
fun AvailableOrderCard(order: OrderDelivery) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(8.dp))
            .border(BorderStroke(1.dp, Zinc200), RoundedCornerShape(8.dp))
            .padding(14.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "#${order.idOrder}",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp,
                    color = Slate950
                )
                Spacer(modifier = Modifier.width(8.dp))
                Box(
                    modifier = Modifier
                        .background(Zinc100, RoundedCornerShape(4.dp))
                        .border(BorderStroke(0.5.dp, Zinc200), RoundedCornerShape(4.dp))
                        .padding(horizontal = 6.dp, vertical = 3.dp)
                ) {
                    Text(
                        text = order.tipeItem.uppercase(),
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 10.sp,
                        color = Zinc600,
                        fontWeight = FontWeight.Medium
                    )
                }
            }

            Text(
                text = order.ongkir,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                color = Slate950
            )
        }

        // Route Visual Block
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Zinc50, RoundedCornerShape(6.dp))
                .border(BorderStroke(1.dp, Zinc100), RoundedCornerShape(6.dp))
                .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Pickup Line
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .background(Zinc400, CircleShape)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "PICKUP: ",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 11.sp,
                    color = Zinc500
                )
                Text(
                    text = "${order.toko} (${order.alamatPickup})",
                    fontSize = 12.sp,
                    color = Zinc800,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            // Drop Line
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .background(Teal400, CircleShape)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "DROP: ",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 11.sp,
                    color = Teal400
                )
                Text(
                    text = "${order.penerima} (${order.alamatDrop})",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Slate950,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }

        // Footer Actions
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = MaterialIconsApps,
                    contentDescription = null,
                    tint = Zinc400,
                    modifier = Modifier.size(14.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = "JARAK: ${order.jarak}",
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 11.sp,
                    color = Zinc500,
                    fontWeight = FontWeight.Medium
                )
            }

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(4.dp))
                    .border(BorderStroke(1.dp, Slate950), RoundedCornerShape(4.dp))
                    .background(Color.White)
                    .clickable { }
                    .padding(horizontal = 14.dp, vertical = 8.dp)
            ) {
                Text(
                    text = "AMBIL ORDER",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 11.sp,
                    color = Slate950
                )
            }
        }
    }
}