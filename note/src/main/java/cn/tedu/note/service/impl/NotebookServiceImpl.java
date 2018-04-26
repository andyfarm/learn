package cn.tedu.note.service.impl;

import cn.tedu.note.dao.NotebookDao;
import cn.tedu.note.dao.UserDao;
import cn.tedu.note.entity.User;
import cn.tedu.note.service.NotebookService;
import cn.tedu.note.service.UserNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("notebookService")
public class NotebookServiceImpl implements NotebookService {
	@Resource
	private NotebookDao notebookDao;
	@Resource
	private UserDao userDao;

	@Override
	public List<Map<String, Object>> listNotebooks(String userId) throws UserNotFoundException {
		if (userId == null || userId.trim().isEmpty()) {
			throw new UserNotFoundException("ID empty");
		}
		User user = userDao.findUserByUserId(userId);
		if (user == null) {
			throw new UserNotFoundException("no this user");
		}
		return notebookDao.findNotebooksByUserId(userId);
	}


	@Value("#{jdbc.pageSize}")
	private int pageSize;

	@Override
	public List<Map<String, Object>> listNotebooks(String userId, Integer page) throws UserNotFoundException {
		if (userId == null || userId.trim().isEmpty()) {
			throw new UserNotFoundException("ID不能空");
		}
		User user = userDao.findUserByUserId(userId);
		if (user == null) {
			throw new UserNotFoundException("用户不存在");
		}
		if (page == null) {
			page = 0;
		}
		int start = page * pageSize;
		String table = "cn_notebook";
		return notebookDao.findNotebooksByPage(userId, start, pageSize, table);
	}
}
