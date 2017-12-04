package samet.com.bp;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;
import java.util.Locale;


/**
 * Created by root on 20.11.2017.
 */

public class Kirala3 extends AppCompatActivity {
    Button btn, btnevet, btnhayir;
    LocationManager locationManager;
    LocationListener locationListener;
    double latitude,longitude;

    Toolbar tb;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kirala3);
        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("MyPref",0);
        final SharedPreferences.Editor editor = sharedPref.edit();

        tb= (Toolbar) findViewById(R.id.supappbar);
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnevet= (Button) findViewById(R.id.btnevet);
        btnhayir= (Button) findViewById(R.id.btnhayir);

         locationManager= (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);





         locationListener=new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                Log.i("My Location",location.toString());
               latitude= location.getLatitude();
                longitude=location.getLongitude();
                String strAdd = "";
                Geocoder geocoder = new Geocoder(Kirala3.this, Locale.getDefault());
                try {
                    List<Address> addresses = geocoder.getFromLocation(latitude, longitude, 1);
                    if (addresses != null) {
                        Address returnedAddress = addresses.get(0);
                        StringBuilder strReturnedAddress = new StringBuilder("");

                        for (int i = 0; i <= returnedAddress.getMaxAddressLineIndex(); i++) {
                            strReturnedAddress.append(returnedAddress.getAddressLine(i)).append("\n");
                        }
                        strAdd = strReturnedAddress.toString();
                        Log.w("My Current address", strReturnedAddress.toString());

                        editor.putString("locations",strReturnedAddress.toString());
                        editor.commit();
                    } else {
                        Log.w("My Current address", "No Address returned!");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.w("My Current address", "Canont get Address!");
                }




            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };


        if(ContextCompat.checkSelfPermission(Kirala3.this,Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(Kirala3.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);
        }

        else{
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,5000,50, locationListener);
        }

        btn= (Button) findViewById(R.id.geribtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kirala3.this,Kirala2.class);
                startActivity(intent);
            }
        });


        btnevet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("MyPref",0);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("oldxml","Kirala3.class");
                editor.commit();

                Intent intent = new Intent(Kirala3.this,Kirala5.class);
                startActivity(intent);
            }
        });


        btnhayir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("MyPref",0);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("oldxml","Kirala4.class");
                editor.commit();

                Intent intent = new Intent(Kirala3.this,Kirala4.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
        }

    }



    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Kirala3.this,Kirala2.class);
        startActivity(intent);
    }



/*   SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("MyPref",0);
SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("locations",addresses.get(0).getAddressLine(0)+addresses.get(0).getAddressLine(1)+addresses.get(0).getAddressLine(2));
            editor.commit();*/

}
