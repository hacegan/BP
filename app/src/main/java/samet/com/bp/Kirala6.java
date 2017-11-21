package samet.com.bp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by root on 20.11.2017.
 */

public class Kirala6 extends AppCompatActivity {
    Button btn,fotocekbtn,fotosecbtn,btndvm;

    int REQUEST_CAMERA=1,SELECT_FILE=1;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kirala6);

        fotocekbtn= (Button) findViewById(R.id.fotocekbtn);
        fotosecbtn= (Button) findViewById(R.id.fotosecbtn);
        btndvm= (Button) findViewById(R.id.btndvm);


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
                Intent intent=new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                intent.setType("image/*");
                startActivityForResult(Intent.createChooser(intent,"Dosyayı Seçin"),SELECT_FILE);
            }
        });


        fotocekbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,REQUEST_CAMERA);
            }
        });


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Kirala6.this,Kirala5.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode== Activity.RESULT_OK){

            if(requestCode==REQUEST_CAMERA){
Bundle bundle=data.getExtras();
                final Bitmap bmp = (Bitmap) bundle.get("data");
                //img.setImageBitmap(bmp=;
            }
            else if(requestCode==SELECT_FILE){
Uri selectedImageUri=data.getData();
                //img.setImageBitmap(bmp=;
            }


        }


    }




}
