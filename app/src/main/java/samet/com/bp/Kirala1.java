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

public class Kirala1 extends AppCompatActivity {
Button btn,dairebtn,evbtn;
    Toolbar tb;

     SharedPreferences sharedPref;
     SharedPreferences.Editor editor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kirala1);

        sharedPref = getApplicationContext().getSharedPreferences("MyPref",0);
        editor = sharedPref.edit();

        tb= (Toolbar) findViewById(R.id.supappbar);
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        dairebtn= (Button) findViewById(R.id.dairebtn);
        evbtn= (Button) findViewById(R.id.evbtn);


        btn= (Button) findViewById(R.id.geribtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kirala1.this,Ilanver2.class);
                startActivity(intent);
            }
        });



        dairebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("kirala1mulktur","daire");
                editor.commit();
                Intent intent = new Intent(Kirala1.this,Kirala2.class);
                startActivity(intent);
            }
        });


        evbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("kirala1mulktur","ev");
                editor.commit();
                Intent intent = new Intent(Kirala1.this,Kirala2.class);
                startActivity(intent);
            }
        });



    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Kirala1.this,Ilanver2.class);
        startActivity(intent);
    }
}
