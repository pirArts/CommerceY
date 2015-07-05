package com.baymax.baymax.service.commerce.catlog;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baymax.baymax.model.ProductCategory;
import com.baymax.baymax.dao.ProductCategoryDAO;

import com.baymax.baymax.model.Product;
import com.baymax.baymax.dao.ProductDAO;

@Service
public class CatalogService{
 
    @Autowired
    private ProductCategoryDAO productCategoryDAO;
    
    @Autowired
    private ProductDAO productDAO;
     
    public List<ProductCategory> getCategoryList()
    {
        return  productCategoryDAO.getCategoryList();
    }

    public ProductCategory getCategory(long categoryId)
    {
        return productCategoryDAO.getCategory(categoryId);
    }

    public ProductCategory getCategoryByName(String name)
    {
        return productCategoryDAO.getCategoryByName(name);
    }

    public void insertProductCategory(ProductCategory productCategory)
    {
        productCategoryDAO.insertProductCategory(productCategory);
    }

    public void deleteProductCategory(ProductCategory productCategory)
    {
        productCategoryDAO.deleteProductCategory(productCategory);
    }
    
    public Product getProduct(long productId) 
    {
        return productDAO.getProduct(productId);
    }

    public List<Product> getProductListByCategory(long categoryId) 
    {
        return productDAO.getProductListByCategory(categoryId);
    }

    public List<Product> searchProductList(String keywords) 
    {
        List<Product> products = new ArrayList<Product>();
        for(String keyword : keywords.split("\\s+"))
        {
            products.addAll(productDAO.searchProductList("%" + keyword.toLowerCase() + "%"));
        }
        return products;
     }

     public void insertProduct(Product product)
     {
        productDAO.insertProduct(product);
     }

     public void deleteProduct(Product product)
     {
        productDAO.deleteProduct(product);
     }

     public void deleteProductsByCategory(Product product)
     {
        productDAO.deleteProductsByCategory(product);
        // productCategoryDAO.DeleteProductCategory(product.getProductCategory());
     }
}