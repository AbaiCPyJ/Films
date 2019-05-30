package com.example.user_pc.films;

import android.os.Parcel;
import android.os.Parcelable;





import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Film implements Parcelable {
    private String name;
    private String country;
    private String genre;
    private int ID;
    public Film() {
    }

    public Film(String name, String country, String genre) {
        this.name = name;
        this.country = country;
        this.genre = genre;
    }
    public Film(String str){
        String[] w = str.split("/");
        this.name = w[0];
        this.country = w[1];
        this.genre = w[2];
        //  System.out.println("MyLog: group ="+group);
        //  System.out.println("MyLog: group ="+w[1]);
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    protected Film(Parcel in) {
        name = in.readString();
        country = in.readString();
        genre = in.readString();
        ID = in.readInt();
    }

    public static final Creator<Film> CREATOR = new Creator<Film>() {
        @Override
        public Film createFromParcel(Parcel in) {
            return new Film(in);
        }

        @Override
        public Film[] newArray(int size) {
            return new Film[size];
        }
    };

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "MyLog: " + name + " " + country + " " + genre;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.country);
        parcel.writeString(this.genre);
        parcel.writeInt(this.ID);
    }
}
