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
import com.example.dscproject.databinding.FragmentCBinding
import com.example.dscproject.databinding.FragmentIphone89Binding


class iphone89 : Fragment() {
    private var _binding:FragmentIphone89Binding?=null
    private val binding
        get()=_binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= FragmentIphone89Binding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.aktivitas.setOnClickListener(){
            val action=Fragmentiphone89Direction.actionFragmentIphone89ToFragmentIphone814();
            findNavController().navigate(action)

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }


}