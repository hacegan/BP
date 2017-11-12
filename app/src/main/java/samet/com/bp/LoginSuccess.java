package samet.com.bp;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

/**
 * Created by root on 06.11.2017.
 */

public class LoginSuccess extends Activity{
TextView tv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registered_main);
tv=(TextView) findViewById(R.id.wlcmregisteredtxt);
      /*  Bundle bundle=getIntent().getExtras();
        tv.setText("Hosgeldin " + bundle.getString("name"));*/


    }
}
