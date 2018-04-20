package com.syndicat.syndicats.entity;

import java.util.List;
import javax.persistence.*;


@Entity
@Table(name="roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String role;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    // constructors

    public Role() {

    }

    public Role(String role) {
        super();
        this.role = role;
    }

    // getters

    public Long getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public List<User> getUsers() {
        return users;
    }

    // setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }


}
