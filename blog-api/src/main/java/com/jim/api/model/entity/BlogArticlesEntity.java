package com.jim.api.model.entity;

import com.jim.entity.impl.JPAIEntity;
import org.hibernate.annotations.Generated;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by jim on 2017/3/21.
 * This class is ...
 */
@Entity
@Table(name = "articles", schema = "blog")
public class BlogArticlesEntity extends JPAIEntity<Long> {
	private String title;
	private String content;
	private String background;
	private long userId;
	private ArticleStatus status;
	private String password;
	private int sticky;
	private int rating;
	private int parent;
	private ArticleCommentStatus commentStatus;
	private int commentCount;

	public enum ArticleStatus{
		PRIVATE(1), PUBLIC(2), DRAFT(3), DELETE(0);
		private int status;
		ArticleStatus(int i) {
			this.status = i;
		}

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}
	}

	public enum ArticleCommentStatus{
		CLOSE(0), OPEN(1);

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

		private int status;
		ArticleCommentStatus(int i) {
			this.status = i;
		}
	}

	@Basic
	@Column(name = "title", nullable = false, length = 255)
	@NotNull
	@NotBlank
	@NotEmpty
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Basic
	@NotNull
	@NotBlank
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
	public ArticleStatus getStatus() {
		return status;
	}

	public void setStatus(ArticleStatus status) {
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
	@Column(name = "rating")
	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Basic
	@JoinColumn(name = "parent")
	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}

	@Basic
	@Column(name = "comment_status", nullable = false, length = 30)
	public ArticleCommentStatus getCommentStatus() {
		return commentStatus;
	}

	public void setCommentStatus(ArticleCommentStatus commentStatus) {
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

	@Override
	public String toString() {
		return "BlogArticlesEntity{" +
				"title='" + title + '\'' +
				", content='" + content + '\'' +
				", background='" + background + '\'' +
				", userId=" + userId +
				", status=" + status +
				", password='" + password + '\'' +
				", sticky=" + sticky +
				", rating=" + rating +
				", parent=" + parent +
				", commentStatus=" + commentStatus +
				", commentCount=" + commentCount +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof BlogArticlesEntity)) return false;

		BlogArticlesEntity that = (BlogArticlesEntity) o;

		if (getUserId() != that.getUserId()) return false;
		if (getSticky() != that.getSticky()) return false;
		if (getRating() != that.getRating()) return false;
		if (getParent() != that.getParent()) return false;
		if (getCommentCount() != that.getCommentCount()) return false;
		if (!getTitle().equals(that.getTitle())) return false;
		if (!getContent().equals(that.getContent())) return false;
		if (getBackground() != null ? !getBackground().equals(that.getBackground()) : that.getBackground() != null)
			return false;
		if (getStatus() != that.getStatus()) return false;
		if (getPassword() != null ? !getPassword().equals(that.getPassword()) : that.getPassword() != null)
			return false;
		return getCommentStatus() == that.getCommentStatus();
	}

}
