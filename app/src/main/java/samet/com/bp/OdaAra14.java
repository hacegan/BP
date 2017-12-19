package samet.com.bp;

import android.content.Intent;
import android.content.SharedPreferences;
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

public class OdaAra14 extends AppCompatActivity {

    Button btn,btndvm;
    Toolbar tb;
    EditText aciklama,baslik;
    SharedPreferences sharedPref ;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.odaiste14);


        tb= (Toolbar) findViewById(R.id.supappbar);
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        sharedPref = getApplicationContext().getSharedPreferences("MyPref",0);
        editor = sharedPref.edit();

        aciklama= (EditText) findViewById(R.id.oda14aciklama);
baslik= (EditText) findViewById(R.id.oda14baslik);

        btndvm= (Button) findViewById(R.id.btnodaarayayinla);


        btn= (Button) findViewById(R.id.btnodaarayayinla);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btndvm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("odaara14baslik", baslik.getText().toString());
                editor.putString("odaara14aciklama", aciklama.getText().toString());
                editor.commit();


            }
        });



    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(OdaAra14.this,OdaAra13.class);
        startActivity(intent);
    }
}
