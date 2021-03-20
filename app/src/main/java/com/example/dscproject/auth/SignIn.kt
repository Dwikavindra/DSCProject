package com.example.dscproject.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dscproject.databinding.SignInBinding
import com.example.dscproject.databinding.SignUpBinding

class SignIn: Fragment() {
    private var _binding: SignInBinding?=null
    private val binding
        get()=_binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= SignInBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.signinbackbutton.setOnClickListener(){
            activity?.onBackPressed();
        }
    }

}