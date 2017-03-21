package com.jim.api.entities.blog;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by jim on 2017/3/21.
 * This class is ...
 */
@Entity
@Table(name = "roles", schema = "blog", catalog = "")
public class blogRolesEntity {
	private int id;
	private String name;
	private String description;
	private String status;
	private Timestamp createAt;
	private Timestamp updateAt;

	@Id
	@Column(name = "id", nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Basic
	@Column(name = "name", nullable = false, length = 50)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Basic
	@Column(name = "description", nullable = false, length = 100)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
	@Column(name = "create_at", nullable = false)
	public Timestamp getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}

	@Basic
	@Column(name = "update_at", nullable = false)
	public Timestamp getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Timestamp updateAt) {
		this.updateAt = updateAt;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		blogRolesEntity that = (blogRolesEntity) o;

		if (id != that.id) return false;
		if (name != null ? !name.equals(that.name) : that.name != null) return false;
		if (description != null ? !description.equals(that.description) : that.description != null) return false;
		if (status != null ? !status.equals(that.status) : that.status != null) return false;
		if (createAt != null ? !createAt.equals(that.createAt) : that.createAt != null) return false;
		if (updateAt != null ? !updateAt.equals(that.updateAt) : that.updateAt != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (description != null ? description.hashCode() : 0);
		result = 31 * result + (status != null ? status.hashCode() : 0);
		result = 31 * result + (createAt != null ? createAt.hashCode() : 0);
		result = 31 * result + (updateAt != null ? updateAt.hashCode() : 0);
		return result;
	}
}
