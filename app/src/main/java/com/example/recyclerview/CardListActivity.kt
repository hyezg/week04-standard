package com.example.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.recyclerview.databinding.ActivityCardsListBinding

class CardListActivity : AppCompatActivity() {
    private val binding: ActivityCardsListBinding by lazy {
        ActivityCardsListBinding.inflate(layoutInflater)
    }

    private val cardsAdapter : CardsAdapter by lazy {
        CardsAdapter {
            //onClick 코드 블록 실행
            //detailactivity 에 넘김
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)
        cardsAdapter.cardList = DataSource.getDataSource().getCardList()
        with(binding.recyclerView) {
            adapter = cardsAdapter
        }

    }
}