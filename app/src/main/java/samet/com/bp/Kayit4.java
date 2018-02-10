package samet.com.bp;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
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
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.firebase.client.Firebase;

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
    String server_url="http://vodkamorello.atspace.co.uk/kayit.php";
    AlertDialog.Builder builder;
    static String code;
    String sonuc;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kayit4);


        tv= (TextView) findViewById(R.id.kayitisim);

        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("MyPref", 0);
        SharedPreferences.Editor editor = sharedPref.edit();
        isim=sharedPref.getString("name",null);
        tv.setText(tv.getText().toString()+isim);

        sifre=sharedPref.getString("sifre",null);
        email=sharedPref.getString("email",null);


        btn= (Button) findViewById(R.id.kayit4devambuton);

        kayitchkbir= (CheckBox) findViewById(R.id.kayitchkbir);
        kayitchkiki= (CheckBox) findViewById(R.id.kayitchkiki);




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


                server_url="http://vodkamorello.atspace.co.uk/kayit.php";


server_url+="?Email="+email+"&Name="+isim+"&Password="+sifre;
                System.out.println(server_url);
new RegisterTask().execute();


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
                Toast.makeText(getApplicationContext(),"Bu kullanici zaten kayitli lütfen giris yapin ! ",Toast.LENGTH_LONG).show();
            }
            else if(sonuc.equals("Kullanici Eklenemedi . ")){
                Toast.makeText(getApplicationContext(),"Kullanici Eklenemedi . ",Toast.LENGTH_LONG).show();
            }


            else  {
                Toast.makeText(getApplicationContext(),"Kullanici Basariyla eklendi . ",Toast.LENGTH_SHORT).show();

              /*  Intent intent = new Intent(getApplicationContext(),UserMainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);*/

                Firebase.setAndroidContext(getApplicationContext());

                SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("MyPref", 0);
                SharedPreferences.Editor editor = sharedPref.edit();

                sifre=sharedPref.getString("sifre",null);
                email=sharedPref.getString("email",null);

                final ProgressDialog pd = new ProgressDialog(Kayit4.this);
                pd.setMessage("Kaydediliyor...");
                pd.show();
                String url = "https://bitirme-proje-1511471101877.firebaseio.com/users.json";

                StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>(){
                    @Override
                    public void onResponse(String s) {
                        Firebase reference = new Firebase("https://bitirme-proje-1511471101877.firebaseio.com/users");

                        if(s.equals("null")) {
                            reference.child(email.replace(".",",")).child("password").setValue(sifre);
                            Toast.makeText(Kayit4.this, "registration successful", Toast.LENGTH_LONG).show();
                        }
                        else {
                            try {
                                JSONObject obj = new JSONObject(s);

                                if (!obj.has(email.replace(".",","))) {
                                    reference.child(email.replace(".",",")).child("password").setValue(sifre);
                                    Toast.makeText(Kayit4.this, "Fİrebase registration successful", Toast.LENGTH_LONG).show();
                                } else {
                                    Toast.makeText(Kayit4.this, "Firebase username already exists", Toast.LENGTH_LONG).show();
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
                        System.out.println("" + volleyError );
                        pd.dismiss();
                    }
                });

                RequestQueue rQueue = Volley.newRequestQueue(Kayit4.this);
                rQueue.add(request);

                getApplicationContext().startActivity(new Intent(getApplicationContext(),UserMainActivity.class));

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



