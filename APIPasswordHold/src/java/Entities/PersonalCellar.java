/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author wilson.mora
 */
@Entity
@Table(name = "personalcellar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonalCellar.findAll", query = "SELECT p FROM PersonalCellar p")
    , @NamedQuery(name = "PersonalCellar.findByIdBodega", query = "SELECT p FROM PersonalCellar p WHERE p.idBodega = :idBodega")
    , @NamedQuery(name = "PersonalCellar.findByNameProyect", query = "SELECT p FROM PersonalCellar p WHERE p.nameProyect = :nameProyect")
    , @NamedQuery(name = "PersonalCellar.findByPasswordProyect", query = "SELECT p FROM PersonalCellar p WHERE p.passwordProyect = :passwordProyect")})
public class PersonalCellar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idBodega")
    private Integer idBodega;
    @Column(name = "nameProyect")
    private String nameProyect;
    @Column(name = "passwordProyect")
    private String passwordProyect;
    @JoinColumn(name = "idUsuario", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User idUsuario;

    public PersonalCellar() {
    }

    public PersonalCellar(Integer idBodega) {
        this.idBodega = idBodega;
    }

    public Integer getIdBodega() {
        return idBodega;
    }

    public void setIdBodega(Integer idBodega) {
        this.idBodega = idBodega;
    }

    public String getNameProyect() {
        return nameProyect;
    }

    public void setNameProyect(String nameProyect) {
        this.nameProyect = nameProyect;
    }

    public String getPasswordProyect() {
        return passwordProyect;
    }

    public void setPasswordProyect(String passwordProyect) {
        this.passwordProyect = passwordProyect;
    }

    public User getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(User idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBodega != null ? idBodega.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonalCellar)) {
            return false;
        }
        PersonalCellar other = (PersonalCellar) object;
        if ((this.idBodega == null && other.idBodega != null) || (this.idBodega != null && !this.idBodega.equals(other.idBodega))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.PersonalCellar[ idBodega=" + idBodega + " ]";
    }
    
}
