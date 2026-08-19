package com.example.burungkurirapp.ui.section.Home.page.Alamat.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.HomeWork
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
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
import com.example.burungkurirapp.ui.section.Home.page.Alamat.AlamatKurirItem

private val Rose600 = Color(0xFFE11D48)

// ─── KOMPONEN 2: CARD ALAMAT SINGLE ───
@Composable
fun SingleAlamatCard(
    item: AlamatKurirItem,
    onEdit: () -> Unit,
    onDelete: () -> Unit
) {
    Surface(
        shape = RoundedCornerShape(8.dp),
        color = Color.White,
        border = BorderStroke(1.dp, Zinc200),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            // Header: Icon, Label Alamat, Telepon & Tombol Aksi
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Surface(
                        shape = RoundedCornerShape(6.dp),
                        color = Slate950,
                        modifier = Modifier.size(36.dp)
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Icon(
                                imageVector = Icons.Default.HomeWork,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(18.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.width(10.dp))

                    Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                        Text(
                            text = item.panggilanAlamat.uppercase(),
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.sp,
                            color = Slate950
                        )
                        Text(
                            text = "TELP: ${item.nomorTelephone}",
                            fontFamily = FontFamily.SansSerif,
                            fontSize = 11.sp,
                            color = Zinc500
                        )
                    }
                }

                Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                    // Tombol Edit
                    Surface(
                        onClick = onEdit,
                        shape = RoundedCornerShape(6.dp),
                        color = Zinc50,
                        border = BorderStroke(1.dp, Zinc200)
                    ) {
                        Box(
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Edit,
                                contentDescription = "Edit",
                                tint = Slate950,
                                modifier = Modifier.size(14.dp)
                            )
                        }
                    }

                    // Tombol Hapus
                    Surface(
                        onClick = onDelete,
                        shape = RoundedCornerShape(6.dp),
                        color = Zinc50,
                        border = BorderStroke(1.dp, Zinc200)
                    ) {
                        Box(
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Delete,
                                contentDescription = "Hapus",
                                tint = Rose600,
                                modifier = Modifier.size(14.dp)
                            )
                        }
                    }
                }
            }

            HorizontalDivider(color = Zinc100, thickness = 1.dp)

            // Informasi Detail Alamat
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Text(
                    text = item.namaAlamat,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Slate950
                )
                Text(
                    text = "${item.kota}, ${item.provinsi} • ${item.kodePos} (${item.kodeNegara})",
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 11.sp,
                    color = Zinc600
                )
                if (item.deskripsi.isNotBlank()) {
                    Text(
                        text = "PATOKAN: ${item.deskripsi}",
                        fontSize = 11.sp,
                        color = Zinc500,
                        lineHeight = 15.sp
                    )
                }
            }

            // Tag GPS
            Surface(
                shape = RoundedCornerShape(4.dp),
                color = Zinc50,
                border = BorderStroke(1.dp, Zinc200)
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = null,
                        tint = Teal600,
                        modifier = Modifier.size(14.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "GPS: ${item.latitude}, ${item.longitude}",
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 10.sp,
                        color = Zinc600
                    )
                }
            }
        }
    }
}