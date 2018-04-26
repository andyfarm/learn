package cn.tedu.note.service;

import cn.tedu.note.entity.Note;

import java.util.List;
import java.util.Map;

public interface NoteService {
	List<Map<String,Object>> listNotes(String notebookId) throws NotebookNotFoundException;
	Note getNote(String noteId) throws NoteNotFoundException;
	Note addNote(String userId,String notebookId,String title) throws UserNotFoundException,NotebookNotFoundException;
	boolean updateNote(String noteId, String title, String body);
	boolean moveNote(String noteId, String notebookId) throws NoteNotFoundException,NotebookNotFoundException;
	boolean deleteNote(String noteId)throws NoteNotFoundException;
	List<Map<String, Object>> listNotesInTrash(String userId) throws UserNotFoundException;
	boolean replayNote(String noteId, String notebookId) throws NoteNotFoundException,NotebookNotFoundException;
	int deleteNotes(String... noteIds) throws NoteNotFoundException;
	boolean addStars(String userId, int stars) throws UserNotFoundException;
}
