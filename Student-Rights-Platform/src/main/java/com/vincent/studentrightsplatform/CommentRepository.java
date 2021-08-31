package com.vincent.studentrightsplatform;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer> {
    List<Comment> findByattachmentFileName(String filename);
    List<Comment> findByuserId(String uid);
    List<Comment> findByuserName(String username);
}
