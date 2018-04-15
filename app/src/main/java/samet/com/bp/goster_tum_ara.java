package samet.com.bp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class goster_tum_ara extends AppCompatActivity implements  View.OnClickListener,SearchView.OnQueryTextListener{


    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<ara_pojo> ara_pojos=new ArrayList<ara_pojo>();
    ArrayList<String> ilanbaslik = new ArrayList<String>();
    ArrayList<String> ilanaciklama = new ArrayList<String>();
    Toolbar toolbar;
    AraListAdapter araListAdapter;
    ArrayList<String> ilanid = new ArrayList<String>();
    static int maxaraid;
    static StorageReference storageReference= FirebaseStorage.getInstance().getReference();
    static Drawable drawable;
    static int drawableResourceId;

    static ArrayList<Integer> heraraarrayliste=new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goster_tum_ara);
        toolbar= (Toolbar) findViewById(R.id.aralisttoolbar);
        setSupportActionBar(toolbar);

        recyclerView= (RecyclerView) findViewById(R.id.aralistrecview);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        new MyAd().execute();
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        newText=newText.toLowerCase();
        ArrayList<ara_pojo> newList=new ArrayList<>();
        for(ara_pojo kira:ara_pojos){
            String ilanbaslik=kira.getIlanbaslik().toLowerCase();
            if(ilanbaslik.contains(newText))
                newList.add(kira);

        }

        araListAdapter.setFilter(newList);
        return true;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.ara_menu_items,menu);
        MenuItem menuItem=menu.findItem(R.id.action_search);
        SearchView searchView= (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(this);
        return true;
    }

    int sayac;
    int wtf=0;
    public class MyAd extends AsyncTask {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Object o) {
            sayac=0;

            for(int i=0;i<ilanbaslik.size();i++){

                final ImageView tempimg=new ImageView(goster_tum_ara.this);

                sayac=i;


                storageReference.child("images/herara/"+ilanid.get(sayac)).getBytes(Long.MAX_VALUE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
                    @Override
                    public void onSuccess(byte[] bytes) {
                        System.out.println("Basariilli");
                        Bitmap bmp = BitmapFactory.decodeByteArray(bytes,0,bytes.length);
                        tempimg.setImageBitmap(bmp);
                        drawable=tempimg.getDrawable();
                        drawable.setBounds(0,0,460,460);
                        drawableResourceId=tempimg.getId();



                        ara_pojos.add(new ara_pojo(ilanbaslik.get(wtf),ilanaciklama.get(wtf),drawable,ilanid.get(wtf)));
                        wtf++;

                        if(wtf==sayac){
                            araListAdapter=new AraListAdapter(ara_pojos,getApplicationContext());
                            recyclerView.setAdapter(araListAdapter);
                        }

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        System.out.println("Basarisiz");
                    }
                });

               /* storageReference.child("images/herara/"+(i+1)).getBytes(Long.MAX_VALUE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
                    @Override
                    public void onSuccess(byte[] bytes) {
                        System.out.println("Basariilli");
                        Bitmap bmp = BitmapFactory.decodeByteArray(bytes,0,bytes.length);
                        tempimg.setImageBitmap(bmp);
                        drawable=tempimg.getDrawable();
                        drawable.setBounds(0,0,460,460);
                        drawableResourceId=tempimg.getId();



                        ara_pojos.add(new ara_pojo(ilanbaslik.get(sayac),ilanaciklama.get(sayac),drawable,ilanid.get(sayac)));


                        if(sayac==ilanbaslik.size()-1){
                            araListAdapter=new AraListAdapter(ara_pojos,getApplicationContext());
                            recyclerView.setAdapter(araListAdapter);
                        }

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        System.out.println("Basarisiz");
                    }
                });*/





                //data[i]=ilanbaslik.get(i).toString();

            }

           // araListAdapter=new AraListAdapter(ara_pojos,getApplicationContext());
           // recyclerView.setAdapter(araListAdapter);



//toplamilansayi= (TextView) findViewById(R.id.allkiralatoplamsayi);
//toplamilansayi.setText("Toplam Kirala İlan Sayısı : "+ilanbaslik.size());

        }

        @Override
        protected Object doInBackground(Object[] params) {

            try{
                URL url=new URL("http://vodkamorello.atspace.co.uk/get_all_ara.php");
                HttpURLConnection con= (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.connect();

                BufferedReader bf=new BufferedReader(new InputStreamReader(con.getInputStream()));
                String  sonuc=bf.readLine();
                //System.out.println(sonuc);

                if(sonuc.equals("0 results;")){

                }
                else{

                    StringTokenizer token = new StringTokenizer(sonuc, ";");

                    ilanaciklama.clear();
                    ilanbaslik.clear();
                    ilanid.clear();

                    while (token.hasMoreTokens()) {

                        String temp=token.nextToken();

                        ilanbaslik.add( temp.substring(temp.indexOf("ilanbaslik:")+11,temp.indexOf("-",temp.indexOf("ilanbaslik:")) ) );
                        ilanaciklama.add( temp.substring(temp.indexOf("ilanaciklama:")).trim() );
                        ilanid.add(  temp.substring(temp.indexOf("Ara id:")+8,temp.indexOf("-",temp.indexOf("Ara id:")) ).trim()  );
                    }


                }





                con.disconnect();
                bf.close();

                /*url=new URL("http://vodkamorello.atspace.co.uk/getmaxallaraimg.php");
                con= (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.connect();

                bf=new BufferedReader(new InputStreamReader(con.getInputStream()));
                sonuc=bf.readLine();

                if(sonuc!=null){
                    maxaraid=Integer.valueOf(sonuc.trim());
                }

                con.disconnect();
                bf.close();


                url=new URL("http://vodkamorello.atspace.co.uk/AraHerArrayGetir.php");
                con= (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.connect();


                bf=new BufferedReader(new InputStreamReader(con.getInputStream()));
                sonuc=bf.readLine();


                token = new StringTokenizer(sonuc, "<br>");
                while (token.hasMoreTokens()) {

                    String temp = token.nextToken();
                    heraraarrayliste.add(Integer.valueOf(temp.trim()));


                }*/







            }
            catch (Exception e){
                e.printStackTrace();
            }


            return null;
        }


    }





}
