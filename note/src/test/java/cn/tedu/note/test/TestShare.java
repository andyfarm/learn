package cn.tedu.note.test;

import cn.tedu.note.service.ShareService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;

public class TestShare {
	ShareService service;

	protected ClassPathXmlApplicationContext ctx;

	@Before
	public void initService(){
		ctx = new ClassPathXmlApplicationContext(
			"conf/spring-mvc.xml",
			"conf/spring-mybatis.xml",
			"conf/spring-service.xml");
		service = ctx.getBean("shareService",
			ShareService.class);
	}
	@Test
	public void test(){
		String keyword = "参加";
		List<Map<String, Object>> list = service.findByKeyword(keyword);
		System.out.println(list);
	}

}
