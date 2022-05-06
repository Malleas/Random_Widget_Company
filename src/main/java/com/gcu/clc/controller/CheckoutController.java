package com.gcu.clc.controller;

import com.gcu.clc.business.AddressBusinessService;
import com.gcu.clc.business.OrdersBusinessService;
import com.gcu.clc.business.UserBusinessService;
import com.gcu.clc.model.AddressModel;
import com.gcu.clc.model.CreditCardModel;
import com.gcu.clc.model.OrderModel;
import com.gcu.clc.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/checkout")
public class CheckoutController {

    @Autowired
    private AddressBusinessService addressBusinessService;

    @Autowired
    private OrdersBusinessService ordersBusinessService;

    @GetMapping("/")
    public ModelAndView display(){
        ModelAndView modelAndView = new ModelAndView();
        CreditCardModel creditCardModel = new CreditCardModel();
        modelAndView.addObject("title", "Checkout Form");
        modelAndView.addObject("creditCardModel", creditCardModel);
        modelAndView.setViewName("checkout");
        return modelAndView;
    }

    @PostMapping("/purchase")
    public ModelAndView purchase(@Valid CreditCardModel creditCardModel, BindingResult bindingResult, Model model, HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("purchaseComplete");
        int userId = (int) request.getSession().getAttribute("userId");
        int addressId = addressBusinessService.getAddressIdByUserId(userId);
        List<ProductModel> cart = (List<ProductModel>) request.getSession().getAttribute("cart");
        float total = 0;
        Random random = new Random();
        int purchaseId = random.nextInt(100000);
        for (ProductModel product: cart) {
            total = total + (product.getProductQuantity() * product.getProductPrice());
            OrderModel orderModel = new OrderModel();
            orderModel.setUserId(userId);
            orderModel.setAddressId(addressId);
            orderModel.setPurchaseId(purchaseId);
            orderModel.setProductId(product.getProductId());
            orderModel.setOrderTotal(total);
            ordersBusinessService.addOrder(orderModel);
        }
        return modelAndView;
    }
}
