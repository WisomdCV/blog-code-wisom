package com.wisom711.service;

import com.wisom711.entity.PostEntity;

import java.util.List;
import java.util.Optional;

public interface PostService {
    List<PostEntity> getAllPost();
    Optional<PostEntity> getPostById(Long id);
    List<PostEntity> getPostByUserId(Long userId);
    void createPost(PostEntity post);
    void updatePost(Long id, PostEntity post);
    void deletePost(Long id);
    List<PostEntity> searchPostByTitle(String title);
}
