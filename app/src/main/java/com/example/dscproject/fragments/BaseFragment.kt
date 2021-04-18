package com.example.dscproject.fragments

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.dscproject.R
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth


open class BaseFragment : Fragment() {

  private var doubleBackToExitPressedOnce=false
    private lateinit var mProgressDialog: Dialog


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }
fun showProgressDialog(text: String){
    mProgressDialog= Dialog(requireContext())
    mProgressDialog.setContentView(R.layout.dialog_progress)
    mProgressDialog.findViewById<TextView>(R.id.tv_progress_text).text =text
    mProgressDialog.show()

}
    fun hideProgressDialog() {
        mProgressDialog.dismiss()
    }
    fun getCurrentUserID(): String {
        return FirebaseAuth.getInstance().currentUser!!.uid
    }
    fun showErrorSnackBar(message: String) {
        val snackBar =
            Snackbar.make(
                requireActivity().findViewById(android.R.id.content),
                message,
                Snackbar.LENGTH_LONG
            )
        val snackBarView = snackBar.view
        snackBarView.setBackgroundColor(
            ContextCompat.getColor(
                requireContext(),
                R.color.snackbar_error_color
            )
        )
        snackBar.show()
    }
}
