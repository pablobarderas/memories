package com.bardev.memories.service.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Photo {

    private Long id;

    private String name;

    private String description;

    private LocalDate date;

    private byte[] image;

}
