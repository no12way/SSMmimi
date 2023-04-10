package com.service.impl;

import com.mapper.AdminMapper;
import com.pojo.Admin;
import com.pojo.AdminExample;
import com.service.AdminService;
import com.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

//交给spring
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;
    @Override
    public Admin login(String name, String pwd) {
        AdminExample adminExample = new AdminExample();
        //相当于向查询语句where 后面追加了 name = ?(name)
        adminExample.createCriteria().andANameEqualTo(name);
        List<Admin> admins = adminMapper.selectByExample(adminExample);
        //如果admin表中有数据,表示查询到实体类admin
        if (admins.size() > 0) {
            //此时默认查询到的第一个结果对象就是我们要找的
            Admin admin = admins.get(0);
            //把密码进行md5加密,因为从数据库取出来的密码是md5加密后的密码
            String md5 = MD5Util.getMD5(pwd);
            String s = admin.getaPass();
            //在用户名相同的情况下,如果密码对的上,那么就返回这个admin对象
            if (md5.equals(s)){
                return admin;
            }
        }
        return null;
    }
}
