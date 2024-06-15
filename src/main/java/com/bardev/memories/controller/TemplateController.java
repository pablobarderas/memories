package com.bardev.memories.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bardev.memories.controller.DTO.PhotoDto;
import com.bardev.memories.controller.mapper.PhotoDtoMapper;
import com.bardev.memories.service.impl.PhotoServiceImpl;
import com.bardev.memories.service.model.Photo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class TemplateController {

    @Autowired
    private PhotoServiceImpl photoServiceImpl;

    @Autowired
    private PhotoDtoMapper photoDtoMapper;

    @GetMapping("/index")
    public String getIndex() {
        return "index";
    }

    // Upload photo form
    @GetMapping("/upload")
    public String showUploadForm(Model model) {
        model.addAttribute("photo", new Photo());
        return "upload";
    }

    // Delete form
    @GetMapping("/delete")
    public String showDeleteForm(Model model) {
        List<PhotoDto> photos = photoDtoMapper.toPhotoDtoList(photoServiceImpl.findAll());
        model.addAttribute("photos", photos);
        return "delete";
    }

    // DELETE PHOTO BY ID
    @DeleteMapping("/delete")
    public String deletePhoto(@RequestParam("photoId") Long photoId) {
        photoServiceImpl.deleteById(photoId);
        return "redirect:/photos";
    }

    @PostMapping("/upload")
    public String uploadPhoto(@RequestParam("file") MultipartFile file, @ModelAttribute PhotoDto photo)
            throws IOException {

        if (!file.isEmpty()) {
            try {

                // log.info("FILE NAME: " + file.getOriginalFilename());
                // photo.setDate(LocalDate.now());
                photo.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
                // log.info("Name: " + photo.getName() + "Desc: " + photo.getDescription() +
                // "Date: \n" + photo.getDate());

                photoServiceImpl.save(photoDtoMapper.toPhoto(photo));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return "redirect:/photos";
    }

    // Show all photos
    @GetMapping("/photos")
    public String showPhotos(Model model) {

        // Parse Photo List to PhotoDto List
        List<PhotoDto> photoDTOs = photoServiceImpl.findAll().stream()
                .map(photoDtoMapper::toPhotoDto)
                .toList();

        // Send to view
        model.addAttribute("photos", photoDTOs);
        return "photos";
    }

}
