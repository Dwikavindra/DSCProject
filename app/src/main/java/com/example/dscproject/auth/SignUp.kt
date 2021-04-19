package com.example.dscproject.auth

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.dscproject.Home.Home
import com.example.dscproject.R
import com.example.dscproject.firebase.User

import com.example.dscproject.databinding.SignUpBinding
import com.example.dscproject.firebase.FirestoreClass
import com.example.dscproject.fragments.BaseFragment
import com.example.dscproject.testing

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class SignUp: BaseFragment() {
    private var _binding: SignUpBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = SignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.backbutton.setOnClickListener() {
            activity?.onBackPressed()
        }
        binding.btnSignUp.setOnClickListener() {
            registerUser()
        }
    }

    private fun registerUser() {
        val email: String = binding.etEmail.text.toString().trim { it <= ' ' }
        val password: String = binding.etPassword.text.toString().trim { it <= ' ' }
        val name: String = binding.etName.text.toString().trim { it <= ' ' }
        if (validateForm(name, email, password)) {
            showProgressDialog(resources.getString(R.string.please_wait))
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(
                    {//if sucessfulll
                        task ->
                        hideProgressDialog()//hide the progress//if we press back the progress dialog still shows
                        if (task.isSuccessful) {
                            val firebaseUser: FirebaseUser = task.result!!.user!!
                            val registeredEmail = firebaseUser.email!!
                            val user= User(firebaseUser.uid,
                                binding.etName.text.toString().trim { it <= ' ' },
                                binding.etEmail.text.toString().trim { it <= ' ' }
                            )
                            FirestoreClass().registerUser(this@SignUp,user)
                            startActivity(Intent(requireActivity(),Home::class.java))

//                            FirebaseAuth.getInstance().signOut()
//                            activity?.finish()
                        } else {
                            hideProgressDialog()
                            Toast.makeText(requireContext(),task.exception!!.message,Toast.LENGTH_SHORT)


                        }
                    }
                )

        }
    }

    private fun validateForm(name: String, email: String, password: String): Boolean {
        if (TextUtils.isEmpty(name)) {
            showErrorSnackBar("Please Enter a name")
            return false
        } else if (TextUtils.isEmpty(email)) {
            showErrorSnackBar("Please Enter an email address")
            return false
        } else if (TextUtils.isEmpty(password)) {
            showErrorSnackBar("Please Enter a password")
            return false
        } else
            return true
    }
    fun userRegistrationSuccess(){
        hideProgressDialog()
        Toast.makeText(
            context,
            "You have sucessfully registered",
            Toast.LENGTH_SHORT
        ).show()
    }
//    return when{
//        TextUtils.isEmpty(name) -> {
//            showErrorSnackBar("Please Enter a name")
//            false
//        }
//        TextUtils.isEmpty(password) -> {
//            showErrorSnackBar("Please Enter a password")
//            false
//        }
//        TextUtils.isEmpty(email) -> {
//            showErrorSnackBar("Please Enter an email address")
//            false
//        }else->{
//            true
//        }

}


