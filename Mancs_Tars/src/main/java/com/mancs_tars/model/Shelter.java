/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mancs_tars.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rkczi
 */
@Entity
@Table(name = "shelter")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shelter.findAll", query = "SELECT s FROM Shelter s"),
    @NamedQuery(name = "Shelter.findById", query = "SELECT s FROM Shelter s WHERE s.id = :id"),
    @NamedQuery(name = "Shelter.findByAddress", query = "SELECT s FROM Shelter s WHERE s.address = :address"),
    @NamedQuery(name = "Shelter.findByEmail", query = "SELECT s FROM Shelter s WHERE s.email = :email"),
    @NamedQuery(name = "Shelter.findByPhoneNumber", query = "SELECT s FROM Shelter s WHERE s.phoneNumber = :phoneNumber"),
    @NamedQuery(name = "Shelter.findByShelterName", query = "SELECT s FROM Shelter s WHERE s.shelterName = :shelterName"),
    @NamedQuery(name = "Shelter.findByDirectorName", query = "SELECT s FROM Shelter s WHERE s.directorName = :directorName"),
    @NamedQuery(name = "Shelter.findByComment", query = "SELECT s FROM Shelter s WHERE s.comment = :comment"),
    @NamedQuery(name = "Shelter.findByUserId", query = "SELECT s FROM Shelter s WHERE s.userId = :userId"),
    @NamedQuery(name = "Shelter.findByDogId", query = "SELECT s FROM Shelter s WHERE s.dogId = :dogId"),
    @NamedQuery(name = "Shelter.findByCatId", query = "SELECT s FROM Shelter s WHERE s.catId = :catId")})
public class Shelter implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "web_address")
    private String webAddress;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "phone_number")
    private String phoneNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "shelter_name")
    private String shelterName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "director_name")
    private String directorName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "comment")
    private String comment;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "dog_id")
    private Integer dogId;
    @Column(name = "cat_id")
    private Integer catId;

    public Shelter() {
    }

    public Shelter(Integer id) {
        this.id = id;
    }

    public Shelter(Integer id, String address, String webAddress, String email, String phoneNumber, String shelterName, String directorName, String comment) {
        this.id = id;
        this.address = address;
        this.webAddress = webAddress;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.shelterName = shelterName;
        this.directorName = directorName;
        this.comment = comment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebAddress() {
        return webAddress;
    }

    public void setWebAddress(String webAddress) {
        this.webAddress = webAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getShelterName() {
        return shelterName;
    }

    public void setShelterName(String shelterName) {
        this.shelterName = shelterName;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getDogId() {
        return dogId;
    }

    public void setDogId(Integer dogId) {
        this.dogId = dogId;
    }

    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
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
        if (!(object instanceof Shelter)) {
            return false;
        }
        Shelter other = (Shelter) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mancs_tars.model.Shelter[ id=" + id + " ]";
    }
    
}
