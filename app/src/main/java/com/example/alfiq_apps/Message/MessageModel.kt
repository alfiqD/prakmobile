package com.example.alfiq_apps.Message

data class MessageModel(
    val senderName: String,
    val messageText: String,
    val avatar: Any // Menggunakan Any agar bisa menerima URL (String) atau Drawable (Int)
)
