package edu.tomerbu.lec8navdrawer.models;

import android.os.AsyncTask;
import androidx.lifecycle.MutableLiveData;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;
//in Java we used Threads:
//Android does not allow HEAVY operations on the Main(UI) Thread!
//Exception: Networking on the UI Thread
//Database operations etc... (new Thread) (Async)

public class MoviesAsync extends AsyncTask<Void, Integer, ArrayList<Song>> {

    //property: LiveData<List<Song>>
    //Observable List<Song>
    private MutableLiveData<List<Song>> mLiveData;

    //in the constructor: init properties:
    public MoviesAsync(MutableLiveData<List<Song>> mLiveData) {
        this.mLiveData = mLiveData;
    }

    @Override
    protected ArrayList<Song> doInBackground(Void... voids) {

        try {
            URL feedURL = new URL("https://rss.itunes.apple.com/api/v1/il/apple-music/coming-soon/all/100/explicit.json");
            HttpsURLConnection con = (HttpsURLConnection) feedURL.openConnection();
            //binary input stream:
            InputStream in = con.getInputStream();
            StringBuilder sb = new StringBuilder();

            //wrap the binary inputStream with a reader:
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line = null;

            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            //the stringBuilder is full:
            String json = sb.toString();
            ArrayList<Song> result = new ArrayList<>();

            JSONObject obj = new JSONObject(json);
            JSONObject feedObject = obj.getJSONObject("feed");
            JSONArray resultsArray = feedObject.getJSONArray("results");
            //fill the list:
            for (int i = 0; i < resultsArray.length(); i++) {
                JSONObject songObject = resultsArray.getJSONObject(i);
                String artistName = songObject.getString("artistName");
                String id = songObject.getString("id");
                String releaseDate = songObject.getString("releaseDate");
                String name = songObject.getString("name");
                String artistUrl = songObject.getString("artistUrl");
                String artworkUrl100 = songObject.getString("artworkUrl100");
                Song s = new Song(artistName, id, releaseDate, name, artistUrl, artworkUrl100);
                result.add(s);
            }
            return result;
        } catch (IOException e) {
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //code that runs in the background:
        return null;
    }
    //doInBackground: fetch JSon{Threads}
    //onPostExecute (update UI)
    @Override
    protected void onPostExecute(ArrayList<Song> result) {
        //update UI (after the thread is done)
        mLiveData.setValue(result);
        //tell the viewModel:
    }
}


/*
* class AsyncTask
*   //doInBackground (Thread)
*   //Rule #1) don't do heavy work on the UI Thread

*   //onPostExecute() //the thread is done (we are on the UI Thread now)
*   //Rule #2) ONLY The UI Thread may update UI
* */
