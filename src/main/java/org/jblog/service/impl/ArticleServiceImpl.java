package org.jblog.service.impl;

import java.io.Serializable;
import java.util.List;

import org.jblog.dao.ArticleDao;
import org.jblog.dao.ArticleGroupDao;
import org.jblog.dao.UserDao;
import org.jblog.domain.Article;
import org.jblog.domain.ArticleGroup;
import org.jblog.domain.User;
import org.jblog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ArticleServiceImpl extends BaseServiceImpl<Article> implements
		ArticleService {
	@Autowired
	ArticleDao articleDao;

	@Autowired
	ArticleGroupDao groupDao;

	@Autowired
	UserDao userDao;

	public Serializable save(Article article, Serializable authorId,
			Serializable groupId) {
		User author = userDao.load(authorId);
		article.setAuthor(author);

		ArticleGroup group = groupDao.load(groupId);
		article.setGroup(group);

		return articleDao.save(article);
	}

	public List<Article> listByGroup(Serializable groupId) {
		ArticleGroup group = groupDao.load(groupId);
		return articleDao.listByGroup(group);
	}

}
