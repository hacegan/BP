package samet.com.bp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by root on 20.11.2017.
 */

public class OdaAra2 extends AppCompatActivity {

    Button btn,fotocekbtn,fotosecbtn,btndvm;
    ImageView iv;

    private static int LOAD_IMAGE_RESULTS=1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.odaiste2);
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




            }
        });


    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);



        if(requestCode==LOAD_IMAGE_RESULTS && resultCode==RESULT_OK ){
            Uri pickedImage = data.getData();
            iv.setImageURI(pickedImage);

        }



    }






    @Override
    public void onBackPressed() {
        Intent intent = new Intent(OdaAra2.this,OdaAra1.class);
        startActivity(intent);
    }
}
