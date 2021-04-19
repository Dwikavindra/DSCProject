package com.example.dscproject.auth

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.dscproject.Home.Home
import com.example.dscproject.R
import com.example.dscproject.databinding.SignInBinding
import com.example.dscproject.firebase.FirestoreClass
import com.example.dscproject.firebase.User
import com.example.dscproject.fragments.BaseFragment
import com.example.dscproject.testing
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignIn: BaseFragment() {
    private var _binding: SignInBinding?=null
    private val binding
        get()=_binding!!
    private lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth=Firebase.auth
    }
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
        binding.btnSignIn.setOnClickListener(){
            signinUser()
        }
    }
    private fun signinUser() {
        val email: String = binding.signinEmail.text.toString().trim { it <= ' ' }
        val password: String = binding.signinPassword.text.toString().trim { it <= ' ' }
        if (validateForm(email, password)) {
            showProgressDialog(resources.getString(R.string.please_wait))
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(requireActivity()) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d("Sign In", "signInWithEmail:success")
                        val user = Firebase.auth.currentUser
                        Toast.makeText(
                            context, "Authentication Successful",
                            Toast.LENGTH_SHORT
                        ).show()
                        FirestoreClass().getUserDetails(this@SignIn)
                    } else {
                        hideProgressDialog()
                        // If sign in fails, display a message to the user.
                        Log.w("Sign", "signInWithEmail:failure", task.exception)
                        Toast.makeText(
                            context, "Authentication Failed ",
                            Toast.LENGTH_SHORT
                        ).show()

                    }


                }
        }
    }
    private fun validateForm(email:String,password:String):Boolean{
        if (TextUtils.isEmpty(email)){
            showErrorSnackBar("Please Enter an email address")
            return false
        }
        else if (TextUtils.isEmpty(password)){
            showErrorSnackBar("Please Enter a password")
            return false
        }
        else
            return true
    }
    fun UserSignedInSuccess(user: User){
        hideProgressDialog()
        Log.i("First Name",user.name)
        Log.i("Email",user.email)

        startActivity(Intent(requireActivity(), Home::class.java))
        activity?.finish()
    }

}