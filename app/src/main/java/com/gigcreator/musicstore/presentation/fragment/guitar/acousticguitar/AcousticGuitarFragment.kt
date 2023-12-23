package com.gigcreator.musicstore.presentation.fragment.guitar.acousticguitar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.gigcreator.musicstore.R
import com.gigcreator.musicstore.databinding.FragmentAcousticGuitarBinding
import com.gigcreator.musicstore.presentation.fragment.guitar.GuitarAdapter
import com.gigcreator.musicstore.presentation.fragment.shopitem.GuitarItemViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AcousticGuitarFragment : Fragment() {

    private lateinit var binding: FragmentAcousticGuitarBinding
    private lateinit var guitarAdapter: GuitarAdapter
    private val viewModel: AcousticGuitarViewModel by viewModels()
    private val viewModelItem: GuitarItemViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentAcousticGuitarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnBack.setOnClickListener { findNavController().popBackStack() }

        guitarAdapter = GuitarAdapter(requireContext()){
            viewModelItem.setAcousticGuitarData(it)
            findNavController().navigate(R.id.action_acousticGuitarFragment_to_acousticGuitarFragmentItem)
        }
        binding.rcView.layoutManager = LinearLayoutManager(requireContext())
        binding.rcView.adapter = guitarAdapter


        viewModel.readAcousticGuitar()
        viewModel.resultGuitarData.observe(viewLifecycleOwner, Observer {
            guitarAdapter.set(it)
        })
    }

}