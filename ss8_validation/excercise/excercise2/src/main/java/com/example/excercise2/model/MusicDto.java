package com.example.excercise2.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class MusicDto implements Validator {
    private String nameMusic;
    private String singer;
    private String musicGenre;

    public MusicDto() {
    }

    public MusicDto(String nameMusic, String singer, String musicGenre) {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        MusicDto musicDto = (MusicDto) target;

        if (musicDto.getNameMusic().equals("")) {
            errors.rejectValue("nameMusic", null, "Not Empty");
        } else if (!musicDto.getNameMusic().matches("^\\w{1,}$")) {
            errors.rejectValue("nameMusic", null, "Contains Special Characters");
        }
        if (musicDto.getNameMusic().length() > 800) {
            errors.rejectValue("nameMusic", null, "Over 800 words");
        }
        if (musicDto.getSinger().equals("")) {
            errors.rejectValue("singer", null, "Not Empty");
        } else if (!musicDto.getSinger().matches("^\\w{1,}$")) {
            errors.rejectValue("singer", null, "Contains Special Characters");
        }
        if (musicDto.getSinger().length() > 300) {
            errors.rejectValue("singer", null, "Over 300 words");
        }
        if (musicDto.getMusicGenre().equals("")) {
            errors.rejectValue("musicGenre", null, "Not Empty");
        } else if (!musicDto.getMusicGenre().matches("^[a-zA-Z_0-9_,]{1,}$")) {
            errors.rejectValue("musicGenre", null, "',' except Contains Special Characters");
        }
        if (musicDto.getMusicGenre().length() > 1000) {
            errors.rejectValue("musicGenre", null, "Over 1000 words");
        }
    }

    @Override
    public String toString() {
        return "MusicDto{" +
                "nameMusic='" + nameMusic + '\'' +
                ", singer='" + singer + '\'' +
                ", musicGenre='" + musicGenre + '\'' +
                '}';
    }
}
