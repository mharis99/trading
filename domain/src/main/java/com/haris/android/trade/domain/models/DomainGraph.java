package com.haris.android.trade.domain.models;

import java.util.List;

public class DomainGraph {

    private List<GraphDataObj> coins;

    public List<GraphDataObj> getCoins() {
        return coins;
    }

    public void setCoins(List<GraphDataObj> coins) {
        this.coins = coins;
    }

    public static final  class GraphDataObj {

        private Integer date;

        private Double volume;

        private Double quoteVolume;

        public GraphDataObj(Double volume) {
            this.volume = volume;
        }

        public Integer getDate() {
            return date;
        }

        public void setDate(Integer date) {
            this.date = date;
        }


        public Double getVolume() {
            return volume;
        }

        public void setVolume(Double volume) {
            this.volume = volume;
        }

        public Double getQuoteVolume() {
            return quoteVolume;
        }

        public void setQuoteVolume(Double quoteVolume) {
            this.quoteVolume = quoteVolume;
        }

    }
}
