package pe.android.com.mvp_clean.domain.repository;

import pe.android.com.mvp_clean.domain.entity.Login;

/**
 * Created by jsaenz on 31/1/2018.
 */

public interface LoginRepository {
    void validateUser(Login login, CallbackRepository callbackRepository);
    Login getUsuario();
    void setUsuario(Login login);

    interface CallbackRepository{
        void onSuccess(Login usuario);
        void onError(Throwable poException);
    }

}
