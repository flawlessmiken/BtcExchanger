package com.a5.ngenemichael.btcexchanger;

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
 * Created by Flawless on 10/12/2017.
 */
public class CountriesAd extends RecyclerView.Adapter<CountriesAd.MyViewHolder>  {

    private List<Countries> mCountries;
        // ViewHolder
    public class MyViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener {
        public TextView name, btc, eth;
        public ImageView cFlag,coinFlag;
        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            name = (TextView) itemView.findViewById(R.id.names);
            btc = (TextView)itemView.findViewById(R.id.btc);
            eth = (TextView)itemView.findViewById(R.id.eth);
            cFlag = (ImageView)itemView.findViewById(R.id.flag1);
            coinFlag = (ImageView)itemView.findViewById(R.id.flag2);

        }



        @Override
        public void onClick(View v) {
            Context context = v.getContext();
            Intent i = new Intent(context,ConversionBoard.class);
            i.putExtra("key",getAdapterPosition());
            context.startActivity(i);
        }
    }
    public  CountriesAd (List<Countries>mCountries){
        this.mCountries=mCountries;
    }
    @Override
    public MyViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card,parent,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Countries countries = mCountries.get(position);
        holder.name.setText(countries.getName());
        holder.btc.setText(countries.getBtc());
        holder.eth.setText(countries.getEth());
        holder.cFlag.setImageResource(countries.getcFlag());
        holder.coinFlag.setImageResource(countries.getCoinFlag());

    }

    @Override
    public int getItemCount() {
        return mCountries.size();
    }


}
