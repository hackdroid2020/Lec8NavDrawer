package edu.tomerbu.lec8navdrawer.models;

public class Song {
    private String artistName;
    private String id;
    private String releaseDate;
    private String name;
    private String artistUrl;
    private String artworkUrl100;

    //ctor:
    public Song(String artistName, String id, String releaseDate, String name, String artistUrl, String artworkUrl100) {
        this.artistName = artistName;
        this.id = id;
        this.releaseDate = releaseDate;
        this.name = name;
        this.artistUrl = artistUrl;
        this.artworkUrl100 = artworkUrl100;
    }

    //getters setters
    public String getArtistName() {
        return artistName;
    }
    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getArtistUrl() {
        return artistUrl;
    }
    public void setArtistUrl(String artistUrl) {
        this.artistUrl = artistUrl;
    }
    public String getArtworkUrl100() {
        return artworkUrl100;
    }
    public void setArtworkUrl100(String artworkUrl100) {
        this.artworkUrl100 = artworkUrl100;
    }

    //toString
    @Override
    public String toString() {
        return "Song{" +
                "artistName='" + artistName + '\'' +
                ", id='" + id + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", name='" + name + '\'' +
                ", artistUrl='" + artistUrl + '\'' +
                ", artworkUrl100='" + artworkUrl100 + '\'' +
                '}';
    }
}
