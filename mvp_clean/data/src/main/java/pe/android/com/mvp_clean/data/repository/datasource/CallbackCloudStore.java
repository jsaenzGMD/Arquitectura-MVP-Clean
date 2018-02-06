package pe.android.com.mvp_clean.data.repository.datasource;

/**
 * Created by jsaenz on 1/2/2018.
 */

public interface CallbackCloudStore<T> {
    void onSuccess(T poData);
    void onError(Throwable poException);
}
