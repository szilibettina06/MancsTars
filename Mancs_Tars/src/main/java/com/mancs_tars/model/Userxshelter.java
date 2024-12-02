/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mancs_tars.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rkczi
 */
@Entity
@Table(name = "userxshelter")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userxshelter.findAll", query = "SELECT u FROM Userxshelter u"),
    @NamedQuery(name = "Userxshelter.findById", query = "SELECT u FROM Userxshelter u WHERE u.id = :id"),
    @NamedQuery(name = "Userxshelter.findByUserId", query = "SELECT u FROM Userxshelter u WHERE u.userId = :userId"),
    @NamedQuery(name = "Userxshelter.findByShelterId", query = "SELECT u FROM Userxshelter u WHERE u.shelterId = :shelterId"),
    @NamedQuery(name = "Userxshelter.findByRole", query = "SELECT u FROM Userxshelter u WHERE u.role = :role"),
    @NamedQuery(name = "Userxshelter.findByConnectionDate", query = "SELECT u FROM Userxshelter u WHERE u.connectionDate = :connectionDate")})
public class Userxshelter implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "shelter_id")
    private Integer shelterId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "role")
    private int role;
    @Basic(optional = false)
    @NotNull
    @Column(name = "connection_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date connectionDate;

    public Userxshelter() {
    }

    public Userxshelter(Integer id) {
        this.id = id;
    }

    public Userxshelter(Integer id, int role, Date connectionDate) {
        this.id = id;
        this.role = role;
        this.connectionDate = connectionDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getShelterId() {
        return shelterId;
    }

    public void setShelterId(Integer shelterId) {
        this.shelterId = shelterId;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public Date getConnectionDate() {
        return connectionDate;
    }

    public void setConnectionDate(Date connectionDate) {
        this.connectionDate = connectionDate;
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
        if (!(object instanceof Userxshelter)) {
            return false;
        }
        Userxshelter other = (Userxshelter) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mancs_tars.model.Userxshelter[ id=" + id + " ]";
    }
    
}
