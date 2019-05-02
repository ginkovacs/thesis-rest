package hu.unideb.thesis.controller;

import hu.unideb.thesis.fileoperations.Auth;
import hu.unideb.thesis.models.Files;
import hu.unideb.thesis.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

@RestController
@RequestMapping("file")
public class FileUploadController {
    @Autowired
    private FileStorageService fileStorageService;

    @PostMapping("upload")
    public Files uploadFile(@RequestParam("file") MultipartFile file, @RequestParam Boolean isCourse, @RequestParam Integer id)
            throws IOException, GeneralSecurityException {
        if (isCourse) {
            return fileStorageService.storeFileToCourse(file, Auth.getService(), id);
        }

        return fileStorageService.storeFileToQuestion(file, Auth.getService(), id);
    }

    @GetMapping("findAll")
    public ResponseEntity<List<Files>> findAll(@RequestParam Integer courseId) {
        return new ResponseEntity<>(fileStorageService.findAll(courseId), HttpStatus.OK);
    }
}
