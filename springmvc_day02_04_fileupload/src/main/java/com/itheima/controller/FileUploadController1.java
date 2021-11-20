package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * MultipartFile file：保存了上传文件的信息
 */
@Controller
public class FileUploadController1 {

    @RequestMapping(value = "/fileupload")
    public String fileupload1(MultipartFile file, HttpServletRequest request) throws IOException {
        System.out.println("file upload is running ..." + file);
         /*
         file就是你上传的文件，注意这里要对应jsp的name属性值
        得到file为：org.springframework.web.multipart.commons.CommonsMultipartFile@38cc1696
        显然这个对象已经加载到内存中了
         */

        /*
        文件操作的四个注意事项：用file中提供的方法解决
         */
//        System.out.println(file.getSize());//545832：文件保存占的硬盘空间
//        System.out.println(file.getBytes());//[B@78f7e525：文件中的所有数据
//        System.out.println(file.getContentType());//image/jpeg：文件类型
//        System.out.println(file.getName());//file：这个是形参的名称（也是表单对应的名称）
//        System.out.println(file.getOriginalFilename());//最近照片.jpg：这个才是真正的文件名
//        System.out.println(file.isEmpty());//是否为空文件

        //首先判断是否为空文件
        if(!file.isEmpty()) {
            //如果大小在范围内
            String filename = file.getOriginalFilename();
            //设置保存的路径
            /*
            要使用HttpServletRequest request来得到tomcat路径，再去创建自己的路径

            getRealPath(getRealPath(：获取与给定虚拟路径对应的真实路径。
             */
            String realPath = request.getServletContext().getRealPath("/images");
//            System.out.println(realPath);//D:\developer_tools\workplace\SpringMVC\springmvc_fileupload\src\main\webapp\images

            file.transferTo(new File(realPath,filename));
            /*
            transferTo：这是上传文件用的方法
            将接收到的文件传输到给定名称和格式的目标文件
            new File(：从父路径名字符串和子路径名字符串创建一个新的File实例。
             */
        }

        return "page.jsp";
    }
}

