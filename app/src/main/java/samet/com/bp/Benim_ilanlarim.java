package samet.com.bp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.StringTokenizer;

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
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.benimilanlarim);

        sharedPref = getApplicationContext().getSharedPreferences("MyPref",0);
        editor = sharedPref.edit();

        benim_ilanlarim_url+="&user_id="+sharedPref.getString("user_id",null);

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

        TextView tv=new TextView(Benim_ilanlarim.this);


       // tv.setText(     arrayplaka.get(i) );
        tv.setTextSize(35);
        tv.setPadding(80,80,80,80);
        tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        tv.setTextAppearance(android.R.attr.listSeparatorTextViewStyle);
       // tv.setBackgroundResource(R.drawable.border_textview);

        tv.setOnClickListener(Benim_ilanlarim.this);

        ll.addView(tv);

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
            while (token.hasMoreTokens()) {
               // System.out.println(token.nextToken());
String temp=token.nextToken();

                if(temp.contains("results")){
temp.replaceAll("result","");
                    resultcount+=Integer.valueOf(temp);
                }


            }

            System.out.println("Toplam Result "+resultcount);


        }
        catch (Exception e){
            e.printStackTrace();
        }



        return null;
    }





}


}
