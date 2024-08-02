package org.choongang.file.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor // 의존성 주입에 필수!!
public class FileUploadService {

    public void upload(MultipartFile[] files, String gid, String location) {

    }
}