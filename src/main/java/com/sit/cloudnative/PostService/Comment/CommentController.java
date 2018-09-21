package com.sit.cloudnative.PostService.Comment;

import java.util.List;
import javax.validation.Valid;
import com.sit.cloudnative.PostService.Post.Post;
import com.sit.cloudnative.PostService.Post.PostRepository;
import com.sit.cloudnative.PostService.Post.ResourceNotFoundException;
import com.sit.cloudnative.PostService.User.User;
import com.sit.cloudnative.PostService.User.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {

    @Autowired
    CommentService commentService;

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/comments")
    public ResponseEntity<List<Comment>> getAllComment() {
        List<Comment> allComment = commentService.getAllComment();
        return new ResponseEntity<List<Comment>>(allComment, HttpStatus.OK);
    }

    @PostMapping("/comment/add/postId={post_id}/userId={user_id}")
    public Comment addComment(@PathVariable("post_id") Long post_id, @PathVariable("user_id") Long user_id,
            @Valid @RequestBody Comment comment) {
        Post post = postRepository.findById(post_id)
                .orElseThrow(() -> new ResourceNotFoundException("Post Id: " + post_id + "Not Found"));
        User user = userRepository.findById(user_id)
                .orElseThrow(() -> new ResourceNotFoundException("Post Id: " + post_id + "Not Found"));
        comment.setPost(post);
        comment.setUser(user);
        return commentService.addComment(comment);
    }

    @GetMapping("/comment/{post_id}")
    public List<Comment> getComment(@PathVariable("post_id") Long post_id) {
        return commentService.getComment(post_id);
    }

}