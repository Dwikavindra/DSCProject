package com.example.dscproject.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.dscproject.databinding.Fragment81Binding
import com.example.dscproject.databinding.FragmentABinding
import com.example.dscproject.firebase.FirestoreClass


class Fragment81 : Fragment() {
    private var _binding:Fragment81Binding?=null
    private val binding
        get()=_binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= Fragment81Binding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var currentID= FirestoreClass().getCurrentUserID()
//        if(currentID.isNotEmpty()){
//            startActivity(Intent(requireContext(),FirstPageView::class.java))
//            activity?.finish()
//        } to be implemented later
        binding.mulai.setOnClickListener(){
            val action=Fragment81Directions.actionFragment81ToFragment89()
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }



}