package org.jblog.service.impl;

import java.io.Serializable;

import org.jblog.dao.ArticleDao;
import org.jblog.dao.CommentDao;
import org.jblog.dao.UserDao;
import org.jblog.domain.Article;
import org.jblog.domain.Comment;
import org.jblog.domain.User;
import org.jblog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommentServiceImpl extends BaseServiceImpl<Comment> implements
		CommentService {

	@Autowired
	CommentDao commentDao;

	@Autowired
	ArticleDao articleDao;

	@Autowired
	UserDao userDao;

	public Serializable save(Comment comment, Serializable userId,
			Serializable articleId, Serializable parentId) {
		User user = userDao.load(userId);
		Article article = articleDao.load(articleId);
		Comment parent = commentDao.load(parentId);
		comment.setArticle(article);
		comment.setUser(user);
		comment.setParent(parent);
		return commentDao.save(comment);
	}

}
