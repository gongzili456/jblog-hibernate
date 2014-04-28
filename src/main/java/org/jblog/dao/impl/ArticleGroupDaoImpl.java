package org.jblog.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.jblog.dao.ArticleGroupDao;
import org.jblog.domain.ArticleGroup;
import org.jblog.domain.User;
import org.springframework.stereotype.Component;

@Component
public class ArticleGroupDaoImpl extends BaseDaoImpl<ArticleGroup> implements
		ArticleGroupDao {

	public List<ArticleGroup> listByUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<ArticleGroup> groups = session.createCriteria(ArticleGroup.class)
				.add(Restrictions.eq("user", user)).list();
		return groups;
	}

}
