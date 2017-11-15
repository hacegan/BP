package samet.com.bp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by root on 04.11.2017.
 */
public class Kayit4 extends Activity {
    Button btn;
    CheckBox kayitchkbir,kayitchkiki;
String isim,sifre,email;
TextView tv;
    String server_url="http://192.168.1.33/kayit.php";
    AlertDialog.Builder builder;
    static String code;
    String sonuc;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kayit4);


        tv=findViewById(R.id.kayitisim);

        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("MyPref", 0);
        SharedPreferences.Editor editor = sharedPref.edit();
        isim=sharedPref.getString("name",null);
        tv.setText(tv.getText().toString()+isim);

        sifre=sharedPref.getString("sifre",null);
        email=sharedPref.getString("email",null);


        btn=findViewById(R.id.kayit4devambuton);

        kayitchkbir=findViewById(R.id.kayitchkbir);
        kayitchkiki=findViewById(R.id.kayitchkiki);

        builder=new AlertDialog.Builder(Kayit4.this);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                kayitchkbir.clearFocus();
                kayitchkiki.clearFocus();
                SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("MyPref", 0);
                SharedPreferences.Editor editor = sharedPref.edit();


                if(kayitchkbir.isChecked()){
                    editor.putString("chkbir","chkbirsecildi");
                    editor.commit();
                }

                if(kayitchkiki.isChecked()){
                    editor.putString("chkiki","chkikisecildi");
                    editor.commit();
                }





            }
        });


    }



    public class RegisterTask extends AsyncTask{


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Object o) {
           // super.onPostExecute(o);

            if(sonuc.equals("Bu kullanici zaten kayitli lütfen giris yapin ! ")){
                // Toast.makeText("")
            }
            else if(sonuc.equals("")){
                Toast.makeText(getApplicationContext(),"Kullanici Eklenemedi . ",Toast.LENGTH_LONG).show();
            }


            else  {
                Toast.makeText(getApplicationContext(),"Email kayitli değil . Lütfen kayit olun !  ",Toast.LENGTH_LONG).show();
            }


        }

        @Override
        protected Object doInBackground(Object[] params) {

            try{
                URL url=new URL(server_url);
                HttpURLConnection con= (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.connect();

                BufferedReader bf=new BufferedReader(new InputStreamReader(con.getInputStream()));
                sonuc=bf.readLine();
                System.out.println(sonuc);

               /* StringBuilder sb = new StringBuilder();
                String line = null;

                // Read Server Response
                while((line = bf.readLine()) != null) {
                    sb.append(line);
                    break;
                }


                System.out.println(sb);*/

            }
            catch (Exception e){
                System.out.println(e);
            }

            return null;
        }
    }





}



