package cn.tedu.note.controller;

import cn.tedu.note.service.NotebookService;
import cn.tedu.note.util.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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
}
