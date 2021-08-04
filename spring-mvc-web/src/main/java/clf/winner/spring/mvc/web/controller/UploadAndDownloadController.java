package clf.winner.spring.mvc.web.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.file.Paths;

@Controller
@RequestMapping("/uploadAndDownload")
public class UploadAndDownloadController {

    private static final String DOWNLOAD_PATH ="/WEB-INF/download/";
    private static final String UPLOAD_PATH = "/WEB-INF/upload/";

    @RequestMapping(value="/init")
    public String init() {
        return "uploadAndDownload";
    }


    @ResponseBody
    @RequestMapping(value="/upload")
    public String upload(@RequestParam("file") MultipartFile file, HttpServletRequest request){

        String filePath = request.getSession().getServletContext().getRealPath(UPLOAD_PATH) + File.separator+ file.getOriginalFilename();

        try {
            file.transferTo(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("upload file success");

        return "OK";

    }

    @RequestMapping(value="/download")
    public void download(String fileName, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {

        String filePath = request.getSession().getServletContext().getRealPath(DOWNLOAD_PATH) + File.separator + fileName;
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(fileName,"UTF-8"));

        try {
            InputStream is = new FileInputStream(filePath);
            OutputStream os = response.getOutputStream();
            IOUtils.copy(is, os);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
