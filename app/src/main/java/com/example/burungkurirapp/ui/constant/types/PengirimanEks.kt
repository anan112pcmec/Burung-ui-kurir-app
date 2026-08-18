package com.example.burungkurirapp.ui.constant.types

data class PengirimanEks(
    val Id: Int,
    val IdTransaksi: Int,
    val IdSeller: Int,
    val IdAlamatGudang: Int,
    val IdAlamatEkspedis: Int,
    val IdKurir: Int,
    val BeratBarang:Int,
    val KendaraanRequired: String,
    val JenisPengiriman: String,
    val JarakTempuh: String,
    val KurirPaid: String,
    val Status: String,
    val CreatedAt: String,
)