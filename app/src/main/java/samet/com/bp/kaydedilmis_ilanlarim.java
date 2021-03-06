package samet.com.bp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by root on 07.02.2018.
 */

public class kaydedilmis_ilanlarim extends Activity implements  View.OnClickListener{

    LinearLayout ll;
    static String benim_ilanlarim_url="http://vodkamorello.atspace.co.uk/kaydedilmis_ilanlarim.php";
    static String sonuc;
    static SharedPreferences sharedPref;
    static SharedPreferences.Editor editor;
    static int resultcount=0;
    TextView resulttv;
    ArrayList<String> ilanbaslik = new ArrayList<String>();
    ArrayList<String> ilanaciklama = new ArrayList<String>();
    ArrayList<String> kiralailanid=new ArrayList<String>();
    ArrayList<String> arailanid=new ArrayList<String>();
    static StorageReference storageReference= FirebaseStorage.getInstance().getReference();

    static  String kul_mail;

    static int kiralamaximgid=0;
    static int aramaximgid=0;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kaydedilmis_ilanlarim);

        sharedPref = getApplicationContext().getSharedPreferences("MyPref",0);
        editor = sharedPref.edit();

        benim_ilanlarim_url+="?user_id="+sharedPref.getString("user_id",null);

        ll= (LinearLayout) findViewById(R.id.kayitilantv);
        ll.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        kul_mail =sharedPref.getString("email",null);


        new MyAd().execute();

    }

    @Override
    public void onClick(View v) {

        String text_tag= (String) v.getTag();
        Intent intent;

        System.out.println("Gelen Tag DEgeri = "+text_tag);

        if(text_tag.contains("Kirala")){

            intent=new Intent(kaydedilmis_ilanlarim.this,tekilkiralailangoster.class);
            StringTokenizer token = new StringTokenizer(text_tag,":");

            int i=0;
            while (token.hasMoreTokens()) {

                String temp = token.nextToken();

                if(i==1){
                    intent.putExtra("ilan_id",temp);
                    System.out.println("GÖnderilen id ="+temp);
                }
                i++;
            }


            // Intent  intent = new Intent(Benim_ilanlarim.this,Benim_Tekil_Kira_Goster.class);
            startActivity(intent);
        }

        else{

            intent=new Intent(kaydedilmis_ilanlarim.this,tekilarailangoster.class);
            StringTokenizer token = new StringTokenizer(text_tag,":");

            int i=0;
            while (token.hasMoreTokens()) {

                String temp = token.nextToken();
                if(i==1){
                    intent.putExtra("ilan_id",temp);
                    System.out.println("GÖnderilen id ="+temp);
                }

                i++;
            }


            //Intent  intent = new Intent(Benim_ilanlarim.this,Benim_Tekil_Ara_Goster.class);
            startActivity(intent);
        }




    }


    public class MyAd extends AsyncTask {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Object o) {


            StorageReference ref = null;

            for(int i=0;i<resultcount;i++){
                final TextView tv=new TextView(kaydedilmis_ilanlarim.this);


               if(i<kiralailanid.size()){

                    final ImageView tempimg=new ImageView(kaydedilmis_ilanlarim.this);


                    storageReference.child("images/herkirala/"+(i+1)).getBytes(Long.MAX_VALUE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
                        @Override
                        public void onSuccess(byte[] bytes) {
                            System.out.println("Basariilli");
                            Bitmap bmp = BitmapFactory.decodeByteArray(bytes,0,bytes.length);
                            tempimg.setImageBitmap(bmp);
                            Drawable drawable=tempimg.getDrawable();
                            drawable.setBounds(0,0,460,460);
                            tv.setCompoundDrawables(drawable,null,null,null);
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception exception) {
                            System.out.println("Basarisiz");
                        }
                    });


                }
                else{
                    final ImageView tempimg=new ImageView(kaydedilmis_ilanlarim.this);


                    storageReference.child("images/herara/"+   (i-kiralailanid.size()+1)     ).getBytes(Long.MAX_VALUE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
                        @Override
                        public void onSuccess(byte[] bytes) {
                            System.out.println("Basariilli");
                            Bitmap bmp = BitmapFactory.decodeByteArray(bytes,0,bytes.length);
                            tempimg.setImageBitmap(bmp);
                            Drawable drawable=tempimg.getDrawable();
                            drawable.setBounds(0,0,460,460);
                            tv.setCompoundDrawables(drawable,null,null,null);
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception exception) {
                            System.out.println("Basarisiz");
                        }
                    });
                }


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

                tv.setOnClickListener(kaydedilmis_ilanlarim.this);

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
                        if (!temp.contains("results")   && Integer.valueOf(temp) instanceof Integer) {


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
                resulttv= (TextView) findViewById(R.id.kayitilanresultsid);
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
