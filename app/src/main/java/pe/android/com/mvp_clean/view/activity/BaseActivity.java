package pe.android.com.mvp_clean.view.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.afollestad.materialdialogs.MaterialDialog;

import java.util.ArrayList;
import java.util.List;

import pe.android.com.mvp_clean.R;
import pe.android.com.mvp_clean.navigation.Navigator;
import pe.android.com.mvp_clean.presenter.BasePresenter;
import pe.android.com.mvp_clean.util.CommonUtil;
import pe.android.com.mvp_clean.view.BaseView;
import pe.android.com.mvp_clean.view.widget.ToastCustom;

/**
 * Created by jsaenz on 1/2/2018.
 */

public abstract class BaseActivity extends AppCompatActivity implements BaseView {
    BasePresenter presenter;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new BasePresenter(this);
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }

    @Override
    public Intent getIntent() {
        return super.getIntent();
    }

    @Override
    public void showToastError(String message) {
        CommonUtil.mostrarToast(this, message, ToastCustom.TYPE_ERROR);
    }

    @Override
    public void showToastCorrect(String message) {
        CommonUtil.mostrarToast(this, message, ToastCustom.TYPE_CORRECTO);
    }

    @Override
    public void showToastInfo(String message) {
        CommonUtil.mostrarToast(this, message, ToastCustom.TYPE_INFO);
    }

    @Override
    public void showloading(String message) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
        progressDialog = new ProgressDialog(this, R.style.AppCompatAlertDialogStyle);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage(message);
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    public void hideloading() {
        progressDialog.dismiss();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
    }

    @Override
    public void finalizar() {
        finish();
    }

    @Override
    public void terminarAplicacion() {
        finish();
        System.exit(0);
    }

    @Override
    public String obtenerFechaActual() {
        return String.valueOf(android.text.format.DateFormat.format("yyyy/MM/dd HH:mm:ss", new java.util.Date()));
    }
}
