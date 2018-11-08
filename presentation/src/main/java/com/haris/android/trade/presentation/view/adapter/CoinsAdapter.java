package com.haris.android.trade.presentation.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.haris.android.trade.domain.models.DomainCoin;
import com.haris.android.trade.presentation.R;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;


public class CoinsAdapter extends RecyclerView.Adapter<CoinsAdapter.CoinViewHolder> {

    public interface OnItemClickListener {
        void onCoinItemClicked(DomainCoin.Coin coin);
    }

    private Context context;
    private List<DomainCoin.Coin> coins;
    private final LayoutInflater layoutInflater;

    private OnItemClickListener onItemClickListener;

    @Inject
    CoinsAdapter(Context context) {
        this.context = context;
        this.layoutInflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.coins = Collections.emptyList();
    }

    @Override
    public int getItemCount() {
        return (this.coins != null) ? this.coins.size() : 0;
    }

    @Override
    public CoinViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = this.layoutInflater.inflate(R.layout.row_coin, parent, false);
        return new CoinViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CoinViewHolder holder, final int position) {
        final DomainCoin.Coin coin = this.coins.get(position);
        holder.textViewTitle.setText(coin.getCoinCode());
        holder.textViewHigh.setText( this.context.getString(R.string.high_value,coin.getHigh24hr()));
        holder.textViewLow.setText( this.context.getString(R.string.low_value,coin.getLow24hr()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (CoinsAdapter.this.onItemClickListener != null) {
                    CoinsAdapter.this.onItemClickListener.onCoinItemClicked(coin);
                }
            }
        });

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void setCoins(Collection<DomainCoin.Coin> coins) {
        this.validateCoinsCollection(coins);
        this.coins = (List<DomainCoin.Coin>) coins;
        this.notifyDataSetChanged();
    }


    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    private void validateCoinsCollection(Collection<DomainCoin.Coin> coins) {
        if (coins == null) {
            throw new IllegalArgumentException("The list cannot be null");
        }
    }

    static class CoinViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.coinTitle)
        TextView textViewTitle;

        @Bind(R.id.high)
        TextView textViewHigh;

        @Bind(R.id.low)
        TextView textViewLow;


        CoinViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
