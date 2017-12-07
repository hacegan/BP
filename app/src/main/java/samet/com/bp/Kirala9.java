package samet.com.bp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by root on 20.11.2017.
 */

public class Kirala9 extends AppCompatActivity {
    Button btn,btnkizartir,btnkizazalt,btnerkekartir,btnerkekazalt,btndvm;
TextView erkektv,kiztv;
    Toolbar tb;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kirala9);
        btn= (Button) findViewById(R.id.geribtn);

        tb= (Toolbar) findViewById(R.id.supappbar);
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kirala9.this,Kirala8.class);
                startActivity(intent);
            }
        });

        btndvm= (Button) findViewById(R.id.btndvm);

        btnerkekartir= (Button) findViewById(R.id.erkekartirbtn);
        btnerkekazalt= (Button) findViewById(R.id.erkekazaltbtn);
        btnkizartir= (Button) findViewById(R.id.kizartirbtn);
        btnkizazalt= (Button) findViewById(R.id.kizazaltbtn);
        erkektv= (TextView) findViewById(R.id.erkeksayitv);
        kiztv= (TextView) findViewById(R.id.kizsayitv);


        btnerkekartir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deger=Integer.valueOf(erkektv.getText().toString());
erkektv.setText(deger+1);
            }
        });


        btnerkekazalt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deger=Integer.valueOf(erkektv.getText().toString());
                erkektv.setText(deger-1);
            }
        });

        btnkizazalt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deger=Integer.valueOf(erkektv.getText().toString());
                kiztv.setText(deger+1);
            }
        });

        btnkizartir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deger=Integer.valueOf(erkektv.getText().toString());
                kiztv.setText(deger-1);
            }
        });


btndvm.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Kirala9.this,Kirala10.class);
        startActivity(intent);
    }
});



    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Kirala9.this,Kirala8.class);
        startActivity(intent);
    }
}
