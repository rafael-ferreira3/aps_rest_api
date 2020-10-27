package br.com.aps_rest_api.endpoint.categoria;

import java.io.Serializable;

public class CategoriaQuery implements Serializable {

    public CategoriaQuery(){

    }

    public CategoriaQuery(Long idCategoria, String descr, String img) {
        this.idCategoria = idCategoria;
        this.descr = descr;
        this.img = img;
    }

    private Long idCategoria;

    private String descr;

    private String img;

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
