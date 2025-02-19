package org.choongang.file.services;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.choongang.file.entities.FileInfo;
import org.choongang.file.exceptions.FileNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor
public class FileDownloadService {
    private final FileInfoService infoService; // 의존성 주입
    private final HttpServletResponse response; // 파일 가져오기 위해 사용

    public void download(Long seq) {
        FileInfo data = infoService.get(seq); // 위의 seq 연동

        String filePath = data.getFilePath(); // 위의 data 연결 -> 2차 가공
        String fileName = new String(data.getFileName().getBytes(), StandardCharsets.ISO_8859_1); // 위의 data 연결 -> 2차 가공 | 2byte 로 연동

        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException();
        }

        String contentType = data.getContentType();
        contentType = StringUtils.hasText(contentType) ? contentType : "application/octet-stream"; // contentType 연결

        try (FileInputStream fis = new FileInputStream(file); // 위의 file 연동
            BufferedInputStream bis = new BufferedInputStream(fis)) {

            response.setHeader("Content-Disposition", "attachment; fileName=" + fileName);
            response.setContentType(contentType); // 위의 contentType 연동
            response.setIntHeader("Expires", 0); // 만료 시간 X
            response.setHeader("Cache-Control", "must-revalidate");
            response.setContentLengthLong(file.length());

            OutputStream out = response.getOutputStream();
            out.write(bis.readAllBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    } // 파일 다운로드 = 응답 헤더로 가능 !
}