package com.gcu.clc.data;

import com.gcu.clc.model.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersDataService implements DataAccessInterface<OrderModel> {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public OrdersDataService(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public List<OrderModel> getAll() {
        String sql = "SELECT * FROM ORDERS";
        List<OrderModel> orders = new ArrayList<>();
        try {
            SqlRowSet srs = jdbcTemplate.queryForRowSet(sql);
            while (srs.next()){
                orders.add(new OrderModel(
                   srs.getInt("ORDER_ID"),
                   srs.getInt("PURCHASE_ID"),
                   srs.getInt("USER_ID"),
                   srs.getInt("ADDRESS_ID"),
                   srs.getInt("PRODUCT_ID"),
                   srs.getFloat("ORDER_TOTAL")
                ));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public OrderModel getById(int id) {
        String sql = "SELECT * FROM ORDERS WHERE ORDER_ID = ?";
        OrderModel order = new OrderModel();
        try {
            SqlRowSet srs = jdbcTemplate.queryForRowSet(sql, id);
            while (srs.next()){
                order.setOrderId(srs.getInt("ORDER_ID"));
                order.setUserId(srs.getInt("USER_ID"));
                order.setAddressId(srs.getInt("ADDRESS_ID"));
                order.setProductId(srs.getInt("PRODUCT_ID"));
                order.setOrderTotal(srs.getFloat("ORDER_TOTAL"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public boolean create(OrderModel orderModel) {
        String sql = "INSERT INTO ORDERS(PURCHASE_ID, USER_ID, ADDRESS_ID, PRODUCT_ID, ORDER_TOTAL) VALUES(?,?,?,?,?)";
        try {
            jdbcTemplate.update(sql, orderModel.getPurchaseId(), orderModel.getUserId(), orderModel.getAddressId(), orderModel.getProductId(),
                    orderModel.getOrderTotal());
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean update(OrderModel orderModel) {
        String sql = "UPDATE ORDERS SET USER_ID = ?, ADDRESS_ID = ? WHERE PURCHASE_ID = ?";
        try {
            jdbcTemplate.update(sql, orderModel.getUserId(), orderModel.getAddressId(), orderModel.getPurchaseId());
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(OrderModel orderModel) {
        String sql = "DELETE FROM ORDERS WHERE PURCHASE_ID = ?";
        try {
            jdbcTemplate.update(sql, orderModel.getPurchaseId());
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
