package samet.com.bp;

import android.app.Activity;
import android.content.Intent;
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

import java.util.HashMap;
import java.util.Map;

/**
 * Created by root on 06.11.2017.
 */

public class Giris extends Activity{

    String server_url="http://samet822.heliohost.org/girisyapma.php";

    Button btngiris,btnreset;
    EditText giriseposta,girissifre;
    String email,sifre;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
setContentView(R.layout.giris);

      giriseposta= (EditText) findViewById(R.id.giriseposta);
        girissifre=(EditText)findViewById(R.id.girissifre);
btngiris=(Button) findViewById(R.id.girisyapbuton);

        btngiris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             email =giriseposta.getText().toString();
                 sifre=girissifre.getText().toString();
                Intent intent =new Intent(Giris.this,LoginSuccess.class);
                startActivity(intent);

/*
                StringRequest stringRequest=new StringRequest(Request.Method.POST,server_url,
                        new Response.Listener<String>(){
                            @Override
                            public void onResponse(String response) {
                                try {
                                    JSONArray jsonArray=new JSONArray(response);
                                    JSONObject jsonObject=jsonArray.getJSONObject(0);
                                    String code   =jsonObject.getString("code");
                                  //  String message=jsonObject.getString("message");

                                    if(code=="login_success"){
                                        Intent intent =new Intent(Giris.this,LoginSuccess.class);
                                        Bundle bundle=new Bundle();
                                    //    bundle.putString("email",jsonObject.getString("email"));
            //bundle.putString("password",jsonObject.getString("password"));
                                     bundle.putString("name",jsonObject.getString("name"));

                                        intent.putExtras(bundle);
                                        startActivity(intent);

                                    }

                                    Intent intent =new Intent(Giris.this,LoginSuccess.class);
                                    Bundle bundle=new Bundle();
                                    //    bundle.putString("email",jsonObject.getString("email"));
                                    //bundle.putString("password",jsonObject.getString("password"));
                                    bundle.putString("name",jsonObject.getString("name"));

                                    intent.putExtras(bundle);
                                    startActivity(intent);




                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }



                            }
                        }
                        ,new Response.ErrorListener(){

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Giris.this,"Hata...",Toast.LENGTH_SHORT);
                        error.printStackTrace();
                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> params=new HashMap<String, String>();
                        params.put("email",email);
                        params.put("password",sifre);

                        return params;
                    }
                };

MySingleton.getmInstance(Giris.this).addTorequestque(stringRequest);*/





            }
        });





/*
btnreset.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

    }
});*/


    }
}
