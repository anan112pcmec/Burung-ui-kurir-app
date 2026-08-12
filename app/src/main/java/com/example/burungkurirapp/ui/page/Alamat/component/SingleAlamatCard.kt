package com.example.burungkurirapp.ui.page.Alamat.component

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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.HomeWork
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.burungkurirapp.ui.constant.color.Slate950
import com.example.burungkurirapp.ui.constant.color.Teal600
import com.example.burungkurirapp.ui.constant.color.Zinc100
import com.example.burungkurirapp.ui.constant.color.Zinc200
import com.example.burungkurirapp.ui.constant.color.Zinc50
import com.example.burungkurirapp.ui.constant.color.Zinc500
import com.example.burungkurirapp.ui.constant.color.Zinc600
import com.example.burungkurirapp.ui.page.Alamat.AlamatKurirItem


// ─── KOMPONEN 2: CARD ALAMAT SINGLE ───
@Composable
fun SingleAlamatCard(
    item: AlamatKurirItem,
    onEdit: () -> Unit,
    onDelete: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(2.dp))
            .border(BorderStroke(1.dp, Slate950), RoundedCornerShape(2.dp))
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(32.dp)
                        .background(Slate950, RoundedCornerShape(2.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.HomeWork,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(16.dp)
                    )
                }

                Spacer(modifier = Modifier.width(10.dp))

                Column {
                    Text(
                        text = item.panggilanAlamat.uppercase(),
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        color = Slate950
                    )
                    Text(
                        text = "TELP: ${item.nomorTelephone}",
                        fontFamily = FontFamily.Monospace,
                        fontSize = 8.sp,
                        color = Zinc500
                    )
                }
            }

            Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                Box(
                    modifier = Modifier
                        .background(Zinc50, RoundedCornerShape(2.dp))
                        .border(BorderStroke(1.dp, Zinc200), RoundedCornerShape(2.dp))
                        .clickable { onEdit() }
                        .padding(horizontal = 8.dp, vertical = 6.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Edit",
                        tint = Slate950,
                        modifier = Modifier.size(13.dp)
                    )
                }

                Box(
                    modifier = Modifier
                        .background(Zinc50, RoundedCornerShape(2.dp))
                        .border(BorderStroke(1.dp, Zinc200), RoundedCornerShape(2.dp))
                        .clickable { onDelete() }
                        .padding(horizontal = 8.dp, vertical = 6.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Hapus",
                        tint = Color(0xFFE11D48),
                        modifier = Modifier.size(13.dp)
                    )
                }
            }
        }

        Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(Zinc100))

        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Text(
                text = item.namaAlamat,
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = Slate950
            )
            Text(
                text = "${item.kota}, ${item.provinsi} • ${item.kodePos} (${item.kodeNegara})",
                fontFamily = FontFamily.Monospace,
                fontSize = 9.sp,
                color = Zinc600
            )
            if (item.deskripsi.isNotBlank()) {
                Text(
                    text = "PATOKAN: ${item.deskripsi}",
                    fontSize = 10.sp,
                    color = Zinc500,
                    lineHeight = 14.sp
                )
            }
        }

        // Tag Koordinat GPS (Lat / Long)
        Row(
            modifier = Modifier
                .background(Zinc50, RoundedCornerShape(2.dp))
                .border(BorderStroke(0.5.dp, Zinc200), RoundedCornerShape(2.dp))
                .padding(horizontal = 6.dp, vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.LocationOn,
                contentDescription = null,
                tint = Teal600,
                modifier = Modifier.size(12.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "GPS: ${item.latitude}, ${item.longitude}",
                fontFamily = FontFamily.Monospace,
                fontSize = 8.sp,
                color = Zinc600
            )
        }
    }
}