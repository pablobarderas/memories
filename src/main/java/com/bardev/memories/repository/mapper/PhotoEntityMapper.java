package com.bardev.memories.repository.mapper;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Component;

import com.bardev.memories.repository.entity.PhotoEntity;
import com.bardev.memories.service.model.Photo;

@Component
public class PhotoEntityMapper {

    // FROM PHOTO-ENTITY TO PHOTO
    public Photo toPhoto(PhotoEntity photoEntity) {

        Photo photo = new Photo();

        if (Objects.isNull(photoEntity)) {
            return photo;
        }

        photo.setId(photoEntity.getId());
        photo.setName(photoEntity.getName());
        photo.setDescription(photoEntity.getDescription());
        photo.setDate(photoEntity.getDate());
        photo.setImage(photoEntity.getImage());

        return photo;
    }

    // FROM PHOTO TO PHOTO-ENTITY
    public PhotoEntity toPhotoEntity(Photo photo) {

        PhotoEntity photoEntity = new PhotoEntity();

        if (Objects.isNull(photo)) {
            return photoEntity;
        }

        photoEntity.setId(photo.getId());
        photoEntity.setName(photo.getName());
        photoEntity.setDescription(photo.getDescription());
        photoEntity.setDate(photo.getDate());
        photoEntity.setImage(photo.getImage());

        return photoEntity;
    }

    // FROM List<PHOTO-ENTITY> TO List<PHOTO>
    public List<Photo> toPhotoEntityList(List<PhotoEntity> photoEntityList) {
        return photoEntityList.stream().map(this::toPhoto).toList();
    }

}
