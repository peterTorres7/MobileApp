package com.example.helloworld;

import android.os.Parcel;
import android.os.Parcelable;

public class MatchesDataModel implements Parcelable {

    public String imageUrl;
    public boolean liked;
    public String name;
    public String uid;

    public MatchesDataModel() {
    }

    public MatchesDataModel(String imageUrl, String name, boolean liked) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.liked = liked;
    }

    public MatchesDataModel(Parcel in) {
        imageUrl = in.readString();
        name = in.readString();
        liked = in.readByte() != 0;
    }

    public static final Creator<MatchesDataModel> CREATOR = new Creator<MatchesDataModel>() {
        @Override
        public MatchesDataModel createFromParcel(Parcel in) {
            return new MatchesDataModel(in);
        }

        @Override
        public MatchesDataModel[] newArray(int size) {
            return new MatchesDataModel[size];
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
