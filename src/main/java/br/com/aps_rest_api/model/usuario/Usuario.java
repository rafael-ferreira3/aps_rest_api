package br.com.aps_rest_api.model.usuario;

import br.com.aps_rest_api.helpers.Encrypt;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="USUARIO")
public class Usuario implements Serializable {

    Usuario(){}

    public Usuario(String nome, String username, String senha){
        this.nome = nome;
        this.username = username;
        this.senha = Encrypt.toMD5(senha);
    }

    @Id
    @SequenceGenerator(name="seq_usuario",sequenceName="seq_usuario", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_usuario")
    private long idusuario;

    private String nome;

    private String username;

    private String senha;

    public long getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(long idusuario) {
        this.idusuario = idusuario;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idusuario=" + idusuario +
                ", nome='" + nome + '\'' +
                ", username='" + username + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
