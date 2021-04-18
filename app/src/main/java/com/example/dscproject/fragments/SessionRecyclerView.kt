package com.example.dscproject.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dscproject.R
import com.example.dscproject.databinding.FragmentSessionRecyclerViewBinding
import com.example.dscproject.model.Sessions
import com.google.firebase.database.*
import com.google.firebase.firestore.FirebaseFirestore

class SessionRecyclerView : Fragment() {


private var sessions= mutableListOf<String>("Sesi 1", "Sesi 2", "Sesi 3")
    private var _binding:FragmentSessionRecyclerViewBinding?=null
    private val binding
        get() = _binding!!
//move this later on to the onviewcreated

    private var waktu= mutableListOf<String>("09:00-13:00", "13:00-17:00", "18:00-22:00")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentSessionRecyclerViewBinding.inflate(inflater, container, false)
        return binding.root
        return inflater.inflate(R.layout.fragment_session_recycler_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val db = FirebaseFirestore.getInstance()

        var list2 = arrayListOf<String>()
//        val ref = FirebaseDatabase.getInstance().getReference("Sessions")
//        ref.addValueEventListener(object : ValueEventListener {
//            override fun onDataChange(dataSnapshot: DataSnapshot) {
//                for (sessionsnapshot in dataSnapshot.children) {
//                    val session = sessionsnapshot.getValue(Sessions::class.java)
//                    list2.add(session!!)
//                }
//            }
//
//            override fun onCancelled(databaseError: DatabaseError) {
//                throw databaseError.toException()
//            }
//        }
//        )

        val docref=db.collection("Sessions").document("Sesi 1")
        docref.get()
            .addOnSuccessListener{ document ->
                if(document !=null){
                    Log.d("hello", "DocumentSnapshot data: ${document.data}")
                   var  list1=document.data?.get("idRuangan") as List<String>
                    for(i in list1){
                        list2.add(i)

                    }
                    Log.d("list2data", "DocumentSnapshot data: ${list2}")
                    val listsession=listOf<Sessions>(
                        Sessions(
                            "Sesi 1",
                            "09:00-13:00",
                            list2,
                            listOf<String>(
                                "Doc A",
                                "Doc B",
                                "Doc C"
                            )
                        ),
                        Sessions(
                            "Sesi 2",
                            "13:00-17:00",
                            listOf<String>("Ruangan D", "Ruangan E", "Ruangan F"),
                            listOf<String>(
                                "Doc D",
                                "Doc E",
                                "Doc F"
                            )
                        ),
                        Sessions(
                            "Sesi 3",
                            "18:00-22:00",
                            listOf<String>("Ruangan G", "Ruangan H", "Ruangan I"),
                            listOf<String>(
                                "Doc G",
                                "Doc H",
                                "Doc I"
                            )
                        )
                    )
                    binding.SessionRecyclerView.layoutManager=LinearLayoutManager(requireContext())
                    binding.SessionRecyclerView.adapter=RecyclerViewAdapter(listsession)

                }else{
                    Log.d("doesnt exist", "No such document")
                }
            }
            .addOnFailureListener{ exception->
                Log.d("errordb", "get failed with ", exception)
            }
        Log.d("list3data", "DocumentSnapshot data: ${list2}")
    }

}