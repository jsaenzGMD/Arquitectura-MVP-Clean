package pe.android.com.mvp_clean.view.activity;

import android.app.Dialog;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.afollestad.materialdialogs.MaterialDialog;

import java.util.ArrayList;
import java.util.List;

import pe.android.com.mvp_clean.R;
import pe.android.com.mvp_clean.navigation.Navigator;
import pe.android.com.mvp_clean.presenter.SplashPresenter;
import pe.android.com.mvp_clean.view.SplashView;
import pe.android.com.mvp_clean.view.dialog.DialogView;

public class SplashActivity extends BaseActivity implements SplashView{
    SplashPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        presenter = new SplashPresenter(this);
        presenter.iniciar();
    }


    public void solicitarPermiso(String[] lasPermission) {
        ActivityCompat.requestPermissions(this,lasPermission,0);
    }

    @Override
    public void irLogin() {
        Navigator.navigateToLogin(this);
    }

    @Override
    public void onRequestPermissionsResult(final int requestCode, @NonNull final String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        List<String> lasPermissionPending = new ArrayList<>();
        for (int i = 0; i < permissions.length; i++) {
            if (grantResults[i] == PackageManager.PERMISSION_DENIED) {
                lasPermissionPending.add(permissions[i]);
            }
        }
        if (lasPermissionPending.isEmpty()) {
            irLogin();
        } else {
            DialogView.create(this).showBasicDialog(null, "Debe aceptar los permisos para continuar", null, new DialogView.OnSingleButton() {
                @RequiresApi(api = Build.VERSION_CODES.M)
                @Override
                public void onClick(@NonNull MaterialDialog poDialog) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        return;
                    }
                    requestPermissions(permissions, requestCode);
                }
            });

        }

    }

    @Override
    public void showError(String message) {

    }


    //----Eventos listener dialog

    //private DialogView.OnSingleButton goOnSingleButtonGoPermission = new DialogView.OnSingleButton() {
    //    @Override
    //    public void onClick(@NonNull MaterialDialog poDialog) {
    //
    //    }
    //};
}
