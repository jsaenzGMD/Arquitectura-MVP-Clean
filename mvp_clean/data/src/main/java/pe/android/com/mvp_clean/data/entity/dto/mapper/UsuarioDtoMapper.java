package pe.android.com.mvp_clean.data.entity.dto.mapper;

import org.modelmapper.ModelMapper;

import pe.android.com.mvp_clean.data.entity.LoginEntity;
import pe.android.com.mvp_clean.data.entity.dto.UsuarioDto;
import pe.android.com.mvp_clean.domain.entity.Login;

/**
 * Created by jsaenz on 2/2/2018.
 */

public class UsuarioDtoMapper {
    public UsuarioDto transform (Login poLoginEntity){
        UsuarioDto poLogin = null;
        if(poLoginEntity != null){
            poLogin = new UsuarioDto();
            ModelMapper modelMapper = new ModelMapper();
            poLogin = modelMapper.map(poLoginEntity,UsuarioDto.class);
        }
        return  poLogin;
    }

    public Login transform (UsuarioDto poUsuario){
        Login poLoginEntity = null;
        if(poUsuario != null){
            poLoginEntity = new Login();
            ModelMapper modelMapper = new ModelMapper();
            poLoginEntity = modelMapper.map(poUsuario,Login.class);
        }
        return  poLoginEntity;
    }
}
