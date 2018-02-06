package pe.android.com.mvp_clean.data.net;

import android.content.Context;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import pe.android.com.mvp_clean.data.R;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jsaenz on 31/1/2018.
 */

public class RestBase {
    Context ioContext;
    RestApi ioRestApi;

    public RestBase(Context poContext) {
        this.ioContext = poContext;
        this.ioRestApi = createRestApi();
    }

    public Context getContext() {
        return ioContext;
    }

    public RestApi getRestApi() {
        return ioRestApi;
    }

    protected String getHost() {
        return ioContext.getString(R.string.host_mvpclean);
    }

    protected String getProtocol() {
        return ioContext.getString(R.string.protocol_mvpclean);
    }

    protected int getConnetTimeout() {
        return ioContext.getResources().getInteger(R.integer.connect_timeout);
    }

    protected int getReadTimeout() {
        return ioContext.getResources().getInteger(R.integer.read_timeout);
    }

    private RestApi createRestApi(){
        String lsUrlServer = String.format("%s%s", getProtocol(), getHost());
        if(ioRestApi == null){
            Retrofit loRetrofit = new Retrofit.Builder().baseUrl(lsUrlServer).addConverterFactory(GsonConverterFactory.create()).build();
            ioRestApi = loRetrofit.create(RestApi.class);
        }
        return ioRestApi;
    }

}
