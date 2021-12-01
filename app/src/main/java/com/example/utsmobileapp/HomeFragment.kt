package com.example.utsmobileapp

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment(R.layout.fragment_home) {

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var username: String
    lateinit var uriImage: Uri

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
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        username = arguments?.getString("user").toString()
        val namalengkap : EditText = view.findViewById(R.id.editNamaLengkap)
        val nim : EditText = view.findViewById(R.id.editNIM)
        val imageUpload : ImageView = view.findViewById(R.id.image_Upload)
        val save : Button = view.findViewById(R.id.btnSave)

        val txtUsername : TextView = view.findViewById(R.id.txtViewUser)
        txtUsername.text = username

        var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                imageUpload.setImageURI(data?.data)
                uriImage = data?.data!!
            }
        }

        imageUpload.setOnClickListener(){
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            resultLauncher.launch(intent)
        }

        save.setOnClickListener(){
            pindahHalamanProfile(namalengkap, nim)
        }
    }

    fun pindahHalamanProfile(namalengkap : EditText, nim : EditText)
    {
        if(namalengkap.text.toString().equals("") || nim.text.toString().equals("")){
            Toast.makeText(requireContext(), "Nama dan NIM harus diisi", Toast
                .LENGTH_LONG).show()
        }
        else{
            val bundle = bundleOf(
                "user" to username,
                "namalengkap" to namalengkap.text.toString(),
                "nim" to nim.text.toString(),
                "image" to uriImage.toString()
            )
            findNavController().navigate(R.id.action_homeFragment_to_profileFragment, bundle)
        }
    }

}