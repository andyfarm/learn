package cn.tedu.note.service.impl;

import cn.tedu.note.dao.NoteDao;
import cn.tedu.note.dao.ShareDao;
import cn.tedu.note.entity.Note;
import cn.tedu.note.entity.Share;
import cn.tedu.note.service.KeywordException;
import cn.tedu.note.service.NoteNotFoundException;
import cn.tedu.note.service.ShareNoteNotFoundException;
import cn.tedu.note.service.ShareService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author 马成杰
 */
@Service("shareService")
public class ShareServiceImpl implements ShareService {
	@Resource
	private ShareDao shareDao;
	@Resource
	private NoteDao noteDao;

	@Override
	public Share addShare(String noteId) throws NoteNotFoundException {
		if (noteId == null || noteId.trim().isEmpty()) {
			throw new NoteNotFoundException("no this noteId");
		}
		Note note = noteDao.findNoteById(noteId);
		if (note == null) {
			throw new NoteNotFoundException("no this note");
		}
		String id = String.valueOf(UUID.randomUUID());
		String title = note.getTitle();
		String body = note.getBody();
		Share share = new Share(id, title, body, noteId);
		int i = shareDao.addNote(share);
		if (i != 1) {
			throw new ShareNoteNotFoundException("share failed");
		}
		return share;
	}

	@Override
	@Transactional(rollbackFor = RuntimeException.class, readOnly = true)
	public List<Map<String, Object>> findByKeyword(String keyword) throws KeywordException {
		if (keyword == null || keyword.trim().isEmpty()) {
			throw new KeywordException("wu guanjianci");
		}
		String title = "%" + keyword + "%";
		List<Map<String, Object>> list = shareDao.findByTitle(title);
		return list;
	}
}
