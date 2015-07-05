package com.baymax.baymax.dao;

import java.util.List;

import com.baymax.baymax.model.Product;

public interface ProductDAO {
    List<Product> getProductListByCategory(long categoryId);
    Product getProduct(long productId);
    List<Product> searchProductList(String keywords);

    void insertProduct(Product product);
    void deleteProduct(Product product);
    void deleteProductsByCategory(Product product);
}