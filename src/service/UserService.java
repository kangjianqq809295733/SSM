package service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pojo.User;

import dao.UserDao;


@Service("userService")
public class UserService {
	@Resource
	private UserDao userDao;

	public User getUserById(int i) throws Exception {
		return userDao.getUserById(i);
	}
}
