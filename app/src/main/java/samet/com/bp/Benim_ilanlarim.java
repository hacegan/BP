package samet.com.bp;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by root on 24.12.2017.
 */

public class Benim_ilanlarim extends Activity implements  View.OnClickListener{
LinearLayout ll;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.benimilanlarim);

ll=findViewById(R.id.benimilantv);
        ll.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

       new MyAd().execute();

    }

    @Override
    public void onClick(View v) {

    }


    public class MyAd extends  AsyncTask{


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Object o) {

        TextView tv=new TextView(Benim_ilanlarim.this);


       // tv.setText(     arrayplaka.get(i) );
        tv.setTextSize(35);
        tv.setPadding(80,80,80,80);
        tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        tv.setBackgroundResource(R.drawable.border_textview);

        tv.setOnClickListener(Benim_ilanlarim.this);

        ll.addView(tv);

    }

    @Override
    protected Object doInBackground(Object[] params) {
        return null;
    }
}


}
