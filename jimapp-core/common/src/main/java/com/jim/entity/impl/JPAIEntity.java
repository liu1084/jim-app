package com.jim.entity.impl;

import com.jim.entity.IEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by jim on 2017/3/23.
 * This class is ...
 */
public class JPAIEntity<T extends Serializable> implements IEntity<T> {
	protected T id;
	protected Date createdAt;
	protected Date updatedAt;

	public JPAIEntity(){
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

	public T getId() {
		return id;
	}

	public void setId(T id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
}
