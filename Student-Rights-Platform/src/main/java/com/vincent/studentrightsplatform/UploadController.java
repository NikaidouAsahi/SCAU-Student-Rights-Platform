package com.vincent.studentrightsplatform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.util.unit.DataSize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.MultipartConfigElement;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class UploadController {
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //  单个数据大小
        factory.setMaxFileSize(DataSize.parse("100MB"));
        /// 总上传数据大小
        factory.setMaxRequestSize(DataSize.parse("102MB"));
        return factory.createMultipartConfig();
    }

    @Autowired
    private CommentRepository commentRepository;

    @PostMapping("/upload-comment")
    public String form(HttpServletRequest req,
                       @RequestParam(name = "attachmentFile", required = false) MultipartFile attachmentFile, @RequestParam("commentText") String commentText,
                       @RequestParam("userName") String userName, @RequestParam("userEmail") String userEmail,
                       @RequestParam("userCollege") String userCollege, @RequestParam("userGrade") String userGrade,
                       @RequestParam("userProfession") String userProfession, @RequestParam("userPhoneNumber") String userPhoneNumber) {
        try {
            String uuid = UUID.randomUUID().toString();
            Comment newComment = new Comment();
            newComment.setCommentText(commentText);
            newComment.setUserCollege(userCollege);
            newComment.setUserEmail(userEmail);
            newComment.setUserGrade(userGrade);
            newComment.setUserName(userName);
            newComment.setUserProfession(userProfession);
            newComment.setUserPhoneNumber(userPhoneNumber);
            newComment.setUserId(uuid);
            if(attachmentFile != null && !attachmentFile.isEmpty()) {
                String fileName = System.currentTimeMillis() + attachmentFile.getOriginalFilename();
                byte[] b = attachmentFile.getBytes();
                String destFileName = req.getServletContext().getRealPath("") + "uploaded" + File.separator + fileName;
                System.out.println(Utilities.getDateAndTime(System.currentTimeMillis()) + " 附件文件路径: " + destFileName + "\n");
                File outputFile = new File(destFileName);
                outputFile.getParentFile().mkdirs();
                FileOutputStream fos = new FileOutputStream(outputFile);
                fos.write(b,0,b.length);
                fos.close();
                newComment.setAttachmentFileName(destFileName);
            }
            else {
                System.out.println(Utilities.getDateAndTime(System.currentTimeMillis()) + " 本次上传无附件");
                newComment.setAttachmentFileName("NULL");
            }
            commentRepository.save(newComment);
            return "上传成功";
        } catch (IOException e) {
            e.printStackTrace();
            return "500";
        }
    }
}
