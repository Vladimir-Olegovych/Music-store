package com.gigcreator.musicstore.presentation.fragment.usersfragments.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.gigcreator.musicstore.databinding.FragmentRegisterBinding
import com.gigcreator.musicstore.presentation.constants.Constants
import com.gigcreator.musicstore.presentation.fragment.usersfragments.mvvm.UserDataViewModel
import com.gigcreator.musicstore.presentation.functions.isValidEmail
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding
    private val viewModel: UserDataViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonLogIn.setOnClickListener {
            if (binding.editTextTextEmailAddress.text.isNotEmpty() &&
                binding.editTextTextPassword.text.isNotEmpty() &&
                binding.editTextTextEmailAddress.text.isValidEmail() &&
                binding.editTextTextPassword.text.toString() ==
                binding.editTextTextPasswordRetry.text.toString())
            {
                viewModel.saveUser(binding.editTextTextEmailAddress.text.toString(),
                    binding.editTextTextPassword.text.toString(),
                    Constants.KEY)
            }else {
                Toast.makeText(requireContext(), "text error", Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.resultSave.observe(viewLifecycleOwner, Observer {
            Toast.makeText(requireContext(), it.result, Toast.LENGTH_SHORT).show()
        })
    }
}