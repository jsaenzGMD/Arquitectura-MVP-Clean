package pe.android.com.mvp_clean.data.repository.datasource.local;

import android.content.Context;

import java.util.List;

import pe.android.com.mvp_clean.data.db.LocalBase;
import pe.android.com.mvp_clean.data.entity.dto.UsuarioDto;
import pe.android.com.mvp_clean.data.entity.dto.UsuarioDtoDao;
import pe.android.com.mvp_clean.data.repository.datasource.LocalStore;

/**
 * Created by jsaenz on 2/2/2018.
 */

public class UsuarioLocalStore extends LocalBase implements LocalStore<UsuarioDto,UsuarioDtoDao>{
    public UsuarioLocalStore(Context goContext) {
        super(goContext);
    }

    @Override
    public long insertOrUpdate(UsuarioDto object) {
        return dao().insertOrReplace(object);
    }

    @Override
    public long clear() {
        try {
            dao().deleteAll();
            return IS_OK;
        }catch(Exception e){
            return IS_ERROR;
        }
    }

    @Override
    public UsuarioDtoDao dao() {
        return getGoDaoSession().getUsuarioDtoDao();
    }

    @Override
    public UsuarioDto getForId(long id) {
        return dao().load(id);
    }

    @Override
    public List<UsuarioDto> getAll() {
        return dao().loadAll();
    }

    @Override
    public long deleteForId(long id) {
        try {
            dao().delete(getForId(id));
            return IS_OK;
        }catch (Exception e){
            return IS_ERROR;
        }
    }

    //----Añadir otros métodos adicionales en caso existiera-----
}
