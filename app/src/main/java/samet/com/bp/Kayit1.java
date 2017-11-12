package samet.com.bp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by root on 03.11.2017.
 */

public class Kayit1 extends Activity{
     int kayitolabilirmi=1;
    Button btn;
    EditText name;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kayit1);

        name= (EditText) findViewById(R.id.kayitadsoyadtxt);
        btn=findViewById(R.id.kayit1devambuton);








        name.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if(hasFocus && name.getText().length()==0){
                    name.setError("İsim  Boş olamaz!");
                    kayitolabilirmi=0;
                }

                if(hasFocus && name.getText().length()<5){
                    name.setError("İsim 5 karakterden fazla olmalıdır!");
                    kayitolabilirmi=0;
                }

                if(hasFocus && name.getText().length()>=5){
                    kayitolabilirmi=1;
                }



            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
name.clearFocus();
                SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("MyPref",0);
                SharedPreferences.Editor editor = sharedPref.edit();

                if(kayitolabilirmi==1){
                    editor.putString("name",name.getText().toString());
                    editor.commit();
                    Intent intent = new Intent(Kayit1.this, Kayit2.class);
                    startActivity(intent);
                }





                }


            });
        }

    }




