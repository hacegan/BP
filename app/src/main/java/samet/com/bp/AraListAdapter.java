package samet.com.bp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by root on 26.01.2018.
 */

public class AraListAdapter extends RecyclerView.Adapter<AraListAdapter.MyViewHolder>{
    Context ctx;
    ArrayList<ara_pojo> arrayList=new ArrayList<ara_pojo>();
    AraListAdapter(ArrayList<ara_pojo> arrayList,Context ctx){
        this.arrayList=arrayList;
        this.ctx=ctx;
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
            int position=getAdapterPosition();
            ara_pojo pojo=this.arapojo.get(position);
            Intent intent=new Intent(this.ctx,tekilarailangoster.class);
            intent.putExtra("tekilaraitemid",pojo.getIlanid());
            this.ctx.startActivity(intent);
        }
    }


    public void setFilter(ArrayList<ara_pojo> newList){
        arrayList=new ArrayList<>();
        arrayList.addAll(newList);
        notifyDataSetChanged();
    }



}
