package com.vincent.studentrightsplatform.RepositoryInterface;

import com.vincent.studentrightsplatform.entity.Comment;
import com.vincent.studentrightsplatform.entity.Proposal;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProposalRepository extends CrudRepository<Proposal, Integer> {
    List<Proposal> findByUserId(String uid);
    List<Proposal> findByUserName(String username);
}
