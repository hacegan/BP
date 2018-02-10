package samet.com.bp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by root on 06.11.2017.
 */

public class Giris extends Activity{



   // String server_url="http://192.168.1.33/giris.php";

    String server_url="http://vodkamorello.atspace.co.uk/giris.php";

    Button btngiris,btnreset;
    EditText giriseposta,girissifre;
 static   String email,sifre;
String sonuc;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
setContentView(R.layout.giris);



      giriseposta= (EditText) findViewById(R.id.giriseposta);
        girissifre= (EditText) findViewById(R.id.girissifre);
btngiris= (Button) findViewById(R.id.girisyapbuton);

        btngiris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("MyPref",0);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("email",giriseposta.getText().toString());
                editor.commit();


                server_url="http://vodkamorello.atspace.co.uk/giris.php";

             email =giriseposta.getText().toString();
                 sifre=girissifre.getText().toString();

                    server_url+= "?Email="+email+"&Password="+sifre;

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

               /* Intent intent = new Intent(getApplicationContext(),UserMainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);*/

                String fire_url = "https://bitirme-proje-1511471101877.firebaseio.com/users.json";
                final ProgressDialog pd = new ProgressDialog(Giris.this);
                pd.setMessage("Giris Yapiliyor...");
                pd.show();

                StringRequest request = new StringRequest(Request.Method.GET, fire_url, new Response.Listener<String>(){
                    @Override
                    public void onResponse(String s) {
                        if(s.equals("null")){
                            Toast.makeText(Giris.this, "user not found", Toast.LENGTH_LONG).show();
                        }
                        else{
                            try {
                                JSONObject obj = new JSONObject(s);

                                if(!obj.has(email.replace(".",","))){
                                    Toast.makeText(Giris.this, "user not found", Toast.LENGTH_LONG).show();
                                }
                                else if(obj.getJSONObject(email.replace(".",",")).getString("password").equals(sifre)){
                                    // UserDetails.username = user;
                                    //UserDetails.password = pass;
                                    //startActivity(new Intent(Login_Firebase.this, Users.class));
                                    Toast.makeText(Giris.this, "Basariyla giris yapildi firebasee", Toast.LENGTH_LONG).show();
                                    System.out.println("Connected to Fİrebase");

                                    UserDetails_Firebase.username = email.replace(".",",");
                                    UserDetails_Firebase.password = sifre;
                                }
                                else {
                                    Toast.makeText(Giris.this, "incorrect password", Toast.LENGTH_LONG).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                        pd.dismiss();
                    }
                },new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        System.out.println("" + volleyError);
                        pd.dismiss();
                    }
                });

                RequestQueue rQueue = Volley.newRequestQueue(Giris.this);
                rQueue.add(request);




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




            }
            catch (Exception e){
                System.out.println(e);

            }

            return null;
        }
    }






}
