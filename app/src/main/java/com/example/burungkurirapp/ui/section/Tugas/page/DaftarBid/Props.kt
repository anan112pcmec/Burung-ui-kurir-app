package com.example.burungkurirapp.ui.section.Tugas.page.DaftarBid

import com.example.burungkurirapp.ui.constant.types.BidKurirData
import com.example.burungkurirapp.ui.constant.types.Pengiriman
import com.example.burungkurirapp.ui.constant.types.PengirimanEks

data class TugasDaftarBidProps(
    val dataBidKurir: BidKurirData,
    val listPengiriman: List<Pengiriman>?,
    val listPengirimanEks: List<PengirimanEks>?
)