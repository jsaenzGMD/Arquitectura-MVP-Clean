package pe.android.com.mvp_clean.presenter;

import pe.android.com.mvp_clean.data.repository.LoginDataRepository;
import pe.android.com.mvp_clean.domain.entity.Login;
import pe.android.com.mvp_clean.domain.repository.LoginRepository;
import pe.android.com.mvp_clean.domain.usercase.SetUserUseCase;
import pe.android.com.mvp_clean.domain.usercase.ValidateUserUseCase;
import pe.android.com.mvp_clean.domain.usercase.implementation.SetUserUseCaseImpl;
import pe.android.com.mvp_clean.domain.usercase.implementation.ValidateUserUseCaseImpl;
import pe.android.com.mvp_clean.view.LoginView;

/**
 * Created by jsaenz on 1/2/2018.
 */

public class LoginPresenter {
    LoginView view;
    LoginRepository repository;
    public LoginPresenter(LoginView view) {
        this.view = view;
    }

    public void validarUsuario(String usuario, String password){
        repository = new LoginDataRepository(view.getContext());
        ValidateUserUseCase userUseCase = new ValidateUserUseCaseImpl(repository);
        view.showloading("validando");
        userUseCase.ejecutar(usuario, password, new ValidateUserUseCase.Callback() {
            @Override
            public void onSucess(Login login) {
                view.hideloading();
                view.ingreso(login);
            }
            @Override
            public void onError(Throwable throwable) {
                view.hideloading();
                view.showError(throwable.getMessage());
            }
        });
    }

    public void guardarUsuario(Login login){
        repository = new LoginDataRepository(view.getContext());
        SetUserUseCase userUseCase = new SetUserUseCaseImpl(repository);
        userUseCase.setUser(login);
    }
}
