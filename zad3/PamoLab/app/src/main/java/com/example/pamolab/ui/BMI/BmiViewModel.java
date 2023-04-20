package com.example.pamolab.ui.BMI;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
public class BmiViewModel extends ViewModel {


    private final MutableLiveData<Integer> mWeight;
    private final MutableLiveData<Integer> mHeight;

    public BmiViewModel() {
        mWeight = new MutableLiveData<>();
        mHeight = new MutableLiveData<>();

    }


    public LiveData<Integer> getWeight() {
        return mWeight;
    }

    public LiveData<Integer> getHeight() {
        return mHeight;
    }

    public void setWeight(int weight) {
        mWeight.setValue(weight);
    }

    public void setHeight(int height) {
        mHeight.setValue(height);
    }

}
