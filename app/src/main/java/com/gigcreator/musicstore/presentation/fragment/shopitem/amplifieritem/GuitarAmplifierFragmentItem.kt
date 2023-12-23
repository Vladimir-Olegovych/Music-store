package com.gigcreator.musicstore.presentation.fragment.shopitem.amplifieritem

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.gigcreator.musicstore.databinding.FragmentGuitarAmplifierItemBinding
import com.gigcreator.musicstore.presentation.fragment.shopitem.GuitarAmplifierItemViewModel

class GuitarAmplifierFragmentItem : Fragment() {

    private lateinit var binding: FragmentGuitarAmplifierItemBinding
    private val viewModel: GuitarAmplifierItemViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentGuitarAmplifierItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.resultGuitarAmplifierData.observe(viewLifecycleOwner){
            binding.apply {
                Glide.with(requireContext())
                    .load("http://178.163.63.165:27015/guitar/electric/search/image?id=${it.image}")
                    .into(itemImage)
                itemName.text = it.name
                textTeh.text = it.technical_description
                textPrice.text = "${it.price}руб."
                textBrand.text = "Brand - ${it.brand}"
                textCharacteristics.text = "${it.characteristics}"
                textDescription.text = it.description
                btnBack.setOnClickListener {
                    findNavController().popBackStack()
                }
            }
        }
    }

}