package pe.android.com.mvp_clean.presenter;

import pe.android.com.mvp_clean.view.BaseView;

/**
 * Created by jsaenz on 1/2/2018.
 */

public class BasePresenter {
    BaseView view;

    public BasePresenter(BaseView view) {
        this.view = view;
    }
}
