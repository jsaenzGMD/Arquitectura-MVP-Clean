package pe.android.com.mvp_clean.navigation;

import android.content.Context;
import android.content.Intent;

import pe.android.com.mvp_clean.view.activity.LoginActivity;
import pe.android.com.mvp_clean.view.activity.PrincipalActivity;

/**
 * Created by jsaenz on 1/2/2018.
 */

public class Navigator {
    public static void navigateToLogin(Context context){
        Intent intent = LoginActivity.getCallingIntent(context);
        context.startActivity(intent);
    }

    public static void navigateToPrincipal(Context context){
        Intent intent = PrincipalActivity.getCallingIntent(context);
        context.startActivity(intent);
    }
}
