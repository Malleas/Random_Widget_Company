package com.gcu.clc.business;

import com.gcu.clc.model.ProductList;
import com.gcu.clc.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/service")
public class ProductRestService
{
    @Autowired
    public ProductBusinessService service;

    @GetMapping(path="/getProduct/{id}")
    public ResponseEntity<?> getProduct(@PathVariable("id") Integer productId)
    {
        try
        {
            ProductModel product = service.getById(productId);
            if(product == null)
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            else
                return new ResponseEntity<>(product, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path="/getJson", produces={MediaType.APPLICATION_JSON_VALUE})
    public List<ProductModel> getProductsAsJson()
    {
        return service.getAll();
    }

    @GetMapping(path="/getXml", produces ={MediaType.APPLICATION_XML_VALUE})
    public ProductList getProductAsXml()
    {
        ProductList productList = new ProductList();
        productList.setProduct(service.getAll());
        return productList;
    }



}
