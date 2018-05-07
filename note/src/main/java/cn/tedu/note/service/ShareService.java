package cn.tedu.note.service;

import cn.tedu.note.entity.Share;

import java.util.List;
import java.util.Map;

public interface ShareService {
	Share addShare(String noteId) throws NoteNotFoundException, ShareNoteNotFoundException;
	List<Map<String,Object>> findByKeyword(String keyword) throws KeywordException;
}
