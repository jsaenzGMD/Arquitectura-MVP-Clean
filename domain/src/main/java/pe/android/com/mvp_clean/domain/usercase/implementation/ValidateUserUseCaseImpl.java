package pe.android.com.mvp_clean.domain.usercase.implementation;

import pe.android.com.mvp_clean.domain.entity.Login;
import pe.android.com.mvp_clean.domain.repository.LoginRepository;
import pe.android.com.mvp_clean.domain.usercase.ValidateUserUseCase;

/**
 * Created by jsaenz on 1/2/2018.
 */

public class ValidateUserUseCaseImpl implements ValidateUserUseCase {
    LoginRepository loginRepository;

    public ValidateUserUseCaseImpl(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public void ejecutar(String usuario, String password, final Callback callback) {
        Login login = new Login();
        login.setUsuario(usuario);
        login.setClave(password);

        loginRepository.validateUser(login, new LoginRepository.CallbackRepository() {
            @Override
            public void onSuccess(Login usuario) {
                callback.onSucess(usuario);
            }

            @Override
            public void onError(Throwable poException) {
                callback.onError(poException);
            }
        });
    }
}
