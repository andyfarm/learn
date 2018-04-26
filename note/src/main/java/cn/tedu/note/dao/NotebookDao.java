package cn.tedu.note.dao;

import java.util.List;
import java.util.Map;

/**
 * @author 马成杰
 */
public interface NotebookDao {
	List<Map<String,Object>> findNotebooksByUserId(String userId);
	int countNotebookById(String notebookId);
}
