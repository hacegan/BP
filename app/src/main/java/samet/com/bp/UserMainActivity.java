package samet.com.bp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class UserMainActivity extends AppCompatActivity {
TextView tv;
    String isim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main);

        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("MyPref", 0);
        SharedPreferences.Editor editor = sharedPref.edit();
        isim=sharedPref.getString("name",null);
        tv= (TextView) findViewById(R.id.userwbmsg);

        tv.setText(tv.getText().toString()+isim);

    }
}
