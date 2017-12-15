package samet.com.bp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

/**
 * Created by root on 20.11.2017.
 */

public class OdaAra7 extends AppCompatActivity {

    Button btn,btndvm;
    Toolbar tb;
    CheckBox erkek,kiz,ogrenci,calisan,sigara,hayvan;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.odaiste7);
        btn= (Button) findViewById(R.id.geribtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OdaAra7.this,OdaAra6.class);
                startActivity(intent);
            }
        });

        tb= (Toolbar) findViewById(R.id.supappbar);
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btndvm= (Button) findViewById(R.id.btndvm);
        btndvm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OdaAra7.this,OdaAra8.class);
                startActivity(intent);
            }
        });



        erkek= (CheckBox) findViewById(R.id.odaara7erkekcb);
        kiz= (CheckBox) findViewById(R.id.odaara7kizcb);
        calisan= (CheckBox) findViewById(R.id.odaara7calisancb);
        ogrenci= (CheckBox) findViewById(R.id.odaara7ogrencicb);
        sigara= (CheckBox) findViewById(R.id.odaara7sigaracb);
        hayvan= (CheckBox) findViewById(R.id.odaara7hayvancb);

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(OdaAra7.this,OdaAra6.class);
        startActivity(intent);
    }
}
