package pe.android.com.mvp_clean.data.net;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import java.io.IOException;

import pe.android.com.mvp_clean.data.R;
import pe.android.com.mvp_clean.data.exception.BaseException;
import pe.android.com.mvp_clean.data.net.message.BaseResponseEntity;
import pe.android.com.mvp_clean.data.util.CommonUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by jsaenz on 31/1/18.
 */
public class RestReceptor<T> {

    private static final String TAG = RestReceptor.class.getSimpleName();

    private final Context goContext;
    public RestReceptor(Context poContext) {
        this.goContext = poContext;
    }
    public void invoke(Call<BaseResponseEntity<T>> poCall, final RestCallback<T> poRestCallback) {

        if (CommonUtil.isOnline(this.goContext)) {
            poCall.enqueue(new Callback<BaseResponseEntity<T>>() {
                @Override
                public void onResponse(Call<BaseResponseEntity<T>> poCall, Response<BaseResponseEntity<T>> poResponse) {

                    if (poResponse.body() != null) {
                        if (poResponse.body().getCodigo().equals("1")) {
                            poRestCallback.onResponse(poResponse.body().getRespuesta(), poResponse.body());
                        } else {
                            String lsMessageError = String.format("invoke | onResponse | errorSuccess \n%s",
                                    poResponse.body().getMensaje());
                            Log.e(TAG, lsMessageError);
                            BaseException loBaseException = new BaseException(
                                    poResponse.body().getCodigo(),
                                    poResponse.body().getMensaje(),
                                    !TextUtils.isEmpty(poResponse.body().getMensaje()) ? poResponse.body().getMensaje() : "");
                            loBaseException.setTag(BaseException.TAG.BUSINESS);
                            poRestCallback.onError(loBaseException);
                        }
                    } else {
                        try {
                            if (poResponse.errorBody() != null) {
                                String lsMessageError = String.format("invoke | onResponse | errorBody \n%s",
                                        poResponse.errorBody().string());
                                Log.e(TAG, lsMessageError);
                            } else {
                                Log.e(TAG, "ERROR PARSEANDO DATA");
                            }
                        } catch (IOException poIOException) {
                            Log.e(TAG, "invoke | onResponse | errorBody", poIOException);
                        }
                        poRestCallback.onError(new BaseException(BaseException.ERROR_DATA_RESPONSE,
                                goContext.getString(R.string.rest_message_error_data_response), BaseException.TAG.EXCEPTION));

                    }
                }

                @Override
                public void onFailure(Call<BaseResponseEntity<T>> call, Throwable t) {
                    String lsMessageError = goContext.getString(R.string.rest_message_error_failure);
                    Log.e(TAG, "invoke | onFailure", t);
                    poRestCallback.onError(new BaseException(BaseException.ERROR_FAILURE, lsMessageError, BaseException.TAG.EXCEPTION));
                }
            });
        } else {
            String lsMessageError = goContext.getString(R.string.rest_message_error_connection);
            Log.e(TAG, "invoke", new Throwable(lsMessageError));
            poRestCallback.onError(new BaseException(BaseException.ERROR_CONNECTION, lsMessageError, BaseException.TAG.EXCEPTION));
        }
    }
}
