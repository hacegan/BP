package samet.com.bp;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.vansuita.pickimage.bean.PickResult;
import com.vansuita.pickimage.listeners.IPickResult;

import java.util.ArrayList;

import static android.media.MediaRecorder.VideoSource.CAMERA;


/**
 * Created by root on 20.11.2017.
 */

public class Kirala6 extends AppCompatActivity  {
    Button btn,fotocekbtn,fotosecbtn,btndvm;
ImageView iv;

 private static int LOAD_IMAGE_RESULTS=1;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kirala6);

        fotocekbtn= (Button) findViewById(R.id.fotocekbtn);
        fotosecbtn= (Button) findViewById(R.id.fotosecbtn);
        btndvm= (Button) findViewById(R.id.btndvm);
        iv= (ImageView) findViewById(R.id.camerapic);


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
                Intent i =new Intent( MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i,2);
            }
            });





    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if(requestCode==2 && resultCode==RESULT_OK ){
         Bundle extras=data.getExtras();
            Bitmap photo= (Bitmap) extras.get("data");
iv.setImageBitmap(photo);


        }




        if(requestCode==LOAD_IMAGE_RESULTS && resultCode==RESULT_OK ){
            Uri pickedImage = data.getData();
iv.setImageURI(pickedImage);

        }



    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Kirala6.this,Kirala5.class);
        startActivity(intent);
    }


}
