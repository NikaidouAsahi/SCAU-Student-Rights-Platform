package com.vincent.studentrightsplatform;

import com.vincent.studentrightsplatform.ParamModel.CommentParam;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.util.unit.DataSize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.MultipartConfigElement;
import javax.validation.Valid;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class UploadController {

    @Autowired
    private CommentRepository commentRepository;

    public UploadController() {
    }
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //  单个数据大小
        factory.setMaxFileSize(DataSize.parse("100MB"));
        /// 总上传数据大小
        factory.setMaxRequestSize(DataSize.parse("102MB"));
        return factory.createMultipartConfig();
    }
    @PostMapping("/upload-comment")
    public String Comment(@Valid @RequestBody CommentParam param) {
        String uuid = UUID.randomUUID().toString();
        Comment comment = new Comment();
        comment.setCommentText(param.getCommentText());
        comment.setUserCollege(param.getUserCollege());
        comment.setUserEmail(param.getUserEmail());
        comment.setUserGrade(param.getUserGrade());
        comment.setUserName(param.getUserName());
        comment.setUserProfession(param.getUserProfession());
        comment.setUserPhoneNumber(param.getUserPhoneNumber());
        comment.setUserId(uuid);
        try {
            if(param.getAttachmentFile().length() != 0) {
                String fileExtension = FilenameUtils.getExtension(param.getFileName());
                String fileName = uuid + '.' + fileExtension;
                byte[] b = Utilities.base64Decrypt(param.getAttachmentFile());
                String filePath = System.getProperty("user.dir") + File.separator + "upload" + File.separator + "comment" + File.separator + fileName;
                System.out.println(Utilities.getDateAndTime(System.currentTimeMillis()) + " 附件文件路径: " + filePath + "\n");
                File outputFile = new File(filePath);
                if(outputFile.getParentFile().mkdirs()) {
                    System.out.println(Utilities.getDateAndTime(System.currentTimeMillis()) + "创建目录成功\n");
                }
                else {
                    System.out.println(Utilities.getDateAndTime(System.currentTimeMillis()) + "目录已存在\n");
                }
                FileOutputStream fos = new FileOutputStream(outputFile);
                fos.write(b,0,b.length);
                fos.close();
                comment.setAttachmentFileName(filePath);
            }
            else {
                System.out.println(Utilities.getDateAndTime(System.currentTimeMillis()) + " 本次上传无附件");
                comment.setAttachmentFileName("NULL");
            }
            commentRepository.save(comment);
            return "上传成功";
        } catch (IOException e) {
            e.printStackTrace();
            return "500";
        }
    }

    @PostMapping("/upload-proposal")
    public String Proposal(@RequestParam(name = "proposalTitle") String proposalTitle,
                           @RequestParam(name = "userName") String userName,
                           @RequestParam(name = "userCollegeAndProfession") String userCollegeAndProfession,
                           @RequestParam(name = "userId") String userId,
                           @RequestParam(name = "userContact") String userContact,
                           @RequestParam(name = "userEmail") String userEmail,
                           @RequestParam(name = "proposalContent") String proposalContent,
                           @RequestParam(name = "photo") MultipartFile photo,
                           @RequestParam(name = "document") MultipartFile document
                           )
    {
        return "hello";
    }
}
