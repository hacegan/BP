package samet.com.bp;

import android.content.Intent;
import android.content.SharedPreferences;
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
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kirala12);
        btn= (Button) findViewById(R.id.geribtn);

        tb= (Toolbar) findViewById(R.id.supappbar);
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sharedPref = getApplicationContext().getSharedPreferences("MyPref",0);
        editor = sharedPref.edit();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kirala12.this,Kirala11.class);
                startActivity(intent);
            }
        });

        btndvm= (Button) findViewById(R.id.btndvm);

        erkek= (CheckBox) findViewById(R.id.kirala12erkekcb);
        kiz= (CheckBox) findViewById(R.id.kirala12kizcb);
        calisan= (CheckBox) findViewById(R.id.kirala12calisancb);
        ogrenci= (CheckBox) findViewById(R.id.kirala12ogrencicb);
        sigara= (CheckBox) findViewById(R.id.kirala12sigaracb);
        hayvan= (CheckBox) findViewById(R.id.kirala12hayvancb);

        btndvm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(erkek.isChecked()){
                    editor.putString("kirala12erkek","");
                    editor.commit();
                }

                if(kiz.isChecked()){
                    editor.putString("kirala12kiz","evet");
                    editor.commit();
                }

                if(ogrenci.isChecked()){
                    editor.putString("kirala12ogr","evet");
                    editor.commit();
                }

                if(calisan.isChecked()){
                    editor.putString("kirala12clsn","evet");
                    editor.commit();
                }

                if(sigara.isChecked()){
                    editor.putString("kirala12sgr","evet");
                    editor.commit();
                }

                if(hayvan.isChecked()){
                    editor.putString("kirala12hyvn","evet");
                    editor.commit();
                }



                Intent intent = new Intent(Kirala12.this,Kirala13.class);
                startActivity(intent);
            }
        });










    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Kirala12.this,Kirala11.class);
        startActivity(intent);
    }
}
