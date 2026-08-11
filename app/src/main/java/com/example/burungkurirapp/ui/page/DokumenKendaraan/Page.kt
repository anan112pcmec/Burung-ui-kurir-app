package com.example.burungkurirapp.ui.page.DokumenKendaraan

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddAPhoto
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.TwoWheeler
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.burungkurirapp.ui.constant.color.*

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun DokumenKendaraanPage() {
    // ─── FORM STATES (Direct mapping to InformasiKendaraanKurir GORM)
    var jenisKendaraan by remember { mutableStateOf("Motor") } // 'Motor' / 'Mobil'
    var namaKendaraan by remember { mutableStateOf("Honda Vario 160 CC") }
    var rodaKendaraan by remember { mutableStateOf("2 Roda") } // '2 Roda' / '3 Roda' / '4 Roda'
    var noRangka by remember { mutableStateOf("MH1JM8112KK980123") }
    var noMesin by remember { mutableStateOf("JM81E1980123") }
    var hasStnk by remember { mutableStateOf(true) }
    var hasBpkb by remember { mutableStateOf(true) }
    var statusPerizinan by remember { mutableStateOf("Pending") } // 'Pending' / 'Approved' / 'Rejected'

    // Mock Upload Photo States
    var isFotoKendaraanUploaded by remember { mutableStateOf(false) }
    var isFotoStnkUploaded by remember { mutableStateOf(false) }
    var isFotoBpkbUploaded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // ─── 1. HEADER & STATUS PERIZINAN BADGE ───
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "DOKUMEN KENDARAAN",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = Slate950,
                    letterSpacing = 1.sp
                )
                Text(
                    text = "INFORMASI FISIK & LEGALITAS OPERASIONAL",
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 8.sp,
                    color = Zinc400
                )
            }

            // Status Badge
            Box(
                modifier = Modifier
                    .background(
                        when (statusPerizinan) {
                            "Approved" -> Teal600
                            "Rejected" -> Color(0xFFE11D48)
                            else -> Teal100
                        },
                        RoundedCornerShape(2.dp)
                    )
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            ) {
                Text(
                    text = statusPerizinan.uppercase(),
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 8.sp,
                    color = Color.White
                )
            }
        }

        Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(Zinc100))

        // ─── 2. SECTION 1: SPESIFIKASI UTAMA KENDARAAN ───
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Text(
                text = "01. DETAIL KENDARAAN",
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                fontSize = 9.sp,
                color = Zinc400,
                letterSpacing = 1.sp
            )

            // Selector Jenis Kendaraan (Motor / Mobil)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                listOf("Motor", "Mobil").forEach { item ->
                    val isSelected = jenisKendaraan == item
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(38.dp)
                            .background(if (isSelected) Slate950 else Zinc50, RoundedCornerShape(2.dp))
                            .border(BorderStroke(1.dp, if (isSelected) Slate950 else Zinc200), RoundedCornerShape(2.dp))
                            .clickable { jenisKendaraan = item },
                        contentAlignment = Alignment.Center
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = if (item == "Motor") Icons.Default.TwoWheeler else Icons.Default.DirectionsCar,
                                contentDescription = null,
                                tint = if (isSelected) Color.White else Zinc600,
                                modifier = Modifier.size(14.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = item.uppercase(),
                                fontFamily = FontFamily.SansSerif,
                                fontWeight = FontWeight.Bold,
                                fontSize = 10.sp,
                                color = if (isSelected) Color.White else Zinc600
                            )
                        }
                    }
                }
            }

            // Input Nama Kendaraan
            CustomInputField(
                label = "NAMA / MERK KENDARAAN",
                value = namaKendaraan,
                onValueChange = { namaKendaraan = it },
                placeholder = "Contoh: Honda Vario 160 / Gran Max"
            )

            // Selector Roda Kendaraan
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Text(
                    text = "KATEGORI RODA",
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 8.sp,
                    color = Zinc400,
                    fontWeight = FontWeight.Bold
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    listOf("2 Roda", "3 Roda", "4 Roda").forEach { option ->
                        val isSelected = rodaKendaraan == option
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .height(32.dp)
                                .background(if (isSelected) Slate950 else Color.White, RoundedCornerShape(2.dp))
                                .border(BorderStroke(1.dp, if (isSelected) Slate950 else Zinc200), RoundedCornerShape(2.dp))
                                .clickable { rodaKendaraan = option },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = option.uppercase(),
                                fontFamily = FontFamily.SansSerif,
                                fontWeight = FontWeight.Bold,
                                fontSize = 9.sp,
                                color = if (isSelected) Color.White else Zinc600
                            )
                        }
                    }
                }
            }
        }

        // ─── 3. SECTION 2: LEGALITAS & NOMOR IDENTITAS ───
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Text(
                text = "02. MESIN & KEPEMILIKAN",
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                fontSize = 9.sp,
                color = Zinc400,
                letterSpacing = 1.sp
            )

            CustomInputField(
                label = "NOMOR RANGKA (VIN)",
                value = noRangka,
                onValueChange = { noRangka = it },
                placeholder = "Masukkan No. Rangka sesuai STNK"
            )

            CustomInputField(
                label = "NOMOR MESIN",
                value = noMesin,
                onValueChange = { noMesin = it },
                placeholder = "Masukkan No. Mesin"
            )

            // Toggle Boolean Checkbox STNK & BPKB
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                BooleanCheckboxCard(
                    modifier = Modifier.weight(1f),
                    label = "STNK AKTIF",
                    checked = hasStnk,
                    onCheckedChange = { hasStnk = it }
                )
                BooleanCheckboxCard(
                    modifier = Modifier.weight(1f),
                    label = "BPKB ADA",
                    checked = hasBpkb,
                    onCheckedChange = { hasBpkb = it }
                )
            }
        }

        // ─── 4. SECTION 3: UPLOAD FOTO & MEDIA ───
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Text(
                text = "03. LAMPIRAN FOTO DOKUMEN",
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                fontSize = 9.sp,
                color = Zinc400,
                letterSpacing = 1.sp
            )

            // Upload Box 1: Foto Kendaraan
            UploadMediaBox(
                title = "FOTO KENDARAAN",
                pathName = "/media_informasi_kendaraan_kurir_kendaraan_foto/",
                isUploaded = isFotoKendaraanUploaded,
                onUploadClick = { isFotoKendaraanUploaded = !isFotoKendaraanUploaded }
            )

            // Upload Box 2: Foto STNK
            UploadMediaBox(
                title = "FOTO STNK (ASLI)",
                pathName = "/media_informasi_kendaraan_kurir_stnk_foto/",
                isUploaded = isFotoStnkUploaded,
                onUploadClick = { isFotoStnkUploaded = !isFotoStnkUploaded }
            )

            // Upload Box 3: Foto BPKB
            UploadMediaBox(
                title = "FOTO BPKB (ASLI)",
                pathName = "/media_informasi_kendaraan_kurir_bpkb_foto/",
                isUploaded = isFotoBpkbUploaded,
                onUploadClick = { isFotoBpkbUploaded = !isFotoBpkbUploaded }
            )
        }

        Spacer(modifier = Modifier.height(6.dp))

        // ─── 5. SUBMIT BUTTON ───
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(44.dp)
                .background(Slate950, RoundedCornerShape(2.dp))
                .clickable { /* Trigger Sync/Post to Backend */ }
                .padding(vertical = 12.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "SIMPAN DOKUMEN KENDARAAN",
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                fontSize = 11.sp,
                color = Color.White,
                letterSpacing = 1.sp
            )
        }
    }
}

// ─── REUSABLE UI COMPONENTS ───

@Composable
private fun CustomInputField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String
) {
    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        Text(
            text = label,
            fontFamily = FontFamily.SansSerif,
            fontSize = 8.sp,
            color = Zinc400,
            fontWeight = FontWeight.Bold
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(38.dp)
                .background(Zinc50, RoundedCornerShape(2.dp))
                .border(BorderStroke(1.dp, Zinc200), RoundedCornerShape(2.dp))
                .padding(horizontal = 10.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                decorationBox = { innerTextField ->
                    if (value.isEmpty()) {
                        Text(
                            text = placeholder,
                            fontFamily = FontFamily.SansSerif,
                            fontSize = 10.sp,
                            color = Zinc400
                        )
                    }
                    innerTextField()
                }
            )
        }
    }
}

@Composable
private fun BooleanCheckboxCard(
    modifier: Modifier = Modifier,
    label: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = modifier
            .height(38.dp)
            .background(Color.White, RoundedCornerShape(2.dp))
            .border(BorderStroke(1.dp, Zinc200), RoundedCornerShape(2.dp))
            .clickable { onCheckedChange(!checked) }
            .padding(horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            fontSize = 9.sp,
            color = Slate950
        )
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange,
            colors = CheckboxDefaults.colors(
                checkedColor = Slate950,
                uncheckedColor = Zinc400,
                checkmarkColor = Color.White
            ),
            modifier = Modifier.size(16.dp)
        )
    }
}

@Composable
private fun UploadMediaBox(
    title: String,
    pathName: String,
    isUploaded: Boolean,
    onUploadClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Zinc50, RoundedCornerShape(2.dp))
            .border(BorderStroke(1.dp, Zinc200), RoundedCornerShape(2.dp))
            .padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                fontSize = 9.sp,
                color = Slate950
            )
            Text(
                text = pathName,
                fontFamily = FontFamily.SansSerif,
                fontSize = 7.sp,
                color = Zinc400
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
                .background(if (isUploaded) Color.White else Zinc100, RoundedCornerShape(2.dp))
                .border(
                    BorderStroke(1.dp, if (isUploaded) Teal400 else Zinc200),
                    RoundedCornerShape(2.dp)
                )
                .clickable { onUploadClick() },
            contentAlignment = Alignment.Center
        ) {
            if (isUploaded) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = null,
                        tint = Teal400,
                        modifier = Modifier.size(14.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "FILE TERUPLOAD • KLIK UNTUK UBAH",
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold,
                        fontSize = 9.sp,
                        color = Teal400
                    )
                }
            } else {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.AddAPhoto,
                        contentDescription = null,
                        tint = Zinc400,
                        modifier = Modifier.size(14.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "+ UNGGAH FOTO (JPG/PNG)",
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold,
                        fontSize = 9.sp,
                        color = Zinc400
                    )
                }
            }
        }
    }
}