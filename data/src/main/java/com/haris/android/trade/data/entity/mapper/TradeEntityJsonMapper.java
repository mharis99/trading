
package com.haris.android.trade.data.entity.mapper;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.haris.android.trade.data.entity.CoinEntity;

import java.lang.reflect.Type;

import javax.inject.Inject;


public class TradeEntityJsonMapper {

    private final Gson gson;

    @Inject
    public TradeEntityJsonMapper() {
        this.gson = new Gson();
    }


    public CoinEntity transformCoinEntity(String coinJsonResponse) throws JsonSyntaxException {
        final Type coinEntityType = new TypeToken<CoinEntity>() {
        }.getType();
        return this.gson.fromJson(coinJsonResponse, coinEntityType);
    }

}
