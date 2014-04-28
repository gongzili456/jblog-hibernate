package org.jblog.service.impl;

import java.io.Serializable;
import java.util.List;

import org.jblog.dao.ArticleGroupDao;
import org.jblog.dao.UserDao;
import org.jblog.domain.ArticleGroup;
import org.jblog.domain.User;
import org.jblog.service.ArticleGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ArticleGroupServiceImpl extends BaseServiceImpl<ArticleGroup>
		implements ArticleGroupService {

	@Autowired
	ArticleGroupDao articleGroupDao;

	@Autowired
	UserDao userDao;

	public List<ArticleGroup> listByUser(Serializable userId) {
		User user = userDao.load(userId);
		return articleGroupDao.listByUser(user);
	}
}
