package com.jim.api.entities.blog;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by jim on 2017/3/22.
 * This class is ...
 */
@Entity
@Table(name = "sessions", schema = "blog", catalog = "")
public class BlogSessionsEntity {
	private String id;
	private Integer userId;
	private String ipAddress;
	private String userAgent;
	private String payload;
	private int lastActivity;

	@Basic
	@Column(name = "id", nullable = false, length = 255)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Basic
	@Column(name = "user_id", nullable = true)
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Basic
	@Column(name = "ip_address", nullable = true, length = 45)
	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	@Basic
	@Column(name = "user_agent", nullable = true, length = -1)
	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	@Basic
	@Column(name = "payload", nullable = false, length = -1)
	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

	@Basic
	@Column(name = "last_activity", nullable = false)
	public int getLastActivity() {
		return lastActivity;
	}

	public void setLastActivity(int lastActivity) {
		this.lastActivity = lastActivity;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		BlogSessionsEntity that = (BlogSessionsEntity) o;

		if (lastActivity != that.lastActivity) return false;
		if (id != null ? !id.equals(that.id) : that.id != null) return false;
		if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
		if (ipAddress != null ? !ipAddress.equals(that.ipAddress) : that.ipAddress != null) return false;
		if (userAgent != null ? !userAgent.equals(that.userAgent) : that.userAgent != null) return false;
		if (payload != null ? !payload.equals(that.payload) : that.payload != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (userId != null ? userId.hashCode() : 0);
		result = 31 * result + (ipAddress != null ? ipAddress.hashCode() : 0);
		result = 31 * result + (userAgent != null ? userAgent.hashCode() : 0);
		result = 31 * result + (payload != null ? payload.hashCode() : 0);
		result = 31 * result + lastActivity;
		return result;
	}
}
