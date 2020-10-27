package br.com.aps_rest_api.model.categoria;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {

    public Categoria() {

    }

    public Categoria(Long idCategoria, String descricao, String img) {
        this.idCategoria = idCategoria;
        this.descricao = descricao;
        this.img = img;
    }

    @Id
    @Column(name = "idcategoria")
    @SequenceGenerator(name = "seq_categoria", sequenceName = "seq_categoria", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_categoria")
    private Long idCategoria;

    @Column(name = "descr")
    private String descricao;

    @Column(name = "img")
    private String img;

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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "idCategoria=" + idCategoria +
                ", descricao='" + descricao + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
