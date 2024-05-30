package com.api.recuperacao.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.api.recuperacao.R


class Login : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        val buttonView = view.findViewById<Button>(R.id.btn_registrar)
        buttonView.setOnClickListener {
            findNavController().navigate(R.id.action_login_to_register)
        }

        val buttonLogin = view.findViewById<Button>(R.id.btn_login)
        buttonLogin.setOnClickListener {
            findNavController().navigate(R.id.action_login_to_maps)
        }

        return view
    }
}