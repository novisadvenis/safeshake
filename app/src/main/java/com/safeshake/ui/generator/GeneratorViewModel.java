package com.safeshake.ui.generator;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class GeneratorViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public GeneratorViewModel() {
        mText = new MutableLiveData<>();
        //mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}