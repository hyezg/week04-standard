package com.example.recyclerview

data class Card(
    val name: String,
    val cardN: String,
    val period: String,
    val price: String,
    val viewtype: Int)
{
    companion object {
        const val BLUE = 0
        const val SKYBLUE = 1
        const val ORANGE = 2

    }
}
