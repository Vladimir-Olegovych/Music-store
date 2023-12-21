package com.gigcreator.musicstore.presentation.fragment.acousticguitar.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gigcreator.domain.models.AcousticGuitarData
import com.gigcreator.musicstore.R
import com.gigcreator.musicstore.databinding.AcousticGuitarItemBinding

class AcousticGuitarAdapter(
    private val context: Context,
    private val listener: (AcousticGuitarData) -> Unit
): RecyclerView.Adapter<AcousticGuitarAdapter.GuitarHolder>() {

    private var guitarList = listOf<AcousticGuitarData>()

    inner class GuitarHolder(item: View) : RecyclerView.ViewHolder(item) {

        private val binding = AcousticGuitarItemBinding.bind(item)

        fun bind(new: AcousticGuitarData) = with(binding) {
            Glide.with(context)
                .load("http://178.163.63.165:27015/guitar/acoustic/search/image?id=${new.image}")
                .into(image)
            name.text = new.name
            price.text = new.price.toString() + "руб."
            description.text = new.technical_description
            card.setOnClickListener { listener.invoke(new) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuitarHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.acoustic_guitar_item, parent, false)
        return GuitarHolder(view)
    }

    override fun onBindViewHolder(holder: GuitarHolder, position: Int) {
        holder.bind(guitarList[position])
    }

    override fun getItemCount(): Int {
        return guitarList.size
    }

    fun set(list: List<AcousticGuitarData>){
        guitarList = list
        notifyDataSetChanged()
    }
}
