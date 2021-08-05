package com.example.newsapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class adapter extends RecyclerView.Adapter<adapter.ViewH> {

    ArrayList<model2> data;
    Context context;

    public adapter(ArrayList<model2> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.sr_general, parent, false);

        return new adapter.ViewH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewH holder, int position) {

        holder.mtitle.setText(data.get(position).getTitle());
        holder.mdesc.setText(data.get(position).getDescription());
        Glide.with(context).load(data.get(position).getUrlToImage()).into(holder.mimage);
        holder.msource.setText(data.get(position).getSource().get("name"));

        String url=data.get(position).getUrl();
        holder.mcardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(context,webVIew.class);
                intent.putExtra("url",url);
                context.startActivity(intent);



            }
        });


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewH extends RecyclerView.ViewHolder {

        CardView mcardview;
        TextView mtitle, mdesc, msource;
        ImageView mimage;

        public ViewH(@NonNull View itemView) {
            super(itemView);

            mcardview = itemView.findViewById(R.id.cardview_general);
            mdesc = itemView.findViewById(R.id.descGeneral);
            mimage = itemView.findViewById(R.id.imageG);
            msource = itemView.findViewById(R.id.sourecsGeneral);
            mtitle = itemView.findViewById(R.id.titleGeneral);
        }
    }
}
