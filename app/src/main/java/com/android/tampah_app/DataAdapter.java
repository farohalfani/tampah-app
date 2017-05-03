package com.android.tampah_app;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Faroh Nur Alfani on 02-May-17.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.MyViewHolder> {

    private Context mContext;
    private Data data;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, count;
        public ImageView thumbnail, overflow;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            count = (TextView) view.findViewById(R.id.count);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
        }
    }

    public DataAdapter(Context mContext, List<Data> albumList) {
        this.mContext = mContext;
//        this.albumList = albumList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.barang, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        data = new Data();
        holder.title.setText(data.namaBrg[position]);
        holder.count.setText(String.valueOf(data.hargaBrg[position]));
        holder.thumbnail.setImageResource(data.gambarBrg[position]);
//        Album album = albumList.get(position);
//        holder.title.setText(album.getName());
//        holder.count.setText(album.getNumOfSongs() + " songs");

//        Glide.with(mContext).load(data.gambar[position]).into(holder.thumbnail);

        // loading album cover using Glide library
//        Glide.with(mContext).load(album.getThumbnail()).into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               choose(position);
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choose(position);
            }
        });
    }

    private void choose(int position) {
        data.setPosition(position);
        Intent intent = new Intent(mContext, ItemActivity.class);
        intent.putExtra("index", String.valueOf(position));
        mContext.startActivity(intent);
//        Toast.makeText(mContext, String.valueOf(position), Toast.LENGTH_LONG).show();
    }

    @Override
    public int getItemCount() {
        return data.namaBrg.length;
    }
}
