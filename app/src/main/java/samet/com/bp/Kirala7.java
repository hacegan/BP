package samet.com.bp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by root on 20.11.2017.
 */

public class Kirala7 extends AppCompatActivity {
    Button btn,odaeklebtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kirala7);
        btn= (Button) findViewById(R.id.geribtn);
        odaeklebtn= (Button) findViewById(R.id.odaeklebtn);




        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kirala7.this,Kirala6.class);
                startActivity(intent);
            }
        });


        odaeklebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Kirala7.this,Kirala6.class);
        startActivity(intent);
    }
}
