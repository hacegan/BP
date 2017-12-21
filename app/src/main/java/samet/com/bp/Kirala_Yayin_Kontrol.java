package samet.com.bp;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by root on 21.12.2017.
 */

public class Kirala_Yayin_Kontrol   extends Activity{
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    TextView textView;
ImageView imageView;
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
        //  System.out.println("kirala6resim = "+kirala6resim);

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


        //

        textView=findViewById(R.id.kirala_yayin_mulktur);
        String kirala_yayin_mulktur=textView.getText().toString();


        textView=findViewById(R.id.kirala_yayin_ilanverentur);
        String kirala_yayin_ilanverentur=textView.getText().toString();

        textView=findViewById(R.id.kirala_yayin_adres);
        String kirala_yayin_adres=textView.getText().toString();

        imageView=findViewById(R.id.kirala_yayin_resim);

        textView=findViewById(R.id.kirala_yayin_m2);
        String kirala_yayin_m2=textView.getText().toString();

        textView=findViewById(R.id.kirala_yayin_odasayi);
        String kirala_yayin_odasayi=textView.getText().toString();

        textView=findViewById(R.id.kirala_yayin_bkat);
        String kirala_yayin_bkat=textView.getText().toString();

        textView=findViewById(R.id.kirala_yayin_katsayi);
        String kirala_yayin_katsayi=textView.getText().toString();

        textView=findViewById(R.id.kirala_yayin_esyalimi);
        String kirala_yayin_esyalimi=textView.getText().toString();

        textView=findViewById(R.id.kirala_yayin_aidat);
        String kirala_yayin_aidat=textView.getText().toString();

        textView=findViewById(R.id.kirala_yayin_kira);
        String kirala_yayin_kira=textView.getText().toString();

        textView=findViewById(R.id.kirala_yayin_odauyguntarih);
        String kirala_yayin_odauyguntarih=textView.getText().toString();

        textView=findViewById(R.id.kirala_yayin_erkeksayi);
        String kirala_yayin_erkeksayi=textView.getText().toString();

        textView=findViewById(R.id.kirala_yayin_kizsayi);
        String kirala_yayin_kizsayi=textView.getText().toString();

        textView=findViewById(R.id.kirala_yayin_evcilvarmi);
        String kirala_yayin_evcilvarmi=textView.getText().toString();

        textView=findViewById(R.id.kirala_yayin_sigaravarmi);
        String kirala_yayin_sigaravarmi=textView.getText().toString();

        textView=findViewById(R.id.kirala_yayin_kimlelive);
        String kirala_yayin_kimlelive=textView.getText().toString();

        textView=findViewById(R.id.kirala_yayin_hangiyas);
        String kirala_yayin_hangiyas=textView.getText().toString();

        textView=findViewById(R.id.kirala_yayin_no);
        String kirala_yayin_no=textView.getText().toString();

        textView=findViewById(R.id.kirala_yayin_baslik);
        String kirala_yayin_baslik=textView.getText().toString();

        textView=findViewById(R.id.kirala_yayin_aciklama);
        String kirala_yayin_aciklama=textView.getText().toString();


    }
}
