package samet.com.bp;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.database.DatabaseReference;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * Created by root on 11.02.2018.
 */

public class Benim_Mesajlarim extends AppCompatActivity {

    DatabaseReference rootRef,demoRef;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mesajlarim);

        new Mesaj_Users().execute();
    }


    public class Mesaj_Users extends AsyncTask{


        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
        }

        @Override
        protected Object doInBackground(Object[] params) {


            String fire_url = "https://bitirme-proje-1511471101877.firebaseio.com/messages.json";




            return null;
        }
    }



}
