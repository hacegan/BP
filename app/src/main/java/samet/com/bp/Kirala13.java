package samet.com.bp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.appyvet.materialrangebar.RangeBar;

/**
 * Created by root on 20.11.2017.
 */

public class Kirala13 extends AppCompatActivity {
    Button btn,btndvm;
    Toolbar tb;
    RangeBar rb;
    TextView tv;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kirala13);
        btn= (Button) findViewById(R.id.geribtn);

        tb= (Toolbar) findViewById(R.id.supappbar);
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        sharedPref = getApplicationContext().getSharedPreferences("MyPref",0);
        editor = sharedPref.edit();

        rb= (RangeBar) findViewById(R.id.kirala13rb);
        tv= (TextView) findViewById(R.id.kirala13tv);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kirala13.this,Kirala12.class);
                startActivity(intent);
            }
        });


        rb.setOnRangeBarChangeListener(new RangeBar.OnRangeBarChangeListener() {
            @Override
            public void onRangeChangeListener(RangeBar rangeBar, int leftPinIndex, int rightPinIndex, String leftPinValue, String rightPinValue) {
tv.setText(leftPinValue+"-"+rightPinValue);
            }
        });

        btndvm= (Button) findViewById(R.id.btndvm);
        btndvm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("kirala13yas",tv.getText().toString());
                editor.commit();
                Intent intent = new Intent(Kirala13.this,Kirala14.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Kirala13.this,Kirala12.class);
        startActivity(intent);
    }
}
