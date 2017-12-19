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

public class OdaAraIl extends Activity implements  View.OnClickListener{
    ArrayList<String> arrayil = new ArrayList<String>();
    ArrayList<String> arrayplaka = new ArrayList<String>();
    static String server_url;
    LinearLayout ll;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.odaarail);

         ll = findViewById(R.id.dyntvekle);
        ll.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));



        new SehirTask().execute();





    }

    @Override
    public void onClick(View v) {
        TextView t=(TextView) v;
        Intent intent = new Intent(OdaAraIl.this,OdaAraIlce.class);
       // intent.putExtra("plakalist",arrayil);
        intent.putExtra("odaarahangiil",((TextView) v).getText().toString());
        startActivity(intent);
    }


    public class SehirTask extends AsyncTask {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Object o) {


            for(int i=0;i<arrayplaka.size();i++){

                TextView tv=new TextView(OdaAraIl.this);

                tv.setText(     arrayplaka.get(i) );
                tv.setTextSize(35);
                tv.setPadding(80,80,80,80);
                tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

                tv.setBackgroundResource(R.drawable.border_textview);

                tv.setOnClickListener(OdaAraIl.this);

                ll.addView(tv);
            }

          /*Intent in=new Intent(OdaAraIl.this,OdaAraIlce.class);
            in.putExtra("plakalist",arrayplaka);
            startActivity(in);*/

        }

        @Override
        protected Object doInBackground(Object[] params) {


            try{


                int i=0;
                Document doc = Jsoup.connect("http://samet.j.layershift.co.uk/GetSehir.php").get();
                Elements elements=doc.select("ul li");
                for(Element element:elements){


                    if(i%2==1){
                        System.out.println(element.text());
                        arrayplaka.add(element.text());
                    }


                    if(i%2==0)   {
                        System.out.println(element.text());
                        arrayil.add(element.text());
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
