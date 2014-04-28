package org.jblog.dao;

import java.util.List;

import org.jblog.domain.Article;
import org.jblog.domain.ArticleGroup;

public interface ArticleDao extends BaseDao<Article> {

	List<Article> listByGroup(ArticleGroup group);
}
