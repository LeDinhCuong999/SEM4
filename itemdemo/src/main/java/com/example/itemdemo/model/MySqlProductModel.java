package com.example.itemdemo.model;

import com.example.itemdemo.entity.Product;
import com.example.itemdemo.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class MySqlProductModel implements ProductModel {
    @Override
    public Product save(Product product) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "insert into students " +
                    "(id, name, price, thumbnail, createdAt, updatedAt, status) " +
                    "values " +
                    "(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, product.getId());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setString(3, product.getPrice());
            preparedStatement.setString(4, product.getThumbnail());
            preparedStatement.setString(5,product.getContent());
            preparedStatement.setInt(6,product.getQty());
            preparedStatement.setString(7, product.getCreatedAt().toString());
            preparedStatement.setString(8, product.getUpdatedAt().toString());
            preparedStatement.setInt(9, product.getStatus());
            System.out.println("Connection success!");
            preparedStatement.execute();
            return product;
        } catch (SQLException e) {
            e.printStackTrace();
        }
            return null;
    }

    @Override
    public List<Product> findAll() {
        List<Product> list = new ArrayList<>();
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from products where status = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, 1);
            System.out.println("Connection success!");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String price = resultSet.getString("price");
                String thumbnail = resultSet.getString("thumbnail");
                String content = resultSet.getString("content");
                int qty = resultSet.getInt("qty");
                LocalDateTime createdAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime updatedAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("updatedAt").toInstant(), ZoneId.systemDefault());
                int status = resultSet.getInt("status");
                Product product = new Product(id, name, price, thumbnail, content, qty);
                list.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Product findById(String id) {
        Product product = null;
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from products where status = ? and id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                String name = resultSet.getString("name");
                String price = resultSet.getString("price");
                String thumbnail = resultSet.getString("thumbnail");
                String content = resultSet.getString("content");
                int qty = resultSet.getInt("qty");
                LocalDateTime createdAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime updatedAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("updatedAt").toInstant(), ZoneId.systemDefault());
                int status = resultSet.getInt("status");
                product = new Product(id, name, price, thumbnail, content, qty);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
        public Product update(String id, Product updateProduct) {
            try {
                Connection connection = ConnectionHelper.getConnection();
                String sqlQuery = "update products " +
                        "set id = ?, name = ?, price = ?, thumbnail = ?, content = ?, qty = ?, createdAt = ?, updatedAt = ?, status = ? where id = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
                preparedStatement.setString(1, updateProduct.getId());
                preparedStatement.setString(2, updateProduct.getName());
                preparedStatement.setString(3, updateProduct.getPrice());
                preparedStatement.setString(4, updateProduct.getThumbnail());
                preparedStatement.setString(5, updateProduct.getContent());
                preparedStatement.setInt(5, updateProduct.getQty());
                preparedStatement.setString(7, updateProduct.getCreatedAt().toString());
                preparedStatement.setString(8, updateProduct.getUpdatedAt().toString());
                preparedStatement.setInt(9, updateProduct.getStatus());
                preparedStatement.setString(10, id);
                System.out.println("Connection success!");
                preparedStatement.execute();
                return updateProduct;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
    }

    @Override
    public boolean delete(String id) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "update products " +
                    "set status = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, -1);
            preparedStatement.setString(2, id);
            System.out.println("Connection success!");
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
