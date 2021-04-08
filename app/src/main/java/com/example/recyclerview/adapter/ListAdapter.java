package com.example.recyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.R;
import com.example.recyclerview.model.List1;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.viewHolder> {


    private  List<List1> list1List;
    private Context mContext;

    public ListAdapter(List<List1> list1List, Context mContext) {
        this.list1List = list1List;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ListAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.list,parent,false);
        return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.viewHolder holder, int position) {
        int img1 = list1List.get(position).getImg1();
        int img2 = list1List.get(position).getImg2();
        String txt1 = list1List.get(position).getTxt1();
        String txt2 = list1List.get(position).getTxt2();

        holder.setContents(img1,img2,txt1,txt2);

    }

    @Override
    public int getItemCount() {
        return list1List.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView image1,image2;
        TextView text1, Text2;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            image1 = itemView.findViewById(R.id.img1Iv);
            image2 = itemView.findViewById(R.id.img2Iv);
            text1 = itemView.findViewById(R.id.text1Tv);
            Text2 = itemView.findViewById(R.id.text2Tv);
        }

        public void setContents(int img1, int img2, String txt1, String txt2) {

            image1.setImageResource(img1);
            image2.setImageResource(img2);
            text1.setText(txt1);
            Text2.setText(txt2);
        }
    }
}
