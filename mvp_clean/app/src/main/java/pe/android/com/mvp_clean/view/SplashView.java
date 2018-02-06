package pe.android.com.mvp_clean.view;

/**
 * Created by jsaenz on 1/2/2018.
 */

public interface SplashView extends BaseView {
    void solicitarPermiso(String[] permisos);
    void irLogin();
}
