package samet.com.bp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
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
    static String benim_ilanlarim_url="http://vodkamorello.cloud.unispace.io/benim_ilanlarim.php";
    static String sonuc;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    static int resultcount=0;
    TextView resulttv;
    ArrayList<String> ilanbaslik = new ArrayList<String>();
    ArrayList<String> ilanaciklama = new ArrayList<String>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.benimilanlarim);

        sharedPref = getApplicationContext().getSharedPreferences("MyPref",0);
        editor = sharedPref.edit();

        benim_ilanlarim_url+="?user_id="+sharedPref.getString("user_id",null);

        ll=findViewById(R.id.benimilantv);
        ll.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));


        new MyAd().execute();

    }

    @Override
    public void onClick(View v) {

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
                tv.setTextSize(35);
                tv.setPadding(80,80,80,80);
                tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

                tv.setTextAppearance(android.R.attr.textAppearanceLarge);
                // tv.setBackgroundResource(R.drawable.border_textview);

                tv.setOnClickListener(Benim_ilanlarim.this);




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
   ilanbaslik.add( temp.substring(temp.indexOf("ilanbaslik: ")+1,temp.indexOf("-") ) );
                        ilanaciklama.add( temp.substring(temp.indexOf("ilanaciklama: ")+1,temp.indexOf("\0") ) );

                    }



                }

                System.out.println("Toplam Result "+resultcount);
                resulttv=findViewById(R.id.benimilanresultsid);
                resulttv.setText("Toplam Sonuc : "+resultcount);


con.disconnect();


            }
            catch (Exception e){
                e.printStackTrace();
            }



         /*   finally {

                try {


                    //  int i=0;
                    Document doc = Jsoup.connect(benim_ilanlarim_url).get();
                    Elements elements = doc.select("[class=\\\"style3\\\"]");
                    for (Element element : elements) {
                        String text =element.firstElementSibling().html();
                        text = text.replaceAll("<br>", "\n");
                        System.out.println(text);
                     //   System.out.println(element.text());
                   *//* if(i%2==1){
                        System.out.println(element.text());
                       // arrayplaka.add(element.text());
                    }


                    if(i%2==0)   {
                        System.out.println(element.text());
                      //  arrayil.add(element.text());
                    }
                    i++;*//*
                    }

                } catch (Exception e) {
                    System.out.println(e);

                }

            }*/




            return null;
        }





    }


}
