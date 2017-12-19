package samet.com.bp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by root on 20.11.2017.
 */

public class Kirala15 extends AppCompatActivity {
    Button btn,btndvm;
    Toolbar tb;
    EditText baslik,aciklama;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kirala15);
        btn= (Button) findViewById(R.id.geribtn);

        tb= (Toolbar) findViewById(R.id.supappbar);
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sharedPref = getApplicationContext().getSharedPreferences("MyPref",0);
        editor = sharedPref.edit();

        baslik= (EditText) findViewById(R.id.kirala15baslik);
        aciklama= (EditText) findViewById(R.id.kirala15aciklama);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kirala15.this,Kirala14.class);
                startActivity(intent);
            }
        });


        btndvm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("kirala15baslik",baslik.getText().toString());
                editor.putString("kirala15aciklama",aciklama.getText().toString());
                editor.commit();

            }
        });


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Kirala15.this,Kirala14.class);
        startActivity(intent);
    }


    public class KiralaTask extends AsyncTask{


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
        }

        @Override
        protected Object doInBackground(Object[] params) {
            return null;
        }




    }



}
