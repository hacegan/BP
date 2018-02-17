package samet.com.bp;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by root on 21.12.2017.
 */

public class Kirala_Yayin_Kontrol   extends Activity{
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
        setContentView(R.layout.kirala_yayin_kontrol);

        sharedPref = getApplicationContext().getSharedPreferences("MyPref",0);
        editor = sharedPref.edit();

        String kirala1mulktur=sharedPref.getString("kirala1mulktur",null);
        System.out.println("kirala1mulktur = "+kirala1mulktur);

        String kirala2ilanveren=sharedPref.getString("kirala2ilanveren",null);
        System.out.println("kirala2ilanveren = "+kirala2ilanveren);

        String kirala3adres=sharedPref.getString("kirala3adres",null);
        kirala3adres= kirala3adres.replaceAll("\\s+","");
        System.out.println("kirala3adres = "+kirala3adres);

        String kiralasecilenil=sharedPref.getString("kiralasecilenil",null);
        System.out.println("kiralasecilenil = "+kiralasecilenil);

        String kiralasecilenilce=sharedPref.getString("kiralasecilenilce",null);
        System.out.println("kiralasecilenilce = "+kiralasecilenilce);

     String   kirala6resim=sharedPref.getString("kirala6resim",null);
         // System.out.println("kirala6resim = "+kirala6resim);

        String kirala7m2=sharedPref.getString("kirala7m2",null);
        System.out.println("kirala7m2 = "+kirala7m2);

        String kirala7oda=sharedPref.getString("kirala7oda",null);
        System.out.println("kirala7oda = "+kirala7oda);

        String kirala7kat=sharedPref.getString("kirala7kat",null);
        System.out.println("kirala7kat = "+kirala7kat);

        String kirala7bkat=sharedPref.getString("kirala7bkat",null);
        System.out.println("kirala7bkat = "+kirala7bkat);

        String kirala7aidat=sharedPref.getString("kirala7aidat",null);
        System.out.println("kirala7aidat = "+kirala7aidat);

        String kirala7kira=sharedPref.getString("kirala7kira",null);
        System.out.println("kirala7kira = "+kirala7kira);

        String kirala7esya=sharedPref.getString("kirala7esya",null);
        System.out.println("kirala7esya = "+kirala7esya);

        String kirala8tarih=sharedPref.getString("kirala8tarih",null);
        System.out.println("kirala8tarih = "+kirala8tarih);

        String kirala9kizsayi=sharedPref.getString("kirala9kizsayi",null);
        System.out.println("kirala9kizsayi = "+kirala9kizsayi);

        String kirala9erkeksayi=sharedPref.getString("kirala9erkeksayi",null);
        System.out.println("kirala9erkeksayi = "+kirala9erkeksayi);

        String kirala10var=sharedPref.getString("kirala10var",null);
        System.out.println("kirala10var = "+kirala10var);

        String kirala11evet=sharedPref.getString("kirala11evet",null);
        System.out.println("kirala11evet = "+ kirala11evet);

        String kirala12erkek=sharedPref.getString("kirala12erkek",null);
        System.out.println("kirala12erkek = "+ kirala12erkek);

        String kirala12kiz=sharedPref.getString("kirala12kiz",null);
        System.out.println("kirala12kiz = "+kirala12kiz);

        String kirala12ogr=sharedPref.getString("kirala12ogr",null);
        System.out.println("kirala12ogr = "+kirala12ogr);

        String kirala12clsn=sharedPref.getString("kirala12clsn",null);
        System.out.println("kirala12clsn = "+ kirala12clsn);

        String kirala12sgr=sharedPref.getString("kirala12sgr",null);
        System.out.println("kirala12sgr = "+kirala12sgr);

        String kirala12hyvn=sharedPref.getString("kirala12hyvn",null);
        System.out.println("kirala12hyvn = "+kirala12hyvn);

        String kirala13yas=sharedPref.getString("kirala13yas",null);
        System.out.println("kirala13yas = "+kirala13yas);

        String  kirala14numara=sharedPref.getString("kirala14numara",null);
        System.out.println("kirala14numara = "+kirala14numara);


        String kirala15baslik=sharedPref.getString("kirala15baslik",null);

        String kirala15aciklama=sharedPref.getString("kirala15aciklama",null);


        //

        textView= (TextView) findViewById(R.id.kirala_yayin_mulktur);
        String kirala_yayin_mulktur=textView.getText().toString();
        textView.setText(kirala_yayin_mulktur+" "+kirala1mulktur);


        textView= (TextView) findViewById(R.id.kirala_yayin_ilanverentur);
        String kirala_yayin_ilanverentur=textView.getText().toString();
        textView.setText(kirala_yayin_ilanverentur+" "+kirala2ilanveren);

        textView= (TextView) findViewById(R.id.kirala_yayin_adres);
        String kirala_yayin_adres=textView.getText().toString();
        textView.setText(kirala_yayin_adres+" "+kirala3adres);

        imageView= (ImageView) findViewById(R.id.kirala_yayin_resim);

        if (!kirala6resim.equalsIgnoreCase("")) {
            //Decoding the Image and display in ImageView
            byte[] b = Base64.decode(kirala6resim, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(b,0,b.length);
            imageView.setImageBitmap(bitmap);
        }
        else
        {
            Toast.makeText(getApplicationContext(),"You don't have Image in SharedPreferences!", Toast.LENGTH_SHORT).show();
        }



        textView= (TextView) findViewById(R.id.kirala_yayin_m2);
        String kirala_yayin_m2=textView.getText().toString();
        textView.setText(kirala_yayin_m2+" "+kirala7m2);

        textView= (TextView) findViewById(R.id.kirala_yayin_odasayi);
        String kirala_yayin_odasayi=textView.getText().toString();
        textView.setText(kirala_yayin_odasayi+" "+kirala7oda);

        textView= (TextView) findViewById(R.id.kirala_yayin_bkat);
        String kirala_yayin_bkat=textView.getText().toString();
        textView.setText(kirala_yayin_bkat+" "+kirala7bkat);

        textView= (TextView) findViewById(R.id.kirala_yayin_katsayi);
        String kirala_yayin_katsayi=textView.getText().toString();
        textView.setText(kirala_yayin_katsayi+" "+kirala7kat);


        textView= (TextView) findViewById(R.id.kirala_yayin_esyalimi);
        String kirala_yayin_esyalimi=textView.getText().toString();
        textView.setText(kirala_yayin_esyalimi+" "+kirala7esya);

        textView= (TextView) findViewById(R.id.kirala_yayin_aidat);
        String kirala_yayin_aidat=textView.getText().toString();
        textView.setText(kirala_yayin_aidat+" "+kirala7aidat);

        textView= (TextView) findViewById(R.id.kirala_yayin_kira);
        String kirala_yayin_kira=textView.getText().toString();
        textView.setText(kirala_yayin_kira+" "+kirala7kira);

        textView= (TextView) findViewById(R.id.kirala_yayin_odauyguntarih);
        String kirala_yayin_odauyguntarih=textView.getText().toString();
        textView.setText(kirala_yayin_odauyguntarih+" "+kirala8tarih);

        textView= (TextView) findViewById(R.id.kirala_yayin_erkeksayi);
        String kirala_yayin_erkeksayi=textView.getText().toString();
        textView.setText(kirala_yayin_erkeksayi+" "+kirala9erkeksayi);

        textView= (TextView) findViewById(R.id.kirala_yayin_kizsayi);
        String kirala_yayin_kizsayi=textView.getText().toString();
        textView.setText(kirala_yayin_kizsayi+" "+kirala9kizsayi);

        textView= (TextView) findViewById(R.id.kirala_yayin_evcilvarmi);
        String kirala_yayin_evcilvarmi=textView.getText().toString();
        textView.setText(kirala_yayin_evcilvarmi+" "+kirala10var);

        textView= (TextView) findViewById(R.id.kirala_yayin_sigaravarmi);
        String kirala_yayin_sigaravarmi=textView.getText().toString();
        textView.setText(kirala_yayin_sigaravarmi+" "+kirala11evet);

        textView= (TextView) findViewById(R.id.kirala_yayin_kimlelive);
        String kirala_yayin_kimlelive=textView.getText().toString();
       // textView.setText(kirala_yayin_kimlelive+" kirala1mulktur");

        textView= (TextView) findViewById(R.id.kirala_yayin_hangiyas);
        String kirala_yayin_hangiyas=textView.getText().toString();
        textView.setText(kirala_yayin_hangiyas+" "+kirala13yas);

        textView= (TextView) findViewById(R.id.kirala_yayin_no);
        String kirala_yayin_no=textView.getText().toString();
        textView.setText(kirala_yayin_no+" "+kirala14numara);

        textView= (TextView) findViewById(R.id.kirala_yayin_baslik);
        String kirala_yayin_baslik=textView.getText().toString();
        textView.setText(kirala_yayin_baslik+" " + kirala15baslik);

        textView= (TextView) findViewById(R.id.kirala_yayin_aciklama);
        String kirala_yayin_aciklama=textView.getText().toString();
        textView.setText(kirala_yayin_aciklama+" "+kirala15aciklama);


        btn= (Button) findViewById(R.id.kirala_yayin_onaybuton);

        noBuilder=new  NotificationCompat.Builder(this);
        noBuilder.setAutoCancel(true);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                noBuilder.setSmallIcon(R.drawable.ic_launcher);
                noBuilder.setTicker("Yeni Bir Kirala Ilanı eklendi");
                noBuilder.setWhen(System.currentTimeMillis());
                noBuilder.setContentTitle("YENI ILAN");
                noBuilder.setContentText("Yeni Bir Ilan Eklendi");
                Intent intent=new Intent(Kirala_Yayin_Kontrol.this,Kirala_Yayin_Kontrol.class);
                PendingIntent pendingIntent=PendingIntent.getActivity(Kirala_Yayin_Kontrol.this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                noBuilder.setContentIntent(pendingIntent);

                NotificationManager notificationManager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(uniqueID,noBuilder.build());

                 intent = new Intent(Kirala_Yayin_Kontrol.this,UserMainActivity.class);
                startActivity(intent);
            }
        });


    }
}
