package samet.com.bp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

/**
 * Created by root on 20.11.2017.
 */

public class OdaAra11  extends AppCompatActivity {

    Button btn,btndvm;
    Toolbar tb;
    SharedPreferences sharedPref ;
    SharedPreferences.Editor editor;
    CalendarView cv;
    String tarih;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.odaiste11);
        btn= (Button) findViewById(R.id.geribtn);

        tb= (Toolbar) findViewById(R.id.supappbar);
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sharedPref = getApplicationContext().getSharedPreferences("MyPref",0);
        editor = sharedPref.edit();

        cv= (CalendarView) findViewById(R.id.odaara11cv);


        cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                tarih=""+dayOfMonth+month+year;
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OdaAra11.this,OdaAra10.class);
                startActivity(intent);
            }
        });

        btndvm= (Button) findViewById(R.id.btndvm);
        btndvm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("odaara11tarih", tarih);
                editor.commit();
                Intent intent = new Intent(OdaAra11.this,OdaAra12.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(OdaAra11.this,OdaAra10.class);
        startActivity(intent);
    }
}
