package com.jim.api.entities.blog;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by jim on 2017/3/21.
 * This class is ...
 */
@Entity
@Table(name = "users", schema = "blog", catalog = "")
public class BlogUsersEntity {
	private long id;
	private String name;
	private String password;
	private String email;
	private String avatar;
	private String nickname;
	private String url;
	private String rememberToken;
	private String activationKey;
	private String status;
	private String onlineStatus;
	private String feeling;
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
	@Column(name = "name", nullable = false, length = 100)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Basic
	@Column(name = "password", nullable = false, length = 255)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Basic
	@Column(name = "email", nullable = false, length = 100)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Basic
	@Column(name = "avatar", nullable = false, length = 100)
	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	@Basic
	@Column(name = "nickname", nullable = false, length = 100)
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Basic
	@Column(name = "url", nullable = false, length = 300)
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Basic
	@Column(name = "remember_token", nullable = false, length = 100)
	public String getRememberToken() {
		return rememberToken;
	}

	public void setRememberToken(String rememberToken) {
		this.rememberToken = rememberToken;
	}

	@Basic
	@Column(name = "activation_key", nullable = false, length = 100)
	public String getActivationKey() {
		return activationKey;
	}

	public void setActivationKey(String activationKey) {
		this.activationKey = activationKey;
	}

	@Basic
	@Column(name = "status", nullable = false, length = 10)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Basic
	@Column(name = "online_status", nullable = false, length = 10)
	public String getOnlineStatus() {
		return onlineStatus;
	}

	public void setOnlineStatus(String onlineStatus) {
		this.onlineStatus = onlineStatus;
	}

	@Basic
	@Column(name = "feeling", nullable = false, length = 100)
	public String getFeeling() {
		return feeling;
	}

	public void setFeeling(String feeling) {
		this.feeling = feeling;
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

		BlogUsersEntity that = (BlogUsersEntity) o;

		if (id != that.id) return false;
		if (name != null ? !name.equals(that.name) : that.name != null) return false;
		if (password != null ? !password.equals(that.password) : that.password != null) return false;
		if (email != null ? !email.equals(that.email) : that.email != null) return false;
		if (avatar != null ? !avatar.equals(that.avatar) : that.avatar != null) return false;
		if (nickname != null ? !nickname.equals(that.nickname) : that.nickname != null) return false;
		if (url != null ? !url.equals(that.url) : that.url != null) return false;
		if (rememberToken != null ? !rememberToken.equals(that.rememberToken) : that.rememberToken != null)
			return false;
		if (activationKey != null ? !activationKey.equals(that.activationKey) : that.activationKey != null)
			return false;
		if (status != null ? !status.equals(that.status) : that.status != null) return false;
		if (onlineStatus != null ? !onlineStatus.equals(that.onlineStatus) : that.onlineStatus != null) return false;
		if (feeling != null ? !feeling.equals(that.feeling) : that.feeling != null) return false;
		if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
		if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = (int) (id ^ (id >>> 32));
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (password != null ? password.hashCode() : 0);
		result = 31 * result + (email != null ? email.hashCode() : 0);
		result = 31 * result + (avatar != null ? avatar.hashCode() : 0);
		result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
		result = 31 * result + (url != null ? url.hashCode() : 0);
		result = 31 * result + (rememberToken != null ? rememberToken.hashCode() : 0);
		result = 31 * result + (activationKey != null ? activationKey.hashCode() : 0);
		result = 31 * result + (status != null ? status.hashCode() : 0);
		result = 31 * result + (onlineStatus != null ? onlineStatus.hashCode() : 0);
		result = 31 * result + (feeling != null ? feeling.hashCode() : 0);
		result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
		result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
		return result;
	}
}
