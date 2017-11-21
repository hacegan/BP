package samet.com.bp;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by root on 20.11.2017.
 */

public class Kirala3  extends AppCompatActivity implements LocationListener{
    Button btn,btnevet,btnhayir;
    private LocationManager locationManager;
    private double longtitude;
    private double latitude;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kirala3);




        btnevet= (Button) findViewById(R.id.btnevet);
        btnhayir= (Button) findViewById(R.id.btnhayir);


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

                locationManager= (LocationManager) getSystemService(Context.LOCATION_SERVICE);


                if(ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED
                        && ActivityCompat.checkSelfPermission(getApplicationContext(),Manifest.permission.ACCESS_COARSE_LOCATION)!=PackageManager.PERMISSION_GRANTED){

                }

Location location=locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

 onLocationChanged(location);

                Intent intent = new Intent(Kirala3.this,Kirala4.class);
                startActivity(intent);
            }
        });


        btnhayir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kirala3.this,Kirala4.class);
                startActivity(intent);
            }
        });



    }

    public void onLocationChanged(Location location){
longtitude=location.getLongitude();
        latitude=location.getLatitude();

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


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Kirala3.this,Kirala2.class);
        startActivity(intent);
    }






}
