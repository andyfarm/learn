package cn.tedu.note.dao;

import cn.tedu.note.entity.Note;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface NoteDao {
	List<Map<String,Object>> findNotesByNotebookId(
		@Param("userId") String userId,
		@Param("notebookId") String notebookId,
		@Param("statusId") String statusId);
	Note findNoteById(String noteId);
	int addNote(Note note);
	int updateNote(Note note);
	List<Map<String,Object>> findDeleteNotesByUserId(String userId);
	int deleteNoteById(String noteId);
	int deleteNotes(@Param("ids") String... ids);
}
