package com.example.user_pc.films;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WatchActivity extends Activity {
    public int numRow;
    private String name;


    Film film = new Film();
    // TextView textView;
    LinearLayout llMain;
    int wrapContent = LinearLayout.LayoutParams.WRAP_CONTENT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch);
        numRow = getIntent().getIntExtra("numRow", 0);


        name = getIntent().getStringExtra("name");
        System.out.println("MyLog Watch: " + numRow + " " + name);
        //   Bundle data = getIntent().getExtras();

        //    dog = (Dog) data.getParcelable("Dog");

        //   System.out.println("MyLog - Watch:" + dog.toString()+ " ID = " + dog.getID());


        TextView textView2;
        textView2 = findViewById(R.id.textView2);
        textView2.setText(name);
        textView2.setVisibility(View.VISIBLE);
        //  textView2.setVisibility(View.VISIBLE);
        TextView textView;
        textView = findViewById(R.id.textView);
        textView.setVisibility(View.VISIBLE);

        textView.setMovementMethod(new ScrollingMovementMethod());
        String str;
        System.out.println("MyLog:" + numRow);
        //   str = readTextFromAssets(Integer.toString(numRow+1));
        str = readTextFromAssets(Integer.toString(numRow + 1));
        textView.setText(str);


        //   numRow = getIntent().getIntExtra("numRow", 0);
        // numRow = dog.getID();
        System.out.println("MyLog - WatchActivity " + numRow);

    }

    public void ToCentralActivity(View view) {
        Intent intent = new Intent(WatchActivity.this, CentralActivity.class);

        startActivity(intent);
    }
    public void ToImageActivity(View view) {
        Intent intent = new Intent(WatchActivity.this, ImageActavity.class);
        intent.putExtra("numRow", numRow+1);
        startActivity(intent);

    }



    public String readTextFromAssets(String dirName) {

        String line;
        String str = " ";

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(getAssets().open(dirName + "/t1.txt")));
            while ((line = reader.readLine()) != null) {
                str = str + line;
            }

            reader.close();
            // System.out.println("MyLog- readTextFromAsseta: "+str);
        } catch (IOException e) {
            System.out.println("MyLog - readTextFromAsseta: FileError " + dirName);
            e.printStackTrace();
        }
        return str;
    }


    public int getNumRow() {
        return numRow;
    }

    public void setNumRow(int numRow) {
        this.numRow = numRow;
    }
}
