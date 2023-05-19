package com.controller;

import com.github.pagehelper.PageInfo;
import com.pojo.ProductInfo;
import com.service.ProductInfoService;
import com.utils.FileNameUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
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

    @ResponseBody
    @RequestMapping("/ajaxImg")
    public Object ajaxImg(MultipartFile pimage,HttpServletRequest request){
        //文件上传
        //异步上传文件名,增加和更新就用这个名字
        //给文件取名
        String saveFileName = FileNameUtil.getUUIDFileName() + FileNameUtil.getFileType(pimage.getOriginalFilename());
        try{
        //取出路径
        String realPath = request.getServletContext().getRealPath("/image_big");
        System.out.println("realPath"+realPath);
        //转存
        pimage.transferTo(new File(realPath + File.separator + saveFileName));}
        catch (Exception e){
            e.printStackTrace();
        }
        //上面的代码实现了文件上传的功能
        //为了在客户端显示图片，要将存储的文件名回传下去，由于是自定义的上传插件，所以此处要手工处理JSON
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("imgurl",saveFileName);
        return jsonObject.toString();
    }

}
