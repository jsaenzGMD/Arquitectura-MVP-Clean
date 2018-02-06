package pe.android.com.mvp_clean.domain.entity;

/**
 * Created by jsaenz on 31/1/2018.
 */

public class Login {
    private String usuario;
    private String clave;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
