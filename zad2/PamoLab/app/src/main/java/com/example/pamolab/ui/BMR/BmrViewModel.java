package com.example.pamolab.ui.BMR;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BmrViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public BmrViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Calculate BMR");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
