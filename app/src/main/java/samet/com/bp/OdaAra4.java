package samet.com.bp;

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

public class OdaAra4 extends AppCompatActivity {

    Button btn,btnogr,btnclsn,btndgr;
    Toolbar tb;
    SharedPreferences sharedPref ;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.odaiste4);
        btn= (Button) findViewById(R.id.geribtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OdaAra4.this,OdaAra3.class);
                startActivity(intent);
            }
        });

        tb= (Toolbar) findViewById(R.id.supappbar);
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sharedPref = getApplicationContext().getSharedPreferences("MyPref",0);
        editor = sharedPref.edit();

        btnclsn= (Button) findViewById(R.id.btncalisan);
        btndgr= (Button) findViewById(R.id.btndiger);
        btnogr= (Button) findViewById(R.id.btnogrenci);

        btnclsn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("odaara4calisan", "odaara4calisan");
                editor.commit();
                Intent intent = new Intent(OdaAra4.this,OdaAra5.class);
                startActivity(intent);
            }
        });


        btndgr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("odaara4diger", "odaara4diger");
                editor.commit();
                Intent intent = new Intent(OdaAra4.this,OdaAra5.class);
                startActivity(intent);
            }
        });

        btnogr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("odaara4ogrenci", "odaara4ogrenci");
                editor.commit();
                Intent intent = new Intent(OdaAra4.this,OdaAra5.class);
                startActivity(intent);
            }
        });



    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(OdaAra4.this,OdaAra3.class);
        startActivity(intent);
    }
}
