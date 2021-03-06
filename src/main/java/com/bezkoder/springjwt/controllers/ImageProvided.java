package com.bezkoder.springjwt.controllers;


import com.bezkoder.springjwt.models.ImageModl;
import com.bezkoder.springjwt.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("ispits-project/image")

public class ImageProvided {
    @Autowired
    private ImageService imageService;

    @PostMapping("/upload/nameData/{nameData}")
    public int uplaodImage( @RequestParam("imageFile") MultipartFile file,@PathVariable String nameData) throws IOException {
        return imageService.uplaodImage(file,nameData);
    }

    @GetMapping(path = { "/get/{imageName}" })
    @PreAuthorize("hasRole('ADMINABSENCE')")
    public ImageModl getImage(@PathVariable("imageName") String imageName) throws IOException {
        return imageService.getImage(imageName);
    }
}
