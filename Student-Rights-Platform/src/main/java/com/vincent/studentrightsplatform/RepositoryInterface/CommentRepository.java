package com.vincent.studentrightsplatform.RepositoryInterface;

import com.vincent.studentrightsplatform.entity.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer> {
    List<Comment> findByAttachmentFileName(String filename);
    List<Comment> findByUserId(String uid);
    List<Comment> findByUserName(String username);
}
