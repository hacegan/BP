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
    ArrayList<String> array = new ArrayList<String>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.odaarailce);
        LinearLayout ll = findViewById(R.id.dyntvekle);
        ll.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        Bundle bundle = getIntent().getExtras();
        ArrayList<String> array = bundle.getStringArrayList("plakalist");
        for(int i=0;i<array.size();i++){

            TextView tv=new TextView(this);

            tv.setText(     array.get(i) );
            tv.setTextSize(35);
            tv.setPadding(80,80,80,80);
            tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

            tv.setBackgroundResource(R.drawable.border_textview);

            tv.setOnClickListener(this);

            ll.addView(tv);
        }

        new IlceTask().execute();


    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(OdaAraIlce.this,OdaAra10.class);
        startActivity(intent);
    }


    public class IlceTask extends AsyncTask {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Object o) {

            Intent in=new Intent(OdaAraIlce.this,KiralaIlveIlceleri.class);
            in.putExtra("ilcelist",array);
            startActivity(in);

        }

        @Override
        protected Object doInBackground(Object[] params) {

            StringBuilder stringBuilder=new StringBuilder();
            try{



                int i=0;
                Document doc = Jsoup.connect("http://sametd.demo.datacenter.fi/myphp/Getilce.php").get();
                Elements elements=doc.select("ul li");
                for(Element element:elements){
                    if(i%2==1)   {
                        System.out.println(element.text());
                        array.add(element.text());
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
