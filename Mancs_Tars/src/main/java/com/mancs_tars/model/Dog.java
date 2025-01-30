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
@Table(name = "dog")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dog.findAll", query = "SELECT d FROM Dog d"),
    @NamedQuery(name = "Dog.findById", query = "SELECT d FROM Dog d WHERE d.id = :id"),
    @NamedQuery(name = "Dog.findByName", query = "SELECT d FROM Dog d WHERE d.name = :name"),
    @NamedQuery(name = "Dog.findByBreed", query = "SELECT d FROM Dog d WHERE d.breed = :breed"),
    @NamedQuery(name = "Dog.findByAge", query = "SELECT d FROM Dog d WHERE d.age = :age"),
    @NamedQuery(name = "Dog.findByGender", query = "SELECT d FROM Dog d WHERE d.gender = :gender"),
    @NamedQuery(name = "Dog.findByKidsFriendly", query = "SELECT d FROM Dog d WHERE d.kidsFriendly = :kidsFriendly"),
    @NamedQuery(name = "Dog.findByApartmnetFriendly", query = "SELECT d FROM Dog d WHERE d.apartmnetFriendly = :apartmnetFriendly"),
    @NamedQuery(name = "Dog.findByTendencyToGainWeight", query = "SELECT d FROM Dog d WHERE d.tendencyToGainWeight = :tendencyToGainWeight"),
    @NamedQuery(name = "Dog.findByHealth", query = "SELECT d FROM Dog d WHERE d.health = :health"),
    @NamedQuery(name = "Dog.findByIntelligence", query = "SELECT d FROM Dog d WHERE d.intelligence = :intelligence"),
    @NamedQuery(name = "Dog.findByTedencytoEscape", query = "SELECT d FROM Dog d WHERE d.tedencytoEscape = :tedencytoEscape"),
    @NamedQuery(name = "Dog.findByPlayfulness", query = "SELECT d FROM Dog d WHERE d.playfulness = :playfulness"),
    @NamedQuery(name = "Dog.findByCatFriendly", query = "SELECT d FROM Dog d WHERE d.catFriendly = :catFriendly"),
    @NamedQuery(name = "Dog.findByEnergyLevel", query = "SELECT d FROM Dog d WHERE d.energyLevel = :energyLevel"),
    @NamedQuery(name = "Dog.findByUserId", query = "SELECT d FROM Dog d WHERE d.userId = :userId"),
    @NamedQuery(name = "Dog.findByShelterId", query = "SELECT d FROM Dog d WHERE d.shelterId = :shelterId"),
    @NamedQuery(name = "Dog.findByCatId", query = "SELECT d FROM Dog d WHERE d.catId = :catId")})
public class Dog implements Serializable {

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
    @Column(name = "age")
    private String age;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "gender")
    private String gender;
    @Basic(optional = false)
    @NotNull
    @Column(name = "kids_friendly")
    private int kidsFriendly;
    @Basic(optional = false)
    @NotNull
    @Column(name = "apartmnet_friendly")
    private int apartmnetFriendly;
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
    @Column(name = "tedency_to_Escape")
    private int tedencytoEscape;
    @Basic(optional = false)
    @NotNull
    @Column(name = "playfulness")
    private int playfulness;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cat_friendly")
    private int catFriendly;
    @Basic(optional = false)
    @NotNull
    @Column(name = "energy_level")
    private int energyLevel;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "dog_img")
    private String dogImg;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "shelter_id")
    private Integer shelterId;
    @Column(name = "cat_id")
    private Integer catId;

    public Dog() {
    }

    public Dog(Integer id) {
        this.id = id;
    }

    public Dog(Integer id, String name, String breed, String age, String gender, int kidsFriendly, int apartmnetFriendly, int tendencyToGainWeight, int health, int intelligence, int tedencytoEscape, int playfulness, int catFriendly, int energyLevel, String dogImg) {
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.gender = gender;
        this.kidsFriendly = kidsFriendly;
        this.apartmnetFriendly = apartmnetFriendly;
        this.tendencyToGainWeight = tendencyToGainWeight;
        this.health = health;
        this.intelligence = intelligence;
        this.tedencytoEscape = tedencytoEscape;
        this.playfulness = playfulness;
        this.catFriendly = catFriendly;
        this.energyLevel = energyLevel;
        this.dogImg = dogImg;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getKidsFriendly() {
        return kidsFriendly;
    }

    public void setKidsFriendly(int kidsFriendly) {
        this.kidsFriendly = kidsFriendly;
    }

    public int getApartmnetFriendly() {
        return apartmnetFriendly;
        
    }

    public void setApartmnetFriendly(int apartmnetFriendly) {
        this.apartmnetFriendly = apartmnetFriendly;
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

    public int getTedencytoEscape() {
        return tedencytoEscape;
    }

    public void setTedencytoEscape(int tedencytoEscape) {
        this.tedencytoEscape = tedencytoEscape;
    }

    public int getPlayfulness() {
        return playfulness;
    }

    public void setPlayfulness(int playfulness) {
        this.playfulness = playfulness;
    }

    public int getCatFriendly() {
        return catFriendly;
    }

    public void setCatFriendly(int catFriendly) {
        this.catFriendly = catFriendly;
    }

    public int getEnergyLevel() {
        return energyLevel;
    }

    public void setEnergyLevel(int energyLevel) {
        this.energyLevel = energyLevel;
    }

    public String getDogImg() {
        return dogImg;
    }

    public void setDogImg(String dogImg) {
        this.dogImg = dogImg;
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
        if (!(object instanceof Dog)) {
            return false;
        }
        Dog other = (Dog) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mancs_tars.model.Dog[ id=" + id + " ]";
    }
    
}
