package com.bardev.memories.service;

import java.util.List;

import com.bardev.memories.service.model.Photo;;

public interface PhotoService {

    public List<Photo> findAll();

    public Photo save(Photo photo);

    public void deleteById(Long id);

    public List<Photo> findBySection(String section);

}
