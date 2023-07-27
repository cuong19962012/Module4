package com.example.excercise2.model;

public class Music {
    private String nameMusic;
    private String singer;
    private String musicGenre;

    public Music() {
    }

    public Music(String nameMusic, String singer, String musicGenre) {
        this.nameMusic = nameMusic;
        this.singer = singer;
        this.musicGenre = musicGenre;
    }

    public String getNameMusic() {
        return nameMusic;
    }

    public void setNameMusic(String nameMusic) {
        this.nameMusic = nameMusic;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getMusicGenre() {
        return musicGenre;
    }

    public void setMusicGenre(String musicGenre) {
        this.musicGenre = musicGenre;
    }
}
