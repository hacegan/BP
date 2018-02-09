package samet.com.bp;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.StringTokenizer;

/**
 * Created by root on 07.02.2018.
 */

public class kaydedilmis_ilanlarim extends Activity implements  View.OnClickListener{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kaydedilmis_ilanlarim);
    }

    @Override
    public void onClick(View v) {

    }


   /* public class MyAd extends AsyncTask {


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
                    tv.setTag("Ara:"+arailanid.get(i));
                }



                // tv.setBackgroundResource(R.drawable.border_textview);

                tv.setOnClickListener(Benim_ilanlarim.this);

                //setOnClick(tv,ilanid.get(i));


                ll.addView(tv);

            }
//


        }

        @Override
        protected Object doInBackground(Object[] params) {

            try{
                URL url=new URL("http://vodkamorello.atspace.co.uk/kaydedilmis_ilanlarim.php");
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
*/


}
