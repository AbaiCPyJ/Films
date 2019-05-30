package com.example.user_pc.films;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class CentralActivity extends Activity {
    private int MAX_NUMBER_FILMS = 100;
    private FilmWorld filmWorld = new FilmWorld();
    private List<Film> films = new ArrayList<>();
    private ListView listView;
    private FilmAdapter filmAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_central);
        filmWorld = readFilmsFromAssets();
        films= filmWorld.getFilms();

        listView = findViewById(R.id.listview);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                System.out.println(("MyLog: Central " +i+ " "+j));

                Intent intent = new Intent(CentralActivity.this, WatchActivity.class);
                intent.putExtra("numRow", i);
                intent.putExtra("name", films.get(i).getName());
                System.out.println("MyLog : Central " + films.get(i).toString());
                startActivity(intent);
            }
        });


        filmAdapter = new FilmAdapter (this, R.layout.adapter_film, films);
        listView.setAdapter(filmAdapter);
    }

    public void Back(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    public  Film readFilmFromAssets(String fileName){
        Film film;
        BufferedReader reader = null;
        String str = null;
        //   String fName = String.valueOf(fileName)+"/name.txt";
        try {
            reader = new BufferedReader(new InputStreamReader(getAssets().open(fileName+"/name.txt")));
            str = reader.readLine();
            reader.close();

            film = new Film(str);
            film.setID(Integer.parseInt(fileName));
            System.out.println("MyLog - readFilm: "+film.toString() + " ID= " + film.getID());
        } catch (Exception e) {
            //  System.out.println("MyLog: FileError " + fileName);
            film = null;
            e.printStackTrace();
        }
        return film;
    }
    public FilmWorld readFilmsFromAssets(){
        FilmWorld r = new FilmWorld();
        Film film = new Film();
        for (int i=1; i<= MAX_NUMBER_FILMS; i++) {
            film = readFilmFromAssets(Integer.toString(i));
             /* if(film == null) {System.out.println("MyLog: dog == null");}
               System.out.println("MyLog: "+ film.getID());
              System.out.println(film.toString());*/
            r.add(film);
        }

        return r;
    }


}/*
import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ListView;
        import android.widget.Toast;

        import java.util.ArrayList;
        import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<State> states = new ArrayList();

    ListView countriesList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // начальная инициализация списка
        setInitialData();
        // получаем элемент ListView
        countriesList = (ListView) findViewById(R.id.countriesList);
        // создаем адаптер
        StateAdapter stateAdapter = new StateAdapter(this, R.layout.list_item, states);
        // устанавливаем адаптер
        countriesList.setAdapter(stateAdapter);
        // слушатель выбора в списке
        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                // получаем выбранный пункт
                State selectedState = (State)parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), "Был выбран пункт " + selectedState.getName(),
                        Toast.LENGTH_SHORT).show();
            }
        };
        countriesList.setOnItemClickListener(itemListener);
    }
    private void setInitialData(){

        states.add(new State ("Бразилия", "Бразилиа", R.drawable.brazilia));
        states.add(new State ("Аргентина", "Буэнос-Айрес", R.drawable.argentina));
        states.add(new State ("Колумбия", "Богота", R.drawable.columbia));
        states.add(new State ("Уругвай", "Монтевидео", R.drawable.uruguai));
        states.add(new State ("Чили", "Сантьяго", R.drawable.chile));
    }
*/