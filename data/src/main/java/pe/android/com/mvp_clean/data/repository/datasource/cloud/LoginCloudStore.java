package pe.android.com.mvp_clean.data.repository.datasource.cloud;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;

import pe.android.com.mvp_clean.data.R;
import pe.android.com.mvp_clean.data.entity.LoginEntity;
import pe.android.com.mvp_clean.data.exception.BaseException;
import pe.android.com.mvp_clean.data.net.RestBase;
import pe.android.com.mvp_clean.data.net.RestCallback;
import pe.android.com.mvp_clean.data.net.RestReceptor;
import pe.android.com.mvp_clean.data.net.message.BaseResponseEntity;
import pe.android.com.mvp_clean.data.repository.datasource.CallbackCloudStore;
import retrofit2.Call;

/**
 * Created by jsaenz on 31/1/2018.
 */

public class LoginCloudStore extends RestBase{

    private static final String TAG = LoginCloudStore.class.getSimpleName();

    public LoginCloudStore(Context poContext) {
        super(poContext);
    }

    public void validarUsuario(LoginEntity poRequest, final CallbackCloudStore<LoginEntity> callbackCloudStore){
        final String lsContext = getContext().getString(R.string.context_mvpcleanapp);
        final String lsEndpoint = getContext().getString(R.string.endpoint_login);
        final String lsUrl = String.format("%s%s", lsContext, lsEndpoint);
        Call<BaseResponseEntity<LoginEntity>> loCall = getRestApi().login(lsUrl, poRequest);

        Log.i("json Request", new Gson().toJson(poRequest));
        Log.i("URL Obtenida", loCall.request().url().toString());
        Log.i(TAG, "INICIO - login");

        RestReceptor<LoginEntity> loRestReceptor = new RestReceptor<>(getContext());
        loRestReceptor.invoke(loCall, new RestCallback<LoginEntity>() {
            @Override
            public void onResponse(LoginEntity poData, BaseResponseEntity poBaseResponseEntity) {
                Log.i(TAG, "FIN - login: onResponse");
                callbackCloudStore.onSuccess(poData);
            }

            @Override
            public void onError(BaseException poException) {
                Log.e(TAG, "FIN - login: onError");
                callbackCloudStore.onError(poException);
            }
        });
    }
}
