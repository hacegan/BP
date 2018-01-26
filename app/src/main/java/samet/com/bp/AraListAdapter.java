package samet.com.bp;

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

    ArrayList<ara_pojo> arrayList=new ArrayList<ara_pojo>();
    AraListAdapter(ArrayList<ara_pojo> arrayList){
        this.arrayList=arrayList;
    }


    @Override
    public AraListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.aralistitems,parent,false);


        return new AraListAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AraListAdapter.MyViewHolder holder, int position) {

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
            c_flag= (ImageView) itemView.findViewById(R.id.aralistimageitem);
            c_name= (TextView) itemView.findViewById(R.id.aralisttxtitem);
        }
    }


    public void setFilter(ArrayList<ara_pojo> newList){
        arrayList=new ArrayList<>();
        arrayList.addAll(newList);
        notifyDataSetChanged();
    }



}
