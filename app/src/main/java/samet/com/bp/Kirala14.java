package samet.com.bp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by root on 20.11.2017.
 */

public class Kirala14 extends AppCompatActivity {
    Button btn,btnevet,btnhayir;
    Toolbar tb;
    EditText numaraet;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kirala14);
        btn= (Button) findViewById(R.id.geribtn);

        tb= (Toolbar) findViewById(R.id.supappbar);
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sharedPref = getApplicationContext().getSharedPreferences("MyPref",0);
        editor = sharedPref.edit();

        numaraet = (EditText) findViewById(R.id.telefonnoet);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kirala14.this,Kirala13.class);
                startActivity(intent);
            }
        });

        btnevet= (Button) findViewById(R.id.btnevet);
        btnhayir= (Button) findViewById(R.id.btnhayir);

        btnevet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              /*  Intent intent = new Intent(Kirala14.this,Kirala15.class);
                startActivity(intent);*/

                AlertDialog.Builder builder=new AlertDialog.Builder(Kirala14.this);
                LayoutInflater inflater=getLayoutInflater();
                View dialog_layout=inflater.inflate(R.layout.telefonnoekleme,null);
builder.setView(dialog_layout).setPositiveButton("ONAYLA", new DialogInterface.OnClickListener() {
    @Override
    public void onClick(DialogInterface dialogInterface, int i) {


String numara=numaraet.getText().toString();
        editor.putString("kirala14numara",numara);
        editor.commit();

        Intent intent = new Intent(Kirala14.this,Kirala15.class);
        startActivity(intent);

    }
})
        .setNegativeButton("İPTAL ET", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

                builder.show();


            }
        });

        btnhayir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kirala14.this,Kirala15.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Kirala14.this,Kirala13.class);
        startActivity(intent);
    }
}
