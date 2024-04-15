package com.fz.ExpenseTracker.company;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private int id;
    
    @Column(name="name")
    private String name;
    @Column(name="legalName")
    
    private String legalName;
    @Column(name="type")
    private String type;
    @Column(name="email")
    private String email;
    @Column(name="phoneNumber")
    private String phoneNumber;
    @Column(name="address")
    private String address;
//    @OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "currency")
    private String currency;
    
    // Constructors
    public Company() {
    }

    public Company(String name, String legalName, String type, String email, String phoneNumber, String address, String currency) {
        this.name = name;
        this.legalName = legalName;
        this.type = type;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.currency = currency;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLegalName() {
		return legalName;
	}

	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

}
