package com.example.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.CardItemBinding

class CardsAdapter(private val onClick: (Card) -> Unit) : RecyclerView.Adapter<CardsAdapter.CardViewHolder>() {
    var cardList = listOf<Card>()

    class CardViewHolder(private var binding: CardItemBinding,val onClick: (Card) -> Unit) : RecyclerView.ViewHolder(binding.root) {
        private var currentCard: Card? = null
        init {
            itemView.setOnClickListener{
                currentCard?.let{
                    onClick(it)
                }

            }
        }

        fun bind(card: Card) {
            currentCard = card

            binding.itemName.text = card.name
            binding.itemCardN.text = card.cardN
            binding.itemPeriod.text = card.period
            binding.itemPrice.text = card.price


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false)
        return CardViewHolder(CardItemBinding.bind(view),onClick)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bind(cardList[position])
    }

    override fun getItemCount(): Int {
        return cardList.size
    }
}