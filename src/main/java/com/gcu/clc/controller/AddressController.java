package com.gcu.clc.controller;

import com.gcu.clc.business.AddressBusinessService;
import com.gcu.clc.model.AddressModel;
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

@Controller
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressBusinessService addressBusinessService;

    @GetMapping("/")
    public ModelAndView display() {
        ModelAndView modelAndView = new ModelAndView();
        AddressModel addressModel = new AddressModel();
        modelAndView.addObject("title", "Address Page");
        modelAndView.addObject("addressModel", addressModel);
        modelAndView.setViewName("address");
        return modelAndView;
    }

    @PostMapping ("/addAddress")
    public ModelAndView addAddress(@Valid AddressModel addressModel, BindingResult bindingResult, Model model, HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addAddress");
        int userId = (int) request.getSession().getAttribute("userId");
        addressModel.setUserId(userId);
        if(bindingResult.hasErrors()){
            model.addAttribute("title", "Add Address Page");
            return modelAndView;
        }
        if(addressBusinessService.addAddress(addressModel)){
            modelAndView.setViewName("index");
        }
        return modelAndView;
    }
}
