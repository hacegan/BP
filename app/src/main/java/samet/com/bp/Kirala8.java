package samet.com.bp;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by root on 20.11.2017.
 */

public class Kirala8 extends AppCompatActivity {
    Button btn,btndvm;
TextView tv;
    CheckBox evet;
    CheckBox hayir;
    static String tarih;
    private DatePickerDialog.OnDateSetListener onDateSetListener;

    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kirala8);
        btn= (Button) findViewById(R.id.geribtn);

        tv= (TextView) findViewById(R.id.DisplayDatetv);

        //evet= (CheckBox) findViewById(R.id.kirala8evetcb);
      //  hayir= (CheckBox) findViewById(R.id.kirala8hayircb);

        sharedPref = getApplicationContext().getSharedPreferences("MyPref",0);
        editor=sharedPref.edit();


        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal= Calendar.getInstance();
                int year=cal.get(Calendar.YEAR);
                int month=cal.get(Calendar.MONTH);
                int day=cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog=new DatePickerDialog(Kirala8.this,android.R.style.Theme_Holo_Light_Dialog_MinWidth,onDateSetListener,year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                dialog.show();

            }
        });



        onDateSetListener=new DatePickerDialog.OnDateSetListener(){

            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                tv.setText(dayOfMonth+"/"+month+"/"+year+"'itibaren");
                tarih=""+dayOfMonth+month+year;
            }
        };



btndvm= (Button) findViewById(R.id.btndvm);

        btndvm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("kirala8tarih",tarih);
                editor.commit();
                Intent intent = new Intent(Kirala8.this,Kirala9.class);
                startActivity(intent);
            }
        });







        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kirala8.this,Kirala7.class);
                startActivity(intent);
            }
        });






    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Kirala8.this,Kirala7.class);
        startActivity(intent);
    }
}
