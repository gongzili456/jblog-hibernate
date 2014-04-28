package jblog;

import java.util.Date;

import org.jblog.domain.Comment;
import org.jblog.service.ArticleService;
import org.jblog.service.CommentService;
import org.jblog.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCommentService {
	private ApplicationContext ac;
	private CommentService service;
	private UserService userService;
	private ArticleService articleService;

	@Before
	public void init() {
		ac = new ClassPathXmlApplicationContext("beans.xml");
		service = ac.getBean(CommentService.class);
		articleService = ac.getBean(ArticleService.class);
		userService = ac.getBean(UserService.class);
	}

	@Test
	public void save() {
		Comment comment = new Comment();
		comment.setContent("这是评论内容。。。");
		comment.setDate(new Date());
		service.save(comment, 1l, 1l, 0l);
	}
}
