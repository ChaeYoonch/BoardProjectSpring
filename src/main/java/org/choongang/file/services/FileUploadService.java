package org.choongang.file.services;

import lombok.RequiredArgsConstructor;
import org.choongang.file.entities.FileInfo;
import org.choongang.file.repositories.FileInfoRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Service
@RequiredArgsConstructor // 의존성 주입에 필수!!
public class FileUploadService {

    private final FileInfoRepository fileInfoRepository;

    public void upload(MultipartFile[] files, String gid, String location) {
        /**
         * 1. 파일 정보 저장
         * 2. 파일을 서버로 이동
         * 3. 이미지 이면 썸네일 생성
         * 4. 업로드한 파일 목록 반환
         */

        gid = StringUtils.hasText(gid) ? gid : UUID.randomUUID().toString();

        /* 1. 파일 정보 저장 */ // image.abc.def.png -> 가장 마지막 . 찾아 확장자 확인
        for (MultipartFile file : files) {
            String fileName = file.getOriginalFilename(); // 업로드 파일 원래 이름
            String contentType = file.getContentType(); // 파일 형식
            String extension = fileName.substring(fileName.lastIndexOf(".")); // 확장자 확인

            FileInfo fileInfo = FileInfo.builder() // 위의 String 뒤의 값 연동한 것
                                        .gid(gid)
                                        .location(location)
                                        .fileName(fileName)
                                        .contentType(contentType)
                                        .extension(extension)
                                        .build();

            fileInfoRepository.saveAndFlush(fileInfo); // 위의 fileInfo 에 담은 값들 가져옴
        }
    }
}