package com.gigcreator.musicstore.presentation.fragment.main

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
import com.gigcreator.musicstore.R
import com.gigcreator.musicstore.databinding.FragmentMainBinding
import com.gigcreator.musicstore.presentation.fragment.main.adapter.MainAdapter
import com.gigcreator.musicstore.presentation.fragment.main.model.DirectoryModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var mainAdapter: MainAdapter
    private val viewModel: MainViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun onClick(){
        binding.login.setOnClickListener { findNavController().navigate(R.id.action_mainFragment_to_loginFragment) }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mainList = fillMainAdapter()
        onClick()
        viewModel.get()
        viewModel.user.observe(viewLifecycleOwner, Observer {
            binding.name.text = it.email
        })

        mainAdapter = MainAdapter(mainList) {
            when(it){
                mainList[0].name -> findNavController().navigate(R.id.action_mainFragment_to_acousticGuitarFragment)
                mainList[1].name -> Log.d("sdsdsdsdsd", it)
                mainList[2].name -> Log.d("sdsdsdsdsd", it)
                mainList[3].name -> Log.d("sdsdsdsdsd", it)
                mainList[4].name -> Log.d("sdsdsdsdsd", it)
                mainList[5].name -> Log.d("sdsdsdsdsd", it)
                mainList[6].name -> Log.d("sdsdsdsdsd", it)
                mainList[7].name -> Log.d("sdsdsdsdsd", it)
            }
        }
        binding.rcViewDirectory.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rcViewDirectory.adapter = mainAdapter

    }
    private fun fillMainAdapter(): List<DirectoryModel> {
        val diList = resources.getStringArray(R.array.directory)
        return listOf(
            DirectoryModel(R.drawable.acoustic, diList[0]),
            DirectoryModel(R.drawable.electric, diList[1]),
            DirectoryModel(R.drawable.amplifier, diList[2]),
            DirectoryModel(R.drawable.acoustic_system, diList[3]),
            DirectoryModel(R.drawable.piano, diList[4]),
            DirectoryModel(R.drawable.synthesizer, diList[5]),
            DirectoryModel(R.drawable.microphone, diList[6]),
            DirectoryModel(R.drawable.radio, diList[7]),
        )
    }
}