package jblog;

import java.util.Date;

import org.jblog.domain.User;
import org.jblog.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserService {

	private ApplicationContext ac;
	private UserService service;

	@Before
	public void init() {
		ac = new ClassPathXmlApplicationContext("beans.xml");
		service = ac.getBean(UserService.class);
	}

	@Test
	public void save() {
		User t = new User();
		t.setName("Rose");
		t.setEmail("rose@gmail.com");
		t.setPassword("123456");
		t.setRegisteDate(new Date());
		service.save(t);
	}

	// @Test
	// public void addFans() {
	// Set<Serializable> ids = new HashSet<Serializable>();
	//
	// ids.add(4l);
	// // ids.add(3l);
	//
	// service.addFans(1l, ids);
	// }
	//
	// @Test
	// public void removeFans() {
	// Set<Serializable> ids = new HashSet<Serializable>();
	// ids.add(4l);
	// ids.add(3l);
	// service.removeFans(1l, ids);
	// }

	@Test
	public void get() {
		User user = service.get(1l);
		System.out.println(user);
	}
}
