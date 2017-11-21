package samet.com.bp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by root on 20.11.2017.
 */

public class Kirala6 extends AppCompatActivity {
    Button btn,fotocekbtn,fotosecbtn,btndvm;

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



    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Kirala6.this,Kirala5.class);
        startActivity(intent);
    }
}
