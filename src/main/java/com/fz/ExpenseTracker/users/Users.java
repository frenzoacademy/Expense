//package com.fz.ExpenseTracker.users;
//
//import java.time.LocalDateTime;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.SequenceGenerator;
//
//@Entity
//public class Users {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
//	@SequenceGenerator(name = "user_generator", sequenceName = "users_seq", allocationSize = 1)
//	private int userId;
//	private String userName;
//	private String password;
//	private long mobile;
//	@Column(unique = true)
//	private String email;
////	private String role;
////	private String token;
//	@Column(columnDefinition = "TIMESTAMP")
//	private LocalDateTime tokenCreationDate;
//
//	public Users(int userId, String userName, String password, long mobile, String email,
//			LocalDateTime tokenCreationDate) {
//		super();
//		this.userId = userId;
//		this.userName = userName;
//		this.password = password;
//		this.mobile = mobile;
//		this.email = email;
//		this.tokenCreationDate = tokenCreationDate;
//	}
//
//	public Users() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	public int getUserId() {
//		return userId;
//	}
//
//	public void setUserId(int userId) {
//		this.userId = userId;
//	}
//
//	public String getUserName() {
//		return userName;
//	}
//
//	public void setUserName(String userName) {
//		this.userName = userName;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public long getMobile() {
//		return mobile;
//	}
//
//	public void setMobile(long mobile) {
//		this.mobile = mobile;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public LocalDateTime getTokenCreationDate() {
//		return tokenCreationDate;
//	}
//
//	public void setTokenCreationDate(LocalDateTime tokenCreationDate) {
//		this.tokenCreationDate = tokenCreationDate;
//	}
//
//}
