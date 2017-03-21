package com.jim.api.entities.blog;

import javax.persistence.*;

/**
 * Created by jim on 2017/3/21.
 * This class is ...
 */
@Entity
@Table(name = "migrations", schema = "blog", catalog = "")
public class blogMigrationsEntity {
	private int id;
	private String migration;
	private int batch;

	@Id
	@Column(name = "id", nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Basic
	@Column(name = "migration", nullable = false, length = 255)
	public String getMigration() {
		return migration;
	}

	public void setMigration(String migration) {
		this.migration = migration;
	}

	@Basic
	@Column(name = "batch", nullable = false)
	public int getBatch() {
		return batch;
	}

	public void setBatch(int batch) {
		this.batch = batch;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		blogMigrationsEntity that = (blogMigrationsEntity) o;

		if (id != that.id) return false;
		if (batch != that.batch) return false;
		if (migration != null ? !migration.equals(that.migration) : that.migration != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (migration != null ? migration.hashCode() : 0);
		result = 31 * result + batch;
		return result;
	}
}
