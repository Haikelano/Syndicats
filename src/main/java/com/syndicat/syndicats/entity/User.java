package com.syndicat.syndicats.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String nom;
    private String prenom;
    private String dateNaissence;
    private String email;
    private long tel;
    private String photo;


    public User()
    {

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public User(String nom, String prenom, String dateNaissence, String email, long tel, String photo) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissence = dateNaissence;
        this.email = email;
        this.tel = tel;
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "User{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", dateNaissence='" + dateNaissence + '\'' +
                ", email='" + email + '\'' +
                ", tel=" + tel +
                ", photo='" + photo + '\'' +
                '}';
    }
}
