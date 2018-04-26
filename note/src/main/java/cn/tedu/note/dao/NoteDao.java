package cn.tedu.note.dao;

import cn.tedu.note.entity.Note;

import java.util.List;
import java.util.Map;

public interface NoteDao {
	List<Map<String,Object>> findNotesByNotebookId(String notebookId);
	Note findNoteById(String noteId);
	int addNote(Note note);
	int updateNote(Note note);
	List<Map<String,Object>> findDeleteNotesByUserId(String userId);
	int deleteNoteById(String noteId);
}
