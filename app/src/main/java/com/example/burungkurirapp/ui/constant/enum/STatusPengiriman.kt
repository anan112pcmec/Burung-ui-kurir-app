package com.example.burungkurirapp.ui.constant.enum

enum class StatusPengiriman(val value: String) {
    WAITING("Waiting"),
    PICKED_UP("Picked Up"),
    DI_PERJALANAN("Diperjalanan"),
    SAMPAI("Sampai"),
    TROUBLE("Trouble");

    // Fungsi opsional untuk mengubah kembali dari string atau menampilkan nilai
    override fun toString(): String {
        return value
    }
}