package com.azhya.models;

import java.time.LocalDateTime;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table
@Data
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private int id;
	
	@Column(name = "username", unique = true, nullable = false)
	private String username;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "first_name", nullable = false)
	private String fname;
	
	@Column(name = "last_name", nullable = false)
	private String lname;
	
	@Column(name = "avatar")
	private byte[] avatar;
	
	@Column(name = "join_date", nullable = false)
	private LocalDateTime joinDate;
	
	@Column(name = "active", nullable = false)
	private boolean active;
	
	@Column(name = "verified", columnDefinition = "boolean default false")
	private boolean verified;

	public Player() {
		super();
	}

	public Player(String username, String password, String fname, String lname, LocalDateTime joinDate,
			boolean active, byte[] avatar) {
		super();
		this.username = username;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		this.avatar = avatar;
		this.joinDate = joinDate;
		this.active = active;
	}

	public Player(int id, String username, String password, String fname, String lname,
			LocalDateTime joinDate, boolean active, byte[] avatar) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		this.avatar = avatar;
		this.joinDate = joinDate;
		this.active = active;
	}
}