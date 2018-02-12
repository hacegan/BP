package samet.com.bp;

import android.app.Activity;
import android.app.Application;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import com.firebase.client.GenericTypeIndicator;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;

import static samet.com.bp.Message_Details.chatWithList;


/**
 * Created by root on 11.02.2018.
 */

public class Benim_Mesajlarim extends Activity implements  View.OnClickListener,Application.ActivityLifecycleCallbacks{

    DatabaseReference rootRef, demoRef;

    static String hedef_kisi;
    static SharedPreferences sharedPref;
    static SharedPreferences.Editor editor;

    static String kaynak_kisi;

    static int bakmaona = 0;

   static LinearLayout ll;

   static com.firebase.client.ValueEventListener valueEventListener;

   static Firebase reference;
    @Override
    protected void onResume() {
        super.onResume();
      //  ll= (LinearLayout) findViewById(R.id.benimmesajll);
        chatWithList.clear();
        //ll.removeAllViews();

//reference.removeEventListener(valueEventListener);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mesajlarim);
        sharedPref = getApplicationContext().getSharedPreferences("MyPref", 0);
        editor = sharedPref.edit();
        kaynak_kisi = sharedPref.getString("email", "");

            ll= (LinearLayout) findViewById(R.id.benimmesajll);

                ll.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

      //  new Mesaj_Users().execute();
        chatWithList.clear();
        //ll.removeAllViews();

        Firebase.setAndroidContext(this);
         reference = new Firebase("https://bitirme-proje-1511471101877.firebaseio.com/messages");

/*        reference.addValueEventListener(valueEventListener);

  valueEventListener=new com.firebase.client.ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot childDataSnapshot : dataSnapshot.getChildren()) {

                    System.out.println("1 = " + childDataSnapshot.getKey());//Bu emailleri alıyor sorunsuz
                    // System.out.println(childDataSnapshot.child("user").getValue());

                    String kimlekimarasinda = childDataSnapshot.getKey();
                    StringTokenizer token = new StringTokenizer(kimlekimarasinda, "_");

                    int i = 0;
                    while (token.hasMoreTokens()) {

                        String temp = token.nextToken();

                        if (i == 0 && !kaynak_kisi.replace(".", ",").equals(temp)) {
                            bakmaona = -1;
                            break;


                        }

                        if (i == 1) {
                            hedef_kisi = temp;
                            if(!chatWithList.contains(temp))
                                chatWithList.add(temp);

                        }
                        i++;
                    }

                    if (bakmaona == -1) {
                        bakmaona = 0;
                        continue;
                    }


                    for (DataSnapshot childDataSnapshot2 : childDataSnapshot.getChildren()) {
                        System.out.println("2 = " + childDataSnapshot2.getKey());

                        for (DataSnapshot childDataSnapshot3 : childDataSnapshot2.getChildren()) {
                            System.out.println("3 = " + childDataSnapshot3.getKey());
                            System.out.println("Mesaj = " + childDataSnapshot3.getValue());
                        }

                    }


                }



                for (int i = 0; i < chatWithList.size(); i++) {
                    TextView tv = new TextView(Benim_Mesajlarim.this);
                    tv.setText(chatWithList.get(i));
                    tv.setTextSize(35);
                    tv.setPadding(80, 80, 80, 80);
                    tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                    tv.setTextAppearance(android.R.attr.textAppearanceLarge);
                    tv.setOnClickListener(Benim_Mesajlarim.this);
                    tv.setTag(chatWithList.get(i));
                    ll.addView(tv);
                }





            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        };*/

        reference.addValueEventListener(new com.firebase.client.ValueEventListener() {
            @Override
            public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {
                for (DataSnapshot childDataSnapshot : dataSnapshot.getChildren()) {

                    System.out.println("1 = " + childDataSnapshot.getKey());//Bu emailleri alıyor sorunsuz
                    // System.out.println(childDataSnapshot.child("user").getValue());

                    String kimlekimarasinda = childDataSnapshot.getKey();
                    StringTokenizer token = new StringTokenizer(kimlekimarasinda, "_");

                    int i = 0;
                    while (token.hasMoreTokens()) {

                        String temp = token.nextToken();

                        if (i == 0 && !kaynak_kisi.replace(".", ",").equals(temp)) {
                            bakmaona = -1;
                            break;


                        }

                        if (i == 1) {
                            hedef_kisi = temp;
                            if(!chatWithList.contains(temp))
                            chatWithList.add(temp);

                        }
                        i++;
                    }

                    if (bakmaona == -1) {
                        bakmaona = 0;
                        continue;
                    }


                    for (DataSnapshot childDataSnapshot2 : childDataSnapshot.getChildren()) {
                        System.out.println("2 = " + childDataSnapshot2.getKey());

                        for (DataSnapshot childDataSnapshot3 : childDataSnapshot2.getChildren()) {
                            System.out.println("3 = " + childDataSnapshot3.getKey());
                            System.out.println("Mesaj = " + childDataSnapshot3.getValue());
                        }

                    }


                }
                System.out.println("OnDataChange Lİste = "+chatWithList);

                for (int i = 0; i < chatWithList.size(); i++) {
                    TextView tv = new TextView(Benim_Mesajlarim.this);
                    tv.setText(chatWithList.get(i));
                    tv.setTextSize(35);
                    tv.setPadding(80, 80, 80, 80);
                    tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                    tv.setTextAppearance(android.R.attr.textAppearanceLarge);
                    tv.setOnClickListener(Benim_Mesajlarim.this);
                    tv.setTag(chatWithList.get(i));
                    ll.addView(tv);
                }
reference.removeEventListener(this);

                //Firebase.goOffline();
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });



        //System.out.println("Lİste = "+chatWithList);


    }


    private void collectEmailAdresses(Map<String, Object> users) {


        ArrayList<String> emails = new ArrayList<>();

        //iterate through each user, ignoring their UID
        for (Map.Entry<String, Object> entry : users.entrySet()) {

            //Get user map
            Map singleUser = (Map) entry.getValue();
            //Get phone field and append to list
            emails.add((String) singleUser.get("user"));
        }

        System.out.println(emails.toString());
    }

    @Override
    public void onClick(View v) {

        TextView textView=(TextView) v;
        String hedef_kisi_sec= (String) textView.getTag();
        UserDetails_Firebase.chatWith=hedef_kisi_sec;
       // Firebase.goOffline();
        getApplicationContext().startActivity(new Intent(getApplicationContext(),Chat_Firebase.class));

    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {
      //  Firebase.goOffline();
        chatWithList.clear();
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {
       // Firebase.goOffline();
    }
/*
    public class Mesaj_Users extends AsyncTask {




        @Override
        protected Object doInBackground(Object[] params) {


            String fire_url = "https://bitirme-proje-1511471101877.firebaseio.com/messages.json";


            Firebase.setAndroidContext(getApplicationContext());
            Firebase reference = new Firebase("https://bitirme-proje-1511471101877.firebaseio.com/messages");
            reference.addValueEventListener(new com.firebase.client.ValueEventListener() {
                @Override
                public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {
                    for (DataSnapshot childDataSnapshot : dataSnapshot.getChildren()) {

                        System.out.println("1 = " + childDataSnapshot.getKey());//Bu emailleri alıyor sorunsuz
                        // System.out.println(childDataSnapshot.child("user").getValue());

                        String kimlekimarasinda = childDataSnapshot.getKey();
                        StringTokenizer token = new StringTokenizer(kimlekimarasinda, "_");

                        int i = 0;
                        while (token.hasMoreTokens()) {

                            String temp = token.nextToken();

                            if (i == 0 && !kaynak_kisi.replace(".", ",").equals(temp)) {
                                bakmaona = -1;
                                break;


                            }

                            if (i == 1) {
                                hedef_kisi = temp;
                                chatWithList.add(temp);

                            }
                            i++;
                        }

                        if (bakmaona == -1) {
                            bakmaona = 0;
                            continue;
                        }


                        for (DataSnapshot childDataSnapshot2 : childDataSnapshot.getChildren()) {
                            System.out.println("2 = " + childDataSnapshot2.getKey());

                            for (DataSnapshot childDataSnapshot3 : childDataSnapshot2.getChildren()) {
                                System.out.println("3 = " + childDataSnapshot3.getKey());
                                System.out.println("Mesaj = " + childDataSnapshot3.getValue());
                            }

                        }


                    }
                    System.out.println("OnDataChange Lİste = "+chatWithList);
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });


            return null;
        }


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);


            //   UserDetails_Firebase.username                   passs chatwith ayarlanip chat_Firebase gönderilecek.

            System.out.println("Lİste = "+chatWithList);

            for (int i = 0; i < chatWithList.size(); i++) {
                TextView tv = new TextView(Benim_Mesajlarim.this);
                tv.setText(chatWithList.get(i));
                tv.setTextSize(35);
                tv.setPadding(80, 80, 80, 80);
                tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                tv.setTextAppearance(android.R.attr.textAppearanceLarge);
                tv.setOnClickListener(Benim_Mesajlarim.this);
                tv.setTag(chatWithList.get(i));
                ll.addView(tv);
            }


        }



    }*/


}
