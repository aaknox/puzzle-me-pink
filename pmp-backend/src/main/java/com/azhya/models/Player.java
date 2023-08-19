package com.azhya.models;

import java.time.LocalDateTime;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table
@NamedQuery(name = "Player.findByEmail",
query = "select p from Player p where p.email = ?1")
@Data
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;
	
	@Column(name = "username", unique = true, nullable = false)
	private String username;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "first_name", nullable = false)
	private String first_name;
	
	@Column(name = "last_name", nullable = false)
	private String last_name;
	
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	
	@Column(name = "avatar")
	private byte[] avatar;
	
	@CreationTimestamp
	@Column(name = "join_date")
	private LocalDateTime joinDate;
	
	@Column(name = "active", nullable = false)
	private Boolean active;
	
	@Column(name = "verified", columnDefinition = "boolean default false")
	private Boolean verified;

	public Player() {
		super();
	}

	public Player(String username, String password, String first_name, String last_name, String email, byte[] avatar,
			LocalDateTime joinDate, Boolean active, Boolean verified) {
		super();
		this.username = username;
		this.password = password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.avatar = avatar;
		this.joinDate = joinDate;
		this.active = active;
		this.verified = verified;
	}

	public Player(Integer id, String username, String password, String first_name, String last_name, String email,
			byte[] avatar, LocalDateTime joinDate, Boolean active, Boolean verified) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.avatar = avatar;
		this.joinDate = joinDate;
		this.active = active;
		this.verified = verified;
	}
	
	
}