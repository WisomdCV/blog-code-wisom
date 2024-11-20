package com.wisom711.service;

import com.wisom711.entity.CommentEntity;

import java.util.Optional;

public interface CommentService {
    Optional<CommentEntity> getCommentById(Long id);
    void createComment(CommentEntity comment);
    void updateComment(Long id, CommentEntity comment);
    void deleteComment(Long id);
}
