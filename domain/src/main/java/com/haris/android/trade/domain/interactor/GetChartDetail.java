package com.haris.android.trade.domain.interactor;

import com.haris.android.trade.domain.executor.PostExecutionThread;
import com.haris.android.trade.domain.executor.ThreadExecutor;
import com.haris.android.trade.domain.models.DomainGraph;
import com.haris.android.trade.domain.repository.TradeRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

public class GetChartDetail extends UseCase<DomainGraph, GetChartDetail.Params>  {

    private final TradeRepository tradeRepository;

    @Inject
    GetChartDetail(TradeRepository tradeRepository, ThreadExecutor threadExecutor,
                   PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.tradeRepository = tradeRepository;
    }


    @Override
    Observable<DomainGraph> buildUseCaseObservable(GetChartDetail.Params params) {
        return this.tradeRepository.chartDetails(params.currencyPair,params.start,params.end, params.isForceUpdate);
    }


    public static final class Params {

        private final String currencyPair;
        private final String start;
        private final String end;

        private final boolean isForceUpdate;

        private Params(String currencyPair,String start, String end, boolean isForceUpdate) {

            this.currencyPair = currencyPair;
            this.start = start;
            this.end = end;
            this.isForceUpdate=isForceUpdate;
        }

        public static GetChartDetail.Params forChart(String currencyPair,String start, String end, boolean isForceUpdate) {
            return new GetChartDetail.Params(currencyPair,start,end, isForceUpdate);
        }
    }

}
