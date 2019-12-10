package edu.bnuz.fb;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import edu.bnuz.fb.entity.Content;
import edu.bnuz.fb.mapper.ContentMapper;
/**
 * SpringRunner 继承了SpringJUnit4ClassRunner，没有扩展任何功能；使用前者，名字简短而已
 * @author zookeeper
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestAddContent {
	
	@Autowired
	private ContentMapper contentDao;
	
	@Test
	public void testAddContent() {
		Content tent = new Content();
		tent.setTitle("测试添加");
		tent.setCreateuser(01l);
		tent.setContext("helloworld");
		tent.setCteateDate(new Date());
		tent.setType(1);
		contentDao.insert(tent);
		
	}

}
