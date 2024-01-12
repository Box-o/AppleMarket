package net.flow9.thisiskotlin.applemarket

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import net.flow9.thisiskotlin.applemarket.databinding.ItemRecyclerviewBinding
import java.text.NumberFormat

class MyAdapter(val mainList: MutableList<MyItem>) : RecyclerView.Adapter<MyAdapter.Holder>() {

    interface ItemClick {
        fun onClick(view : View, position : Int)
    }
    interface ItemLongClick {
        fun onLongClick(view : View, position : Int)
    }

    var itemClick : ItemClick? = null
    var itemLongClick : ItemLongClick? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.setOnClickListener {  //클릭이벤트추가부분
            itemClick?.onClick(it, position)
        }

        holder.itemView.setOnLongClickListener() OnLongClickListener@{
            itemLongClick?.onLongClick(it, position)
            return@OnLongClickListener true
        }

        holder.holderRecycleImg.setImageResource(mainList[position].recycleImg)
        holder.holderRecycleTitle.text = mainList[position].recycleTitle
        holder.holderRecycleLocation.text = mainList[position].recycleLocation
        //holder.holderRecyclePrice.text = mainList[position].recyclePrice
        //가격 숫자만 표시

        /*val format = NumberFormat.getNumberInstance()
        // 숫자를 포맷화 하기 위해 NumberFormat 인스턴스 호출
        val priceWithComma = format.format(mainList[position].recyclePrice.toInt())
        // 가격에 콤마 추가
        holder.holderRecyclePrice.text = priceWithComma
        // 변수에 추가된 포멧을 적용*/

        val price = mainList[position].recyclePrice.toInt()
        val formattedPrice = if (price >= 1000000) {
            val manwon = price / 10000
            "${manwon}만원"
        } else {
            NumberFormat.getNumberInstance().format(price) + "원"
        }

        holder.holderRecyclePrice.text = formattedPrice


        holder.holderRecycleLike.text = mainList[position].recycleLike
        holder.holderRecycleChat.text = mainList[position].recycleChat


    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int {
        return mainList.size
    }

    inner class Holder(val binding: ItemRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root) {
        val holderRecycleImg = binding.ivProduct
        val holderRecycleTitle = binding.tvProductTitle
        val holderRecycleLocation = binding.tvProductLocation
//        val holderRecycleSeller = binding.
        val holderRecyclePrice = binding.tvProductPrice
        val holderRecycleLike = binding.tvLike
        val holderRecycleChat = binding.tvChat
//        val holderRecycleDescription = binding.
    }
}