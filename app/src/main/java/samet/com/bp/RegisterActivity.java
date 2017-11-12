package samet.com.bp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mailjet.client.ClientOptions;
import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.MailjetResponse;
import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;
import com.mailjet.client.resource.Emailv31;

import org.json.JSONArray;
import org.json.JSONObject;


public class RegisterActivity extends Activity {
EditText uname,pass,email,name;
    TextView kalanhak;
    Button kayitbuton;
    int kayitolabilirmi=0;
int denemehak=5;

    private static final String MAILJET_API_KEY = System.getenv("MAILJET_API_KEY");
    private static final String MAILJET_SECRET_KEY = System.getenv("MAILJET_SECRET_KEY");
    //private MailjetClient client = new MailjetClient(MAILJET_API_KEY, MAILJET_SECRET_KEY, new ClientOptions("v3.1"));

    String recipient = "";
    String sender = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        uname= (EditText) findViewById(R.id.kulad);
        pass= (EditText) findViewById(R.id.kulsifre);
        email= (EditText) findViewById(R.id.email);
        name= (EditText) findViewById(R.id.isim);
        kayitbuton= (Button) findViewById(R.id.kayitbuton);
        kalanhak= (TextView) findViewById(R.id.denemehaksayac);


        uname.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(uname.getText().length()==0){
                    uname.setError("Kullanıcı Adı Boş olamaz!");
                    kayitolabilirmi=-1;
                }

                if(uname.getText().length()<5){
                    uname.setError("Kullanıcı Adı 5 karakterden fazla olmalıdır!");
                    kayitolabilirmi=-1;
                }


            }
        });


pass.setOnFocusChangeListener(new View.OnFocusChangeListener() {
    @Override
    public void onFocusChange(View v, boolean hasFocus) {

        if(pass.getText().length()==0){
            pass.setError("Şifre  Boş olamaz!");
            kayitolabilirmi=-1;
        }

        if(pass.getText().length()<5){
            pass.setError("Şifre 5 karakterden fazla olmalıdır!");
            kayitolabilirmi=-1;
        }



    }
});


        email.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if(email.getText().length()==0){
                    email.setError("Email  Boş olamaz!");
                    kayitolabilirmi=-1;
                }

else if(    android.util.Patterns.EMAIL_ADDRESS.matcher(email.getText()).matches() !=true ){
                    email.setError("Email Standartına Uygun Değil!");
                    kayitolabilirmi=-1;
                }



            }
        });


        name.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if(name.getText().length()==0){
                    name.setError("İsim  Boş olamaz!");
                    kayitolabilirmi=-1;
                }

                if(name.getText().length()<5){
                    name.setError("İsim 5 karakterden fazla olmalıdır!");
                    kayitolabilirmi=-1;
                }



            }
        });


        kayitbuton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


if(kayitolabilirmi==-1){
    Toast.makeText(RegisterActivity.this,"Girilen Bilgiler Geçersiz!",Toast.LENGTH_SHORT);
/*denemehak--;
kalanhak.setText(String.valueOf(denemehak));
    if(denemehak==0)
        kayitbuton.setEnabled(false);*/
}



    else{

   // 65.19.141.67


}





            }
        });











    }
}
