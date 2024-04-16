package com.example.recyclerview

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.recyclerview.databinding.ActivityCardsListBinding

class CardListActivity : AppCompatActivity() {
    private val binding: ActivityCardsListBinding by lazy {
        ActivityCardsListBinding.inflate(layoutInflater)
    }

    private val cardsAdapter: CardsAdapter by lazy {
        CardsAdapter { card ->
            adapterOnClick(card)
            //onClick 코드 블록 실행
            //detailactivity 에 넘기기

            adapterOnClick(card)

            //val bundle = Bundle()
            //bundle.putString("key","value")

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        //DataSource 클래스의 인스턴스를 얻음
        val dataSource = DataSource.getDataSource()
        cardsAdapter.cardList = dataSource.getCardList()

        with(binding.recyclerView) {
            adapter = cardsAdapter
        }
    }

    private fun adapterOnClick(card: Card) {
        val intent = Intent(this, DetailActivity()::class.java)
        intent.putExtra("CARD_NAME", card.name)
        intent.putExtra("CARD_CARD_N", card.cardN)
        intent.putExtra("CARD_PERIOD", card.period)
        intent.putExtra("CARD_PRICE", card.price)
        startActivity(intent)
    }

}