package pe.android.com.mvp_clean.view.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.fasterxml.jackson.databind.ser.Serializers;

import pe.android.com.mvp_clean.R;
import pe.android.com.mvp_clean.view.PrincipalView;

public class PrincipalActivity extends BaseActivity implements PrincipalView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    }

    @Override
    public void actualizarMenu() {

    }
    public static Intent getCallingIntent(Context context){
        return new Intent(context,PrincipalActivity.class);
    }

    @Override
    public void showError(String message) {

    }
}
