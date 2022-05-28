package com.t2010a.fruits.entity.cart;

import com.t2010a.fruits.entity.myenum.CartItemStatus;
import com.t2010a.fruits.entity.base.BaseEntity;
public class CartItem extends BaseEntity{

    private int shoppingcartId;
    private int productId; // san pham nao
    private String productName;
    private String productThumbnail;
    private double unitPrice; // gia tien bao nhieu
    private int quantity; // so luong

    private CartItemStatus status;

    public CartItem() {
    }

    public int getShoppingcartId() {
        return shoppingcartId;
    }


    public void setShoppingcartId(int shoppingcartId) {
        this.shoppingcartId = shoppingcartId;
    }


    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductThumbnail() {
        return productThumbnail;
    }

    public void setProductThumbnail(String productThumbnail) {
        this.productThumbnail = productThumbnail;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public CartItemStatus getStatus() {
        return status;
    }

    public void setStatus(CartItemStatus status) {
        this.status = status;
    }
}
