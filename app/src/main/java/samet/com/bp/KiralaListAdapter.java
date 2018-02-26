package samet.com.bp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeoutException;

/**
 * Created by root on 25.01.2018.
 */

public class KiralaListAdapter extends RecyclerView.Adapter<KiralaListAdapter.MyViewHolder> {
ArrayList<kirala_pojo> arrayList=new ArrayList<kirala_pojo>();
    Context ctx;
    KiralaListAdapter(ArrayList<kirala_pojo> arrayList,Context ctx){
        this.arrayList=arrayList;
        this.ctx=ctx;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.kiralalistitems,parent,false);


        return new MyViewHolder(view,ctx,arrayList);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        //holder.c_flag.setImageResource(arrayList.get(position).getPhoto());
       // holder.c_flag.setImageResource(R.drawable.empty_house);
       // holder.c_flag.setImageResource(arrayList.get(position).getPhoto());
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

ArrayList<kirala_pojo> kiralapojo=new ArrayList<kirala_pojo>();
        Context ctx;
        public MyViewHolder(View itemView,Context ctx,ArrayList<kirala_pojo> kiralapojo) {
            super(itemView);
            this.kiralapojo=kiralapojo;
            this.ctx=ctx;
            itemView.setOnClickListener(this);
            c_flag= (ImageView) itemView.findViewById(R.id.kiralalistimageitem);
            c_name= (TextView) itemView.findViewById(R.id.kiralalisttxtitem);
        }

        @Override
        public void onClick(View v) {
int position=getAdapterPosition();
kirala_pojo pojo=this.kiralapojo.get(position);
            Intent intent=new Intent(this.ctx,tekilkiralailangoster.class);
            intent.putExtra("tekilkiralaitemid",pojo.getIlanid());
            this.ctx.startActivity(intent);

        }
    }


    public void setFilter(ArrayList<kirala_pojo> newList){
        arrayList=new ArrayList<>();
        arrayList.addAll(newList);
        notifyDataSetChanged();
    }


}
