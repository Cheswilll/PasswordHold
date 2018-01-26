/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author wilson.mora
 */
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
    , @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id")
    , @NamedQuery(name = "User.findByNameUser", query = "SELECT u FROM User u WHERE u.nameUser = :nameUser")
    , @NamedQuery(name = "User.findByPasswordUser", query = "SELECT u FROM User u WHERE u.passwordUser = :passwordUser")
    , @NamedQuery(name = "User.findLogin", query = "SELECT u FROM User u WHERE u.nameUser = :nameUser AND u.passwordUser = :passwordUser")
    , @NamedQuery(name = "User.findByCorreoElectronico", query = "SELECT u FROM User u WHERE u.correoElectronico = :correoElectronico")
    , @NamedQuery(name = "User.findByState", query = "SELECT u FROM User u WHERE u.state = :state")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nameUser")
    private String nameUser;
    @Column(name = "passwordUser")
    private String passwordUser;
    @Column(name = "correoElectronico")
    private String correoElectronico;
    @Column(name = "state")
    private Integer state;
    @ManyToMany(mappedBy = "userList", fetch = FetchType.LAZY)
    private List<Role> roles;
    @OneToMany(mappedBy = "idUsuario", fetch = FetchType.LAZY)
    private List<PersonalCellar> personalCellars;

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @XmlTransient
    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @XmlTransient
    public List<PersonalCellar> getPersonalCellars() {
        return personalCellars;
    }

    public void setPersonalCellars(List<PersonalCellar> personalCellars) {
        this.personalCellars = personalCellars;
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
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.User[ id=" + id + " ]";
    }
    
}
