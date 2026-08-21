package com.example.burungkurirapp.ui.section.Tugas.page.Pengiriman

import com.example.burungkurirapp.ui.constant.enum.STatusPengiriman
import com.example.burungkurirapp.ui.constant.types.Pengiriman

data class TugasPengirimanProps(
    val Id: Long,
    val IdTransaksi: Long,
    val IdSeller: Long,
    val NamaSeller: String,
    val IdPengguna: Long,
    val NamaPengguna: String,
    val IdAlamatGudang: Long,
    val NamaAlamatGudang: String,
    val LongAlamatGudang: Double,
    val LatAlamatGudang: Double,
    val IdAlamatPengguna: Long,
    val NamaAlamatPengguna: String,
    val LongAlamatPengguna: Double,
    val LatAlamatPengguna: Double,
    val IdBarangInduk: Long,
    val NamaBarangInduk: String,
    val IdKategoriBarang: Long,
    val NamaKategoriBarang: String,
    val UrlFotoKategoriBarang: List<String>,
    val IdKurir: Long,
    val KodeOrderSistem: String,
    val Catatan: String,
    val BeratBarang: Short,
    val KendaraanRequired: String,
    val JenisPengiriman: String,
    val JarakTempuh: String,
    val KurirPaid: Long,
    val Status: STatusPengiriman,


)