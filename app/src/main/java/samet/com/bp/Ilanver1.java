package samet.com.bp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
    String server_url="http://192.168.1.33/getname.php";
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

}
else{//Kayitliysa da alert adimini atlayip diger adıma geç

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
