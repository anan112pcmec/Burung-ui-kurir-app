package com.example.burungkurirapp.ui.page.Alamat.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.burungkurirapp.ui.constant.color.Slate950
import com.example.burungkurirapp.ui.constant.color.Zinc200
import com.example.burungkurirapp.ui.constant.color.Zinc50
import com.example.burungkurirapp.ui.constant.color.Zinc600
import com.example.burungkurirapp.ui.page.Alamat.AlamatKurirItem

// ─── KOMPONEN 3: FORM INPUT / EDIT ALAMAT ───
@Composable
fun FormAlamatSection(
    initialData: AlamatKurirItem?,
    onCancel: () -> Unit,
    onSubmit: (AlamatKurirItem) -> Unit
) {
    var panggilan by remember { mutableStateOf(initialData?.panggilanAlamat ?: "") }
    var telp by remember { mutableStateOf(initialData?.nomorTelephone ?: "") }
    var namaAlamat by remember { mutableStateOf(initialData?.namaAlamat ?: "") }
    var kota by remember { mutableStateOf(initialData?.kota ?: "") }
    var provinsi by remember { mutableStateOf(initialData?.provinsi ?: "") }
    var kodeNegara by remember { mutableStateOf(initialData?.kodeNegara ?: "ID") }
    var kodePos by remember { mutableStateOf(initialData?.kodePos ?: "") }
    var deskripsi by remember { mutableStateOf(initialData?.deskripsi ?: "") }
    var lat by remember { mutableStateOf(initialData?.latitude?.toString() ?: "-6.1754") }
    var lng by remember { mutableStateOf(initialData?.longitude?.toString() ?: "106.8272") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Zinc50, RoundedCornerShape(2.dp))
            .border(BorderStroke(1.dp, Slate950), RoundedCornerShape(2.dp))
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(
            text = if (initialData == null) "FORM INPUT ALAMAT BARU" else "FORM UBAH ALAMAT",
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.Bold,
            fontSize = 10.sp,
            color = Slate950,
            letterSpacing = 1.sp
        )

        CustomInputField("PANGGILAN ALAMAT (LABEL)", panggilan, { panggilan = it }, "Contoh: RUMAH / BASECAMP")
        CustomInputField("NOMOR TELEPON", telp, { telp = it }, "Contoh: 08123456789", KeyboardType.Phone)
        CustomInputField("ALAMAT LENGKAP", namaAlamat, { namaAlamat = it }, "Nama jalan, nomor rumah, RT/RW")

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Box(modifier = Modifier.weight(1f)) { CustomInputField("KOTA", kota, { kota = it }, "Kota/Kab") }
            Box(modifier = Modifier.weight(1f)) { CustomInputField("PROVINSI", provinsi, { provinsi = it }, "Provinsi") }
        }

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Box(modifier = Modifier.weight(1f)) { CustomInputField("KODE POS", kodePos, { kodePos = it }, "5 digit", KeyboardType.Number) }
            Box(modifier = Modifier.weight(1f)) { CustomInputField("KODE NEGARA", kodeNegara, { kodeNegara = it.uppercase() }, "ID") }
        }

        CustomInputField("DESKRIPSI / PATOKAN", deskripsi, { deskripsi = it }, "Warna pagar, dekat fasilitas umum, dll.")

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Box(modifier = Modifier.weight(1f)) { CustomInputField("LATITUDE", lat, { lat = it }, "-6.xxx") }
            Box(modifier = Modifier.weight(1f)) { CustomInputField("LONGITUDE", lng, { lng = it }, "106.xxx") }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(36.dp)
                    .background(Color.White, RoundedCornerShape(2.dp))
                    .border(BorderStroke(1.dp, Zinc200), RoundedCornerShape(2.dp))
                    .clickable { onCancel() },
                contentAlignment = Alignment.Center
            ) {
                Text("BATAL", fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold, fontSize = 9.sp, color = Zinc600)
            }

            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(36.dp)
                    .background(Slate950, RoundedCornerShape(2.dp))
                    .clickable {
                        if (panggilan.isNotBlank() && namaAlamat.isNotBlank()) {
                            onSubmit(
                                AlamatKurirItem(
                                    id = initialData?.id ?: System.currentTimeMillis(),
                                    panggilanAlamat = panggilan,
                                    nomorTelephone = telp,
                                    namaAlamat = namaAlamat,
                                    kota = kota,
                                    provinsi = provinsi,
                                    kodeNegara = kodeNegara,
                                    kodePos = kodePos,
                                    deskripsi = deskripsi,
                                    latitude = lat.toDoubleOrNull() ?: 0.0,
                                    longitude = lng.toDoubleOrNull() ?: 0.0
                                )
                            )
                        }
                    },
                contentAlignment = Alignment.Center
            ) {
                Text("SIMPAN ALAMAT", fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold, fontSize = 9.sp, color = Color.White)
            }
        }
    }
}