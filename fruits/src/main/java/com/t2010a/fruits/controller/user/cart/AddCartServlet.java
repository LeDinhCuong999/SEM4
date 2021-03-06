package com.t2010a.fruits.controller.user.cart;

import com.t2010a.fruits.entity.Product;
import com.t2010a.fruits.entity.cart.ShoppingCart;
import com.t2010a.fruits.model.product.MySqlProductModel;
import com.t2010a.fruits.model.product.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AddCartServlet extends HttpServlet {
    private ProductModel productModel;

    public AddCartServlet() {
        this.productModel = new MySqlProductModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
        if (shoppingCart == null) {
            shoppingCart = new ShoppingCart();
        }
        try {
            String id = req.getParameter("id");
            int quantity = Integer.parseInt(req.getParameter("quantity"));
            Product product = productModel.findById(id);
            if (product == null) {
                req.setAttribute("message", "Error!!");
                req.getRequestDispatcher("/user/errors/404.jsp").forward(req, resp);
                return;
            }
            if (quantity <= 0) {
                req.setAttribute("message", "Error!!");
                req.getRequestDispatcher("/user/errors/404.jsp").forward(req, resp);
                return;
            }
            shoppingCart.add(product, quantity);
            session.setAttribute("shoppingCart", shoppingCart);
            resp.sendRedirect("/cart/show");
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("message", "Error!!");
            req.getRequestDispatcher("/user/errors/500.jsp").forward(req, resp);
        }
    }
}