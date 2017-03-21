package com.jim.api.entities.blog;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by jim on 2017/3/21.
 * This class is ...
 */
@Entity
@Table(name = "articles", schema = "blog", catalog = "")
public class blogArticlesEntity {
	private long id;
	private String title;
	private String content;
	private String background;
	private long userId;
	private String status;
	private String password;
	private int sticky;
	private byte rating;
	private long parent;
	private String commentStatus;
	private int commentCount;
	private Timestamp createdAt;
	private Timestamp updatedAt;

	@Id
	@Column(name = "id", nullable = false)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Basic
	@Column(name = "title", nullable = false, length = 255)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Basic
	@Column(name = "content", nullable = false, length = -1)
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Basic
	@Column(name = "background", nullable = false, length = 300)
	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	@Basic
	@Column(name = "user_id", nullable = false)
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	@Basic
	@Column(name = "status", nullable = false, length = 30)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Basic
	@Column(name = "password", nullable = false, length = 32)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Basic
	@Column(name = "sticky", nullable = false)
	public int getSticky() {
		return sticky;
	}

	public void setSticky(int sticky) {
		this.sticky = sticky;
	}

	@Basic
	@Column(name = "rating", nullable = false)
	public byte getRating() {
		return rating;
	}

	public void setRating(byte rating) {
		this.rating = rating;
	}

	@Basic
	@Column(name = "parent", nullable = false)
	public long getParent() {
		return parent;
	}

	public void setParent(long parent) {
		this.parent = parent;
	}

	@Basic
	@Column(name = "comment_status", nullable = false, length = 30)
	public String getCommentStatus() {
		return commentStatus;
	}

	public void setCommentStatus(String commentStatus) {
		this.commentStatus = commentStatus;
	}

	@Basic
	@Column(name = "comment_count", nullable = false)
	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	@Basic
	@Column(name = "created_at", nullable = false)
	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	@Basic
	@Column(name = "updated_at", nullable = false)
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		blogArticlesEntity that = (blogArticlesEntity) o;

		if (id != that.id) return false;
		if (userId != that.userId) return false;
		if (sticky != that.sticky) return false;
		if (rating != that.rating) return false;
		if (parent != that.parent) return false;
		if (commentCount != that.commentCount) return false;
		if (title != null ? !title.equals(that.title) : that.title != null) return false;
		if (content != null ? !content.equals(that.content) : that.content != null) return false;
		if (background != null ? !background.equals(that.background) : that.background != null) return false;
		if (status != null ? !status.equals(that.status) : that.status != null) return false;
		if (password != null ? !password.equals(that.password) : that.password != null) return false;
		if (commentStatus != null ? !commentStatus.equals(that.commentStatus) : that.commentStatus != null)
			return false;
		if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
		if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = (int) (id ^ (id >>> 32));
		result = 31 * result + (title != null ? title.hashCode() : 0);
		result = 31 * result + (content != null ? content.hashCode() : 0);
		result = 31 * result + (background != null ? background.hashCode() : 0);
		result = 31 * result + (int) (userId ^ (userId >>> 32));
		result = 31 * result + (status != null ? status.hashCode() : 0);
		result = 31 * result + (password != null ? password.hashCode() : 0);
		result = 31 * result + sticky;
		result = 31 * result + (int) rating;
		result = 31 * result + (int) (parent ^ (parent >>> 32));
		result = 31 * result + (commentStatus != null ? commentStatus.hashCode() : 0);
		result = 31 * result + commentCount;
		result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
		result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
		return result;
	}
}
