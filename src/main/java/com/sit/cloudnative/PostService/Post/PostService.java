package com.sit.cloudnative.PostService.Post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    public List<Post> getAllPost() {
        List<Post> posts = postRepository.findAll();
        return posts;
    }

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public Post getPost(Long id) {
        return postRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("This id: "+ id + "Not found"));
    }
}