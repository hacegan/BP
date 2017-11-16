package samet.com.bp;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
 * Created by root on 06.11.2017.
 */

public class Giris extends Activity{

     String server_url="http://192.168.1.33/giris.php";

    Button btngiris,btnreset;
    EditText giriseposta,girissifre;
    String email,sifre;
String sonuc;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
setContentView(R.layout.giris);

      giriseposta= findViewById(R.id.giriseposta);
        girissifre= findViewById(R.id.girissifre);
btngiris= findViewById(R.id.girisyapbuton);

        btngiris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             email =giriseposta.getText().toString();
                 sifre=girissifre.getText().toString();
                server_url+="?Email="+email+"&Password="+sifre;
                System.out.println(server_url);
new LoginTask().execute();

               // new SignInUpActivity(getApplicationContext(),0).execute(email,sifre);




            }
        });





/*
btnreset.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

    }
});*/


    }


    public class LoginTask extends AsyncTask {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Object o) {
           // super.onPostExecute(o);
            if(sonuc.equals("Bu Email kayitli Başariyla giriş yapiyorsunuz . ")){
                Toast.makeText(getApplicationContext(),"Bu Email kayitli Başariyla giriş yapiyorsunuz . ",Toast.LENGTH_SHORT).show();
                getApplicationContext().startActivity(new Intent(getApplicationContext(),UserMainActivity.class));
            }
            else{
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
