package pe.android.com.mvp_clean.data;

import pe.android.com.mvp_clean.data.entity.dto.DaoSession;

/**
 * Created by jsaenz on 2/2/2018.
 */

public interface AndroidApplicationData {
    String getToken();
    DaoSession getDaoSession();
}
