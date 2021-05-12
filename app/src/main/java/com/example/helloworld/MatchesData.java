package com.example.helloworld;

public class MatchesData {

    private int matchesImage;
    private String matchesName;

    public MatchesData(int matchesImage, String matchesName) {
        this.matchesImage = matchesImage;
        this.matchesName = matchesName;
    }

    public int getMatchesImage() {
        return matchesImage;
    }

    public void setMatchesImage(int matchesImage) {
        this.matchesImage = matchesImage;
    }

    public String getMatchesName() {
        return matchesName;
    }

    public void setMatchesName(String matchesName) {
        this.matchesName = matchesName;
    }
}
