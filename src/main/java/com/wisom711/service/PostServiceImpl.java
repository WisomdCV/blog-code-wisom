package com.wisom711.service;


import com.wisom711.entity.PostEntity;
import com.wisom711.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<PostEntity> getAllPost() {
        return postRepository.findAll();
    }

    @Override
    public Optional<PostEntity> getPostById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public List<PostEntity> getPostByUserId(Long userId) {
        return postRepository.findByUserId(userId);
    }

    @Override
    public void createPost(PostEntity post) {
        postRepository.save(post);
    }

    @Override
    public void updatePost(Long id, PostEntity post) {
        PostEntity postDB = getPostById(id).orElseThrow(() -> new InvalidParameterException("Invalid post id"));
        //metodo de actualización
        postDB.setTitle(post.getTitle());
        postDB.setContent(post.getContent());
        postRepository.save(postDB);
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public List<PostEntity> searchPostByTitle(String title) {
        return postRepository.findByTitleContainingIgnoreCase(title);
    }
}
