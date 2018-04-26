package cn.tedu.note.service;

import cn.tedu.note.entity.User;

/**
 * @author 马成杰
 */
public interface UserService  {
	/**
	 * 验证用户登录信息
	 * @param name 用户名
	 * @param password 密码
	 * @return 返回用户信息
	 * @throws UserNameFormatException 用户名格式错误
	 * @throws PasswordFormatException 密码格式错误
	 * @throws UserNotFoundException 用户不存在
	 * @throws PasswordException 用户或密码错误
	 *
	 */
	User login(String name,String password)
			throws UserNameFormatException,PasswordFormatException,UserNotFoundException,PasswordException;

	/**
	 * 注册用户信息
	 * @param name 用户名
	 * @param nick 昵称
	 * @param password 密码
	 * @param confirm 确认密码
	 * @return 注册用户信息
	 * @throws UserNameException 用户名已存在
	 * @throws PasswordException 密码不一致
	 */
	User regist(String name,String nick,String password,String confirm)
			throws UserNameException,PasswordException;
}
