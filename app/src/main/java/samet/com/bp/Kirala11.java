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

public class Kirala11 extends AppCompatActivity {
    Button btn,evet,hayir;
    Toolbar tb;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kirala11);
        btn= (Button) findViewById(R.id.geribtn);


        tb= (Toolbar) findViewById(R.id.supappbar);
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sharedPref = getApplicationContext().getSharedPreferences("MyPref",0);
        editor = sharedPref.edit();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kirala11.this,Kirala10.class);
                startActivity(intent);
            }
        });

evet= (Button) findViewById(R.id.btnevet);
        hayir= (Button) findViewById(R.id.btnhayir);
        evet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("kirala11evet","evet");
                editor.commit();
                Intent intent = new Intent(Kirala11.this,Kirala12.class);
                startActivity(intent);
            }
        });

        hayir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("kirala11hayir","hayir");
                editor.commit();
                Intent intent = new Intent(Kirala11.this,Kirala12.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Kirala11.this,Kirala10.class);
        startActivity(intent);
    }
}
