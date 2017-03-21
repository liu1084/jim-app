package com.jim.api.entities.blog;

import javax.persistence.*;

/**
 * Created by jim on 2017/3/21.
 * This class is ...
 */
@Entity
@Table(name = "user_role", schema = "blog", catalog = "")
public class blogUserRoleEntity {
	private int id;
	private long userId;
	private int roleId;

	@Id
	@Column(name = "id", nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	@Column(name = "role_id", nullable = false)
	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		blogUserRoleEntity that = (blogUserRoleEntity) o;

		if (id != that.id) return false;
		if (userId != that.userId) return false;
		if (roleId != that.roleId) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (int) (userId ^ (userId >>> 32));
		result = 31 * result + roleId;
		return result;
	}
}
