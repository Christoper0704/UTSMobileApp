package com.example.utsmobileapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    val username = "c.luis0704"
    val password = "1234"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val txtUsername : EditText = view.findViewById(R.id.editUsername)
        val txtPassword : EditText = view.findViewById(R.id.editPassword)
        val btnPindahkeHome : Button = view.findViewById(R.id.btnLogin)

        btnPindahkeHome.setOnClickListener(){
            pindahHalamanHome(txtUsername, txtPassword)
        }
    }

    fun pindahHalamanHome(txtUsername : EditText, txtPassword : EditText){
        if(txtUsername.text.toString().equals(username) && txtPassword.text.toString().equals(password)){
            val bundle = bundleOf(
                "user" to txtUsername.text.toString()
            )
            findNavController().navigate(R.id.action_loginFragment_to_homeFragment, bundle)
        }
        else if(txtUsername.text.toString().equals("") || txtPassword.text.toString().equals("")){
            Toast.makeText(requireContext(), "Username dan Password harus diisi", Toast.LENGTH_LONG).show()
        }
        else
        {
            Toast.makeText(requireContext(), "Masukkan Username atau Password yang benar", Toast.LENGTH_LONG).show()
        }
    }
}