package br.com.aps_rest_api.endpoint.login;

import br.com.aps_rest_api.model.usuario.Usuario;

import java.io.Serializable;

public class UsuarioLoginQuery implements Serializable {

    long idUsuario;
    String nome;
    String username;

    public UsuarioLoginQuery(){

    }

    public UsuarioLoginQuery(long idUsuario, String nome, String username) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.username = username;
    }

    public UsuarioLoginQuery(Usuario usuario){
        this.idUsuario = usuario.getIdUsuario();
        this.nome = usuario.getNome();
        this.username = usuario.getUsername();
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "UsuarioLoginQuery{" +
                "idUsuario=" + idUsuario +
                ", nome='" + nome + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
