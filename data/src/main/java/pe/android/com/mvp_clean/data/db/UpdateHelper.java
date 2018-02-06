package pe.android.com.mvp_clean.data.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import org.greenrobot.greendao.database.Database;

import pe.android.com.mvp_clean.data.entity.dto.DaoMaster;

/**
 * Created by jsaenz on 2/02/18.
 */
public class UpdateHelper extends DaoMaster.DevOpenHelper {

    public UpdateHelper(Context poContext, String psName, SQLiteDatabase.CursorFactory poFactory) {
        super(poContext, psName, poFactory);
    }

    public UpdateHelper(Context poContext, String psName) {
        super(poContext, psName);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        switch (newVersion) {
//            case 2:
//                new MigrateV1ToV2().applyMigration(db, oldVersion);
//                break;
//            case 3:
//                new MigrateV2ToV3().applyMigration(db, oldVersion);
//                break;
            default:
                return;
        }

    }
}
