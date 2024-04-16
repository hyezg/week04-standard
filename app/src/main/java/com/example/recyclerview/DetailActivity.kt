package com.example.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.recyclerview.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_CARD: String = "extra_card"
    }

    private val binding: ActivityDetailBinding by lazy {
        ActivityDetailBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val intent = intent
        val cardName = intent.extras?.getString(EXTRA_CARD) ?: ""
        val cardData = DataSource.getDataSource().getCardForName(cardName)

        binding.tvDName.text = cardData.name
        binding.tvDCardN.text = cardData.cardN
        binding.tvDPeriod.text = cardData.period
        binding.tvDPrice.text = cardData.price

    }
}