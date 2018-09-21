package com.sit.cloudnative.PostService.Comment;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService{
    
    @Autowired
    CommentRepository commentRepository;

    public List<Comment> getComment(Long id){
        return commentRepository.findByPostId(id);
    } 

    public List<Comment> getAllComment(){
        return commentRepository.findAll();
    }

    public Comment addComment(Comment comment){
        return commentRepository.save(comment);
    }
}