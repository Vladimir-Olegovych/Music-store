package com.gigcreator.musicstore.presentation.fragment.amplifier

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gigcreator.domain.models.GuitarAmplifier
import com.gigcreator.musicstore.R
import com.gigcreator.musicstore.databinding.ShopItemBinding

class AmplifierAdapter(
    private val context: Context,
    private val listener: (GuitarAmplifier) -> Unit
): RecyclerView.Adapter<AmplifierAdapter.AmplifierListHolder>() {

    private var amplifierList = listOf<GuitarAmplifier>()

    inner class AmplifierListHolder(item: View) : RecyclerView.ViewHolder(item) {

        private val binding = ShopItemBinding.bind(item)

        fun bind(new: GuitarAmplifier) = with(binding) {
            Glide.with(context)
                .load("${context.resources.getString(R.string.address)}amplifier/search/image?id=${new.image}")
                .into(image)
            name.text = new.name
            price.text = new.price.toString() + "руб."
            description.text = new.technical_description
            card.setOnClickListener { listener.invoke(new) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AmplifierListHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shop_item, parent, false)
        return AmplifierListHolder(view)
    }

    override fun onBindViewHolder(holder: AmplifierListHolder, position: Int) {
        holder.bind(amplifierList[position])
    }

    override fun getItemCount(): Int {
        return amplifierList.size
    }

    fun set(list: List<GuitarAmplifier>){
        amplifierList = list
        notifyDataSetChanged()
    }
}
