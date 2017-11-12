package samet.com.bp;


import android.app.FragmentManager;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.glassfish.jersey.internal.guava.Predicates;


public class MainActivity extends AppCompatActivity  {

    Button kayitbuton,girisbuton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        kayitbuton= (Button) findViewById(R.id.kayitbuton);
        girisbuton= (Button) findViewById(R.id.girisbuton);



        kayitbuton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

Intent intent=new Intent(MainActivity.this,Kayit1.class);
                startActivity(intent);




            }
        });


        girisbuton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Giris.class);
                startActivity(intent);
            }
        });








    }









}
