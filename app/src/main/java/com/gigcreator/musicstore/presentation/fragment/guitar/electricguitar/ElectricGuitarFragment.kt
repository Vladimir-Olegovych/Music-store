package com.gigcreator.musicstore.presentation.fragment.guitar.electricguitar

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
import com.gigcreator.musicstore.databinding.FragmentElectricGuitarBinding
import com.gigcreator.musicstore.presentation.fragment.guitar.GuitarAdapter
import com.gigcreator.musicstore.presentation.fragment.shopitem.GuitarItemViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ElectricGuitarFragment : Fragment() {

    private lateinit var binding: FragmentElectricGuitarBinding
    private lateinit var guitarAdapter: GuitarAdapter
    private val viewModel: ElectricGuitarViewModel by viewModels()
    private val viewModelItem: GuitarItemViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentElectricGuitarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnBack.setOnClickListener { findNavController().popBackStack() }

        guitarAdapter = GuitarAdapter(requireContext()){
            viewModelItem.setElectricGuitarData(it)
            findNavController().navigate(R.id.action_electricGuitarFragment_to_electricGuitarFragmentItem)
        }
        binding.rcView.layoutManager = LinearLayoutManager(requireContext())
        binding.rcView.adapter = guitarAdapter

        viewModel.readAcousticGuitar()
        viewModel.resultGuitarData.observe(viewLifecycleOwner, Observer {
            guitarAdapter.set(it)
        })
    }

}