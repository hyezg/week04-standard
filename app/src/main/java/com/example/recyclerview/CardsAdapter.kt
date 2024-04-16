package com.example.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.Card.Companion.BLUE
import com.example.recyclerview.Card.Companion.ORANGE
import com.example.recyclerview.Card.Companion.SKYBLUE
import com.example.recyclerview.databinding.CardItem2Binding
import com.example.recyclerview.databinding.CardItem3Binding
import com.example.recyclerview.databinding.CardItemBinding

class CardsAdapter(private val onClick: (Card) -> Unit) :
    RecyclerView.Adapter<CardsAdapter.CardViewHolder>() {
    var cardList = listOf<Card>()

    class CardViewHolder(private var binding: CardItemBinding, val onClick: (Card) -> Unit) :
        RecyclerView.ViewHolder(binding.root) {
        private var currentCard: Card? = null

        init {
            itemView.setOnClickListener {
                currentCard?.let {
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


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardsAdapter.CardViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            BLUE -> {
                val binding = CardItemBinding.inflate(inflater, parent, false)
                BlueCardViewHolder(binding)
            }

            ORANGE -> {
                val binding = CardItemBinding.inflate(inflater, parent, false)
                OrangeCardViewHolder(binding)
            }

            SKYBLUE -> {
                val binding = CardItemBinding.inflate(inflater, parent, false)
                SkyblueCardViewHolder(binding)
            }

            else -> {
                SkyblueCardViewHolder

            }
        }
    }


    override fun getItemCount(): Int {
        return cardList.size
    }

    override fun getItemViewType(position: Int): Int {
        return cardList[position].viewtype
    }

    /*override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bind(cardList[position])
    }
*/
    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val cardlist = cardList[position]

        when (holder) {
            is BlueCardViewHolder -> holder.bind(cardlist)
            is SkyblueCardViewHolder -> holder.bind(cardlist)
            is OrangeCardViewHolder -> holder.bind(cardlist)
        }
    }

    inner class BlueCardViewHolder(private val binding: CardItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private var currentCard: Card? = null
        fun bind(card: Card) {
            currentCard = card
            binding.itemName.text = card.name
            binding.itemCardN.text = card.cardN
            binding.itemPeriod.text = card.period
            binding.itemPrice.text = card.price
        }
    }

    inner class OrangeCardViewHolder(private val binding: CardItem3Binding) :
        RecyclerView.ViewHolder(binding.root) {
        private var currentCard: Card? = null
        fun bind(card: Card) {
            currentCard = card
            binding.itemName.text = card.name
            binding.itemCardN.text = card.cardN
            binding.itemPeriod.text = card.period
            binding.itemPrice.text = card.price
        }
    }

    inner class SkyblueCardViewHolder(private val binding: CardItem2Binding) :
        RecyclerView.ViewHolder(binding.root) {
        private var currentCard: Card? = null
        fun bind(card: Card) {
            currentCard = card
            binding.itemName.text = card.name
            binding.itemCardN.text = card.cardN
            binding.itemPeriod.text = card.period
            binding.itemPrice.text = card.price
        }
    }
}