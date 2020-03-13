 package com.home.controller;
         import com.alibaba.fastjson.JSON;
         import com.alibaba.fastjson.JSONObject;
         import com.baidu.ueditor.ActionEnter;
         import org.springframework.beans.factory.annotation.Value;
         import org.springframework.core.io.ClassPathResource;
         import org.springframework.stereotype.Controller;
         import org.springframework.util.ClassUtils;
         import org.springframework.web.bind.annotation.RequestMapping;
         import org.springframework.web.bind.annotation.ResponseBody;
         import org.springframework.web.multipart.MultipartFile;
         import org.springframework.web.multipart.MultipartHttpServletRequest;
         import javax.servlet.http.HttpServletRequest;
         import javax.servlet.http.HttpServletResponse;
         import java.io.*;
         import java.util.Calendar;
         import java.util.Map;
 /**
  * Created by 李小末 on 2019/5/23 14:31
  */
 @RequestMapping("img")
 @Controller
 public class CommonController {
     //@Value("${web.ueditor-path}")
     private String path;
     // @Value("${web.upload-path}")
     private String upload;

     @RequestMapping("UeConfig")
     @ResponseBody
     public Object config(HttpServletRequest request, HttpServletResponse response){
         String action = request.getParameter("action");
         if ("config".equals(action)){
             response.setContentType("application/json");
             String rootPath = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/ueditor";
             try {
                ClassPathResource resource = new ClassPathResource( "static/ueditor/jsp/config.json");
                 //返回读取指定资源的输入流
                 InputStream is=this.getClass().getResourceAsStream("src/main/resource/static/ueditor/jsp/config.json");
                 BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new java.io.File(path+"\\config.json"))));
                 String s="";
                 //StringBuffer sb = new StringBuffers();
                 while ((s = br.readLine()) != null){
                     //sb.append(s);
                     //String result = sb.toString().replaceAll("/\\*(.|[\\r\\n])*？\\*/", "");
                     System.out.println(rootPath);
                   //  String exec = new ActionEnter(request, rootPath).exec();
                    // JSONObject json = JSON.parseObject(result);
                    // return json.toJSONString();
                 }
             } catch (FileNotFoundException e) {
                 e.printStackTrace();
             } catch (IOException e) {
                 e.printStackTrace();
             }

         }else {
             MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
             Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
             for (Map.Entry<String,MultipartFile> entity : fileMap.entrySet()){
                 MultipartFile f = entity.getValue();
                 System.err.println(f+"889999");
                 return imgUpdate(f);
             }
         }
         return null;
     }

     @ResponseBody
     @RequestMapping("imgUpdate")
     private String imgUpdate(MultipartFile file) {
         if (file.isEmpty()){
             return "error";
         }
         //获取文件名
         String filename = file.getOriginalFilename();
         System.out.println(filename);
         //获取文件后缀名
         String suffixName = filename.substring(filename.lastIndexOf("."));
         //这里使用随机字符串来重新命名图片
         filename=Calendar.getInstance().getTimeInMillis()+suffixName;
         //这里的路径为nginx的代理路径，这里是/data/images/xxx.png
         File dest = new File(upload + File.separator + filename);
         //检测是否存在目录
         if (!dest.getParentFile().exists()){
             dest.getParentFile().mkdir();
         }
         try {
             file.transferTo(dest);
             //url的值为图片的实际访问地址 这里我用了nginx代理，访问路径是http://localhost/xxx.png
             String config = "{\"state\": \"SUCCESS\"," + "\"url\": \"" + filename + "\","
                     + "\"title\": \"" + filename + "\"," + "\"original\": \"" + filename + "\"}";
             System.out.println(config);
             return config;
         } catch (IOException e) {
             e.printStackTrace();
         }
         return "error";
     }
 }
