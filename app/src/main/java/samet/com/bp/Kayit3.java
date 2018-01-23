package samet.com.bp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by root on 04.11.2017.
 */

public class Kayit3 extends Activity {
    Button btn;
EditText kayitsifretxt;
    int kayitolabilirmi=1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kayit3);

        btn= (Button) findViewById(R.id.kayit3devambuton);
        kayitsifretxt= (EditText) findViewById(R.id.kayitsifretxt);


        final SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPref.edit();

        kayitsifretxt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if(kayitsifretxt.getText().length()==0){
                    kayitsifretxt.setError("Şifre  Boş olamaz!");
                    kayitolabilirmi=0;
                }

                if(kayitsifretxt.getText().length()<5){
                    kayitsifretxt.setError("Şifre 5 karakterden fazla olmalıdır!");
                    kayitolabilirmi=0;
                }

                if(kayitsifretxt.getText().length()>=5){
                    kayitolabilirmi=1;
                }



            }
        });



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kayitsifretxt.clearFocus();
                SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("MyPref", 0);
                SharedPreferences.Editor editor = sharedPref.edit();
                if(kayitolabilirmi==1){
                    editor.putString("sifre",kayitsifretxt.getText().toString());
                    editor.commit();
                    Intent intent=new Intent(Kayit3.this,Kayit4.class);
                    startActivity(intent);
                }


            }
        });


    }
}
