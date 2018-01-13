package samet.com.bp;

import android.app.Activity;
import android.content.Intent;
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

import java.util.ArrayList;

/**
 * Created by root on 09.12.2017.
 */

public class OdaAraIlce extends Activity implements  View.OnClickListener{
   static ArrayList<String> array = new ArrayList<String>();
   static String sehir_isim;
    static String server_url;
    LinearLayout ll;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.odaarailce);
         ll = findViewById(R.id.dyntvekle);
        ll.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        Bundle bundle = getIntent().getExtras();
        sehir_isim=bundle.getString("odaarahangiil");

        server_url="http://vodkamorello.cloud.unispace.io/Getarailce.php?City="+sehir_isim.toUpperCase();



        new IlceTask().execute();


    }

    @Override
    public void onClick(View v) {
        TextView t=(TextView) v;
        Intent intent = new Intent(OdaAraIlce.this,OdaAra10.class);
        intent.putExtra("odaarahangiilce",((TextView) v).getText().toString());
        startActivity(intent);
    }


    public class IlceTask extends AsyncTask {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Object o) {

            for(int i=0;i<array.size();i++){

                TextView tv=new TextView(OdaAraIlce.this);

                tv.setText(     array.get(i) );
                tv.setTextSize(35);
                tv.setPadding(80,80,80,80);
                tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

                tv.setBackgroundResource(R.drawable.border_textview);

                tv.setOnClickListener(OdaAraIlce.this);

                ll.addView(tv);
            }

        }

        @Override
        protected Object doInBackground(Object[] params) {


            try{


                Document doc = Jsoup.connect(server_url).get();
                Elements elements=doc.select("ul li");
                for(Element element:elements){

                        System.out.println(element.text());
                        array.add(element.text());

                }


            }
            catch (Exception e){
                System.out.println(e);

            }

            return null;
        }
    }




}
