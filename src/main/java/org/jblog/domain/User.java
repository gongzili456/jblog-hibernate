package org.jblog.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "_users")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8513214846193903127L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true)
	private long id;

	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String password;
	@Column
	private String avatar;

	@Column(nullable = false)
	private Date registeDate;

	@Column
	private String introduction;

	// @ManyToMany(cascade=CascadeType.ALL)
	// @JoinTable(name = "_user_friends", joinColumns = { @JoinColumn(name =
	// "user_id", referencedColumnName = "id") },
	// inverseJoinColumns = { @JoinColumn(name = "fans_id", referencedColumnName
	// = "id") })
	// private Set<User> fans;
	//
	// @ManyToMany(cascade=CascadeType.ALL)
	// @JoinTable(name = "_user_friends", joinColumns = { @JoinColumn(name =
	// "fans_id", referencedColumnName = "id") },
	// inverseJoinColumns = { @JoinColumn(name = "user_id", referencedColumnName
	// = "id") })
	// private Set<User> follows;

	public User() {
	}

	public long getId() {
		return id;
	}

	@SuppressWarnings("unused")
	private void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Date getRegisteDate() {
		return registeDate;
	}

	public void setRegisteDate(Date registeDate) {
		this.registeDate = registeDate;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email
				+ ", password=" + password + ", avatar=" + avatar
				+ ", registeDate=" + registeDate + ", introduction="
				+ introduction + "]";
	}

}
