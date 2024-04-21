package com.example.recyclerview

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Suppress("DEPRECATED_ANNOTATION")
@Parcelize
data class Card(
    val name: String,
    val cardN: String,
    val cardType: String,
    val period: String,
    val price: Double,
    val cardManager: String, //카드사
    val cardViewType: MuiltiViewEnum
) : Parcelable

