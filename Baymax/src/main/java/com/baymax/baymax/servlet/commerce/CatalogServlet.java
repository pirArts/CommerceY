package com.baymax.baymax.servlet.commerce;

import com.baymax.baymax.servlet.BaseServlet;
import com.baymax.baymax.servlet.OperationResult;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baymax.baymax.model.ProductCategory;
import com.baymax.baymax.model.Product;
import com.baymax.baymax.service.commerce.catlog.CatalogService;
import com.baymax.baymax.utils.common.JsonUtil;
import com.baymax.baymax.utils.common.ServletUtil;

public class CatalogServlet extends BaseServlet{

    private final static Logger logger = LoggerFactory.getLogger(CatalogServlet.class);

    @Autowired
    private CatalogService catalogService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
        List<ProductCategory> categoryList = catalogService.getCategoryList();

        String json = "{}";
        if(categoryList.size() > 0){
            List<Product> productList = catalogService.getProductListByCategory(categoryList.get(0).getId());
            json = JsonUtil.Serialize(productList);
        }
        
        logger.debug(json);
        
        ServletUtil.writeResponse(resp, 200, json);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String postData = ServletUtil.GetPostData(req);
        Product product = (Product)JsonUtil.DeSerialize(postData, Product.class);
        
        OperationResult result = new OperationResult();
        if(product != null){
            try{
                catalogService.insertProduct(product);
                result.setResult("Success");
            }
            catch(Exception e){
                result.setResult(e.getMessage());
            }
        }
        
        String json = JsonUtil.Serialize(result);
        logger.debug(json);
        
        ServletUtil.writeResponse(resp, 200, json);
    }
}