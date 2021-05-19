package com.example.helloworld;

import android.os.Parcel;
import android.os.Parcelable;

public class MatchesModel implements Parcelable {

    public String imageUrl;
    public boolean liked;
    public String name;
    public String uid;

    public MatchesModel() {
    }

    public MatchesModel(String imageUrl, String name, boolean liked) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.liked = liked;
    }

    public MatchesModel(Parcel in) {
        imageUrl = in.readString();
        name = in.readString();
        liked = in.readByte() != 0;
    }

    public static final Creator<MatchesModel> CREATOR = new Creator<MatchesModel>() {
        @Override
        public MatchesModel createFromParcel(Parcel in) {
            return new MatchesModel(in);
        }

        @Override
        public MatchesModel[] newArray(int size) {
            return new MatchesModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(imageUrl);
        dest.writeString(name);
        dest.writeByte((byte) (liked ? 1 : 0));
    }
}
