package cn.tedu.note.test;

import cn.tedu.note.service.NotebookService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;

public class TestNotebook {
	NotebookService service;

	protected ClassPathXmlApplicationContext ctx;

	@Before
	public void initService(){
		ctx = new ClassPathXmlApplicationContext(
			"conf/spring-mvc.xml",
			"conf/spring-mybatis.xml",
			"conf/spring-service.xml");
		service = ctx.getBean("notebookService",
			NotebookService.class);
	}

	@Test
	public void testListNotebooksPaged(){
		String userId = "39295a3d-cc9b-42b4-b206-a2e7fab7e77c";
		List<Map<String, Object>> list = service.listNotebooks(userId, 1);
		for (Map<String, Object> map : list) {
			System.out.println(map);
		}

	}



}
