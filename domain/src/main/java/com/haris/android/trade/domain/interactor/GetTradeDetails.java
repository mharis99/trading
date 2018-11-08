package com.haris.android.trade.domain.interactor;

import com.haris.android.trade.domain.models.DomainCoin;
import com.haris.android.trade.domain.executor.PostExecutionThread;
import com.haris.android.trade.domain.executor.ThreadExecutor;
import com.haris.android.trade.domain.repository.TradeRepository;

import javax.inject.Inject;

import io.reactivex.Observable;


public class GetTradeDetails extends UseCase<DomainCoin, GetTradeDetails.Params> {

    private final TradeRepository tradeRepository;

    @Inject
    GetTradeDetails(TradeRepository tradeRepository, ThreadExecutor threadExecutor,
                    PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.tradeRepository = tradeRepository;
    }


    @Override
    Observable<DomainCoin> buildUseCaseObservable(Params params) {
        return this.tradeRepository.trade(params.isForceUpdate);
    }


    public static final class Params {

        private final boolean isForceUpdate;

        private Params(boolean isForceUpdate) {


            this.isForceUpdate=isForceUpdate;
        }

        public static GetTradeDetails.Params forTrade(boolean isForceUpdate) {
            return new GetTradeDetails.Params(isForceUpdate);
        }
    }



}
