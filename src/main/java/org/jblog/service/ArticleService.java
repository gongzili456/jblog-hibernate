package org.jblog.service;

import java.io.Serializable;
import java.util.List;

import org.jblog.domain.Article;

public interface ArticleService extends BaseService<Article> {

	Serializable save(Article article, Serializable authorId,
			Serializable groupId);

	List<Article> listByGroup(Serializable groupId);
}
