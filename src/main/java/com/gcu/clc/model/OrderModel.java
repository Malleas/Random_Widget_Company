package com.gcu.clc.model;

import java.util.List;

public class OrderModel {

    private int orderId;
    private int purchaseId;
    private int userId;
    private int addressId;
    private int productId;
    private float orderTotal;

    public OrderModel(int orderId, int purchaseId, int userId, int addressId, int productId, float orderTotal) {
        this.orderId = orderId;
        this.purchaseId = purchaseId;
        this.userId = userId;
        this.addressId = addressId;
        this.productId = productId;
        this.orderTotal = orderTotal;
    }

    public OrderModel(int purchaseId, int userId, int addressId, int productId, float orderTotal) {
        this.purchaseId = purchaseId;
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

    public int getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
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
