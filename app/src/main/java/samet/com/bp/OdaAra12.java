package samet.com.bp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by root on 20.11.2017.
 */

public class OdaAra12 extends AppCompatActivity {

    Button btn,btnhergun,btnhici,btnhsonu,btndvm;
    Toolbar tb;
    EditText et;
    SharedPreferences sharedPref ;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.odaiste12);
        btn= (Button) findViewById(R.id.geribtn);
        btndvm= (Button) findViewById(R.id.btndvm);


        tb= (Toolbar) findViewById(R.id.supappbar);
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sharedPref = getApplicationContext().getSharedPreferences("MyPref",0);
        editor = sharedPref.edit();

        et= (EditText) findViewById(R.id.odaara12et);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OdaAra12.this,OdaAra11.class);
                startActivity(intent);
            }
        });

      /*  btnhergun= (Button) findViewById(R.id.hergunbtn);
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
        });*/

btndvm.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        editor.putString("odaara12sure", et.getText().toString());
        editor.commit();
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
