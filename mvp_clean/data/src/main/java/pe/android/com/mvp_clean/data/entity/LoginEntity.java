package pe.android.com.mvp_clean.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jsaenz on 31/1/2018.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginEntity {
    @JsonProperty("usuario")
    private String usuario;
    @JsonProperty("clave")
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
