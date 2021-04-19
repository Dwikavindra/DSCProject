package com.example.dscproject.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dscproject.R
import com.example.dscproject.databinding.FragmentHistoryRecycleryViewBinding
import com.example.dscproject.databinding.FragmentSessionRecyclerViewBinding
import com.example.dscproject.model.History

class HistoryRecycleryView : Fragment() {
    private var _binding: FragmentHistoryRecycleryViewBinding?=null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
    _binding= FragmentHistoryRecycleryViewBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listhistory= listOf<History>(History("Dokter A","11"), History("Dokter B","1"),History("Dokter C","4"))
        binding.HistoryRecyclerView.layoutManager=LinearLayoutManager(requireContext())
        binding.HistoryRecyclerView.adapter=HistoryRecyclerViewAdapter(listhistory)
    }

}