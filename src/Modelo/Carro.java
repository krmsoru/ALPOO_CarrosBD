/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author utayk
 */
@Entity
@Table(name = "Carros")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Carro.findAll", query = "SELECT c FROM Carro c")
    , @NamedQuery(name = "Carro.findById", query = "SELECT c FROM Carro c WHERE c.id = :id")
    , @NamedQuery(name = "Carro.findByFabricante", query = "SELECT c FROM Carro c WHERE c.fabricante = :fabricante")
    , @NamedQuery(name = "Carro.findByModelo", query = "SELECT c FROM Carro c WHERE c.modelo = :modelo")
    , @NamedQuery(name = "Carro.findByCor", query = "SELECT c FROM Carro c WHERE c.cor = :cor")
    , @NamedQuery(name = "Carro.findByAnoFabricacao", query = "SELECT c FROM Carro c WHERE c.anoFabricacao = :anoFabricacao")
    , @NamedQuery(name = "Carro.findByValor", query = "SELECT c FROM Carro c WHERE c.valor = :valor")
})
public class Carro implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "fabricante")
    private String fabricante;
    @Column(name = "modelo")
    private String modelo;
    @Column(name = "cor")
    private String cor;
    @Column(name = "ano_fabricacao")
    private Integer anoFabricacao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Double valor;

    public Carro()
    {
    }

    public Carro(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getFabricante()
    {
        return fabricante;
    }

    public void setFabricante(String fabricante)
    {
        this.fabricante = fabricante;
    }

    public String getModelo()
    {
        return modelo;
    }

    public void setModelo(String modelo)
    {
        this.modelo = modelo;
    }

    public String getCor()
    {
        return cor;
    }

    public void setCor(String cor)
    {
        this.cor = cor;
    }

    public Integer getAnoFabricacao()
    {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Integer anoFabricacao)
    {
        this.anoFabricacao = anoFabricacao;
    }

    public Double getValor()
    {
        return valor;
    }

    public void setValor(Double valor)
    {
        this.valor = valor;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carro))
        {
            return false;
        }
        Carro other = (Carro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "Modelo.Carro[ id=" + id + " ]";
    }
    
}
