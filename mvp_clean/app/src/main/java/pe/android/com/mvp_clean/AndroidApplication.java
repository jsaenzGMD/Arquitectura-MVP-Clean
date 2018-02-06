package pe.android.com.mvp_clean;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.v7.app.AppCompatDelegate;

import org.greenrobot.greendao.database.Database;

import pe.android.com.mvp_clean.data.AndroidApplicationData;
import pe.android.com.mvp_clean.data.db.UpdateHelper;
import pe.android.com.mvp_clean.data.entity.dto.DaoMaster;
import pe.android.com.mvp_clean.data.entity.dto.DaoSession;


/**
 * Created by jsaenz on 2/2/2018.
 */

public class AndroidApplication extends Application implements AndroidApplicationData{
    private DaoSession goDaoSession;
    private String gsToken;
    private static AndroidApplication instance;

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        this.initializeGreenDao();
        instance = this;
    }

    public static AndroidApplication getInstance() {
        return instance;
    }

    public void setToken(String psToken) {
        this.gsToken = psToken;
    }

    @Override
    public String getToken() {
        return gsToken;
    }

    @Override
    public DaoSession getDaoSession() {
        return goDaoSession;
    }

    private void initializeGreenDao() {
        boolean lbEncryptedBD = getApplicationContext().getResources().getBoolean(R.bool.encrypted_bd);
        String lsNameBD = getApplicationContext().getString(R.string.name_bd);
        String lsPasswordBD = getApplicationContext().getString(R.string.password_bd);

        UpdateHelper helper = new UpdateHelper(this, lsNameBD);
        //colocar en lbEncryptedDB = false para no encriptar la BDD
        Database db = lbEncryptedBD ? helper.getEncryptedWritableDb(lsPasswordBD) : helper.getWritableDb();
        goDaoSession = new DaoMaster(db).newSession();
    }
}
