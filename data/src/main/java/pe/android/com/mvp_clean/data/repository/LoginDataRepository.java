package pe.android.com.mvp_clean.data.repository;

import android.content.Context;
import android.util.Log;

import pe.android.com.mvp_clean.data.entity.LoginEntity;
import pe.android.com.mvp_clean.data.entity.dto.mapper.UsuarioDtoMapper;
import pe.android.com.mvp_clean.data.entity.mapper.LoginEntityMapper;
import pe.android.com.mvp_clean.data.repository.datasource.CallbackCloudStore;
import pe.android.com.mvp_clean.data.repository.datasource.cloud.LoginCloudStore;
import pe.android.com.mvp_clean.data.repository.datasource.local.UsuarioLocalStore;
import pe.android.com.mvp_clean.domain.entity.Login;
import pe.android.com.mvp_clean.domain.repository.LoginRepository;
import retrofit2.http.POST;

/**
 * Created by jsaenz on 31/1/2018.
 */

public class LoginDataRepository implements LoginRepository {
   Context context;

    public LoginDataRepository(Context context) {
        this.context = context;
    }

    @Override
    public void validateUser(Login login, final CallbackRepository callbackRepository) {
        LoginCloudStore loginCloudStore = new LoginCloudStore(context);
        loginCloudStore.validarUsuario(new LoginEntityMapper().transform(login), new CallbackCloudStore<LoginEntity>() {
            @Override
            public void onSuccess(LoginEntity poData) {
                callbackRepository.onSuccess(new LoginEntityMapper().transform(poData));
            }

            @Override
            public void onError(Throwable poException) {
                callbackRepository.onError(poException);
            }
        });
    }

    @Override
    public Login getUsuario() {
        return null;
    }

    @Override
    public void setUsuario(Login login) {
        UsuarioDtoMapper usuarioDtoMapper = new UsuarioDtoMapper();
        UsuarioLocalStore localStore = new UsuarioLocalStore(context);
        localStore.insertOrUpdate(usuarioDtoMapper.transform(login));
        Log.i("Inserto","Se inserto los datos");

    }
}
