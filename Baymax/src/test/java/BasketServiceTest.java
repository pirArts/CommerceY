import junit.framework.Assert;
import org.junit.Test;

import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.baymax.baymax.model.Basket;
import com.baymax.baymax.model.BasketItem;
import com.baymax.baymax.service.commerce.cart.CartService;

import com.baymax.baymax.model.CustomerType;
import com.baymax.baymax.model.Customer;
import com.baymax.baymax.service.identity.CustomerService;

import com.baymax.baymax.model.ProductCategory;
import com.baymax.baymax.model.Product;
import com.baymax.baymax.service.commerce.catlog.CatalogService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:conf/spring.xml", "classpath:conf/spring-mybatis.xml"})
public class BasketServiceTest {
    
    @Autowired 
    private CartService basketService;

    @Autowired 
    private CustomerService customerService;

    @Autowired 
    private CatalogService catalogService;
    
    @Test
    public void testBasketOperation(){
        CustomerType customerType = new CustomerType();
        customerType.setName("baskettest");
        customerService.insertCustomerType(customerType);

        customerType = customerService.getCustomerTypeByName("baskettest");
        Assert.assertEquals(customerType.getName(), "baskettest");

        Customer customer = new Customer();
        customer.setEmail("baskettest@hotmail.com");
        customer.setPassword("12");
        customer.setNickname("Hao");
        customer.setPhone("135");
        customer.setAddress("street A");
        customer.setGender("M");
        customer.setWechatOpenID("abcd");
        customer.setCustomerType(customerType);
        customerService.insertCustomer(customer);

        customer = customerService.getCustomerByEmail("baskettest@hotmail.com");
        Assert.assertEquals(customer.getNickname(), "Hao");

        Basket basket = new Basket();
        basket.setAmount(100.0f);
        basket.setCustomer(customer);
        basketService.insertBasket(basket);

        basket = basketService.getBasketByUserEmail("baskettest@hotmail.com");
        Assert.assertEquals(basket.getAmount(), 100.0f);

        ProductCategory productCategory = new ProductCategory();
        productCategory.setName("baskettest");
        catalogService.insertProductCategory(productCategory);

        ProductCategory pc = catalogService.getCategoryByName("baskettest");
        Assert.assertEquals(pc.getName(), "baskettest");

        Product product1 = new Product();
        product1.setName("baskettest-1");
        product1.setPrice(100.0f);
        product1.setDescription("java web development");
        product1.setProductCategory(pc);
        catalogService.insertProduct(product1);

        Product product2 = new Product();
        product2.setName("baskettest-2");
        product2.setPrice(100.0f);
        product2.setDescription("java web development");
        product2.setProductCategory(pc);
        catalogService.insertProduct(product2);

        List<Product> products = catalogService.getProductListByCategory(pc.getId());
        Assert.assertEquals(products.size(), 2);

        BasketItem basketItem = new BasketItem();
        basketItem.setBasket(basket);
        basketItem.setProduct(products.get(0));
        basketItem.setQuantity(2);
        basketService.insertBasketItem(basketItem);

        basketItem = new BasketItem();
        basketItem.setBasket(basket);
        basketItem.setProduct(products.get(1));
        basketItem.setQuantity(5);
        basketService.insertBasketItem(basketItem);

        basket = basketService.getBasketByUserEmail("baskettest@hotmail.com");
        Assert.assertEquals(basket.getBasketItems().size(), 2);

        basketItem = basketService.getBasketItem(basket.getBasketItems().get(0).getId());
        Assert.assertEquals(basketItem.getBasket().getId(), basket.getId());

        basketService.deleteBasketItemsByBasket(basketItem);

        basketItem = basketService.getBasketItem(basketItem.getId());
        Assert.assertEquals(basketItem, null);

        Product product = products.get(0);
        catalogService.deleteProductsByCategory(product);

        products = catalogService.getProductListByCategory(pc.getId());
        Assert.assertEquals(products.size(), 0);

        catalogService.deleteProductCategory(pc);
        pc = catalogService.getCategoryByName("baskettest");
        Assert.assertEquals(pc, null);

        basketService.deleteBasket(basket);
        basket = basketService.getBasketByUserEmail("baskettest@hotmail.com");
        Assert.assertEquals(basket, null);

        customerService.deleteCustomersByType(customer);
        customer = customerService.getCustomerByEmail("baskettest@hotmail.com");
        Assert.assertEquals(customer, null);

        customerService.deleteCustomerType(customerType);
        customerType = customerService.getCustomerTypeByName("baskettest");
        Assert.assertEquals(customerType, null);
    }
}
