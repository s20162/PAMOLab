package com.example.pamolab.ui.BMI

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BmiViewModel : ViewModel() {
    private val mWeight: MutableLiveData<Int>
    private val mHeight: MutableLiveData<Int>

    init {
        mWeight = MutableLiveData()
        mHeight = MutableLiveData()
    }

    val weight: LiveData<Int>
        get() = mWeight
    val height: LiveData<Int>
        get() = mHeight

    fun setWeight(weight: Int) {
        mWeight.value = weight
    }

    fun setHeight(height: Int) {
        mHeight.value = height
    }
}