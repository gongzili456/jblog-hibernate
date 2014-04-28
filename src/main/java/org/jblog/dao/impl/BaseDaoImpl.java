package org.jblog.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.jblog.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BaseDaoImpl<T> implements BaseDao<T> {

	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	private Class<T> getClazz() {
		return (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public Serializable save(T t) {
		return sessionFactory.getCurrentSession().save(t);
	}

	public boolean update(T t) {
		Session session = sessionFactory.getCurrentSession();
		session.update(t);
		return true;
	}

	public T get(Serializable id) {
		@SuppressWarnings("unchecked")
		T t = (T) sessionFactory.getCurrentSession().get(getClazz(), id);
		return t;
	}

	@SuppressWarnings("unchecked")
	public T load(Serializable id) {
		return (T) sessionFactory.getCurrentSession().load(getClazz(), id);
	}

	public long count() {
		Session session = sessionFactory.getCurrentSession();
		return (Long) session.createCriteria(getClazz())
				.setProjection(Projections.rowCount()).uniqueResult();
	}

	public List<T> list(int page, int size) {
		if (page <= 0) {
			page = 1;
		}
		if (size <= 0) {
			throw new IllegalArgumentException(
					"Argument Error, not size <=0  --> page = " + page
							+ ", size = " + size);
		}
		Session session = sessionFactory.getCurrentSession();
		String hql = "from " + getClazz().getSimpleName();
		Query query = session.createQuery(hql)
				.setFirstResult((page - 1) * size).setMaxResults(size);
		@SuppressWarnings("unchecked")
		List<T> list = query.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<T> list() {
		return sessionFactory.getCurrentSession()
				.createQuery("from " + getClazz().getSimpleName()).list();
	}

	public boolean delete(Serializable id) {
		Session session = sessionFactory.getCurrentSession();
		Object o = session.load(getClazz(), id);
		session.delete(o);
		return true;
	}

}
