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

        var cardItem = intent.getParcelableExtra<Card>(EXTRA_CARD)

        binding.tvDName.text = cardItem!!.name
        binding.dName.text = cardItem!!.name
        binding.tvDPeriod.text = cardItem.period
        binding.tvDCardN.text = cardItem.cardN
        binding.tvDcardViewType.text = cardItem.cardViewType.name

    }
}