/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mancs_tars.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;
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
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id"),
    @NamedQuery(name = "User.findByFirstName", query = "SELECT u FROM User u WHERE u.firstName = :firstName"),
    @NamedQuery(name = "User.findByLastName", query = "SELECT u FROM User u WHERE u.lastName = :lastName"),
    @NamedQuery(name = "User.findByAge", query = "SELECT u FROM User u WHERE u.age = :age"),
    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
    @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password"),
    @NamedQuery(name = "User.findByPhoneNumber", query = "SELECT u FROM User u WHERE u.phoneNumber = :phoneNumber")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "first_name")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "last_name")
    private String lastName;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "age")
    private int age;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "phone_number")
    private String phoneNumber;
      @Basic(optional = false)
    @NotNull
    @Column(name = "is_admin")
    private boolean isAdmin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_deleted")
    private boolean isDeleted;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "deleted_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedAt;

    static EntityManagerFactory emf= Persistence.createEntityManagerFactory("com_Mancs_Tars_war_1.0-SNAPPU");
    public User() {
    }

    public User(Integer id) {
        EntityManager em = emf.createEntityManager();

        try {
            User u = em.find(User.class, id);

            this.id = u.getId();
            this.email = u.getEmail();
            this.phoneNumber = u.getPhoneNumber();
            this.firstName = u.getFirstName();
            this.lastName = u.getLastName();
            this.password = u.getPassword();
            this.isAdmin = u.getIsAdmin();
            this.isDeleted = u.getIsDeleted();
            this.createdAt = u.getCreatedAt();
        } catch (Exception ex) {
            System.err.println("Hiba: " + ex.getLocalizedMessage());
        } finally {
            em.clear();
            em.close();
        }
    }

    public User(Integer id, String firstName, String lastName, int age, String email, String password, String phoneNumber, boolean isAdmin, boolean isDeleted, Date createdAt, Date deletedAt) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.isAdmin = isAdmin;
        this.isDeleted = isDeleted;
        this.createdAt = createdAt;
        this.deletedAt = deletedAt;
    }
    public User(String email, String phoneNumber, String firstName, String lastName, String password) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    private User(Integer valueOf, String toString, String toString0, String toString1, String toString2, String toString3, boolean parseBoolean, boolean parseBoolean0, Date parse, Date date, Date date0, Date date1, Date date2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private User(Integer valueOf, String toString, String toString0, String toString1, String toString2, String toString3, boolean parseBoolean, boolean parseBoolean0, Date parse, Date date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



   
    //----------------------------------------------------
    //setterek
    public void setId(Integer id) {
        this.id = id;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
     public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
      public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
     public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }
    //----------------------------------------------------
    //getterek
     public Integer getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getAge() {
        return age;
    }
    public boolean getIsAdmin() {
        return isAdmin;
    }
    public boolean getIsDeleted() {
        return isDeleted;
    }
    public Date getCreatedAt() {
        return createdAt;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
      public Date getDeletedAt() {
        return deletedAt;
    }
//------------------------------------------------------
    

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
        return "com.mancs_tars.model.User[ id=" + id + " ]";
    }

    public User login(String email, String password) {
        EntityManager em = emf.createEntityManager();

        try {
            StoredProcedureQuery spq = em.createStoredProcedureQuery("login");
            
            spq.registerStoredProcedureParameter("emailIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("passwordIN", String.class, ParameterMode.IN);
            
            spq.setParameter("emailIN", email);
            spq.setParameter("passwordIN", password);
            
            spq.execute();
            
            List<Object[]> resultList = spq.getResultList();
            User toReturn = new User();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            for(Object[] o : resultList){
                User u = new User(
                        Integer.valueOf(o[0].toString()),
                        o[1].toString(),
                        o[2].toString(),
                        o[3].toString(),
                        o[4].toString(),
                        o[5].toString(),
                        Boolean.parseBoolean(o[6].toString()),
                        Boolean.parseBoolean(o[7].toString()),
                        formatter.parse(o[8].toString()),
                        o[9] == null ? null : formatter.parse(o[9].toString())
                );
                toReturn = u;
            }
            
            return toReturn;
            
        } catch (NumberFormatException | ParseException e) {
            System.err.println("Hiba: " + e.getLocalizedMessage());
            return null;
        } finally {
            em.clear();
            em.close();
        }
    }
        public Boolean registerUser(User u) {
        EntityManager em = emf.createEntityManager();
        
        try {
            StoredProcedureQuery spq = em.createStoredProcedureQuery("registerUser");
            
            spq.registerStoredProcedureParameter("emailIn", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("phoneNumberIn", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("firstNameIn", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("lastNameIn", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("passwordIn", String.class, ParameterMode.IN);
            
            spq.setParameter("emailIn", u.getEmail());
            spq.setParameter("phoneNumberIn", u.getPhoneNumber());
            spq.setParameter("firstNameIn", u.getFirstName());
            spq.setParameter("lastNameIn", u.getLastName());
            spq.setParameter("passwordIn", u.getPassword());
            
            spq.execute();
            
            return true;
        } catch (Exception e) {
            System.err.println("Hiba: " + e.getLocalizedMessage());
            return false;
        } finally {
            em.clear();
            em.close();
        }
    }
    
    public static Boolean isUserExists(String email){
        EntityManager em = emf.createEntityManager();
        
        try {
            StoredProcedureQuery spq = em.createStoredProcedureQuery("isUserExists");
            
            spq.registerStoredProcedureParameter("emailIn", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("resultOut", Boolean.class, ParameterMode.OUT);
            
            spq.setParameter("emailIn", email);
            
            spq.execute();
            
            Boolean result = Boolean.valueOf(spq.getOutputParameterValue("resultOut").toString());
            
            return result;
        } catch (Exception e) {
            System.err.println("Hiba: " + e.getLocalizedMessage());
            return null;
        } finally {
            em.clear();
            em.close();
        }
    }
    
    public Boolean registerAdmin(User u) {
        EntityManager em = emf.createEntityManager();
        
        try {
            StoredProcedureQuery spq = em.createStoredProcedureQuery("registerAdmin");
            
            spq.registerStoredProcedureParameter("emailIn", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("phoneNumberIn", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("firstNameIn", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("lastNameIn", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("passwordIn", String.class, ParameterMode.IN);
            
            spq.setParameter("emailIn", u.getEmail());
            spq.setParameter("phoneNumberIn", u.getPhoneNumber());
            spq.setParameter("firstNameIn", u.getFirstName());
            spq.setParameter("lastNameIn", u.getLastName());
            spq.setParameter("passwordIn", u.getPassword());
            
            spq.execute();
            
            return true;
        } catch (Exception e) {
            System.err.println("Hiba: " + e.getLocalizedMessage());
            return false;
        } finally {
            em.clear();
            em.close();
        }
    }
    public static List<User> getAllUser() {
        EntityManager em = emf.createEntityManager();
        List<User> userList = null;
        
        try {
            StoredProcedureQuery spq = em.createStoredProcedureQuery("getAllUser");
            spq.execute();
            
            List<User>toReturn=new ArrayList();
            List<Object[]>resultList =spq.getResultList();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            for(Object[] record : resultList){
                User u =new User(
                         Integer.valueOf(record[0].toString()),
                        record[1].toString(),
                        record[2].toString(),
                        record[3].toString(),
                        record[4].toString(),
                        record[5].toString(),
                        Boolean.parseBoolean(record[6].toString()),
                        Boolean.parseBoolean(record[7].toString()),
                        formatter.parse(record[8].toString()),
                        record[6] == null ? null : formatter.parse(record[6].toString()),
                        record[7] == null ? null : formatter.parse(record[7].toString()),
                        record[8] == null ? null : formatter.parse(record[8].toString()),
                        record[9] == null ? null : formatter.parse(record[9].toString())

                );
                toReturn.add(u);
            }
            
            return toReturn;
        } catch (Exception e) {
            System.err.println("Hiba: " + e.getLocalizedMessage());
            return null;
        } finally {
            em.clear();
            em.close();
        }
    }

    
}
