package cn.tedu.note.service.impl;

import cn.tedu.note.dao.NotebookDao;
import cn.tedu.note.dao.UserDao;
import cn.tedu.note.entity.Notebook;
import cn.tedu.note.entity.User;
import cn.tedu.note.service.NotebookNotFoundException;
import cn.tedu.note.service.NotebookService;
import cn.tedu.note.service.UserNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author 马成杰
 */
@Service("notebookService")
public class NotebookServiceImpl implements NotebookService {
	@Resource
	private NotebookDao notebookDao;
	@Resource
	private UserDao userDao;

	@Override
	@Transactional(rollbackFor = RuntimeException.class, readOnly = true)
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
	@Transactional(rollbackFor = RuntimeException.class, readOnly = true)
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

	@Override
	public Notebook addNotebook(String userId, String name) throws UserNotFoundException, NotebookNotFoundException {
		if (userId == null || userId.trim().isEmpty()){
			throw new UserNotFoundException("no this userId");
		}
		User user = userDao.findUserByUserId(userId);
		if (user == null){
			throw new UserNotFoundException("no this user");
		}
		if (name == null || name.trim().isEmpty()){
			name = String.valueOf(System.currentTimeMillis());
		}
		Notebook notebook = new Notebook();
		String id = String.valueOf(UUID.randomUUID());
		long time = System.currentTimeMillis();
		notebook.setId(id);
		notebook.setUserId(userId);
		notebook.setName(name);
		notebook.setCreateTime(time);
		int n = notebookDao.addNotebook(notebook);
		if (n != 1){
			throw new NotebookNotFoundException("failed save new notebook");
		}
		return notebook;
	}
}
