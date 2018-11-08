package com.haris.android.trade.presentation.model;

import com.haris.android.trade.domain.models.DomainCoin;

import java.util.List;

public class CoinModel {

    private List<DomainCoin.Coin> coins;


    public List<DomainCoin.Coin> getCoins() {
        return coins;
    }

    public void setCoins(List<DomainCoin.Coin> coins) {
        this.coins = coins;
    }





}
