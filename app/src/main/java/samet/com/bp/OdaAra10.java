package samet.com.bp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by root on 20.11.2017.
 */

public class OdaAra10 extends AppCompatActivity {

    Button btn,btndvm;
    Toolbar tb;
    EditText butce;
    SharedPreferences sharedPref ;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.odaiste10);

        sharedPref = getApplicationContext().getSharedPreferences("MyPref",0);
        editor = sharedPref.edit();

        btn= (Button) findViewById(R.id.geribtn);

        tb= (Toolbar) findViewById(R.id.supappbar);
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OdaAra10.this,OdaAra9.class);
                startActivity(intent);
            }
        });

        btndvm= (Button) findViewById(R.id.btndvm);
btndvm.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        editor.putString("odaara10butce", butce.getText().toString());
        editor.commit();
        Intent intent = new Intent(OdaAra10.this,OdaAra11.class);
        startActivity(intent);
    }
});

butce= (EditText) findViewById(R.id.odaara10butce);

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(OdaAra10.this,OdaAra9.class);
        startActivity(intent);
    }
}
