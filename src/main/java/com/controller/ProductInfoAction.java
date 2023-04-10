package com.controller;

import com.pojo.ProductInfo;
import com.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/prod")
public class ProductInfoAction {
    @Autowired
    ProductInfoService productInfoService;

    @RequestMapping("/list")
    public String getList(Model model){
        List<ProductInfo> productInfos = productInfoService.selectAll();
        model.addAttribute("list",productInfos);
        return "product";
    }
}
