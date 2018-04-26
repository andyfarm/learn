package cn.tedu.note.controller;

import cn.tedu.note.entity.Note;
import cn.tedu.note.service.NoteService;
import cn.tedu.note.util.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author 马成杰
 */
@Controller
@RequestMapping("note")
public class NoteController {

	@Resource
	private NoteService noteService;

	@RequestMapping("/list.do")
	@ResponseBody
	public JsonResult list(String notebookId){
		return new JsonResult(noteService.listNotes(notebookId));
	}

	@RequestMapping("/load.do")
	@ResponseBody
	public JsonResult load(String noteId) {
		return new JsonResult(noteService.getNote(noteId));
	}

	@RequestMapping("/add.do")
	@ResponseBody
	public JsonResult add(String userId, String notebookId, String title){
		Note note = noteService.addNote(userId, notebookId, title);
		return new JsonResult(note);
	}

	@RequestMapping("/update.do")
	@ResponseBody
	public JsonResult update(String noteId, String title, String body){
		boolean b = noteService.updateNote(noteId, title, body);
		return new JsonResult(b);
	}

	@RequestMapping("/move.do")
	@ResponseBody
	public JsonResult move(String noteId, String notebookId){
		boolean b = noteService.moveNote(noteId, notebookId);
		return new JsonResult(b);
	}

	@RequestMapping("/delete.do")
	@ResponseBody
	public JsonResult delete(String noteId){
		boolean b = noteService.deleteNote(noteId);
		return new JsonResult(b);
	}

	@RequestMapping("/trash.do")
	@ResponseBody
	public JsonResult trash(String userId){
		List<Map<String, Object>> list = noteService.listNotesInTrash(userId);
		return new JsonResult(list);
	}

	@RequestMapping("/replay.do")
	@ResponseBody
	public JsonResult replay(String noteId, String notebookId){
		boolean b = noteService.replayNote(noteId, notebookId);
		return new JsonResult(b);
	}










}
