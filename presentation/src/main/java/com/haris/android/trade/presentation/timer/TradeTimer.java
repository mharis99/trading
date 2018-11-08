package com.haris.android.trade.presentation.timer;


import java.util.Timer;
import java.util.TimerTask;

public class TradeTimer extends TimerTask {

    private Timer timer;

    private TradeInterval tradeInterval;

    private boolean hasStarted = false;

    public TradeTimer(TradeInterval timeUpdate) {
        tradeInterval = timeUpdate;
        timer = new Timer();
        timer.scheduleAtFixedRate(this, 0, 3000);
    }

    @Override
    public void run() {
        this.hasStarted = true;
        this.tradeInterval.onTradeIntervalUpdate();
    }

    public boolean hasRunStarted() {
        return this.hasStarted;
    }


}