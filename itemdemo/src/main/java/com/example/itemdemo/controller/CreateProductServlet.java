package com.example.itemdemo.controller;

import com.example.itemdemo.entity.Product;
import com.example.itemdemo.model.MySqlProductModel;
import com.example.itemdemo.model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateProductServlet extends HttpServlet {

    private ProductModel productModel;

    public CreateProductServlet() {
        this.productModel = new MySqlProductModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // tra ve form
        req.setAttribute("product", new Product());
        req.setAttribute("action", 1);
        req.getRequestDispatcher("/admin/products/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF8");
        // xu li validate va save
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String price = req.getParameter("price");
        String thumbnail = req.getParameter("thumbnail");
        String content = req.getParameter("content");
        int qty = Integer.parseInt(req.getParameter("qty"));
        System.out.println(name);
        Product product = new Product(id, name, price, thumbnail, content, qty);
        // validate du lieu
        if (productModel.save(product) != null) {
            resp.sendRedirect("/admin/products/list");
        }else {
            req.getRequestDispatcher("/admin/products/form").forward(req, resp);
        }
    }
}
