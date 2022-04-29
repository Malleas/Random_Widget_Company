package com.gcu.clc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cart")
public class CartController {

    @GetMapping("/")
    public ModelAndView display() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("title", "Cart Page");
        // modelAndView.addObject("cart", productBusinessService.getAll());  //TODO this needs to either get a cart from the DB or from session
        modelAndView.setViewName("cart");
        return modelAndView;
    }
}
