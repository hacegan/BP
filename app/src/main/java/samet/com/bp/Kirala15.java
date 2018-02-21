package samet.com.bp;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.dd.CircularProgressButton;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.UUID;



/**
 * Created by root on 20.11.2017.
 */

public class Kirala15 extends AppCompatActivity {
    Button btn,btndvm;
    Toolbar tb;
    EditText baslik,aciklama;
  static  SharedPreferences sharedPref;
 static   SharedPreferences.Editor editor;
    CircularProgressButton cbp;
   static String kirala_upload_url="http://vodkamorello.atspace.co.uk/kirala_upload.php";
    static String kirala6resim;
    static String  sonuc;
    static  StorageReference storageReference= FirebaseStorage.getInstance().getReference();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kirala15);
        btn= (Button) findViewById(R.id.geribtn);

        tb= (Toolbar) findViewById(R.id.supappbar);
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sharedPref = getApplicationContext().getSharedPreferences("MyPref",0);
        editor = sharedPref.edit();

        baslik= (EditText) findViewById(R.id.kirala15baslik);
        aciklama= (EditText) findViewById(R.id.kirala15aciklama);


        String kirala1mulktur=sharedPref.getString("kirala1mulktur",null);
        System.out.println("kirala1mulktur = "+kirala1mulktur);

        String kirala2ilanveren=sharedPref.getString("kirala2ilanveren",null);
        System.out.println("kirala2ilanveren = "+kirala2ilanveren);

        String kirala3adres=sharedPref.getString("kirala3adres",null);
        kirala3adres= kirala3adres.replaceAll("\\s+","");
        System.out.println("kirala3adres = "+kirala3adres);

        String kiralasecilenil=sharedPref.getString("kiralasecilenil",null);
        System.out.println("kiralasecilenil = "+kiralasecilenil);

        String kiralasecilenilce=sharedPref.getString("kiralasecilenilce",null);
        System.out.println("kiralasecilenilce = "+kiralasecilenilce);

        kirala6resim=sharedPref.getString("kirala6resim",null);
      //  System.out.println("kirala6resim = "+kirala6resim);

        String kirala7m2=sharedPref.getString("kirala7m2",null);
        System.out.println("kirala7m2 = "+kirala7m2);

        String kirala7oda=sharedPref.getString("kirala7oda",null);
        System.out.println("kirala7oda = "+kirala7oda);

        String kirala7kat=sharedPref.getString("kirala7kat",null);
        System.out.println("kirala7kat = "+kirala7kat);

        String kirala7bkat=sharedPref.getString("kirala7bkat",null);
        System.out.println("kirala7bkat = "+kirala7bkat);

        String kirala7aidat=sharedPref.getString("kirala7aidat",null);
        System.out.println("kirala7aidat = "+kirala7aidat);

        String kirala7kira=sharedPref.getString("kirala7kira",null);
        System.out.println("kirala7kira = "+kirala7kira);

        String kirala7esya=sharedPref.getString("kirala7esya",null);
        System.out.println("kirala7esya = "+kirala7esya);

        String kirala8tarih=sharedPref.getString("kirala8tarih",null);
        System.out.println("kirala8tarih = "+kirala8tarih);

        String kirala9kizsayi=sharedPref.getString("kirala9kizsayi",null);
        System.out.println("kirala9kizsayi = "+kirala9kizsayi);

        String kirala9erkeksayi=sharedPref.getString("kirala9erkeksayi",null);
        System.out.println("kirala9erkeksayi = "+kirala9erkeksayi);

        String kirala10var=sharedPref.getString("kirala10var",null);
        System.out.println("kirala10var = "+kirala10var);

        String kirala11evet=sharedPref.getString("kirala11evet",null);
        System.out.println("kirala11evet = "+ kirala11evet);

        String kirala12erkek=sharedPref.getString("kirala12erkek",null);
        System.out.println("kirala12erkek = "+ kirala12erkek);

        String kirala12kiz=sharedPref.getString("kirala12kiz",null);
        System.out.println("kirala12kiz = "+kirala12kiz);

        String kirala12ogr=sharedPref.getString("kirala12ogr",null);
        System.out.println("kirala12ogr = "+kirala12ogr);

        String kirala12clsn=sharedPref.getString("kirala12clsn",null);
        System.out.println("kirala12clsn = "+ kirala12clsn);

        String kirala12sgr=sharedPref.getString("kirala12sgr",null);
        System.out.println("kirala12sgr = "+kirala12sgr);

        String kirala12hyvn=sharedPref.getString("kirala12hyvn",null);
        System.out.println("kirala12hyvn = "+kirala12hyvn);

        String kirala13yas=sharedPref.getString("kirala13yas",null);
        System.out.println("kirala13yas = "+kirala13yas);

        String  kirala14numara=sharedPref.getString("kirala14numara",null);
        System.out.println("kirala14numara = "+kirala14numara);

        kirala_upload_url+="?kirala1mulktur="+kirala1mulktur+"&kirala2ilanveren="+kirala2ilanveren+"&kirala3adres="+kirala3adres+"&kirala7m2="+kirala7m2+"&kirala7oda="+kirala7oda
        +"&kirala7kat="+kirala7kat+"&kirala7bkat="+kirala7bkat+"&kirala7aidat="+kirala7aidat+"&kirala7kira="+kirala7kira+"&kirala7esya="+kirala7esya+"&kirala8tarih="+kirala8tarih
        +"&kirala9kizsayi="+kirala9kizsayi+"&kirala9erkeksayi="+kirala9erkeksayi+"&kirala10var="+kirala10var+"&kirala11evet="+kirala11evet+"&kirala13yas="+kirala13yas
        +"&kirala14numara="+kirala14numara
        ;

        cbp= (CircularProgressButton) findViewById(R.id.btnWithText);
       // cbp.setIndeterminateProgressMode(true);

        cbp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                kirala_upload_url+="&kirala15baslik="+baslik.getText().toString()+"&kirala15aciklama="+aciklama.getText().toString();
                System.out.println(kirala_upload_url);
                new  KiralaTask().execute();

         if(sonuc.equals("Ilan Basariyla eklendi . ")){
             if (cbp.getProgress() == 0) {
                 simulateSuccessProgress(cbp);

             } else {
                 cbp.setProgress(0);
             }
         }
         else{
             if (cbp.getProgress() == 0) {
                 simulateErrorProgress(cbp);
             } else {
                 cbp.setProgress(0);
             }
         }



            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kirala15.this,Kirala14.class);
                startActivity(intent);
            }
        });

btndvm= (Button) findViewById(R.id.btndvm);
        btndvm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("kirala15baslik",baslik.getText().toString());
                editor.putString("kirala15aciklama",aciklama.getText().toString());
                editor.commit();
                kirala_upload_url+="&kirala15baslik="+baslik.getText().toString()+"&kirala15aciklama="+aciklama.getText().toString();
                System.out.println(kirala_upload_url);
                kirala_upload_url+="&user_id="+sharedPref.getString("user_id",null);
              new  KiralaTask().execute();

                Intent intent = new Intent(Kirala15.this,Kirala_Yayin_Kontrol.class);
                startActivity(intent);

            }
        });


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Kirala15.this,Kirala14.class);
        startActivity(intent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);


        switch (requestCode) {
            case 2:

                if(grantResults[0]== PackageManager.PERMISSION_GRANTED){
                    byte[] b = Base64.decode(kirala6resim, Base64.DEFAULT);
                    Bitmap bitmap = BitmapFactory.decodeByteArray(b,0,b.length);

                    String path = MediaStore.Images.Media.insertImage(getApplicationContext().getContentResolver(), bitmap, "Title", null);
                    Uri myUri=   Uri.parse(path);


                    String kul_mail=sharedPref.getString("email",null);

//                final ProgressDialog progressDialog=new ProgressDialog(getApplicationContext());
                    StorageReference ref=storageReference.child("images/kirala/"+kul_mail+"/"+firebase_kirala_imgpojo.kirala_img_id);

                    ref.putFile(myUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            firebase_kirala_imgpojo.kirala_img_id+=1;
                            System.out.println("Firebase dosya basirlya yüklendi");
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            System.out.println("Firebase dosya yüklenmedi = "+e.getCause());
                        }
                    }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress=(100.0*taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());
                            //  progressDialog.setMessage("Yüklendi "+(int)progress+"%");
                            System.out.println("Dosya yükleniyor...");
                        }
                    });



                }else{
                    Toast.makeText(getApplicationContext(),"İzin vermeniz gerekli",Toast.LENGTH_LONG);
                }
                break;


        }




    }

    public class KiralaTask extends AsyncTask{


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

            try{
                URL url=new URL(kirala_upload_url);
                HttpURLConnection con= (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.connect();

                BufferedReader bf=new BufferedReader(new InputStreamReader(con.getInputStream()));
                sonuc=bf.readLine();
                System.out.println(sonuc);

                con.disconnect();


                String kul_mail=sharedPref.getString("email",null);

                 url=new URL("http://vodkamorello.atspace.co.uk/kiralamaxdegerimage.php?email="+kul_mail);
                con= (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.connect();

               bf=new BufferedReader(new InputStreamReader(con.getInputStream()));
                sonuc=bf.readLine();
con.disconnect();

                int ensonid=0;
                if(sonuc=="null"){
                    url=new URL("http://vodkamorello.atspace.co.uk/kiralaimagedegerolustur.php?email="+kul_mail);
                    con= (HttpURLConnection) url.openConnection();
                    con.setRequestMethod("GET");
                    con.connect();

                    bf=new BufferedReader(new InputStreamReader(con.getInputStream()));
                    sonuc=bf.readLine();
                    con.disconnect();



                }
                else {
                    ensonid = Integer.valueOf(sonuc);

                }


                byte[] b = Base64.decode(kirala6resim, Base64.DEFAULT);
                Bitmap bitmap = BitmapFactory.decodeByteArray(b,0,b.length);


                if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        == PackageManager.PERMISSION_GRANTED) {


                    String path = MediaStore.Images.Media.insertImage(getApplicationContext().getContentResolver(), bitmap, "Title", null);
                    Uri myUri=   Uri.parse(path);



//                final ProgressDialog progressDialog=new ProgressDialog(getApplicationContext());
                    StorageReference ref=storageReference.child("images/kirala/"+kul_mail+"/"+ensonid);

                    ref.putFile(myUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            firebase_kirala_imgpojo.kirala_img_id+=1;
                            System.out.println("Firebase dosya basirlya yüklendi");
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            System.out.println("Firebase dosya yüklenmedi = "+e.getCause());

                        }
                    }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress=(100.0*taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());
                            //  progressDialog.setMessage("Yüklendi "+(int)progress+"%");
                            System.out.println("Dosya yükleniyor...");
                        }
                    });



                }//İzin alındı

else{
                    ActivityCompat.requestPermissions(Kirala15.this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 2);
                }




            }
            catch (Exception e){
                e.printStackTrace();
            }



            return null;
        }




    }


    private void simulateErrorProgress(final CircularProgressButton button) {
        ValueAnimator widthAnimation = ValueAnimator.ofInt(1, 99);
        widthAnimation.setDuration(1500);
        widthAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        widthAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Integer value = (Integer) animation.getAnimatedValue();
                button.setProgress(value);
                if (value == 99) {
                    button.setProgress(-1);
                }
            }
        });
        widthAnimation.start();
    }


    private void simulateSuccessProgress(final CircularProgressButton button) {
        ValueAnimator widthAnimation = ValueAnimator.ofInt(1, 100);
        widthAnimation.setDuration(1500);
        widthAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        widthAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Integer value = (Integer) animation.getAnimatedValue();
                button.setProgress(value);
            }




        });
        widthAnimation.start();
      //  Intent intent = new Intent(Kirala15.this,Kirala_Yayin_Kontrol.class);
        //startActivity(intent);
    }



}
