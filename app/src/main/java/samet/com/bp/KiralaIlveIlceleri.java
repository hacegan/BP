package samet.com.bp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;




/**
 * Created by root on 08.12.2017.
 */

public class KiralaIlveIlceleri extends AppCompatActivity implements View.OnClickListener{

    String hangisehir;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kiralailveilceleri);

        LinearLayout ll = (LinearLayout) findViewById(R.id.dyntvekle);
        ll.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));


        Bundle bundle = getIntent().getExtras();
        ArrayList<String> array = bundle.getStringArrayList("ilcelist");
        hangisehir=bundle.getString("hangisehir");

for(int i=0;i<array.size();i++){

    TextView tv=new TextView(this);

    tv.setText(     array.get(i) );
tv.setTextSize(35);
tv.setPadding(80,80,80,80);
    tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

    tv.setBackgroundResource(R.drawable.border_textview);

    tv.setOnClickListener(this);

ll.addView(tv);
}


    }

    @Override
    public void onClick(View v) {
        TextView t=(TextView) v;

        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("MyPref",0);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("kiralasecilenilce",((TextView) v).getText().toString());
        editor.putString("kiralasecilenil",hangisehir);
        editor.putString("kirala3adres",hangisehir+((TextView) v).getText().toString());
        editor.commit();


        Intent intent = new Intent(KiralaIlveIlceleri.this,Kirala5.class);
        startActivity(intent);
    }
}
