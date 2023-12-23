package com.gigcreator.musicstore.presentation.fragment.guitar

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gigcreator.domain.models.GuitarData
import com.gigcreator.musicstore.R
import com.gigcreator.musicstore.databinding.ShopItemBinding

class GuitarAdapter(
    private val context: Context,
    private val listener: (GuitarData) -> Unit
): RecyclerView.Adapter<GuitarAdapter.GuitarHolder>() {

    private var guitarList = listOf<GuitarData>()

    inner class GuitarHolder(item: View) : RecyclerView.ViewHolder(item) {

        private val binding = ShopItemBinding.bind(item)

        fun bind(new: GuitarData) = with(binding) {
            Glide.with(context)
                .load("${context.resources.getString(R.string.address)}guitar/acoustic/search/image?id=${new.image}")
                .into(image)
            name.text = new.name
            price.text = new.price.toString() + "руб."
            description.text = new.technical_description
            card.setOnClickListener { listener.invoke(new) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuitarHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shop_item, parent, false)
        return GuitarHolder(view)
    }

    override fun onBindViewHolder(holder: GuitarHolder, position: Int) {
        holder.bind(guitarList[position])
    }

    override fun getItemCount(): Int {
        return guitarList.size
    }

    fun set(list: List<GuitarData>){
        guitarList = list
        notifyDataSetChanged()
    }
}
