package br.com.aps_rest_api.model.usuario;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="USUARIO")
public class Usuario implements Serializable {

    public Usuario(){}

    public Usuario(String nome, String username, String senha){
        this.nome = nome;
        this.username = username;
        this.senha = senha;
    }

    public Usuario(long idUsuario, String nome, String username, String senha){
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.username = username;
        this.senha = senha;
    }

    @Id
    @Column(name = "idusuario")
    @SequenceGenerator(name="seq_usuario",sequenceName="seq_usuario", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_usuario")
    private long idUsuario;

    @Column(name = "nome")
    private String nome;

    @Column(name = "username")
    private String username;

    @Column(name = "senha")
    private String senha;

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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idusuario=" + idUsuario +
                ", nome='" + nome + '\'' +
                ", username='" + username + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
