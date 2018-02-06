package pe.android.com.mvp_clean.data.net;

import pe.android.com.mvp_clean.data.entity.LoginEntity;
import pe.android.com.mvp_clean.data.net.message.BaseResponseEntity;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by jsaenz on 31/1/2018.
 */

public interface RestApi {
    @POST("{url}")
    Call<BaseResponseEntity<LoginEntity>> login(
            @Path(value = "url", encoded = true) String psUrl, @Body LoginEntity poBody);
}
