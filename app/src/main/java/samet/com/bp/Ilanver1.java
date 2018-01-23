package samet.com.bp;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by root on 17.11.2017.
 */

public class Ilanver1 extends AppCompatActivity{

Button btn;
    String isRegistered;
    String email,isim;
    String server_url="http://vodkamorello.atspace.co.uk/getname.php";
    Toolbar tb;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ilanver1);


        tb= (Toolbar) findViewById(R.id.supappbar);
setSupportActionBar(tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("MyPref", 0);
        SharedPreferences.Editor editor = sharedPref.edit();
        email=sharedPref.getString("email",null);

btn= (Button) findViewById(R.id.ilan1baslabtn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

if(email==null){//Kullanıcı Kayıtlı Değilse İsim Email Alma Alertini Goster

    AlertDialog.Builder alert=new AlertDialog.Builder(Ilanver1.this);
    LayoutInflater inflater = getLayoutInflater();
    View alertLayout = inflater.inflate(R.layout.ilanvernonreg, null);

    alert.setView(alertLayout);
    alert.setCancelable(false);

    alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

        @Override
        public void onClick(DialogInterface dialog, int which) {
            Intent intent = new Intent(Ilanver1.this,Ilanver2.class);
            startActivity(intent);
        }
    });

    alert.setPositiveButton("Done", new DialogInterface.OnClickListener() {

        @Override
        public void onClick(DialogInterface dialog, int which) {

        }
    });
    AlertDialog dialog = alert.create();
    dialog.show();


}
else{//Kayitliysa da alert adimini atlayip diger adıma geç


    Intent intent = new Intent(Ilanver1.this,Ilanver2.class);
    startActivity(intent);


}


            }
        });


    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Ilanver1.this,UserMainActivity.class);
        startActivity(intent);
    }


}
