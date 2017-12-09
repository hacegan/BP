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

public class Kirala7 extends AppCompatActivity {
    Button btn,odaeklebtn,btndvm;
    Toolbar tb;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kirala7);
        btn= (Button) findViewById(R.id.geribtn);
        odaeklebtn= (Button) findViewById(R.id.odaeklebtn);
btndvm= (Button) findViewById(R.id.btndvm);



        tb= (Toolbar) findViewById(R.id.supappbar);
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

btndvm.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Kirala7.this,Kirala8.class);
        startActivity(intent);
    }
});

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kirala7.this,Kirala6.class);
                startActivity(intent);
            }
        });


        odaeklebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kirala7.this,OdaEkle.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Kirala7.this,Kirala6.class);
        startActivity(intent);
    }
}
