package com.rishika.fireapp.data

data class CDoc(
    val uid: String = "",
    val url: String = "",
    val name: String = "",
    val mimeType: String = "",
    val timestamp: Long = System.currentTimeMillis()
)