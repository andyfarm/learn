package cn.tedu.note.dao;

import cn.tedu.note.entity.Share;

import java.util.List;
import java.util.Map;

/**
 * @author 马成杰
 */
public interface ShareDao {
	int addNote(Share share);
	List<Map<String,Object>> findByTitle(String title);
}
