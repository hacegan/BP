package samet.com.bp;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.StringTokenizer;

/**
 * Created by root on 31.01.2018.
 */

public class tekilarailangoster extends Activity{
    static String ilan_url="http://vodkamorello.atspace.co.uk/tekilaragetir.php";
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    TextView textView;
    ImageView imageView;
    String odaara1bay,odaara3yas,odaara4meslek,odaara5evet,odaara6evet,odaara10butce,odaara11tarih,odaara12sure,odaara13numara,odaara14baslik,odaara14aciklama;

    static String ilanid;

    Button mesajbtn,kaydetbtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tekilarailangoster);

       // sharedPref = getApplicationContext().getSharedPreferences("MyPref",0);
       // editor = sharedPref.edit();



         ilanid= getIntent().getStringExtra("tekilaraitemid");
        int id=Integer.valueOf(ilanid.trim());

        ilan_url+="?ilan_id="+id;

        new MyAd().execute();

        kaydetbtn= (Button) findViewById(R.id.tekilkaydetarabtn);
        mesajbtn= (Button) findViewById(R.id.tekilmesajbtn);

        kaydetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
new Kaydet().execute();
            }
        });

        mesajbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    public class Kaydet extends  AsyncTask{


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
        }

        @Override
        protected Object doInBackground(Object[] params) {
            sharedPref = getApplicationContext().getSharedPreferences("MyPref",0);
            editor = sharedPref.edit();

            String user_id_str= sharedPref.getString("user_id","");
            int user_id=Integer.valueOf(user_id_str);


            try{
                URL url=new URL("http://vodkamorello.atspace.co.uk/kisikaydet_arailan.php?ara_ilanid="+ilanid+"&user_id="+user_id);
                HttpURLConnection con= (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.connect();

                BufferedReader bf=new BufferedReader(new InputStreamReader(con.getInputStream()));
                String  sonuc=bf.readLine();
                // System.out.println(sonuc);

                con.disconnect();


            }
            catch (Exception e){
                e.printStackTrace();
            }



            return null;
        }
    }

    public class MyAd extends AsyncTask {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Object o) {


           /* for(int i=0;i<resultcount;i++){
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
                // tv.setBackgroundResource(R.drawable.border_textview);

                // tv.setOnClickListener(Benim_ilanlarim.this);

                setOnClick(tv,ilanid.get(i));


                ll.addView(tv);

            }*/

            textView= (TextView) findViewById(R.id.Tara_yayin_arayan);
            String ara_yayin_arayan=textView.getText().toString();
            textView.setText(ara_yayin_arayan+" "+odaara1bay);


                /*    imageView= (ImageView) findViewById(R.id.ara_yayin_resim);

                    if (!odaara2resim.equalsIgnoreCase("")) {
                        //Decoding the Image and display in ImageView
                        byte[] b = Base64.decode(odaara2resim, Base64.DEFAULT);
                        Bitmap bitmap = BitmapFactory.decodeByteArray(b, 0, b.length);
                        imageView.setImageBitmap(bitmap);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"You don't have Image in SharedPreferences!", Toast.LENGTH_SHORT).show();
                    }
*/
            textView= (TextView) findViewById(R.id.Tara_yayin_yas);
            String ara_yayin_yas=textView.getText().toString();
            textView.setText(ara_yayin_yas+" "+odaara3yas);


            textView= (TextView) findViewById(R.id.Tara_yayin_meslek);
            String ara_yayin_meslek=textView.getText().toString();
            textView.setText(ara_yayin_meslek+" "+odaara4meslek);

            textView= (TextView) findViewById(R.id.Tara_yayin_evcilvarmi);
            String ara_yayin_evcilvarmi=textView.getText().toString();
            textView.setText(ara_yayin_evcilvarmi+" "+odaara5evet);

            textView= (TextView) findViewById(R.id.Tara_yayin_sigaravarmi);
            String ara_yayin_sigaravarmi=textView.getText().toString();
            textView.setText(ara_yayin_sigaravarmi+" "+odaara6evet);

                /*    textView= (TextView) findViewById(R.id.ara_yayin_yasaralik);
                    String ara_yayin_yasaralik=textView.getText().toString();
                    textView.setText(ara_yayin_yasaralik+" "+odaara8tv);*/

                /*    textView= (TextView) findViewById(R.id.ara_yayin_neredelive);
                    String ara_yayin_neredelive=textView.getText().toString();
                    textView.setText(ara_yayin_neredelive+" "+odaarahangiil);*/

                /*    textView= (TextView) findViewById(R.id.ara_yayin_butce);
                    String ara_yayin_butce=textView.getText().toString();
                    textView.setText(ara_yayin_butce+" "+odaarahangiilce);*/

            textView= (TextView) findViewById(R.id.Tara_yayin_hazirtarih);
            String ara_yayin_hazirtarih=textView.getText().toString();
            textView.setText(ara_yayin_hazirtarih+" "+odaara11tarih);

            textView= (TextView) findViewById(R.id.Tara_yayin_konaksure);
            String ara_yayin_konaksure=textView.getText().toString();
            textView.setText(ara_yayin_konaksure+" "+odaara12sure);

            textView= (TextView) findViewById(R.id.Tara_yayin_telefonno);
            String ara_yayin_telefonno=textView.getText().toString();
            textView.setText(ara_yayin_telefonno+" "+odaara13numara);

            textView= (TextView) findViewById(R.id.Tara_yayin_ilanbaslik);
            String ara_yayin_ilanbaslik=textView.getText().toString();
            textView.setText(ara_yayin_ilanbaslik+" "+odaara14baslik);

            textView= (TextView) findViewById(R.id.Tara_yayin_ilanaciklama);
            String ara_yayin_ilanaciklama=textView.getText().toString();
            textView.setText(ara_yayin_ilanaciklama+" "+odaara14aciklama);



        }

        @Override
        protected Object doInBackground(Object[] params) {

            try{
                URL url=new URL(ilan_url);
                HttpURLConnection con= (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.connect();

                BufferedReader bf=new BufferedReader(new InputStreamReader(con.getInputStream()));
                String  sonuc=bf.readLine();
                // System.out.println(sonuc);

                StringTokenizer token = new StringTokenizer(sonuc, ";");

                while (token.hasMoreTokens()) {

                    String temp = token.nextToken();

                    //    ilanbaslik.add( temp.substring(temp.indexOf("ilanbaslik:"),temp.indexOf("-",temp.indexOf("ilanbaslik:")) ) );
                    //    ilanaciklama.add( temp.substring(temp.indexOf("ilanaciklama:") ) );

                    //  ilanid.add(  temp.substring(temp.indexOf("Kirala id:"),temp.indexOf("-",temp.indexOf("Kirala id:")) )        );

                    odaara1bay = temp.substring(temp.indexOf("arayanbir: ")+12, temp.indexOf("-", temp.indexOf("arayanbir: ")));
                    System.out.println("odaara1bay =" + odaara1bay);

                    //   String odaara2resim=temp.substring(temp.indexOf("ilanbaslik:"),temp.indexOf("-",temp.indexOf("ilanbaslik:")) );
                    //System.out.println("odaara2resim = "+odaara2resim);

                    odaara3yas = temp.substring(temp.indexOf("yas : ")+7, temp.indexOf("-", temp.indexOf("yas : ")));
                    System.out.println("odaara3yas = " + odaara3yas);

                    odaara4meslek = temp.substring(temp.indexOf("meslek: ")+9, temp.indexOf("-", temp.indexOf("meslek: ")));
                    System.out.println("odaara4meslek = " + odaara4meslek);

                    odaara5evet = temp.substring(temp.indexOf("havepet: ")+10, temp.indexOf("-", temp.indexOf("havepet: ")));
                    System.out.println("odaara5evet = " + odaara5evet);

                    odaara6evet = temp.substring(temp.indexOf("havesmoke: ")+12, temp.indexOf("-", temp.indexOf("havesmoke: ")));
                    System.out.println("odaara6evet = " + odaara6evet);

                    //  String odaara8tv =temp.substring(temp.indexOf("ilanbaslik:"),temp.indexOf("-",temp.indexOf("ilanbaslik:")) );
                    //  System.out.println("odaara8tv = "+odaara8tv);

                    //       String odaarahangiil=temp.substring(temp.indexOf("ilanbaslik:"),temp.indexOf("-",temp.indexOf("ilanbaslik:")) );
                    //   System.out.println("odaarahangiil = "+odaarahangiil);

                    //   String odaarahangiilce=temp.substring(temp.indexOf("ilanbaslik:"),temp.indexOf("-",temp.indexOf("ilanbaslik:")) );
                    //   System.out.println("odaarahangiilce = "+odaarahangiilce);

                    odaara10butce = temp.substring(temp.indexOf("butce: ")+8, temp.indexOf("-", temp.indexOf("butce: ")));
                    System.out.println("odaara10butce = " + odaara10butce);

                    odaara11tarih = temp.substring(temp.indexOf("hazirbulunmatarih:")+19, temp.indexOf("-", temp.indexOf("hazirbulunmatarih:")));
                    System.out.println("odaara11tarih = " + odaara11tarih);

                    odaara12sure = temp.substring(temp.indexOf("konaklamasure: ")+16, temp.indexOf("-", temp.indexOf("konaklamasure: ")));
                    System.out.println("odaara12sure = " + odaara12sure);

                    odaara13numara = temp.substring(temp.indexOf("telefonno: ")+12, temp.indexOf("-", temp.indexOf("telefonno: ")));
                    System.out.println("odaara13numara = " + odaara13numara);

                    odaara14baslik = temp.substring(temp.indexOf("ilanbaslik: ")+13, temp.indexOf("-", temp.indexOf("ilanbaslik: ")));
                    System.out.println("odaara14baslik="+odaara14baslik);

                    odaara14aciklama = temp.substring(temp.indexOf("ilanaciklama: ")+15, temp.indexOf("-", temp.indexOf("ilanaciklama: ")));
                    System.out.println("odaara14aciklama"+odaara14aciklama);

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
