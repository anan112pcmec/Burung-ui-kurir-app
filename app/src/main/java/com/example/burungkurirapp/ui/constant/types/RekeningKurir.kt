package com.example.burungkurirapp.ui.constant.types


data class RekeningKurir(
    val Id: Long,
    val IdKurir: Long,
    val Kurir: Kurir?,
    val NamaBank: String,
    val NomorRekening: String,
    val PemilikRekening: String,
    val CreatedAt: String,
    val UpdatedAt: String,

    // Total Keseluruhan (All-time)
    val PengirimanDisbursmentCount: Int,
    val PemasukanTotal: Long,
    val DisbursmentGagalCount: Int,
    val PendingDisbursmentAmount: Long,

    // Data Per Hari Ini (Today)
    val PengirimanDisbursmentCountHariIni: Int,
    val PemasukanTotalHariIni: Long,
    val DisbursmentGagalCountHariIni: Int,
    val PendingDisbursmentAmountHariIni: Long,

    // Data Per Minggu Ini (This Week)
    val PengirimanDisbursmentCountMingguIni: Int,
    val PemasukanTotalMingguIni: Long,
    val DisbursmentGagalCountMingguIni: Int,
    val PendingDisbursmentAmountMingguIni: Long,

    // Data Per Bulan Ini (This Month)
    val PengirimanDisbursmentCountBulanIni: Int,
    val PemasukanTotalBulanIni: Long,
    val DisbursmentGagalCountBulanIni: Int,
    val PendingDisbursmentAmountBulanIni: Long,

    // Data Per Tahun Ini (This Year)
    val PengirimanDisbursmentCountTahunIni: Int,
    val PemasukanTotalTahunIni: Long,
    val DisbursmentGagalCountTahunIni: Int,
    val PendingDisbursmentAmountTahunIni: Long,

    val listPengirimanTerkaitRek: List<Pengiriman>
)