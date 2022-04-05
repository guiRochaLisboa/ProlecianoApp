package com.example.prolecianoapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.prolecianoapp.R
import com.example.prolecianoapp.viewmodel.RegisterViewModel
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mViewModel : RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        mViewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)

        setListener()
        observe()
    }



    override fun onClick(p0: View) {
        val id = p0.id

        if(id == R.id.buttonCadastrar){
            val nome = editTextName.toString()
            val email = editTextEmailAddress.toString()
            val senha = editTextPassword.toString()

            mViewModel.handleRegister(nome,email,senha)
            startActivity(Intent(this,MainActivity::class.java))
        }
    }

    private fun observe() {

    }

    private fun setListener() {
        buttonCadastrar.setOnClickListener(this)
    }
}