package cn.tedu.note.service.impl;

import cn.tedu.note.dao.UserDao;
import cn.tedu.note.entity.User;
import cn.tedu.note.service.PasswordException;
import cn.tedu.note.service.PasswordFormatException;
import cn.tedu.note.service.UserNameException;
import cn.tedu.note.service.UserNameFormatException;
import cn.tedu.note.service.UserNotFoundException;
import cn.tedu.note.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author 马成杰
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	@Value("#{jdbc.salt}")
	private String salt;
	@Resource
	private UserDao userDao;

	@Override
	@Transactional(rollbackFor = RuntimeException.class, readOnly = true)
	public User login(String name, String password)
		throws UserNameFormatException, PasswordFormatException, UserNotFoundException, PasswordException {
		String nameRule = "^\\w{4,10}$";
		String passwordRule = "^\\w{6,12}$";
		if (!name.matches(nameRule)) {
			throw new UserNameFormatException("用户名格式错误");
		}
		if (!password.matches(passwordRule)) {
			throw new PasswordFormatException("mimageshicuowu");
		}
		User user = userDao.findUserByName(name);
		if (user == null) {
			throw new UserNotFoundException("yonghubucunzai");
		}
		String md5Password = DigestUtils.md5Hex(salt + password);
		if (!md5Password.equals(user.getPassword())) {
			throw new PasswordException("yonghuminghuomimacuowu");
		}
		return user;
	}

	@Override
	@Transactional(rollbackFor = RuntimeException.class)
	public User regist(String name, String nick, String password, String confirm) throws UserNameException, PasswordException {
		User one = userDao.findUserByName(name);
		if (one != null) {
			throw new UserNameException("yizhuce");
		}
		if (!password.equals(confirm)) {
			throw new PasswordException("mimabuyizhi");
		}
		if (nick == null || nick.trim().isEmpty()) {
			nick = name;
		}
		String id = UUID.randomUUID().toString();
		String token = "";
		password = DigestUtils.md5Hex(salt + password);
		User user = new User(id, name, password, token, nick);
		int n = userDao.addUser(user);
		if (n != 1) {
			throw new RuntimeException("failed add");
		}
		return user;
	}
}
