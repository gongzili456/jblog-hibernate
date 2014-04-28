package jblog;

import java.util.Date;
import java.util.List;

import org.jblog.domain.Article;
import org.jblog.service.ArticleGroupService;
import org.jblog.service.ArticleService;
import org.jblog.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TesArticletService {

	private ArticleService service;
	private ArticleGroupService groupService;
	@SuppressWarnings("unused")
	private UserService userService;

	@Before
	public void before() {
		@SuppressWarnings("resource")
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		service = ac.getBean(ArticleService.class);
		groupService = ac.getBean(ArticleGroupService.class);
		userService = ac.getBean(UserService.class);
	}

	@Test
	public void testSave() {
		@SuppressWarnings("resource")
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		ArticleService service = ac.getBean(ArticleService.class);
		UserService userService = ac.getBean(UserService.class);

		Article article = new Article();
		article.setTitle("文章标题2");
		article.setContent("文章内容2。。。。");
		article.setCreateTime(new Date());
		article.setModifyTime(new Date());
		article.setAuthor(userService.get(2l));

		article.setGroup(groupService.get(1l));

		service.save(article);
	}

	@Test
	public void testlist() {
		@SuppressWarnings("resource")
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		ArticleService service = ac.getBean(ArticleService.class);
		int page = 1;
		int size = 1;
		List<Article> articles = service.list(page, size);
		for (Article a : articles) {
			System.out.println(a);
		}
	}

	@Test
	public void delete() {
		@SuppressWarnings("resource")
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		ArticleService service = ac.getBean(ArticleService.class);

		boolean r = service.delete(1l);
		System.out.println(r);
	}

	@Test
	public void get() {
		@SuppressWarnings("resource")
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		ArticleService service = ac.getBean(ArticleService.class);

		Article r = service.get(2l);
		System.out.println(r);
	}

	@Test
	public void update() {
		@SuppressWarnings("resource")
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		ArticleService service = ac.getBean(ArticleService.class);

		Article r = service.load(2l);

		r.setContent("new Contents");
		service.update(r);
		System.out.println(r);
	}

	@Test
	public void count() {
		@SuppressWarnings("resource")
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		ArticleService service = ac.getBean(ArticleService.class);

		long r = service.count();

		System.out.println(r);
	}

	@Test
	public void listGroup() {
		List<Article> articles = service.listByGroup(1l);
		System.out.println(articles);
	}
}
