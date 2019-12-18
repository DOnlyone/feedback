package edu.bnuz.fb;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.bnuz.fb.entity.Content;
import edu.bnuz.fb.mapper.ContentMapper;
import edu.bnuz.fb.rbac.entity.User;
import edu.bnuz.fb.rbac.mapper.UserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestUserMapper {
	
	@Autowired
	private UserMapper userDao;
	
	@Test
	public void testAddContent() {
		User user = new User();
		user.setUserName("hangs");
		user.setRealName("张三丰");
		user.setPassword("123456");
		user.setPhone("18303412058");
		user.setSex((byte)1);
		user.setClassNum(02);
		user.setGarde(1);
		user.setEmail("859422@qq.com");
		userDao.createUser(user);
		
	}
	


}
