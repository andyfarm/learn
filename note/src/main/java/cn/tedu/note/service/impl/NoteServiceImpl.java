package cn.tedu.note.service.impl;

import cn.tedu.note.dao.NoteDao;
import cn.tedu.note.dao.NotebookDao;
import cn.tedu.note.dao.UserDao;
import cn.tedu.note.entity.Note;
import cn.tedu.note.entity.User;
import cn.tedu.note.service.NoteNotFoundException;
import cn.tedu.note.service.NoteService;
import cn.tedu.note.service.NotebookNotFoundException;
import cn.tedu.note.service.UserNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service("noteService")
public class NoteServiceImpl implements NoteService {
	@Resource
	private UserDao userDao;
	@Resource
	private NoteDao noteDao;
	@Resource
	private NotebookDao notebookDao;
	@Override
	public List<Map<String, Object>> listNotes(String notebookId) throws NotebookNotFoundException {
		if (notebookId == null || notebookId.trim().isEmpty()){
			throw new NotebookNotFoundException("id empty");
		}
		int n = notebookDao.countNotebookById(notebookId);
		if ( n != 1){
			throw new NotebookNotFoundException("no this notebook");
		}
		return noteDao.findNotesByNotebookId(notebookId);
	}

	@Override
	public Note getNote(String noteId) throws NoteNotFoundException {
		if (noteId == null || noteId.trim().isEmpty()){
			throw new NoteNotFoundException("id empty");
		}
		Note note = noteDao.findNoteById(noteId);
		if (note == null){
			throw new NoteNotFoundException("no this note");
		}
		return note;
	}

	@Override
	public Note addNote(String userId, String notebookId, String title) throws UserNotFoundException, NotebookNotFoundException {
		if (userId == null || userId.trim().isEmpty()) {
			throw new UserNotFoundException("no this userId");
		}
		User user = userDao.findUserByUserId(userId);
		if (user == null) {
			throw new UserNotFoundException("no match user");
		}
		if (notebookId == null || notebookId.trim().isEmpty()) {
			throw new NotebookNotFoundException("no notebook");
		}
		int n = notebookDao.countNotebookById(notebookId);
		if (n != 1) {
			throw new NotebookNotFoundException("no the notebook");
		}
		if (title == null || title.trim().isEmpty()) {
			title = String.valueOf(System.currentTimeMillis());
		}
		String id = UUID.randomUUID().toString();
		String statusId = "1";
		String typeId = "0";
		String body = "";
		long time = System.currentTimeMillis();
		Note note = new Note(id,notebookId,userId,statusId,typeId,title,body,time,time);
		n = noteDao.addNote(note);
		if (n != 1) {
			throw new NoteNotFoundException("failed to save");
		}
		return note;
	}

	@Override
	public boolean updateNote(String noteId, String title, String body) {
		if (noteId == null || noteId.trim().isEmpty()) {
			throw new NoteNotFoundException("no noteID");
		}
		Note note = noteDao.findNoteById(noteId);
		if (note == null) {
			throw new NoteNotFoundException("no this note");
		}
		Note data = new Note();
		if (title != null && !title.equals(note.getTitle())) {
			data.setTitle(title);
		}
		if (body != null && !body.equals(note.getBody())) {
			data.setBody(body);
		}
		data.setId(noteId);
		data.setLastModifyTime(System.currentTimeMillis());
		int n = noteDao.updateNote(data);
		return n == 1;
	}

	@Override
	public boolean moveNote(String noteId, String notebookId) throws NoteNotFoundException, NotebookNotFoundException {
		if (noteId == null || noteId.trim().isEmpty()) {
			throw new NoteNotFoundException("id empty");
		}
		Note note = noteDao.findNoteById(noteId);
		if (note == null) {
			throw new NoteNotFoundException("no this note");
		}
		if (notebookId == null || notebookId.trim().isEmpty()) {
			throw new NotebookNotFoundException("notebookId empty");
		}
		int n = notebookDao.countNotebookById(notebookId);
		if (n != 1) {
			throw new NotebookNotFoundException("no this notebook");
		}
		Note data = new Note();
		data.setId(noteId);
		data.setNotebookId(notebookId);
		data.setLastModifyTime(System.currentTimeMillis());

		int i = noteDao.updateNote(data);
		return i == 1;
	}

	@Override
	public boolean deleteNote(String noteId) throws NoteNotFoundException {
		if (noteId == null || noteId.trim().isEmpty()) {
			throw new NoteNotFoundException("no noteID");
		}
		Note note = noteDao.findNoteById(noteId);
		if (note == null) {
			throw new NoteNotFoundException("no this note");
		}
		Note data = new Note();
		data.setId(noteId);
		data.setStatusId("0");
		data.setLastModifyTime(System.currentTimeMillis());
		int i = noteDao.updateNote(data);
		return i == 1;
	}

	@Override
	public List<Map<String, Object>> listNotesInTrash(String userId) throws UserNotFoundException {
		if (userId == null || userId.trim().isEmpty()) {
			throw new UserNotFoundException("no this userId");
		}
		User user = userDao.findUserByUserId(userId);
		if (user == null) {
			throw new UserNotFoundException("no match user");
		}
		return noteDao.findDeleteNotesByUserId(userId);
	}

	@Override
	public boolean replayNote(String noteId, String notebookId) throws NoteNotFoundException, NotebookNotFoundException {
		if (noteId == null || noteId.trim().isEmpty()) {
			throw new NoteNotFoundException("id empty");
		}
		Note note = noteDao.findNoteById(noteId);
		if (note == null) {
			throw new NoteNotFoundException("no this note");
		}
		if (notebookId == null || notebookId.trim().isEmpty()) {
			throw new NotebookNotFoundException("notebookId empty");
		}
		int n = notebookDao.countNotebookById(notebookId);
		if (n != 1) {
			throw new NotebookNotFoundException("no this notebook");
		}
		Note data = new Note();
		data.setId(noteId);
		data.setNotebookId(notebookId);
		data.setStatusId("1");
		data.setLastModifyTime(System.currentTimeMillis());

		int i = noteDao.updateNote(data);
		return i == 1;

	}

	@Override
	@Transactional
	public int deleteNotes(String... noteIds) throws NoteNotFoundException {
		for (String noteId : noteIds) {
			int n = noteDao.deleteNoteById(noteId);
			if (n != 1){
				throw new NoteNotFoundException("wrong id");
			}
		}
		return noteIds.length;
	}
}
