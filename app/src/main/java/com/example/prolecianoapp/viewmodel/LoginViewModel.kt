package com.example.prolecianoapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.prolecianoapp.service.listener.ValidationListerner

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    private val mLogin = MutableLiveData<ValidationListerner>()
    var login: LiveData<ValidationListerner> = mLogin


    fun login(email: String,password: String) {

        if (email != "" || password != ""){
            mLogin.value = ValidationListerner()
        }else{
            mLogin.value = ValidationListerner("Erro ao fazer login!!")
        }
        }



}