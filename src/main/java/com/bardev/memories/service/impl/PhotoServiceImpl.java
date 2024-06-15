package com.bardev.memories.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bardev.memories.repository.PhotoRepository;
import com.bardev.memories.repository.mapper.PhotoEntityMapper;
import com.bardev.memories.service.PhotoService;
import com.bardev.memories.service.model.Photo;

@Service
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    private PhotoRepository photoRepository;

    @Autowired
    private PhotoEntityMapper photoEntityMapper;

    @Override
    public List<Photo> findAll() {
        return photoEntityMapper.toPhotoEntityList(photoRepository.findAll());
    }

    @Override
    public Photo save(Photo photo) {
        return photoEntityMapper.toPhoto(photoRepository.save(photoEntityMapper.toPhotoEntity(photo)));
    }

    @Override
    public void deleteById(Long id) {
        photoRepository.deleteById(id);
    }

}
