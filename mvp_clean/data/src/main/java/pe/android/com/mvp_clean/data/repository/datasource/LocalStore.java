package pe.android.com.mvp_clean.data.repository.datasource;

import java.util.List;

/**
 * Created by jsaenz on 2/2/2018.
 */

public interface LocalStore<T,K> {
    public long insertOrUpdate(T object);

    public long clear();

    public K dao();

    public T getForId(long id);

    public List<T> getAll();

    public long deleteForId(long id);
}
