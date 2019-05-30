package com.example.user_pc.films;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FilmAdapter extends ArrayAdapter<Film> {

    private LayoutInflater inflater;
    private int layout;
    private List<Film> films;

    public FilmAdapter(Context context, int resource, List<Film> films) {
        super(context, resource, films);
        this.films = films;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }
    public View getView(int position, View convertView, ViewGroup parent) {

        View view=inflater.inflate(this.layout, parent, false);


        TextView nameView = view.findViewById(R.id.name);
        TextView countryView = view.findViewById(R.id.country);
        TextView genreView = view.findViewById(R.id.genre);

        Film film = films.get(position);



        nameView.setText(film.getName());
        countryView.setText(String.valueOf(film.getCountry()));
        genreView.setText(String.valueOf(film.getGenre()));

        return view;
    }
}/*
import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.ImageView;
        import android.widget.TextView;

        import java.util.List;

public class StateAdapter extends ArrayAdapter<State> {

    private LayoutInflater inflater;
    private int layout;
    private List<State> states;

    public StateAdapter(Context context, int resource, List<State> states) {
        super(context, resource, states);
        this.states = states;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }
    public View getView(int position, View convertView, ViewGroup parent) {

        View view=inflater.inflate(this.layout, parent, false);

        ImageView flagView = (ImageView) view.findViewById(R.id.flag);
        TextView nameView = (TextView) view.findViewById(R.id.name);
        TextView capitalView = (TextView) view.findViewById(R.id.capital);

        State state = states.get(position);

        flagView.setImageResource(state.getFlagResource());
        nameView.setText(state.getName());
        capitalView.setText(state.getCapital());

        return view;
    */