// Generated code from Butter Knife. Do not modify!
package pe.android.com.mvp_clean.view.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import pe.android.com.mvp_clean.R;

public class LoginActivity_ViewBinding implements Unbinder {
  private LoginActivity target;

  private View view2131689690;

  @UiThread
  public LoginActivity_ViewBinding(LoginActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public LoginActivity_ViewBinding(final LoginActivity target, View source) {
    this.target = target;

    View view;
    target.edtUsuario = Utils.findRequiredViewAsType(source, R.id.edtUsuario, "field 'edtUsuario'", EditText.class);
    target.edtPassword = Utils.findRequiredViewAsType(source, R.id.edtPassword, "field 'edtPassword'", EditText.class);
    view = Utils.findRequiredView(source, R.id.btnIngresar, "field 'btnIngresar' and method 'onClickBtnIngresar'");
    target.btnIngresar = Utils.castView(view, R.id.btnIngresar, "field 'btnIngresar'", Button.class);
    view2131689690 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickBtnIngresar();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    LoginActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.edtUsuario = null;
    target.edtPassword = null;
    target.btnIngresar = null;

    view2131689690.setOnClickListener(null);
    view2131689690 = null;
  }
}
