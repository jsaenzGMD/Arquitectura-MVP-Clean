package pe.android.com.mvp_clean.presenter;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import pe.android.com.mvp_clean.util.CommonUtil;
import pe.android.com.mvp_clean.view.SplashView;

/**
 * Created by jsaenz on 1/2/2018.
 */

public class SplashPresenter {
    SplashView view;

    public SplashPresenter(SplashView view) {
        this.view = view;
    }

    public void iniciar(){
        verificarPermisos();
    }

    private void verificarPermisos() {
        String[] permisos = CommonUtil.obtenerPermisos(view.getContext());
        List<String> permisosASolicitar = new ArrayList<>();

        for (int i = 0; i < permisos.length; i++) {
            boolean isPermisoAceptado = ContextCompat.checkSelfPermission(view.getContext(), permisos[i]) == PackageManager.PERMISSION_GRANTED;

            if (!isPermisoAceptado) {
                permisosASolicitar.add(permisos[i]);
                Log.v("SplashPresenter", "Permiso no Aceptado: " + permisos[i]);
            }
        }

        if (permisosASolicitar.size() > 0) {
            String[] lstPermisos = new String[permisosASolicitar.size()];
            lstPermisos = permisosASolicitar.toArray(lstPermisos);
            view.solicitarPermiso(lstPermisos);
        } else {
            view.irLogin();
       }
    }
}
