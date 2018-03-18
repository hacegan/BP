package samet.com.bp;

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
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;

/**
 * Created by root on 20.11.2017.
 */

public class OdaAra14 extends AppCompatActivity {

    Button btn,btndvm;
    Toolbar tb;
    EditText aciklama,baslik;
    SharedPreferences sharedPref ;
    SharedPreferences.Editor editor;
    static String ara_upload_url="http://vodkamorello.atspace.co.uk/ara_upload.php";
    static String  sonuc;
    static  StorageReference storageReference= FirebaseStorage.getInstance().getReference();
   static String odaara2resim;
   static int heraraid;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.odaiste14);


        tb= (Toolbar) findViewById(R.id.supappbar);
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        sharedPref = getApplicationContext().getSharedPreferences("MyPref",0);
        editor = sharedPref.edit();

        aciklama= (EditText) findViewById(R.id.oda14aciklama);
baslik= (EditText) findViewById(R.id.oda14baslik);

String odaara1bay=sharedPref.getString("odaara1bay",null);
        System.out.println("odaara1bay ="+odaara1bay);

         odaara2resim=sharedPref.getString("odaara2resim",null);
        //System.out.println("odaara2resim = "+odaara2resim);

        String odaara3yas=sharedPref.getString("odaara3yas",null);
        System.out.println("odaara3yas = "+odaara3yas);

String odaara4meslek=sharedPref.getString("odaara4meslek",null);
        System.out.println("odaara4meslek = "+odaara4meslek);

String odaara5evet=sharedPref.getString("odaara5evet",null);
        System.out.println("odaara5evet = "+odaara5evet);

        String odaara6evet=sharedPref.getString("odaara6evet",null);
        System.out.println("odaara6evet = "+odaara6evet);

        String odaara8tv =sharedPref.getString("odaara8tv",null);
        System.out.println("odaara8tv = "+odaara8tv);

        String odaarahangiil=sharedPref.getString("odaarahangiil",null);
        System.out.println("odaarahangiil = "+odaarahangiil);

String odaarahangiilce=sharedPref.getString("odaarahangiilce",null);
        System.out.println("odaarahangiilce = "+odaarahangiilce);

        String odaara10butce=sharedPref.getString("odaara10butce",null);
        System.out.println("odaara10butce = "+odaara10butce);

        String odaara11tarih=sharedPref.getString("odaara11tarih",null);
        System.out.println("odaara11tarih = "+odaara11tarih);

        String odaara12sure=sharedPref.getString("odaara12sure",null);
        System.out.println("odaara12sure = "+odaara12sure);

        String odaara13numara=sharedPref.getString("odaara13numara",null);
        System.out.println("odaara13numara = "+odaara13numara);

        ara_upload_url+="?odaara1bay="+odaara1bay+"&odaara3yas="+odaara3yas+"&odaara4meslek="+odaara4meslek+"&odaara5evet="+odaara5evet
                +"&odaara6evet="+odaara6evet+"&odaara8tv="+odaara8tv+"&odaarahangibolge="+odaarahangiil+"-"+odaarahangiilce
                +"&odaara10butce="+odaara10butce+"&odaara11tarih="+odaara11tarih+"&odaara12sure="+odaara12sure+"&odaara13numara="+odaara13numara;


        btndvm= (Button) findViewById(R.id.btnodaarayayinla);


        btn= (Button) findViewById(R.id.btnodaarayayinla);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btndvm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("odaara14baslik", baslik.getText().toString());
                editor.putString("odaara14aciklama", aciklama.getText().toString());
                editor.commit();

                ara_upload_url+="&odaara14baslik="+baslik.getText().toString()+"&odaara14aciklama="+aciklama.getText().toString()+"&user_id="+sharedPref.getString("user_id",null);
                new AraTask().execute();
               Intent intent = new Intent(OdaAra14.this,Ara_Yayin_Kontrol.class);
                startActivity(intent);

            }
        });



    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(OdaAra14.this,OdaAra13.class);
        startActivity(intent);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);


        switch (requestCode) {
            case 2:

                if(grantResults[0]== PackageManager.PERMISSION_GRANTED){
                    byte[] b = Base64.decode(odaara2resim, Base64.DEFAULT);
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


                    ref=storageReference.child("images/herara/"+heraraid);

                    ref.putFile(myUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            firebase_kirala_imgpojo.kirala_img_id+=1;
                            System.out.println("HER Firebase dosya basirlya yüklendi");
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            System.out.println("HER Firebase dosya yüklenmedi = "+e.getCause());

                        }
                    }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress=(100.0*taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());
                            //  progressDialog.setMessage("Yüklendi "+(int)progress+"%");
                            System.out.println("HER Dosya yükleniyor...");
                        }
                    });


                }else{
                    Toast.makeText(getApplicationContext(),"İzin vermeniz gerekli",Toast.LENGTH_LONG);
                }
                break;


        }




    }


    public class AraTask extends AsyncTask {


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
                URL url=new URL(ara_upload_url);
                HttpURLConnection con= (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.connect();

                BufferedReader bf=new BufferedReader(new InputStreamReader(con.getInputStream()));
                sonuc=bf.readLine();
                System.out.println(sonuc);

                con.disconnect();


                String kul_mail=sharedPref.getString("email",null);

                url=new URL("http://vodkamorello.atspace.co.uk/aramaxdegerimage.php?email="+kul_mail);
                con= (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.connect();

                bf=new BufferedReader(new InputStreamReader(con.getInputStream()));
                sonuc=bf.readLine();
                System.out.println("aramaxdegerimage sonucu ="+sonuc);
                con.disconnect();

                int ensonid=1;
                if(sonuc.equals("bos")){
                    url=new URL("http://vodkamorello.atspace.co.uk/araimagedegerolustur.php?email="+kul_mail);
                    con= (HttpURLConnection) url.openConnection();
                    con.setRequestMethod("GET");
                    con.connect();

                    bf=new BufferedReader(new InputStreamReader(con.getInputStream()));
                   sonuc=bf.readLine();
                    System.out.println("araimagedegerolustur sonucu ="+sonuc);
                   con.disconnect();
bf.close();
                    ensonid=1;

                }
                else {
                    ensonid = Integer.valueOf(sonuc.trim());

                }

//BÜtün araya eklmee
                url=new URL("http://vodkamorello.atspace.co.uk/heraramaximgolustur.php");
                con= (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.connect();

                bf=new BufferedReader(new InputStreamReader(con.getInputStream()));
                sonuc=bf.readLine();
                System.out.println("heraramaximgolustur sonucu ="+sonuc);
                bf.close();
                con.disconnect();

                 heraraid=Integer.valueOf(sonuc.trim());


                //Ara fireid güncellemesi
                url=new URL("http://vodkamorello.atspace.co.uk/arafireupdate.php");
                con= (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.connect();

                bf=new BufferedReader(new InputStreamReader(con.getInputStream()));
                sonuc=bf.readLine();
                System.out.println("arafireupdate sonucu ="+sonuc);
                bf.close();
                con.disconnect();


                byte[] b = Base64.decode(odaara2resim, Base64.DEFAULT);
                Bitmap bitmap = BitmapFactory.decodeByteArray(b,0,b.length);


                if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        == PackageManager.PERMISSION_GRANTED) {

                    String path = MediaStore.Images.Media.insertImage(getApplicationContext().getContentResolver(), bitmap, "Title", null);
                    Uri myUri = Uri.parse(path);


//                final ProgressDialog progressDialog=new ProgressDialog(getApplicationContext());
                    StorageReference ref = storageReference.child("images/ara/" + kul_mail + "/" + ensonid);

                    ref.putFile(myUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            firebase_ara_imgpojo.ara_img_id += 1;
                            System.out.println("Firebase dosya basirlya yüklendi");
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            System.out.println("Firebase dosya yüklenmedi = " + e.getCause());
                        }
                    }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
                            //  progressDialog.setMessage("Yüklendi "+(int)progress+"%");
                            System.out.println("Dosya yükleniyor...");
                        }
                    });



                    ref=storageReference.child("images/herara/"+heraraid);

                    ref.putFile(myUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            firebase_kirala_imgpojo.kirala_img_id+=1;
                            System.out.println("HER Firebase dosya basirlya yüklendi");
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            System.out.println("HER Firebase dosya yüklenmedi = "+e.getCause());

                        }
                    }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress=(100.0*taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());
                            //  progressDialog.setMessage("Yüklendi "+(int)progress+"%");
                            System.out.println("HER Dosya yükleniyor...");
                        }
                    });




                }
                else{
                    ActivityCompat.requestPermissions(OdaAra14.this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 2);
                }

            }
            catch (Exception e){
                e.printStackTrace();
            }



            return null;
        }




    }



}
