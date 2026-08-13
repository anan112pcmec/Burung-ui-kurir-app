package com.example.burungkurirapp.ui.section.Home.page.DokumenInformasi

import android.widget.Space
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddAPhoto
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.burungkurirapp.ui.constant.color.Slate900
import com.example.burungkurirapp.ui.constant.color.Teal700
import com.example.burungkurirapp.ui.constant.color.Zinc400

//buat si ngentot by
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.burungkurirapp.ui.constant.color.Slate950
import com.example.burungkurirapp.ui.constant.color.Teal500
import com.example.burungkurirapp.ui.constant.color.Teal600
import com.example.burungkurirapp.ui.constant.color.Zinc100
import com.example.burungkurirapp.ui.constant.color.Zinc200
import com.example.burungkurirapp.ui.constant.color.Zinc300
import com.example.burungkurirapp.ui.constant.color.Zinc50
import com.example.burungkurirapp.ui.section.Home.page.DokumenInformasi.component.CheckboxCard
import com.example.burungkurirapp.ui.section.Home.page.DokumenInformasi.component.CustomTextAreaField
import com.example.burungkurirapp.ui.section.Home.page.Rekening.component.CustomInputField

@Preview(showBackground = true)
@Composable
fun DokumenInformasiPage(){
    var tanggalLahir by remember {mutableStateOf("2007-08-12")}
    var alasan by remember {mutableStateOf("Mencari penghasilan dari sini")}
    var hasKtp by remember {mutableStateOf(true)}
    var hasSim by remember {mutableStateOf(true)}
    var statusPerizinan by remember { mutableStateOf("Approved") }

    var isFotoKtpUploaded by remember { mutableStateOf(true)}

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
            .padding(15.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column {
                Text(
                    text = "Dokumen Informasi Kurir",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Slate900,
                    letterSpacing = 0.5.sp,
                )

                Spacer(Modifier.height(16.dp))

                Text(
                    text = "Verifikasi Data Diri & Lisensi Operasional",
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 10.sp,
                    color = Zinc400,
                )
            }

            Box(
              modifier = Modifier
                  .background(
                      when(statusPerizinan){
                          "Approved" -> Teal700
                          "Rejected" -> Slate900
                          else -> Zinc200
                      },
                      RoundedCornerShape(2.dp)
                  )
                  .padding(horizontal = 8.dp, vertical = 4.dp)
            ){
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

        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Text(
                text = "Profil Identitas",
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                fontSize = 9.sp,
                color = Zinc400,
                letterSpacing = 0.8.sp
            )

            CustomInputField(
                label = "Tanggal Lahir (YYYY-MM-DD)",
                value = tanggalLahir,
                onValueChange = { tanggalLahir = it },
                placeholder = "YYYY-MM-DD"
            )

            CustomTextAreaField(
                label = "Alasan Bergabung / Catatan",
                value = alasan,
                onValueChange = { alasan = it },
                placeholder = "Tuliskan alasan bergabung menjadi mitra kurir..."
            )
        }


        Spacer(Modifier.height(12.dp))
            Column(verticalArrangement =  Arrangement.spacedBy(10.dp)) {
                Text(
                    text = "Kepemilikan Dokumen",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 9.sp,
                    color = Zinc400,
                    letterSpacing = 1.sp
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    CheckboxCard (
                        label = "KTP AKTIF",
                        isCheck = hasKtp,
                        onCheckedChange = {hasKtp = it}
                    )
                    CheckboxCard(
                        label = "SIM C / A AKTIF",
                        isCheck = hasSim,
                        onCheckedChange = {hasSim = it}
                    )
                }
            }

        Spacer(Modifier.height(12.dp))
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Text(
                text = "Lampiran Identitas",
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                fontSize = 9.sp,
                color = Zinc400,
                letterSpacing = 1.sp
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Zinc50, RoundedCornerShape(2.dp))
                    .border(BorderStroke(1.dp, Zinc200), RoundedCornerShape(2.dp))
                    .padding(10.dp),
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ){
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement =  Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "FOTO KTP (ASLI)",
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Bold,
                        fontSize = 9.sp,
                        color = Slate950
                    )
                    Text(
                        text = "/media_informasi_kurir_ktp_foto/",
                        fontFamily = FontFamily.Monospace,
                        fontSize = 7.sp,
                        color = Zinc400
                    )
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(74.dp)
                        .background(if (isFotoKtpUploaded) Color.White else Zinc200,
                            RoundedCornerShape(2.dp) )
                        .border(
                            BorderStroke(1.dp, if (isFotoKtpUploaded) Teal500 else Zinc300),
                            RoundedCornerShape(2.dp)
                        )
                        .clickable{isFotoKtpUploaded = !isFotoKtpUploaded},
                    contentAlignment = Alignment.Center
                ) {
                    if (isFotoKtpUploaded){
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Check,
                                contentDescription = null,
                                tint = Teal600,
                                modifier = Modifier.size(14.dp)
                            )
                            Spacer(Modifier.width(6.dp))
                            Text(
                                text = "Ktp Berhasil Di Upload • Klik Untuk Ubah",
                                fontFamily = FontFamily.SansSerif,
                                fontWeight = FontWeight.Bold,
                                fontSize = 9.sp,
                                color = Teal600
                            )
                        }
                    } else {
                        Row(verticalAlignment =  Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.AddAPhoto,
                                contentDescription = "Tambahkan Foto",
                                tint = Zinc400,
                                modifier = Modifier.size(14.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "Unggah Foto KTP (JPG/PNG)",
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

        Spacer(modifier= Modifier.height(6.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(44.dp)
                .background(Slate950, RoundedCornerShape(2.dp))
                .clickable{/* Trigger API submit */}
                .padding(vertical = 12.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "SIMPAN INFORMASI KURIR",
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                fontSize = 11.sp,
                color = Color.White,
                letterSpacing = 1.sp
            )
        }


    }
}
