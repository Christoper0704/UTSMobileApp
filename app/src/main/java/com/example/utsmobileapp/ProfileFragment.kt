package com.example.utsmobileapp

import android.media.Image
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import org.w3c.dom.Text

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val username = arguments?.getString("user").toString()
        val namalengkap = arguments?.getString("namalengkap").toString()
        val nim = arguments?.getString("nim").toString()
        val uriImage = Uri.parse(arguments?.getString("image").toString())
        val buttonnext : Button = view.findViewById(R.id.btnnext)

        val txtUser : TextView = view.findViewById(R.id.textWelcome)
        val txtnama : TextView = view.findViewById(R.id.textNamaLengkap)
        val txtnim : TextView = view.findViewById(R.id.textNIM)
        val imgProfile : ImageView = view.findViewById(R.id.imageProfile)

        txtUser.text = "Hello @" + username
        txtnama.text = namalengkap
        txtnim.text = nim
        imgProfile.setImageURI(uriImage)

        buttonnext.setOnClickListener(){
            findNavController().navigate(R.id.action_profileFragment_to_fishActivity2)
        }
    }
}