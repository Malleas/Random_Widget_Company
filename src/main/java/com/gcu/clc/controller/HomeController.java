package com.gcu.clc.controller;

import com.gcu.clc.business.UserBusinessService;
import com.gcu.clc.model.LoginModel;
import com.gcu.clc.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
@SessionAttributes({"user", "userId", "cart"})
public class HomeController {

    @Autowired
    private UserBusinessService userBusinessService;

    @GetMapping("/index")
    public ModelAndView index(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        List<ProductModel> cart = new ArrayList<>();
        String currentUsername = userBusinessService.getUserName();
        int userId = userBusinessService.getUserIdByUsername(currentUsername);
        request.getSession().setAttribute("user", currentUsername);
        request.getSession().setAttribute("userId", userId);
        request.getSession().setAttribute("cart", cart);
        HttpSession session = request.getSession();
        modelAndView.setViewName("index");
        return modelAndView;
    }

}
