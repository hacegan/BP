package samet.com.bp;

import android.Manifest;
import android.app.AlertDialog;
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
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;


/**
 * Created by root on 20.11.2017.
 */

public class Kirala3 extends AppCompatActivity implements LocationListener {

    private LocationManager locationManager;


    Button btn, btnevet, btnhayir;


    Toolbar tb;

    String cityName = "";

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
                    if (locationManager != null) {


                        if (ActivityCompat.checkSelfPermission(Kirala3.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(Kirala3.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                            // TODO: Consider calling
                            //    ActivityCompat#requestPermissions
                            // here to request the missing permissions, and then overriding
                            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                            //                                          int[] grantResults)
                            // to handle the case where the user grants the permission. See the documentation
                            // for ActivityCompat#requestPermissions for more details.
                            return;
                        }
                        Location location = locationManager
                                .getLastKnownLocation(LocationManager.GPS_PROVIDER);
                        if (location != null) {
                            double latitude = location.getLatitude();
                            double longitude = location.getLongitude();
                            Toast.makeText(getApplication(),"latitude: "+ latitude +" longitude: "+longitude, Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(Kirala3.this,Kirala5.class);
                            startActivity(intent);
                        }
                    }
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
    public void onBackPressed() {
        Intent intent = new Intent(Kirala3.this,Kirala2.class);
        startActivity(intent);
    }


    @Override
    public void onLocationChanged(Location location) {


    }


    @Override
    public void onProviderDisabled(String provider) {
        // TODO Auto-generated method stub
        Toast.makeText(getBaseContext(), "Gps turned off ", Toast.LENGTH_LONG).show();
    }


    @Override
    public void onProviderEnabled(String provider) {
        // TODO Auto-generated method stub
        Toast.makeText(getBaseContext(), "Gps turned on ", Toast.LENGTH_LONG).show();
    }


    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        // TODO Auto-generated method stub

    }


}
