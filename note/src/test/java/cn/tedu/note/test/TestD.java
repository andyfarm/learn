package cn.tedu.note.test;

import cn.tedu.note.service.NoteService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestD {
	NoteService service;

	protected ClassPathXmlApplicationContext ctx;

	@Before
	public void initService(){
		ctx = new ClassPathXmlApplicationContext(
			"conf/spring-mvc.xml",
			"conf/spring-mybatis.xml",
			"conf/spring-service.xml");
		service = ctx.getBean("noteService",
			NoteService.class);
	}

	@Test
	public void testDeleteNotes(){
		String id1 = "3febebb3-a1b7-45ac-83ba-50cdb41e5fc1";
		String id2 = "9187ffd3-4c1e-4768-9f2f-c600e835b823";
		String id3 = "ebd65da6-3f90-45f9-b045-782928a5e2c0";
		String id4 = "A";//"fed920a0-573c-46c8-ae4e-368397846efd";

		int n = service.deleteNotes(
			id1, id2, id3, id4);
		//int n = service.deleteNotes(
		//	new String[]{id1, id2, id3, id4});
		System.out.println(n);
	}
}
