package com.vincent.studentrightsplatform;

import com.vincent.studentrightsplatform.ParamModel.CommentParam;
import com.vincent.studentrightsplatform.ParamModel.ProposalParam;
import com.vincent.studentrightsplatform.RepositoryInterface.CommentRepository;
import com.vincent.studentrightsplatform.RepositoryInterface.ProposalRepository;
import com.vincent.studentrightsplatform.entity.Comment;
import com.vincent.studentrightsplatform.entity.Proposal;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.util.unit.DataSize;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    private ProposalRepository proposalRepository;

    public UploadController() {
    }
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //  单个数据大小
        factory.setMaxFileSize(DataSize.parse("200MB"));
        /// 总上传数据大小
        factory.setMaxRequestSize(DataSize.parse("202MB"));
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
            if(param.getFileName() != null && param.getFileName().length() != 0) {
                String fileExtension = FilenameUtils.getExtension(param.getFileName());
                String fileName = uuid + '.' + fileExtension;
                byte[] b = Utilities.base64Decrypt(param.getAttachmentFile());
                String filePath = System.getProperty("user.dir") + File.separator + "upload" + File.separator + "comment" + File.separator + fileName;
                System.out.println(Utilities.getDateAndTime(System.currentTimeMillis()) + " 附件文件路径: " + filePath + "\n");
                SaveFile(b, filePath);
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
    public String Proposal(@Valid @RequestBody ProposalParam param) {
        String uuid = UUID.randomUUID().toString();
        Proposal proposal = new Proposal();
        proposal.setProposalContent(param.getProposalContent());
        proposal.setProposalTitle(param.getProposalTitle());
        proposal.setUserEmail(param.getUserEmail());
        proposal.setSolution(param.getSolution());
        proposal.setUserName(param.getUserName());
        proposal.setUserContact(param.getUserContact());
        proposal.setUserCollegeAndProfession(param.getUserCollegeAndProfession());
        try {
            if(param.getPhotoName() != null && param.getPhotoName().length() != 0) {
                String photoExtension = FilenameUtils.getExtension(param.getPhotoName());
                String fileName = uuid + '.' + photoExtension;
                byte[] b = Utilities.base64Decrypt(param.getPhoto());
                String photoPath = System.getProperty("user.dir") + File.separator + "upload" + File.separator + "proposal" + File.separator + uuid + File.separator + "photo" + File.separator + fileName;
                System.out.println(Utilities.getDateAndTime(System.currentTimeMillis()) + " 附件图片路径: " + photoPath + "\n");
                SaveFile(b, photoPath);
                proposal.setPhotoPath(photoPath);
            }
            else {
                System.out.println(Utilities.getDateAndTime(System.currentTimeMillis()) + " 本次上传无图片");
                proposal.setPhotoPath("NULL");
            }
            if(param.getDocumentName() != null && param.getDocumentName().length() != 0) {
                String documentExtension = FilenameUtils.getExtension(param.getDocumentName());
                String fileName = uuid + '.' + documentExtension;
                byte[] b = Utilities.base64Decrypt(param.getDocument());
                String documentPath = System.getProperty("user.dir") + File.separator + "upload" + File.separator + "proposal" + File.separator + uuid + File.separator + "document" + File.separator + fileName;
                System.out.println(Utilities.getDateAndTime(System.currentTimeMillis()) + " 附件文档路径: " + documentPath + "\n");
                SaveFile(b, documentPath);
                proposal.setDocumentPath(documentPath);
            }
            else {
                System.out.println(Utilities.getDateAndTime(System.currentTimeMillis()) + " 本次上传无文档");
                proposal.setPhotoPath("NULL");
            }
            proposalRepository.save(proposal);
            return "上传成功";
        } catch (IOException e) {
            e.printStackTrace();
            return "500";
        }
    }

    private void SaveFile(byte[] b, String filePath) throws IOException {
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
    }
}
