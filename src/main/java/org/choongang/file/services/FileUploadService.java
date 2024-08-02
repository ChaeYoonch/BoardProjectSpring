package org.choongang.file.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Service
@RequiredArgsConstructor // 의존성 주입에 필수!!
public class FileUploadService {

    public void upload(MultipartFile[] files, String gid, String location) {
        /**
         * 1. 파일 정보 저장
         * 2. 파일을 서버로 이동
         * 3. 이미지 이면 썸네일 생성
         * 4. 업로드한 파일 목록 반환
         */

        gid = StringUtils.hasText(gid) ? gid : UUID.randomUUID().toString();
    }
}