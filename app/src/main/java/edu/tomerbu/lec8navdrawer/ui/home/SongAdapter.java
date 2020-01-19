package edu.tomerbu.lec8navdrawer.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.tomerbu.lec8navdrawer.R;
import edu.tomerbu.lec8navdrawer.models.Song;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder>{

    //properties:
    List<Song> songs;
    LayoutInflater inflater; //takes xml files -> View

    //ctor:
    public SongAdapter(List<Song> songs, LayoutInflater inflater) {
        this.songs = songs;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate the xml file -> View:
        View v = inflater.inflate(R.layout.song_item, parent, false);
        return new SongViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SongViewHolder holder, int position) {
        Song s = songs.get(position);

        holder.tvSong.setText(s.getName());

        //TODO: how to show image from the internet (URL)
    }

    @Override
    public int getItemCount() {
        return songs.size();
    }






    //the view holder class -> hold references to views in the item view.
    //we need a class For Song View
    //here the properties are the TextView and ImageView from the layout.xml item file
    public static class SongViewHolder extends RecyclerView.ViewHolder{

        TextView tvSong;
        ImageView imageArt;

        public SongViewHolder(@NonNull View itemView) {
            super(itemView);

            //findViews:
            tvSong = itemView.findViewById(R.id.text_song_title);
            imageArt = itemView.findViewById(R.id.image_art);
        }
    }
}
