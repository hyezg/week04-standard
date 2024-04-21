package com.example.recyclerview

fun cardList(): List<Card> {
    return listOf(
        Card(
            name = "Anderson",
            cardN = "2423 3581 9503",
            cardType = "A Debit Card",
            period = "21/24",
            price = 3100.30,
            cardManager = "Visa",
            MuiltiViewEnum.BLUE
        ),
        Card(
            "Jimmy",
            "1234 5678 1234 1111",
            "A Prepaid Card",
            "19/25",
            5431.40,
            "Master",
            MuiltiViewEnum.LIGHTBLUE
        ),
        Card(
            "Hanna",
            "4443 2345 4564 1231",
            "A Credit Card",
            "23/28",
            1030.99,
            "Union",
            MuiltiViewEnum.ORANGE
        )
    )
}