package jblog;

import org.jblog.domain.ArticleGroup;
import org.jblog.service.ArticleGroupService;
import org.jblog.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestArticleGroupService {
	private ApplicationContext ac;
	private ArticleGroupService service;
	private UserService userService;

	@Before
	public void init() {
		ac = new ClassPathXmlApplicationContext("beans.xml");
		service = ac.getBean(ArticleGroupService.class);
		userService = ac.getBean(UserService.class);
	}

	@Test
	public void save() {
		ArticleGroup group = new ArticleGroup();
		group.setName("JAVA相关");
		group.setUser(userService.get(1l));
		service.save(group);
	}
}
