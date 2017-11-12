package samet.com.bp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
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
    String server_url="http://samet822.heliohost.org/kayitetme.php";
    AlertDialog.Builder builder;
    static String code;

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

/*
                StringRequest stringRequest=new StringRequest(Request.Method.POST,server_url,
                        new Response.Listener<String>(){
                            @Override
                            public void onResponse(String response) {
                                try {
                                    JSONArray jsonArray=new JSONArray(response);
                                    JSONObject jsonObject=jsonArray.getJSONObject(0);
                                 code   =jsonObject.getString("code");
                                    //String message=jsonObject.getString("message");


                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }



                            }
                        }
,new Response.ErrorListener(){

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> params=new HashMap<String, String>();
                        params.put("email",email);
                        params.put("name",isim);
                        params.put("password",sifre);


                        return params;
                    }
                };


                MySingleton.getmInstance(Kayit4.this).addTorequestque(stringRequest);

             /*   if(code=="Register_success"){
                    Intent intent=new Intent(Kayit4.this,UserMainActivity.class);
                    startActivity(intent);
                }*/
                Intent intent=new Intent(Kayit4.this,UserMainActivity.class);
                startActivity(intent);



            }
        });


    }
}
