package cn.tedu.note.controller;

import cn.tedu.note.entity.Notebook;
import cn.tedu.note.service.NotebookService;
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
@RequestMapping("notebook")
public class NotebookController {
	@Resource
	private NotebookService notebookService;
	@RequestMapping("/list.do")
	@ResponseBody
	public JsonResult list(String userId){
		List<Map<String,Object>> list = notebookService.listNotebooks(userId);
		return new JsonResult(list);
	}

	@RequestMapping("/page.do")
	@ResponseBody
	public JsonResult page(String userId, Integer page){
		List<Map<String, Object>> list = notebookService.listNotebooks(userId, page);
		return new JsonResult(list);
	}
	@RequestMapping("/add.do")
	@ResponseBody
	public JsonResult add(String userId, String name){
		Notebook notebook = notebookService.addNotebook(userId, name);
		return new JsonResult(notebook);
	}
}
