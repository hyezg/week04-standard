package com.example.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ItemBlueCardBinding
import com.example.recyclerview.databinding.ItemLightBlueBinding
import com.example.recyclerview.databinding.ItemOrangeCardBinding

//ViewHolder 라는 이름의 뷰홀더 만듦
class CardsAdapter(private val onClick: (Card) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var cardList = listOf<Card>()

    //CardViewHolder 생성
    //viewHolder에 연결된 view 생성, 초기화
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        //type을 구현하는 item layout 연결
        return when (viewType) {
            MuiltiViewEnum.BLUE.viewtype -> {
                val binding =
                    ItemBlueCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                BlueTypeViewHolder(binding)
            }

            MuiltiViewEnum.LIGHTBLUE.viewtype -> {
                val binding =
                    ItemLightBlueBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                LightBlueTypeViewHolder(binding)
            }

            MuiltiViewEnum.ORANGE.viewtype -> {
                val binding =
                    ItemOrangeCardBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                OrangeTypeViewHolder(binding)
            }

            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    //viewholder 클래스 필요 없나?
    /*class CardViewHolder(private var binding: CardItemBinding, val onClick: (Card) -> Unit) :
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
    }*/

    //카드 목록의 갯수 카운트
    override fun getItemCount(): Int {
        return cardList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentItem = cardList[position]
        when (holder.itemViewType) {
            //BLUE 일때
            MuiltiViewEnum.BLUE.viewtype -> {
                val blueHolder = holder as BlueTypeViewHolder
                blueHolder.bind(currentItem)

                holder.itemView.setOnClickListener {
                    onClick(currentItem)
                }
            }
            //LIGHTBLUE 일때
            MuiltiViewEnum.LIGHTBLUE.viewtype -> {
                val lightBlueHolder = holder as LightBlueTypeViewHolder
                lightBlueHolder.bind(currentItem)

                holder.itemView.setOnClickListener {
                    onClick(currentItem)
                }
            }
            //ORANGE 일때
            MuiltiViewEnum.ORANGE.viewtype -> {
                val orangeHolder = holder as OrangeTypeViewHolder
                orangeHolder.bind(currentItem)

                holder.itemView.setOnClickListener {
                    onClick(currentItem)
                }
            }
        }
    }

    //아이템의 위치에 따라 어떤 뷰 타입을 가져야하는지 결정
    //position 즉 아이템의 위치에 접근하여 아이템의 뷰타입 결정
    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> MuiltiViewEnum.BLUE.viewtype
            1 -> MuiltiViewEnum.LIGHTBLUE.viewtype
            2 -> MuiltiViewEnum.ORANGE.viewtype
            else -> throw IllegalArgumentException("Invalid position")
        }
    }

    /*override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bind(cardList[position])
    }
*/


    //item layout의 ui값 뿌려주기
    //Blue Type
    inner class BlueTypeViewHolder(private val binding: ItemBlueCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(card: Card) {
            binding.apply {
                itemName.text = card.name
                itemCardN.text = card.cardN
                itemCardType.text = card.cardType
                itemPeriod.text = card.period
                itemPrice.text = card.price.toString()
                itemCardManager.text = card.cardManager
            }
        }
    }

    //LightBlue Type
    inner class LightBlueTypeViewHolder(private val binding: ItemLightBlueBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(card: Card) {
            binding.apply {
                itemName.text = card.name
                itemCardN.text = card.cardN
                itemCardType.text = card.cardType
                itemPeriod.text = card.period
                itemPrice.text = card.price.toString()
                itemCardManager.text = card.cardManager
            }
        }
    }

    inner class OrangeTypeViewHolder(private val binding: ItemOrangeCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(card: Card) {
            binding.apply {
                itemName.text = card.name
                itemCardN.text = card.cardN
                itemCardType.text = card.cardType
                itemPeriod.text = card.period
                itemPrice.text = card.price.toString()
                itemCardManager.text = card.cardManager
            }
        }
    }
}