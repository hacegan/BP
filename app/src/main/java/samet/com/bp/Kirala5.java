package samet.com.bp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by root on 20.11.2017.
 */

public class Kirala5 extends AppCompatActivity {
    Button btn,btndvm;
TextView tv;
String oldxml;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kirala5);
        btn= (Button) findViewById(R.id.geribtn);
        tv= (TextView) findViewById(R.id.locadresid);
        btndvm= (Button) findViewById(R.id.btndvm);



        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("MyPref", 0);
        SharedPreferences.Editor editor = sharedPref.edit();

        tv.setText(sharedPref.getString("locations",null));


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("MyPref", 0);
                SharedPreferences.Editor editor = sharedPref.edit();
        oldxml=        sharedPref.getString("oldxml",null);

                if(oldxml=="Kirala3.class") {
                    Intent intent = new Intent(Kirala5.this, Kirala3.class);
                    startActivity(intent);
                }
              else  if(oldxml=="Kirala4.class") {
                    Intent intent = new Intent(Kirala5.this, Kirala4.class);
                    startActivity(intent);
                }

            }
        });


        btndvm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kirala5.this,Kirala6.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public void onBackPressed() {
        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("MyPref", 0);
        SharedPreferences.Editor editor = sharedPref.edit();
        oldxml=        sharedPref.getString("oldxml",null);

        if(oldxml=="Kirala3.class") {
            Intent intent = new Intent(Kirala5.this, Kirala3.class);
            startActivity(intent);
        }
        else if(oldxml=="Kirala4.class") {
            Intent intent = new Intent(Kirala5.this, Kirala4.class);
            startActivity(intent);
        }

    }
}
