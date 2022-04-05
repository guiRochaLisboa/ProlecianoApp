package com.example.prolecianoapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.prolecianoapp.R
import com.example.prolecianoapp.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mViewModel : LoginViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        setListener()
        observe()
    }


    override fun onClick(id: View) {
        val id = id.id

        if(id == R.id.buttonLogin){
            val email = editTextTextEmailAddress.toString()
            val password = editTextTextPassword.toString()

            mViewModel.login(email,password)
        }else if(id == R.id.textRegister){
            startActivity(Intent(Intent(this, RegisterActivity::class.java)))
        }
    }

    private fun setListener() {
        buttonLogin.setOnClickListener(this)
        textRegister.setOnClickListener(this)
    }

    private fun observe() {

        mViewModel.login.observe(this, Observer {
            if(it.success()){
                startActivity(Intent(this,MainActivityHome::class.java))
            }
        })

    }

}