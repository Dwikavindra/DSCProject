package com.example.dscproject.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.dscproject.R
import com.example.dscproject.databinding.FragmentABinding
import com.example.dscproject.databinding.FragmentBBinding
import kotlinx.parcelize.Parcelize


class FragmentB : Fragment() {
    private var _binding: FragmentBBinding?=null
    private val binding
        get()=_binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= FragmentBBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.movetofragmentc.setOnClickListener(){
            val action=FragmentBDirections.actionFragmentBToFragmentC()
            findNavController().navigate(action)
        }
    }


}