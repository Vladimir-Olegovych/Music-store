package com.gigcreator.musicstore.presentation.fragment.acousticguitar

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.gigcreator.musicstore.databinding.FragmentAcousticGuitarBinding
import com.gigcreator.musicstore.presentation.fragment.acousticguitar.adapter.AcousticGuitarAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AcousticGuitarFragment : Fragment() {

    private lateinit var binding: FragmentAcousticGuitarBinding
    private lateinit var acousticGuitarAdapter: AcousticGuitarAdapter
    private val viewModel: AcousticGuitarViewModel by viewModels()


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

        acousticGuitarAdapter = AcousticGuitarAdapter(requireContext()){
            Log.d("sadasdasdasdasd", it.name)
        }
        binding.rcView.layoutManager = LinearLayoutManager(requireContext())
        binding.rcView.adapter = acousticGuitarAdapter


        viewModel.readAcousticGuitar()
        viewModel.resultAcousticGuitarData.observe(viewLifecycleOwner, Observer {
            acousticGuitarAdapter.set(it)
        })
    }

}