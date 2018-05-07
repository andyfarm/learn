package cn.tedu.note.service;

import cn.tedu.note.entity.Notebook;

import java.util.List;
import java.util.Map;

public interface NotebookService {
	List<Map<String,Object>> listNotebooks(String userId) throws UserNotFoundException;
	List<Map<String,Object>> listNotebooks(String userId, Integer page) throws UserNotFoundException;
	Notebook addNotebook(String userId, String name) throws UserNotFoundException, NotebookNotFoundException;
}

