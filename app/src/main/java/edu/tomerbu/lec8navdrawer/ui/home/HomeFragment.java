package edu.tomerbu.lec8navdrawer.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.tomerbu.lec8navdrawer.R;
import edu.tomerbu.lec8navdrawer.models.Song;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        //final TextView textView = root.findViewById(R.id.text_home);
        final RecyclerView rvSongs = root.findViewById(R.id.recycler_songs);

        homeViewModel.getSongs().observe(this, new Observer<List<Song>>() {
            @Override
            public void onChanged(@Nullable List<Song> s) {
                SongAdapter adapter = new SongAdapter(s, getLayoutInflater());
                rvSongs.setLayoutManager(new LinearLayoutManager(getContext()));
                rvSongs.setAdapter(adapter);
            }
        });
        return root;
    }
}