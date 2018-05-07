package cn.tedu.note.dao;

import cn.tedu.note.entity.Notebook;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author 马成杰
 */
public interface NotebookDao {
	List<Map<String,Object>> findNotebooksByUserId(String userId);
	int countNotebookById(String notebookId);
	List<Map<String,Object>> findNotebooksByPage(
		@Param("userId") String userId,
		@Param("start") int start,
		@Param("pageSize") int pageSize,
		@Param("table") String table);

	int addNotebook(Notebook notebook);
}
