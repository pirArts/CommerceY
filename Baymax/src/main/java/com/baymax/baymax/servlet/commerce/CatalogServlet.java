package com.baymax.baymax.servlet.commerce;

import com.baymax.baymax.servlet.BaseServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import com.google.gson.Gson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baymax.baymax.model.ProductCategory;
import com.baymax.baymax.model.Product;
import com.baymax.baymax.service.commerce.catlog.CatalogService;

public class CatalogServlet extends BaseServlet{

    private final static Logger logger = LoggerFactory.getLogger(CatalogServlet.class);

    @Autowired
    private CatalogService catalogService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
        List<ProductCategory> categoryList = catalogService.getCategoryList();

        String json = "{}";
        if(categoryList.size() > 0)
        {
            List<Product> productList = catalogService.getProductListByCategory(categoryList.get(0).getId());
            Gson gson = new Gson();
            json = gson.toJson(productList);
        }
        logger.debug(json);
        resp.setStatus(200);
        writeResponse(resp, json);
    }
}