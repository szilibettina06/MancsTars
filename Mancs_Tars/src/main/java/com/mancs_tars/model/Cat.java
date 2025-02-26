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
@Table(name = "cat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cat.findAll", query = "SELECT c FROM Cat c"),
    @NamedQuery(name = "Cat.findById", query = "SELECT c FROM Cat c WHERE c.id = :id"),
    @NamedQuery(name = "Cat.findByName", query = "SELECT c FROM Cat c WHERE c.name = :name"),
    @NamedQuery(name = "Cat.findByBreed", query = "SELECT c FROM Cat c WHERE c.breed = :breed"),
    @NamedQuery(name = "Cat.findByGender", query = "SELECT c FROM Cat c WHERE c.gender = :gender"),
    @NamedQuery(name = "Cat.findByAge", query = "SELECT c FROM Cat c WHERE c.age = :age"),
    @NamedQuery(name = "Cat.findByKidsFriendly", query = "SELECT c FROM Cat c WHERE c.kidsFriendly = :kidsFriendly"),
    @NamedQuery(name = "Cat.findByApartmentFriendly", query = "SELECT c FROM Cat c WHERE c.apartmentFriendly = :apartmentFriendly"),
    @NamedQuery(name = "Cat.findByTendencyToGainWeight", query = "SELECT c FROM Cat c WHERE c.tendencyToGainWeight = :tendencyToGainWeight"),
    @NamedQuery(name = "Cat.findByHealth", query = "SELECT c FROM Cat c WHERE c.health = :health"),
    @NamedQuery(name = "Cat.findByIntelligence", query = "SELECT c FROM Cat c WHERE c.intelligence = :intelligence"),
    @NamedQuery(name = "Cat.findByTendencytoEscape", query = "SELECT c FROM Cat c WHERE c.tendencytoEscape = :tendencytoEscape"),
    @NamedQuery(name = "Cat.findByPlayfulness", query = "SELECT c FROM Cat c WHERE c.playfulness = :playfulness"),
    @NamedQuery(name = "Cat.findByDogFriendly", query = "SELECT c FROM Cat c WHERE c.dogFriendly = :dogFriendly"),
    @NamedQuery(name = "Cat.findByRateOfHairLoss", query = "SELECT c FROM Cat c WHERE c.rateOfHairLoss = :rateOfHairLoss"),
    @NamedQuery(name = "Cat.findByEnergyLevel", query = "SELECT c FROM Cat c WHERE c.energyLevel = :energyLevel"),
    @NamedQuery(name = "Cat.findByUserId", query = "SELECT c FROM Cat c WHERE c.userId = :userId"),
    @NamedQuery(name = "Cat.findByShelterId", query = "SELECT c FROM Cat c WHERE c.shelterId = :shelterId"),
    @NamedQuery(name = "Cat.findByDogId", query = "SELECT c FROM Cat c WHERE c.dogId = :dogId")})
public class Cat implements Serializable {

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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "breed")
    private String breed;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "gender")
    private String gender;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "age")
    private String age;
    @Basic(optional = false)
    @NotNull
    @Column(name = "kids_friendly")
    private int kidsFriendly;
    @Basic(optional = false)
    @NotNull
    @Column(name = "apartment_friendly")
    private int apartmentFriendly;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tendency_to_gain_weight")
    private int tendencyToGainWeight;
    @Basic(optional = false)
    @NotNull
    @Column(name = "health")
    private int health;
    @Basic(optional = false)
    @NotNull
    @Column(name = "intelligence")
    private int intelligence;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tendency_to_Escape")
    private int tendencytoEscape;
    @Basic(optional = false)
    @NotNull
    @Column(name = "playfulness")
    private int playfulness;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dog_friendly")
    private int dogFriendly;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rate_of_hair_loss")
    private int rateOfHairLoss;
    @Basic(optional = false)
    @NotNull
    @Column(name = "energy_level")
    private int energyLevel;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "cat_img")
    private String catImg;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "shelter_id")
    private Integer shelterId;
    @Column(name = "dog_id")
    private Integer dogId;

    public Cat() {
    }

    public Cat(Integer id) {
        this.id = id;
    }

    public Cat(Integer id, String name, String breed, String gender, String age, int kidsFriendly, int apartmentFriendly, int tendencyToGainWeight, int health, int intelligence, int tendencytoEscape, int playfulness, int dogFriendly, int rateOfHairLoss, int energyLevel, String catImg) {
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.gender = gender;
        this.age = age;
        this.kidsFriendly = kidsFriendly;
        this.apartmentFriendly = apartmentFriendly;
        this.tendencyToGainWeight = tendencyToGainWeight;
        this.health = health;
        this.intelligence = intelligence;
        this.tendencytoEscape = tendencytoEscape;
        this.playfulness = playfulness;
        this.dogFriendly = dogFriendly;
        this.rateOfHairLoss = rateOfHairLoss;
        this.energyLevel = energyLevel;
        this.catImg = catImg;
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

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getKidsFriendly() {
        return kidsFriendly;
    }

    public void setKidsFriendly(int kidsFriendly) {
        this.kidsFriendly = kidsFriendly;
    }

    public int getApartmentFriendly() {
        return apartmentFriendly;
    }

    public void setApartmentFriendly(int apartmentFriendly) {
        this.apartmentFriendly = apartmentFriendly;
    }

    public int getTendencyToGainWeight() {
        return tendencyToGainWeight;
    }

    public void setTendencyToGainWeight(int tendencyToGainWeight) {
        this.tendencyToGainWeight = tendencyToGainWeight;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getTendencytoEscape() {
        return tendencytoEscape;
    }

    public void setTendencytoEscape(int tendencytoEscape) {
        this.tendencytoEscape = tendencytoEscape;
    }

    public int getPlayfulness() {
        return playfulness;
    }

    public void setPlayfulness(int playfulness) {
        this.playfulness = playfulness;
    }

    public int getDogFriendly() {
        return dogFriendly;
    }

    public void setDogFriendly(int dogFriendly) {
        this.dogFriendly = dogFriendly;
    }

    public int getRateOfHairLoss() {
        return rateOfHairLoss;
    }

    public void setRateOfHairLoss(int rateOfHairLoss) {
        this.rateOfHairLoss = rateOfHairLoss;
    }

    public int getEnergyLevel() {
        return energyLevel;
    }

    public void setEnergyLevel(int energyLevel) {
        this.energyLevel = energyLevel;
    }

    public String getCatImg() {
        return catImg;
    }

    public void setCatImg(String catImg) {
        this.catImg = catImg;
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

    public Integer getDogId() {
        return dogId;
    }

    public void setDogId(Integer dogId) {
        this.dogId = dogId;
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
        if (!(object instanceof Cat)) {
            return false;
        }
        Cat other = (Cat) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mancs_tars.model.Cat[ id=" + id + " ]";
    }
    
}
