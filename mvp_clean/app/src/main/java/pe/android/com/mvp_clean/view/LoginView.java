package pe.android.com.mvp_clean.view;

import pe.android.com.mvp_clean.domain.entity.Login;

/**
 * Created by jsaenz on 1/2/2018.
 */

public interface LoginView extends BaseView{
    void irMenu();
    void ingreso(Login login);
}
