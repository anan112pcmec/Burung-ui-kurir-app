package com.example.burungkurirapp.ui.section.Home.page.Rekening

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.burungkurirapp.ui.constant.color.*
import com.example.burungkurirapp.ui.section.Home.page.Rekening.component.CustomInputField
import com.example.burungkurirapp.ui.section.Home.page.Rekening.component.SingleRekeningCard

data class RekeningItem(
    val id: Long,
    val namaBank: String,
    val nomorRekening: String,
    val pemilikRekening: String
)

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RekeningPage() {
    // ─── STATE REKENING (NULLABLE: MAKSIMAL 1 REKENING) ───
    var rekeningUtama by remember {
        mutableStateOf<RekeningItem?>(
            RekeningItem(1, "BCA", "8830912044", "FAIZ HANNAN HAKIM")
        )
    }

    var isFormOpen by remember { mutableStateOf(false) }
    var isEditing by remember { mutableStateOf(false) }

    // Form inputs
    var namaBankInput by remember { mutableStateOf("") }
    var nomorRekeningInput by remember { mutableStateOf("") }
    var pemilikRekeningInput by remember { mutableStateOf("") }

    // Modal state
    var showDeleteConfirm by remember { mutableStateOf(false) }

    fun resetForm() {
        namaBankInput = ""
        nomorRekeningInput = ""
        pemilikRekeningInput = ""
        isFormOpen = false
        isEditing = false
    }

    fun openFormForEdit() {
        rekeningUtama?.let {
            namaBankInput = it.namaBank
            nomorRekeningInput = it.nomorRekening
            pemilikRekeningInput = it.pemilikRekening
            isEditing = true
            isFormOpen = true
        }
    }

    Box(modifier = Modifier.fillMaxSize().background(Color.White)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            // ─── 1. HEADER & ACTION ───
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                    Text(
                        text = "REKENING UTAMA",
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = Slate950,
                        letterSpacing = 0.5.sp
                    )
                    Text(
                        text = "Penarikan saldo operasional kurir",
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 12.sp,
                        color = Zinc400
                    )
                }

                // Tombol TAMBAH hanya muncul jika BELUM ADA rekening DAN form sedang tertutup
                if (rekeningUtama == null && !isFormOpen) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(2.dp))
                            .background(Slate950)
                            .clickable {
                                resetForm()
                                isFormOpen = true
                            }
                            .padding(horizontal = 12.dp, vertical = 8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(14.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "TAUTKAN",
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

            Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(Zinc100))

            // ─── 2. BANNER INFORMASI BATAS REKENING (SINGLE ACCOUNT RULE) ───
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(2.dp))
                    .background(Zinc50)
                    .border(BorderStroke(1.dp, Zinc200), RoundedCornerShape(2.dp))
                    .padding(14.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = null,
                        tint = Zinc500,
                        modifier = Modifier.size(18.dp)
                    )
                    Text(
                        text = "KETENTUAN: 1 Kurir hanya bisa menautkan 1 rekening utama.",
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Zinc600,
                        lineHeight = 16.sp
                    )
                }
            }

            // ─── 3. FORM INPUT / EDIT ───
            if (isFormOpen) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(2.dp))
                        .background(Zinc50)
                        .border(BorderStroke(1.dp, Slate950), RoundedCornerShape(2.dp))
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    Text(
                        text = if (isEditing) "FORM UBAH REKENING UTAMA" else "FORM TAUTKAN REKENING UTAMA",
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        color = Slate950,
                        letterSpacing = 0.5.sp
                    )

                    CustomInputField(
                        label = "NAMA BANK",
                        value = namaBankInput,
                        onValueChange = { namaBankInput = it.uppercase() },
                        placeholder = "Contoh: BCA / MANDIRI / BRI"
                    )

                    CustomInputField(
                        label = "NOMOR REKENING",
                        value = nomorRekeningInput,
                        onValueChange = { nomorRekeningInput = it },
                        placeholder = "Masukkan nomor rekening"
                    )

                    CustomInputField(
                        label = "NAMA PEMILIK (SESUAI KTP KURIR)",
                        value = pemilikRekeningInput,
                        onValueChange = { pemilikRekeningInput = it.uppercase() },
                        placeholder = "Masukkan nama pemilik"
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .height(44.dp)
                                .clip(RoundedCornerShape(2.dp))
                                .background(Color.White)
                                .border(BorderStroke(1.dp, Zinc200), RoundedCornerShape(2.dp))
                                .clickable { resetForm() },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "BATAL",
                                fontFamily = FontFamily.SansSerif,
                                fontWeight = FontWeight.Bold,
                                fontSize = 11.sp,
                                color = Zinc600,
                                letterSpacing = 0.5.sp
                            )
                        }

                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .height(44.dp)
                                .clip(RoundedCornerShape(2.dp))
                                .background(Slate950)
                                .clickable {
                                    if (namaBankInput.isNotBlank() && nomorRekeningInput.isNotBlank()) {
                                        rekeningUtama = RekeningItem(
                                            id = rekeningUtama?.id ?: 1,
                                            namaBank = namaBankInput,
                                            nomorRekening = nomorRekeningInput,
                                            pemilikRekening = pemilikRekeningInput
                                        )
                                        resetForm()
                                    }
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "SIMPAN REKENING",
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

            // ─── 4. DISPLAY REKENING UTAMA ATAU EMPTY STATE ───
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Text(
                    text = "STATUS REKENING TERTAUT",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 11.sp,
                    color = Zinc400,
                    letterSpacing = 0.5.sp
                )

                if (rekeningUtama == null) {
                    // Empty State bila belum ada rekening
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(2.dp))
                            .background(Zinc50)
                            .border(BorderStroke(1.dp, Zinc200), RoundedCornerShape(2.dp))
                            .padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = "BELUM ADA REKENING TERKONEKSI",
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Bold,
                            fontSize = 12.sp,
                            color = Slate950
                        )
                        Text(
                            text = "Tautkan rekening bank Anda untuk menerima hasil pencairan pencapaian insentif.",
                            fontFamily = FontFamily.SansSerif,
                            fontSize = 12.sp,
                            color = Zinc500,
                            lineHeight = 16.sp
                        )
                    }
                } else {
                    // Single Rekening Card Display
                    rekeningUtama?.let { item ->
                        SingleRekeningCard(
                            item = item,
                            onEdit = { openFormForEdit() },
                            onDelete = { showDeleteConfirm = true }
                        )
                    }
                }
            }
        }

        // ─── 5. MODAL DIALOG HAPUS REKENING ───
        if (showDeleteConfirm) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.4f))
                    .padding(20.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(2.dp))
                        .background(Color.White)
                        .border(BorderStroke(1.dp, Zinc200), RoundedCornerShape(2.dp))
                        .padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Text(
                        text = "LEPAS TAUTAN REKENING",
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        color = Slate950,
                        letterSpacing = 0.5.sp
                    )

                    Text(
                        text = "Apakah Anda yakin ingin menghapus rekening ${rekeningUtama?.namaBank} (${rekeningUtama?.nomorRekening})? Anda harus menautkan ulang rekening baru untuk penarikan saldo.",
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 12.sp,
                        color = Zinc600,
                        lineHeight = 18.sp
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .height(44.dp)
                                .clip(RoundedCornerShape(2.dp))
                                .background(Color.White)
                                .border(BorderStroke(1.dp, Zinc200), RoundedCornerShape(2.dp))
                                .clickable { showDeleteConfirm = false },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "BATAL",
                                fontFamily = FontFamily.SansSerif,
                                fontWeight = FontWeight.Bold,
                                fontSize = 11.sp,
                                color = Zinc600,
                                letterSpacing = 0.5.sp
                            )
                        }

                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .height(44.dp)
                                .clip(RoundedCornerShape(2.dp))
                                .background(Color(0xFFE11D48))
                                .clickable {
                                    rekeningUtama = null
                                    showDeleteConfirm = false
                                    resetForm()
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "YA, LEPAS TAUTAN",
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
    }
}