/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author a1712004
 */
@Embeddable
public class VendaHasProdutoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "venda_id_venda")
    private int vendaIdVenda;
    @Basic(optional = false)
    @Column(name = "produto_id_produto")
    private int produtoIdProduto;

    public VendaHasProdutoPK() {
    }

    public VendaHasProdutoPK(int vendaIdVenda, int produtoIdProduto) {
        this.vendaIdVenda = vendaIdVenda;
        this.produtoIdProduto = produtoIdProduto;
    }

    public int getVendaIdVenda() {
        return vendaIdVenda;
    }

    public void setVendaIdVenda(int vendaIdVenda) {
        this.vendaIdVenda = vendaIdVenda;
    }

    public int getProdutoIdProduto() {
        return produtoIdProduto;
    }

    public void setProdutoIdProduto(int produtoIdProduto) {
        this.produtoIdProduto = produtoIdProduto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) vendaIdVenda;
        hash += (int) produtoIdProduto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VendaHasProdutoPK)) {
            return false;
        }
        VendaHasProdutoPK other = (VendaHasProdutoPK) object;
        if (this.vendaIdVenda != other.vendaIdVenda) {
            return false;
        }
        if (this.produtoIdProduto != other.produtoIdProduto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.VendaHasProdutoPK[ vendaIdVenda=" + vendaIdVenda + ", produtoIdProduto=" + produtoIdProduto + " ]";
    }
    
}
