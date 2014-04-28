package org.jblog.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.jblog.dao.ArticleDao;
import org.jblog.domain.Article;
import org.jblog.domain.ArticleGroup;
import org.springframework.stereotype.Component;

@Component
public class ArticleDaoImpl extends BaseDaoImpl<Article> implements ArticleDao {

	public List<Article> listByGroup(ArticleGroup group) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Article.class);
		criteria.add(Restrictions.eq("group", group));
		@SuppressWarnings("unchecked")
		List<Article> articles = criteria.list();
		return articles;
	}

}
