package samet.com.bp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by root on 20.11.2017.
 */

public class Kirala4 extends AppCompatActivity {
    Button btn,btndvm;
    Toolbar tb;
   static EditText et;
    String sonuc;
    static String gitdeger;
   static String server_url;
    ArrayList<String> array = new ArrayList<String>();
    static String hangisehir;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kirala4);




        tb= (Toolbar) findViewById(R.id.supappbar);
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btndvm= (Button) findViewById(R.id.btndvm);



        btn= (Button) findViewById(R.id.geribtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kirala4.this,Kirala3.class);
                startActivity(intent);
            }
        });


        btndvm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et= (EditText) findViewById(R.id.plakaet);
                gitdeger= et.getText().toString();
                server_url="http://sametd.demo.datacenter.fi/myphp/Getilce.php";

                server_url+="?Plaka="+gitdeger;
                System.out.println(gitdeger);
                System.out.println(et);
                Log.w("DENEME", String.valueOf(et));
                Log.w("DENEME", String.valueOf(gitdeger));

new CityTask().execute();

              /*  Intent intent = new Intent(Kirala4.this,Kirala5.class);
                startActivity(intent);*/
            }
        });


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Kirala4.this,Kirala3.class);
        startActivity(intent);
    }



    public class CityTask extends AsyncTask {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Object o) {




            Intent in=new Intent(Kirala4.this,KiralaIlveIlceleri.class);
            in.putExtra("ilcelist",array);
            in.putExtra("hangisehir",hangisehir);
            startActivity(in);

        }

        @Override
        protected Object doInBackground(Object[] params) {


            try{


int i=0;
                Document doc = Jsoup.connect(server_url).get();
              Elements elements=doc.select("ul li");
                for(Element element:elements){
            if(i%2==1)   {
                System.out.println(element.text());
                array.add(element.text());
            }

            if(i%2==0){
                hangisehir=element.text();
            }


                    i++;
                }




            }
            catch (Exception e){
                System.out.println(e);

            }

            return null;
        }
    }




}
