package ru.trinitydigital.errorhandling.data.model.collections

import android.os.Parcelable

data class RowsItem(
    val created_at: String,
    val icon: String,
    val preview: String,
    val content: String?,
    val id: Int,
    val rank: Int,
    val title: String,
    val updated_at: String
)