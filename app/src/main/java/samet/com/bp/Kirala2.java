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

public class Kirala2 extends AppCompatActivity {
    Button btn,btnadvertiser1,btnadvertiser2,btnadvertiser3,btnadvertiser4,btnadvertiser5;
    Toolbar tb;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kirala2);

        tb= (Toolbar) findViewById(R.id.supappbar);
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnadvertiser1= (Button) findViewById(R.id.btnadvertiser1);
                btnadvertiser2= (Button) findViewById(R.id.btnadvertiser2);





        btn= (Button) findViewById(R.id.geribtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kirala2.this,Kirala1.class);
                startActivity(intent);
            }
        });

        btnadvertiser1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kirala2.this,Kirala3.class);
                startActivity(intent);
            }
        });


        btnadvertiser2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kirala2.this,Kirala3.class);
                startActivity(intent);
            }
        });







    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Kirala2.this,Kirala1.class);
        startActivity(intent);
    }
}
