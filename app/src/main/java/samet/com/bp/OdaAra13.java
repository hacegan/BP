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

public class OdaAra13 extends AppCompatActivity {

    Button btn,btnevet,btnhayir;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.odaiste11);
        btn= (Button) findViewById(R.id.geribtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OdaAra13.this,OdaAra12.class);
                startActivity(intent);
            }
        });

        btnevet= (Button) findViewById(R.id.btnevet);
        btnhayir= (Button) findViewById(R.id.btnhayir);
        btnevet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OdaAra13.this,OdaAra14.class);
                startActivity(intent);
            }
        });

        btnhayir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OdaAra13.this,OdaAra14.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(OdaAra13.this,OdaAra12.class);
        startActivity(intent);
    }
}
