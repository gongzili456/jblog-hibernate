package org.jblog.service.impl;

import java.io.Serializable;
import java.util.List;

import org.jblog.dao.BaseDao;
import org.jblog.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseServiceImpl<T> implements BaseService<T> {

	@Autowired
	BaseDao<T> baseDao;

	public Serializable save(T t) {
		return baseDao.save(t);
	}

	public boolean update(T t) {
		return baseDao.update(t);
	}

	public T get(Serializable id) {
		return baseDao.get(id);
	}

	public T load(Serializable id) {
		return baseDao.load(id);
	}

	public long count() {
		return baseDao.count();
	}

	public List<T> list(int page, int size) {
		return baseDao.list(page, size);
	}

	public List<T> list() {
		return baseDao.list();
	}

	public boolean delete(Serializable id) {
		return baseDao.delete(id);
	}

}
