package com.example.burungkurirapp.ui.constant.types

data class NotificationKurir(
    val IdKurir: Long,
    val Pengirim: String,
    val Judul: String,
    val Pesan: String,
    val Pop: Float,
    val Archive: Boolean,
    val Inbox: Boolean,
    val Activity: Boolean,
    val CreatedAt: String,
    val ExpiredAt: String,
    val Data: DataInfo
) {
    data class DataInfo(
        val Metadata: Map<String, Any>,
        val Special: Any
    )
}