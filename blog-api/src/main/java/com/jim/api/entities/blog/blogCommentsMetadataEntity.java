package com.jim.api.entities.blog;

import javax.persistence.*;

/**
 * Created by jim on 2017/3/21.
 * This class is ...
 */
@Entity
@Table(name = "comments_metadata", schema = "blog", catalog = "")
public class BlogCommentsMetadataEntity {
	private long id;
	private long commentId;
	private String key;
	private String value;

	@Id
	@Column(name = "id", nullable = false)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Basic
	@Column(name = "commentId", nullable = false)
	public long getCommentId() {
		return commentId;
	}

	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}

	@Basic
	@Column(name = "key", nullable = false, length = 50)
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Basic
	@Column(name = "value", nullable = false, length = -1)
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		BlogCommentsMetadataEntity that = (BlogCommentsMetadataEntity) o;

		if (id != that.id) return false;
		if (commentId != that.commentId) return false;
		if (key != null ? !key.equals(that.key) : that.key != null) return false;
		if (value != null ? !value.equals(that.value) : that.value != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = (int) (id ^ (id >>> 32));
		result = 31 * result + (int) (commentId ^ (commentId >>> 32));
		result = 31 * result + (key != null ? key.hashCode() : 0);
		result = 31 * result + (value != null ? value.hashCode() : 0);
		return result;
	}
}
