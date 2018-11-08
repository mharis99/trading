
package com.haris.android.trade.domain.repository;

import com.haris.android.trade.domain.models.DomainCoin;
import com.haris.android.trade.domain.models.DomainGraph;

import io.reactivex.Observable;


public interface TradeRepository {

    Observable<DomainCoin> trade(boolean isForceUpdate);

    Observable<DomainGraph> chartDetails(String currencyPair,String start, String end, boolean isForceUpdate);


}
