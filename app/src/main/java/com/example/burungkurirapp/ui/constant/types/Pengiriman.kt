package com.example.burungkurirapp.ui.constant.types

data class Pengiriman(
    val Id: Int,
    val IdTransaksi: Int,
    val IdSeller: Int,
    val IdAlamatGudang: Int,
    val IdAlamatPengguna: Int,
    val IdKurir: Int,
    val BeratBarang:Int,
    val KendaraanRequired: String,
    val JenisPengiriman: String,
    val JarakTempuh: String,
    val KurirPaid: String,
    val Status: String,
    val CreatedAt: String,

    val Transaksi: Transaksi?,
    val AlamatGudang: AlamatGudang?,
    val AlamatPengguna: AlamatPengguna?
)