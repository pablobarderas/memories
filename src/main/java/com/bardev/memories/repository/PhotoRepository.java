package com.bardev.memories.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bardev.memories.repository.entity.PhotoEntity;

public interface PhotoRepository extends JpaRepository<PhotoEntity, Long> {

}
