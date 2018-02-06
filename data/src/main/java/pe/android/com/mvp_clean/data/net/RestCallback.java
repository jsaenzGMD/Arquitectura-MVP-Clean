package pe.android.com.mvp_clean.data.net;

import pe.android.com.mvp_clean.data.exception.BaseException;
import pe.android.com.mvp_clean.data.net.message.BaseResponseEntity;

/**
 * Created by jsaenz on 31/01/18.
 */

public interface RestCallback<T> {

    void onResponse(T poData, BaseResponseEntity poBaseResponseEntity);
    void onError(BaseException poException);
}
