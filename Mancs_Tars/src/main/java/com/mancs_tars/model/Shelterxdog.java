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
@Table(name = "shelterxdog")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shelterxdog.findAll", query = "SELECT s FROM Shelterxdog s"),
    @NamedQuery(name = "Shelterxdog.findById", query = "SELECT s FROM Shelterxdog s WHERE s.id = :id"),
    @NamedQuery(name = "Shelterxdog.findByShelterId", query = "SELECT s FROM Shelterxdog s WHERE s.shelterId = :shelterId"),
    @NamedQuery(name = "Shelterxdog.findByDogId", query = "SELECT s FROM Shelterxdog s WHERE s.dogId = :dogId"),
    @NamedQuery(name = "Shelterxdog.findByArrivelDate", query = "SELECT s FROM Shelterxdog s WHERE s.arrivelDate = :arrivelDate")})
public class Shelterxdog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "shelter_id")
    private int shelterId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dog_id")
    private int dogId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "arrivel_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date arrivelDate;

    public Shelterxdog() {
    }

    public Shelterxdog(Integer id) {
        this.id = id;
    }

    public Shelterxdog(Integer id, int shelterId, int dogId, Date arrivelDate) {
        this.id = id;
        this.shelterId = shelterId;
        this.dogId = dogId;
        this.arrivelDate = arrivelDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getShelterId() {
        return shelterId;
    }

    public void setShelterId(int shelterId) {
        this.shelterId = shelterId;
    }

    public int getDogId() {
        return dogId;
    }

    public void setDogId(int dogId) {
        this.dogId = dogId;
    }

    public Date getArrivelDate() {
        return arrivelDate;
    }

    public void setArrivelDate(Date arrivelDate) {
        this.arrivelDate = arrivelDate;
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
        if (!(object instanceof Shelterxdog)) {
            return false;
        }
        Shelterxdog other = (Shelterxdog) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mancs_tars.model.Shelterxdog[ id=" + id + " ]";
    }
    
}
