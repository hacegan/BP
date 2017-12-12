package samet.com.bp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.appyvet.materialrangebar.RangeBar;

/**
 * Created by root on 20.11.2017.
 */

public class OdaAra8 extends AppCompatActivity {

    Button btn,btndvm;
    Toolbar tb;
RangeBar rb;
    TextView tv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.odaiste8);
        btn= (Button) findViewById(R.id.geribtn);


        tb= (Toolbar) findViewById(R.id.supappbar);
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tv= (TextView) findViewById(R.id.kacyas);

        rb= (RangeBar) findViewById(R.id.odaiste8rb);

        rb.setOnRangeBarChangeListener(new RangeBar.OnRangeBarChangeListener() {
            @Override
            public void onRangeChangeListener(RangeBar rangeBar, int leftPinIndex, int rightPinIndex, String leftPinValue, String rightPinValue) {
                tv.setText(leftPinValue+"-"+rightPinValue);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OdaAra8.this,OdaAra7.class);
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
                Intent intent = new Intent(OdaAra8.this,OdaAra9.class);
                startActivity(intent);
            }
        });




    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(OdaAra8.this,OdaAra7.class);
        startActivity(intent);
    }
}
