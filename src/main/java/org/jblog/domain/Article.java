package org.jblog.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "_articles")
@JsonIgnoreProperties(value = { "group", "collectUsers", "author" })
@DynamicUpdate(true)
@SelectBeforeUpdate(true)
public class Article implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8307907694937453507L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true, updatable = false)
	private Long id;

	@Column(nullable = false)
	private String title;
	@Column(nullable = false)
	@Type(type = "text")
	private String content;

	@Column(name = "excerpt")
	private String desc;

	@Column(name = "word_count", columnDefinition = "int default 0")
	private int wordCount = 0;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "group_id", nullable = false, updatable = false)
	private ArticleGroup group;

	@Column(nullable = false, updatable = false)
	private Date createTime;
	@Column(nullable = false)
	private Date modifyTime;

	@Column(columnDefinition = "int default 1")
	private int status = 1;

	@Column(columnDefinition = "int default 1")
	private int type = 1;
	@Column(columnDefinition = "int default 0")
	private int commentCount = 0;

	@Column(columnDefinition = "int default 0")
	private int collectCount = 0;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "_article_user_collect", joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "id", updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "article_id", referencedColumnName = "id", updatable = false) })
	private Set<User> collectUsers = new HashSet<User>();

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "author_id", updatable = false)
	private User author = new User();

	public Long getId() {
		return id;
	}

	@SuppressWarnings("unused")
	private void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return createTime == null ? new Date() : createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return modifyTime == null ? new Date() : modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public int getCollectCount() {
		return collectCount;
	}

	public void setCollectCount(int collectCount) {
		this.collectCount = collectCount;
	}

	public Set<User> getCollectUsers() {
		return collectUsers;
	}

	public void setCollectUsers(Set<User> collectUsers) {
		this.collectUsers = collectUsers;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public ArticleGroup getGroup() {
		return group;
	}

	public void setGroup(ArticleGroup group) {
		this.group = group;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getWordCount() {
		return wordCount;
	}

	public void setWordCount(int wordCount) {
		this.wordCount = wordCount;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", content="
				+ content + ", desc=" + desc + ", wordCount=" + wordCount
				+ ", group=" + group + ", createTime=" + createTime
				+ ", modifyTime=" + modifyTime + ", status=" + status
				+ ", type=" + type + ", commentCount=" + commentCount
				+ ", collectCount=" + collectCount + ", collectUsers="
				+ collectUsers + ", author=" + author + "]";
	}

}
