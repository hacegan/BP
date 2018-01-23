package samet.com.bp;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.mindorks.paracamera.Camera;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * Created by root on 20.11.2017.
 */

public class OdaAra2 extends AppCompatActivity {

    Button btn,fotocekbtn,fotosecbtn,btndvm;
    ImageView iv;
    Toolbar tb;
    private static int LOAD_IMAGE_RESULTS=2;
    Camera camera;

    SharedPreferences sharedPref ;
    SharedPreferences.Editor editor;

    String encodedImage;

    private String uploadurl="http://vodkamorello.atspace.co.uk/kiralaimageupload.php";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.odaiste2);

        sharedPref = getApplicationContext().getSharedPreferences("MyPref",0);
        editor = sharedPref.edit();

        btn= (Button) findViewById(R.id.geribtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OdaAra2.this,OdaAra1.class);
                startActivity(intent);
            }
        });


        fotocekbtn= (Button) findViewById(R.id.fotocekbtn);
        fotosecbtn= (Button) findViewById(R.id.fotosecbtn);
        btndvm= (Button) findViewById(R.id.btndvm);

        iv= (ImageView) findViewById(R.id.camerapic);


        tb= (Toolbar) findViewById(R.id.supappbar);
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btndvm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OdaAra2.this,OdaAra3.class);
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

                if (ContextCompat.checkSelfPermission(OdaAra2.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(OdaAra2.this, new String[] { Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE }, 0);
                }


                camera=new Camera.Builder().resetToCorrectOrientation(true)
                        .setTakePhotoRequestCode(1)
                        .setDirectory("pics")
                        .setName("samet_"+System.currentTimeMillis())
                        .setImageFormat(Camera.IMAGE_JPEG)
                        .setCompression(75)
                        .setImageHeight(1000)
                        .build(OdaAra2.this);

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


                    editor.putString("odaara2resim", encodedImage);
                    editor.commit();
                    Toast.makeText(getApplicationContext(),"Image has been Stored!",Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                String kullanici_ismi = sharedPref.getString("kullaniciismi",null);


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


                editor.putString("odaara2resim", encodedImage);
                editor.commit();
                Toast.makeText(getApplicationContext(),"Image has been Stored!",Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                e.printStackTrace();
            }


            String kullanici_ismi = sharedPref.getString("kullaniciismi",null);



        }



    }






    @Override
    public void onBackPressed() {
        Intent intent = new Intent(OdaAra2.this,OdaAra1.class);
        startActivity(intent);
    }
}
