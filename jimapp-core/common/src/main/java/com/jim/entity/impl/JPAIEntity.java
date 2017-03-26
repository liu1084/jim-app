package com.jim.entity.impl;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jim.entity.IEntity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Created by jim on 2017/3/23.
 * This class is ...
 */
@MappedSuperclass
public abstract class JPAIEntity<T extends Serializable> implements IEntity {
	protected T id;
	protected Date createdAt;
	protected Date updatedAt;

	public JPAIEntity() {
		createdAt = new Date();
		updatedAt = new Date();
	}

	/**
	 * To make XStream deserialization assign values to
	 * base class fields of createdAt and updatedAt
	 *
	 * @return
	 */
	public Object readResolve() {
		if (createdAt == null) {
			createdAt = new Date();
			updatedAt = createdAt;
		}

		return this;
	}

	@XmlElement(type = Objects.class)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public T getId() {
		return id;
	}

	public void setId(T id){
		this.id = id;
	}

	@JsonIgnore
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", nullable = false)
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@JsonIgnore
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", nullable = false)
	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
}
