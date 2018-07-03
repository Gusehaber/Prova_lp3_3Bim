/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author a1712004
 */
@Entity
@Table(name = "venda_has_produto")
@NamedQueries({
    @NamedQuery(name = "VendaHasProduto.findAll", query = "SELECT v FROM VendaHasProduto v")})
public class VendaHasProduto implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VendaHasProdutoPK vendaHasProdutoPK;
    @Basic(optional = false)
    @Column(name = "quantidade_produto")
    private int quantidadeProduto;
    @Basic(optional = false)
    @Column(name = "preco_venda")
    private double precoVenda;
    @JoinColumn(name = "produto_id_produto", referencedColumnName = "id_produto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Produto produto;
    @JoinColumn(name = "venda_id_venda", referencedColumnName = "id_venda", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Venda venda;

    public VendaHasProduto() {
    }

    public VendaHasProduto(VendaHasProdutoPK vendaHasProdutoPK) {
        this.vendaHasProdutoPK = vendaHasProdutoPK;
    }

    public VendaHasProduto(VendaHasProdutoPK vendaHasProdutoPK, int quantidadeProduto, double precoVenda) {
        this.vendaHasProdutoPK = vendaHasProdutoPK;
        this.quantidadeProduto = quantidadeProduto;
        this.precoVenda = precoVenda;
    }

    public VendaHasProduto(int vendaIdVenda, int produtoIdProduto) {
        this.vendaHasProdutoPK = new VendaHasProdutoPK(vendaIdVenda, produtoIdProduto);
    }

    public VendaHasProdutoPK getVendaHasProdutoPK() {
        return vendaHasProdutoPK;
    }

    public void setVendaHasProdutoPK(VendaHasProdutoPK vendaHasProdutoPK) {
        this.vendaHasProdutoPK = vendaHasProdutoPK;
    }

    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vendaHasProdutoPK != null ? vendaHasProdutoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VendaHasProduto)) {
            return false;
        }
        VendaHasProduto other = (VendaHasProduto) object;
        if ((this.vendaHasProdutoPK == null && other.vendaHasProdutoPK != null) || (this.vendaHasProdutoPK != null && !this.vendaHasProdutoPK.equals(other.vendaHasProdutoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.VendaHasProduto[ vendaHasProdutoPK=" + vendaHasProdutoPK + " ]";
    }
    
}
