package com.haris.android.trade.domain.models;

import java.util.List;

public class DomainCoin {

    private List<Coin> coins;

    public List<Coin> getCoins() {
        return coins;
    }

    public void setCoins(List<Coin> coins) {
        this.coins = coins;
    }


    public static final class Coin {

        private String coinCode;

        private Integer id;

        private String last;

        private String lowestAsk;

        private String highestBid;

        private String percentChange;

        private String baseVolume;

        private String quoteVolume;

        private String isFrozen;

        private String high24hr;

        private String low24hr;

        public Coin(String coinCode) {
            this.coinCode = coinCode;
        }

        public Coin(String coinCode, Integer id, String last, String lowestAsk, String highestBid, String percentChange, String baseVolume, String quoteVolume, String isFrozen, String high24hr, String low24hr) {
            this.coinCode = coinCode;
            this.id = id;
            this.last = last;
            this.lowestAsk = lowestAsk;
            this.highestBid = highestBid;
            this.percentChange = percentChange;
            this.baseVolume = baseVolume;
            this.quoteVolume = quoteVolume;
            this.isFrozen = isFrozen;
            this.high24hr = high24hr;
            this.low24hr = low24hr;
        }

        public String getCoinCode() {
            return coinCode;
        }

        public void setCoinCode(String coinCode) {
            this.coinCode = coinCode;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getLast() {
            return last;
        }

        public void setLast(String last) {
            this.last = last;
        }

        public String getLowestAsk() {
            return lowestAsk;
        }

        public void setLowestAsk(String lowestAsk) {
            this.lowestAsk = lowestAsk;
        }

        public String getHighestBid() {
            return highestBid;
        }

        public void setHighestBid(String highestBid) {
            this.highestBid = highestBid;
        }

        public String getPercentChange() {
            return percentChange;
        }

        public void setPercentChange(String percentChange) {
            this.percentChange = percentChange;
        }

        public String getBaseVolume() {
            return baseVolume;
        }

        public void setBaseVolume(String baseVolume) {
            this.baseVolume = baseVolume;
        }

        public String getQuoteVolume() {
            return quoteVolume;
        }

        public void setQuoteVolume(String quoteVolume) {
            this.quoteVolume = quoteVolume;
        }

        public String getIsFrozen() {
            return isFrozen;
        }

        public void setIsFrozen(String isFrozen) {
            this.isFrozen = isFrozen;
        }

        public String getHigh24hr() {
            return high24hr;
        }

        public void setHigh24hr(String high24hr) {
            this.high24hr = high24hr;
        }

        public String getLow24hr() {
            return low24hr;
        }

        public void setLow24hr(String low24hr) {
            this.low24hr = low24hr;
        }

    }




}
