package com.gigcreator.musicstore.presentation.fragment.shopitem.guitaritem

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.gigcreator.musicstore.databinding.FragmentAcousticGuitarItemBinding
import com.gigcreator.musicstore.presentation.fragment.shopitem.GuitarItemViewModel

class AcousticGuitarFragmentItem : Fragment() {

    private val viewModel: GuitarItemViewModel by activityViewModels()
    private lateinit var binding: FragmentAcousticGuitarItemBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentAcousticGuitarItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.resultAcousticGuitarData.observe(viewLifecycleOwner){
            binding.apply {
                Glide.with(requireContext())
                    .load("http://178.163.63.165:27015/guitar/acoustic/search/image?id=${it.image}")
                    .into(itemImage)
                itemName.text = it.name
                textTeh.text = it.technical_description
                textPrice.text = "${it.price}руб."
                textBrand.text = "Brand - ${it.brand}"
                textStrings.text = "Strings - ${it.strings}"
                textDescription.text = it.description
                btnBack.setOnClickListener {
                    findNavController().popBackStack()
                }
            }
        }
    }

}