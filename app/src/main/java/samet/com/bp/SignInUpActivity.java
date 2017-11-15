package samet.com.bp;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * Created by root on 15.11.2017.
 */

public class SignInUpActivity   extends AsyncTask{
    private Context context;
    private int byGetOrPost = 0;

    public SignInUpActivity(Context context, int byGetOrPost) {
        this.context = context;
        this.byGetOrPost = byGetOrPost;
    }



    @Override
    protected Object doInBackground(Object[] params) {
        if(byGetOrPost == 0){ //means by Get Method Giriş Yeri

            try{
                String email = (String) params[0];
                String password = (String) params[1];
                String link = "localhost/giris.php?email="+email+"& password="+password;

                URL url = new URL(link);
                HttpClient client = new DefaultHttpClient();
                HttpGet request = new HttpGet();
                request.setURI(new URI(link));
                HttpResponse response = client.execute(request);
                BufferedReader in = new BufferedReader(new
                        InputStreamReader(response.getEntity().getContent()));

                StringBuffer sb = new StringBuffer("");
                String line="";

                while ((line = in.readLine()) != null) {
                    sb.append(line);
                    break;
                }

                in.close();
                return sb.toString();
            } catch(Exception e){
                return new String("Exception: " + e.getMessage());
            }
        } else{
            try{
                String email = (String) params[0];
                String name = (String) params[1];
                String password = (String) params[2];

                String link="localhost/kayit.php";
                String data  = URLEncoder.encode("email", "UTF-8") + "=" +
                        URLEncoder.encode(email, "UTF-8");
                data += "&" + URLEncoder.encode("name", "UTF-8") + "=" +
                        URLEncoder.encode(name, "UTF-8");
                data += "&" + URLEncoder.encode("password", "UTF-8") + "=" +
                        URLEncoder.encode(password, "UTF-8");

                URL url = new URL(link);
                URLConnection conn = url.openConnection();

                conn.setDoOutput(true);
                OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());

                wr.write( data );
                wr.flush();

                BufferedReader reader = new BufferedReader(new
                        InputStreamReader(conn.getInputStream()));

                StringBuilder sb = new StringBuilder();
                String line = null;

                // Read Server Response
                while((line = reader.readLine()) != null) {
                    sb.append(line);
                    break;
                }

                return sb.toString();
            } catch(Exception e){
                return new String("Exception: " + e.getMessage());
            }
        }



    }


    @Override
    protected void onPreExecute() {
      //  super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        if(byGetOrPost == 0){//Giriş
context.startActivity(new Intent(context,LoginSuccess.class));

        }
else{//Kayit
            context.startActivity(new Intent(context,UserMainActivity.class));
        }



    }
}
