package org.jblog.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "_user_article_group")
// 转换成json的时候， 忽略这些属性
@JsonIgnoreProperties(value = { "user" })
public class ArticleGroup implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -507242186952460911L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true)
	private long id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@Column
	private String name;

	public long getId() {
		return id;
	}

	@SuppressWarnings("unused")
	private void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ArticleGroup [id=" + id + ", user=" + user + ", name=" + name
				+ "]";
	}

}
