
package com.haris.android.trade.data.net.retrofit;

import com.google.gson.JsonElement;
import com.haris.android.trade.data.entity.CoinEntity;
import com.haris.android.trade.data.entity.GraphEntity;
import com.haris.android.trade.data.exception.NetworkConnectionException;
import com.haris.android.trade.data.net.RestApi;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitRestApiImpl implements RestApi {

    private Retrofit retrofit;
    private OkHttpClient.Builder builder;
    private TradeRetrofitApi tradeRetrofitApi;
    private static final long DEFAULT_TIMEOUT = 5;

    public RetrofitRestApiImpl() {
        builder = new OkHttpClient.Builder()
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .addInterceptor(chain -> {
                    Request original = chain.request();
                    HttpUrl originalHttpUrl = original.url();

                    HttpUrl url = originalHttpUrl.newBuilder()
                            .build();

                    // Request customization: add request headers
                    Request.Builder requestBuilder = original.newBuilder().url(url);

                    Request request = requestBuilder.build();
                    return chain.proceed(request);
                });

        retrofit = new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(simpleCallAdapter)
                .baseUrl(RestApi.API_BASE_URL)
                .build();

        tradeRetrofitApi = retrofit.create(TradeRetrofitApi.class);
    }

    private final CallAdapter.Factory simpleCallAdapter = new CallAdapter.Factory() {
        @Override
        public CallAdapter<Object, Object> get(final Type returnType, Annotation[] annotations, Retrofit retrofit) {
            // if returnType is retrofit2.Call, do nothing
            if (returnType.toString().contains("retrofit2.Call")) {
                return null;
            }

            return new CallAdapter<Object, Object>() {
                @Override
                public Type responseType() {
                    return returnType;
                }

                @Override
                public Object adapt(Call<Object> call) {
                    try {
                        return call.execute().body();
                    } catch (Exception e) {
                        throw new RuntimeException(e); // do something better
                    }
                }
            };
        }
    };





    @Override
    public Observable<CoinEntity> tradeEntity() {

        return Observable.create(emitter -> {
            try {
                Map<String, Object> response = getTradeFromApi();
                if (response != null) {
                    emitter.onNext(new CoinEntity(response));
                    emitter.onComplete();
                } else {
                    emitter.onError(new NetworkConnectionException());
                }
            } catch (Exception e) {
                emitter.onError(new NetworkConnectionException(e.getCause()));
            }
        });
    }

    @Override
    public Observable<GraphEntity> chartDetails(String currencyPair,String start, String end) {
        return Observable.create(emitter -> {
            try {
                JsonElement response = getChartFromApi(currencyPair, start, end);
                if (response != null) {
                    emitter.onNext(new GraphEntity(response));
                    emitter.onComplete();
                } else {
                    emitter.onError(new NetworkConnectionException());
                }
            } catch (Exception e) {
                emitter.onError(new NetworkConnectionException(e.getCause()));
            }
        });
    }


    private Map<String, Object> getTradeFromApi() {
        return tradeRetrofitApi.getTradeDetails();
    }


    private JsonElement getChartFromApi(String currencyPair, String start, String end) {
        return tradeRetrofitApi.getChartDetails(currencyPair, start, end);
    }


}
