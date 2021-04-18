package com.example.dscproject.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.dscproject.databinding.HomeSignBinding
import com.example.dscproject.databinding.SignUpBinding

class HomeSign: Fragment() {
    private var _binding: HomeSignBinding?=null
    private val binding
        get()=_binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= HomeSignBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.signUpbutton.setOnClickListener(){
            val action=HomeSignDirections.actionHomeSignToSignUp()
            findNavController().navigate(action)
        }
        binding.signinbutton.setOnClickListener(){
            val action=HomeSignDirections.actionHomeSignToSignIn()
            findNavController().navigate(action)
        }
        binding.topBackButton.setOnClickListener(){
            activity?.onBackPressed()
        }
    }

}