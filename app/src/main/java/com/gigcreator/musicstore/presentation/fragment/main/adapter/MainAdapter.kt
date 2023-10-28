package com.gigcreator.musicstore.presentation.fragment.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.recyclerview.widget.RecyclerView
import com.gigcreator.musicstore.R
import com.gigcreator.musicstore.databinding.DirectoryItemBinding
import com.gigcreator.musicstore.presentation.fragment.main.model.DirectoryModel

class MainAdapter(private var directoryList: List<DirectoryModel>,
                  private val listener: (String) -> Unit): RecyclerView.Adapter<MainAdapter.DirectoryHolder>() {

    inner class DirectoryHolder(item: View) : RecyclerView.ViewHolder(item) {

        private val binding = DirectoryItemBinding.bind(item)

        fun bind(new: DirectoryModel) = with(binding) {

            val params = CoordinatorLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
            image.setImageResource(new.image)
            name.text = new.name

            if (directoryList[0].name == new.name){
                params.marginStart = 0
                params.marginEnd = 23
                card.layoutParams = params
            } else if (directoryList[7].name == new.name) {
                params.marginStart = 23
                params.marginEnd = 0
                card.layoutParams = params
            }
            card.setOnClickListener { listener.invoke(new.name) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DirectoryHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.directory_item, parent, false)
        return DirectoryHolder(view)
    }

    override fun onBindViewHolder(holder: DirectoryHolder, position: Int) {
        holder.bind(directoryList[position])
    }

    override fun getItemCount(): Int {
        return directoryList.size
    }
}