package com.example.building.repository;

import com.example.building.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Commentrepo extends JpaRepository<Comment,Integer> {

  List<Comment> findAllByServiceproviderId(Integer spid);
// List<Comment> findCommentsByServiceproviderId(Integer spid);
}
