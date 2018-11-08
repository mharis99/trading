package com.haris.android.trade.presentation.model;



import com.haris.android.trade.domain.models.DomainGraph;

import java.util.List;

public class GraphModel {

    private List<DomainGraph.GraphDataObj> coins;

    public List<DomainGraph.GraphDataObj> getCoins() {
        return coins;
    }

    public void setCoins(List<DomainGraph.GraphDataObj> coins) {
        this.coins = coins;
    }

}
