package com.machengjie.clonenote.dao;


import com.machengjie.clonenote.entity.User;

public interface UserDao {
	
	User findUserByName(String name);

	int addUser(User user);

	User findUserByUserId(String userId);
}
