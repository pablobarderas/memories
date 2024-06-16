package com.bardev.memories.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bardev.memories.repository.entity.PhotoEntity;
import java.util.List;

public interface PhotoRepository extends JpaRepository<PhotoEntity, Long> {

    List<PhotoEntity> findBySection(String section);
}
