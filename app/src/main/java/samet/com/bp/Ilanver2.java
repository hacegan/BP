package samet.com.bp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created by root on 18.11.2017.
 */

public class Ilanver2 extends AppCompatActivity {
Button btn;
    ImageButton btnara,btnkirala;
    Toolbar tb;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ilanver2);


        tb= (Toolbar) findViewById(R.id.supappbar);
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        btnara= (ImageButton) findViewById(R.id.aragitbtn);
        btnkirala= (ImageButton) findViewById(R.id.kiralagitbtn);

        btn=(Button)findViewById(R.id.geribtn);
btn.setOnClickListener(new View.OnClickListener() {//Bir önceki adıma dönmek için
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Ilanver2.this,Ilanver1.class);
        startActivity(intent);
    }
});

btnara.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Ilanver2.this,OdaAra1.class);
        startActivity(intent);
    }
});


btnkirala.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Ilanver2.this,Kirala1.class);
        startActivity(intent);
    }
});



    }





}
