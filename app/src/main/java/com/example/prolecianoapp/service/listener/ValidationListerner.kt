package com.example.prolecianoapp.service.listener

class ValidationListerner(str: String = "") {


    private var mStatus : Boolean = true
    private var mMessage : String = ""

    init {
        if(str != ""){
            mStatus = false
            mMessage = str
        }
    }


    fun success() = mStatus
    fun faliure() = mMessage
}