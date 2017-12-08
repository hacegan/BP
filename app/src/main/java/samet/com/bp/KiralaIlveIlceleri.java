package samet.com.bp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by root on 08.12.2017.
 */

public class KiralaIlveIlceleri extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kiralailveilceleri);

        LinearLayout ll = new LinearLayout(this);


        Bundle bundle = getIntent().getExtras();
        ArrayList<String> array = bundle.getStringArrayList("ilcelist");
for(int i=0;i<array.size();i++){

    TextView tv=new TextView(this);

    if(i%2==0)  tv.setText(     array.get(i) );
        if(i%2==1) tv.setText(     array.get(i) );

ll.addView(tv);
}


    }
}
