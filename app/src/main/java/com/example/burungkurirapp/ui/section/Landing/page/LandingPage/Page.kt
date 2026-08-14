package com.example.burungkurirapp.ui.section.Landing.page

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.HorizontalDivider
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
import com.example.burungkurirapp.ui.constant.prefix.AuthSectionPrefix
import com.example.burungkurirapp.ui.section.LocalUiFlowState

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LandingPagePage(

) {
    val state = LocalUiFlowState.current
    var isAgeAndKtpChecked by remember { mutableStateOf(false) }
    var isTermsChecked by remember { mutableStateOf(false) }

    val canProceed = isAgeAndKtpChecked && isTermsChecked

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // ─── AREA HERO / ANIMASI (Sesuai struktur awal: 0.25f) ───
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.25f)
                .background(Zinc100),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = "🖼️ [AREA HERO / ANIMASI LOTTIE]",
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Zinc400
                )
                Text(
                    text = "Ilustrasi kurir burung / banner interaktif",
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 11.sp,
                    color = Zinc400
                )
            }
        }

        // ─── AREA KONTEN UTAMA (Berbasis Tipografi & Spasi Clean) ───
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.75f)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp, vertical = 20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            // 1. SAMBUTAN UTAMA
            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Text(
                    text = "Ingin Menjadi Mitra Kurir Burung?",
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Slate950,
                    lineHeight = 28.sp
                )
                Text(
                    text = "Bergabunglah dengan jaringan pengiriman terdepan. Nikmati fleksibilitas waktu kerja, pendapatan harian kompetitif, serta skema insentif yang transparan. Sebelum memulai pendaftaran, mohon baca seluruh ketentuan di bawah ini.",
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 13.sp,
                    color = Zinc600,
                    lineHeight = 19.sp
                )
            }

            HorizontalDivider(color = Zinc200, thickness = 1.dp)

            // 2. PEMBERITAHUAN & PROSES VERIFIKASI (Narasi Panjang)
            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Text(
                    text = "PEMBERITAHUAN & PROSES SELEKSI",
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = Slate950,
                    letterSpacing = 0.5.sp
                )
                Text(
                    text = "Proses peninjauan dokumen pendaftaran membutuhkan waktu maksimal 1x24 jam kerja. Seluruh berkas yang Anda unggah harus merupakan dokumen asli (bukan fotokopi), masih berlaku, serta dapat terbaca jelas tanpa pantulan cahaya. Pendaftaran mitra Kurir Burung sepenuhnya GRATIS dan tidak dipungut biaya apapun. Harap waspada terhadap pihak yang mengatasnamakan manajemen dan meminta imbalan sejumlah uang.",
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 12.sp,
                    color = Zinc600,
                    lineHeight = 18.sp
                )
            }

            // 3. PERSYARATAN DOKUMEN & KUALIFIKASI (Teks Naratif Berurutan)
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(
                    text = "PERSYARATAN KUALIFIKASI DOKUMEN",
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = Slate950,
                    letterSpacing = 0.5.sp
                )
                Text(
                    text = "1. Warga Negara Indonesia (WNI) berusia minimal 18 tahun dan maksimal 55 tahun pada saat pendaftaran.\n" +
                            "2. Memiliki Kartu Tanda Penduduk (e-KTP) asli yang terdaftar resmi di Disdukcapil.\n" +
                            "3. Memiliki Surat Izin Mengemudi (SIM C / C1) aktif dan STNK sepeda motor dengan pajak jalan tidak menunggak.\n" +
                            "4. Memiliki smartphone Android (minimal OS v8.0, RAM 3GB, dan GPS berfungsi akurat).\n" +
                            "5. Memiliki rekening bank pribadi (BCA, Mandiri, BRI, atau BNI) sesuai nama pada e-KTP untuk pencairan saldo insentif harian.",
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 12.sp,
                    color = Zinc700,
                    lineHeight = 20.sp
                )
            }

            // 4. KODE ETIK & KETENTUAN OPERASIONAL
            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Text(
                    text = "KEBIJAKAN PRIVASI & KODE ETIK MITRA",
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = Slate950,
                    letterSpacing = 0.5.sp
                )
                Text(
                    text = "Sebagai mitra operasional, Anda menyetujui untuk selalu menjaga keamanan barang pelanggan, mematuhi Service Level Agreement (SLA) waktu pengantaran, menggunakan atribut resmi saat bertugas, serta menjaga kerahasiaan data pribadi penerima paket. Pelanggaran berat seperti manipulasi lokasi GPS, perusakan paket, atau perilaku tidak sopan dapat berakibat pada pemutusan kemitraan secara permanen.",
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 12.sp,
                    color = Zinc600,
                    lineHeight = 18.sp
                )
            }

            // 5. PERSETUJUAN & CHECKBOX
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { isAgeAndKtpChecked = !isAgeAndKtpChecked },
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Checkbox(
                        checked = isAgeAndKtpChecked,
                        onCheckedChange = { isAgeAndKtpChecked = it },
                        colors = CheckboxDefaults.colors(
                            checkedColor = Slate950,
                            uncheckedColor = Zinc400
                        )
                    )
                    Text(
                        text = "Saya berusia 18+ tahun, memiliki e-KTP sah, SIM C aktif, dan memenuhi seluruh kualifikasi dokumen di atas.",
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 11.sp,
                        color = Slate950,
                        lineHeight = 16.sp
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { isTermsChecked = !isTermsChecked },
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Checkbox(
                        checked = isTermsChecked,
                        onCheckedChange = { isTermsChecked = it },
                        colors = CheckboxDefaults.colors(
                            checkedColor = Slate950,
                            uncheckedColor = Zinc400
                        )
                    )
                    Text(
                        text = "Saya telah membaca, memahami, dan menyetujui seluruh Syarat, Ketentuan Kemitraan, Kebijakan Privasi, serta Kode Etik Operasional.",
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 11.sp,
                        color = Slate950,
                        lineHeight = 16.sp
                    )
                }
            }

            // 6. ACTION BUTTONS
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .background(
                            if (canProceed) Slate950 else Zinc200,
                            RoundedCornerShape(6.dp)
                        )
                        .clickable(enabled = canProceed) { state.navController.navigate("$AuthSectionPrefix/SignUp") },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "DAFTAR SEBAGAI MITRA KURIR",
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        color = if (canProceed) Color.White else Zinc400,
                        letterSpacing = 0.5.sp
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { state.navController.navigate("$AuthSectionPrefix/Login")}
                        .padding(vertical = 6.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Sudah mendaftar sebagai mitra? ",
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 12.sp,
                        color = Zinc600
                    )
                    Text(
                        text = "Masuk Akun",
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Slate950
                    )
                }
            }
        }
    }
}