package com.example.dscproject.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.dscproject.R
import com.example.dscproject.databinding.FragmentBBinding
import com.example.dscproject.databinding.FragmentCBinding

class FragmentC: Fragment() {
    private var _binding: FragmentCBinding?=null
    private val binding
        get()=_binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= FragmentCBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.movetoHomeSign.setOnClickListener(){
            val action=FragmentCDirections.actionFragmentCToHomeSign()
            findNavController().navigate(action)
        }
        binding.movetofragmentb.setOnClickListener(){
            activity?.onBackPressed();
        }
    }
}