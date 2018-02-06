package pe.android.com.mvp_clean.data.entity.mapper;

import org.modelmapper.ModelMapper;

import pe.android.com.mvp_clean.data.entity.LoginEntity;
import pe.android.com.mvp_clean.domain.entity.Login;

/**
 * Created by jsaenz on 31/1/2018.
 */

public class LoginEntityMapper {
    public Login transform (LoginEntity poLoginEntity){
        Login poLogin = null;
        if(poLoginEntity != null){
            poLogin = new Login();
            ModelMapper modelMapper = new ModelMapper();
            poLogin = modelMapper.map(poLoginEntity,Login.class);
        }
        return  poLogin;
    }

    public LoginEntity transform (Login poLogin){
        LoginEntity poLoginEntity = null;
        if(poLogin != null){
            poLoginEntity = new LoginEntity();
            ModelMapper modelMapper = new ModelMapper();
            poLoginEntity = modelMapper.map(poLogin,LoginEntity.class);
        }
        return  poLoginEntity;
    }
}
