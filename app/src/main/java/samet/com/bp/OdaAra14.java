package samet.com.bp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
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
    static  StorageReference storageReference;
   static String odaara2resim;
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
                +"&odaara6evet="+odaara6evet+"&odaara8tv="+odaara8tv+"&odaarahangiil="+odaarahangiil+"&odaarahangiilce="+odaarahangiilce
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

                ara_upload_url+="&odaara14baslik"+baslik.getText().toString()+"&odaara14aciklama="+aciklama.getText().toString()+"&user_id="+sharedPref.getString("user_id",null);
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

                byte[] b = Base64.decode(odaara2resim, Base64.DEFAULT);
                Bitmap bitmap = BitmapFactory.decodeByteArray(b,0,b.length);

                String path = MediaStore.Images.Media.insertImage(getApplicationContext().getContentResolver(), bitmap, "Title", null);
                Uri myUri=   Uri.parse(path);


                String kul_mail=sharedPref.getString("email",null);

//                final ProgressDialog progressDialog=new ProgressDialog(getApplicationContext());
                StorageReference ref=storageReference.child("images/ara/"+kul_mail+"/"+ UUID.randomUUID().toString());

                ref.putFile(myUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                        double progress=(100.0*taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());
                        //  progressDialog.setMessage("Yüklendi "+(int)progress+"%");
                    }
                });



            }
            catch (Exception e){
                e.printStackTrace();
            }



            return null;
        }




    }



}
