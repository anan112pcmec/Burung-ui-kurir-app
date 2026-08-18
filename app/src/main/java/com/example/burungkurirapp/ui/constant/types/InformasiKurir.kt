package com.example.burungkurirapp.ui.constant.types

data class InformasiKurir(
    val Id: Int,
    val IdKurir: Int,
    val TanggalLahir: String,
    val Alasan: String,
    val InformasiKtp: Boolean,
    val InformasiSim: Boolean,
    val Status: String,
    val CreatedAt: String,
    val UpdatedAt: String,

    val urlFotoKtp: String?,
    val urlFotoSim: String?
)