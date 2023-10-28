package com.gigcreator.musicstore.presentation.fragment.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.gigcreator.musicstore.R
import com.gigcreator.musicstore.databinding.FragmentLoginBinding
import com.gigcreator.musicstore.presentation.constants.Constants
import com.gigcreator.musicstore.presentation.functions.isValidEmail
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
        }
        binding.buttonLogIn.setOnClickListener {
            if (binding.editTextTextEmailAddress.text.isNotEmpty() &&
                binding.editTextTextPassword.text.isNotEmpty() &&
                binding.editTextTextEmailAddress.text.isValidEmail())
            {
                viewModel.searchUser(binding.editTextTextEmailAddress.text.toString(), Constants.KEY)
            }else {
                Toast.makeText(requireContext(), "text error", Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.resultSearch.observe(viewLifecycleOwner, Observer {
            if (it.email == binding.editTextTextEmailAddress.text.toString() &&
                it.password == binding.editTextTextPassword.text.toString()){
                viewModel.save(it)
                findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
            }else {
                Toast.makeText(requireContext(), "wrong login or password", Toast.LENGTH_SHORT).show()
            }
        })

        binding.textViewRegister.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }
}