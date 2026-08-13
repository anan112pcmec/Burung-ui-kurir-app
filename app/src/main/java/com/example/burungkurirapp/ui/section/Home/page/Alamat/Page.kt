package com.example.burungkurirapp.ui.section.Home.page.Alamat

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.HomeWork
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.burungkurirapp.ui.constant.color.*
import com.example.burungkurirapp.ui.section.Home.page.Alamat.component.DialogHapusAlamat
import com.example.burungkurirapp.ui.section.Home.page.Alamat.component.FormAlamatSection
import com.example.burungkurirapp.ui.section.Home.page.Alamat.component.SingleAlamatCard

// ─── DATA MODEL (Direct Mapping to Payload Structs) ───
data class AlamatKurirItem(
    val id: Long = 1,
    val panggilanAlamat: String,
    val nomorTelephone: String,
    val namaAlamat: String,
    val kota: String,
    val provinsi: String,
    val kodeNegara: String,
    val kodePos: String,
    val deskripsi: String,
    val longitude: Double,
    val latitude: Double
)


// ─── KOMPONEN 1: MAIN CONTAINER PAGE ───
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AlamatPage() {
    // Single Address State (Nullable, Max 1 Address)
    var alamatUtama by remember {
        mutableStateOf<AlamatKurirItem?>(
            AlamatKurirItem(
                id = 101,
                panggilanAlamat = "BASECAMP DOMISILI",
                nomorTelephone = "081298765432",
                namaAlamat = "Jl. Raya Daan Mogot No. 45, RT 02/RW 05",
                kota = "Jakarta Barat",
                provinsi = "DKI Jakarta",
                kodeNegara = "ID",
                kodePos = "11730",
                deskripsi = "Pagar hitam tinggi, sebelah toko kelontong Pak Haji.",
                longitude = 106.7583,
                latitude = -6.1683
            )
        )
    }

    var isFormOpen by remember { mutableStateOf(false) }
    var isEditing by remember { mutableStateOf(false) }
    var showDeleteConfirm by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize().background(Color.White)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Header Section
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "ALAMAT KURIR",
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        color = Slate950,
                        letterSpacing = 1.sp
                    )

                }

                // Tombol Tambah hanya aktif jika BELUM ADA alamat
                if (alamatUtama == null && !isFormOpen) {
                    Box(
                        modifier = Modifier
                            .background(Slate950, RoundedCornerShape(2.dp))
                            .clickable {
                                isEditing = false
                                isFormOpen = true
                            }
                            .padding(horizontal = 8.dp, vertical = 5.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(12.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = "TAMBAH",
                                fontFamily = FontFamily.SansSerif,
                                fontWeight = FontWeight.Bold,
                                fontSize = 9.sp,
                                color = Color.White
                            )
                        }
                    }
                }
            }

            Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(Zinc100))

            // Info Banner Rule
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Zinc50, RoundedCornerShape(2.dp))
                    .border(BorderStroke(1.dp, Zinc200), RoundedCornerShape(2.dp))
                    .padding(10.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = null,
                        tint = Zinc500,
                        modifier = Modifier.size(14.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "KETENTUAN: 1 KURIR HANYA BISA MENDAFTARKAN 1 ALAMAT UTAMA.",
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 8.sp,
                        fontWeight = FontWeight.Bold,
                        color = Zinc600
                    )
                }
            }

            // Form Section (Create / Edit)
            if (isFormOpen) {
                FormAlamatSection (
                    initialData = if (isEditing) alamatUtama else null,
                    onCancel = { isFormOpen = false },
                    onSubmit = { item ->
                        alamatUtama = item
                        isFormOpen = false
                    }
                )
            }

            // Display Alamat Card / Empty State
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Text(
                    text = "STATUS ALAMAT TERDAFTAR",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 9.sp,
                    color = Zinc400,
                    letterSpacing = 1.sp
                )

                if (alamatUtama == null) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Zinc50, RoundedCornerShape(2.dp))
                            .border(BorderStroke(1.dp, Zinc200), RoundedCornerShape(2.dp))
                            .padding(20.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "BELUM ADA ALAMAT TERTAUT",
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Bold,
                            fontSize = 10.sp,
                            color = Zinc400
                        )
                    }
                } else {
                    alamatUtama?.let { item ->
                        SingleAlamatCard (
                            item = item,
                            onEdit = {
                                isEditing = true
                                isFormOpen = true
                            },
                            onDelete = { showDeleteConfirm = true }
                        )
                    }
                }
            }
        }

        // Dialog Confirm Hapus
        if (showDeleteConfirm) {
            DialogHapusAlamat (
                onDismiss = { showDeleteConfirm = false },
                onConfirmDelete = {
                    alamatUtama = null
                    showDeleteConfirm = false
                    isFormOpen = false
                }
            )
        }
    }
}

