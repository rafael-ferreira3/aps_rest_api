package br.com.aps_rest_api.endpoint.login;

import java.io.Serializable;

public class LoginParam implements Serializable {

    public LoginParam(){}

    String username;
    String senha;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "LoginParam{" +
                "username='" + username + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
