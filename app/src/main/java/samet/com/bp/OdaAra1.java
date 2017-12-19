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

/**
 * Created by root on 20.11.2017.
 */

public class OdaAra1 extends AppCompatActivity {

    Button btn,btnbay,btnbayan,btnikisi;
    Toolbar tb;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.odaiste1);

        sharedPref = getApplicationContext().getSharedPreferences("MyPref",0);
        editor = sharedPref.edit();


        btn= (Button) findViewById(R.id.geribtn);

        btnbay= (Button) findViewById(R.id.btnbay);
        btnbayan= (Button) findViewById(R.id.btnbayan);
        btnikisi= (Button) findViewById(R.id.bayplusbayan);


        tb= (Toolbar) findViewById(R.id.supappbar);
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OdaAra1.this,Ilanver2.class);
                startActivity(intent);
            }
        });


        btnbay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("odaara1bay","bay");
                editor.commit();
                Intent intent = new Intent(OdaAra1.this,OdaAra2.class);
                startActivity(intent);
            }
        });

        btnbayan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("odaara1bayan","bayan");
                editor.commit();
                Intent intent = new Intent(OdaAra1.this,OdaAra2.class);
                startActivity(intent);
            }
        });

        btnikisi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("odaara1ikisi","ikisi");
                editor.commit();
                Intent intent = new Intent(OdaAra1.this,OdaAra2.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(OdaAra1.this,Ilanver2.class);
        startActivity(intent);
    }

}
