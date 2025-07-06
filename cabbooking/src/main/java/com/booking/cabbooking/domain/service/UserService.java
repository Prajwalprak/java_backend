package com.booking.cabbooking.domain.service;

import org.springframework.web.multipart.MultipartFile;

public interface UserService {
    public int uploadCsv(MultipartFile file);
}
