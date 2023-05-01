package com.example.pamolab.ui.BMR

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BmrViewModel : ViewModel() {
    private val mText: MutableLiveData<String>

    init {
        mText = MutableLiveData()
        mText.value = "Calculate BMR"
    }

    val text: LiveData<String>
        get() = mText
}