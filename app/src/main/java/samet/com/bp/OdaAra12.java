package samet.com.bp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

/**
 * Created by root on 20.11.2017.
 */

public class OdaAra12 extends AppCompatActivity {

    Button btn,btnhergun,btnhici,btnhsonu;
    Toolbar tb;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.odaiste12);
        btn= (Button) findViewById(R.id.geribtn);


        tb= (Toolbar) findViewById(R.id.supappbar);
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OdaAra12.this,OdaAra11.class);
                startActivity(intent);
            }
        });

        btnhergun= (Button) findViewById(R.id.hergunbtn);
        btnhici= (Button) findViewById(R.id.hicibtn);
        btnhsonu= (Button) findViewById(R.id.hsonubtn);


        btnhergun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OdaAra12.this,OdaAra13.class);
                startActivity(intent);
            }
        });


        btnhici.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OdaAra12.this,OdaAra13.class);
                startActivity(intent);
            }
        });


        btnhsonu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OdaAra12.this,OdaAra13.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(OdaAra12.this,OdaAra11.class);
        startActivity(intent);
    }
}
