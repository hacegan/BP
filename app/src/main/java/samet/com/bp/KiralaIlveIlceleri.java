package samet.com.bp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.ViewGroup;
import android.widget.FrameLayout;
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

        LinearLayout ll = (LinearLayout) findViewById(R.id.dyntvekle);
        ll.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));


        Bundle bundle = getIntent().getExtras();
        ArrayList<String> array = bundle.getStringArrayList("ilcelist");
for(int i=0;i<array.size();i++){

    TextView tv=new TextView(this);

    tv.setText(     array.get(i) );
tv.setTextSize(10);


ll.addView(tv);
}


    }
}
