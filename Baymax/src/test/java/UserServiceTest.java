import junit.framework.Assert;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.baymax.baymax.model.User;
import com.baymax.baymax.service.identity.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:conf/spring.xml", "classpath:conf/spring-mybatis.xml"})
public class UserServiceTest {
	
	@Autowired 
	private UserService userService;
	
	@Test
	public void testSelectUser(){
		User user = userService.getUserByDeviceId("aaaaa");
		
		if(user != null){
			Assert.assertEquals(user.getName(), "Hao Yan");		
		}
	}
	
    @Test
    public void testEquals() {
    	Assert.assertEquals("Test", "Test");
    }
}
