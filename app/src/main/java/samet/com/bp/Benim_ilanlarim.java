package samet.com.bp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.StringTokenizer;

import static java.security.AccessController.getContext;

/**
 * Created by root on 24.12.2017.
 */

public class Benim_ilanlarim extends Activity implements  View.OnClickListener{
    LinearLayout ll;
    static String benim_ilanlarim_url="http://vodkamorello.atspace.co.uk/benim_ilanlarim.php";
    static String sonuc;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    static int resultcount=0;
    TextView resulttv;
    ArrayList<String> ilanbaslik = new ArrayList<String>();
    ArrayList<String> ilanaciklama = new ArrayList<String>();
    ArrayList<String> kiralailanid=new ArrayList<String>();
    ArrayList<String> arailanid=new ArrayList<String>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.benimilanlarim);

        sharedPref = getApplicationContext().getSharedPreferences("MyPref",0);
        editor = sharedPref.edit();

        benim_ilanlarim_url+="?user_id="+sharedPref.getString("user_id",null);

        ll= (LinearLayout) findViewById(R.id.benimilantv);
        ll.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));


        new MyAd().execute();

    }

/*
    private void setOnClick(final TextView tv, final String str){
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Do whatever you want(str can be used here)

            }
        });
    }*/


    @Override
    public void onClick(View v) {

       String text_tag= (String) v.getTag();
Intent intent=new Intent(Benim_ilanlarim.this,Benim_Tekil_Kira_Goster.class);
        if(text_tag.contains("Kirala")){


            StringTokenizer token = new StringTokenizer(text_tag,":");

            int i=0;
            while (token.hasMoreTokens()) {

                String temp = token.nextToken();

                if(i==1){
intent.putExtra("ilan_id",temp);
                }

            }


         // Intent  intent = new Intent(Benim_ilanlarim.this,Benim_Tekil_Kira_Goster.class);
            startActivity(intent);
        }

        else{


            StringTokenizer token = new StringTokenizer(text_tag,":");

            int i=0;
            while (token.hasMoreTokens()) {

                String temp = token.nextToken();
                if(i==1){
                    intent.putExtra("ilan_id",temp);
                }


            }


            //Intent  intent = new Intent(Benim_ilanlarim.this,Benim_Tekil_Ara_Goster.class);
              startActivity(intent);
        }

    }


    public class MyAd extends  AsyncTask{


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Object o) {


            for(int i=0;i<resultcount;i++){
                TextView tv=new TextView(Benim_ilanlarim.this);



                Drawable drawable=getApplicationContext().getResources().getDrawable(R.drawable.empty_house);
                tv.setCompoundDrawablesWithIntrinsicBounds(drawable,null,null,null);
               // tv.setCompoundDrawables(R.drawable.empty_house,null,null,null);

                 tv.setText(ilanbaslik.get(i)+"\n"+ilanaciklama.get(i));
                //tv.setText(ilanbaslik.get(i));
                tv.setTextSize(35);
                tv.setPadding(80,80,80,80);
                tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

                tv.setTextAppearance(android.R.attr.textAppearanceLarge);

if(i<kiralailanid.size())
tv.setTag("Kirala:"+kiralailanid.get(i));

                else{
    tv.setTag("Ara:"+arailanid.get(i-kiralailanid.size()));
                }



                // tv.setBackgroundResource(R.drawable.border_textview);

                tv.setOnClickListener(Benim_ilanlarim.this);

                    //setOnClick(tv,ilanid.get(i));


                ll.addView(tv);

            }



        }

        @Override
        protected Object doInBackground(Object[] params) {

            try{
                URL url=new URL(benim_ilanlarim_url);
                HttpURLConnection con= (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.connect();

                BufferedReader bf=new BufferedReader(new InputStreamReader(con.getInputStream()));
                sonuc=bf.readLine();
                System.out.println(sonuc);

                StringTokenizer token = new StringTokenizer(sonuc, ";");
                resultcount=0;
                while (token.hasMoreTokens()) {

                    String temp=token.nextToken();


                    if(!temp.contains("<br>")) {
                        if (Integer.valueOf(temp) instanceof Integer) {


                            resultcount += Integer.valueOf(temp);
                        }

                    }

                    else{

   ilanbaslik.add( temp.substring(temp.indexOf("ilanbaslik:"),temp.indexOf("-",temp.indexOf("ilanbaslik:")) ) );
                        ilanaciklama.add( temp.substring(temp.indexOf("ilanaciklama:") ) );

                        if(temp.contains("Kirala"))
                            kiralailanid.add(  temp.substring(temp.indexOf("Kirala id:")+11,temp.indexOf("-",temp.indexOf("Kirala id:")) ));

                        else
                            arailanid.add(  temp.substring(temp.indexOf("Ara id:")+8,temp.indexOf("-",temp.indexOf("Ara id:")) ));

                                    //  ilanid.add(  temp.substring(temp.indexOf("Kirala id:"),temp.indexOf("-",temp.indexOf("Kirala id:")) )        );

                    }



                }

                System.out.println("Toplam Result "+resultcount);
                resulttv= (TextView) findViewById(R.id.benimilanresultsid);
                resulttv.setText("Toplam Sonuc : "+resultcount);


con.disconnect();


            }
            catch (Exception e){
                e.printStackTrace();
            }


            return null;
        }


    }






}
