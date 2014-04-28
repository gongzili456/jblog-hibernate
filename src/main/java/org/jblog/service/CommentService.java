package org.jblog.service;

import java.io.Serializable;

import org.jblog.domain.Comment;

public interface CommentService extends BaseService<Comment> {

	/**
	 * 保存评论实例
	 * 
	 * @param comment
	 *            评论实例，应包含：content，date
	 * @param userId
	 *            评论的作者ID
	 * @param articleId
	 *            被评论文章的ID
	 * @param parentId
	 *            引用评论的ID，若没引用则赋值：0L
	 * @return 该评论在数据库中的ID
	 */
	Serializable save(Comment comment, Serializable userId,
			Serializable articleId, Serializable parentId);
}
