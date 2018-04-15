package samet.com.bp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by root on 26.01.2018.
 */

public class AraListAdapter extends RecyclerView.Adapter<AraListAdapter.MyViewHolder>{
   static Context ctx;
    ArrayList<ara_pojo> arrayList=new ArrayList<ara_pojo>();

    static int position;
    static ara_pojo pojo;

    static SharedPreferences sharedPref;
    static SharedPreferences.Editor editor;


    AraListAdapter(ArrayList<ara_pojo> arrayList,Context ctx){
        this.arrayList=arrayList;
        AraListAdapter.ctx =ctx;
    }


    @Override
    public AraListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.aralistitems,parent,false);


        return new AraListAdapter.MyViewHolder(view,ctx,arrayList);
    }

    @Override
    public void onBindViewHolder(AraListAdapter.MyViewHolder holder, int position) {

        //holder.c_flag.setImageResource(arrayList.get(position).getPhoto());
       // holder.c_flag.setImageResource(R.drawable.empty_house);
        //holder.c_flag.setImageResource(arrayList.get(position).getPhoto());
        holder.c_flag.setImageDrawable(arrayList.get(position).getPhoto());
        holder.c_name.setText(arrayList.get(position).getIlanbaslik());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public static class MyViewHolder extends  RecyclerView.ViewHolder implements  View.OnClickListener{

        ImageView c_flag;
        TextView c_name;
        ArrayList<ara_pojo> arapojo=new ArrayList<ara_pojo>();
        Context ctx;

        public MyViewHolder(View itemView,Context ctx,ArrayList<ara_pojo> arapojo) {
            super(itemView);
            this.arapojo=arapojo;
            this.ctx=ctx;
            itemView.setOnClickListener(this);
            c_flag= (ImageView) itemView.findViewById(R.id.aralistimageitem);
            c_name= (TextView) itemView.findViewById(R.id.aralisttxtitem);
        }

        @Override
        public void onClick(View v) {
             position=getAdapterPosition();
             pojo=this.arapojo.get(position);

            sharedPref = ctx.getSharedPreferences("MyPref",0);
            editor = sharedPref.edit();

            new MyAd().execute();


        }
    }


    public void setFilter(ArrayList<ara_pojo> newList){
        arrayList=new ArrayList<>();
        arrayList.addAll(newList);
        notifyDataSetChanged();
    }



    public static class MyAd extends AsyncTask {


        @Override
        protected Object doInBackground(Object[] params) {

            try{

                URL url=new URL("http://vodkamorello.atspace.co.uk/Arailankimeait.php?ilan_id="+pojo.getIlanid());
                HttpURLConnection con= (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.connect();

                BufferedReader bf=new BufferedReader(new InputStreamReader(con.getInputStream()));
                String  sonuc=bf.readLine();


                if(sonuc.equals(sharedPref.getString("user_id",null))){
                    Intent intent=new Intent(ctx,Benim_Tekil_Ara_Goster.class);
                    intent.putExtra("ilan_id",pojo.getIlanid());
                    ctx.startActivity(intent);
                }

                else{
                    Intent intent=new Intent(ctx,tekilarailangoster.class);
                    intent.putExtra("tekilaraitemid",pojo.getIlanid());
                    ctx.startActivity(intent);
                }



            }
            catch (Exception e){
                e.printStackTrace();
            }






            return null;
        }


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Object o) {

        }


    }


}
