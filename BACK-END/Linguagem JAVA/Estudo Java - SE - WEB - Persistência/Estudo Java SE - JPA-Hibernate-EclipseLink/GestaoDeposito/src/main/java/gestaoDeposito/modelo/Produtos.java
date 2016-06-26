/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaoDeposito.modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Maikon
 */
@Entity
@Table(name = "produtos", catalog = "testes", schema = "")
@NamedQueries({
    @NamedQuery(name = "Produtos.findAll", query = "SELECT p FROM Produtos p"),
    @NamedQuery(name = "Produtos.findById", query = "SELECT p FROM Produtos p WHERE p.id = :id"),
    @NamedQuery(name = "Produtos.findByNomeProduto", query = "SELECT p FROM Produtos p WHERE p.nomeProduto = :nomeProduto"),
    @NamedQuery(name = "Produtos.findByQuantidadeProduto", query = "SELECT p FROM Produtos p WHERE p.quantidadeProduto = :quantidadeProduto"),
    @NamedQuery(name = "Produtos.findByValorProduto", query = "SELECT p FROM Produtos p WHERE p.valorProduto = :valorProduto")})
public class Produtos implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "nomeProduto")
    private String nomeProduto;
    @Basic(optional = false)
    @Column(name = "quantidadeProduto")
    private int quantidadeProduto;
    @Basic(optional = false)
    @Column(name = "valorProduto")
    private double valorProduto;

    public Produtos() {
    }

    public Produtos(Long id) {
        this.id = id;
    }

    public Produtos(Long id, String nomeProduto, int quantidadeProduto, double valorProduto) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.quantidadeProduto = quantidadeProduto;
        this.valorProduto = valorProduto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        Long oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        String oldNomeProduto = this.nomeProduto;
        this.nomeProduto = nomeProduto;
        changeSupport.firePropertyChange("nomeProduto", oldNomeProduto, nomeProduto);
    }

    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(int quantidadeProduto) {
        int oldQuantidadeProduto = this.quantidadeProduto;
        this.quantidadeProduto = quantidadeProduto;
        changeSupport.firePropertyChange("quantidadeProduto", oldQuantidadeProduto, quantidadeProduto);
    }

    public double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(double valorProduto) {
        double oldValorProduto = this.valorProduto;
        this.valorProduto = valorProduto;
        changeSupport.firePropertyChange("valorProduto", oldValorProduto, valorProduto);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produtos)) {
            return false;
        }
        Produtos other = (Produtos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gestaoDeposito.janelas.Produtos[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
