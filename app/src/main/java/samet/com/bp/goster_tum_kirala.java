package samet.com.bp;

import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class goster_tum_kirala extends Activity implements  View.OnClickListener{

RecyclerView listshowrcy;
List<kirala_pojo> kirala_pojos=new ArrayList<kirala_pojo>();
    static int resultcount=0;
    ArrayList<String> ilanbaslik = new ArrayList<String>();
    ArrayList<String> ilanaciklama = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goster_tum_kirala);






        listshowrcy= (RecyclerView) findViewById(R.id.listshow);
                listshowrcy.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        listshowrcy.setLayoutManager(linearLayoutManager);

    }

    @Override
    public void onClick(View v) {

    }


    public class MyAd extends AsyncTask {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Object o) {


            for(int i=0;i<ilanbaslik.size();i++){
                //TextView tv=new TextView(goster_tum_kirala.this);



                /*Drawable drawable=getApplicationContext().getResources().getDrawable(R.drawable.empty_house);
                tv.setCompoundDrawablesWithIntrinsicBounds(drawable,null,null,null);
                // tv.setCompoundDrawables(R.drawable.empty_house,null,null,null);

                tv.setText(ilanbaslik.get(i)+"\n"+ilanaciklama.get(i));
                //tv.setText(ilanbaslik.get(i));
                tv.setTextSize(35);
                tv.setPadding(80,80,80,80);
                tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

                tv.setTextAppearance(android.R.attr.textAppearanceLarge);
                // tv.setBackgroundResource(R.drawable.border_textview);

                tv.setOnClickListener(goster_tum_kirala.this);*/

kirala_pojos.add(new kirala_pojo(ilanbaslik.get(i),ilanaciklama.get(i),R.drawable.empty_house));




            }



        }

        @Override
        protected Object doInBackground(Object[] params) {

            try{
                URL url=new URL("http://vodkamorello.cloud.unispace.io/get_all_kirala.php");
                HttpURLConnection con= (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.connect();

                BufferedReader bf=new BufferedReader(new InputStreamReader(con.getInputStream()));
              String  sonuc=bf.readLine();
                System.out.println(sonuc);

                StringTokenizer token = new StringTokenizer(sonuc, ";");
                while (token.hasMoreTokens()) {

                    String temp=token.nextToken();

                        ilanbaslik.add( temp.substring(temp.indexOf("ilanbaslik:"),temp.indexOf("-",temp.indexOf("ilanbaslik:")) ) );
                        ilanaciklama.add( temp.substring(temp.indexOf("ilanaciklama:") ) );


                }




                con.disconnect();


            }
            catch (Exception e){
                e.printStackTrace();
            }


            return null;
        }


    }










}
