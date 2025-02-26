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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rkczi
 */
@Entity
@Table(name = "shelter_worker")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ShelterWorker.findAll", query = "SELECT s FROM ShelterWorker s"),
    @NamedQuery(name = "ShelterWorker.findById", query = "SELECT s FROM ShelterWorker s WHERE s.id = :id"),
    @NamedQuery(name = "ShelterWorker.findByName", query = "SELECT s FROM ShelterWorker s WHERE s.name = :name"),
    @NamedQuery(name = "ShelterWorker.findByEmail", query = "SELECT s FROM ShelterWorker s WHERE s.email = :email"),
    @NamedQuery(name = "ShelterWorker.findByPhoneNumber", query = "SELECT s FROM ShelterWorker s WHERE s.phoneNumber = :phoneNumber"),
    @NamedQuery(name = "ShelterWorker.findByJobPosition", query = "SELECT s FROM ShelterWorker s WHERE s.jobPosition = :jobPosition"),
    @NamedQuery(name = "ShelterWorker.findByStartDate", query = "SELECT s FROM ShelterWorker s WHERE s.startDate = :startDate"),
    @NamedQuery(name = "ShelterWorker.findByShelterId", query = "SELECT s FROM ShelterWorker s WHERE s.shelterId = :shelterId")})
public class ShelterWorker implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "phone_number")
    private String phoneNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "job_position")
    private String jobPosition;
    @Basic(optional = false)
    @NotNull
    @Column(name = "start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "shelter_id")
    private int shelterId;

    public ShelterWorker() {
    }

    public ShelterWorker(Integer id) {
        this.id = id;
    }

    public ShelterWorker(Integer id, String name, String email, String phoneNumber, String jobPosition, Date startDate, int shelterId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.jobPosition = jobPosition;
        this.startDate = startDate;
        this.shelterId = shelterId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getShelterId() {
        return shelterId;
    }

    public void setShelterId(int shelterId) {
        this.shelterId = shelterId;
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
        if (!(object instanceof ShelterWorker)) {
            return false;
        }
        ShelterWorker other = (ShelterWorker) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mancs_tars.model.ShelterWorker[ id=" + id + " ]";
    }
    
}
