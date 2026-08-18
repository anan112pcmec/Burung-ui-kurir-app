package com.example.burungkurirapp.ui.constant.types

data class BidKurirData(
    val Id: Int,
    val IdKurir: Int,
    val JenisPengiriman: String,
    val Mode: String,
    val Provinsi: String,
    val Kota: String,
    val IsEkspedisi: Boolean,
    val Alamat: String,
    val Longitude: Double,
    val Latitude: Double,
    val MaxKg: Int,
    val SlotTersisa: Int,
    val Dimulai: String,
    val Selesai: String,
    val CreatedAt: String,
    val UpdatedAt: String,

    val ListPengiriman: List<Pengiriman>?,
    val ListPengirimanEks: List<PengirimanEks>?
)
