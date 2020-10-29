package br.com.aps_rest_api.endpoint.produto;
import java.io.Serializable;

public class ProdutoParam implements Serializable {

    public ProdutoParam(){

    }

    public ProdutoParam(Long idProduto, Long idCategoria, String descricao, Double preco, String img) {
        this.idProduto = idProduto;
        this.idCategoria = idCategoria;
        this.descricao = descricao;
        this.preco = preco;
        this.img = img;
    }

    private Long idProduto;

    private Long idCategoria;

    private String descricao;

    private Double preco;

    private String img;

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
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

    @Override
    public String toString() {
        return "ProdutoParam{" +
                "idProduto=" + idProduto +
                ", categoria=" + idCategoria +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                ", img='" + img + '\'' +
                '}';
    }
}
