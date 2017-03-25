package com.jim.service;

import com.jim.entity.IEntity;
import org.hibernate.criterion.Order;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by jim on 2017/3/23.
 * This class is ...
 */
public interface IBaseService<T extends IEntity, ID extends Serializable> {
	void setupService();
	T insert(T object) throws Exception;
	T update(T object) throws Exception;
	void delete(T object) throws Exception;
	T findById(ID id) throws Exception;
	Collection<T> findAllByPage(int pageNum, int countPerPage, Order order) throws Exception;
}
