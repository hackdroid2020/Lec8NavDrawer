package edu.tomerbu.lec8navdrawer.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import edu.tomerbu.lec8navdrawer.models.MoviesAsync;
import edu.tomerbu.lec8navdrawer.models.Song;

public class HomeViewModel extends ViewModel {

    //data for the controller: (properties:)
    private MutableLiveData<String> mText;
    private MutableLiveData<List<Song>> mSongs;


    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mSongs = new MutableLiveData<>();
        mText.setValue("This is home fragment");

        MoviesAsync moviesAsync = new MoviesAsync(mSongs);
        moviesAsync.execute();
    }

    public LiveData<String> getText() {
        return mText;
    }
    //publicly expose the as read only live data
    public LiveData<List<Song>> getSongs() {
        return mSongs;
    }



}