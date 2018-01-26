package samet.com.bp;

import android.content.Context;
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
    KiralaListAdapter(ArrayList<kirala_pojo> arrayList){
        this.arrayList=arrayList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.kiralalistitems,parent,false);


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        //holder.c_flag.setImageResource(arrayList.get(position).getPhoto());
        holder.c_flag.setImageResource(R.drawable.empty_house);
holder.c_name.setText(arrayList.get(position).getIlanbaslik());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public static class MyViewHolder extends  RecyclerView.ViewHolder{

        ImageView c_flag;
        TextView c_name;


        public MyViewHolder(View itemView) {
            super(itemView);
            c_flag= (ImageView) itemView.findViewById(R.id.kiralalistimageitem);
            c_name= (TextView) itemView.findViewById(R.id.kiralalisttxtitem);
        }
    }


    public void setFilter(ArrayList<kirala_pojo> newList){
        arrayList=new ArrayList<>();
        arrayList.addAll(newList);
        notifyDataSetChanged();
    }


}
