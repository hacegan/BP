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

public class OdaAra7 extends AppCompatActivity {

    Button btn,btndvm;
    Toolbar tb;
    CheckBox erkek,kiz,ogrenci,calisan,sigara,hayvan;
    SharedPreferences sharedPref ;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.odaiste7);
        btn= (Button) findViewById(R.id.geribtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OdaAra7.this,OdaAra6.class);
                startActivity(intent);
            }
        });

        tb= (Toolbar) findViewById(R.id.supappbar);
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sharedPref = getApplicationContext().getSharedPreferences("MyPref",0);
        editor = sharedPref.edit();

        btndvm= (Button) findViewById(R.id.btndvm);




        erkek= (CheckBox) findViewById(R.id.odaara7erkekcb);
        kiz= (CheckBox) findViewById(R.id.odaara7kizcb);
        calisan= (CheckBox) findViewById(R.id.odaara7calisancb);
        ogrenci= (CheckBox) findViewById(R.id.odaara7ogrencicb);
        sigara= (CheckBox) findViewById(R.id.odaara7sigaracb);
        hayvan= (CheckBox) findViewById(R.id.odaara7hayvancb);

        btndvm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(erkek.isChecked()){
                    editor.putString("odaara7erkek","evet");
                    editor.commit();
                }

                if(kiz.isChecked()){
                    editor.putString("odaara7kiz","evet");
                    editor.commit();
                }

                if(ogrenci.isChecked()){
                    editor.putString("odaara7ogr","evet");
                    editor.commit();
                }

                if(calisan.isChecked()){
                    editor.putString("odaara7clsn","evet");
                    editor.commit();
                }

                if(sigara.isChecked()){
                    editor.putString("odaara7sgr","evet");
                    editor.commit();
                }

                if(hayvan.isChecked()){
                    editor.putString("odaara7hyvn","evet");
                    editor.commit();
                }



                Intent intent = new Intent(OdaAra7.this,OdaAra8.class);
                startActivity(intent);
            }
        });





    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(OdaAra7.this,OdaAra6.class);
        startActivity(intent);
    }
}
