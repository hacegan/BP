package samet.com.bp;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by root on 25.12.2017.
 */

public class Ara_Yayin_Kontrol   extends Activity{
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    TextView textView;
    ImageView imageView;
    String encodedImage;
    Button btn;
NotificationCompat.Builder noBuilder;
private static final int uniqueID=45612;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ara_yayin_kontrol);

        sharedPref = getApplicationContext().getSharedPreferences("MyPref",0);
        editor = sharedPref.edit();

        String odaara1bay=sharedPref.getString("odaara1bay",null);
        System.out.println("odaara1bay ="+odaara1bay);

        String odaara2resim=sharedPref.getString("odaara2resim",null);
        //System.out.println("odaara2resim = "+odaara2resim);

        String odaara3yas=sharedPref.getString("odaara3yas",null);
        System.out.println("odaara3yas = "+odaara3yas);

        String odaara4meslek=sharedPref.getString("odaara4meslek",null);
        System.out.println("odaara4meslek = "+odaara4meslek);

        String odaara5evet=sharedPref.getString("odaara5evet",null);
        System.out.println("odaara5evet = "+odaara5evet);

        String odaara6evet=sharedPref.getString("odaara6evet",null);
        System.out.println("odaara6evet = "+odaara6evet);

        String odaara8tv =sharedPref.getString("odaara8tv",null);
        System.out.println("odaara8tv = "+odaara8tv);

        String odaarahangiil=sharedPref.getString("odaarahangiil",null);
        System.out.println("odaarahangiil = "+odaarahangiil);

        String odaarahangiilce=sharedPref.getString("odaarahangiilce",null);
        System.out.println("odaarahangiilce = "+odaarahangiilce);

        String odaara10butce=sharedPref.getString("odaara10butce",null);
        System.out.println("odaara10butce = "+odaara10butce);

        String odaara11tarih=sharedPref.getString("odaara11tarih",null);
        System.out.println("odaara11tarih = "+odaara11tarih);

        String odaara12sure=sharedPref.getString("odaara12sure",null);
        System.out.println("odaara12sure = "+odaara12sure);

        String odaara13numara=sharedPref.getString("odaara13numara",null);
        System.out.println("odaara13numara = "+odaara13numara);

        String odaara14baslik=sharedPref.getString("odaara14baslik",null);

        String odaara14aciklama=sharedPref.getString("odaara14aciklama",null);


        //

        textView=findViewById(R.id.ara_yayin_arayan);
        String ara_yayin_arayan=textView.getText().toString();
        textView.setText(ara_yayin_arayan+" "+odaara1bay);


        imageView=findViewById(R.id.ara_yayin_resim);

        if (!odaara2resim.equalsIgnoreCase("")) {
            //Decoding the Image and display in ImageView
            byte[] b = Base64.decode(odaara2resim, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(b, 0, b.length);
            imageView.setImageBitmap(bitmap);
        }
        else
        {
            Toast.makeText(getApplicationContext(),"You don't have Image in SharedPreferences!", Toast.LENGTH_SHORT).show();
        }

        textView=findViewById(R.id.ara_yayin_yas);
        String ara_yayin_yas=textView.getText().toString();
        textView.setText(ara_yayin_yas+" "+odaara3yas);


        textView=findViewById(R.id.ara_yayin_meslek);
        String ara_yayin_meslek=textView.getText().toString();
        textView.setText(ara_yayin_meslek+" "+odaara4meslek);

        textView=findViewById(R.id.ara_yayin_evcilvarmi);
        String ara_yayin_evcilvarmi=textView.getText().toString();
        textView.setText(ara_yayin_evcilvarmi+" "+odaara5evet);

        textView=findViewById(R.id.ara_yayin_sigaravarmi);
        String ara_yayin_sigaravarmi=textView.getText().toString();
        textView.setText(ara_yayin_sigaravarmi+" "+odaara6evet);

        textView=findViewById(R.id.ara_yayin_yasaralik);
        String ara_yayin_yasaralik=textView.getText().toString();
        textView.setText(ara_yayin_yasaralik+" "+odaara8tv);

        textView=findViewById(R.id.ara_yayin_neredelive);
        String ara_yayin_neredelive=textView.getText().toString();
        textView.setText(ara_yayin_neredelive+" "+odaarahangiil);

        textView=findViewById(R.id.ara_yayin_butce);
        String ara_yayin_butce=textView.getText().toString();
        textView.setText(ara_yayin_butce+" "+odaarahangiilce);

        textView=findViewById(R.id.ara_yayin_hazirtarih);
        String ara_yayin_hazirtarih=textView.getText().toString();
        textView.setText(ara_yayin_hazirtarih+" "+odaara10butce);

        textView=findViewById(R.id.ara_yayin_konaksure);
        String ara_yayin_konaksure=textView.getText().toString();
        textView.setText(ara_yayin_konaksure+" "+odaara11tarih);

        textView=findViewById(R.id.ara_yayin_telefonno);
        String ara_yayin_telefonno=textView.getText().toString();
        textView.setText(ara_yayin_telefonno+" "+odaara12sure);

        textView=findViewById(R.id.ara_yayin_ilanbaslik);
        String ara_yayin_ilanbaslik=textView.getText().toString();
        textView.setText(ara_yayin_ilanbaslik+" "+odaara13numara);

        textView=findViewById(R.id.ara_yayin_ilanaciklama);
        String ara_yayin_ilanaciklama=textView.getText().toString();
        textView.setText(ara_yayin_ilanaciklama+" "+odaara13numara);


        btn=findViewById(R.id.ara_yayin_onaybuton);


        noBuilder=new  NotificationCompat.Builder(this);
        noBuilder.setAutoCancel(true);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
noBuilder.setSmallIcon(R.drawable.ic_launcher);
                noBuilder.setTicker("Yeni Bir Ara Ilanı eklendi");
                noBuilder.setWhen(System.currentTimeMillis());
                noBuilder.setContentTitle("YENI ILAN");
                noBuilder.setContentText("Yeni Bir Ilan Eklendi");
                Intent intent=new Intent(Ara_Yayin_Kontrol.this,Ara_Yayin_Kontrol.class);
                PendingIntent pendingIntent=PendingIntent.getActivity(Ara_Yayin_Kontrol.this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                noBuilder.setContentIntent(pendingIntent);

                NotificationManager notificationManager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(uniqueID,noBuilder.build());

                 intent = new Intent(Ara_Yayin_Kontrol.this,UserMainActivity.class);
                startActivity(intent);
            }
        });



    }




}
