package com.wisom711.repository;

import com.wisom711.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {

    //Lista en base al usuario
    List<PostEntity> findByUserId(Long userId);
    //Lista en base al titulo agregando la posibilidad al buscador
    List<PostEntity> findByTitleContainingIgnoreCase(String title);
}
