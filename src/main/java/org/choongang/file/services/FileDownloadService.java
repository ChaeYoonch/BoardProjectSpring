package org.choongang.file.services;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.choongang.file.entities.FileInfo;
import org.springframework.stereotype.Service;

import java.io.IOException;
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

        try () {

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}