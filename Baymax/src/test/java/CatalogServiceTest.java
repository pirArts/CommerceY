import junit.framework.Assert;
import org.junit.Test;

import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.baymax.baymax.model.ProductCategory;
import com.baymax.baymax.model.Product;
import com.baymax.baymax.service.commerce.catlog.CatalogService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:conf/spring.xml", "classpath:conf/spring-mybatis.xml"})
public class CatalogServiceTest {
    
    @Autowired 
    private CatalogService catalogService;
    
    @Test
    public void testProductOperation(){

        ProductCategory productCategory = new ProductCategory();
        productCategory.setName("test");
        catalogService.insertProductCategory(productCategory);

        ProductCategory pc = catalogService.getCategoryByName("test");
        Assert.assertEquals(pc.getName(), "test");

        Product product1 = new Product();
        product1.setName("java-mybatis");
        product1.setPrice(100.0f);
        product1.setDescription("java web development");
        product1.setProductCategory(pc);
        catalogService.insertProduct(product1);

        Product product2 = new Product();
        product2.setName("java-spring");
        product2.setPrice(100.0f);
        product2.setDescription("java web development");
        product2.setProductCategory(pc);
        catalogService.insertProduct(product2);

        List<Product> products = catalogService.getProductListByCategory(pc.getId());
        Assert.assertEquals(products.size(), 2);

        Product product = products.get(0);
        catalogService.deleteProductsByCategory(product);

        products = catalogService.getProductListByCategory(pc.getId());
        Assert.assertEquals(products.size(), 0);

        catalogService.deleteProductCategory(pc);
        pc = catalogService.getCategoryByName("test");
        Assert.assertEquals(pc, null);
    }
}
