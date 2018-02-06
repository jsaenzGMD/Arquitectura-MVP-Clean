package pe.android.com.mvp_clean.view.activity;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.afollestad.materialdialogs.MaterialDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pe.android.com.mvp_clean.R;
import pe.android.com.mvp_clean.domain.entity.Login;
import pe.android.com.mvp_clean.presenter.LoginPresenter;
import pe.android.com.mvp_clean.util.CommonUtil;
import pe.android.com.mvp_clean.view.LoginView;
import pe.android.com.mvp_clean.view.dialog.DialogView;

public class LoginActivity extends BaseActivity implements LoginView{

    @BindView(R.id.edtUsuario)
    EditText edtUsuario;
    @BindView(R.id.edtPassword)
    EditText edtPassword;
    @BindView(R.id.btnIngresar)
    Button btnIngresar;

    LoginPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        //CommonUtil.exportarBD(this);
        presenter = new LoginPresenter(this);
    }

    public static Intent getCallingIntent(Context context){
        return new Intent(context,LoginActivity.class);
    }


    @OnClick(R.id.btnIngresar)
    public void onClickBtnIngresar(){
        if(edtUsuario.getText().length() == 0 || edtPassword.getText().length() == 0){
            showToastError("Ingrese correctamente los datos");
        }else{
            presenter.validarUsuario(edtUsuario.getText().toString(),edtPassword.getText().toString());
        }
    }

    @Override
    public void showError(String message) {
        DialogView.create(this).showBasicDialog(getResources().getString(R.string.error), message, null, new DialogView.OnSingleButton() {
            @Override
            public void onClick(@NonNull MaterialDialog poDialog) {

            }
        }).setCanceledOnTouchOutside(false);
    }

    @Override
    public void irMenu() {

    }

    @Override
    public void ingreso(Login login) {
        presenter.guardarUsuario(login);
        DialogView.create(this).showBasicDialog(login.getUsuario() + " " + login.getClave());

    }
}
