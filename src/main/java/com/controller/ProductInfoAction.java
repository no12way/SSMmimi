package com.controller;

import com.github.pagehelper.PageInfo;
import com.pojo.ProductInfo;
import com.service.ProductInfoService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

@Controller
@RequestMapping("/prod")
public class ProductInfoAction {
    //每一页的显示记录数
    public static final int PAGE_SIZE = 5;
    @Autowired
    ProductInfoService productInfoService;
    //查询全部数据
    @RequestMapping("/list")
    public String getList(Model model){
        List<ProductInfo> productInfos = productInfoService.selectAll();
        model.addAttribute("list",productInfos);
        return "product";
    }
    //通过分页展示数据
    //显示第一页的五条数据
    @RequestMapping("/split")
    public String Split(HttpServletRequest request){
        PageInfo pageInfo = productInfoService.splitPage(1, PAGE_SIZE);
        //把分页后的数据存储到请求域中
        request.setAttribute("info",pageInfo);
        return "product";
    }
    //通过ajax请求刷新页面数据,通过ajax请求,会跳过解析器,把数据转换成json,所以必须要有responseBody
    @ResponseBody
    @RequestMapping("/ajaxSplit")
    public void ajaxSplit(int page, HttpSession session) {
        PageInfo info = productInfoService.splitPage(page, PAGE_SIZE);
        //把数据存放到session域中
        session.setAttribute("info", info);
    }

}
