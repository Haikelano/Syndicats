package com.syndicat.syndicats.entity;

import org.hibernate.SessionFactory;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
import com.syndicat.syndicats.entity.Role;
@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @Size(min = 3,max = 200, message = "Login cannot be blank .")
    private String login;
    private String nom;
    private String prenom;
    private String dateNaissence;
    @Email(message = "Invalid email format . EX: user@user.com")
    private String email;
    private long tel;
    private String photo;
    private String password;
    @Column(name = "active")
    @ColumnDefault(value = "1")
    private int active;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;
    public User() {

    }

    public User(String nom, String login, String prenom, String dateNaissence, String email, long tel, String photo, String password, int active, List<Role> roles) {
        super();
        this.active = active;
        this.roles = roles;
        this.login = login;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissence = dateNaissence;
        this.email = email;
        this.tel = tel;
        this.photo = photo;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDateNaissence() {
        return dateNaissence;
    }

    public void setDateNaissence(String dateNaissence) {
        this.dateNaissence = dateNaissence;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getTel() {
        return tel;
    }

    public void setTel(long tel) {
        this.tel = tel;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }




    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", dateNaissence='" + dateNaissence + '\'' +
                ", email='" + email + '\'' +
                ", tel=" + tel +
                ", photo='" + photo + '\'' +
                ", password='" + password + '\'' +
                ", active=" + active +
                ", roles=" + roles +
                '}';
    }
}