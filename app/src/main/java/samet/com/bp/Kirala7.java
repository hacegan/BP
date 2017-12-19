package samet.com.bp;

import android.content.Context;
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

public class Kirala7 extends AppCompatActivity {
    Button btn,odaeklebtn,btndvm;
    Toolbar tb;
    EditText m2,oda,kat,bkat,aidat,kira,esya;

    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kirala7);

        sharedPref = getPreferences(Context.MODE_PRIVATE);
        editor = sharedPref.edit();

        btn= (Button) findViewById(R.id.geribtn);
        //odaeklebtn= (Button) findViewById(R.id.odaeklebtn);
btndvm= (Button) findViewById(R.id.btndvm);



        m2= (EditText) findViewById(R.id.kiralam2et);
oda= (EditText) findViewById(R.id.kiralaodaet);
        kat= (EditText) findViewById(R.id.kiralakatet);
        bkat= (EditText) findViewById(R.id.kiralabkatet);
        aidat= (EditText) findViewById(R.id.kiralaaidatet);
        kira= (EditText) findViewById(R.id.kiralakiraet);
        esya= (EditText) findViewById(R.id.kiralaesyaliet);

        tb= (Toolbar) findViewById(R.id.supappbar);
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

btndvm.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        editor.putString("kirala7m2",m2.getText().toString());
        editor.putString("kirala7oda",oda.getText().toString());
        editor.putString("kirala7kat",kat.getText().toString());
        editor.putString("kirala7bkat",bkat.getText().toString());
        editor.putString("kirala7aidat",aidat.getText().toString());
        editor.putString("kirala7kira",kira.getText().toString());
        editor.putString("kirala7esya",esya.getText().toString());
        editor.commit();
        Intent intent = new Intent(Kirala7.this,Kirala8.class);
        startActivity(intent);
    }
});

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kirala7.this,Kirala6.class);
                startActivity(intent);
            }
        });


    /*    odaeklebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kirala7.this,OdaEkle.class);
                startActivity(intent);
            }
        });*/


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Kirala7.this,Kirala6.class);
        startActivity(intent);
    }
}
