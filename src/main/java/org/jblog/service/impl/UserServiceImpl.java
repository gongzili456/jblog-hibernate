package org.jblog.service.impl;

import org.jblog.domain.User;
import org.jblog.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl extends BaseServiceImpl<User> implements
		UserService {

	// public boolean addFans(Serializable id, Set<Serializable> ids) {
	// User user = baseDao.load(id);
	// for (Serializable i : ids) {
	// Set<User> users = user.getFans();
	// users.add(baseDao.load(i));
	// }
	// return true;
	// }
	//
	// public boolean removeFans(Serializable id, Set<Serializable> ids) {
	// User user = baseDao.load(id);
	// Set<User> fans = new HashSet<User>();
	// for (Serializable i : ids) {
	// fans.add(baseDao.load(i));
	// }
	// boolean b = user.getFans().removeAll(fans);
	// return b;
	// }
	//
	// public boolean addFollows(Serializable id, Set<Serializable> ids) {
	// User user = baseDao.load(id);
	// for (Serializable i : ids) {
	// user.getFollows().add(baseDao.load(i));
	// }
	// return true;
	// }
	//
	// public boolean removeFollws(Serializable id, Set<Serializable> ids) {
	// User user = baseDao.load(id);
	// Set<User> follows = new HashSet<User>();
	// for (Serializable i : ids) {
	// follows.add(baseDao.load(i));
	// }
	// boolean b = user.getFollows().removeAll(follows);
	// return b;
	// }

}
