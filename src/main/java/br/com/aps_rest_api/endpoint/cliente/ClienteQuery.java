package br.com.aps_rest_api.endpoint.cliente;

import java.io.Serializable;

public class ClienteQuery implements Serializable {

    public ClienteQuery(){

    }

    public ClienteQuery(Long idCliente, String nome, String email, String telefone, String rua, String numero) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.rua = rua;
        this.numero = numero;
    }

    private Long idCliente;

    private String nome;

    private String email;

    private String telefone;

    private String rua;

    private String numero;

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
