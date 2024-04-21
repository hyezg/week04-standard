package com.example.recyclerview

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.databinding.ActivityCardsListBinding

class CardListActivity : AppCompatActivity() {

    private val binding: ActivityCardsListBinding by lazy {
        ActivityCardsListBinding.inflate(layoutInflater)
    }

    private val cardsAdapter: CardsAdapter by lazy {
        CardsAdapter { card ->
            adapterOnClick(card)
            //onClick 코드 블록 실행
            //detailactivity 에 넘기기\
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        //DataSource 클래스의 인스턴스를 얻음
        val cardList = DataSource.getDataSource().getCardList()
        cardsAdapter.cardList = cardList

        with(binding.recyclerView) {
            adapter = cardsAdapter
            layoutManager = LinearLayoutManager(this@CardListActivity)
        }
    }

    private fun adapterOnClick(card: Card) {
        val intent = Intent(this, DetailActivity()::class.java)
        val bundle = Bundle().apply {
            putParcelable(DetailActivity.EXTRA_CARD, card)
        }
        intent.putExtras(bundle)
        startActivity(intent)
    }

}