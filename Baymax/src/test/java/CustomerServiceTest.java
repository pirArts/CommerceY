import junit.framework.Assert;
import org.junit.Test;

import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.baymax.baymax.model.CustomerType;
import com.baymax.baymax.model.Customer;
import com.baymax.baymax.service.identity.CustomerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:conf/spring.xml", "classpath:conf/spring-mybatis.xml"})
public class CustomerServiceTest {
	
	@Autowired 
	private CustomerService customerService;

	@Test
	public void testCustomerOperation(){
        CustomerType customerType = new CustomerType();
        customerType.setName("test");
        customerService.insertCustomerType(customerType);

        customerType = customerService.getCustomerTypeByName("test");
        Assert.assertEquals(customerType.getName(), "test");

        Customer customer1 = new Customer();
        customer1.setEmail("test@hotmail.com");
        customer1.setPassword("12");
        customer1.setNickname("Hao");
        customer1.setPhone("135");
        customer1.setAddress("street A");
        customer1.setGender("M");
        customer1.setWechatOpenID("abcd");
        customer1.setCustomerType(customerType);
        customerService.insertCustomer(customer1);

        Customer customer2 = new Customer();
        customer2.setEmail("test@gmail.com");
        customer2.setPassword("12");
        customer2.setNickname("Hao");
        customer2.setPhone("135");
        customer2.setAddress("street A");
        customer2.setGender("M");
        customer2.setWechatOpenID("abcd");
        customer2.setCustomerType(customerType);
        customerService.insertCustomer(customer2);

        Customer customer = customerService.getCustomerByEmail("test@gmail.com");
        Assert.assertEquals(customer.getNickname(), "Hao");

        customerService.deleteCustomersByType(customer);
        customer = customerService.getCustomerByEmail("test@hotmail.com");
        Assert.assertEquals(customer, null);

        customerService.deleteCustomerType(customerType);
        customerType = customerService.getCustomerTypeByName("test");
        Assert.assertEquals(customerType, null);
	}
}
