package com.baymax.baymax.dao;

import java.util.List;

import com.baymax.baymax.model.ProductCategory;

public interface ProductCategoryDAO {
    List<ProductCategory> getCategoryList();
    ProductCategory getCategory(long categoryId);
    ProductCategory getCategoryByName(String name);

    void insertProductCategory(ProductCategory productCategory);
    void deleteProductCategory(ProductCategory productCategory);
}