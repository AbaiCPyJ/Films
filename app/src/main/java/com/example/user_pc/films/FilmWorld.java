package com.example.user_pc.films;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("ParcelCreator")
public class FilmWorld implements Parcelable {
    private List<Film> films = new ArrayList<>();

    public FilmWorld() {
    }
    public void clear(){
        films.clear();
    }
    protected FilmWorld(Parcel in) {
        films = in.createTypedArrayList(Film.CREATOR);
    }

    public static final Creator<FilmWorld> CREATOR = new Creator<FilmWorld>() {
        @Override
        public FilmWorld createFromParcel(Parcel in) {
            return new FilmWorld(in);
        }

        @Override
        public FilmWorld[] newArray(int size) {
            return new FilmWorld[size];
        }
    };

    public List<Film> getFilms() {
        return films;
    }
    public boolean dublicateNameID(Film film){
        boolean result = false;
        if (film == null) return true;
        for (Film r: films) {
            if( (film.getName().compareTo(r.getName()) == 0)
                    || (film.getID() == r.getID() )
                    ) result = true;
        }
        return result;
    }

    public void add(Film film){
        //  System.out.println("MyLog-add 1");
        if(!dublicateNameID(film) && (film != null)) {
            //   System.out.println("MyLog-add 2");
            films.add(new Film(film.getName(), film.getCountry(), film.getGenre()));
            //   System.out.println("MyLog-add 3");
        }
        // System.out.println("MyLog-add 4");
    }
    public void fill(){

        films.add(new Film("Halloween", "USA", "Horror"));
        films.add(new Film("hgg2g", "iyuu", "ewre"));
        films.add(new Film("ggg3", "iyuu", "ewre"));
        films.add(new Film("ggg4", "iyuu", "ewre"));
        films.add(new Film("ggg5", "iyuu", "ewre"));
        films.add(new Film("ggg6", "iyuu", "ewre"));
        films.add(new Film("ggg7", "iyuu", "ewre"));
        films.add(new Film("ggg8", "iyuu", "ewre"));
        films.add(new Film("ggg9", "iyuu", "ewre"));
        films.add(new Film("ggg10", "iyuu", "ewre"));

    }

    public void show(){
        for (Film film: films) {
            System.out.println(film.toString());

        }
        System.out.println();

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(films);
    }
}
