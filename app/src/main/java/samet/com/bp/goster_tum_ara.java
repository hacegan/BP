package samet.com.bp;

import android.os.AsyncTask;
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
    static int maxkiraid;


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


    public class MyAd extends AsyncTask {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Object o) {
            String[] data=new String[ilanbaslik.size()];

            for(int i=0;i<ilanbaslik.size();i++){
                ara_pojos.add(new ara_pojo(ilanbaslik.get(i),ilanaciklama.get(i),R.drawable.empty_house,ilanid.get(i)));
                data[i]=ilanbaslik.get(i).toString();

            }

            araListAdapter=new AraListAdapter(ara_pojos,getApplicationContext());
            recyclerView.setAdapter(araListAdapter);



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

                StringTokenizer token = new StringTokenizer(sonuc, ";");
                while (token.hasMoreTokens()) {

                    String temp=token.nextToken();

                    ilanbaslik.add( temp.substring(temp.indexOf("ilanbaslik:"),temp.indexOf("-",temp.indexOf("ilanbaslik:")) ).replaceAll("ilanbaslik:","").trim() );
                    ilanaciklama.add( temp.substring(temp.indexOf("ilanaciklama:") ).replaceAll("ilanaciklama:","").trim() );
                    ilanid.add(  temp.substring(temp.indexOf("Ara id:"),temp.indexOf("-",temp.indexOf("Ara id:")) ).replaceAll("Kirala id:","").trim()  );
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
