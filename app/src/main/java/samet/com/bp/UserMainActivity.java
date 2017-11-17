package samet.com.bp;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UserMainActivity extends AppCompatActivity   implements NavigationView.OnNavigationItemSelectedListener {
TextView tv;
    String isim;
    String email;
    String server_url="http://192.168.1.33/getname.php";


    @Override
    public void onBackPressed() {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            //super.onBackPressed();
        }


        AlertDialog.Builder alertDialog = new AlertDialog.Builder(UserMainActivity.this);


        // Setting Dialog Title

        alertDialog.setTitle("Uygulumadan ayrılıyor musun?");

        // Setting Dialog Message

        alertDialog.setMessage("Uygulamadan ayrılmak istiyor musunuz?");

        // Setting Icon to Dialog

      //  alertDialog.setIcon(R.layout.);

        // Setting Positive "Yes" Button

        alertDialog.setPositiveButton("EVET",

        new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {

             finishAffinity();

            }

        });

        // Setting Negative "NO" Button

        alertDialog.setNegativeButton("HAYIR",

        new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {

                // Write your code here to invoke NO event

                dialog.cancel();

            }

        });

        // Showing Alert Message

        alertDialog.show();




        return ;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



       SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("MyPref", 0);
        SharedPreferences.Editor editor = sharedPref.edit();
        email=sharedPref.getString("email",null);

        server_url="http://192.168.1.33/getname.php";


        server_url+="?Email="+email;
        System.out.println(server_url);
       new GetNameTask().execute();


    }



    public class GetNameTask extends AsyncTask{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Object o) {
            //super.onPostExecute(o);
            tv= (TextView) findViewById(R.id.userwbmsg);

            tv.setText(tv.getText().toString()+isim);


        }

        @Override
        protected Object doInBackground(Object[] params) {
            try{
                URL url=new URL(server_url);
                HttpURLConnection con= (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.connect();

                BufferedReader bf=new BufferedReader(new InputStreamReader(con.getInputStream()));
                isim=bf.readLine();
                System.out.println(isim);



            }
            catch (Exception e){
                System.out.println(e);

            }

            return null;
        }
    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.sol_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }




}
