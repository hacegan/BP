package samet.com.bp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

/**
 * Created by root on 20.11.2017.
 */

public class Kirala12 extends AppCompatActivity {
    Button btn,btndvm;
    Toolbar tb;
    CheckBox erkek,kiz,calisan,ogrenci,sigara,hayvan;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kirala12);
        btn= (Button) findViewById(R.id.geribtn);

        tb= (Toolbar) findViewById(R.id.supappbar);
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kirala12.this,Kirala11.class);
                startActivity(intent);
            }
        });

        btndvm= (Button) findViewById(R.id.btndvm);
        btndvm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kirala12.this,Kirala13.class);
                startActivity(intent);
            }
        });


       erkek= (CheckBox) findViewById(R.id.kirala12erkekcb);
        kiz= (CheckBox) findViewById(R.id.kirala12kizcb);
calisan= (CheckBox) findViewById(R.id.kirala12calisancb);
        ogrenci= (CheckBox) findViewById(R.id.kirala12ogrencicb);
        sigara= (CheckBox) findViewById(R.id.kirala12sigaracb);
        hayvan= (CheckBox) findViewById(R.id.kirala12hayvancb);

       if(erkek.isChecked()){

       }

        if(kiz.isChecked()){

        }

        if(ogrenci.isChecked()){

        }

        if(calisan.isChecked()){

        }

        if(sigara.isChecked()){

        }

        if(hayvan.isChecked()){

        }



    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Kirala12.this,Kirala11.class);
        startActivity(intent);
    }
}
