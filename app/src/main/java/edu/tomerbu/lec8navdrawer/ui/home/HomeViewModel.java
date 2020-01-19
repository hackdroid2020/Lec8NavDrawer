package edu.tomerbu.lec8navdrawer.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import edu.tomerbu.lec8navdrawer.models.MoviesAsync;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");

        MoviesAsync moviesAsync = new MoviesAsync();
        moviesAsync.execute();
    }

    public LiveData<String> getText() {
        return mText;
    }



}