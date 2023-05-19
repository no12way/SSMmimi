package com.listener;

import com.pojo.ProductType;
import com.service.ProductTypeService;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

//监听器的注册
//在web服务器加载的时候,会自动运行
@WebListener
public class ProductTypeListener implements ServletContextListener {
    //监听器的初始化
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //手工取出spring容器里的产品类别
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext_*.xml");
        ProductTypeService productType = (ProductTypeService)applicationContext.getBean("productTypeServiceImpl");
        List<ProductType> allType = productType.getAllType();
        //把所有类型都放入全局变量中
        sce.getServletContext().setAttribute("typeList",allType);
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
