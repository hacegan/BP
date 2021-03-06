package samet.com.bp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.StringTokenizer;

/**
 * Created by root on 12.02.2018.
 */

public class Benim_Tekil_Kira_Goster extends AppCompatActivity {


   static String ilan_id;
   static     int il_id;

    TextView textView;
    ImageView imageView;
   public static String kirala1mulktur,kirala2ilanveren,kirala3adres,kirala7m2,kirala7oda,kirala7kat,kirala7bkat,kirala7aidat,kirala7kira,kirala7esya,kirala8tarih,kirala9kizsayi
            ,kirala9erkeksayi,kirala10var,kirala11evet,kirala13yas,kirala14numara,kirala15baslik,kirala15aciklama;

    Button silbtn,editbtn;

    static String ilan_url="http://vodkamorello.atspace.co.uk/tekilkiragetir.php";

    static StorageReference storageReference= FirebaseStorage.getInstance().getReference();

    static  String kul_mail;

    static SharedPreferences sharedPref;
    static SharedPreferences.Editor editor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
setContentView(R.layout.benim_tekil_kirala);

      ilan_id=  getIntent().getStringExtra("ilan_id");
        System.out.println("Benim İLanlarimdan gelen kirala id si = "+ilan_id);
       il_id=Integer.valueOf(ilan_id.trim());

        sharedPref = getApplicationContext().getSharedPreferences("MyPref",0);
        editor = sharedPref.edit();

        kul_mail =sharedPref.getString("email",null);


        silbtn= (Button) findViewById(R.id.benimtklkiralasilbtn);

        editbtn= (Button) findViewById(R.id.benimtklkiralaeditbtn);




     new  MyAd().execute();



        silbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder builder=new AlertDialog.Builder(Benim_Tekil_Kira_Goster.this);
                LayoutInflater inflater=getLayoutInflater();
                View dialog_layout=inflater.inflate(R.layout.kayitsil,null);

                builder.setView(dialog_layout).setPositiveButton("SİL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

new SilAd().execute();

                     //   il_id url de yerine yazılı silinecek ayrıca atspacede bunun icin php dosyası olusturuulucak


           /*             try{
                            URL url=new URL("http://vodkamorello.atspace.co.uk/kiralasil.php"+"?ilan_id="+il_id);
                            HttpURLConnection con= (HttpURLConnection) url.openConnection();
                            con.setRequestMethod("GET");
                            con.connect();

                            BufferedReader bf=new BufferedReader(new InputStreamReader(con.getInputStream()));
                            String  sonuc=bf.readLine();
                             System.out.println(sonuc);
                            Intent intent = new Intent(Benim_Tekil_Kira_Goster.this,UserMainActivity.class);
                            startActivity(intent);
                        }
                        catch (Exception e){
                            System.out.println("Silmede Hata var ="+e.getCause());
                            e.printStackTrace();
                        }
*/




                       // Intent intent = new Intent(Benim_Tekil_Kira_Goster.this,UserMainActivity.class);
                        //startActivity(intent);

                    }
                })
                        .setNegativeButton("İPTAL ET", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });

                builder.show();




            }
        });


        editbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



    }


    public class UpdateAd extends  AsyncTask{

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
            return null;
        }
    }



    public class SilAd extends  AsyncTask{



        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Object o) {

        }

        @Override
        protected Object doInBackground(Object[] params) {

            try{

                URL   url=new URL("http://vodkamorello.atspace.co.uk/GetKiralaFireid.php"+"?ilan_id="+il_id);
                HttpURLConnection  con= (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.connect();
                BufferedReader  bf=new BufferedReader(new InputStreamReader(con.getInputStream()));
                String  sonuc=bf.readLine();
                int fire_id=Integer.valueOf(sonuc);

                bf.close();
                con.disconnect();





                 url=new URL("http://vodkamorello.atspace.co.uk/kiralasil.php"+"?ilan_id="+il_id);
                 con= (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.connect();

                 bf=new BufferedReader(new InputStreamReader(con.getInputStream()));
                  sonuc=bf.readLine();
                System.out.println(sonuc);

                bf.close();
                con.disconnect();




              /*  StringTokenizer token = new StringTokenizer(sonuc, ".");
 int i=0;
                int fire_id=0;
                while (token.hasMoreTokens()) {

                    String temp = token.nextToken();

                    if(i==1){
                         fire_id=Integer.valueOf(temp.trim());
                    }
i++;
                }*/


                storageReference.child("images/herkirala/"+il_id).delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        System.out.println("Her kiraladan kayit basariyla silindi");
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        System.out.println("Her kiraladan kayit silinemedi");
                    }
                });


                storageReference.child("images/kirala/"+kul_mail+"/"+fire_id).delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        System.out.println("Her kiraladan kayit basariyla silindi");
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        System.out.println("Her kiraladan kayit silinemedi");
                    }
                });





                Intent intent = new Intent(Benim_Tekil_Kira_Goster.this,UserMainActivity.class);
                startActivity(intent);
            }
            catch (Exception e){
                System.out.println("Silmede Hata var ="+e.getCause());
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



            textView= (TextView) findViewById(R.id.Tkirala_yayin_mulktur);
            String kirala_yayin_mulktur=textView.getText().toString();
            textView.setText(kirala_yayin_mulktur+" "+kirala1mulktur);


            textView= (TextView) findViewById(R.id.Tkirala_yayin_ilanverentur);
            String kirala_yayin_ilanverentur=textView.getText().toString();
            textView.setText(kirala_yayin_ilanverentur+" "+kirala2ilanveren);

            textView= (TextView) findViewById(R.id.Tkirala_yayin_adres);
            String kirala_yayin_adres=textView.getText().toString();
            textView.setText(kirala_yayin_adres+" "+kirala3adres);

                 /*   imageView= (ImageView) findViewById(R.id.kirala_yayin_resim);

                    if (!kirala6resim.equalsIgnoreCase("")) {
                        //Decoding the Image and display in ImageView
                        byte[] b = Base64.decode(kirala6resim, Base64.DEFAULT);
                        Bitmap bitmap = BitmapFactory.decodeByteArray(b, 0, b.length);
                        imageView.setImageBitmap(bitmap);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"You don't have Image in SharedPreferences!", Toast.LENGTH_SHORT).show();
                    }
*/


            textView= (TextView) findViewById(R.id.Tkirala_yayin_m2);
            String kirala_yayin_m2=textView.getText().toString();
            textView.setText(kirala_yayin_m2+" "+kirala7m2);

            textView= (TextView) findViewById(R.id.Tkirala_yayin_odasayi);
            String kirala_yayin_odasayi=textView.getText().toString();
            textView.setText(kirala_yayin_odasayi+" "+kirala7oda);

            textView= (TextView) findViewById(R.id.Tkirala_yayin_bkat);
            String kirala_yayin_bkat=textView.getText().toString();
            textView.setText(kirala_yayin_bkat+" "+kirala7bkat);

            textView= (TextView) findViewById(R.id.Tkirala_yayin_katsayi);
            String kirala_yayin_katsayi=textView.getText().toString();
            textView.setText(kirala_yayin_katsayi+" "+kirala7kat);


            textView= (TextView) findViewById(R.id.Tkirala_yayin_esyalimi);
            String kirala_yayin_esyalimi=textView.getText().toString();
            textView.setText(kirala_yayin_esyalimi+" "+kirala7esya);

            textView= (TextView) findViewById(R.id.Tkirala_yayin_aidat);
            String kirala_yayin_aidat=textView.getText().toString();
            textView.setText(kirala_yayin_aidat+" "+kirala7aidat);

            textView= (TextView) findViewById(R.id.Tkirala_yayin_kira);
            String kirala_yayin_kira=textView.getText().toString();
            textView.setText(kirala_yayin_kira+" "+kirala7kira);

            textView= (TextView) findViewById(R.id.Tkirala_yayin_odauyguntarih);
            String kirala_yayin_odauyguntarih=textView.getText().toString();
            textView.setText(kirala_yayin_odauyguntarih+" "+kirala8tarih);

            textView= (TextView) findViewById(R.id.Tkirala_yayin_erkeksayi);
            String kirala_yayin_erkeksayi=textView.getText().toString();
            textView.setText(kirala_yayin_erkeksayi+" "+kirala9erkeksayi);

            textView= (TextView) findViewById(R.id.Tkirala_yayin_kizsayi);
            String kirala_yayin_kizsayi=textView.getText().toString();
            textView.setText(kirala_yayin_kizsayi+" "+kirala9kizsayi);

            textView= (TextView) findViewById(R.id.Tkirala_yayin_evcilvarmi);
            String kirala_yayin_evcilvarmi=textView.getText().toString();
            textView.setText(kirala_yayin_evcilvarmi+" "+kirala10var);

            textView= (TextView) findViewById(R.id.Tkirala_yayin_sigaravarmi);
            String kirala_yayin_sigaravarmi=textView.getText().toString();
            textView.setText(kirala_yayin_sigaravarmi+" "+kirala11evet);

              /*      textView= (TextView) findViewById(R.id.kirala_yayin_kimlelive);
                    String kirala_yayin_kimlelive=textView.getText().toString();
                    // textView.setText(kirala_yayin_kimlelive+" kirala1mulktur");*/

            textView= (TextView) findViewById(R.id.Tkirala_yayin_hangiyas);
            String kirala_yayin_hangiyas=textView.getText().toString();
            textView.setText(kirala_yayin_hangiyas+" "+kirala13yas);

            textView= (TextView) findViewById(R.id.Tkirala_yayin_no);
            String kirala_yayin_no=textView.getText().toString();
            textView.setText(kirala_yayin_no+" "+kirala14numara);

            textView= (TextView) findViewById(R.id.Tkirala_yayin_baslik);
            String kirala_yayin_baslik=textView.getText().toString();
            textView.setText(kirala_yayin_baslik+" " + kirala15baslik);

            textView= (TextView) findViewById(R.id.Tkirala_yayin_aciklama);
            String kirala_yayin_aciklama=textView.getText().toString();
            textView.setText(kirala_yayin_aciklama+" "+kirala15aciklama);



            ilan_url="http://vodkamorello.atspace.co.uk/tekilkiragetir.php";
        }

        @Override
        protected Object doInBackground(Object[] params) {

            try{
                URL url=new URL(ilan_url+"?ilan_id="+il_id);
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

                    kirala1mulktur = temp.substring(temp.indexOf("mulktur:") + 9, temp.indexOf("-", temp.indexOf("mulktur:")));
                    System.out.println("kirala1mulktur = " + kirala1mulktur);

                    kirala2ilanveren = temp.substring(temp.indexOf("ilanverentur :") + 15, temp.indexOf("-", temp.indexOf("ilanverentur :")));
                    System.out.println("kirala2ilanveren = " + kirala2ilanveren);

                    kirala3adres = temp.substring(temp.indexOf("mulkadres:") + 10, temp.indexOf("-", temp.indexOf("mulkadres:")));
                    kirala3adres = kirala3adres.replaceAll("\\s+", "");
                    System.out.println("kirala3adres = " + kirala3adres);


                    //String   kirala6resim=temp.substring(temp.indexOf("mulktur:"),temp.indexOf("-",temp.indexOf("mulktur:")) );
                    //  System.out.println("kirala6resim = "+kirala6resim);

                    kirala7m2 = temp.substring(temp.indexOf("kacm2:") + 6, temp.indexOf("-", temp.indexOf("kacm2:")));
                    System.out.println("kirala7m2 = " + kirala7m2);

                    kirala7oda = temp.substring(temp.indexOf("odasayisi:") + 10, temp.indexOf("-", temp.indexOf("odasayisi:")));
                    System.out.println("kirala7oda = " + kirala7oda);

                    kirala7kat = temp.substring(temp.indexOf("katsayisi:") + 10, temp.indexOf("-", temp.indexOf("katsayisi:")));
                    System.out.println("kirala7kat = " + kirala7kat);

                    kirala7bkat = temp.substring(temp.indexOf("bulundugukat:") + 13, temp.indexOf("-", temp.indexOf("bulundugukat:")));
                    System.out.println("kirala7bkat = " + kirala7bkat);

                    kirala7aidat = temp.substring(temp.indexOf("aidat:") + 6, temp.indexOf("-", temp.indexOf("aidat:")));
                    System.out.println("kirala7aidat = " + kirala7aidat);

                    kirala7kira = temp.substring(temp.indexOf("kiraucret:") + 10, temp.indexOf("-", temp.indexOf("kiraucret: ")));
                    System.out.println("kirala7kira = " + kirala7kira);

                    kirala7esya = temp.substring(temp.indexOf("esyalimi:") + 9, temp.indexOf("-", temp.indexOf("esyalimi: ")));
                    System.out.println("kirala7esya = " + kirala7esya);

                    kirala8tarih = temp.substring(temp.indexOf("odauyguntarih:") + 14, temp.indexOf("-", temp.indexOf("odauyguntarih: ")));
                    System.out.println("kirala8tarih = " + kirala8tarih);

                    kirala9kizsayi = temp.substring(temp.indexOf("kizsayi:") + 8, temp.indexOf("-", temp.indexOf("kizsayi: ")));
                    System.out.println("kirala9kizsayi = " + kirala9kizsayi);

                    kirala9erkeksayi = temp.substring(temp.indexOf("erkeksayi:") + 10, temp.indexOf("-", temp.indexOf("erkeksayi: ")));
                    System.out.println("kirala9erkeksayi = " + kirala9erkeksayi);

                    kirala10var = temp.substring(temp.indexOf("havepet:") + 8, temp.indexOf("-", temp.indexOf("havepet: ")));
                    System.out.println("kirala10var = " + kirala10var);

                    kirala11evet = temp.substring(temp.indexOf("havesmoke:") + 10, temp.indexOf("-", temp.indexOf("havesmoke: ")));
                    System.out.println("kirala11evet = " + kirala11evet);

                /*    String kirala12erkek=temp.substring(temp.indexOf("mulktur:"),temp.indexOf("-",temp.indexOf("mulktur:")) );
                    System.out.println("kirala12erkek = "+ kirala12erkek);

                    String kirala12kiz=temp.substring(temp.indexOf("mulktur:"),temp.indexOf("-",temp.indexOf("mulktur:")) );
                    System.out.println("kirala12kiz = "+kirala12kiz);

                    String kirala12ogr=temp.substring(temp.indexOf("mulktur:"),temp.indexOf("-",temp.indexOf("mulktur:")) );
                    System.out.println("kirala12ogr = "+kirala12ogr);

                    String kirala12clsn=temp.substring(temp.indexOf("mulktur:"),temp.indexOf("-",temp.indexOf("mulktur:")) );
                    System.out.println("kirala12clsn = "+ kirala12clsn);

                    String kirala12sgr=temp.substring(temp.indexOf("mulktur:"),temp.indexOf("-",temp.indexOf("mulktur:")) );
                    System.out.println("kirala12sgr = "+kirala12sgr);

                    String kirala12hyvn=temp.substring(temp.indexOf("mulktur:"),temp.indexOf("-",temp.indexOf("mulktur:")) );
                    System.out.println("kirala12hyvn = "+kirala12hyvn);*/

                    kirala13yas = temp.substring(temp.indexOf("happywithage:") + 12, temp.indexOf("-", temp.indexOf("happywithage: ")));
                    System.out.println("kirala13yas = " + kirala13yas);

                    kirala14numara = temp.substring(temp.indexOf("telefonno:") + 10, temp.indexOf("-", temp.indexOf("telefonno: ")));
                    System.out.println("kirala14numara = " + kirala14numara);


                    kirala15baslik = temp.substring(temp.indexOf("ilanbaslik:") + 11, temp.indexOf("-", temp.indexOf("ilanbaslik: ")));
                    System.out.println("kirala15baslik" + kirala15baslik);

                    kirala15aciklama = temp.substring(temp.indexOf("ilanaciklama: ")+13);
                    System.out.println("kirala15aciklama=" + kirala15aciklama);

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
