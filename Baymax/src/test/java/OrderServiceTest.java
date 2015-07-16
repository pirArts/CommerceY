import junit.framework.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.baymax.baymax.model.Order;
import com.baymax.baymax.model.OrderItem;
import com.baymax.baymax.model.OrderState;
import com.baymax.baymax.model.PaymentType;
import com.baymax.baymax.service.commerce.order.OrderService;

import com.baymax.baymax.model.CustomerType;
import com.baymax.baymax.model.Customer;
import com.baymax.baymax.service.identity.CustomerService;

import com.baymax.baymax.model.ProductCategory;
import com.baymax.baymax.model.Product;
import com.baymax.baymax.service.commerce.catlog.CatalogService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:conf/spring.xml", "classpath:conf/spring-mybatis.xml"})
public class OrderServiceTest {
    
    @Autowired 
    private OrderService orderService;

    @Autowired 
    private CustomerService customerService;

    @Autowired 
    private CatalogService catalogService;
    
    @Test
    public void testOrderStateOperation(){
        OrderState orderState = new OrderState();
        orderState.setName("testOrderState");
        orderService.insertOrderState(orderState);

        orderState = orderService.getOrderStateByName("testOrderState");
        Assert.assertEquals(orderState.getName(), "testOrderState");

        OrderState os = orderService.getOrderState(orderState.getId());
        Assert.assertEquals(os.getName(), "testOrderState");

        orderService.deleteOrderState(orderState);

        orderState = orderService.getOrderStateByName("testOrderState");
        Assert.assertEquals(orderState, null);
    }

    @Test
    public void testOrderPaymentTypeOperation(){
        PaymentType paymentType = new PaymentType();
        paymentType.setName("testPaymentType");
        orderService.insertPaymentType(paymentType);

        paymentType = orderService.getPaymentTypeByName("testpaymentType");
        Assert.assertEquals(paymentType.getName(), "testPaymentType");

        PaymentType pt = orderService.getPaymentType(paymentType.getId());
        Assert.assertEquals(pt.getName(), "testPaymentType");

        orderService.deletePaymentType(paymentType);

        paymentType = orderService.getPaymentTypeByName("testPaymentType");
        Assert.assertEquals(paymentType, null);
    }

    @Test
    public void testOrderOperation(){
        CustomerType customerType = new CustomerType();
        customerType.setName("ordertest");
        customerService.insertCustomerType(customerType);

        customerType = customerService.getCustomerTypeByName("ordertest");
        Assert.assertEquals(customerType.getName(), "ordertest");

        Customer customer = new Customer();
        customer.setEmail("ordertest@hotmail.com");
        customer.setPassword("12");
        customer.setNickname("Hao");
        customer.setPhone("135");
        customer.setAddress("street A");
        customer.setGender("M");
        customer.setWechatOpenID("abcd");
        customer.setCustomerType(customerType);
        customerService.insertCustomer(customer);

        customer = customerService.getCustomerByEmail("ordertest@hotmail.com");
        Assert.assertEquals(customer.getNickname(), "Hao");

        PaymentType paymentType = new PaymentType();
        paymentType.setName("testPaymentType");
        orderService.insertPaymentType(paymentType);

        paymentType = orderService.getPaymentTypeByName("testpaymentType");
        Assert.assertEquals(paymentType.getName(), "testPaymentType");

        OrderState orderState = new OrderState();
        orderState.setName("testOrderState");
        orderService.insertOrderState(orderState);

        orderState = orderService.getOrderStateByName("testOrderState");
        Assert.assertEquals(orderState.getName(), "testOrderState");

        Order order = new Order();
        order.setAmount(100.0f);
        order.setCustomer(customer);
        order.setOrderState(orderState);
        order.setPaymentType(paymentType);
        order.setPaymentResult(0);
        order.setPaymentTime(new Date());

        orderService.insertOrder(order);

        List<Order> orders = orderService.getOrderByUserEmail("ordertest@hotmail.com");
        Assert.assertEquals(orders.size(), 1);
        order = orders.get(0);
        Assert.assertEquals(order.getAmount(), 100.0f);

        ProductCategory productCategory = new ProductCategory();
        productCategory.setName("ordertest");
        catalogService.insertProductCategory(productCategory);

        ProductCategory pc = catalogService.getCategoryByName("ordertest");
        Assert.assertEquals(pc.getName(), "ordertest");

        Product product1 = new Product();
        product1.setName("ordertest-1");
        product1.setPrice(100.0f);
        product1.setDescription("java web development");
        product1.setProductCategory(pc);
        catalogService.insertProduct(product1);

        Product product2 = new Product();
        product2.setName("ordertest-2");
        product2.setPrice(100.0f);
        product2.setDescription("java web development");
        product2.setProductCategory(pc);
        catalogService.insertProduct(product2);

        List<Product> products = catalogService.getProductListByCategory(pc.getId());
        Assert.assertEquals(products.size(), 2);

        OrderItem orderItem = new OrderItem();
        orderItem.setOrder(order);
        orderItem.setProduct(products.get(0));
        orderItem.setQuantity(2);
        orderService.insertOrderItem(orderItem);

        orderItem = new OrderItem();
        orderItem.setOrder(order);
        orderItem.setProduct(products.get(0));
        orderItem.setQuantity(1);
        orderService.insertOrderItem(orderItem);

        orders = orderService.getOrderByUserEmail("ordertest@hotmail.com");
        order = orders.get(0);
        Assert.assertEquals(order.getOrderItems().size(), 2);

        orderItem = orderService.getOrderItem(order.getOrderItems().get(0).getId());
        Assert.assertEquals(orderItem.getOrder().getId(), order.getId());

        orderService.deleteOrderItemsByOrder(orderItem);

        orderItem = orderService.getOrderItem(orderItem.getId());
        Assert.assertEquals(orderItem, null);

        Product product = products.get(0);
        catalogService.deleteProductsByCategory(product);

        products = catalogService.getProductListByCategory(pc.getId());
        Assert.assertEquals(products.size(), 0);

        catalogService.deleteProductCategory(pc);
        pc = catalogService.getCategoryByName("ordertest");
        Assert.assertEquals(pc, null);

        // Begin to test delete
        orderService.deleteOrder(order);

        orders = orderService.getOrderByUserEmail("ordertest@hotmail.com");
        Assert.assertEquals(orders.size(), 0);

        orderService.deletePaymentType(paymentType);

        paymentType = orderService.getPaymentTypeByName("testPaymentType");
        Assert.assertEquals(paymentType, null);

        orderService.deleteOrderState(orderState);

        orderState = orderService.getOrderStateByName("testOrderState");
        Assert.assertEquals(orderState, null);

        customerService.deleteCustomersByType(customer);
        customer = customerService.getCustomerByEmail("ordertest@hotmail.com");
        Assert.assertEquals(customer, null);

        customerService.deleteCustomerType(customerType);
        customerType = customerService.getCustomerTypeByName("ordertest");
        Assert.assertEquals(customerType, null);
    }
}