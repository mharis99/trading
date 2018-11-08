
package com.haris.android.trade.data.entity.mapper;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.haris.android.trade.data.entity.CoinEntity;
import com.haris.android.trade.data.entity.GraphEntity;
import com.haris.android.trade.domain.models.DomainCoin;
import com.haris.android.trade.domain.models.DomainGraph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class TradeEntityDataMapper {

    private final Gson gson = new Gson();

    @Inject
    TradeEntityDataMapper() {
    }


    public DomainCoin transform(CoinEntity coinEntity) {
        if (coinEntity == null) {
            throw new IllegalArgumentException("Cannot transform a null value");
        }
        final DomainCoin domainCoin = new DomainCoin();
        List<DomainCoin.Coin> coins = new ArrayList<>();
        coins.clear();
        Iterator entries = coinEntity.getCoins().entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry entry = (Map.Entry) entries.next();
            String key = (String) entry.getKey();
            DomainCoin.Coin coin = gson.fromJson(entry.getValue().toString(), DomainCoin.Coin.class);
            coin.setCoinCode(key);
            coins.add(coin);


            System.out.println("Key = " + key + ", Value = ");
        }

        domainCoin.setCoins(coins);

        return domainCoin;
    }

    public DomainGraph transformGraphData(GraphEntity graphEntity) {
        if (graphEntity == null) {
            throw new IllegalArgumentException("Cannot transform a null value");
        }
        final DomainGraph domainGraph = new DomainGraph();

        List<DomainGraph.GraphDataObj> graphs = gson.fromJson(graphEntity.getGraphData().toString(), new TypeToken<List<DomainGraph.GraphDataObj>>() {
        }.getType());

        domainGraph.setCoins(graphs);

        return domainGraph;
    }


}
