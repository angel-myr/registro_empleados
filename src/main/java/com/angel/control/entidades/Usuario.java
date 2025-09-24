package com.angel.control.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "userdetail")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long user_id;
    private String username;
    private String password;
    private String roles;
    public long getUser_id() {
        return user_id;
    }
    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getRoles() {
        return roles;
    }
    public void setRoles(String roles) {
        this.roles = roles;
    }

    public Usuario() {
        // TODO Auto-generated constructor stub
    }
    public Usuario(String username, String password, String roles) {
        super();
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

}