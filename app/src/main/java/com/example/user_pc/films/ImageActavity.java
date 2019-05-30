package com.example.user_pc.films;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ImageActavity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        Bundle arguments = getIntent().getExtras();
        int number = arguments.getInt("numRow");

       System.out.println("MyLog Watch: " + number);


        ImageView imageView = (ImageView) findViewById(R.id.imageView2) ;
        String filename = number + "/A1.jpg";

        InputStream inputStream = null;
        try{
            inputStream = getApplicationContext().getAssets().open(filename);
            Drawable d = Drawable.createFromStream(inputStream, null);
            imageView.setImageDrawable(d);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            try{
                if(inputStream!=null)
                    inputStream.close();
            }
            catch (IOException ex){
                ex.printStackTrace();
            }
        }
    }


    public void ToCentralActiviy(View view) {
        Intent intent = new Intent(ImageActavity.this, CentralActivity.class);

        startActivity(intent);
    }
}





//    public void loadImageFromAsset(String dirName) {
//
//        try {
//
//            InputStream ims = getAssets().open(dirName + "/A1.jpg");
//            // загружаем как Drawable
//            Drawable d = Drawable.createFromStream(ims, null);
//            //Drawable d = Drawable.createFromStream(ims, null);
//            // выводим картинку в ImageView
//
//
//            System.out.println("MyLog:" + numRow);
//            //loadImageFromAsset(String.valueOf(numRow+1));
//            //loadImageFromAsset(String.valueOf(numRow + 1));
//           imageView.setImageDrawable(d);
//
//        }
//        catch(IOException ex) {
//            return;
//        }
//
//    }


/*
public class ImageActavity extends AppCompatActivity {
    public void ToCentralActiviy(View view) {
        Intent intent = new Intent(ImageActavity.this, CentralActivity.class);
        startActivity(intent);
    }
    public void loadImageFromAsset() {
        try {
            // получаем входной поток
            InputStream ims = getAssets().open("A1.jpg");
            // загружаем как Drawable
            Drawable d = Drawable.createFromStream(ims, null);
            // выводим картинку в ImageView
            mImage.setImageDrawable(d);
        }
        catch(IOException ex) {
            return;
        }
    }

}
*/