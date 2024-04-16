package com.example.recyclerview

class DataSource {
    companion object {
        private var INSTANCE: DataSource? = null
        fun getDataSource(): DataSource {
            return synchronized(DataSource::class) {
                val newInstance = INSTANCE ?: DataSource()
                INSTANCE = newInstance
                newInstance
            }
        }
    }

    fun getCardList(): List<Card> {
        return cardList()
    }

    fun getCardForName(name: String): Card {
        cardList().let { cards ->
            return cards.first { it.name == name }
        }
    }
}