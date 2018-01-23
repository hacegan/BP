package samet.com.bp;

import android.app.AlertDialog;
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

/**
 * Created by root on 20.11.2017.
 */

public class OdaAra13 extends AppCompatActivity {

    Button btn,btnevet,btnhayir;
    Toolbar tb;
    SharedPreferences sharedPref ;
    SharedPreferences.Editor editor;
    EditText numaraet;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.odaiste13);
        btn= (Button) findViewById(R.id.geribtn);
        btnevet= (Button) findViewById(R.id.btnevet);
        btnhayir= (Button) findViewById(R.id.btnhayir);

        tb= (Toolbar) findViewById(R.id.supappbar);
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sharedPref = getApplicationContext().getSharedPreferences("MyPref",0);
        editor = sharedPref.edit();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OdaAra13.this,OdaAra12.class);
                startActivity(intent);
            }
        });


        btnevet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              /*  Intent intent = new Intent(OdaAra13.this,OdaAra14.class);
                startActivity(intent);*/


                AlertDialog.Builder builder=new AlertDialog.Builder(OdaAra13.this);
                LayoutInflater inflater=getLayoutInflater();
                View dialog_layout=inflater.inflate(R.layout.telefonnoekleme,null);
                numaraet = (EditText) dialog_layout.findViewById(R.id.telefonnoet);
                builder.setView(dialog_layout).setPositiveButton("ONAYLA", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {


                        String numara=numaraet.getText().toString();
                        editor.putString("odaara13numara",numara);
                        editor.commit();

                        Intent intent = new Intent(OdaAra13.this,OdaAra14.class);
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
                Intent intent = new Intent(OdaAra13.this,OdaAra14.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(OdaAra13.this,OdaAra12.class);
        startActivity(intent);
    }
}
