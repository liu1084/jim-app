package com.jim.repository;

import com.jim.entity.Entity;
import org.hibernate.criterion.Order;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by jim on 2017/3/23.
 * This class is ...
 */
public interface BaseJPARepository<T extends Entity, ID extends Serializable> {
	void setupEntityClass(Class clazz);
	T insert(T object);
	T update(T object);
	T insertOrUpdate(T object);
	void delete(T object);
	T findById(ID id);
	Collection<T> findAllByPage(int pageNum, int countPerPage, Order order);
}
