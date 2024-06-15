package com.bardev.memories.controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhotoDto {
    private Long id;
    private String name;
    private String description;
    private String image;
}
