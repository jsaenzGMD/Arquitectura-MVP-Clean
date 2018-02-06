package pe.android.com.mvp_clean.view;

import android.content.Context;
import android.content.Intent;

/**
 * Created by jsaenz on 1/2/2018.
 */

public interface BaseView {
    Context getContext();
    Intent getIntent();
    void showError(String message);
    void showToastError(String message);
    void showToastCorrect(String message);
    void showToastInfo(String message);
    void finalizar();
    void terminarAplicacion();
    void showloading(String message);
    void hideloading();
    String obtenerFechaActual();
}
