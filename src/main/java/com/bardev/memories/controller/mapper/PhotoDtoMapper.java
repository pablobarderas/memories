package com.bardev.memories.controller.mapper;

import java.util.Base64;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Component;

import com.bardev.memories.controller.DTO.PhotoDto;
import com.bardev.memories.service.model.Photo;

@Component
public class PhotoDtoMapper {

    // FROM PHOTO TO PHOTO-ENTITY
    public PhotoDto toPhotoDto(Photo photo) {

        PhotoDto photoDto = new PhotoDto();

        if (Objects.isNull(photo)) {
            return photoDto;
        }

        photoDto.setId(photo.getId());
        photoDto.setName(photo.getName());
        photoDto.setDescription(photo.getDescription());
        photoDto.setImage(Base64.getEncoder().encodeToString(photo.getImage()));

        return photoDto;
    }

    // FROM PHOTO TO PHOTO-ENTITY
    public Photo toPhoto(PhotoDto photoDto) {

        Photo photo = new Photo();

        if (Objects.isNull(photoDto)) {
            return photo;
        }

        photo.setId(photoDto.getId());
        photo.setName(photoDto.getName());
        photo.setDescription(photoDto.getDescription());
        photo.setImage(Base64.getDecoder().decode(photoDto.getImage()));

        return photo;
    }

    public List<PhotoDto> toPhotoDtoList(List<Photo> photoList) {
        return photoList.stream().map(this::toPhotoDto).toList();
    }

}
