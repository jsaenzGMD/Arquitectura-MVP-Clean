package pe.android.com.mvp_clean.data.entity.dto;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by jsaenz on 2/2/2018.
 */

@Entity(nameInDb = "MVP_USUARIO")
public class UsuarioDto {
    @Id(autoincrement = true)
    private Long id;
    @NotNull
    @Property(nameInDb = "USER_USUARIO")
    private int usuario;
    @Property(nameInDb = "USER_CLAVE")
    private String clave;
    @Generated(hash = 853450052)
    public UsuarioDto(Long id, int usuario, String clave) {
        this.id = id;
        this.usuario = usuario;
        this.clave = clave;
    }
    @Generated(hash = 1977598838)
    public UsuarioDto() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getUsuario() {
        return this.usuario;
    }
    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }
    public String getClave() {
        return this.clave;
    }
    public void setClave(String clave) {
        this.clave = clave;
    }
    

}
