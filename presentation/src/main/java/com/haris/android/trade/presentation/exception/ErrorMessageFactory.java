
package com.haris.android.trade.presentation.exception;

import android.content.Context;

import com.haris.android.trade.data.exception.TradeNotAvailableException;
import com.haris.android.trade.data.exception.NetworkConnectionException;
import com.haris.android.trade.presentation.R;


public class ErrorMessageFactory {

    private ErrorMessageFactory() {
        //empty
    }


    public static String create(Context context, Exception exception) {
        String message = context.getString(R.string.exception_message_generic);

        if (exception instanceof NetworkConnectionException) {
            message = context.getString(R.string.exception_message_no_connection);
        } else if (exception instanceof TradeNotAvailableException) {
            message = context.getString(R.string.exception_message_trade_not_found);
        }

        return message;
    }
}
