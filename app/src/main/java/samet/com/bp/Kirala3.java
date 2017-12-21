package samet.com.bp;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.PermissionChecker;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import java.io.IOException;
import java.util.List;
import java.util.Locale;

import pugman.com.simplelocationgetter.SimpleLocationGetter;


/**
 * Created by root on 20.11.2017.
 */

public class Kirala3 extends AppCompatActivity  implements SimpleLocationGetter.OnLocationGetListener{

    private LocationManager locationManager;


    Button btn, btnevet, btnhayir;


    Toolbar tb;

    String cityName = "";

    static String address,adres;


    private static final int PERMISSIONS_REQUEST_LOCATION = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kirala3);
        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("MyPref", 0);
        final SharedPreferences.Editor editor = sharedPref.edit();

        tb = (Toolbar) findViewById(R.id.supappbar);
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);


        btnevet = (Button) findViewById(R.id.btnevet);
        btnhayir = (Button) findViewById(R.id.btnhayir);



        btn = (Button) findViewById(R.id.geribtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kirala3.this, Kirala2.class);
                startActivity(intent);
            }
        });


        btnevet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // getting GPS status
               boolean isGPSEnabled = locationManager
                        .isProviderEnabled(LocationManager.GPS_PROVIDER);


                if (!isGPSEnabled) {
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(Kirala3.this);

                    // Setting Dialog Title
                    alertDialog.setTitle("GPS settings");

                    // Setting Dialog Message
                    alertDialog.setMessage("GPS is not enabled. Do you want to go to settings menu?");

                    // On pressing Settings button
                    alertDialog.setPositiveButton("Settings", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                            startActivity(intent);
                        }
                    });

                    // on pressing cancel button
                    alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });

                    // Showing Alert Message
                    alertDialog.show();

                } else {
                    int hasCoarseLocationPermission = ActivityCompat.checkSelfPermission(Kirala3.this, Manifest.permission.ACCESS_COARSE_LOCATION);
                    int hasFineLocationPermission = ActivityCompat.checkSelfPermission(Kirala3.this, Manifest.permission.ACCESS_FINE_LOCATION);



                    if (hasCoarseLocationPermission != PackageManager.PERMISSION_GRANTED && hasFineLocationPermission != PackageManager.PERMISSION_GRANTED)
                    {
                        ActivityCompat.requestPermissions(Kirala3.this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSIONS_REQUEST_LOCATION);
                        // When called within fragment:
                        // requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSIONS_REQUEST_LOCATION);
                        return;
                    }

                    SimpleLocationGetter getter = new SimpleLocationGetter(Kirala3.this,Kirala3.this);
                    getter.getLastLocation();




                }



                /*SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("MyPref",0);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("oldxml","Kirala3.class");
                editor.commit();*/

             /*   Intent intent = new Intent(Kirala3.this,Kirala5.class);
                startActivity(intent);*/
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
        switch (requestCode)
        {
            case PERMISSIONS_REQUEST_LOCATION:
            {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    // permission was granted!
                    SimpleLocationGetter getter = new SimpleLocationGetter(Kirala3.this,Kirala3.this);
                    getter.getLastLocation();

                }
                else
                {
                    // permission denied! Disable the functionality that depends on this permission.
                }
                return;
            }
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Kirala3.this,Kirala2.class);
        startActivity(intent);
    }


    @Override
    public void onLocationReady(Location location) {

        Geocoder geocoder=new Geocoder(Kirala3.this);
        if(Geocoder.isPresent()){
            try {
             List<Address> addresses=   geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);
                Address address=  addresses.get(0);
                Log.d("LOCATION",address.getAdminArea()+" İli "+address.getSubAdminArea()+" İlcesi"+address.getThoroughfare()+" "+ address.getCountryName()+" Posta Kodu = "+address.getPostalCode());
                adres=address.getAdminArea()+" Ili "+address.getSubAdminArea()+" Ilcesi"+address.getThoroughfare()+" "+ address.getCountryName()+" Posta Kodu  "+address.getPostalCode();
                System.out.println("ONLOCATIONREADYDE = "+adres);

                SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("MyPref",0);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("adres",adres);
                editor.putString("kirala3adres",adres);
                editor.commit();
                Intent intent = new Intent(Kirala3.this,Kirala5.class);
                startActivity(intent);


            } catch (IOException e) {
                e.printStackTrace();
            }


        }



      //  Log.d("LOCATION", "onLocationReady: lat="+location.getLatitude() + " lon="+location.getLongitude());
    }

    @Override
    public void onError(String s) {
        Log.e("LOCATION", "Error: "+s);
    }

   /* @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
       // MultiDex.install(this);

    }*/
}
