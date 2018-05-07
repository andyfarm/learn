package cn.tedu.note.controller;

import cn.tedu.note.entity.Share;
import cn.tedu.note.service.ShareService;
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
@RequestMapping("share")
public class ShareController {
	@Resource
	private ShareService shareService;

	@RequestMapping("/add.do")
	@ResponseBody
	public JsonResult add(String noteId){
		Share share = shareService.addShare(noteId);
		return new JsonResult(share);
	}

	@RequestMapping("/find.do")
	@ResponseBody
	public JsonResult find(String keyword){
		List<Map<String,Object>> list = shareService.findByKeyword(keyword);
		return new JsonResult(list);
	}
}
