package com.example.burungkurirapp.ui.constant.types

data class InformasiKendaraanKurir(
    val Id: Long,
    val IdKurir: Long,
    val JenisKendaraan: String,
    val NamaKendaraan: String,
    val RodaKendaraan: String,
    val InformasiStnk: Boolean,
    val InformasiBpkb: Boolean,
    val NomorRangka: String?,
    val NomorMesin: String?,
    val Status: String,
    val CreatedAt: String,
    val UpdatedAt: String,

    val fotoKendaraan: String?,
    val fotoBpkb: String?,
    val fotoSTNK: String?,
)

