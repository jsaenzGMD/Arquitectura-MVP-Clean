package pe.android.com.mvp_clean.domain.usercase.implementation;

import pe.android.com.mvp_clean.domain.entity.Login;
import pe.android.com.mvp_clean.domain.repository.LoginRepository;
import pe.android.com.mvp_clean.domain.usercase.SetUserUseCase;

/**
 * Created by jsaenz on 2/2/2018.
 */

public class SetUserUseCaseImpl implements SetUserUseCase{
    LoginRepository loginRepository;

    public SetUserUseCaseImpl(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public void setUser(Login login) {
        loginRepository.setUsuario(login);
    }
}
