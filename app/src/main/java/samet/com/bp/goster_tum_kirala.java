package samet.com.bp;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ExpandedMenuView;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import co.moonmonkeylabs.realmsearchview.RealmSearchAdapter;
import io.realm.Realm;
import io.realm.RealmViewHolder;

public class goster_tum_kirala extends AppCompatActivity implements  View.OnClickListener,SearchView.OnQueryTextListener{

RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;




ArrayList<kirala_pojo> kirala_pojos=new ArrayList<kirala_pojo>();
    static int resultcount=0;
    ArrayList<String> ilanbaslik = new ArrayList<String>();
    ArrayList<String> ilanaciklama = new ArrayList<String>();
    ListView listView;
    // Search EditText
    EditText inputSearch;
    KiralaListAdapter kiralaListAdapter;
    // Listview Adapter
    ArrayAdapter<String> adapter;
    TextView toplamilansayi;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goster_tum_kirala);
        toolbar= (Toolbar) findViewById(R.id.kiralalisttoolbar);
        setSupportActionBar(toolbar);

        recyclerView= (RecyclerView) findViewById(R.id.kiralalistrecview);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
                recyclerView.setHasFixedSize(true);




        new MyAd().execute();



    }

    @Override
    public void onClick(View v) {

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

getMenuInflater().inflate(R.menu.kirala_menu_items,menu);
        MenuItem menuItem=menu.findItem(R.id.action_search);
        SearchView searchView= (SearchView) MenuItemCompat.getActionView(menuItem);
searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        newText=newText.toLowerCase();
        ArrayList<kirala_pojo> newList=new ArrayList<>();
        for(kirala_pojo kira:kirala_pojos){
            String ilanbaslik=kira.getIlanbaslik().toLowerCase();
            if(ilanbaslik.contains(newText))
newList.add(kira);

        }

kiralaListAdapter.setFilter(newList);


        return true;
    }


    public class MyAd extends AsyncTask {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Object o) {
String[] data=new String[ilanbaslik.size()];

            for(int i=0;i<ilanbaslik.size();i++){
kirala_pojos.add(new kirala_pojo(ilanbaslik.get(i),ilanaciklama.get(i),R.drawable.empty_house));
data[i]=ilanbaslik.get(i).toString();

            }

kiralaListAdapter=new KiralaListAdapter(kirala_pojos);
            recyclerView.setAdapter(kiralaListAdapter);



//toplamilansayi= (TextView) findViewById(R.id.allkiralatoplamsayi);
//toplamilansayi.setText("Toplam Kirala İlan Sayısı : "+ilanbaslik.size());

        }

        @Override
        protected Object doInBackground(Object[] params) {

            try{
                URL url=new URL("http://vodkamorello.atspace.co.uk/get_all_kirala.php");
                HttpURLConnection con= (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.connect();

                BufferedReader bf=new BufferedReader(new InputStreamReader(con.getInputStream()));
              String  sonuc=bf.readLine();
                //System.out.println(sonuc);

                StringTokenizer token = new StringTokenizer(sonuc, ";");
                while (token.hasMoreTokens()) {

                    String temp=token.nextToken();

                        ilanbaslik.add( temp.substring(temp.indexOf("ilanbaslik:"),temp.indexOf("-",temp.indexOf("ilanbaslik:")) ).replaceAll("ilanbaslik:","").trim() );
                        ilanaciklama.add( temp.substring(temp.indexOf("ilanaciklama:") ).replaceAll("ilanaciklama:","").trim() );

                }




                con.disconnect();


            }
            catch (Exception e){
                e.printStackTrace();
            }


            return null;
        }


    }










}
