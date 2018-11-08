package com.haris.android.trade.data.entity;


import java.util.Map;

public class CoinEntity {


    public CoinEntity(Map<String, Object> coins) {
        this.coins = coins;
    }

    private Map<String, Object> coins ;

    public Map<String, Object> getCoins() {
        return coins;
    }

    public void setCoins(Map<String, Object> coins) {
        this.coins = coins;
    }
}
