package br.com.aps_rest_api.model.produto;

import br.com.aps_rest_api.model.categoria.Categoria;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "produto")
public class Produto implements Serializable {

    public Produto(){

    }

    public Produto(Long idProduto, Categoria categoria, String descricao, Double preco, String img) {
        this.idProduto = idProduto;
        this.categoria = categoria;
        this.descricao = descricao;
        this.preco = preco;
        this.img = img;
    }

    public Produto(Categoria categoria, String descricao, Double preco, String img) {
        this.categoria = categoria;
        this.descricao = descricao;
        this.preco = preco;
        this.img = img;
    }

    @Id
    @Column(name = "idproduto")
    @SequenceGenerator(name = "seq_produto", sequenceName = "seq_produto", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_produto")
    private Long idProduto;

    @ManyToOne(targetEntity = Categoria.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "idcategoria")
    private Categoria categoria;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "preco")
    private Double preco;

    @Column(name = "img")
    private String img;

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
