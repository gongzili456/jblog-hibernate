package org.jblog.service;

import java.io.Serializable;
import java.util.List;

import org.jblog.domain.ArticleGroup;

public interface ArticleGroupService extends BaseService<ArticleGroup> {

	List<ArticleGroup> listByUser(Serializable userId);
}
