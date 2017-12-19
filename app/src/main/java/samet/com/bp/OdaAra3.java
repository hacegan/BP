package samet.com.bp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by root on 20.11.2017.
 */

public class OdaAra3 extends AppCompatActivity {

    Button btn,btndvm;
    SeekBar sb;
    TextView tv;
    Toolbar tb;
    SharedPreferences sharedPref ;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.odaiste3);
        btn= (Button) findViewById(R.id.geribtn);


        tb= (Toolbar) findViewById(R.id.supappbar);
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sharedPref = getApplicationContext().getSharedPreferences("MyPref",0);
        editor = sharedPref.edit();


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OdaAra3.this,OdaAra2.class);
                startActivity(intent);
            }
        });

        tv= (TextView) findViewById(R.id.kacyas);

        btndvm= (Button) findViewById(R.id.btndvm);

        btndvm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("odaara3yas",tv.getText().toString());
                editor.commit();
                Intent intent = new Intent(OdaAra3.this,OdaAra4.class);
                startActivity(intent);
            }
        });


        sb= (SeekBar) findViewById(R.id.sb);

    sb.setMax(17);

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

tv.setText("" +(progress+18) );
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(OdaAra3.this,OdaAra2.class);
        startActivity(intent);
    }
}
