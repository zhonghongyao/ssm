package com.zhong.controller;



        import java.io.File;
        import java.io.IOException;

        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpSession;

        import com.zhong.service.WordService;
        import org.apache.commons.io.FileUtils;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestParam;
        import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 *
 * 文件上传处理类
 *
 */
@Controller
@RequestMapping("upload")
public class FileController {

   @Autowired
    WordService wordService;

    //单文件上传
    @RequestMapping(value = "/file")
    public String queryFileData(
            @RequestParam("uploadfile") CommonsMultipartFile file,
            HttpServletRequest request) {
        // MultipartFile是对当前上传的文件的封装，当要同时上传多个文件时，可以给定多个MultipartFile参数(数组)
        if (!file.isEmpty()) {
            String type = file.getOriginalFilename().substring(
                    file.getOriginalFilename().indexOf("."));// 取文件格式后缀名
            String filename = System.currentTimeMillis() + type;// 取当前时间戳作为文件名
            String path = request.getSession().getServletContext()
                    .getRealPath("/upload/" + filename);// 存放位置

            request.getSession().setAttribute("filename",path);
            File destFile = new File(path);
            try {
                // FileUtils.copyInputStreamToFile()这个方法里对IO进行了自动操作，不需要额外的再去关闭IO流
                FileUtils
                        .copyInputStreamToFile(file.getInputStream(), destFile);// 复制临时文件到指定目录下
            } catch (IOException e) {
                e.printStackTrace();
            }
            HttpSession httpSession=request.getSession();
            try{
                wordService.readFile(path);
            }catch (Exception e){
                e.printStackTrace();
            }
          return "zhexian";

        } else {
            return "redirect:upload_error.jsp";
        }
    }
}
