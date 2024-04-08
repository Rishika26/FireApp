package com.rishika.fireapp.ui.screens.upload

import com.rishika.fireapp.data.CDoc

enum class UploadStatus {
    IDLE, UPLOADING, SUCCESS, ERROR
}

enum class DocumentStatus {
    LOADING, SUCCESS, ERROR
}
data class DocState(
    val isLoading: Boolean = false,
    val error: String = "",
    val progress: Int = 0,
    val uploadStatus: UploadStatus = UploadStatus.IDLE,
    val documents : List<CDoc> = emptyList(),
    val documentStatus: DocumentStatus = DocumentStatus.LOADING
)
