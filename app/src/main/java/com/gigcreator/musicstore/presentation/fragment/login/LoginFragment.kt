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
import com.gigcreator.musicstore.presentation.functions.isValidEmail
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

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
        binding.buttonLogIn.setOnClickListener {
            if (binding.editTextTextEmailAddress.text.isNotEmpty() &&
                binding.editTextTextPassword.text.isNotEmpty() &&
                binding.editTextTextEmailAddress.text.isValidEmail())
            {
                viewModel.readData()
            }else {
                Toast.makeText(requireContext(), "ERROR", Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.resultLiveData.observe(this, Observer {
            Toast.makeText(requireContext(), it.email, Toast.LENGTH_SHORT).show()
        })

        binding.textViewRegister.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }
}