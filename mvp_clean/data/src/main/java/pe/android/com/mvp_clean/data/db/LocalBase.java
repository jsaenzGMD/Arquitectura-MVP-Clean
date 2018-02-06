package pe.android.com.mvp_clean.data.db;

import android.content.Context;

import pe.android.com.mvp_clean.data.AndroidApplicationData;
import pe.android.com.mvp_clean.data.entity.dto.DaoSession;

/**
 * Created by jsaenz on 2/2/2018.
 */

public class LocalBase {

    private final Context goContext;
    private final DaoSession goDaoSession;
    public static long IS_OK = 0;
    public static long IS_ERROR = 1;

    public LocalBase(Context goContext) {
        this.goContext = goContext;
        this.goDaoSession = ((AndroidApplicationData) goContext).getDaoSession();
    }

    public Context getGoContext() {
        return goContext;
    }

    public DaoSession getGoDaoSession() {
        return goDaoSession;
    }
}
