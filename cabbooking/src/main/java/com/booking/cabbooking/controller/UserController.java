package com.booking.cabbooking.controller;

import com.booking.cabbooking.domain.exception.CsvValidationException;
import com.booking.cabbooking.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/user")

public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> upload(@RequestPart("file")MultipartFile file){
        try {
            int count = userService.uploadCsv(file);
            return ResponseEntity.ok("Uploaded " + count + " valid records.");
        } catch (CsvValidationException e){
            return ResponseEntity.badRequest().body("CSV Validation failed: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Upload failed" + e.getMessage());
        }
    }
}
