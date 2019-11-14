package org.zhangbiao.web.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.zhangbiao.dto.FileInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author: zhangbiao
 * @createTime: 2019/11/14 12:32
 */
@RestController
@RequestMapping("/file")
public class FileController {

    private String folder="D:\\workspace\\workspace-idea\\zhangbiao-security\\zhangbiao-security-demo\\src\\main\\java\\org\\zhangbiao\\web";

    @ApiOperation("文件上传")
    @PostMapping
    public FileInfo upload(@ApiParam("文件名") MultipartFile file) throws IOException {
        System.out.println("文件名："+file.getName());
        System.out.println("原始文件名："+file.getOriginalFilename());
        System.out.println("文件大小："+file.getSize());
        String uploadFile = System.currentTimeMillis()+".txt";
        File localFile = new File(folder,uploadFile);
        file.transferTo(localFile);
        return new FileInfo(localFile.getAbsolutePath());
    }

    @ApiOperation("文件下载")
    @GetMapping("/{id}")
    public void download(@ApiParam("文件名") @PathVariable String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
        try(InputStream inputStream = new FileInputStream(new File(folder,id+".txt"));
            OutputStream outputStream=response.getOutputStream();){
            response.setContentType("application/x-download");
            response.addHeader("Content-Disposition","attachment;filename=test.txt");
            IOUtils.copy(inputStream,outputStream);
            outputStream.flush();
        }
    }

}
