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

public class OdaAra4 extends AppCompatActivity {

    Button btn,btnogr,btnclsn,btndgr;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.odaiste4);
        btn= (Button) findViewById(R.id.geribtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OdaAra4.this,OdaAra3.class);
                startActivity(intent);
            }
        });


        btnclsn= (Button) findViewById(R.id.btncalisan);
        btndgr= (Button) findViewById(R.id.btndiger);
        btnogr= (Button) findViewById(R.id.btnogrenci);

        btnclsn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OdaAra4.this,OdaAra5.class);
                startActivity(intent);
            }
        });


        btndgr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OdaAra4.this,OdaAra5.class);
                startActivity(intent);
            }
        });

        btnogr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OdaAra4.this,OdaAra5.class);
                startActivity(intent);
            }
        });



    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(OdaAra4.this,OdaAra3.class);
        startActivity(intent);
    }
}
