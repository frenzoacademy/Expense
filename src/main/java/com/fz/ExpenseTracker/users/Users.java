package com.fz.ExpenseTracker.users;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fz.ExpenseTracker.category.Category;
import com.fz.ExpenseTracker.role.Roles;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Users {
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private int id;
	    private String firstName;
	    private String lastName;
	    private String password;
	    private String mobile;
	    @Column(unique = true)
	    private String email;

	    // Keep role as an int for JSON mapping
	    private String role;

	    @ManyToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name = "role_id")
	    private Roles roleEntity;

	    public Users() {
	        super();
	    }

	    public Users(int id, String firstName, String lastName, String password, String mobile, String email) {
	        super();
	        this.id = id;
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.password = password;
	        this.mobile = mobile;
	        this.email = email;
	    }

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getFirstName() {
	        return firstName;
	    }

	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }

	    public String getLastName() {
	        return lastName;
	    }

	    public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public String getMobile() {
	        return mobile;
	    }

	    public void setMobile(String string) {
	        this.mobile = string;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getRole() {
	        return role;
	    }

	    public void setRole(String role) {
	        this.role = role;
	    }

	    public Roles getRoleEntity() {
	        return roleEntity;
	    }

	    public void setRoleEntity(Roles roleEntity) {
	        this.roleEntity = roleEntity;
	    }
	
}
