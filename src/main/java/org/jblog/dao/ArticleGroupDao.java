package org.jblog.dao;

import java.util.List;

import org.jblog.domain.ArticleGroup;
import org.jblog.domain.User;

public interface ArticleGroupDao extends BaseDao<ArticleGroup> {
	List<ArticleGroup> listByUser(User user);
}
