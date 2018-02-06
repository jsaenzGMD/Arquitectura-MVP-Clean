package pe.android.com.mvp_clean.domain.usercase;

import java.util.Calendar;

import pe.android.com.mvp_clean.domain.entity.Login;

/**
 * Created by jsaenz on 1/2/2018.
 */

public interface ValidateUserUseCase {
    void ejecutar(String usuario, String password, Callback callback);
    interface Callback{
        void onSucess(Login login);
        void onError(Throwable throwable);
    }
}
