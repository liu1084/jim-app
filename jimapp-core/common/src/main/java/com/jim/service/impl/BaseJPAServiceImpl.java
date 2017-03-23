package com.jim.service.impl;

import com.jim.entity.Entity;
import com.jim.repository.BaseJPARepository;
import com.jim.service.BaseService;
import org.hibernate.criterion.Order;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by jim on 2017/3/23.
 * This class is ...
 */
public abstract class BaseJPAServiceImpl<T extends Entity, ID extends Serializable> implements BaseService<T, ID> {
	protected BaseJPARepository<T, ID> baseJPARepository;
	protected Class<T> clazz;

	@Override
	public T insert(T object) {
		return baseJPARepository.insert(object);
	}

	@Override
	public T update(T object) {
		return baseJPARepository.update(object);
	}

	@Override
	public void delete(T object) {
		baseJPARepository.delete(object);
	}

	@Override
	public T findById(ID id) {
		return baseJPARepository.findById(id);
	}

	@Override
	public Collection<T> findAllByPage(int pageNum, int countPerPage, Order order) {
		return null;
	}
}
