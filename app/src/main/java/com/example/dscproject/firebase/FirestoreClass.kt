package com.example.dscproject.firebase

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.dscproject.Constants.Constant
import com.example.dscproject.auth.SignIn
import com.example.dscproject.auth.SignUp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions

class FirestoreClass {//to store any data in the data base
    private val mFireStore=FirebaseFirestore.getInstance()
    fun registerUser(fragment: SignUp,userinfo:com.example.dscproject.firebase.User){
        mFireStore.collection(Constant.USERS).document(userinfo.id).set(userinfo, SetOptions.merge()).addOnSuccessListener {
            fragment.userRegistrationSuccess()
        }
            .addOnFailureListener{
                e->fragment.hideProgressDialog()
                Log.e("Failure","Failed Adding User")
            }

    }

    fun getCurrentUserID():String{
        //an instance to get the current user
        val currentUser= FirebaseAuth.getInstance().currentUser

        var currentUserID=""
        if(currentUser!=null){
            currentUserID=currentUser.uid
        }
        return currentUserID

    }
    fun SignOut(){
        val auth=FirebaseAuth.getInstance()
        auth.signOut()
    }
    fun getUserDetails(fragment: Fragment){
        mFireStore.collection(Constant.USERS).document(getCurrentUserID()).get().addOnSuccessListener {
            document->Log.i("Success",document.toString())

            val user=document.toObject(User::class.java)!!

            val sharedPreferences=fragment.requireActivity().getSharedPreferences(
                Constant.GALENUS_PREFERENCES,
                Context.MODE_PRIVATE
            )
            val editor: SharedPreferences.Editor= sharedPreferences.edit()
            //Key:signed_in_username - Value:Dwika
            editor.putString(
                Constant.SIGNED_IN_USERNAME,"${user.name}"
            )
            editor.apply()
            when(fragment){
                is SignIn->{
                    fragment.UserSignedInSuccess(user)
                }
            }

        }.addOnFailureListener{
            e-> when(fragment){
                is SignIn->{
                    fragment.hideProgressDialog()
                }
            }
        }
    }
}