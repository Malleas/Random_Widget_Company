package com.gcu.clc.model;

import java.util.List;

public class OrderModel {

    private int orderId;
    private int userId;
    private int addressId;
    private int productId;
    private float orderTotal;

    public OrderModel(int orderId, int userId, int addressId, int productId, float orderTotal) {
        this.orderId = orderId;
        this.userId = userId;
        this.addressId = addressId;
        this.productId = productId;
        this.orderTotal = orderTotal;
    }

    public OrderModel(int userId, int addressId, int productId, float orderTotal) {
        this.userId = userId;
        this.addressId = addressId;
        this.productId = productId;
        this.orderTotal = orderTotal;
    }

    public OrderModel() {
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public float getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(float orderTotal) {
        this.orderTotal = orderTotal;
    }
}
