package com.gigcreator.musicstore.presentation.fragment.amplifier

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.gigcreator.domain.models.GuitarAmplifier
import com.gigcreator.musicstore.R
import com.gigcreator.musicstore.databinding.FragmentGuitarAmplifierBinding
import com.gigcreator.musicstore.presentation.fragment.guitar.GuitarAdapter
import com.gigcreator.musicstore.presentation.fragment.shopitem.GuitarAmplifierItemViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GuitarAmplifierFragment : Fragment() {

    private lateinit var binding: FragmentGuitarAmplifierBinding
    private lateinit var amplifierAdapter: AmplifierAdapter
    private val viewModel: GuitarAmplifierViewModel by viewModels()
    private val viewModelItem: GuitarAmplifierItemViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentGuitarAmplifierBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnBack.setOnClickListener { findNavController().popBackStack() }

        amplifierAdapter = AmplifierAdapter(requireContext()){
            viewModelItem.setGuitarAmplifierData(it)
            findNavController().navigate(R.id.action_guitarAmplifierFragment_to_guitarAmplifierFragmentItem)
        }
        binding.rcView.layoutManager = LinearLayoutManager(requireContext())
        binding.rcView.adapter = amplifierAdapter

        viewModel.readAmplifier()
        viewModel.resultGuitarAmplifierData.observe(viewLifecycleOwner, Observer {
            amplifierAdapter.set(it)
        })
    }
}