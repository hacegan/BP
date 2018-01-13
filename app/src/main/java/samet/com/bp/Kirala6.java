package samet.com.bp;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CameraMetadata;
import android.hardware.camera2.CaptureRequest;
import android.media.Image;
import android.media.ImageReader;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.google.android.gms.common.images.Size;
import com.mindorks.paracamera.Camera;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import static android.media.MediaRecorder.VideoSource.CAMERA;
import static android.media.MediaRecorder.VideoSource.SURFACE;
import static com.android.volley.Request.Method.POST;


/**
 * Created by root on 20.11.2017.
 */

public class Kirala6 extends AppCompatActivity  {
    Button btn,fotocekbtn,fotosecbtn,btndvm;
ImageView iv;
    Toolbar tb;
Camera camera;
    String encodedImage;

 private static int LOAD_IMAGE_RESULTS=2;

Bitmap bitmap;

   SharedPreferences sharedPref =null;
    SharedPreferences.Editor editor ;

private String uploadurl="http://vodkamorello.cloud.unispace.io/kiralaimageupload.php";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kirala6);

        sharedPref = getApplicationContext().getSharedPreferences("MyPref",0);
        editor = sharedPref.edit();


        fotocekbtn= (Button) findViewById(R.id.fotocekbtn);
        fotosecbtn= (Button) findViewById(R.id.fotosecbtn);
        btndvm= (Button) findViewById(R.id.btndvm);

        iv= (ImageView) findViewById(R.id.camerapic);


        tb= (Toolbar) findViewById(R.id.supappbar);
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        btn= (Button) findViewById(R.id.geribtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kirala6.this,Kirala5.class);
                startActivity(intent);
            }
        });


        btndvm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kirala6.this,Kirala7.class);
                startActivity(intent);
            }
        });


        fotosecbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
Intent i =new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i,LOAD_IMAGE_RESULTS);
            }
        });


        fotocekbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ContextCompat.checkSelfPermission(Kirala6.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(Kirala6.this, new String[] { Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE }, 0);
                }


camera=new Camera.Builder().resetToCorrectOrientation(true)
        .setTakePhotoRequestCode(1)
        .setDirectory("pics")
        .setName("samet_"+System.currentTimeMillis())
        .setImageFormat(Camera.IMAGE_JPEG)
.setCompression(75)
        .setImageHeight(1000)
        .build(Kirala6.this);

                try{
camera.takePicture();
                }
                catch(Exception e){
e.printStackTrace();
                }

            }
            });

    }





    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        sharedPref = getApplicationContext().getSharedPreferences("MyPref",0);
        editor = sharedPref.edit();

        if(requestCode == Camera.REQUEST_TAKE_PHOTO){
            InputStream stream;
            Bitmap bitmap = camera.getCameraBitmap();
            if(bitmap != null) {
                iv.setImageBitmap(bitmap);
                btndvm.setText("ONAYLA VE DEVAM ET");


                try {
                    //stream = getContentResolver().openInputStream(data.getData());
                    // Encoding Image into Base64
                   // Bitmap realImage = BitmapFactory.decodeStream(stream);
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                    byte[] b = baos.toByteArray();
                    //Converting Base64 into String to Store in SharedPreferences
                    encodedImage = Base64.encodeToString(b, Base64.DEFAULT);
                    //NOw storing String to SharedPreferences


                    editor.putString("kirala6resim", encodedImage);
                    editor.commit();
                    Toast.makeText(getApplicationContext(),"Image has been Stored!",Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }



                String kullanici_ismi = sharedPref.getString("kullaniciismi",null);
                String user_id=sharedPref.getString("user_id",null);

                new resim_ekle().execute();

            }else{
                Toast.makeText(this.getApplicationContext(),"Fotoğraf Çekilmedi!",Toast.LENGTH_SHORT).show();
            }
        }




    else    if(requestCode== LOAD_IMAGE_RESULTS && resultCode==RESULT_OK ){
            InputStream stream;

            Uri pickedImage = data.getData();
            iv.setImageURI(pickedImage);
            btndvm.setText("ONAYLA VE DEVAM ET");

            try {
                stream = getContentResolver().openInputStream(data.getData());
                // Encoding Image into Base64
                Bitmap realImage = BitmapFactory.decodeStream(stream);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                realImage.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                byte[] b = baos.toByteArray();
                //Converting Base64 into String to Store in SharedPreferences
                encodedImage = Base64.encodeToString(b, Base64.DEFAULT);
                //NOw storing String to SharedPreferences


                editor.putString("kirala6resim", encodedImage);
                editor.commit();
                Toast.makeText(getApplicationContext(),"Image has been Stored!",Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                e.printStackTrace();
            }





String kullanici_ismi = sharedPref.getString("kullaniciismi",null);
String user_id=sharedPref.getString("user_id",null);

new resim_ekle().execute();

        }



    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Kirala6.this,Kirala5.class);
        startActivity(intent);
    }


public class resim_ekle extends AsyncTask{


    @Override
    protected Object doInBackground(Object[] params) {

        try{
            URL url=new URL(uploadurl);
            HttpURLConnection con= (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.connect();

            BufferedReader bf=new BufferedReader(new InputStreamReader(con.getInputStream()));
           String sonuc=bf.readLine();
            System.out.println(sonuc);


        }
        catch (Exception e){
            System.out.println(e);
        }








        return null;
    }
}



}
