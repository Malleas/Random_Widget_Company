package com.gcu.clc.controller;

import com.gcu.clc.business.ProductBusinessService;
import com.gcu.clc.model.ProductModel;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.condition.RequestConditionHolder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private ProductBusinessService productBusinessService;

    @GetMapping("/")
    public ModelAndView display() {
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        ServletRequestAttributes attributes = (ServletRequestAttributes) requestAttributes;
        HttpServletRequest request = attributes.getRequest();
        HttpSession session = request.getSession(true);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("title", "Cart Page");
        List<ProductModel> cart = (List<ProductModel>) session.getAttribute("cart");
        modelAndView.addObject("cart", cart);
        modelAndView.setViewName("cart");
        return modelAndView;
    }

    @PostMapping("/addItem")
    public ModelAndView addItem(int productId, HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        ProductModel product = productBusinessService.getById(productId);
        product.setProductQuantity(1);
        List<ProductModel> cart = (List<ProductModel>) request.getSession().getAttribute("cart");
        cart.add(product);
        request.getSession().setAttribute("cart", cart);
        HttpSession session = request.getSession();
        modelAndView.addObject("cart", cart);
        modelAndView.setViewName("cart");
        return modelAndView;
    }

    @PostMapping("/addQuantity")
    public ModelAndView addQuantity(int addId, HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        List<ProductModel> cart = (List<ProductModel>) request.getSession().getAttribute("cart");
        for (ProductModel productModel : cart) {
                if (productModel.getProductId() == addId){
                    productModel.setProductQuantity(productModel.getProductQuantity() + 1);
                }
        }
        request.getSession().setAttribute("cart", cart);
        modelAndView.setViewName("cart");
        return this.display();
    }

    @PostMapping("/subQuantity")
    public ModelAndView subQuantity(int subId, HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        List<ProductModel> cart = (List<ProductModel>) request.getSession().getAttribute("cart");
        for (ProductModel productModel : cart) {
            if (productModel.getProductId() == subId){
                productModel.setProductQuantity(productModel.getProductQuantity() - 1);
            }
        }
        request.getSession().setAttribute("cart", cart);
        modelAndView.setViewName("cart");
        return this.display();
    }
}
