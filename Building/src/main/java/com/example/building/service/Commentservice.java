package com.example.building.service;

import com.example.building.exeption.InvalidId;
import com.example.building.model.Comment;
import com.example.building.model.ServiceProvider;
import com.example.building.repository.Commentrepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Commentservice {
    private final Commentrepo commentrepo;




    public List<Comment> getcomment(){
        return commentrepo.findAll();
    }


   public void addcomment(Comment comment){  commentrepo.save(comment); }

    public void deletecomment(Integer cid) {
        Comment comment=commentrepo.findById(cid)
                .orElseThrow(
                        ()->new InvalidId("Invalid id"));
        commentrepo.deleteById(cid);}

}
