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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "permissions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permission.findAll", query = "SELECT p FROM Permission p")
    , @NamedQuery(name = "Permission.findByIdPermission", query = "SELECT p FROM Permission p WHERE p.idPermission = :idPermission")
    , @NamedQuery(name = "Permission.findByNamePermission", query = "SELECT p FROM Permission p WHERE p.namePermission = :namePermission")})
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPermission")
    private Integer idPermission;
    @Column(name = "namePermission")
    private String namePermission;
    @Lob
    @Column(name = "url")
    private String url;
    @JoinTable(name = "rolepermissions", joinColumns = {
        @JoinColumn(name = "idPermission", referencedColumnName = "idPermission")}, inverseJoinColumns = {
        @JoinColumn(name = "idRole", referencedColumnName = "idRole")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Role> roles;
    @OneToMany(mappedBy = "permissionPadre", fetch = FetchType.LAZY)
    private List<Permission> permissions;
    @JoinColumn(name = "Permission_Padre", referencedColumnName = "idPermission")
    @ManyToOne(fetch = FetchType.LAZY)
    private Permission permissionPadre;

    public Permission() {
    }

    public Permission(Integer idPermission) {
        this.idPermission = idPermission;
    }

    public Integer getIdPermission() {
        return idPermission;
    }

    public void setIdPermission(Integer idPermission) {
        this.idPermission = idPermission;
    }

    public String getNamePermission() {
        return namePermission;
    }

    public void setNamePermission(String namePermission) {
        this.namePermission = namePermission;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @XmlTransient
    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @XmlTransient
    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

   
    
    
    public Permission getPermissionPadre() {
        return permissionPadre;
    }

    public void setPermissionPadre(Permission permissionPadre) {
        this.permissionPadre = permissionPadre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPermission != null ? idPermission.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permission)) {
            return false;
        }
        Permission other = (Permission) object;
        if ((this.idPermission == null && other.idPermission != null) || (this.idPermission != null && !this.idPermission.equals(other.idPermission))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Permission[ idPermission=" + idPermission + " ]";
    }
    
}
