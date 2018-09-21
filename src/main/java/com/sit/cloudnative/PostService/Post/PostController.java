package com.sit.cloudnative.PostService.Post;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
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
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/post/create/{user_id}")
    public Post CreatePost(@PathVariable("user_id") long user_id, @Valid @RequestBody Post post) {
        return userRepository.findById(user_id).map(user -> {
            post.setUser(user);
            return postService.createPost(post);
        }).orElseThrow(() -> new ResourceNotFoundException("user_id: " + user_id + " not found"));
    }

    @GetMapping("/posts")
    public ResponseEntity<List<Post>> getAllPost() {
        List<Post> allPost = postService.getAllPost();
        return new ResponseEntity<List<Post>>(allPost, HttpStatus.OK);
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<Post> getPost(@PathVariable("id") long id) {
        Post post_id = postService.getPost(id);
        return new ResponseEntity<Post>(post_id, HttpStatus.OK);
    }
}