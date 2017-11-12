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

public class Kayit2 extends Activity {
    Button btn;
EditText kayitepostatxt;
    int kayitolabilirmi=1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kayit2);

        btn=findViewById(R.id.kayit2devambuton);
        kayitepostatxt=findViewById(R.id.kayitepostatxt);



        kayitepostatxt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if(kayitepostatxt.getText().length()==0){
                    kayitepostatxt.setError("Email  Boş olamaz!");
                    kayitolabilirmi=0;
                }

                 if(    android.util.Patterns.EMAIL_ADDRESS.matcher(kayitepostatxt.getText()).matches() !=true ){
                    kayitepostatxt.setError("Email Standartına Uygun Değil!");
                    kayitolabilirmi=0;
                }
                if(    android.util.Patterns.EMAIL_ADDRESS.matcher(kayitepostatxt.getText()).matches() ==true ){
                    kayitolabilirmi=1;
                }


            }
        });




        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kayitepostatxt.clearFocus();
                SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("MyPref", 0);
                SharedPreferences.Editor editor = sharedPref.edit();
                if(kayitolabilirmi==1){
                    editor.putString("email",kayitepostatxt.getText().toString());
                    editor.commit();
                    Intent intent=new Intent(Kayit2.this,Kayit3.class);
                    startActivity(intent);
                }




            }
        });


    }
}
