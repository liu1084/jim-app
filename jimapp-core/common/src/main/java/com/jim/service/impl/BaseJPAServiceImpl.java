package com.jim.service.impl;

import com.jim.entity.IEntity;
import com.jim.repository.IBaseJPARepository;
import com.jim.service.IBaseService;
import org.hibernate.criterion.Order;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by jim on 2017/3/23.
 * This class is ...
 */
public abstract class BaseJPAServiceImpl<T extends IEntity, ID extends Serializable> implements IBaseService<T, ID> {
	protected IBaseJPARepository<T, ID> baseJpaRepository;
	protected Class<T> clazz;

	@Override
	public T insert(T object) {
		return IBaseJPARepository.insert(object);
	}

	@Override
	public T update(T object) {
		return IBaseJPARepository.update(object);
	}

	@Override
	public void delete(T object) {
		IBaseJPARepository.delete(object);
	}

	@Override
	public T findById(ID id) {
		return IBaseJPARepository.findById(id);
	}

	@Override
	public Collection<T> findAllByPage(int pageNum, int countPerPage, Order order) {
		return null;
	}
}
