package com.example.burungkurirapp.ui.constant.types

data class Kurir(
    val Id: Int,
    val Nama: String,
    val Username: String,
    val Email: String,
    val Jenis: String,
    val PasswordHash: String,
    val Deskripsi: String,
    val StatusKurir: String,
    val StatusBid: String,
    val VerifierKurir: Boolean,
    val TipeKendaraan: String,
    val CreatedAt: String,
    val UpdatedAt: String
)